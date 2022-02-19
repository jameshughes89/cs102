import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T> {

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
        // rear will wrap back to 0 if it is more than
        // the capacity of the array
        rear = (rear + 1) % queue.length;
        size++;
    }

    /**
     * Doubles the size of the queue array and copy the
     * contents over.
     * <p>
     * Mind where we copy from the original queue and
     * the updates to front and rear
     */
    @SuppressWarnings("unchecked")
    private void expandCapacity() {
        T[] newQueue = (T[]) new Object[queue.length * 2];
        for (int i = 0; i < queue.length; ++i) {
            newQueue[i] = queue[front];
            front = (front + 1) % queue.length;
        }
        front = 0;
        rear = size;
        queue = newQueue;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Dequeueing from an empty queue.");
        }
        T returnElement = queue[front];
        // front will wrap back to 0 if it is more than
        // the capacity of the array
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

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayQueue<?> that = (ArrayQueue<?>) o;
        if (this.size != that.size) return false;
        for (int i = 0; i < this.size; i++) {
            if (!this.queue[(this.front + i) % this.queue.length].equals(that.queue[(that.front + i) % that.queue.length])) {
                return false;
            }
        }
        return true;
    }
}
