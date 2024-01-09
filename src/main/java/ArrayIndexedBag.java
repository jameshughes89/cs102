import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Implementation of an IndexedBag with an array as the container. The array container will automatically "grow" to
 * accommodate adding beyond the initial capacity.
 *
 * @param <T> Type of elements that are to be in the IndexedBag.
 */
public class ArrayIndexedBag<T> implements IndexedBag<T> {

    private static final int DEFAULT_CAPACITY = 100;
    private static final int NOT_FOUND = -1;
    private T[] bag;
    private int rear;

    /**
     * Create an empty ArrayIndexedBag of the default capacity.
     */
    public ArrayIndexedBag() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Create an empty ArrayIndexedBag with the specified capacity.
     *
     * @param initialCapacity Starting capacity of the fixed length array.
     */
    @SuppressWarnings("unchecked")
    public ArrayIndexedBag(int initialCapacity) {
        bag = (T[]) new Object[initialCapacity];
        rear = 0;
    }

    /**
     * Shifts elements in an array down (towards index 0) to the starting index specified. The element at the starting
     * index will be overwritten.
     *
     * @param start Index of element to be overwritten and where shifting moves down to.
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
     * @param start Index of where the array has a new open location and where shifting moves up from.
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
     * @param element Element to find the index of.
     * @return Index of the target element within the collection, or -1 (NOT_FOUND constant) if no such element exists.
     */
    private int find(T element) {
        int searchIndex = 0;
        for (T bagElement : this) {
            if (Objects.equals(bagElement, element)) {
                return searchIndex;
            }
            searchIndex++;
        }
        return NOT_FOUND;
    }

    @Override
    public boolean add(T element) {
        return add(rear, element);
    }

    @Override
    public boolean add(int index, T element) {
        // Index == size() is valid as that just appends
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException(index);
        }
        if (size() == bag.length) {
            bag = Arrays.copyOf(bag, bag.length * 2);
        }
        shiftRight(index);
        bag[index] = element;
        rear++;
        return true;
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException(index);
        }
        T toReturn = bag[index];
        bag[index] = element;
        return toReturn;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException(index);
        }
        return bag[index];
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException(index);
        }
        T returnElement = bag[index];
        shiftLeft(index);
        rear--;
        return returnElement;
    }

    @Override
    public boolean remove(T element) {
        if (!contains(element)) {
            return false;
        }
        int removeIndex = indexOf(element);
        remove(removeIndex);
        return true;
    }

    @Override
    public int indexOf(T element) {
        if (!contains(element)) {
            throw new NoSuchElementException(Objects.toString(element));
        }
        return find(element);
    }

    @Override
    public boolean contains(T element) {
        return find(element) != NOT_FOUND;
    }

    @Override
    public int count(T element) {
        int count = 0;
        for (T bagElement : this) {
            if (bagElement.equals(element)) {
                count++;
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
