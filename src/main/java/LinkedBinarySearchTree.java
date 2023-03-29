import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedBinarySearchTree<T extends Comparable<? super T>> implements BinarySearchTree<T> {

    private int size;
    private Node<T> root;

    public LinkedBinarySearchTree() {
        root = null;
        size = 0;
    }

    @Override
    public boolean add(T element) {
        root = add(element, root);
        size++;
        return true;
    }

    /**
     * Helper add method for enabling recursive add. This method ensures that elements are added in the proper order for
     * a Binary Search Tree.
     *
     * @param element Element to be added to the tree
     * @param current Current root of subtree
     * @return Node being assigned as left/right child
     */
    private Node<T> add(T element, Node<T> current) {
        if (current == null) {
            return new Node<>(element);
        }
        if (current.getData().compareTo(element) > 0) {
            current.setLeft(add(element, current.getLeft()));
        } else {
            current.setRight(add(element, current.getRight()));
        }
        return current;
    }

    @Override
    public boolean remove(T element) {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Tree");
        }
        int comparison = root.getData().compareTo(element);
        if (comparison == 0) {
            root = findReplacementNode(root);
        } else if (comparison > 0) {
            remove(element, root, root.getLeft());
        } else {
            remove(element, root, root.getRight());
        }
        size--;
        return true;
    }

    /**
     * Helper method for recursive remove.
     *
     * @param element Element to me removed
     * @param parent  The parent of the current node
     * @param current The current node
     * @return The element being removed
     */
    private T remove(T element, Node<T> parent, Node<T> current) {
        if (current == null) {
            throw new NoSuchElementException(Objects.toString(element));
        }
        int comparison = current.getData().compareTo(element);
        if (comparison == 0) {
            if (parent.getData().compareTo(current.getData()) > 0) {
                parent.setLeft(findReplacementNode(current));
            } else {
                parent.setRight(findReplacementNode(current));
            }
            return current.getData();
        } else if (comparison > 0) {
            return remove(element, current, current.getLeft());
        } else {
            return remove(element, current, current.getRight());
        }
    }

    /**
     * Helper method for finding which node should be used to replace a node being removed.
     * There are a few conditions:
     * 1. Both left and right children are null. Here, simply remove the node.
     * 2. Left child is not null but right child is null. Replace the toRemove node with the left child.
     * 3. Left child is null but right child is not null. Replace the toRemove node with the right child.
     * 4. Both left and right children are not null. Replace the toRemove node with the in order successor, which would
     * be the right subtree's left most node.
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
            Node<T> current = toRemove.getRight();
            // Find the in order successor --- toRemove's right child's left most node (minimum node)
            while (current.getLeft() != null) {
                parent = current;
                current = current.getLeft();
            }
            replacementNode = current;
            // Set replacementNode's left to toRemove's left
            replacementNode.setLeft(toRemove.getLeft());
            // Update replacementNode's right if necessary --- if the in order successor of toRemove is its immediate
            // right, no update is needed. Otherwise, the replacementNode's parent's left is set to the
            // replacementNode's right and the replacementNode's right is set to toRemove's right.
            if (toRemove.getRight() != replacementNode) {
                parent.setLeft(replacementNode.getRight());
                replacementNode.setRight(toRemove.getRight());
            }
        }
        return replacementNode;
    }

    @Override
    public T removeMin() {
        T returnElement = null;
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Tree");
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
     * Helper method for a recursive removeMin.
     *
     * @param parent  The parent of the current node
     * @param current The current node
     * @return Minimum element in the binary search tree
     */
    private T removeMin(Node<T> parent, Node<T> current) {
        if (current.getLeft() == null) {
            parent.setLeft(current.getRight());
            return current.getData();
        } else {
            return removeMin(current, current.getLeft());
        }
    }

    /**
     * An iterative implementation of finding the maximum element in a binary search tree. This method could be
     * recursive like removeMin; however, the iterative one is included for demonstrative purposes.
     *
     * @return The maximum element in the binary search tree
     */
    @Override
    public T removeMax() {
        T returnElement = null;
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Tree");
        }
        if (root.getRight() == null) {
            returnElement = root.getData();
            root = root.getLeft();
        } else {
            Node<T> parent = root;
            Node<T> current = root.getRight();
            // Iterate right until right most node is found
            while (current.getRight() != null) {
                parent = current;
                current = current.getRight();
            }
            returnElement = current.getData();
            parent.setRight(current.getLeft());
        }
        size--;
        return returnElement;
    }

    @Override
    public T min() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Tree");
        }
        return min(root);
    }

    /**
     * Helper method for enabling a recursive search for the minimum element in the binary search tree.
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
            throw new NoSuchElementException("Empty Tree");
        }
        if (root.getRight() == null) {
            return root.getData();
        } else {
            Node<T> current = root.getRight();
            // Iterate right until right most node is found
            while (current.getRight() != null) {
                current = current.getRight();
            }
            return current.getData();
        }
    }

    @Override
    public boolean contains(T element) {
        return binarySearch(element, root) != null;
    }

    /**
     * Helper method enabling a recursive binary search for a given element.
     *
     * @param element Element being searched for
     * @param current Current node being investigated
     * @return Node containing the element searched for, or null if not found
     */
    private Node<T> binarySearch(T element, Node<T> current) {
        if (current == null) {
            return null;
        }
        int comparison = current.getData().compareTo(element);
        if (comparison == 0) {
            return current;
        } else {
            if (comparison > 0) {
                return binarySearch(element, current.getLeft());
            } else {
                return binarySearch(element, current.getRight());
            }
        }
    }

    @Override
    public int count(T element) {
        if (isEmpty()) {
            return 0;
        }
        return count(element, root);
    }

    /**
     * Helper method for recursive count of elements in binary search tree.
     *
     * @param element Element to be counted
     * @param current Current node being investigated
     * @return Number of times the element exists in the (sub)tree
     */
    private int count(T element, Node<T> current) {
        if (current == null) {
            return 0;
        }
        int comparison = current.getData().compareTo(element);
        if (comparison == 0) {
            // With this implementation, equal elements are always to the right
            return 1 + count(element, current.getRight());
        } else if (comparison > 0) {
            return count(element, current.getLeft());
        } else {
            return count(element, current.getRight());
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Recursive pre-order traversal of a binary tree. Elements are added to a bag in the required order.
     *
     * @param current  current node in the tree being referenced
     * @param sequence Bag containing elements with a pre-order ordering
     */
    private void preOrder(Node<T> current, IndexedBag<T> sequence) {
        if (current != null) {
            sequence.add(current.getData());
            preOrder(current.getLeft(), sequence);
            preOrder(current.getRight(), sequence);
        }
    }

    /**
     * Recursive in-order traversal of a binary tree. Elements are added to a bag in the required order.
     *
     * @param current  current node in the tree being referenced
     * @param sequence Bag containing elements with an in-order ordering
     */
    private void inOrder(Node<T> current, IndexedBag<T> sequence) {
        if (current != null) {
            inOrder(current.getLeft(), sequence);
            sequence.add(current.getData());
            inOrder(current.getRight(), sequence);
        }
    }

    /**
     * Recursive post-order traversal of a binary tree. Elements are added to a bag in the required order.
     *
     * @param current  current node in the tree being referenced
     * @param sequence Bag containing elements with a post-order ordering
     */
    private void postOrder(Node<T> current, IndexedBag<T> sequence) {
        if (current != null) {
            postOrder(current.getLeft(), sequence);
            postOrder(current.getRight(), sequence);
            sequence.add(current.getData());
        }
    }

    /**
     * Level-order traversal of a binary tree. Elements are added to a bag in the required order.
     *
     * @param start    Root node of a binary tree
     * @param sequence Bag containing elements with a level-order ordering
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
        if (!isEmpty()) {
            levelOrder(root, sequence);
        }
        return sequence.iterator();
    }

    /**
     * Returns a string containing the elements in the binary search tree with an in-order ordering.
     *
     * @return String of the elements with an in-order ordering
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T element : this) {
            builder.append(element);
            builder.append(", ");
        }
        return builder.toString();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof BinaryTree)) {
            return false;
        }
        BinarySearchTree<?> that = (BinarySearchTree<?>) o;
        if (this.size() != that.size()) {
            return false;
        }
        Iterator<T> thisIterator = this.iterator();
        Iterator<?> thatIterator = that.iterator();
        while (thisIterator.hasNext()) {
            if (!Objects.equals(thisIterator.next(), thatIterator.next())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        for (T element : this) {
            result += Objects.hashCode(element);
        }
        return result;
    }

    /**
     * A node class for a linked binary tree structure. Each node contains a nullable reference to data of type T, and a
     * reference to the left and right child nodes, which may be null references.
     *
     * @param <T> Type of the data being stored in the node
     */
    private static class Node<T> {
        private T data;
        private Node<T> left;
        private Node<T> right;

        private Node() {
            this(null);
        }

        private Node(T data) {
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

        private Node<T> getLeft() {
            return left;
        }

        private void setLeft(Node<T> left) {
            this.left = left;
        }

        private Node<T> getRight() {
            return right;
        }

        private void setRight(Node<T> right) {
            this.right = right;
        }
    }
}

