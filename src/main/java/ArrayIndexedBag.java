import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

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
     * @param capacity Starting capacity of the fixed length array.
     */
    @SuppressWarnings("unchecked")
    public ArrayIndexedBag(int capacity) {
        bag = (T[]) new Object[capacity];
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
     * @param target Element to find the index of.
     * @return Index of the target element within the collection, or -1 (NOT_FOUND constant) if no such element exists.
     */
    private int find(T target) {
        int searchIndex = 0;
        for (T bagElement : this) {
            if (bagElement.equals(target)) {
                return searchIndex;
            }
            searchIndex++;
        }
        return NOT_FOUND;
    }
    //    private int find(T target) {
    //        int searchIndex = 0;
    //        Iterator<T> it = this.iterator();
    //        while (it.hasNext()) {
    //            if (it.next().equals(target)) {
    //                return searchIndex;
    //            }
    //            searchIndex++;
    //        }
    //        return NOT_FOUND;
    //    }

    @Override
    public boolean add(T element) {
        return add(rear, element);
    }

    @Override
    public boolean add(int index, T element) {
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
        if (index >= size()) {
            throw new IndexOutOfBoundsException(String.format("Bag has no element at index %d.", index));
        }
        T toReturn = bag[index];
        bag[index] = element;
        return toReturn;
    }

    @Override
    public T get(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException(String.format("Bag has no element at index %d.", index));
        }
        return bag[index];
    }

    @Override
    public T remove(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException(String.format("Bag has no element at index %d.", index));
        }
        T returnElement = bag[index];
        shiftLeft(index);
        rear--;
        return returnElement;
    }

    @Override
    public boolean remove(T element) {
        if (isEmpty()) {
            throw new NoSuchElementException("Removing from an empty bag.");
        }
        // If indexOf throws an exception, this method propagates it
        int removeIndex = indexOf(element);
        remove(removeIndex);
        return true;
    }

    @Override
    public int indexOf(T target) {
        int index = sentinelIndexOf(target);
        if (index == NOT_FOUND) {
            throw new NoSuchElementException("Element not contained in bag.");
        }
        return index;
    }

    @Override
    public boolean contains(T target) {
        return sentinelIndexOf(target) != NOT_FOUND;
    }

    @Override
    public int count(T target) {
        int count = 0;
        for (T bagElement : this) {
            if (bagElement.equals(target)) {
                count++;
            }
        }
        return count;
    }
    //    @Override
    //    public int getCount(T target) {
    //        int count = 0;
    //        Iterator<T> it = this.iterator();
    //        while (it.hasNext()) {
    //            if (it.next().equals(target)) {
    //                count++;
    //            }
    //        }
    //        return count;
    //    }

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

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T bagElement : this) {
            builder.append(bagElement);
            builder.append(", ");
        }
        return builder.toString();
    }
    //    public String toString() {
    //        Iterator<T> it = this.iterator();
    //        StringBuilder builder = new StringBuilder();
    //        while (it.hasNext()) {
    //            builder.append(it.next());
    //            builder.append(", ");
    //        }
    //        return builder.toString();
    //    }
}
