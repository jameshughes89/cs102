import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.Test;

public class LinkedBinarySearchTreeEqualsTest {

    @Test
    @SuppressWarnings("UnstableApiUsage")
    public void equals_verify_contract() {
        LinkedBinarySearchTree<Integer> emptyA = new LinkedBinarySearchTree<>();
        LinkedBinarySearchTree<Integer> emptyB = new LinkedBinarySearchTree<>();

        LinkedBinarySearchTree<Integer> singletonA = new LinkedBinarySearchTree<>();
        LinkedBinarySearchTree<Integer> singletonB = new LinkedBinarySearchTree<>();
        singletonA.add(10);
        singletonB.add(10);

        LinkedBinarySearchTree<Integer> manyA = new LinkedBinarySearchTree<>();
        LinkedBinarySearchTree<Integer> manyB = new LinkedBinarySearchTree<>();
        LinkedBinarySearchTree<Integer> manyDifferentTopology = new LinkedBinarySearchTree<>();
        manyA.add(10);
        manyA.add(20);
        manyA.add(30);
        manyB.add(10);
        manyB.add(20);
        manyB.add(30);
        manyDifferentTopology.add(20);
        manyDifferentTopology.add(30);
        manyDifferentTopology.add(10);

        LinkedBinarySearchTree<Integer> unequalDifferentValues = new LinkedBinarySearchTree<>();
        unequalDifferentValues.add(110);
        unequalDifferentValues.add(120);
        unequalDifferentValues.add(130);

        LinkedBinarySearchTree<Integer> unequalDifferentSizes = new LinkedBinarySearchTree<>();
        unequalDifferentSizes.add(10);
        unequalDifferentSizes.add(20);

        LinkedBinarySearchTree<Integer> unequalSomeEqual = new LinkedBinarySearchTree<>();
        unequalSomeEqual.add(20);
        unequalSomeEqual.add(30);
        unequalSomeEqual.add(40);

        new EqualsTester().addEqualityGroup(LinkedBinarySearchTree.class)
                .addEqualityGroup(emptyA, emptyB)
                .addEqualityGroup(singletonA, singletonB)
                .addEqualityGroup(manyA, manyB, manyDifferentTopology)
                .addEqualityGroup(unequalDifferentValues)
                .addEqualityGroup(unequalDifferentSizes)
                .addEqualityGroup(unequalSomeEqual)
                .testEquals();
    }
}
