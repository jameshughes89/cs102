import java.util.NoSuchElementException;

/**
 * A SortedBag is a Bag where the elements are kept in some defined ordering. A SortedBag has an order defined by the
 * characteristics of the type of elements within the SortedBag; the elements themselves determine the ordering. All
 * modifications to the SortedBag's contents are done in such a way that the ordering is preserved.
 *
 * @param <T> Type of elements that are to be in the SortedBag. These elements must have a defined ordering.
 */
public interface SortedBag<T extends Comparable<? super T>> extends Bag<T> {

    /**
     * Adds the specified element to the SortedBag such that the SortedBag remains sorted.
     *
     * @param element Element to be added to the SortedBag.
     * @return True if the element was added successfully, false otherwise.
     */
    @Override
    boolean add(T element);

    /**
     * Removes the first (lowest) element from the SortedBag. The remove is done in such a way that the order of the
     * elements within the SortedBag is preserved. Returns the element that was removed from the SortedBag.
     *
     * @return The first (lowest) element currently in the SortedBag.
     * @throws NoSuchElementException If the SortedBag is empty.
     */
    T removeFirst();

    /**
     * Removes the last (highest) element from the SortedBag. The remove is done in such a way that the order of the
     * elements within the SortedBag is preserved. Returns the element that was removed from the SortedBag.
     *
     * @return The last (highest) element currently in the SortedBag.
     * @throws NoSuchElementException If the SortedBag is empty.
     */
    T removeLast();

    /**
     * Returns the first (lowest) element currently in the SortedBag.
     *
     * @return The first (lowest) element currently in the SortedBag.
     * @throws NoSuchElementException If the SortedBag is empty.
     */
    T first();

    /**
     * Returns the last (highest) element currently in the SortedBag.
     *
     * @return The last (highest) element currently in the SortedBag.
     * @throws NoSuchElementException If the SortedBag is empty.
     */
    T last();
}
