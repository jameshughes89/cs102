public class LinkedBinarySearchTree<T extends Comparable<? super T>> extends BinarySearchTree<T> {

    private int size;
    private Node<T> root;

    public LinkedBinarySearchTree() {
        this(null);
    }

    public LinkedBinarySearchTree(T element) {
        root = new Node<>(element);
        size = 0;
    }

    private void add(T element, Node<T> current) {
        if (current.getData().compareTo(element) > 0) {
            if (current.getLeft() == null) {
                current.setLeft(new Node<>(element));
            } else {
                add(element, current.getLeft());
            }
        } else {
            if (current.getRight() == null) {
                current.setRight(new Node<>(element));
            } else {
                add(element, current.getRight());
            }
        }
    }

    public void add(T element) {
        if (isEmpty()) {
            root = new Node<>(element);
        } else {
            add(element, root);
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    /**
     * A Node class for a binary linked tree structure. Each node
     * contains a reference to data of type T, which may be
     * null, and a reference to the left and right child
     * binary linked nodes, which may also be null.
     * <p>
     * This class is a static nested class since the node
     * class is only needed for the implementation of the
     * LinkedBinarySearchTree.
     *
     * @param <T> Type of the data being stored in the node
     */
    private static class Node<T> {

        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node() {
            this(null);
        }

        public Node(T data) {
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

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> left) {
            this.right = right;
        }
    }
}

