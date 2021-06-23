import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIndexedBag<T> implements IndexedBag<T> {

    private static final int DEFAULT_CAPACITY = 100;
    private static final int NOT_FOUND = -1;
    protected T[] bag;
    protected int rear;

    public ArrayIndexedBag() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayIndexedBag(int initialCapacity) {
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

    @Override
    public void add(T element) {
        add(rear, element);
    }

    @Override
    public void add(int index, T element) {
        if (index > rear) {
            throw new IndexOutOfBoundsException(String.format("Bag has no index %d to add to.", index));
        }
        if (size() == bag.length) {
            expandCapacity();
        }
        shiftRight(index);
        bag[index] = element;
        rear++;
    }

    @Override
    public void set(int index, T element) {
        if (index >= rear) {
            throw new IndexOutOfBoundsException(String.format("Bag has no element at index %d.", index));
        }
        bag[index] = element;
    }

    @Override
    public T get(int index) {
        if (index >= rear) {
            throw new IndexOutOfBoundsException(String.format("Bag has no element at index %d.", index));
        }
        return bag[index];
    }

    @Override
    public T remove(int index) {
        if (index >= rear) {
            throw new IndexOutOfBoundsException(String.format("Bag has no element at index %d.", index));
        }
        T returnElement = bag[index];
        shiftLeft(index);
        rear--;
        return returnElement;
    }

    @Override
    public int indexOf(T target) {
        for (int i = 0; i < bag.length; ++i) {
            if (bag[i].equals(target)) {
                return i;
            }
        }
        return NOT_FOUND;
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
        return remove(removeIndex);
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
        builder.append("Front --> ");
        while (it.hasNext()) {
            builder.append(it.next());
            builder.append(", ");
        }
        return builder.toString();
    }
}
