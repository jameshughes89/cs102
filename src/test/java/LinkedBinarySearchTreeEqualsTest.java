import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.Test;

public class LinkedBinarySearchTreeEqualsTest {

    @Test
    public void equals_verify_contract() {
        LinkedBinarySearchTree<Integer> emptyA = of();
        LinkedBinarySearchTree<Integer> emptyB = of();

        LinkedBinarySearchTree<Integer> singletonA = of(10);
        LinkedBinarySearchTree<Integer> singletonB = of(10);

        LinkedBinarySearchTree<Integer> manyA = of(10, 20, 30);
        LinkedBinarySearchTree<Integer> manyB = of(10, 20, 30);
        LinkedBinarySearchTree<Integer> manyDifferentTopology = of(30, 10, 20);

        LinkedBinarySearchTree<Integer> duplicateA = of(10, 20, 20, 30, 30, 30);
        LinkedBinarySearchTree<Integer> duplicateB = of(10, 20, 20, 30, 30, 30);
        LinkedBinarySearchTree<Integer> duplicateDifferentTopology = of(20, 30, 10, 30, 20, 30);

        LinkedBinarySearchTree<Integer> unequalDifferentValues = of(110, 120, 130);

        LinkedBinarySearchTree<Integer> unequalDifferentSizes = of(10, 20);

        LinkedBinarySearchTree<Integer> unequalSomeEqual = of(20, 30, 40);

        new EqualsTester().addEqualityGroup(LinkedBinarySearchTree.class)
                .addEqualityGroup(emptyA, emptyB)
                .addEqualityGroup(singletonA, singletonB)
                .addEqualityGroup(manyA, manyB, manyDifferentTopology)
                .addEqualityGroup(duplicateA, duplicateB, duplicateDifferentTopology)
                .addEqualityGroup(unequalDifferentValues)
                .addEqualityGroup(unequalDifferentSizes)
                .addEqualityGroup(unequalSomeEqual)
                .testEquals();
    }

    private <T extends Comparable<? super T>> LinkedBinarySearchTree<T> of(T... ts) {
        LinkedBinarySearchTree<T> binarySearchTree = new LinkedBinarySearchTree<>();
        for (T element : ts) {
            binarySearchTree.add(element);
        }
        return binarySearchTree;
    }
}
