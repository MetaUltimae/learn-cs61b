package synthesizer;

/**
 *
 * @author 33465
 * @created 2026/10/28 22:20
 * @desciption
 *
 */
public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    protected int fillCount;
    protected int capacity;

    public int fillCount() {
        return fillCount;
    }

    public int capacity() {
        return capacity;
    }
}
   