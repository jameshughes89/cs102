import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArraySortedBag<T extends Comparable<? super T>> implements SortedBag<T> {

    private static final int DEFAULT_CAPACITY = 100;
    private static final int NOT_FOUND = -1;
    protected T[] bag;
    protected int rear;

    public ArraySortedBag() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArraySortedBag(int initialCapacity) {
        bag = (T[]) new Object[initialCapacity];
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
        for (int i = start; i < bag.length - 1; ++i) {
            bag[i] = bag[i + 1];
        }
        bag[bag.length - 1] = null;
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
    private int indexOf(T target) {
        for (int i = 0; i < bag.length; ++i) {
            if (bag[i].equals(target)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    @Override
    public void add(T element) {
        if (size() == bag.length) {
            expandCapacity();
        }
        // Assume the element has some defined ordering
        Iterator<T> it = this.iterator();
        int searchIndex = 0;
        // Search for the index the new element belongs in
        while (it.hasNext() && element.compareTo(bag[searchIndex]) > 0) {
            searchIndex++;
        }
        shiftRight(searchIndex);
        bag[searchIndex] = element;
        rear++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Removing first from an empty bag.");
        }
        T returnElement = bag[0];
        shiftLeft(0);
        rear--;
        return returnElement;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Removing last from an empty bag.");
        }
        T returnElement = bag[rear - 1];
        bag[rear - 1] = null;
        rear--;
        return returnElement;
    }

    @Override
    public T remove(T element) {
        if (isEmpty()) {
            throw new NoSuchElementException("Removing from an empty bag.");
        }
        int removeIndex = indexOf(element);
        if (removeIndex == NOT_FOUND) {
            throw new NoSuchElementException("Element not contained in bag.");
        }
        T returnElement = bag[removeIndex];
        shiftLeft(removeIndex);
        rear--;
        return returnElement;
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new NoSuchElementException("First from an empty bag.");
        }
        return bag[0];
    }

    @Override
    public T last() {
        if (isEmpty()) {
            throw new NoSuchElementException("Last from an empty bag.");
        }
        return bag[rear - 1];
    }

    @Override
    public boolean contains(T target) {
        return indexOf(target) != NOT_FOUND;
    }

    @Override
    public int getCount(T target) {
        int count = 0;
        Iterator<T> it = this.iterator();
        while (it.hasNext()) {
            if (it.next().equals(target)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return rear == 0;
    }

    @Override
    public int size() {
        return rear;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(bag, rear);
    }

    public String toString() {
        Iterator<T> it = this.iterator();
        StringBuilder builder = new StringBuilder();
        while (it.hasNext()) {
            builder.append(it.next());
            builder.append(", ");
        }
        return builder.toString();
    }
}
