import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedBinarySearchTreeTest {

    @Test
    void isEmptyOnNewLinkedBinarySearchTreeReturnsTrue() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        assertTrue(bst.isEmpty());
    }

    @Test
    void isEmptyOnNonEmptyLinkedBinarySearchTreeReturnsFalse() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        assertFalse(bst.isEmpty());
    }

    @Test
    void sizeOfEmptyLinkedBinarySearchTreeReturnsZero() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        assertEquals(0, bst.size());
    }

    @Test
    void sizeOfBinarySearchTreeWithOneElementReturnsOne() {
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
    void containsOnEmptyLinkedBinarySearchTreeReturnsFalse() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        assertFalse(bst.contains(99));
    }

    @Test
    void containsOnLinkedBinarySearchTreeWhenSearchingForNonExistingElementReturnsFalse() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        assertFalse(bst.contains(101));
    }

    @Test
    void containsOnLinkedBinarySearchTreeWhenSearchingForSingleEqualElementReturnsTrue() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        assertTrue(bst.contains(99));
    }

    @Test
    void containsOnLinkedBinarySearchTreeWhenSearchingForMultipleEqualElementsReturnsTrue() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(99);
        bst.add(99);
        assertTrue(bst.contains(99));
    }

    @Test
    void getCountOnEmptyLinkedBinarySearchTreeReturnsZero() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        assertEquals(0, bst.getCount(99));
    }

    @Test
    void getCountOnLinkedBinarySearchTreeWhenCountingNonExistingElementsReturnsZero() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        assertEquals(0, bst.getCount(101));
    }

    @Test
    void getCountOnLinkedBinarySearchTreeWhenCountingSingleEqualElementsReturnsOne() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(55);
        bst.add(101);
        assertEquals(1, bst.getCount(99));
    }

    @Test
    void getCountOnLinkedBinarySearchTreeWhenCountingMultipleEqualElementsReturnsOne() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(55);
        bst.add(101);
        bst.add(99);
        bst.add(99);
        bst.add(99);
        bst.add(99);
        assertEquals(5, bst.getCount(99));
    }

    @Test
    void minOnEmptyLinkedBinarySearchTreeThrowsException() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        assertThrows(NoSuchElementException.class, () -> bst.min());
    }

    @Test
    void minOnLinkedBinarySearchTreeWhenMinIsRootReturnsCorrectMin() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        assertEquals(99, bst.min());
    }

    @Test
    void minOnLinkedBinarySearchTreeWhenMinIsInternalNodeReturnsCorrectMin() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(55);
        bst.add(77);
        assertEquals(55, bst.min());
    }

    @Test
    void minOnLinkedBinarySearchTreeWhenMinIsLeafNodeReturnsCorrectMin() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(55);
        bst.add(77);
        bst.add(22);
        assertEquals(22, bst.min());
    }

    @Test
    void minOnLinkedBinarySearchTreeWhenMultipleEqualMinValuesExistReturnsCorrectMin() {
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
    void minOnLinkedBinarySearchTreeLeavesElementInBinarySearchTree() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(55);
        bst.add(77);
        bst.add(22);
        bst.min();
        assertTrue(bst.contains(22));
    }

    @Test
    void maxOnEmptyLinkedBinarySearchTreeThrowsException() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        assertThrows(NoSuchElementException.class, () -> bst.max());
    }

    @Test
    void maxOnLinkedBinarySearchTreeWhenMaxIsRootReturnsCorrectMax() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        assertEquals(99, bst.max());
    }

    @Test
    void maxOnLinkedBinarySearchTreeWhenMaxIsInternalNodeReturnsCorrectMax() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(55);
        bst.add(99);
        bst.add(77);
        assertEquals(99, bst.max());
    }

    @Test
    void maxOnLinkedBinarySearchTreeWhenMaxIsLeafNodeReturnsCorrectMax() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(22);
        bst.add(55);
        bst.add(77);
        bst.add(99);
        assertEquals(99, bst.max());
    }

    @Test
    void maxOnLinkedBinarySearchTreeWhenMultipleEqualMaxValuesExistReturnsCorrectMax() {
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
    void maxOnLinkedBinarySearchTreeLeavesElementInBinarySearchTree() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(55);
        bst.add(77);
        bst.add(22);
        bst.max();
        assertTrue(bst.contains(22));
    }

    @Test
    void removeMinOnEmptyLinkedBinarySearchTreeThrowsException() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        assertThrows(NoSuchElementException.class, () -> bst.removeMin());
    }

    @Test
    void removeMinOnLinkedBinarySearchTreeWhenMinIsRootReturnsCorrectMin() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(101);
        assertEquals(99, bst.removeMin());
    }

    @Test
    void removeMinOnLinkedBinarySearchTreeWhenMinIsInternalNodeReturnsCorrectMin() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(55);
        bst.add(77);
        assertEquals(55, bst.removeMin());
    }

    @Test
    void removeMinOnLinkedBinarySearchTreeWhenMinIsLeafNodeReturnsCorrectMin() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(55);
        bst.add(77);
        bst.add(22);
        assertEquals(22, bst.removeMin());
    }

    @Test
    void removeMinOnLinkedBinarySearchTreeWhenMultipleEqualMinValuesExistReturnsCorrectMin() {
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
    void removeMinOnLinkedBinarySearchTreeWithSingleMinRemovesElementFromBinarySearchTree() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(55);
        bst.add(77);
        bst.add(22);
        bst.removeMin();
        assertFalse(bst.contains(22));
    }

    @Test
    void removeMinOnLinkedBinarySearchTreeWithManyMinRemovesOnlyOneElementFromBinarySearchTree() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(55);
        bst.add(77);
        bst.add(22);
        bst.add(22);
        bst.add(22);
        bst.removeMin();
        assertEquals(2, bst.getCount(22));
    }

    @Test
    void removeMinOnLinkedBinarySearchTreeUpdatesSize() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(55);
        bst.add(77);
        bst.add(22);
        bst.removeMin();
        assertEquals(3, bst.size());
    }

    @Test
    void multipleRemoveMinCallsOnLinkedBinarySearchTreeReturnsElementsInCorrectOrder() {
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
    void removeMaxOnEmptyLinkedBinarySearchTreeThrowsException() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        assertThrows(NoSuchElementException.class, () -> bst.removeMax());
    }

    @Test
    void removeMaxOnLinkedBinarySearchTreeWhenMaxIsRootReturnsCorrectMax() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(101);
        bst.add(99);
        assertEquals(101, bst.removeMax());
    }

    @Test
    void removeMaxOnLinkedBinarySearchTreeWhenMaxIsInternalNodeReturnsCorrectMax() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(55);
        bst.add(99);
        bst.add(77);
        assertEquals(99, bst.removeMax());
    }

    @Test
    void removeMaxOnLinkedBinarySearchTreeWhenMaxIsLeafNodeReturnsCorrectMax() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(22);
        bst.add(55);
        bst.add(33);
        bst.add(99);
        assertEquals(99, bst.removeMax());
    }

    @Test
    void removeMaxOnLinkedBinarySearchTreeWhenMultipleEqualMaxValuesExistReturnsCorrectMax() {
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
    void removeMaxOnLinkedBinarySearchTreeWithSingleMaxRemovesElementFromBinarySearchTree() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(22);
        bst.add(55);
        bst.add(33);
        bst.add(99);
        bst.removeMax();
        assertFalse(bst.contains(99));
    }

    @Test
    void removeMaxOnLinkedBinarySearchTreeWithManyMaxRemovesOnlyOneElementFromBinarySearchTree() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(22);
        bst.add(99);
        bst.add(55);
        bst.add(33);
        bst.add(99);
        bst.removeMax();
        assertEquals(2, bst.getCount(99));
    }

    @Test
    void removeMaxOnLinkedBinarySearchTreeUpdatesSize() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        bst.add(55);
        bst.add(77);
        bst.add(22);
        bst.removeMax();
        assertEquals(3, bst.size());
    }

    @Test
    void multipleRemoveMaxCallsOnLinkedBinarySearchTreeReturnsElementsInCorrectOrder() {
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
    void removeOnEmptyLinkedBinarySearchTreeThrowsException() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        assertThrows(NoSuchElementException.class, () -> bst.remove(99));
    }

    @Test
    void removeNonExistingElementOnLinkedBinarySearchTreeThrowsException() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        assertThrows(NoSuchElementException.class, () -> bst.remove(101));
    }

    @Test
    void removeOnLinkedBinarySearchTreeWhenElementIsRootReturnsCorrectElement() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(50);
        bst.add(25);
        bst.add(75);
        bst.add(37);
        bst.add(12);
        bst.add(62);
        bst.add(87);
        assertEquals(50, bst.remove(50));
    }

    @Test
    void removeOnLinkedBinarySearchTreeWhenElementIsInternalNodeReturnsCorrectElement() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(50);
        bst.add(25);
        bst.add(75);
        bst.add(37);
        bst.add(12);
        bst.add(62);
        bst.add(87);
        assertEquals(25, bst.remove(25));
    }

    @Test
    void removeOnLinkedBinarySearchTreeWhenElementIsLeafNodeReturnsCorrectElement() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(50);
        bst.add(25);
        bst.add(75);
        bst.add(37);
        bst.add(12);
        bst.add(62);
        bst.add(87);
        assertEquals(25, bst.remove(25));
    }

    @Test
    void removeOnLinkedBinarySearchTreeWhenMultipleEqualElementsExistReturnsCorrectElement() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(50);
        bst.add(25);
        bst.add(75);
        bst.add(37);
        bst.add(12);
        bst.add(62);
        bst.add(87);
        bst.add(37);
        bst.add(37);
        assertEquals(37, bst.remove(37));
    }

    @Test
    void removeOnLinkedBinarySearchTreeWithSingleEqualElementRemovesElementFromBinarySearchTree() {
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
    void removeOnLinkedBinarySearchTreeWithManyEqualElementsRemovesOnlyOneElementFromBinarySearchTree() {
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
        assertEquals(2, bst.getCount(37));
    }

    @Test
    void removeOnLinkedBinarySearchTreeUpdatesSize() {
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
    void multipleRemoveCallsOnLinkedBinarySearchTreeReturnsElements() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(50);
        bst.add(25);
        bst.add(75);
        bst.add(37);
        bst.add(12);
        bst.add(62);
        bst.add(87);
        assertEquals(50, bst.remove(50));
        assertEquals(25, bst.remove(25));
        assertEquals(75, bst.remove(75));
        assertEquals(37, bst.remove(37));
        assertEquals(12, bst.remove(12));
        assertEquals(62, bst.remove(62));
        assertEquals(87, bst.remove(87));
    }

    @Test
    void addSingleElementToLinkedBinarySearchTreeResultsInItBeingTheOnlyElement() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        Iterator<Integer> it = bst.iterator();
        assertEquals(99, it.next());
    }

    @Test
    void addManyElementsToLinkedBinarySearchTreeResultsInElementsBeingPlacedInCorrectPlace() {
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
    void addAndRemoveManyElementsToLinkedBinarySearchTreeResultsInElementsBeingPlacedInCorrectPlace() {
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
    void iteratorHasNextOnEmptyLinkedBinarySearchTreeReturnsFalse() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        Iterator<Integer> it = bst.iterator();
        assertFalse(it.hasNext());
    }

    @Test
    void iteratorHasOneElementForLinkedBinarySearchTreeWithOneElement() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        Iterator<Integer> it = bst.iterator();
        assertEquals(99, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void iteratorNextOnNonEmptyLinkedBinarySearchTreeReturnsElementsInCorrectOrder() {
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
    void iteratorNextOnEmptyLinkedBinarySearchTreeThrowsException() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        Iterator<Integer> it = bst.iterator();
        assertThrows(NoSuchElementException.class, () -> it.next());
    }

    @Test
    void preOrderIteratorHasNextOnEmptyLinkedBinarySearchTreeReturnsFalse() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        Iterator<Integer> it = bst.preOrderIterator();
        assertFalse(it.hasNext());
    }

    @Test
    void preOrderIteratorHasOneElementForLinkedBinarySearchTreeWithOneElement() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        Iterator<Integer> it = bst.preOrderIterator();
        assertEquals(99, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void preOrderIteratorNextOnNonEmptyLinkedBinarySearchTreeReturnsElementsInCorrectOrder() {
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
    void preOrderIteratorNextOnEmptyLinkedBinarySearchTreeThrowsException() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        Iterator<Integer> it = bst.preOrderIterator();
        assertThrows(NoSuchElementException.class, () -> it.next());
    }

    @Test
    void inOrderIteratorHasNextOnEmptyLinkedBinarySearchTreeReturnsFalse() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        Iterator<Integer> it = bst.inOrderIterator();
        assertFalse(it.hasNext());
    }

    @Test
    void inOrderIteratorHasOneElementForLinkedBinarySearchTreeWithOneElement() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        Iterator<Integer> it = bst.inOrderIterator();
        assertEquals(99, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void inOrderIteratorNextOnNonEmptyLinkedBinarySearchTreeReturnsElementsInCorrectOrder() {
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
    void inOrderIteratorNextOnEmptyLinkedBinarySearchTreeThrowsException() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        Iterator<Integer> it = bst.inOrderIterator();
        assertThrows(NoSuchElementException.class, () -> it.next());
    }

    @Test
    void postOrderIteratorHasNextOnEmptyLinkedBinarySearchTreeReturnsFalse() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        Iterator<Integer> it = bst.postOrderIterator();
        assertFalse(it.hasNext());
    }

    @Test
    void postOrderIteratorHasOneElementForLinkedBinarySearchTreeWithOneElement() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        Iterator<Integer> it = bst.postOrderIterator();
        assertEquals(99, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void postOrderIteratorNextOnNonEmptyLinkedBinarySearchTreeReturnsElementsInCorrectOrder() {
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
    void postOrderIteratorNextOnEmptyLinkedBinarySearchTreeThrowsException() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        Iterator<Integer> it = bst.postOrderIterator();
        assertThrows(NoSuchElementException.class, () -> it.next());
    }

    @Test
    void levelOrderIteratorHasNextOnEmptyLinkedBinarySearchTreeReturnsFalse() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        Iterator<Integer> it = bst.levelOrderIterator();
        assertFalse(it.hasNext());
    }

    @Test
    void levelOrderIteratorHasOneElementForLinkedBinarySearchTreeWithOneElement() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        bst.add(99);
        Iterator<Integer> it = bst.levelOrderIterator();
        assertEquals(99, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void levelOrderIteratorNextOnNonEmptyLinkedBinarySearchTreeReturnsElementsInCorrectOrder() {
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

    @Test
    void levelOrderIteratorNextOnEmptyLinkedBinarySearchTreeThrowsException() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        Iterator<Integer> it = bst.levelOrderIterator();
        assertThrows(NoSuchElementException.class, () -> it.next());
    }
}
