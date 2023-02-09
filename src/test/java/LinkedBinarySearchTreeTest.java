import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedBinarySearchTreeTest {

    LinkedBinarySearchTree<Integer> classUnderTest;
    LinkedBinarySearchTree<Integer> preState;

    @BeforeEach
    void createLinkedBinarySearchTree() {
        classUnderTest = new LinkedBinarySearchTree<>();
        preState = new LinkedBinarySearchTree<>();
    }

    @Test
    void add_singleton_returnsTrue() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(10);
        assertTrue(bst.add(11));
    }

    @Test
    void add_many_returnsTrue() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(10);
        bst.add(20);
        bst.add(30);
        bst.add(40);
        bst.add(50);
        assertTrue(bst.add(11));
    }

    @Test
    void remove_singleton_returnsTrue() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(10);
        assertTrue(bst.remove(10));
    }

    @Test
    void remove_many_returnsTrue() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(10);
        bst.add(20);
        bst.add(30);
        bst.add(40);
        bst.add(50);
        assertTrue(bst.remove(10));
    }


    @Test
    void isEmptyOnNewTreeNonDefaultConstructorReturnsFalse() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>(99);
        assertFalse(bst.isEmpty());
    }

    @Test
    void isEmptyOnNonEmptyTreeReturnsFalse() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        assertFalse(bst.isEmpty());
    }

    @Test
    void sizeOfNewTreeNonDefaultConstructorReturnsOne() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>(99);
        assertEquals(1, bst.size());
    }

    @Test
    void sizeOfTreeWithOneElementReturnsOne() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        assertEquals(1, bst.size());
    }

    @Test
    void sizeOfBinarySearchTreeWithMultipleElementReturnsCorrectSize() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(101);
        bst.add(11);
        bst.add(44);
        assertEquals(4, bst.size());
    }

    @Test
    void containsOnTreeWhenSearchingForNonExistingElementReturnsFalse() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        assertFalse(bst.contains(101));
    }

    @Test
    void containsOnTreeWhenSearchingForSingleEqualElementReturnsTrue() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        assertTrue(bst.contains(99));
    }

    @Test
    void containsOnTreeWhenSearchingForMultipleEqualElementsReturnsTrue() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(99);
        bst.add(99);
        assertTrue(bst.contains(99));
    }


    @Test
    void countOnTreeWhenCountingNonExistingElementsReturnsZero() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        assertEquals(0, bst.count(101));
    }

    @Test
    void countOnTreeWhenCountingSingleEqualElementsReturnsOne() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(55);
        bst.add(101);
        assertEquals(1, bst.count(99));
    }

    @Test
    void countOnTreeWhenCountingMultipleEqualElementsReturnsOne() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(55);
        bst.add(101);
        bst.add(99);
        bst.add(99);
        bst.add(99);
        bst.add(99);
        assertEquals(5, bst.count(99));
    }

    @Test
    void minOnTreeWhenMinIsRootReturnsCorrectMin() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        assertEquals(99, bst.min());
    }

    @Test
    void minOnTreeWhenMinIsInternalNodeReturnsCorrectMin() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(55);
        bst.add(77);
        assertEquals(55, bst.min());
    }

    @Test
    void minOnTreeWhenMinIsLeafNodeReturnsCorrectMin() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(55);
        bst.add(77);
        bst.add(22);
        assertEquals(22, bst.min());
    }

    @Test
    void minOnTreeWhenMultipleEqualMinValuesExistReturnsCorrectMin() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(55);
        bst.add(77);
        bst.add(22);
        bst.add(22);
        bst.add(22);
        bst.add(22);
        bst.add(22);
        assertEquals(22, bst.min());
    }

    @Test
    void minOnTreeLeavesElementInBinarySearchTree() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(55);
        bst.add(77);
        bst.add(22);
        bst.min();
        assertTrue(bst.contains(bst.min()));
    }

    @Test
    void maxOnTreeWhenMaxIsRootReturnsCorrectMax() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        assertEquals(99, bst.max());
    }

    @Test
    void maxOnTreeWhenMaxIsInternalNodeReturnsCorrectMax() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(55);
        bst.add(99);
        bst.add(77);
        assertEquals(99, bst.max());
    }

    @Test
    void maxOnTreeWhenMaxIsLeafNodeReturnsCorrectMax() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(22);
        bst.add(55);
        bst.add(77);
        bst.add(99);
        assertEquals(99, bst.max());
    }

    @Test
    void maxOnTreeWhenMultipleEqualMaxValuesExistReturnsCorrectMax() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(55);
        bst.add(77);
        bst.add(22);
        bst.add(99);
        bst.add(99);
        bst.add(99);
        bst.add(99);
        assertEquals(99, bst.max());
    }

    @Test
    void maxOnTreeLeavesElementInBinarySearchTree() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(55);
        bst.add(77);
        bst.add(22);
        bst.max();
        assertTrue(bst.contains(bst.max()));
    }


    @Test
    void removeMinOnTreeWhenMinIsRootReturnsCorrectMin() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(101);
        assertEquals(99, bst.removeMin());
    }

    @Test
    void removeMinOnTreeWhenMinIsInternalNodeReturnsCorrectMin() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(55);
        bst.add(77);
        assertEquals(55, bst.removeMin());
    }

    @Test
    void removeMinOnTreeWhenMinIsLeafNodeReturnsCorrectMin() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(55);
        bst.add(77);
        bst.add(22);
        assertEquals(22, bst.removeMin());
    }

    @Test
    void removeMinOnTreeWhenMultipleEqualMinValuesExistReturnsCorrectMin() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(55);
        bst.add(77);
        bst.add(22);
        bst.add(22);
        bst.add(22);
        bst.add(22);
        bst.add(22);
        assertEquals(22, bst.removeMin());
    }

    @Test
    void removeMinOnTreeWithSingleMinRemovesElementFromBinarySearchTree() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(55);
        bst.add(77);
        bst.add(22);
        bst.removeMin();
        assertFalse(bst.contains(22));
    }

    @Test
    void removeMinOnTreeWithManyMinRemovesOnlyOneElementFromBinarySearchTree() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(55);
        bst.add(77);
        bst.add(22);
        bst.add(22);
        bst.add(22);
        bst.removeMin();
        assertEquals(2, bst.count(22));
    }

    @Test
    void removeMinOnTreeUpdatesSize() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(55);
        bst.add(77);
        bst.add(22);
        bst.removeMin();
        assertEquals(3, bst.size());
    }

    @Test
    void multipleRemoveMinCallsOnTreeReturnsElementsInCorrectOrder() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(50);
        bst.add(25);
        bst.add(75);
        bst.add(37);
        bst.add(12);
        bst.add(62);
        bst.add(87);
        assertEquals(12, bst.removeMin());
        assertEquals(25, bst.removeMin());
        assertEquals(37, bst.removeMin());
        assertEquals(50, bst.removeMin());
        assertEquals(62, bst.removeMin());
        assertEquals(75, bst.removeMin());
        assertEquals(87, bst.removeMin());
    }

    @Test
    void removeMaxOnTreeWhenMaxIsRootReturnsCorrectMax() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(101);
        bst.add(99);
        assertEquals(101, bst.removeMax());
    }

    @Test
    void removeMaxOnTreeWhenMaxIsInternalNodeReturnsCorrectMax() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(55);
        bst.add(99);
        bst.add(77);
        assertEquals(99, bst.removeMax());
    }

    @Test
    void removeMaxOnTreeWhenMaxIsLeafNodeReturnsCorrectMax() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(22);
        bst.add(55);
        bst.add(33);
        bst.add(99);
        assertEquals(99, bst.removeMax());
    }

    @Test
    void removeMaxOnTreeWhenMultipleEqualMaxValuesExistReturnsCorrectMax() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(22);
        bst.add(55);
        bst.add(33);
        bst.add(99);
        bst.add(99);
        bst.add(99);
        bst.add(99);
        bst.add(99);
        assertEquals(99, bst.removeMax());
    }

    @Test
    void removeMaxOnTreeWithSingleMaxRemovesElementFromBinarySearchTree() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(22);
        bst.add(55);
        bst.add(33);
        bst.add(99);
        bst.removeMax();
        assertFalse(bst.contains(99));
    }

    @Test
    void removeMaxOnTreeWithManyMaxRemovesOnlyOneElementFromBinarySearchTree() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(22);
        bst.add(99);
        bst.add(55);
        bst.add(33);
        bst.add(99);
        bst.removeMax();
        assertEquals(2, bst.count(99));
    }

    @Test
    void removeMaxOnTreeUpdatesSize() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(55);
        bst.add(77);
        bst.add(22);
        bst.removeMax();
        assertEquals(3, bst.size());
    }

    @Test
    void multipleRemoveMaxCallsOnTreeReturnsElementsInCorrectOrder() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(50);
        bst.add(25);
        bst.add(75);
        bst.add(37);
        bst.add(12);
        bst.add(62);
        bst.add(87);
        assertEquals(87, bst.removeMax());
        assertEquals(75, bst.removeMax());
        assertEquals(62, bst.removeMax());
        assertEquals(50, bst.removeMax());
        assertEquals(37, bst.removeMax());
        assertEquals(25, bst.removeMax());
        assertEquals(12, bst.removeMax());
    }

    @Test
    void removeNonExistingElementOnTreeThrowsException() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        assertThrows(NoSuchElementException.class, () -> bst.remove(101));
    }

    @Test
    void removeOnTreeWithSingleEqualElementRemovesElementFromBinarySearchTree() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(50);
        bst.add(25);
        bst.add(75);
        bst.add(37);
        bst.add(12);
        bst.add(62);
        bst.add(87);
        bst.remove(50);
        assertFalse(bst.contains(50));
    }

    @Test
    void removeOnTreeWithManyEqualElementsRemovesOnlyOneElementFromBinarySearchTree() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(50);
        bst.add(25);
        bst.add(75);
        bst.add(37);
        bst.add(12);
        bst.add(37);
        bst.add(62);
        bst.add(37);
        bst.add(87);
        bst.remove(37);
        assertEquals(2, bst.count(37));
    }

    @Test
    void removeOnTreeUpdatesSize() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(50);
        bst.add(25);
        bst.add(75);
        bst.add(37);
        bst.add(12);
        bst.add(62);
        bst.add(87);
        bst.remove(37);
        assertEquals(6, bst.size());
    }

    @Test
    void addSingleElementToTreeResultsInItBeingTheOnlyElement() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        Iterator<Integer> it = bst.iterator();
        assertEquals(99, it.next());
    }

    @Test
    void addManyElementsToTreeResultsInElementsBeingPlacedInCorrectPlace() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(50);
        bst.add(25);
        bst.add(75);
        bst.add(37);
        bst.add(12);
        bst.add(62);
        bst.add(87);
        Iterator<Integer> it = bst.iterator();
        assertEquals(12, it.next());
        assertEquals(25, it.next());
        assertEquals(37, it.next());
        assertEquals(50, it.next());
        assertEquals(62, it.next());
        assertEquals(75, it.next());
        assertEquals(87, it.next());
    }

    @Test
    void addAndRemoveManyElementsToTreeResultsInElementsBeingPlacedInCorrectPlace() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(50);
        bst.add(25);
        bst.add(75);
        bst.add(37);
        bst.add(12);
        bst.add(62);
        bst.add(87);
        bst.add(87);
        bst.remove(50);
        bst.remove(25);
        bst.add(25);
        bst.remove(75);
        bst.remove(37);
        bst.add(75);
        bst.add(37);
        bst.remove(12);
        bst.remove(62);
        bst.remove(87);
        bst.add(12);
        bst.add(50);
        bst.add(62);
        Iterator<Integer> it = bst.iterator();
        assertEquals(12, it.next());
        assertEquals(25, it.next());
        assertEquals(37, it.next());
        assertEquals(50, it.next());
        assertEquals(62, it.next());
        assertEquals(75, it.next());
        assertEquals(87, it.next());
    }

    @Test
    void iteratorHasOneElementForTreeWithOneElement() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        Iterator<Integer> it = bst.iterator();
        assertEquals(99, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void iteratorNextOnNonEmptyTreeReturnsElementsInCorrectOrder() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(50);
        bst.add(25);
        bst.add(75);
        bst.add(37);
        bst.add(12);
        bst.add(62);
        bst.add(87);
        Iterator<Integer> it = bst.iterator();
        int[] valueOrder = {12, 25, 37, 50, 62, 75, 87};
        int currentIndex = 0;
        while (it.hasNext()) {
            assertEquals(it.next(), valueOrder[currentIndex]);
            currentIndex++;
        }
        assertThrows(NoSuchElementException.class, () -> it.next());
    }


    @Test
    void preOrderIteratorHasOneElementForTreeWithOneElement() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        Iterator<Integer> it = bst.preOrderIterator();
        assertEquals(99, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void preOrderIteratorNextOnNonEmptyTreeReturnsElementsInCorrectOrder() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(50);
        bst.add(25);
        bst.add(75);
        bst.add(37);
        bst.add(12);
        bst.add(62);
        bst.add(87);
        Iterator<Integer> it = bst.preOrderIterator();
        int[] valueOrder = {50, 25, 12, 37, 75, 62, 87};
        int currentIndex = 0;
        while (it.hasNext()) {
            assertEquals(it.next(), valueOrder[currentIndex]);
            currentIndex++;
        }
        assertThrows(NoSuchElementException.class, () -> it.next());
    }

    @Test
    void inOrderIteratorHasOneElementForTreeWithOneElement() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        Iterator<Integer> it = bst.inOrderIterator();
        assertEquals(99, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void inOrderIteratorNextOnNonEmptyTreeReturnsElementsInCorrectOrder() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(50);
        bst.add(25);
        bst.add(75);
        bst.add(37);
        bst.add(12);
        bst.add(62);
        bst.add(87);
        Iterator<Integer> it = bst.inOrderIterator();
        int[] valueOrder = {12, 25, 37, 50, 62, 75, 87};
        int currentIndex = 0;
        while (it.hasNext()) {
            assertEquals(it.next(), valueOrder[currentIndex]);
            currentIndex++;
        }
        assertThrows(NoSuchElementException.class, () -> it.next());
    }


    @Test
    void postOrderIteratorHasOneElementForTreeWithOneElement() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        Iterator<Integer> it = bst.postOrderIterator();
        assertEquals(99, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void postOrderIteratorNextOnNonEmptyTreeReturnsElementsInCorrectOrder() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(50);
        bst.add(25);
        bst.add(75);
        bst.add(37);
        bst.add(12);
        bst.add(62);
        bst.add(87);
        Iterator<Integer> it = bst.postOrderIterator();
        int[] valueOrder = {12, 37, 25, 62, 87, 75, 50};
        int currentIndex = 0;
        while (it.hasNext()) {
            assertEquals(it.next(), valueOrder[currentIndex]);
            currentIndex++;
        }
        assertThrows(NoSuchElementException.class, () -> it.next());
    }


    @Test
    void levelOrderIteratorHasOneElementForTreeWithOneElement() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        Iterator<Integer> it = bst.levelOrderIterator();
        assertEquals(99, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void levelOrderIteratorNextOnNonEmptyTreeReturnsElementsInCorrectOrder() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(50);
        bst.add(25);
        bst.add(75);
        bst.add(37);
        bst.add(12);
        bst.add(62);
        bst.add(87);
        Iterator<Integer> it = bst.levelOrderIterator();
        int[] valueOrder = {50, 25, 75, 12, 37, 62, 87};
        int currentIndex = 0;
        while (it.hasNext()) {
            assertEquals(it.next(), valueOrder[currentIndex]);
            currentIndex++;
        }
        assertThrows(NoSuchElementException.class, () -> it.next());
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
        class Singleton {

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
        }
    }
}
