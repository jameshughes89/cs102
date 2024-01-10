/**
 * A node class for a linked binary tree structure. Each node contains a nullable reference to data of type T, and a
 * reference to the left and right child nodes, which may be null references.
 *
 * @param <T> Type of the data being stored in the node
 */
public class BinaryNode<T> {

    private T data;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    public BinaryNode() {
        this(null);
    }

    public BinaryNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }

    public BinaryNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }
}