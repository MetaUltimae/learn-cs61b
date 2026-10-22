/**
 *
 * @author 33465
 * @created 2026/10/18 10:01
 * @desciption
 *
 */
public class ArrayDeque<T> implements Deque<T> {
    private T[] arr;
    private int size;
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public ArrayDeque() {
        this.arr = (T[]) new Object[8];
        this.head = this.tail = 0;
        this.size = 0;
    }

    private void checkArrayAndUpdate() {
        if (size < arr.length / 4 && arr.length >= 16) {
            updateArray(Math.max(arr.length / 2, 8));
        }
        if (size == arr.length) {
            updateArray(arr.length * 2);
        }
    }

    @SuppressWarnings("unchecked")
    private void updateArray(int bound) {
        T[] newArr = (T[]) new Object[bound];
        if (head + size > arr.length) {
            System.arraycopy(arr, head, newArr, 0, arr.length - head);
            System.arraycopy(arr, 0, newArr, arr.length - head, tail);
        } else {
            System.arraycopy(arr, head, newArr, 0, size);
        }
        arr = newArr;
        head = 0;
        tail = size;
    }

    @Override
    public void addFirst(T item) {
        checkArrayAndUpdate();
        if (head == 0) {
            head = arr.length - 1;
        } else {
            head--;
        }
        arr[head] = item;
        size++;
    }

    @Override
    public void addLast(T item) {
        checkArrayAndUpdate();
        arr[tail] = item;
        if (tail == arr.length - 1) {
            tail = 0;
        } else {
            tail++;
        }
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        if (size == 0) {
            return;
        }
        if (head + size > arr.length) {
            for (int i = head; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            for (int i = 0; i < tail; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            int range = tail;
            if (range == 0) {
                range = arr.length;
            }
            for (int i = head; i < range; i++) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T item = arr[head];
        if (head == arr.length - 1) {
            head = 0;
        } else {
            head++;
        }
        size--;
        checkArrayAndUpdate();
        return item;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (tail == 0) {
            tail = arr.length - 1;
        } else {
            tail--;
        }
        T item = arr[tail];
        size--;
        checkArrayAndUpdate();
        return item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        if (index + head < arr.length) {
            return arr[index + head];
        }
        return arr[index + head - arr.length];
    }
}
