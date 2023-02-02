/**
 * A node class for a singly linked structure. Each node contains a nullable reference to data of type T, and a
 * reference to the next/subsequent/successor singly linked node, which may be a null reference.
 *
 * @param <T> Type of the data being stored in the node.
 */
public class Node<T> {

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
