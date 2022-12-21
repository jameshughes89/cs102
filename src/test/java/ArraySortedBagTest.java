import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

            @BeforeEach
            void addSingleton() {
                classUnderTest.add(10);
            }

            @Test
            void add_successfulAdd_returnsTrue() {
                assertTrue(classUnderTest.add(0));
            }

            @Test
            void add_singleton_correctLocation() {
                // UNIMPLEMENTED --- HOW DO? THINK LATER?
            }

            @Test
            void remove_existingElement_returnsTrue() {
                assertTrue(classUnderTest.remove(10));
            }

            @Test
            void remove_existingElement_emptyCollection() {
                classUnderTest.remove(10);
                assertEquals(new ArraySortedBag<Integer>(), classUnderTest);
            }

            @Test
            void remove_nonexistentElement_throwsNoSuchElementException() {
                assertThrows(NoSuchElementException.class, () -> classUnderTest.remove(0));
            }

            @Test
            void removeFirst_singleton_returnsElement() {
                assertEquals(10, classUnderTest.removeFirst());
            }

            @Test
            void removeFirst_singleton_emptyCollection() {
                classUnderTest.removeFirst();
                assertEquals(new ArraySortedBag<Integer>(), classUnderTest);
            }

            @Test
            void removeLast_singleton_returnsElement() {
                assertEquals(10, classUnderTest.removeLast());
            }

            @Test
            void removeLast_singleton_emptyCollection() {
                classUnderTest.removeLast();
                assertEquals(new ArraySortedBag<Integer>(), classUnderTest);
            }

            @Test
            void first_singleton_returnsElement() {
                assertEquals(10, classUnderTest.first());
            }

            @Test
            void last_singleton_returnsElement() {
                assertEquals(10, classUnderTest.last());
            }

            @Test
            void contains_existingElement_returnsTrue() {
                assertTrue(classUnderTest.contains(10));
            }

            @Test
            void contains_nonexistentElement_returnsFalse() {
                assertFalse(classUnderTest.contains(0));
            }

            @Test
            void count_existingElement_returnsOne() {
                assertEquals(1, classUnderTest.count(10));
            }

            @Test
            void count_nonexistentElement_returnsZero() {
                assertEquals(0, classUnderTest.count(0));
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
            void iterator_singleton_returnsElementsInCorrectOrder() {
                Iterator<Integer> iterator = classUnderTest.iterator();
                List<Integer> expected = List.of(10);
                List<Integer> list = new ArrayList<>();
                while (iterator.hasNext()) {
                    list.add(iterator.next());
                }
                assertEquals(expected, list);
            }

            @Test
            void toString_singleton_returnsCorrectString() {
                assertEquals("10, ", classUnderTest.toString());
            }

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
