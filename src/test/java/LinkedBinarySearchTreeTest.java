import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedBinarySearchTreeTest {

    @Test
    void newLinkedBinarySearchTreeIsEmptyReturnsTrue() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        assertTrue(bst.isEmpty());
    }

    @Test
    void emptyLinkedBinarySearchTreeSizeReturnsZero() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        assertEquals(0, bst.size());
    }

    @Test
    void nonEmptyLinkedBinarySearchTreeIsEmptyReturnsFalse() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        assertFalse(bst.isEmpty());
    }
}
