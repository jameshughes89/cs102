import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayIndexedBagTest {


    private ArrayIndexedBag<Integer> classUnderTest;
    private ArrayIndexedBag<Integer> preState;

    @BeforeEach
    void createStack() {
        classUnderTest = new ArrayIndexedBag<>();
        preState = new ArrayIndexedBag<>();
    }

    @Nested
    class WhenNewEmpty {

        @Test
        void add_elementArgument_returnsTrue() {
            assertTrue(classUnderTest.add(0));
        }

        @Test
        void add_validIndex_returnsTrue() {
            assertTrue(classUnderTest.add(0, 0));
        }

        @Test
        void add_negativeIndex_throwsIndexOutOfBoundsException() {
            assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.add(-1, 0));
        }

        @Test
        void add_tooLargeIndex_throwsIndexOutOfBoundsException() {
            assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.add(1, 0));
        }

        @Test
        void set_negativeIndex_throwsIndexOutOfBoundsException() {
            assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.set(-1, 0));
        }

        @Test
        void set_tooLargeIndex_throwsIndexOutOfBoundsException() {
            assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.set(0, 0));
        }

        @Test
        void get_negativeIndex_throwsIndexOutOfBoundsException() {
            assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.get(-1));
        }

        @Test
        void get_tooLargeIndex_throwsIndexOutOfBoundsException() {
            assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.get(0));
        }

        @Test
        void remove_negativeIndex_throwsIndexOutOfBoundsException() {
            assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.remove(-1));
        }

        @Test
        void remove_tooLargeIndex_throwsIndexOutOfBoundsException() {
            assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.remove(0));
        }

        @Test
        void remove_nonexistentElement_throwsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.remove(Integer.valueOf(0)));
        }

        @Test
        void indexOf_nonexistentElement_throwsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.indexOf(0));
        }

        @Test
        void contains_nonexistentElement_returnsFalse() {
            assertFalse(classUnderTest.contains(0));
        }

        @Test
        void count_nonexistentElement_returnsZero() {
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
                preState.add(10);
            }

            @Test
            void add_elementArgument_returnsTrue() {
                assertTrue(classUnderTest.add(0));
            }

            @Test
            void add_validIndex_returnsTrue() {
                assertTrue(classUnderTest.add(0, 0));
            }

            @Test
            void add_negativeIndex_throwsIndexOutOfBoundsException() {
                assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.add(-1, 0));
            }

            @Test
            void add_tooLargeIndex_throwsIndexOutOfBoundsException() {
                assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.add(2, 0));
            }

            @Test
            void set_validIndex_returnsOriginalElement() {
                assertEquals(10, classUnderTest.set(0, 0));
            }

            @Test
            void set_validIndex_changesElement() {
                classUnderTest.set(0, 0);
                assertEquals(0, classUnderTest.get(0));
            }

            @Test
            void set_negativeIndex_throwsIndexOutOfBoundsException() {
                assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.set(-1, 0));
            }

            @Test
            void set_tooLargeIndex_throwsIndexOutOfBoundsException() {
                assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.set(1, 0));
            }

            @Test
            void get_validIndex_returnsElement() {
                assertEquals(10, classUnderTest.get(0));
            }

            @Test
            void get_negativeIndex_throwsIndexOutOfBoundsException() {
                assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.get(-1));
            }

            @Test
            void get_tooLargeIndex_throwsIndexOutOfBoundsException() {
                assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.get(1));
            }

            @Test
            void remove_validIndex_returnsElement() {
                assertEquals(10, classUnderTest.remove(0));
            }

            @Test
            void remove_validIndex_emptyCollection() {
                classUnderTest.remove(0);
                assertEquals(new ArrayIndexedBag<Integer>(), classUnderTest);
            }

            @Test
            void remove_negativeIndex_throwsIndexOutOfBoundsException() {
                assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.remove(-1));
            }

            @Test
            void remove_tooLargeIndex_throwsIndexOutOfBoundsException() {
                assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.remove(1));
            }

            @Test
            void remove_existingElement_returnsTrue() {
                assertTrue(classUnderTest.remove(Integer.valueOf(10)));
            }

            @Test
            void remove_existingElement_emptyCollection() {
                classUnderTest.remove(Integer.valueOf(10));
                assertEquals(new ArrayIndexedBag<Integer>(), classUnderTest);
            }

            @Test
            void remove_nonexistentElement_throwsNoSuchElementException() {
                assertThrows(NoSuchElementException.class, () -> classUnderTest.remove(Integer.valueOf(0)));
            }

            @Test
            void indexOf_existingElement_returnsCorrectIndex() {
                assertEquals(0, classUnderTest.indexOf(10));
            }

            @Test
            void indexOf_nonexistentElement_throwsNoSuchElementException() {
                assertThrows(NoSuchElementException.class, () -> classUnderTest.indexOf(0));
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
            void iterator_singleton_hasNextTrueOnce() {
                Iterator<Integer> iterator = classUnderTest.iterator();
                assertTrue(iterator.hasNext());
                iterator.next();
                assertFalse(iterator.hasNext());
            }

            @Test
            void iterator_singleton_nextReturnsCorrectElements() {
                Iterator<Integer> iterator = classUnderTest.iterator();
                assertEquals(10, iterator.next());
                assertThrows(NoSuchElementException.class, () -> iterator.next());
            }

            @Test
            void toString_singleton_returnsCorrectString() {
                assertEquals("10, ", classUnderTest.toString());
            }

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class WhenMany {

                @BeforeEach
                void addMany() {
                    // add both ways
                }
            }

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class WhenDuplicate {

                @BeforeEach
                void addDuplicated() {

                }

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
