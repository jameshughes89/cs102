import java.util.NoSuchElementException;
import java.util.Objects;

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
        rear = nextIndex(rear);
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
            front = nextIndex(front);
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
        front = nextIndex(front);
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

    /**
     * Calculates the next valid index. This method is used to have the index
     * increment with an automatic wrapping back to index zero if there is no
     * more room left at the end of the array.
     *
     * @param currentIndex Index to find next index of
     * @return Wrapping next index
     */
    private int nextIndex(int currentIndex) {
        return (currentIndex + 1) % queue.length;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Front --> ");
        int currentIndex = front;
        for (int i = 0; i < size; ++i) {
            builder.append(queue[currentIndex]);
            builder.append(", ");
            currentIndex = nextIndex(currentIndex);
        }
        return builder.toString();
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayQueue<?> that = (ArrayQueue<?>) o;
        if (this.size != that.size) return false;
        int thisCurrentIndex = this.front;
        int thatCurrentIndex = that.front;
        for (int i = 0; i < this.size; i++) {
            if (!this.queue[thisCurrentIndex].equals(that.queue[thatCurrentIndex])) {
                return false;
            }
            thisCurrentIndex = this.nextIndex(thisCurrentIndex);
            thatCurrentIndex = that.nextIndex(thatCurrentIndex);
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(size);
        for (int i = 0; i < size; i++) {
            result += Objects.hashCode(queue[(front + 1) % queue.length]);
        }
        return result;
    }
}
