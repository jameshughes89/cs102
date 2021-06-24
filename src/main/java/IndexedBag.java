public interface IndexedBag<T> extends Bag<T> {

    /**
     * Adds an element to the end of the IndexedBag.
     *
     * @param element Item to be added to the end of the IndexedBag
     */
    void add(T element);

    /**
     * Adds an element to the IndexedBag at the specified index.
     * Item that was in the index before adding will be in index
     * index + 1.
     *
     * @param index   Index of the IndexedBag to add the element
     * @param element Item to be added to the IndexedBag
     */
    void add(int index, T element);

    /**
     * Set the element at the specified index to the provided element.
     *
     * @param index   Index of the element to be set
     * @param element Item to replace the element at the index
     */
    void set(int index, T element);

    /**
     * Return a reference to the element at the specified index of the
     * IndexedBag The element is not removed from the bag.
     *
     * @param index Index of the element to be returned
     * @return Element at the specified index
     */
    T get(int index);

    /**
     * Remove and return a reference to the element at the specified
     * index in the IndexedBag.
     *
     * @param index Index of the element to be removed
     * @return Element at the specified index
     */
    T remove(int index);

    /**
     * Returns the index of the specified element. If more than one
     * exists, the index of the first element is returned only. If
     * no such element exists, a NoSuchElementException is thrown.
     *
     * @param element Item to be searched for in the IndexedBag
     * @return Index of the first found specified element
     */
    int indexOf(T element);
}
