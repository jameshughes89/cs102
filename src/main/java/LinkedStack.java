import java.util.Objects;

/**
 * Implementation of a stack with a linked structure as the container. The class contains a static inner class defining
 * a node for the linked structure.
 *
 * @param <T> Type of elements that are to be in the stack.
 */
public class LinkedStack<T> implements Stack<T> {

    private Node<T> top;
    private int size;

    /**
     * Create an empty LinkedStack.
     */
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
            throw new EmptyCollectionException();
        }
        T returnElement = top.getData();
        top = top.getNext();
        size--;
        return returnElement;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        return top.getData();
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
        Node<T> currentNode = top;
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
        LinkedStack<?> that = (LinkedStack<?>) o;
        if (this.size() != that.size()) {
            return false;
        }
        Node<?> thisCurrent = this.top;
        Node<?> thatCurrent = that.top;
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
        Node<?> current = top;
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
