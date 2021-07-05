import java.util.Iterator;
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

    public T remove(T element) {
        T returnElement = null;
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (root.getData().equals(element)) {
            returnElement = root.getData();
            root = findReplacementNode(root);
        } else if (root.getData().compareTo(element) > 0) {
            returnElement = remove(element, root, root.getLeft());
        } else {
            returnElement = remove(element, root, root.getRight());
        }
        size--;
        return returnElement;
    }

    private T remove(T element, Node<T> parent, Node<T> child) {
        if (child == null) {
            throw new NoSuchElementException();
        } else if (child.getData().equals(element)) {
            parent.setLeft(findReplacementNode(child));
            return child.getData();
        } else if (child.getData().compareTo(element) > 0) {
            return remove(element, child, child.getLeft());
        } else {
            return remove(element, child, child.getRight());
        }
    }

    /**
     * Helper method for finding which node should be used to replace a node being removed.
     * There are a few conditions:
     * <p>
     * 1. Both left and right children are null. Here, simply remove the node.
     * <p>
     * 2. Left child is not null but right child is null. Replace the toRemove node with the left child.
     * <p>
     * 3. Left child is null but right child is not null. Replace the toRemove node with the right child
     * <p>
     * 4. Both left and right children are not null. Replace the toRemove node with the in order successor,
     * which would be the right subtree's left most node.
     *
     * @param toRemove The node being replaced
     * @return The node replacing the node being removed
     */
    private Node<T> findReplacementNode(Node<T> toRemove) {
        Node<T> replacementNode = null;
        if (toRemove.getLeft() == null && toRemove.getRight() == null) {
            replacementNode = null;
        } else if (toRemove.getLeft() != null && toRemove.getRight() == null) {
            replacementNode = toRemove.getLeft();
        } else if (toRemove.getLeft() == null && toRemove.getRight() != null) {
            replacementNode = toRemove.getRight();
        } else {
            Node<T> parent = toRemove;
            Node<T> child = toRemove.getRight();
            // Find the in order successor (right child's left
            // most node (minimum node))
            while (child.getLeft() != null) {
                parent = child;
                child = child.getLeft();
            }
            // Set replacement node's left to
            // the node being removed's (subtree root's) left
            child.setLeft(toRemove.getLeft());
            // If the immediate in order successor is NOT the
            // node being replaced's right child, the parent
            // node's new left becomes the child node's right
            // and the child node's right is replaced with
            // the node being replaced's right
            if (toRemove.getRight() != child) {
                parent.setLeft(child.getRight());
                toRemove.setRight(toRemove.getRight());
            }
            replacementNode = child;
        }
        return replacementNode;
    }

    public T removeMin() {
        T returnElement = null;
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (root.getLeft() == null) {
            returnElement = root.getData();
            root = root.getRight();
        } else {
            returnElement = removeMin(root, root.getLeft());
        }
        size--;
        return returnElement;
    }

    /**
     * Helper method for a recursive removeMin. Note, it is possible
     * to not include the leftChild parameter since current.getLeft
     * will always be equal to leftChild, however it is included for
     * making the implementation more clear.
     *
     * @param current   Current node
     * @param leftChild Current node's left child
     * @return Minimum element in the binary search tree
     */
    private T removeMin(Node<T> current, Node<T> leftChild) {
        if (leftChild.getLeft() == null) {
            current.setLeft(leftChild.getRight());
            return leftChild.getData();
        } else {
            return removeMin(current.getLeft(), leftChild.getLeft());
        }
    }

    /**
     * An iterative implementation of finding the maximum element in
     * a binary serach tree. This method could be a recursive one
     * like removeMin, however the iterative one is included to see
     * multiple implementations.
     *
     * @return The maximum element in the binary search tree
     */
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
     * Recursive pre order traversal of a binary tree. Elements are added
     * to a bag in the required order.
     *
     * @param current  current node in the tree being referenced
     * @param sequence Bag containing elements in pre order order
     */
    private void preOrder(Node<T> current, IndexedBag<T> sequence) {
        if (current != null) {
            sequence.add(current.getData());
            inOrder(current.getLeft(), sequence);
            inOrder(current.getRight(), sequence);
        }
    }

    /**
     * Recursive in order traversal of a binary tree. Elements are added
     * to a bag in the required order.
     *
     * @param current  current node in the tree being referenced
     * @param sequence Bag containing elements in in order order
     */
    private void inOrder(Node<T> current, IndexedBag<T> sequence) {
        if (current != null) {
            inOrder(current.getLeft(), sequence);
            sequence.add(current.getData());
            inOrder(current.getRight(), sequence);
        }
    }

    /**
     * Recursive post order traversal of a binary tree. Elements are added
     * to a bag in the required order.
     *
     * @param current  current node in the tree being referenced
     * @param sequence Bag containing elements in post order order
     */
    private void postOrder(Node<T> current, IndexedBag<T> sequence) {
        if (current != null) {
            inOrder(current.getLeft(), sequence);
            inOrder(current.getRight(), sequence);
            sequence.add(current.getData());
        }
    }

    /**
     * Level order traversal of a binary tree. Elements are added
     * to a bag in the required order.
     *
     * @param start    Root node of a binary tree
     * @param sequence Bag containing elements in level order order
     */
    private void levelOrder(Node<T> start, IndexedBag<T> sequence) {
        Queue<Node<T>> levelOrderQueue = new ArrayQueue<>();
        Node<T> current;
        levelOrderQueue.enqueue(start);
        while (!levelOrderQueue.isEmpty()) {
            current = levelOrderQueue.dequeue();
            sequence.add(current.getData());
            if (current.getLeft() != null) {
                levelOrderQueue.enqueue(current.getLeft());
            }
            if (current.getRight() != null) {
                levelOrderQueue.enqueue(current.getRight());
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return inOrderIterator();
    }

    @Override
    public Iterator<T> preOrderIterator() {
        IndexedBag<T> sequence = new ArrayIndexedBag<>();
        preOrder(root, sequence);
        return sequence.iterator();
    }

    @Override
    public Iterator<T> inOrderIterator() {
        IndexedBag<T> sequence = new ArrayIndexedBag<>();
        inOrder(root, sequence);
        return sequence.iterator();
    }

    @Override
    public Iterator<T> postOrderIterator() {
        IndexedBag<T> sequence = new ArrayIndexedBag<>();
        postOrder(root, sequence);
        return sequence.iterator();
    }

    @Override
    public Iterator<T> levelOrderIterator() {
        IndexedBag<T> sequence = new ArrayIndexedBag<>();
        levelOrder(root, sequence);
        return sequence.iterator();
    }

    /**
     * Returns a string containing the elements in the binary search tree in
     * an in order order.
     *
     * @return String of the elements in in order order
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T element : this) {
            builder.append(element);
            builder.append(", ");
        }
        return builder.toString();
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

