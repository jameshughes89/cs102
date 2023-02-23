import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HuffInternalTest {

    private static final HuffmanInternal LEFT_CHILD_INTERNAL = new HuffmanInternal(10, null, null);
    private static final HuffmanLeaf RIGHT_CHILD_LEAF = new HuffmanLeaf(10, 'a');

    private HuffmanInternal classUnderTest;

    @Test
    void getWeight_onlyUseCase_returnsWeight() {

    }

    @Test
    void getLeft_leftChildInternal_returnsLeftChildInternalNode() {

    }

    @Test
    void getRight_rightChildLeaf_returnsRightChildLeafNode() {

    }

    @Test
    void getLeft_noLeftChild_returnsNull() {

    }

    @Test
    void getRight_noRightChild_returnsNull() {

    }

    @Test
    void toString_onlyUseCase_returnsString() {

    }
}
