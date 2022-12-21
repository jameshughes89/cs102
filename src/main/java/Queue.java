import java.util.NoSuchElementException;

/**
 * A queue is a linear data structure that has all additions (enqueues) happen at one end (back/tail), and all removals
 * (dequeues) happen at the other end (front/head). Adding and removing from anywhere else but is disallowed. This data
 * structure has a "first in, first out" (FIFO) property --- the first element that was added to the queue would be the
 * first element that gets removed if a remove were to happen.
 *
 * @param <T> Type of elements that are to be in the queue.
 */
public interface Queue<T> {


    /**
     * Adds (enqueues) an element to the queue. The enqueue adds the element at the back of the queue such that it
     * becomes the new last thing in the queue.
     *
     * @param element The item to be enqueued (added) to the queue.
     * @return True if the element was enqueued (added) successfully, false otherwise.
     */
    boolean enqueue(T element);


    /**
     * Removes (dequeues) an element from the queue and returns the removed element. The dequeue removes the element
     * from the front of the queue such that the subsequent element, if it exists, becomes the new front of the queue.
     * If no subsequent element exists, the front will be null and the queue will be empty.
     *
     * @return The element at the front of the queue.
     * @throws NoSuchElementException If removing from an empty queue.
     */
    T dequeue();

    /**
     * Return the element at the front of the queue. Calling first leaves the element at the front of the queue and
     * leaves the queue unchanged.
     *
     * @return The element at the front of the queue.
     * @throws NoSuchElementException If calling first on an empty queue.
     */
    T first();


    /**
     * Checks if the queue is currently empty.
     *
     * @return True if the queue is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the queue. This method does not handle the case of size exceeding
     * Integer.MAX_VALUE.
     *
     * @return The number of elements in the queue.
     */
    int size();
}
