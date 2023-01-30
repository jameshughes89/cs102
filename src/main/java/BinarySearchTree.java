import java.util.NoSuchElementException;

/**
 * A binary search tree is a binary tree with the property that all elements to the left are less than the element in
 * the root node and all elements to the right are greater than or equal to the element in the root node. The binary
 * search tree has an order defined by the characteristics of the type of elements within the binary search tree; the
 * elements themselves determine the ordering. All modifications to the binary search tree contents are done in such a
 * way that binary search tree property is maintained.
 *
 * @param <T> Type of elements that are to be in the binary search tree.
 */
public interface BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T> {

    /**
     * Add an element to the binary search tree such that the binary search tree property is maintained. Equal
     * elements are added to the right.
     *
     * @param element Element to be added to the binary search tree.
     * @return True if the element was added successfully, false otherwise.
     */
    @Override
    boolean add(T element);

    /**
     * Removes a single instance of the specified element from the binary search tree such that the binary search
     * tree property is maintained.
     *
     * @param element Element to be removed from the binary search tree.
     * @return True if the element was removed successfully, false otherwise.
     * @throws NoSuchElementException If the provided element does not exist within the binary search tree.
     */
    @Override
    boolean remove(T element);


    /**
     * Removes and returns the minimum element from the binary search tree such that the binary search tree property is
     * maintained.
     *
     * @return The minimum element currently in the binary search tree.
     * @throws NoSuchElementException If the binary search tree is empty.
     */
    T removeMin();

    /**
     * Removes and returns the maximum element from the binary search tree such that the binary search tree property is
     * maintained.
     *
     * @return The maximum element currently in the binary search tree.
     * @throws NoSuchElementException If the binary search tree is empty.
     */
    T removeMax();

    /**
     * Returns the minimum element from the binary search tree.
     *
     * @return The minimum element currently in the binary search tree.
     * @throws NoSuchElementException If the binary search tree is empty.
     */
    T min();

    /**
     * Returns the maximum element from the binary search tree.
     *
     * @return The maximum element currently in the binary search tree.
     * @throws NoSuchElementException If the binary search tree is empty.
     */
    T max();
}
