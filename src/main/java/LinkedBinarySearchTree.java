import java.util.NoSuchElementException;

public class LinkedBinarySearchTree<T extends Comparable<? super T>> implements BinarySearchTree<T> {

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
     * Helper add method for enabling recursive add.
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

    public T removeMin() {
        T returnElement = null;
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (root.getLeft() == null) {
            returnElement = root.getData();
            root = root.getRight();
        } else {
            Node<T> parent = root;
            Node<T> leftChild = root.getLeft();
            // Iterate left until we find the left most node
            while (leftChild.getLeft() != null) {
                parent = leftChild;
                leftChild = leftChild.getLeft();
            }
            returnElement = leftChild.getData();
            parent.setLeft(leftChild.getRight());
        }
        size--;
        return returnElement;
    }

    public T removeMax() {
        T returnElement = null;
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (root.getRight() == null) {
            returnElement = root.getData();
            root = root.getLeft();
        } else {
            Node<T> parent = root;
            Node<T> rightChild = root.getRight();
            // Iterate right until we find the right most node
            while (rightChild.getRight() != null) {
                parent = rightChild;
                rightChild = rightChild.getRight();
            }
            returnElement = rightChild.getData();
            parent.setRight(rightChild.getLeft());
        }
        size--;
        return returnElement;
    }

    @Override
    public T min() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return min(root);
    }

    /**
     * Helper method for enabling a recursive search for the minimum element
     * in the binary search tree.
     *
     * @param current Current node being looked at
     * @return The minimum element in the tree
     */
    private T min(Node<T> current) {
        if (current.getLeft() == null) {
            return current.getData();
        } else {
            return min(current.getLeft());
        }
    }

    @Override
    public T max() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return max(root);
    }

    /**
     * Helper method for enabling a recursive search for the maximum element
     * in the binary search tree.
     *
     * @param current Current node being looked at
     * @return The maximum element in the tree
     */
    private T max(Node<T> current) {
        if (current.getRight() == null) {
            return current.getData();
        } else {
            return min(current.getRight());
        }
    }

    public boolean contains(T element) {
        return binarySearch(element, root);
    }

    /**
     * Helper method enabling a recursive binary search for a given element.
     *
     * @param element Element being searched for
     * @param current Current binary search tree node being investigated
     * @return True if the element is found, false otherwise
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

