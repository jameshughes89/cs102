import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedQueue<T> implements Queue<T> {

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public boolean enqueue(T element) {
        Node<T> toEnqueue = new Node<>(element);

        // If nothing is in the queue, then the front is null
        // and the enqueued element will become the front,
        // otherwise, the enqueued element is added after the
        // current rear.
        if (isEmpty()) {
            front = toEnqueue;
        } else {
            rear.setNext(toEnqueue);
        }
        // Either way, the rear of the queue will be the newly
        // enqueued element.
        rear = toEnqueue;
        size++;
        return true;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Dequeueing from an empty queue.");
        }
        T returnElement = front.getData();
        front = front.getNext();
        size--;
        // Although front will update properly regardless, rear
        // should be set to null if we dequeue the last element
        if (isEmpty()) {
            rear = null;
        }
        return returnElement;
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new NoSuchElementException("First from an empty queue.");
        }
        return front.getData();
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
        Node<T> currentNode = front;
        while (currentNode != null) {
            builder.append(currentNode.getData());
            builder.append(", ");
            currentNode = currentNode.getNext();
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LinkedQueue<?> that = (LinkedQueue<?>) o;
        if (this.size == that.size) {
            Node<?> thisCurrent = this.front;
            Node<?> thatCurrent = that.front;
            while (thisCurrent != null) {
                if (!thisCurrent.data.equals(thatCurrent.data)) {
                    return false;
                }
                thisCurrent = thisCurrent.getNext();
                thatCurrent = thatCurrent.getNext();
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(size);
        Node<?> current = front;
        while (current != null) {
            result = result * 97 + Objects.hashCode(current.getData());
            current = current.getNext();
        }
        return result;
    }

    /**
     * A Node class for a singly linked structure. Each node
     * contains a reference to data of type T, which may be
     * null, and a reference to the next/subsequent/successor
     * singly linked node, which may also be null.
     * <p>
     * This class is a static nested class since the node
     * class is only needed for the implementation of the
     * LinkedQueue.
     *
     * @param <T> Type of the data being stored in the node
     */
    private static class Node<T> {

        private T data;
        private Node<T> next;

        public Node() {
            this(null);
        }

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
