import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.Test;

class ArraySortedBagEqualsTest {

    @Test
    @SuppressWarnings("UnstableApiUsage")
    public void equals_verify_contract() {
        ArraySortedBag<Integer> emptyA = new ArraySortedBag<>();
        ArraySortedBag<Integer> emptyB = new ArraySortedBag<>();
        ArraySortedBag<Integer> emptyC = new ArraySortedBag<>(1000);
        ArrayIndexedBag<Integer> emptyIndexedBag = new ArrayIndexedBag<>();

        ArraySortedBag<Integer> singletonA = new ArraySortedBag<>();
        ArraySortedBag<Integer> singletonB = new ArraySortedBag<>();
        ArraySortedBag<Integer> singletonC = new ArraySortedBag<>(1000);
        ArrayIndexedBag<Integer> singletonIndexedBag = new ArrayIndexedBag<>();
        singletonA.add(10);
        singletonB.add(10);
        singletonC.add(10);
        singletonIndexedBag.add(10);

        ArraySortedBag<Integer> manyA = new ArraySortedBag<>();
        ArraySortedBag<Integer> manyB = new ArraySortedBag<>();
        ArraySortedBag<Integer> manyC = new ArraySortedBag<>(1000);
        ArraySortedBag<Integer> manyDifferentOrder = new ArraySortedBag<>();
        ArrayIndexedBag<Integer> manyIndexedBag = new ArrayIndexedBag<>();
        ArrayIndexedBag<Integer> manyIndexedBagDifferentOrder = new ArrayIndexedBag<>();
        manyA.add(10);
        manyA.add(20);
        manyA.add(30);
        manyB.add(10);
        manyB.add(20);
        manyB.add(30);
        manyC.add(10);
        manyC.add(20);
        manyC.add(30);
        manyDifferentOrder.add(20);
        manyDifferentOrder.add(30);
        manyDifferentOrder.add(10);
        manyIndexedBag.add(10);
        manyIndexedBag.add(20);
        manyIndexedBag.add(30);
        manyIndexedBagDifferentOrder.add(30);
        manyIndexedBagDifferentOrder.add(10);
        manyIndexedBagDifferentOrder.add(20);

        ArraySortedBag<Integer> duplicateA = new ArraySortedBag<>();
        ArraySortedBag<Integer> duplicateB = new ArraySortedBag<>();
        ArraySortedBag<Integer> duplicateC = new ArraySortedBag<>(1000);
        ArraySortedBag<Integer> duplicateDifferentOrder = new ArraySortedBag<>();
        ArrayIndexedBag<Integer> duplicateIndexedBag = new ArrayIndexedBag<>();
        ArrayIndexedBag<Integer> duplicateIndexedBagDifferentOrder = new ArrayIndexedBag<>();
        duplicateA.add(10);
        duplicateA.add(20);
        duplicateA.add(20);
        duplicateA.add(30);
        duplicateA.add(30);
        duplicateA.add(30);
        duplicateB.add(10);
        duplicateB.add(20);
        duplicateB.add(20);
        duplicateB.add(30);
        duplicateB.add(30);
        duplicateB.add(30);
        duplicateC.add(10);
        duplicateC.add(20);
        duplicateC.add(20);
        duplicateC.add(30);
        duplicateC.add(30);
        duplicateC.add(30);
        duplicateDifferentOrder.add(20);
        duplicateDifferentOrder.add(30);
        duplicateDifferentOrder.add(10);
        duplicateDifferentOrder.add(30);
        duplicateDifferentOrder.add(20);
        duplicateDifferentOrder.add(30);
        duplicateIndexedBag.add(10);
        duplicateIndexedBag.add(20);
        duplicateIndexedBag.add(20);
        duplicateIndexedBag.add(30);
        duplicateIndexedBag.add(30);
        duplicateIndexedBag.add(30);
        duplicateIndexedBagDifferentOrder.add(20);
        duplicateIndexedBagDifferentOrder.add(30);
        duplicateIndexedBagDifferentOrder.add(10);
        duplicateIndexedBagDifferentOrder.add(30);
        duplicateIndexedBagDifferentOrder.add(20);
        duplicateIndexedBagDifferentOrder.add(30);

        ArraySortedBag<Integer> unequalDifferentValues = new ArraySortedBag<>();
        unequalDifferentValues.add(110);
        unequalDifferentValues.add(120);
        unequalDifferentValues.add(130);

        ArraySortedBag<Integer> unequalDifferentSizes = new ArraySortedBag<>();
        unequalDifferentSizes.add(10);
        unequalDifferentSizes.add(20);

        ArraySortedBag<Integer> unequalSomeEqual = new ArraySortedBag<>();
        unequalSomeEqual.add(20);
        unequalSomeEqual.add(30);
        unequalSomeEqual.add(40);

        new EqualsTester().addEqualityGroup(ArraySortedBag.class)
                .addEqualityGroup(emptyA, emptyB, emptyC, emptyIndexedBag)
                .addEqualityGroup(singletonA, singletonB, singletonC, singletonIndexedBag)
                .addEqualityGroup(manyA, manyB, manyC, manyDifferentOrder, manyIndexedBag, manyIndexedBagDifferentOrder)
                .addEqualityGroup(duplicateA,
                        duplicateB,
                        duplicateC,
                        duplicateDifferentOrder,
                        duplicateIndexedBag,
                        duplicateIndexedBagDifferentOrder)
                .addEqualityGroup(unequalDifferentValues)
                .addEqualityGroup(unequalDifferentSizes)
                .addEqualityGroup(unequalSomeEqual)
                .testEquals();
    }
}
