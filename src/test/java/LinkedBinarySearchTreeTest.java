import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedBinarySearchTreeTest {

    @Test
    void newLinkedBinarySearchTreeIsEmptyReturnsTrue() {
        BinarySearchTree<Integer> bst = new LinkedBinarySearchTree<>();
        assertTrue(bst.isEmpty());
    }
}
