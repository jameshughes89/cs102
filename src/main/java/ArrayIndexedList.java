import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIndexedList<T> implements IndexedList<T> {

    private static final int DEFAULT_CAPACITY = 100;
    protected T[] list;
    protected int rear;

    public ArrayIndexedList() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayIndexedList(int initialCapacity) {
        list = (T[]) new Object[initialCapacity];
        rear = 0;
    }

    /**
     * Doubles the size of the list array and copy the
     * contents over.
     */
    @SuppressWarnings("unchecked")
    private void expandCapacity() {
        T[] newList = (T[]) new Object[list.length * 2];
        for (int i = 0; i < list.length; ++i) {
            newList[i] = list[i];
        }
        list = newList;
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
        for (int i = start; i < list.length - 1; ++i) {
            list[i] = list[i + 1];
        }
        list[list.length - 1] = null;
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
            list[i] = list[i - 1];
        }
        list[start] = null;
    }

    @Override
    public void add(T element) {
        add(rear, element);
    }

    @Override
    public void add(int index, T element) {
        if (index > rear) {
            throw new IndexOutOfBoundsException(String.format("List has no index %d to add to.", index));
        }
        if (size() == list.length) {
            expandCapacity();
        }
        shiftRight(index);
        list[index] = element;
        rear++;
    }

    @Override
    public void set(int index, T element) {
        if (index >= rear) {
            throw new IndexOutOfBoundsException(String.format("List has no element at index %d.", index));
        }
        list[index] = element;
    }

    @Override
    public T remove(int index) {
        if (index >= rear) {
            throw new IndexOutOfBoundsException(String.format("List has no element at index %d.", index));
        }
        T returnElement = list[index];
        shiftLeft(index);
        rear--;
        return returnElement;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Removing first from an empty list.");
        }
        T returnElement = list[0];
        shiftLeft(0);
        rear--;
        return returnElement;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Removing last from an empty list.");
        }
        T returnElement = list[rear - 1];
        list[rear - 1] = null;
        rear--;
        return returnElement;
    }

    @Override
    public T remove(T element) {
        if (isEmpty()) {
            throw new NoSuchElementException("Removing from an empty list.");
        }
        int removeIndex = indexOf(element);
        if (removeIndex == -1) {
            throw new NoSuchElementException("Element not contained in list.");
        }
        T returnElement = list[removeIndex];
        shiftLeft(removeIndex);
        rear--;
        return returnElement;
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new NoSuchElementException("First from an empty list.");
        }
        return list[0];
    }

    @Override
    public T last() {
        if (isEmpty()) {
            throw new NoSuchElementException("Last from an empty list.");
        }
        return list[rear - 1];
    }

    @Override
    public T get(int index) {
        if (index >= rear) {
            throw new IndexOutOfBoundsException(String.format("List has no element at index %d.", index));
        }
        return list[index];
    }

    @Override
    public int indexOf(T target) {
        for (int i = 0; i < list.length; ++i) {
            if (list[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(T target) {
        return indexOf(target) != -1;
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
        return new ArrayIterator<>(list, rear);
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
