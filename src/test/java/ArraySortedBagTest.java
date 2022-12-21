import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ArraySortedBagTest {
    private ArraySortedBag<Integer> classUnderTest;

    @BeforeEach
    void createStack() {
        classUnderTest = new ArraySortedBag<>();
    }

    @Nested
    class WhenNewEmpty {

        @Test
        void add_successfulAdd_returnsTrue() {
            assertTrue(classUnderTest.add(0));
        }

        @Test
        void remove_empty_throwsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.remove(0));
        }

        @Test
        void removeFirst_empty_throwsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.removeFirst());
        }

        @Test
        void removeLast_empty_throwsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.removeLast());
        }

        @Test
        void first_empty_throwsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.first());
        }

        @Test
        void last_empty_throwsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.last());
        }

        @Test
        void contains_empty_returnsFalse() {
            assertFalse(classUnderTest.contains(0));
        }

        @Test
        void count_empty_returnsZero() {
            assertEquals(0, classUnderTest.count(0));
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
        void iterator_empty_noNext() {
            assertFalse(classUnderTest.iterator().hasNext());
        }

        @Test
        void iterator_empty_nextThrowsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.iterator().next());
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

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class WhenDuplicate {

            }
        }
    }

    @Nested
    class WhenLarge {

        @Test
        void add_large_successfullyExpandsCapacity() {
            for (int i = 0; i < 1000; i++) {
                classUnderTest.add(i);
            }
            assertEquals(1000, classUnderTest.size());
        }
    }
}
