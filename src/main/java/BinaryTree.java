import java.util.Iterator;

public interface BinaryTree<T> extends Iterable<T> {

    T getRootElement();

    boolean contains();

    T find(T element);

    boolean isEmpty();

    int size();

    Iterator<T> iterator();

    Iterator<T> iteratorPreOrder();

    Iterator<T> iteratorInOrder();

    Iterator<T> iteratorPostOrder();

    Iterator<T> iteratorLevelOrder();

    String toString();
}
