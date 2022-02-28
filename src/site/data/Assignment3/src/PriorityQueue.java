/**
 * A priority queue is a queue that does not follow FIFO ordering. Instead, elements are
 * dequeued in order based on their priority, not their order in the queue. Elements with
 * smaller priorities come first. E.g., if one were to enqueue the following in order:
 * A:7
 * B:2
 * C:8
 * <p>
 * The elements would be dequeued in the order: B, A, C
 * <p>
 * How exactly the data is stored in the queue does not matter; all that matters is that
 * elements with lower priorities are dequeued first. If there are multiple elements with
 * the same priority value, the order they are dequeued does not matter.
 * <p>
 *
 * @param <T> Type of elements in the Priority Queue
 */
public interface PriorityQueue<T> extends Queue<T> {

    /**
     * Add an element to the queue with a specified priority.
     *
     * @param element  Element to be enqueued
     * @param priority Priority associated with the element
     */
    void enqueue(T element, int priority);
}
