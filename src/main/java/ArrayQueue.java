import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Implementation of a queue with an array as the container. The array container will automatically "grow" to
 * accommodate adding beyond the initial capacity.
 *
 * @param <T> Type of elements that are to be in the queue
 */
public class ArrayQueue<T> implements Queue<T> {

    private static final int DEFAULT_CAPACITY = 100;
    private T[] queue;
    private int front;
    private int rear;
    private int size;

    /**
     * Create an empty ArrayQueue of the default capacity.
     */
    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Create an empty ArrayQueue with the specified capacity.
     *
     * @param initialCapacity Starting capacity of the fixed length array
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int initialCapacity) {
        front = 0;
        rear = 0;
        size = 0;
        queue = (T[]) new Object[initialCapacity];
    }

    // [start-enqueue]
    @Override
    public boolean enqueue(T element) {
        if (size == queue.length) {
            queue = expandCapacity(queue);
        }
        queue[rear] = element;
        rear = nextIndex(rear);
        size++;
        return true;
    }
    // [end-enqueue]

    // [start-expandCapacity]

    /**
     * Returns a new array with double the size of the queue array container and copy the contents from the old array to
     * the new array. Note that the elements are copied to the beginning (index 0) of the new array and the front and
     * rear fields are updated.
     */
    @SuppressWarnings("unchecked")
    private T[] expandCapacity(T[] oldQueue) {
        T[] newQueue = (T[]) new Object[oldQueue.length * 2];
        for (int i = 0; i < oldQueue.length; i++) {
            newQueue[i] = oldQueue[front];
            front = nextIndex(front);
        }
        front = 0;
        rear = size();
        return newQueue;
    }
    // [end-expandCapacity]

    // [start-dequeue]
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty queue");
        }
        T returnElement = queue[front];
        front = nextIndex(front);
        size--;
        return returnElement;
    }
    // [end-dequeue]

    @Override
    public T first() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty queue");
        }
        return queue[front];
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    // [start-nextIndex]

    /**
     * Calculates the next valid index for the front or rear fields. This method is used to have the index increment
     * with an automatic wrapping back to index zero if there is no more room left at the end of the array.
     *
     * @param currentIndex Index to find next index of
     * @return Wrapping next index
     */
    private int nextIndex(int currentIndex) {
        return (currentIndex + 1) % queue.length;
    }
    // [end-nextIndex]

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int currentIndex = front;
        for (int i = 0; i < size(); i++) {
            builder.append(queue[currentIndex]);
            builder.append(", ");
            currentIndex = nextIndex(currentIndex);
        }
        return builder.toString();
    }

    // [start-equals]
    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArrayQueue<?> that = (ArrayQueue<?>) o;
        if (this.size() != that.size()) {
            return false;
        }
        int thisCurrentIndex = this.front;
        int thatCurrentIndex = that.front;
        // Since this and that are the same size, this.size() can be used safely in the for loop
        for (int i = 0; i < this.size(); i++) {
            if (!Objects.equals(this.queue[thisCurrentIndex], that.queue[thatCurrentIndex])) {
                return false;
            }
            thisCurrentIndex = this.nextIndex(thisCurrentIndex);
            thatCurrentIndex = that.nextIndex(thatCurrentIndex);
        }
        return true;
    }
    // [end-equals]

    @Override
    public int hashCode() {
        int result = Objects.hashCode(size);
        int currentIndex = front;
        for (int i = 0; i < size(); i++) {
            result = result * 97 + Objects.hashCode(queue[currentIndex]);
            currentIndex = nextIndex(currentIndex);
        }
        return result;
    }
}
