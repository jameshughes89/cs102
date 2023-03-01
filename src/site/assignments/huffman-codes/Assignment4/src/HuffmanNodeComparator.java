import java.util.Comparator;

public class HuffmanNodeComparator implements Comparator<HuffmanNode> {

    /**
     * Compares two HuffmanNode objects. HuffmanNode objects are ordered based on the following rules:
     * <p>
     * 1. A HuffmanNode with a smaller weight comes first
     * 2. If a HuffmanLeaf and a HuffmanInternal have the same weight, the leaf comes first
     * 3. If two HuffmanLeaf nodes have the same weight, the one with the character with the smaller ASCII value
     * comes first
     * 4. If two HuffmanInternal nodes are compared, their order does not matter
     *
     * @param huff1 the first object to be compared
     * @param huff2 the second object to be compared
     * @return negative int if huff1 < huff 2, 0 if huff1 == huff2, and positive int if huff1 > huff 2
     */
    public int compare(HuffmanNode huff1, HuffmanNode huff2) {
        return 0;
    }

}

