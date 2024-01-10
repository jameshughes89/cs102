import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

// [start-class_fields_constructor]

/**
 * Implementation of a SortedBag with an array as the container. The array container will automatically "grow" to
 * accommodate adding beyond the initial capacity.
 *
 * @param <T> Type of elements that are to be in the SortedBag
 */
public class ArraySortedBag<T extends Comparable<? super T>> implements SortedBag<T> {

    private static final int DEFAULT_CAPACITY = 100;
    private static final int NOT_FOUND = -1;
    private T[] bag;
    private int rear;

    /**
     * Create an empty ArraySortedBag of the default capacity.
     */
    public ArraySortedBag() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Create an empty ArraySortedBag with the specified capacity.
     *
     * @param initialCapacity Starting capacity of the fixed length array
     */
    @SuppressWarnings("unchecked")
    public ArraySortedBag(int initialCapacity) {
        bag = (T[]) new Comparable[initialCapacity];
        rear = 0;
    }
    // [end-class_fields_constructor]

    /**
     * Shifts elements in an array down (towards index 0) to the starting index specified. The element at the starting
     * index will be overwritten.
     *
     * @param start Index of element to be overwritten and where shifting moves down to
     */
    private void shiftLeft(int start) {
        for (int i = start; i < rear - 1; i++) {
            bag[i] = bag[i + 1];
        }
        bag[rear - 1] = null;
    }

    /**
     * Shifts elements in an array up (towards index rear) away from the starting index specified. The array location
     * at the specified starting index will be open. This method assumes there is room in the array to facilitate the
     * shifting.
     *
     * @param start Index of where the array has a new open location and where shifting moves up from
     */
    private void shiftRight(int start) {
        for (int i = rear; i > start; i--) {
            bag[i] = bag[i - 1];
        }
        bag[start] = null;
    }

    /**
     * Find and return the index of a given target element within the collection. If no such element exists within the
     * collection, a sentinel value of -1 (NOT_FOUND constant) is returned.
     *
     * @param element Element to find the index of
     * @return Index of the target element within the collection, or -1 (NOT_FOUND constant) if no such element exists
     */
    private int find(T element) {
        int searchIndex = 0;
        for (T bagElement : this) {
            if (bagElement.compareTo(element) == 0) {
                return searchIndex;
            } else if (bagElement.compareTo(element) > 0) {
                return NOT_FOUND;
            }
            searchIndex++;
        }
        return NOT_FOUND;
    }

    // [start-add]
    @Override
    public boolean add(T element) {
        if (size() == bag.length) {
            bag = Arrays.copyOf(bag, bag.length * 2);
        }
        int insertIndex = findInsertIndex(element);
        shiftRight(insertIndex);
        bag[insertIndex] = element;
        rear++;
        return true;
    }

    /**
     * Linear search through the bag to find the index of where the element should be inserted. If equal elements
     * exist within the collection, the returned index will be after the existing equal elements.
     *
     * @param element Item to be inserted
     * @return Index where the element should be inserted
     */
    private int findInsertIndex(T element) {
        int searchIndex = 0;
        for (T bagElement : this) {
            if (element.compareTo(bagElement) <= 0) {
                return searchIndex;
            }
            searchIndex++;
        }
        // Element must belong at rear
        return rear;
    }
    // [end-add]

    // [start-remove_removeFirst]
    @Override
    public boolean remove(T element) {
        if (!contains(element)) {
            return false;
        }
        int index = find(element);
        shiftLeft(index);
        rear--;
        return true;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty bag");
        }
        T returnElement = bag[0];
        shiftLeft(0);
        rear--;
        return returnElement;
    }
    // [end-remove_removeFirst]

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty bag");
        }
        T returnElement = bag[rear - 1];
        bag[rear - 1] = null;
        rear--;
        return returnElement;
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty bag");
        }
        return bag[0];
    }

    @Override
    public T last() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty bag");
        }
        return bag[rear - 1];
    }

    @Override
    public boolean contains(T element) {
        return find(element) != NOT_FOUND;
    }

    @Override
    public int count(T element) {
        int count = 0;
        for (T bagElement : this) {
            if (bagElement.compareTo(element) == 0) {
                count++;
            } else if (bagElement.compareTo(element) > 0) {
                return count;
            }
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return rear;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(bag, size());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T bagElement : this) {
            builder.append(bagElement);
            builder.append(", ");
        }
        return builder.toString();
    }


    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Bag)) {
            return false;
        }
        Bag<T> that = (Bag<T>) o;
        if (this.size() != that.size()) {
            return false;
        }
        for (T element : this) {
            if (this.count(element) != that.count(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(rear);
        for (T element : this) {
            result += Objects.hashCode(element);
        }
        return result;
    }
}
