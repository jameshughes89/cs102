public class ArrayIndexedList<T> extends AbstractArrayList<T> implements IndexedList<T> {

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
}
