import java.util.NoSuchElementException;

/**
 * A sorted bag is a bag where the elements are kept in some defined ordering. A sorted bag has an order defined by the
 * characteristics of the type of elements within the sorted bag; the elements themselves determine the ordering. All
 * modifications to the sorted bag's contents are done in such a way that the ordering is preserved.
 *
 * @param <T> Type of elements that are to be in the sorted bag. These elements must have a defined ordering.
 */
public interface SortedBag<T extends Comparable<? super T>> extends Bag<T> {

    /**
     * Adds the specified element to the sorted bag such that the sorted bag remains sorted.
     *
     * @param element Element to be added to the sorted bag.
     * @return True if the element was added successfully, false otherwise.
     */
    @Override
    boolean add(T element);

    /**
     * Removes a single instance of the specified element from the bag such that the sorted bag remains sorted.
     *
     * @param element Element to be removed from the bag.
     * @return True if the element was removed successfully, false otherwise.
     * @throws NoSuchElementException If the provided element does not exist within the bag.
     */
    @Override
    boolean remove(T element);

    /**
     * Removes the first (lowest) element from the sorted bag. The remove is done in such a way that the order of the
     * elements within the sorted bag is preserved. Returns the element that was removed from the sorted bag.
     *
     * @return The first (lowest) element currently in the sorted bag.
     * @throws NoSuchElementException If the sorted bag is empty.
     */
    T removeFirst();

    /**
     * Removes the last (highest) element from the sorted bag. The remove is done in such a way that the order of the
     * elements within the sorted bag is preserved. Returns the element that was removed from the sorted bag.
     *
     * @return The last (highest) element currently in the sorted bag.
     * @throws NoSuchElementException If the sorted bag is empty.
     */
    T removeLast();

    /**
     * Returns the first (lowest) element currently in the sorted bag.
     *
     * @return The first (lowest) element currently in the sorted bag.
     * @throws NoSuchElementException If the sorted bag is empty.
     */
    T first();

    /**
     * Returns the last (highest) element currently in the sorted bag.
     *
     * @return The last (highest) element currently in the sorted bag.
     * @throws NoSuchElementException If the sorted bag is empty.
     */
    T last();
}
