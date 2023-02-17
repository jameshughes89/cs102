import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * A binary tree is a nonlinear data structure. Each node in a binary tree has no more than two children, which are
 * referred to as the left and right children. The relative position of the nodes matter (left vs. right). Additionally,
 * each node has at most one parent node. Only the root node has no parent node.
 *
 * @param <T> Type of elements that are to be in the binary tree.
 */
public interface BinaryTree<T> extends Iterable<T> {

    /**
     * Add an element to the binary tree.
     *
     * @param element Element to be added to the binary tree.
     * @return True if the element was added successfully, false otherwise.
     */
    boolean add(T element);

    /**
     * Removes a single instance of the specified element from the binary tree.
     *
     * @param element Element to be removed from the binary tree.
     * @return True if the element was removed successfully, false otherwise.
     * @throws NoSuchElementException If the provided element does not exist within the binary tree.
     */
    boolean remove(T element);

    /**
     * Returns true if the binary tree contains the specified element.
     *
     * @param element Element whose presence in the binary tree is to be tested.
     * @return True if the element is contained within the binary tree, false otherwise.
     */
    boolean contains(T element);

    /**
     * Returns the number of occurrences of an element contained within the binary tree.
     *
     * @param target Element to be counted.
     * @return Number of times the element can be found in the bag.
     */
    int count(T target);

    /**
     * Returns true if the binary tree contains no elements.
     *
     * @return True if the binary tree is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the binary tree. This method does not handle the case of size exceeding
     * Integer.MAX_VALUE.
     *
     * @return The number of elements in the binary tree.
     */
    int size();

    /**
     * Returns an iterator over the elements in the binary tree.
     *
     * @return An iterator over the elements in the binary tree.
     */
    Iterator<T> iterator();

    /**
     * Returns a pre-order iterator over the elements in the binary tree.
     *
     * @return A pre-order iterator over the elements in the binary tree.
     */
    Iterator<T> preOrderIterator();

    /**
     * Returns an in-order iterator over the elements in the binary tree.
     *
     * @return An in-order iterator over the elements in the binary tree.
     */
    Iterator<T> inOrderIterator();

    /**
     * Returns a post-order iterator over the elements in the binary tree.
     *
     * @return A post-order iterator over the elements in the binary tree.
     */
    Iterator<T> postOrderIterator();

    /**
     * Returns a level-order iterator over the elements in the binary tree.
     *
     * @return A level-order iterator over the elements in the binary tree.
     */
    Iterator<T> levelOrderIterator();
}
