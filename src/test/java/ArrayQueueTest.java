import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest {

    @Test
    @DisplayName("A new queue starts empty.")
    void aNewQueueIsEmpty() {
        Queue<Integer> queue = new ArrayQueue<>();
        assertTrue(queue.isEmpty());
    }

    @Test
    @DisplayName("An empty queue has size 0.")
    void emptyQueueHasSizeZero() {
        Queue<Integer> queue = new ArrayQueue<>();
        assertEquals(0, queue.size());
    }

    @Test
    @DisplayName("isEmpty return false when it is non empty.")
    void nonEmptyQueueIsEmptyReturnsFalse() {
        Queue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(99);
        assertFalse(queue.isEmpty());
    }

    @Test
    @DisplayName("Enqueuing items updates the size of the queue.")
    void enqueuingUpdatesSize() {
        Queue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(99);
        queue.enqueue(101);
        assertEquals(2, queue.size());
    }

    @Test
    @DisplayName("Enqueuing one item results in it being the first.")
    void enqueuingOneItemIsFirst() {
        Queue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(99);
        assertEquals(99, queue.first());
    }

    @Test
    @DisplayName("Enqueuing 6 elements into the queue expands capacity.")
    void enqueuingBeyondCapacityCallsExpandCapacityToMakeRoom() {
        Queue<Integer> queue = new ArrayQueue<>(5);
        for (int i = 0; i < 6; ++i) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 5; ++i) {
            queue.dequeue();
        }
        // After 6 enqueues, expandCapacity is called
        // After 5 dequeues, the 6th element will be first
        assertEquals(5, queue.first());
    }

    @Test
    @DisplayName("Enqueueing and Dequeuing returns in FIFO order.")
    void enqueueingAndDequeuingReturnsElementsInFIFOOrder() {
        Queue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 6; ++i) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 6; ++i) {
            assertEquals(i, queue.dequeue());
        }
    }

    @Test
    @DisplayName("Dequeuing throws NoSuchElementException when queue is empty.")
    void dequeueEmptyQueueThrowsException() {
        Queue<Integer> queue = new ArrayQueue<>();
        assertThrows(NoSuchElementException.class, () -> queue.dequeue());
    }

    @Test
    @DisplayName("First throws NoSuchElementException when queue is empty.")
    void firstEmptyQueueThrowsException() {
        Queue<Integer> queue = new ArrayQueue<>();
        assertThrows(NoSuchElementException.class, () -> queue.first());
    }
}
