import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.Test;

class ArrayIndexedBagEqualsTest {

    @Test
    @SuppressWarnings("UnstableApiUsage")
    public void equals_verify_contract() {
        ArrayIndexedBag<Integer> emptyA = new ArrayIndexedBag<>();
        ArrayIndexedBag<Integer> emptyB = new ArrayIndexedBag<>();
        ArrayIndexedBag<Integer> emptyC = new ArrayIndexedBag<>(1000);
        ArraySortedBag<Integer> emptySortedBag = new ArraySortedBag<>();

        ArrayIndexedBag<Integer> singletonA = new ArrayIndexedBag<>();
        ArrayIndexedBag<Integer> singletonB = new ArrayIndexedBag<>();
        ArrayIndexedBag<Integer> singletonC = new ArrayIndexedBag<>(1000);
        ArraySortedBag<Integer> singletonSortedBag = new ArraySortedBag<>();
        singletonA.add(10);
        singletonB.add(10);
        singletonC.add(10);
        singletonSortedBag.add(10);

        ArrayIndexedBag<Integer> manyA = new ArrayIndexedBag<>();
        ArrayIndexedBag<Integer> manyB = new ArrayIndexedBag<>();
        ArrayIndexedBag<Integer> manyC = new ArrayIndexedBag<>(1000);
        ArraySortedBag<Integer> manySortedBag = new ArraySortedBag<>();
        manyA.add(10);
        manyA.add(20);
        manyA.add(30);
        manyB.add(10);
        manyB.add(20);
        manyB.add(30);
        manyC.add(10);
        manyC.add(20);
        manyC.add(30);
        manySortedBag.add(10);
        manySortedBag.add(20);
        manySortedBag.add(30);

        ArrayIndexedBag<Integer> unequalDifferentValues = new ArrayIndexedBag<>();
        unequalDifferentValues.add(110);
        unequalDifferentValues.add(120);
        unequalDifferentValues.add(130);

        ArrayIndexedBag<Integer> unequalDifferentSizes = new ArrayIndexedBag<>();
        unequalDifferentSizes.add(10);
        unequalDifferentSizes.add(20);

        ArrayIndexedBag<Integer> unequalSomeEqual = new ArrayIndexedBag<>();
        unequalSomeEqual.add(20);
        unequalSomeEqual.add(30);
        unequalSomeEqual.add(40);

        new EqualsTester().addEqualityGroup(ArrayIndexedBag.class)
                .addEqualityGroup(emptyA, emptyB, emptyC, emptySortedBag)
                .addEqualityGroup(singletonA, singletonB, singletonC, singletonSortedBag)
                .addEqualityGroup(manyA, manyB, manyC, manySortedBag)
                .addEqualityGroup(unequalDifferentValues)
                .addEqualityGroup(unequalDifferentSizes)
                .addEqualityGroup(unequalSomeEqual)
                .testEquals();
    }
}
