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

        @Nested
        class WhenSingleton {

            @BeforeEach
            void addSingleInteger() {
                classUnderTest.enqueue(11);
                preState.enqueue(11);
            }

            @Test
            void isEmpty_singleton_returnsFalse() {
                assertFalse(classUnderTest.isEmpty());
            }

            @Test
            void size_singleton_returnsOne() {
                assertEquals(1, classUnderTest.size());
            }

            @Test
            void first_singleton_returnsFront() {
                assertEquals(11, classUnderTest.first());
            }

            @Test
            void first_singleton_unchanged() {
                classUnderTest.first();
                assertEquals(preState, classUnderTest);
            }

            @Test
            void dequeue_singleton_returnsFront() {
                assertEquals(11, classUnderTest.dequeue());
            }

            @Test
            void dequeue_singleton_emptyStack() {
                classUnderTest.dequeue();
                assertEquals(new ArrayQueue<>(), classUnderTest);
            }

            @Test
            void toString_singleton_correctString() {
                String expected = "Front --> 11, ";
                assertEquals(expected, classUnderTest.toString());
            }
        }
    }
}
