import org.junit.jupiter.api.Test;

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
}
