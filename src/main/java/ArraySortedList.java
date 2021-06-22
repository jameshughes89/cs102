import java.util.Iterator;

public class ArraySortedList<T> extends AbstractArrayList<T> implements SortedList<T> {

    public ArraySortedList() {
        super();
    }

    public ArraySortedList(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void add(T element) {
        if (size() == list.length) {
            expandCapacity();
        }
        // Assume the element has some defined ordering
        Comparable<T> comp = (Comparable<T>) element;
        Iterator<T> it = this.iterator();
        int searchIndex = 0;
        while (it.hasNext() && comp.compareTo(this.get(searchIndex)) > 0) {
            searchIndex++;
        }
        shiftRight(searchIndex);
        list[searchIndex] = element;
        rear++;
    }
}
