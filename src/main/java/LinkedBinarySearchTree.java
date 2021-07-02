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

    public void add(T element) {
        if (isEmpty()) {
            root = new Node<>(element);
        } else {
            add(element, root);
        }
        size++;
    }

    /**
     * An internal add method for enabling recursive add.
     *
     * @param element
     * @param current
     */
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

    public boolean contains(T element) {
        return binarySearch(element, root);
    }

    /**
     * TODO
     *
     * @param element
     * @param current
     * @return
     */
    private boolean binarySearch(T element, Node<T> current) {
        if (current == null) {
            return false;
        } else if (current.getData().equals(element)) {
            return true;
        } else {
            if (current.getData().compareTo(element) > 0) {
                return binarySearch(element, current.getLeft());
            } else {
                return binarySearch(element, current.getRight());
            }
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

