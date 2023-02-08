import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.Test;

class ArrayIndexedBagEqualsTest {

    @Test
    public void equals_verify_contract() {
        ArrayIndexedBag<Integer> emptyA = of();
        ArrayIndexedBag<Integer> emptyB = of();
        ArrayIndexedBag<Integer> emptyC = ofCapacity();
        ArraySortedBag<Integer> emptySortedBag = ofSorted();

        ArrayIndexedBag<Integer> singletonA = of(10);
        ArrayIndexedBag<Integer> singletonB = of(10);
        ArrayIndexedBag<Integer> singletonC = ofCapacity(10);
        ArraySortedBag<Integer> singletonSortedBag = ofSorted(10);

        ArrayIndexedBag<Integer> manyA = of(10, 20, 30);
        ArrayIndexedBag<Integer> manyB = of(10, 20, 30);
        ArrayIndexedBag<Integer> manyC = ofCapacity(10, 20, 30);
        ArrayIndexedBag<Integer> manyDifferentOrder = of(20, 30, 10);
        ArraySortedBag<Integer> manySortedBag = ofSorted(10, 20, 30);
        ArraySortedBag<Integer> manySortedBagDifferentOrder = ofSorted(20, 30, 10);

        ArrayIndexedBag<Integer> duplicateA = of(10, 20, 20, 30, 30, 30);
        ArrayIndexedBag<Integer> duplicateB = of(10, 20, 20, 30, 30, 30);
        ArrayIndexedBag<Integer> duplicateC = ofCapacity(10, 20, 20, 30, 30, 30);
        ArrayIndexedBag<Integer> duplicateDifferentOrder = of(20, 30, 10, 30, 20, 30);
        ArraySortedBag<Integer> duplicateSortedBag = ofSorted(10, 20, 20, 30, 30, 30);
        ArraySortedBag<Integer> duplicateSortedBagDifferentOrder = ofSorted(20, 30, 10, 30, 20, 30);

        ArrayIndexedBag<Integer> unequalDifferentValues = of(110, 120, 130);

        ArrayIndexedBag<Integer> unequalDifferentSizes = of(10, 20);

        ArrayIndexedBag<Integer> unequalSomeEqual = of(20, 30, 40);

        new EqualsTester().addEqualityGroup(ArrayIndexedBag.class)
                .addEqualityGroup(emptyA, emptyB, emptyC, emptySortedBag)
                .addEqualityGroup(singletonA, singletonB, singletonC, singletonSortedBag)
                .addEqualityGroup(manyA, manyB, manyC, manyDifferentOrder, manySortedBag, manySortedBagDifferentOrder)
                .addEqualityGroup(duplicateA,
                        duplicateB,
                        duplicateC,
                        duplicateDifferentOrder,
                        duplicateSortedBag,
                        duplicateSortedBagDifferentOrder)
                .addEqualityGroup(unequalDifferentValues)
                .addEqualityGroup(unequalDifferentSizes)
                .addEqualityGroup(unequalSomeEqual)
                .testEquals();
    }

    private <T> ArrayIndexedBag<T> of(T... ts) {
        ArrayIndexedBag<T> indexedBag = new ArrayIndexedBag<>();
        for (T element : ts) {
            indexedBag.add(element);
        }
        return indexedBag;
    }

    private <T> ArrayIndexedBag<T> ofCapacity(T... ts) {
        ArrayIndexedBag<T> indexedBag = new ArrayIndexedBag<>(1000);
        for (T element : ts) {
            indexedBag.add(element);
        }
        return indexedBag;
    }

    private <T extends Comparable<? super T>> ArraySortedBag<T> ofSorted(T... ts) {
        ArraySortedBag<T> sortedBag = new ArraySortedBag<>();
        for (T element : ts) {
            sortedBag.add(element);
        }
        return sortedBag;
    }
}
