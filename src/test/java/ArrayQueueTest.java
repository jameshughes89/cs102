import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest {

    private ArrayQueue<Integer> classUnderTest;
    private ArrayQueue<Integer> preState;

    @BeforeEach
    void createStack() {
        classUnderTest = new ArrayQueue<>();
        preState = new ArrayQueue<>();
    }

    @Nested
    class WhenNewEmpty {

        @Test
        void enqueue_successfullyAdds_returnsTrue() {
            assertTrue(classUnderTest.enqueue(11));
        }

        @Test
        void enqueue_empty_newTop() {
            classUnderTest.enqueue(11);
            assertEquals(11, classUnderTest.first());
        }

        @Test
        void dequeue_empty_throwsEmptyCollectionException() {
            assertThrows(EmptyCollectionException.class, () -> classUnderTest.dequeue());
        }

        @Test
        void first_empty_throwsEmptyCollectionException() {
            assertThrows(EmptyCollectionException.class, () -> classUnderTest.first());
        }

        @Test
        void isEmpty_empty_returnsTrue() {
            assertTrue(classUnderTest.isEmpty());
        }

        @Test
        void size_empty_returnsZero() {
            assertEquals(0, classUnderTest.size());
        }

        @Test
        void toString_empty_returnsEmptyString() {
            assertEquals("", classUnderTest.toString());
        }

        @Nested
        class WhenSingleton {

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class WhenMany {

            }
        }

    }

    @Nested
    class WhenLarge {
        @Test
        void push_large_successfullyExpandsCapacity() {
            for (int i = 0; i < 1000; i++) {
                classUnderTest.enqueue(i);
            }
            assertEquals(1000, classUnderTest.size());
        }
    }
}
