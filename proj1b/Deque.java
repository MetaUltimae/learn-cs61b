/**
 *
 * @author 33465
 * @created 2026/10/22 22:02
 * @desciption
 *
 */

public interface Deque<T> {
    void addFirst(T item);
    void addLast(T item);
    boolean isEmpty();
    int size();
    void printDeque();
    T removeFirst();
    T removeLast();
    T get(int index);
}
