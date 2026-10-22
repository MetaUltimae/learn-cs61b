/**
 *
 * @author 33465
 * @created 2026/10/18 10:00
 * @desciption
 *
 */
public class LinkedListDeque<T> implements Deque<T>{
    private final Node<T> sentinel;
    private int size;

    public LinkedListDeque(){
        this.sentinel = new Node<T>(null,null,null);
        this.sentinel.pre = this.sentinel.next = this.sentinel;
        size = 0;
    }

    private static class Node<T>{
        T item;
        Node<T> pre;
        Node<T> next;

        Node(T item,Node pre,Node next){
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    @Override
    public void addFirst(T item){
        Node<T> N = new Node<>(item, sentinel, sentinel.next);
        sentinel.next.pre = N;
        sentinel.next = N;
        size++;
    }

    @Override
    public void addLast(T item){
        Node<T> N = new Node<>(item, sentinel.pre, sentinel);
        sentinel.pre.next = N;
        sentinel.pre = N;
        size++;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void printDeque(){
        Node<T> p = sentinel;
        while (p.next != sentinel){
            p = p.next;
            System.out.print(p.item + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst(){
        if (sentinel.next == sentinel)
            return null;
        Node<T> first = sentinel.next;
        first.next.pre = sentinel;
        sentinel.next = first.next;
        size--;
        return first.item;
    }

    @Override
    public T removeLast(){
        if (sentinel.pre == sentinel)
            return null;
        Node<T> last = sentinel.pre;
        last.pre.next = sentinel;
        sentinel.pre = last.pre;
        size--;
        return last.item;
    }

    @Override
    public T get(int index){
        if (index < 0 || index >= size)
            return null;
        Node<T> p;
        if (index < size / 2){
            p = sentinel.next;
            while (index != 0){
                index--;
                p = p.next;
            }
        }
        else{
            p = sentinel.pre;
            while (index != size -1){
                index++;
                p = p.pre;
            }
        }
        return p.item;
    }

    public T getRecursive(int index){
        if (index < 0 || index >= size)
            return null;
        if (index < size / 2)
            return getNode(index,sentinel.next,true).item;
        else
            return getNode(size - index - 1,sentinel.pre,false).item;

    }

    private Node<T> getNode(int step,Node<T> node,boolean isFront){
        if (step == 0)
            return node;
        if (isFront)
            return getNode(step - 1,node.next,true);
        return getNode(step - 1,node.pre,false);
    }
}




















