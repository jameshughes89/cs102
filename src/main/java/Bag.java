import java.util.Iterator;
import java.util.NoSuchElementException;

public interface Bag<T> {

    /**
     * Add an element to the bag.
     *
     * @param element item to be added to the bag
     */
    void add(T element);

    /**
     * Removes and returns a reference to the element equal to the specified element.
     * If no such element exists a NoSuchElementException is thrown.
     *
     * @param element Specified element to find return
     * @return Element equal to specified element
     */
    T remove(T element);

    /**
     * Determines if a specified element is contained within the bag.
     *
     * @param target Element to be searched for
     * @return True if the element is found, false otherwise
     */
    boolean contains(T target);

    /**
     * Returns the number of occurrences of a specified element in the
     * bag.
     *
     * @param target Element to be counted
     * @return Number of times the element occured in the bag.
     */
    int getCount(T target);

    /**
     * Tests if the bag is empty and returns a Boolean.
     *
     * @return True if the bag is empty (no items), false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the total number of elements in the bag
     *
     * @return Number of elements in the bag
     */
    int size();

    /**
     * Returns an iterator object for the elements in the bag in
     * the proper order for the bag type.
     *
     * @return Iterator object for bag instance
     */
    Iterator<T> iterator();
}
