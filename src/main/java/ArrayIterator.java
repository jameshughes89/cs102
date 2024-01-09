import java.util.Iterator;
import java.util.NoSuchElementException;

// [start-class_fields]
public class ArrayIterator<T> implements Iterator<T> {

    private final int size;
    private final T[] elements;
    private int index;
    // [end-class_fields]

    // [start-constructor]
    public ArrayIterator(T[] elements, int size) {
        if (size > elements.length) {
            throw new IllegalArgumentException("size exceeds array length.");
        }
        this.elements = elements;
        this.size = size;
        this.index = 0;
    }
    // [end-constructor]

    // [start-hasNext]
    @Override
    public boolean hasNext() {
        return index < size;
    }
    // [end-hasNext]

    // [start-next]
    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T returnElement = elements[index];
        index++;
        return returnElement;
    }
    // [end-next]
}