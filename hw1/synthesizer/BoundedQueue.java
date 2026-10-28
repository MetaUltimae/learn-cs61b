package synthesizer;

/**
 *
 * @author 33465
 * @created 2026/10/28 22:06
 * @desciption
 *
 */
public interface BoundedQueue<T> extends Iterable<T>{
    int capacity();     // return size of the buffer
    int fillCount();    // return number of items currently
    void enqueue(T x);  // add item x to the end
    T dequeue();        // delete and return item from the front
    T peek();           // return (but do not delete) item from the front

    /**
     * @return is the buffer empty
     */
    default boolean isEmpty() {
        return fillCount() == 0;
    }

    /**
     * @return is the buffer full
     */
    default boolean isFull() {
        return fillCount() == capacity();
    }
}
   