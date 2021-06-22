import java.util.Iterator;
import java.util.NoSuchElementException;

public interface List<T> {

    /**
     * Removes and returns a reference to the first element in the list. If no such element
     * exists a NoSuchElementException is thrown.
     *
     * @return First element in the list
     */
    T removeFirst();

    /**
     * Removes and returns a refernce to the last element in the list. If no such element
     * exists a NoSuchElementException is thrown.
     *
     * @return Last element in the list
     */
    T removeLast();

    /**
     * Removes and returns a reference to the element equal to the specified element.
     * If no such element exists a NoSuchElementException is thrown.
     *
     * @param element Specified element to find return
     * @return Element equal to specified element
     */
    T remove(T element);

    /**
     * Returns a reference to the first element in the list. After the method completes,
     * the item will still be at the front of the list. If no such element exists, a
     * NoSuchElementException is thrown.
     *
     * @return First element in the list
     */
    T first();

    /**
     * Returns a reference to the last element in the list. After the method completes,
     * the item will still be at the end of the list. If no such element exists, a
     * NoSuchElementException is thrown.
     *
     * @return Last element in the list
     */
    T last();

    /**
     * Returns a reference to the element at the specified location. After the method
     * completes, the item will still be at the end of the list. If the provided
     * index is out of range, an IndexOutOfBoundsException is thrown.
     *
     * @param index Index to retrieve element from
     * @return Element at specified index
     */
    T get(int index);

    /**
     * Returns the index of a specified element if it is contained
     * within the list. If the element is not within the list, -1
     * is returned to signify that the element was not found.
     *
     * @param target Element to be searched for
     * @return Index of the specified element or -1 if not found
     */
    int indexOf(T target);

    /**
     * Determines if a specified element is contained within the list.
     *
     * @param target Element to be searched for
     * @return True if the element is found, false otherwise
     */
    boolean contains(T target);

    /**
     * Tests if the list is empty and returns a Boolean.
     *
     * @return True if the queue is empty (no items), false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the list. This method does not handle
     * the size exceeding Integer.MAX_VALUE.
     *
     * @return The number of elements in the list.
     */
    int size();

    /**
     * Returns an iterator object for the elements in the list in
     * the proper order for the list type.
     *
     * @return Iterator object for list instance
     */
    Iterator<T> iterator();
}
