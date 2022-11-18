import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HuffNodeComparatorTest {

    private static final HuffmanNode TEST_LEAF = new HuffmanLeaf(10, 'b');
    private static final HuffmanNode TEST_INTERNAL = new HuffmanInternal(10, null, null);

    private static final HuffmanNode SMALLER_WEIGHT_LEAF = new HuffmanLeaf(0, 'a');
    private static final HuffmanNode LARGER_WEIGHT_LEAF = new HuffmanLeaf(20, 'c');

    private static final HuffmanNode SMALLER_WEIGHT_INTERNAL = new HuffmanInternal(0, null, null);
    private static final HuffmanNode LARGER_WEIGHT_INTERNAL = new HuffmanInternal(20, null, null);

    private static final HuffmanNode SMALLER_ASCII_LEAF = new HuffmanLeaf(10, 'a');
    private static final HuffmanNode LARGER_ASCII_LEAF = new HuffmanLeaf(10, 'c');

    private static final HuffmanNode EQUAL_WEIGHT_INTERNAL = new HuffmanInternal(10, null, null);
    private static final HuffmanNode EQUAL_ASCII_LEAF = new HuffmanLeaf(10, 'b');

    private HuffmanNodeComparator classUnderTest;

    @BeforeEach
    void createComparator() {
        classUnderTest = new HuffmanNodeComparator();
    }

    @Test
    void compare_unsortedList_sortsList() {
        List<HuffmanNode> sorted = List.of(SMALLER_WEIGHT_LEAF,
                SMALLER_WEIGHT_INTERNAL,
                SMALLER_ASCII_LEAF,
                TEST_LEAF,
                LARGER_ASCII_LEAF,
                TEST_INTERNAL,
                LARGER_WEIGHT_LEAF,
                LARGER_WEIGHT_INTERNAL);
        List<HuffmanNode> unsorted = new ArrayList<>(sorted);
        Collections.shuffle(unsorted);
        unsorted.sort(classUnderTest);
        assertEquals(sorted, unsorted);
    }

    @Test
    void compare_vsEqualAsciiLeaf_returnsZero() {
        // This should never happen in practice
        int compared = classUnderTest.compare(TEST_LEAF, EQUAL_ASCII_LEAF);
        assertEquals(0, compared);
    }

    @Test
    void compare_vsEqualWeightInternal_returnsZero() {
        int compared = classUnderTest.compare(TEST_INTERNAL, EQUAL_WEIGHT_INTERNAL);
        assertEquals(0, compared);
    }
}
