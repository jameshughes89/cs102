public class ArrayQueue<T> implements Queue<T>{

    private static final int DEFAULT_CAPACITY = 100;
    private T[] queue;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int initialCapacity) {
        front = 0;
        rear = 0;
        size = 0;

        stack = (T[]) new Object[initialCapacity];
    }

    @Override
    public void enqueue(T element) {

    }

    /**
     * Doubles the size of the queue array and copy the
     * contents over.
     */
    @SuppressWarnings("unchecked")
    private void expandCapacity() {
        T[] newStack = (T[]) new Object[queue.length * 2];
        for (int i = 0; i < queue.length; ++i) {
            newStack[i] = queue[i];
        }
        queue = newStack;

    }

    @Override
    public T dequeue() {
        return null;
    }

    @Override
    public T first() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    public String toString() {

    }
}
