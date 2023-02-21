import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Linked Priority Queue. This implementation will:
 * 1. Do the linear search on the enqueue; constant time dequeue
 * 2. Ties in priority are added after all equal priorities.
 *
 * @param <T> Type of elements in the priority queue.
 */
public class LinkedPriorityQueue<T> implements PriorityQueue<T> {

    /**
     * Two LinkedPriorityQueues are considered equal if all elements/data in the two queues are considered equal, along
     * with their corresponding priorities.
     *
     * @param o The thing to check if this is equal to
     * @return True if they are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LinkedPriorityQueue<?> that = (LinkedPriorityQueue<?>) o;
        if (this.size != that.size) {
            return false;
        }
        PriorityNode<T> thisCurrent = (PriorityNode<T>) this.front;
        PriorityNode<T> thatCurrent = (PriorityNode<T>) that.front;
        while (thisCurrent != null) {
            if (thisCurrent.getPriority() != thatCurrent.getPriority() ||
                    !thisCurrent.getData().equals(thatCurrent.getData())) {
                return false;
            }
            thisCurrent = thisCurrent.getNext();
            thatCurrent = thatCurrent.getNext();
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(size);
        PriorityNode<T> current = front;
        while (current != null) {
            result = result * 97 + Objects.hash(current.getPriority(), current.getData());
            current = current.getNext();
        }
        return result;
    }

    private static class PriorityNode<T> {

        private final T data;
        private final int priority;
        private PriorityNode<T> next;

        private PriorityNode(T data, int priority, PriorityNode<T> next) {
            this.data = data;
            this.priority = priority;
            this.next = next;
        }

        private T getData() {
            return data;
        }

        private int getPriority() {
            return priority;
        }

        private PriorityNode<T> getNext() {
            return next;
        }

        private void setNext(PriorityNode<T> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "(p:" + String.valueOf(priority) + ", d:" + data.toString() + ")";
        }
    }
}