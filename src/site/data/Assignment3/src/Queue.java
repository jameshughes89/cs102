public interface Queue<T> {

    /**
     * Enqueues (adds) an item to the end of the queue. After the method completes
     * the item added will be the thing at the end of the queue
     *
     * @param element The item to be enqueued (added) to the end of the queue.
     */
    void enqueue(T element);

    /**
     * Dequeues (removes) the item at the front of the queue and returns it as the value
     * of this method. After the method completes, the item after the front will be the
     * new front if it exists, otherwise the queue will be empty.
     *
     * @return The item at the front of the queue.
     */
    T dequeue();

    /**
     * Looks at the item at the front of the queue and returns it as the value
     * of this method. After the method completes, the item will still be at the
     * front of the queue.
     *
     * @return The item at the front of the queue.
     */
    T first();

    /**
     * Tests if the queue is empty and returns a Boolean.
     *
     * @return true if the queue is empty (no items), false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the queue. This method does not handle
     * the size exceeding Integer.MAX_VALUE.
     *
     * @return The number of elements in the queue.
     */
    int size();
}
