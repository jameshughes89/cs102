public interface SortedBag<T> extends Bag<T> {

    /**
     * Adds an element to the SortedBag such that the bag remains
     * sorted. Elements considered equal are added to the right.
     *
     * @param element Item to be added to the SortedBag
     */
    void add(T element);

    /**
     * Removes and returns a reference to the first element in the bag. If no such element
     * exists a NoSuchElementException is thrown.
     *
     * @return First element in the bag
     */
    T removeFirst();

    /**
     * Removes and returns a reference to the last element in the bag. If no such element
     * exists a NoSuchElementException is thrown.
     *
     * @return Last element in the bag
     */
    T removeLast();

    /**
     * Returns a reference to the first element in the bag. After the method completes,
     * the item will still be at the front of the bag. If no such element exists, a
     * NoSuchElementException is thrown.
     *
     * @return First element in the bag
     */
    T first();

    /**
     * Returns a reference to the last element in the bag. After the method completes,
     * the item will still be at the end of the bag. If no such element exists, a
     * NoSuchElementException is thrown.
     *
     * @return Last element in the bag
     */
    T last();
}
