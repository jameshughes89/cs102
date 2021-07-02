import java.util.Iterator;

public interface BinarySearchTree<T extends Comparable<? super T>> extends Iterable<T> {

    /**
     * Add an element to the tree such that the binary search tree property
     * is maintained.
     *
     * @param element Element to be added to the tree in the proper location
     */
    void add(T element);

    /**
     * Remove and return a specified element from the binary search tree such that
     * the binary search tree property is maintained. If multiple matching elements
     * exist, only one is returned. If no such element exists a
     * NoSuchElementException is thrown.
     *
     * @param element Element to be removed from the
     * @return Element being removed
     */
    T remove(T element);

    /**
     * Remove and return the minimum element contained in the binary search tree.
     * What is considered as the minimum is defined by the type's ordering. If
     * multiple matching elements exist, only one is returned. If no such element
     * exists a NoSuchElementException is thrown.
     *
     * @return Minimum/smallest element in the binary search tree
     */
    T removeMin();

    /**
     * Remove and return the maximum element contained in the binary search tree.
     * What is considered as the maximum is defined by the type's ordering. If
     * multiple matching elements exist, only one is returned. If no such element
     * exists a NoSuchElementException is thrown.
     *
     * @return Maximum/largest element in the binary search tree
     */
    T removeMax();

    /**
     * Return the minimum element contained in the binary search tree. What is
     * considered as the minimum is defined by the type's ordering. After this
     * method is called, the element remains in the tree. If no such element
     * exists a NoSuchElementException is thrown.
     *
     * @return Minimum/smallest element in the binary search tree
     */
    T min();

    /**
     * Return the maximum element contained in the binary search tree. What is
     * considered as the maximum is defined by the type's ordering. After this
     * method is called, the element remains in the tree. If no such element
     * exists a NoSuchElementException is thrown.
     *
     * @return Maximum/largest element in the binary search tree
     */
    T max();

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
