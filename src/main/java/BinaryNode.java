/**
 * A BinaryNode class for a binary linked tree structure. Each
 * BinaryNode contains a reference to data of type T, which
 * may be null, and a reference to the left and right child
 * binary linked BinaryNodes, which may also be null.
 * <p>
 * This class is a static nested class since the BinaryNode
 * class is only needed for the implementation of the
 * LinkedBinarySearchTree.
 *
 * @param <T> Type of the data being stored in the BinaryNode
 */
public class BinaryNode<T> {

    private T data;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    private BinaryNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    private T getData() {
        return data;
    }

    private void setData(T data) {
        this.data = data;
    }

    private BinaryNode<T> getLeft() {
        return left;
    }

    private void setLeft(BinaryNode<T> left) {
        this.left = left;
    }

    private BinaryNode<T> getRight() {
        return right;
    }

    private void setRight(BinaryNode<T> right) {
        this.right = right;
    }
}