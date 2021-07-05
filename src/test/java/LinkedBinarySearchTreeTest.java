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
}
