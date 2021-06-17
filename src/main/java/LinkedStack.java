import java.util.NoSuchElementException;

public class LinkedStack<T> implements Stack<T> {

    private Node<T> top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    @Override
    public void push(T element) {
        Node<T> toPush = new Node<T>(element);
        toPush.setNext(top);
        top = toPush;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Popping from an empty stack.");
        }
        T returnElement = top.getData();
        top = top.getNext();
        size--;
        return returnElement;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Popping from an empty stack.");
        }
        return top.getData();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(", ");
        Node<T> currentNode = top;
        while (currentNode != null) {
            builder.insert(0, currentNode.getData());
            builder.insert(0, ", ");
            currentNode = currentNode.getNext();
        }
        builder.delete(0, 2);
        builder.append("<-- Top");
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
     * LinkedStack.
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
