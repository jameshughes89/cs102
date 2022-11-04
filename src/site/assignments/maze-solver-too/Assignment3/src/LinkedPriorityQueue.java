import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedPriorityQueue<T> implements PriorityQueue<T> {

    private PriorityNode front;
    private int size;


    /**
     * Two LinkedPriorityQueues are considered equal if all elements/data in the two
     * queues are considered equal, along with their corresponding priorities.
     *
     * @param o That thing to check if this is equal to
     * @return If they be equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedPriorityQueue<?> that = (LinkedPriorityQueue<?>) o;
        if (this.size != that.size) return false;
        LinkedPriorityQueue<?>.PriorityNode thisCurrent = this.front;
        LinkedPriorityQueue<?>.PriorityNode thatCurrent = that.front;
        while (thisCurrent != null) {
            if (thisCurrent.getPriority() != thatCurrent.getPriority()
                    || !thisCurrent.getData().equals(thatCurrent.getData())) return false;
            thisCurrent = thisCurrent.getNext();
            thatCurrent = thatCurrent.getNext();
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(size);
        PriorityNode current = front;
        while (current != null) {
            result = result * 97 + Objects.hash(current.getPriority(), current.getData());
            current = current.getNext();
        }
        return result;
    }

    private class PriorityNode {

        private final T data;
        private final int priority;
        private PriorityNode next;

        public PriorityNode(T data, int priority, PriorityNode next) {
            this.data = data;
            this.priority = priority;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public int getPriority() {
            return priority;
        }

        public PriorityNode getNext() {
            return next;
        }

        public void setNext(PriorityNode next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "(p:" + String.valueOf(priority) +
                    ", d:" + data.toString() + ")";
        }
    }
}