public interface SortedList<T> extends List<T> {

    /**
     * Adds an element to the SortedList such that the list remains
     * sorted.
     *
     * @param element Item to be added to the SortedList
     */
    void add(T element);
}
