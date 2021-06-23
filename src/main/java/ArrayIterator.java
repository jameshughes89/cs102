import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {

    private int size;
    private int currentIndex;
    private T[] items;

    public ArrayIterator(T[] items, int size) {
        this.items = items;
        this.size = size;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < size;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T returnElement = items[currentIndex];
        currentIndex--;
        return returnElement;
    }
}