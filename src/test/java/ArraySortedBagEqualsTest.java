import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.Test;

class ArraySortedBagEqualsTest {

    @Test
    @SuppressWarnings("UnstableApiUsage")
    public void equals_verify_contract() {
        ArraySortedBag<Integer> emptyA = of();
        ArraySortedBag<Integer> emptyB = of();
        ArraySortedBag<Integer> emptyC = ofCapacity();
        ArrayIndexedBag<Integer> emptyIndexedBag = ofIndexed();

        ArraySortedBag<Integer> singletonA = of(10);
        ArraySortedBag<Integer> singletonB = of(10);
        ArraySortedBag<Integer> singletonC = ofCapacity(10);
        ArrayIndexedBag<Integer> singletonIndexedBag = ofIndexed(10);

        ArraySortedBag<Integer> manyA = of(10, 20, 30);
        ArraySortedBag<Integer> manyB = of(10, 20, 30);
        ArraySortedBag<Integer> manyC = ofCapacity(10, 20, 30);
        ArraySortedBag<Integer> manyDifferentOrder = of(20, 30, 10);
        ArrayIndexedBag<Integer> manyIndexedBag = ofIndexed(10, 20, 30);
        ArrayIndexedBag<Integer> manyIndexedBagDifferentOrder = ofIndexed(20, 30, 10);

        ArraySortedBag<Integer> duplicateA = of(10, 20, 20, 30, 30, 30);
        ArraySortedBag<Integer> duplicateB = of(10, 20, 20, 30, 30, 30);
        ArraySortedBag<Integer> duplicateC = ofCapacity(10, 20, 20, 30, 30, 30);
        ArraySortedBag<Integer> duplicateDifferentOrder = of(20, 30, 10, 30, 20, 30);
        ArrayIndexedBag<Integer> duplicateIndexedBag = ofIndexed(10, 20, 20, 30, 30, 30);
        ArrayIndexedBag<Integer> duplicateIndexedBagDifferentOrder = ofIndexed(20, 30, 10, 30, 20, 30);

        ArraySortedBag<Integer> unequalDifferentValues = of(110, 120, 130);
        ArraySortedBag<Integer> unequalDifferentSizes = of(10, 20);
        ArraySortedBag<Integer> unequalSomeEqual = of(20, 30, 40);

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


    private <T extends Comparable<? super T>> ArraySortedBag<T> of(T... ts) {
        ArraySortedBag<T> indexedBag = new ArraySortedBag<>();
        for (T element : ts) {
            indexedBag.add(element);
        }
        return indexedBag;
    }

    private <T extends Comparable<? super T>> ArraySortedBag<T> ofCapacity(T... ts) {
        ArraySortedBag<T> indexedBag = new ArraySortedBag<>(1000);
        for (T element : ts) {
            indexedBag.add(element);
        }
        return indexedBag;
    }

    private <T> ArrayIndexedBag<T> ofIndexed(T... ts) {
        ArrayIndexedBag<T> sortedBag = new ArrayIndexedBag<>();
        for (T element : ts) {
            sortedBag.add(element);
        }
        return sortedBag;
    }

}
