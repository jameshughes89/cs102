import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedStack<T> implements Stack<T> {

    private Node<T> top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    @Override
    public boolean push(T element) {
        Node<T> toPush = new Node<T>(element);
        toPush.setNext(top);
        top = toPush;
        size++;
        return true;
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
            throw new NoSuchElementException("Peeking from an empty stack.");
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LinkedStack<?> that = (LinkedStack<?>) o;
        if (this.size == that.size) {
            Node<?> thisCurrent = this.top;
            Node<?> thatCurrent = that.top;
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
        Node<?> current = top;
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
     * LinkedStack.
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
