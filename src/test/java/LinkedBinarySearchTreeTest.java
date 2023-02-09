import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedBinarySearchTreeTest {

    LinkedBinarySearchTree<Integer> classUnderTest;
    LinkedBinarySearchTree<Integer> preState;

    @BeforeEach
    void createLinkedBinarySearchTree() {
        classUnderTest = new LinkedBinarySearchTree<>();
        preState = new LinkedBinarySearchTree<>();
    }

    @Nested
    class WhenNewEmpty {

        @Test
        void add_empty_returnsTrue() {
            assertTrue(classUnderTest.add(11));
        }

        @Test
        void remove_empty_throwsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.remove(11));
        }

        @Test
        void removeMin_empty_throwsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.removeMin());
        }

        @Test
        void removeMax_empty_throwsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.removeMax());
        }

        @Test
        void min_empty_throwsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.min());
        }

        @Test
        void max_empty_throwsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.max());
        }

        @Test
        void contains_empty_returnsFalse() {
            assertFalse(classUnderTest.contains(11));
        }

        @Test
        void count_empty_returnsZero() {
            assertEquals(0, classUnderTest.count(11));
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
        void preOrderIterator_empty_noNext() {
            assertFalse(classUnderTest.preOrderIterator().hasNext());
        }

        @Test
        void preOrderIterator_empty_nextThrowsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.preOrderIterator().next());
        }

        @Test
        void inOrderIterator_empty_noNext() {
            assertFalse(classUnderTest.inOrderIterator().hasNext());
        }

        @Test
        void inOrderIterator_empty_nextThrowsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.inOrderIterator().next());
        }

        @Test
        void postOrderIterator_empty_noNext() {
            assertFalse(classUnderTest.postOrderIterator().hasNext());
        }

        @Test
        void postOrderIterator_empty_nextThrowsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.postOrderIterator().next());
        }

        @Test
        void levelOrderIterator_empty_noNext() {
            assertFalse(classUnderTest.levelOrderIterator().hasNext());
        }

        @Test
        void levelOrderIterator_empty_nextThrowsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.levelOrderIterator().next());
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
            void add_singleton_returnsTrue() {
                assertTrue(classUnderTest.add(11));
            }

            @Test
            void remove_existingElement_returnsTrue() {
                assertTrue(classUnderTest.remove(10));
            }

            @Test
            void remove_existingElement_emptyCollection() {
                classUnderTest.remove(10);
                assertEquals(new LinkedBinarySearchTree<>(), classUnderTest);
            }

            @Test
            void remove_nonExistentElement_throwsNoSuchElementException() {
                assertThrows(NoSuchElementException.class, () -> classUnderTest.remove(11));
            }

            @Test
            void removeMin_singleton_returnsElement() {
                assertEquals(10, classUnderTest.removeMin());
            }

            @Test
            void removeMin_singleton_emptyCollection() {
                classUnderTest.removeMin();
                assertEquals(new LinkedBinarySearchTree<>(), classUnderTest);
            }

            @Test
            void removeMax_singleton_returnsElement() {
                assertEquals(10, classUnderTest.removeMax());
            }

            @Test
            void removeMax_singleton_emptyCollection() {
                classUnderTest.removeMax();
                assertEquals(new LinkedBinarySearchTree<>(), classUnderTest);
            }

            @Test
            void min_singleton_returnsElement() {
                assertEquals(10, classUnderTest.min());
            }

            @Test
            void min_singleton_unchanged() {
                classUnderTest.min();
                assertEquals(preState, classUnderTest);
            }

            @Test
            void max_singleton_returnsElement() {
                assertEquals(10, classUnderTest.max());
            }

            @Test
            void max_singleton_unchanged() {
                classUnderTest.max();
                assertEquals(preState, classUnderTest);
            }

            @Test
            void contains_existingElement_returnsTrue() {
                assertTrue(classUnderTest.contains(10));
            }

            @Test
            void contains_nonExistingElement_returnsFalse() {
                assertFalse(classUnderTest.contains(11));
            }

            @Test
            void count_existingElement_returnsOne() {
                assertEquals(1, classUnderTest.count(10));
            }

            @Test
            void count_nonExistingElement_returnsZero() {
                assertEquals(0, classUnderTest.count(11));
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
            void preOrderIterator_singleton_returnsElementsInCorrectOrder() {
                List<Integer> list = new ArrayList<>();
                classUnderTest.preOrderIterator().forEachRemaining(list::add);
                assertEquals(List.of(10), list);
            }

            @Test
            void inOrderIterator_singleton_returnsElementsInCorrectOrder() {
                List<Integer> list = new ArrayList<>();
                classUnderTest.inOrderIterator().forEachRemaining(list::add);
                assertEquals(List.of(10), list);
            }

            @Test
            void postOrderIterator_singleton_returnsElementsInCorrectOrder() {
                List<Integer> list = new ArrayList<>();
                classUnderTest.postOrderIterator().forEachRemaining(list::add);
                assertEquals(List.of(10), list);
            }

            @Test
            void levelOrderIterator_singleton_returnsElementsInCorrectOrder() {
                List<Integer> list = new ArrayList<>();
                classUnderTest.levelOrderIterator().forEachRemaining(list::add);
                assertEquals(List.of(10), list);
            }

            @Test
            void toString_empty_returnsEmptyString() {
                assertEquals("10, ", classUnderTest.toString());
            }

            @Nested
            class WhenMany {

                /**
                 * Elements are such that it checks a leaf (1), internal node with two children (4), internal node
                 * with only a left child (6), internal node with only a right child (8), and the root node (10).
                 *
                 * @return A stream of the elements for testing
                 */
                static Stream<Integer> existingElements() {
                    return Stream.of(1, 4, 6, 8, 10);
                }

                /***
                 * Creates the linked binary search tree such that it looks like the following:
                 *
                 *                  10
                 *                /   \
                 *               7     15
                 *             /  \
                 *            4     8
                 *          /   \    \
                 *         2     6   9
                 *       /  \   /
                 *      1    3  5
                 *
                 */
                @BeforeEach
                void addMany() {
                    classUnderTest.add(15);
                    classUnderTest.add(7);
                    classUnderTest.add(8);
                    classUnderTest.add(9);
                    classUnderTest.add(4);
                    classUnderTest.add(6);
                    classUnderTest.add(5);
                    classUnderTest.add(2);
                    classUnderTest.add(3);
                    classUnderTest.add(1);
                    preState.add(15);
                    preState.add(7);
                    preState.add(8);
                    preState.add(9);
                    preState.add(4);
                    preState.add(6);
                    preState.add(5);
                    preState.add(2);
                    preState.add(3);
                    preState.add(1);
                }

                @Test
                void add_many_returnsTrue() {
                    assertTrue(classUnderTest.add(11));
                }

                @ParameterizedTest
                @MethodSource("existingElements")
                void remove_existingElement_returnsTrue(Integer element) {
                    assertTrue(classUnderTest.remove(element));
                }

                @ParameterizedTest
                @MethodSource("existingElements")
                void remove_existingElement_removesElement(Integer element) {
                    classUnderTest.remove(element);
                    assertFalse(classUnderTest.contains(element));
                }

                @Test
                void remove_nonExistentElement_throwsNoSuchElementException() {
                    assertThrows(NoSuchElementException.class, () -> classUnderTest.remove(11));
                }

                @Test
                void removeMin_many_returnsElement() {
                    assertEquals(1, classUnderTest.removeMin());
                }

                @Test
                void removeMin_many_removesElement() {
                    classUnderTest.removeMin();
                    assertFalse(classUnderTest.contains(1));
                }

                @Test
                void removeMax_many_returnsElement() {
                    assertEquals(15, classUnderTest.removeMax());
                }

                @Test
                void removeMax_many_removesElement() {
                    classUnderTest.removeMax();
                    assertFalse(classUnderTest.contains(15));
                }

                @Test
                void min_many_returnsElement() {
                    assertEquals(1, classUnderTest.min());
                }

                @Test
                void min_many_unchanged() {
                    classUnderTest.min();
                    assertEquals(preState, classUnderTest);
                }

                @Test
                void max_many_returnsElement() {
                    assertEquals(15, classUnderTest.max());
                }

                @Test
                void max_many_unchanged() {
                    classUnderTest.max();
                    assertEquals(preState, classUnderTest);
                }

                @ParameterizedTest
                @MethodSource("existingElements")
                void contains_existingElement_returnsTrue(Integer element) {
                    assertTrue(classUnderTest.contains(element));
                }

                @Test
                void contains_nonExistingElement_returnsFalse() {
                    assertFalse(classUnderTest.contains(11));
                }

                @ParameterizedTest
                @MethodSource("existingElements")
                void count_existingElement_returnsOne(Integer element) {
                    assertEquals(1, classUnderTest.count(element));
                }

                @Test
                void count_nonExistingElement_returnsZero() {
                    assertEquals(0, classUnderTest.count(11));
                }

                @Test
                void isEmpty_many_returnsFalse() {
                    assertFalse(classUnderTest.isEmpty());
                }

                @Test
                void size_many_returnsCorrectSize() {
                    assertEquals(11, classUnderTest.size());
                }

                @Test
                void iterator_many_returnsElementsInCorrectOrder() {
                    List<Integer> list = new ArrayList<>();
                    classUnderTest.iterator().forEachRemaining(list::add);
                    assertEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15), list);
                }

                @Test
                void preOrderIterator_many_returnsElementsInCorrectOrder() {
                    List<Integer> list = new ArrayList<>();
                    classUnderTest.preOrderIterator().forEachRemaining(list::add);
                    assertEquals(List.of(10, 7, 4, 2, 1, 3, 6, 5, 8, 9, 15), list);
                }

                @Test
                void inOrderIterator_many_returnsElementsInCorrectOrder() {
                    List<Integer> list = new ArrayList<>();
                    classUnderTest.inOrderIterator().forEachRemaining(list::add);
                    assertEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15), list);
                }

                @Test
                void postOrderIterator_many_returnsElementsInCorrectOrder() {
                    List<Integer> list = new ArrayList<>();
                    classUnderTest.postOrderIterator().forEachRemaining(list::add);
                    assertEquals(List.of(1, 3, 2, 5, 6, 4, 9, 8, 7, 15, 10), list);
                }

                @Test
                void levelOrderIterator_many_returnsElementsInCorrectOrder() {
                    List<Integer> list = new ArrayList<>();
                    classUnderTest.levelOrderIterator().forEachRemaining(list::add);
                    assertEquals(List.of(10, 7, 15, 4, 8, 2, 6, 9, 1, 3, 5), list);
                }

                @Test
                void toString_empty_returnsEmptyString() {
                    assertEquals("1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15, ", classUnderTest.toString());
                }
            }
        }
    }
}
