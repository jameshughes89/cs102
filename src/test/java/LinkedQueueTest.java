import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedQueueTest {

    @Test
    @DisplayName("A new queue starts empty.")
    void aNewQueueIsEmpty() {
        Queue<Integer> queue = new LinkedQueue<>();
        assertTrue(queue.isEmpty());
    }

    @Test
    @DisplayName("An empty queue has size 0.")
    void emptyQueueHasSizeZero() {
        Queue<Integer> queue = new LinkedQueue<>();
        assertEquals(0, queue.size());
    }

    @Test
    @DisplayName("isEmpty return false when it is non empty.")
    void nonEmptyQueueIsEmptyReturnsFalse() {
        Queue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(99);
        assertFalse(queue.isEmpty());
    }

    @Test
    @DisplayName("Enqueuing items updates the size of the queue.")
    void enqueuingUpdatesSize() {
        Queue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(99);
        queue.enqueue(101);
        assertEquals(2, queue.size());
    }

}
