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
     * Doubles the size of the bag array and copy the
     * contents over.
     */
    @SuppressWarnings("unchecked")
    private void expandCapacity() {
        T[] newBag = (T[]) new Object[bag.length * 2];
        for (int i = 0; i < bag.length; ++i) {
            newBag[i] = bag[i];
        }
        bag = newBag;
    }

    /**
     * Shifts elements in an array down (towards index 0) towards
     * the starting index specified. This method assumes that
     * the calling function manages the rear field.
     *
     * @param start Index of where shift starts/stops and element
     *              overwritten.
     */
    private void shiftLeft(int start) {
        for (int i = start; i < rear - 1; ++i) {
            bag[i] = bag[i + 1];
        }
        bag[rear - 1] = null;
    }

    /**
     * Shifts elements in an array up (towards index rear) away
     * from the starting index specified. This method assumes that
     * the calling function manages the rear field and any
     * need of expandCapacity().
     *
     * @param start Index of where shifting starts/stops and where
     *              space is opened.
     */
    private void shiftRight(int start) {
        for (int i = rear; i > start; --i) {
            bag[i] = bag[i - 1];
        }
        bag[start] = null;
    }

    /**
     * Find the index of a specified target element. If the element
     * does not exist, return NOT_FOUND
     *
     * @param target Element to be found
     * @return Index of the element if found, NOT_FOUND otherwise
     */
    private int sentinelIndexOf(T target) {
        int searchIndex = 0;
        for (T bagElement : this) {
            if (bagElement.equals(target)) {
                return searchIndex;
            }
            searchIndex++;
        }
        return NOT_FOUND;
    }
    //    private int sentinelIndexOf(T target) {
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
        add(rear, element);
        return true;
    }

    @Override
    public boolean add(int index, T element) {
        if (index > size()) {
            throw new IndexOutOfBoundsException(String.format("Bag has no index %d to add to.", index));
        }
        if (size() == bag.length) {
            expandCapacity();
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
