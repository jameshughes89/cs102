import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T>{

    private static final int DEFAULT_CAPACITY = 100;
    private T[] queue;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayQueue(int initialCapacity) {
        front = 0;
        rear = 0;
        size = 0;
        queue = (T[]) new Object[initialCapacity];
    }

    @Override
    public void enqueue(T element) {
        if (size == queue.length) {
            expandCapacity();
        }
        queue[rear] = element;
        // rear will wrap back to 0 if it is bigger than
        // the capacity of the array
        rear = (rear + 1) % queue.length;
        size++;
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
        if (isEmpty()) {
            throw new NoSuchElementException("Dequeueing from an empty queue.");
        }
        T returnElement = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return returnElement;
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new NoSuchElementException("First from an empty queue.");
        }
        return queue[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Front --> ");
        int currentIndex = front;
        for (int i = 0; i < size; ++i) {
            builder.append(queue[currentIndex]);
            builder.append(", ");
            currentIndex = (currentIndex + 1) % queue.length;
        }
        return builder.toString();
    }
}
