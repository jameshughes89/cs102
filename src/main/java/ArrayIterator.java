import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {

    private final int size;
    private final T[] elements;
    private int index;

    public ArrayIterator(T[] elements, int size) {
        if (size >= elements.length) {
            throw new IllegalArgumentException("size exceeds array length.");
        }
        this.elements = elements;
        this.size = size;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < size;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T returnElement = elements[index];
        index++;
        return returnElement;
    }
}