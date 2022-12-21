import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

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

            static Stream<Arguments> elementsToAdd() {
                return Stream.of(Arguments.of(0, List.of(0, 10)),
                        Arguments.of(10, List.of(10, 10)),
                        Arguments.of(20, List.of(10, 20)));
            }

            @BeforeEach
            void addSingleton() {
                classUnderTest.add(10);
            }

            @Test
            void add_successfulAdd_returnsTrue() {
                assertTrue(classUnderTest.add(0));
            }

            @ParameterizedTest
            @MethodSource("elementsToAdd")
            void add_singleton_correctLocation(int element, List<Integer> expected) {
                List<Integer> list = new ArrayList<>();
                classUnderTest.add(element);
                while (!classUnderTest.isEmpty()) {
                    list.add(classUnderTest.removeFirst());
                }
                assertEquals(expected, list);
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
                List<Integer> list = new ArrayList<>();
                classUnderTest.iterator().forEachRemaining(list::add);
                assertEquals(List.of(10), list);
            }

            @Test
            void toString_singleton_returnsCorrectString() {
                assertEquals("10, ", classUnderTest.toString());
            }

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class WhenMany {

                static Stream<Arguments> elementsToAdd() {
                    return Stream.of(Arguments.of(0, List.of(0, 10, 20, 30, 40, 50)),
                            Arguments.of(10, List.of(10, 10, 20, 30, 40, 50)),
                            Arguments.of(25, List.of(10, 20, 25, 30, 40, 50)),
                            Arguments.of(60, List.of(10, 20, 30, 40, 50, 60)));
                }

                @BeforeEach
                void addMany() {
                    classUnderTest.add(20);
                    classUnderTest.add(30);
                    classUnderTest.add(40);
                    classUnderTest.add(50);
                }

                @Test
                void add_successfulAdd_returnsTrue() {
                    assertTrue(classUnderTest.add(0));
                }

                @ParameterizedTest
                @MethodSource("elementsToAdd")
                void add_many_correctLocation(int element, List<Integer> expected) {
                    List<Integer> list = new ArrayList<>();
                    classUnderTest.add(element);
                    while (!classUnderTest.isEmpty()) {
                        list.add(classUnderTest.removeFirst());
                    }
                    assertEquals(expected, list);
                }

                @ParameterizedTest
                @CsvSource({"10", "30", "50"})
                void remove_existingElement_returnsTrue(Integer element) {
                    assertTrue(classUnderTest.remove(element));
                }

                @ParameterizedTest
                @CsvSource({"10", "30", "50"})
                void remove_existingElement_removesElement(Integer element) {
                    classUnderTest.remove(element);
                    assertFalse(classUnderTest.contains(element));
                }

                @Test
                void remove_nonexistentElement_throwsNoSuchElementException() {
                    assertThrows(NoSuchElementException.class, () -> classUnderTest.remove(0));
                }

                @Test
                void removeFirst_many_returnsElement() {
                    assertEquals(10, classUnderTest.removeFirst());
                }

                @Test
                void removeFirst_many_removesElement() {
                    classUnderTest.removeFirst();
                    assertFalse(classUnderTest.contains(10));
                }

                @Test
                void removeLast_many_returnsElement() {
                    assertEquals(50, classUnderTest.removeLast());
                }

                @Test
                void removeLast_many_removesElement() {
                    classUnderTest.removeLast();
                    assertFalse(classUnderTest.contains(50));
                }

                @Test
                void first_many_returnsElement() {
                    assertEquals(10, classUnderTest.first());
                }

                @Test
                void last_many_returnsElement() {
                    assertEquals(50, classUnderTest.last());
                }

                @ParameterizedTest
                @CsvSource({"10", "30", "50"})
                void contains_existingElement_returnsTrue(Integer element) {
                    assertTrue(classUnderTest.contains(element));
                }

                @Test
                void contains_nonexistentElement_returnsFalse() {
                    assertFalse(classUnderTest.contains(0));
                }

                @ParameterizedTest
                @CsvSource({"10", "30", "50"})
                void count_existingElement_returnsOne(Integer element) {
                    assertEquals(1, classUnderTest.count(element));
                }

                @Test
                void count_nonexistentElement_returnsZero() {
                    assertEquals(0, classUnderTest.count(0));
                }

                @Test
                void isEmpty_many_returnsFalse() {
                    assertFalse(classUnderTest.isEmpty());
                }

                @Test
                void size_many_returnsCorrectSize() {
                    assertEquals(5, classUnderTest.size());
                }

                @Test
                void iterator_singleton_returnsElementsInCorrectOrder() {
                    List<Integer> list = new ArrayList<>();
                    classUnderTest.iterator().forEachRemaining(list::add);
                    assertEquals(List.of(10, 20, 30, 40, 50), list);
                }

                @Test
                void toString_singleton_returnsCorrectString() {
                    assertEquals("10, 20, 30, 40, 50, ", classUnderTest.toString());
                }
            }

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class WhenDuplicate {

                @BeforeEach
                void addDuplicated() {
                    classUnderTest.add(20);
                    classUnderTest.add(10);
                    classUnderTest.add(20);
                    classUnderTest.add(10);
                    classUnderTest.add(20);
                }

                @Test
                void remove_duplicateElements_removesSingleOccurrence() {
                    classUnderTest.remove(20);
                    assertEquals(2, classUnderTest.count(20));
                }

                @Test
                void count_duplicateElements_returnsCorrectCount() {
                    assertEquals(3, classUnderTest.count(20));
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
