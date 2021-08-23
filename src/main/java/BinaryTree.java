import java.util.Iterator;

public interface BinaryTree<T> extends Iterable<T> {

    /**
     * Adds a specified element to the binary tree
     *
     * @param element Element to be added
     */
    void add(T element);

    /**
     * Removes a specified element from the binary tree
     *
     * @param element Element to be removed
     * @return reference to the element being removed
     */
    T remove(T element);

    /**
     * Returns a reference to the element contained in the root of the tree.
     *
     * @return Reference to the root's element
     */
    T getRootElement();

    /**
     * Returns true if element is contained within the tree, false otherwise.
     *
     * @param element Element to search for
     * @return True if element is in tree, false otherwise
     */
    boolean contains(T element);

    /**
     * Checks if the tree is empty.
     *
     * @return True if the tree is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the tree.
     *
     * @return Count of the number of elements in the tree
     */
    int size();

    /**
     * Iterator over all elements in the binary tree.
     *
     * @return Iterator for the binary tree
     */
    Iterator<T> iterator();

    /**
     * Iterator over all elements in the tree in a 'pre-order'
     * ordering.
     *
     * @return Pre-order iterator for tree
     */
    Iterator<T> preOrderIterator();

    /**
     * Iterator over all elements in the tree in a 'In-order'
     * ordering.
     *
     * @return In-order iterator for tree
     */
    Iterator<T> inOrderIterator();

    /**
     * Iterator over all elements in the tree in a 'post-order'
     * ordering.
     *
     * @return Post-order iterator for tree
     */
    Iterator<T> postOrderIterator();

    /**
     * Iterator over all elements in the tree in a 'pre-order'
     * ordering.
     *
     * @return Level-order iterator for tree
     */
    Iterator<T> levelOrderIterator();

    String toString();
}
