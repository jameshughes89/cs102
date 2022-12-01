import java.util.Objects;

/**
 * Implementation of a queue with a linked structure as the container. The class contains a static inner class defining
 * a node for the linked structure.
 *
 * @param <T> Type of elements that are to be in the queue.
 */
public class LinkedQueue<T> implements Queue<T> {

    private Node<T> front;
    private Node<T> rear;
    private int size;

    /**
     * Create an empty LinkedQueue.
     */
    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public boolean enqueue(T element) {
        Node<T> toEnqueue = new Node<>(element);

        // If nothing is in the queue, then the front is null and the enqueued element will become the front. If the
        // queue is not empty, the enqueued element is added after the current rear.
        if (isEmpty()) {
            front = toEnqueue;
        } else {
            rear.setNext(toEnqueue);
        }
        // Either way, the rear of the queue will be the newly enqueued element.
        rear = toEnqueue;
        size++;
        return true;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        T returnElement = front.getData();
        front = front.getNext();
        size--;
        // The front will update correctly regardless. The rear must be set to null if the queue is now empty.
        if (isEmpty()) {
            rear = null;
        }
        return returnElement;
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        return front.getData();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
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
        if (this.size != that.size) {
            return false;
        }
        Node<?> thisCurrent = this.front;
        Node<?> thatCurrent = that.front;
        while (thisCurrent != null && thatCurrent != null) {
            if (!Objects.equals(thisCurrent.getData(), thatCurrent.getData())) {
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
        Node<?> current = front;
        while (current != null) {
            result = result * 97 + Objects.hashCode(current.getData());
            current = current.getNext();
        }
        return result;
    }

    /**
     * A Node class for a singly linked structure. Each node contains a nullable reference to data of type T, and a
     * reference to the next/subsequent/successor singly linked node, which may be a null reference.
     *
     * @param <T> Type of the data being stored in the node.
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
