import java.util.Iterator;
import java.util.NoSuchElementException;

public interface List<T> {

    /**
     * Removes and returns the first element in the list. If no such element exists a
     * NoSuchElementException is thrown.
     *
     * @return First element in the list
     */
    T removeFirst();

    /**
     * Removes and returns the last element in the list. If no such element exists a
     * NoSuchElementException is thrown.
     *
     * @return Last element in the list
     */
    T removeLast();

    /**
     * Removes and returns the element equal to the specified element. If no such
     * element exists a NoSuchElementException is thrown.
     *
     * @param element Specified element to find return
     * @return Element equal to specified element
     */
    T remove(T element);

    /**
     * Returns the first element in the list. After the method completes, the item
     * will still be at the front of the list. If no such element exists, a
     * NoSuchElementException is thrown.
     *
     * @return First element in the list
     */
    T first();

    /**
     * Returns the last element in the list. After the method completes, the item
     * will still be at the end of the list. If no such element exists, a
     * NoSuchElementException is thrown.
     *
     * @return Last element in the list
     */
    T last();

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

    Iterator<T> iterator();

}
