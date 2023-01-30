import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A bag is a linear data structure. Bags have no defined ordering. Elements can be added and removed from a bag.
 *
 * @param <T> Type of elements that are to be in the bag.
 */
public interface Bag<T> extends Iterable<T> {

    /**
     * Add an element to the bag.
     *
     * @param element Element to be added to the bag.
     * @return True if the element was added successfully, false otherwise.
     */
    boolean add(T element);

    /**
     * Removes a single instance of the specified element from the bag.
     *
     * @param element Element to be removed from the bag.
     * @return True if the element was removed successfully, false otherwise.
     * @throws NoSuchElementException If the provided element does not exist within the bag.
     */
    boolean remove(T element);

    /**
     * Returns true if the bag contains the specified element.
     *
     * @param element Element whose presence in the bag is to be tested.
     * @return True if the element is contained within the bag, false otherwise.
     */
    boolean contains(T element);

    /**
     * Returns the number of occurrences of an element contained within the bag.
     *
     * @param element Element to be counted.
     * @return Number of times the element can be found in the bag.
     */
    int count(T element);

    /**
     * Returns true if the bag contains no elements.
     *
     * @return True if the bag is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the bag. This method does not handle the case of size exceeding
     * Integer.MAX_VALUE.
     *
     * @return The number of elements in the bag.
     */
    int size();

    /**
     * Returns an iterator over the elements in the bag.
     *
     * @return An Iterator over the elements in the bag.
     */
    Iterator<T> iterator();
}
