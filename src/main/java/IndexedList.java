public interface IndexedList<T> extends List<T> {

    /**
     * Adds an element to the end of the IndexedList.
     *
     * @param element Item to be added to the end of the IndexedList
     */
    void add(T element);

    /**
     * Adds an element to the IndexedList at the specified index.
     * Item that was in the index before adding will be in index
     * index + 1. If the index does not exist, an
     * IndexOutOfBoundsException is thrown.
     *
     * @param index   Index of the IndexedList to add the element
     * @param element Item to be added to the IndexedList
     */
    void add(int index, T element);

    /**
     * Set the element at the specified index to the provided element.
     * If no item exists at the specified index, an
     * IndexOutOfBoundsException is thrown.
     *
     * @param index   Index of the element to be set
     * @param element Item to replace the element at the index
     */
    void set(int index, T element);

    /**
     * Remove and return a reference to the element at the specified
     * index in the IndexedList.If no item exists at the specified
     * index, an IndexOutOfBoundsException is thrown.
     *
     * @param index Index of the element to be removed
     * @return Element at the specified index
     */
    T remove(int index);
}
