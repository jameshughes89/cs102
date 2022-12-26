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
        ArrayIndexedBag<Integer> ManyIndexedBag = new ArrayIndexedBag<>();
        ArrayIndexedBag<Integer> ManyIndexedBagDifferentOrder = new ArrayIndexedBag<>();
        manyA.add(10);
        manyA.add(20);
        manyA.add(30);
        manyB.add(10);
        manyB.add(20);
        manyB.add(30);
        manyC.add(10);
        manyC.add(20);
        manyC.add(30);
        ManyIndexedBag.add(10);
        ManyIndexedBag.add(20);
        ManyIndexedBag.add(30);
        ManyIndexedBagDifferentOrder.add(30);
        ManyIndexedBagDifferentOrder.add(10);
        ManyIndexedBagDifferentOrder.add(20);

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
                .addEqualityGroup(manyA, manyB, manyC, ManyIndexedBag, ManyIndexedBagDifferentOrder)
                .addEqualityGroup(unequalDifferentValues)
                .addEqualityGroup(unequalDifferentSizes)
                .addEqualityGroup(unequalSomeEqual)
                .testEquals();
    }
}
