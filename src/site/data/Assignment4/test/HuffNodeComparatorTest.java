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


}
