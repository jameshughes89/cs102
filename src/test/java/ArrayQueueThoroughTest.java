import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueThoroughTest {

    private Queue<Integer> classUnderTest;
    private Queue<Integer> preState;

    @BeforeEach
    void newQueue() {
        classUnderTest = new ArrayQueue<>();
        preState = new ArrayQueue<>();
    }

    @Nested
    class WhenNewEmpty {

        @Test
        void isEmpty_empty_returnsTrue() {
            assertTrue(classUnderTest.isEmpty());
        }

        @Test
        void size_empty_returnsZero() {
            assertEquals(0, classUnderTest.size());
        }

        @Test
        void first_empty_throwsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.first());
        }

        @Test
        void dequeue_empty_throwsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.dequeue());
        }

        @Test
        void toString_empty_returnsStringFront() {
            String expected = "Front --> ";
            assertEquals(expected, classUnderTest.toString());
        }
    }
}
