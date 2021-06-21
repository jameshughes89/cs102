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
     * index + 1.
     *
     * @param index   Index of the IndexedList to add the element
     * @param element Item to be added to the IndexedList
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
     * IndexedList. The element is not removed from the list.
     *
     * @param index Index of the element to be returned
     * @return Element at the specified index
     */
    T get(int index);

    /**
     * Remove and return a reference to the element at the specified
     * index in the IndexedList.
     *
     * @param index Index of the element to be removed
     * @return Element at the specified index
     */
    T remove(int index);

    /**
     * Returns the index of the specified element. If no such element exists,
     * a NoSuchElementException is thrown.
     *
     * @param element Item to be searched for in the IndexedList
     * @return Index of the specified element
     */
    int indexOf(T element);

}
