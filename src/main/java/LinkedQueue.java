import java.util.NoSuchElementException;

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
    public void enqueue(T element) {
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

    /**
     * A Node class for a singly linked structure. Each node
     * contains a reference to data of type T, which may be
     * null, and a reference to the next/subsequent/successor
     * singly linked node, which may also be null.
     *
     * This class is a static nested class since the node
     * class is only needed for the implementation of the
     * LinkedQueue.
     *
     * @param <T>   Type of the data being stored in the node
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
