import java.util.NoSuchElementException;

/**
 * An IndexedBag is a Bag where elements may be referenced by numeric positions --- indices. An IndexedBag has an
 * ordering based on element position within the IndexedBag. Every time an element is added or removed, the indices of
 * the elements within the IndexedBag may change.
 *
 * @param <T> Type of elements that are to be in the IndexedBag.
 */
public interface IndexedBag<T> extends Bag<T> {

    /**
     * Appends the specified element to the end of the IndexedBag.
     *
     * @param element Element to be appended to the IndexedBag.
     * @return True if the element was added successfully, false otherwise.
     */
    @Override
    boolean add(T element);

    /**
     * Inserts the specified element at the specified position in the IndexedBag. Shifts the element currently at that
     * position (if any) and any subsequent elements to the right (adds one to their indices).
     *
     * @param index   Index at which the specified element is to be inserted.
     * @param element Element to be inserted to the IndexedBag.
     * @return True if the element was added successfully, false otherwise.
     * @throws IndexOutOfBoundsException If the index is out of range (index < 0 || index >= size()).
     */
    boolean add(int index, T element);

    /**
     * Replaces the element at the specified position in the IndexedBag with the specified element.
     *
     * @param index   Index of the element to replace.
     * @param element Element to be stored at the specified position.
     * @return Element previously at the specified position
     */
    T set(int index, T element);

    /**
     * Returns the element at the specified position in the IndexedBag.
     *
     * @param index Index of the element to return.
     * @return The element at the specified position in the IndexedList.
     * @throws IndexOutOfBoundsException If the index is out of range (index < 0 || index >= size()).
     */
    T get(int index);

    /**
     * Removes the element at the specified position in the IndexedBag. Shifts any subsequent elements to the left
     * (subtracts one from their indices). Returns the element that was removed from the IndexedBag.
     *
     * @param index The index of the element to be removed.
     * @return The element previously at the specified position.
     * @throws IndexOutOfBoundsException If the index is out of range (index < 0 || index >= size()).
     */
    T remove(int index);

    /**
     * Returns the index of the first occurrence of the specified element in the IndexedBag.
     *
     * @param element Element to search for
     * @return The index of the first occurrence of the specified element in the IndexedBag.
     * @throws NoSuchElementException If the provided element does not exist within the IndexedBag.
     */
    int indexOf(T element);
}
