import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.Test;

class ArrayQueueEqualsTest {

    @Test
    @SuppressWarnings("UnstableApiUsage")
    public void equals_verify_contract() {
        ArrayQueue<Integer> emptyA = new ArrayQueue<>();
        ArrayQueue<Integer> emptyB = new ArrayQueue<>();
        ArrayQueue<Integer> emptyC = new ArrayQueue<>(1000);

        ArrayQueue<Integer> singletonA = new ArrayQueue<>();
        ArrayQueue<Integer> singletonB = new ArrayQueue<>();
        ArrayQueue<Integer> singletonC = new ArrayQueue<>(1000);
        singletonA.enqueue(10);
        singletonB.enqueue(10);
        singletonC.enqueue(10);

        ArrayQueue<Integer> manyA = new ArrayQueue<>();
        ArrayQueue<Integer> manyB = new ArrayQueue<>();
        ArrayQueue<Integer> manyC = new ArrayQueue<>(1000);
        manyA.enqueue(10);
        manyA.enqueue(20);
        manyA.enqueue(30);
        manyB.enqueue(10);
        manyB.enqueue(20);
        manyB.enqueue(30);
        manyC.enqueue(10);
        manyC.enqueue(20);
        manyC.enqueue(30);

        ArrayQueue<Integer> unequalDifferentValues = new ArrayQueue<>();
        unequalDifferentValues.enqueue(110);
        unequalDifferentValues.enqueue(120);
        unequalDifferentValues.enqueue(130);

        ArrayQueue<Integer> unequalDifferentOrder = new ArrayQueue<>();
        unequalDifferentOrder.enqueue(30);
        unequalDifferentOrder.enqueue(20);
        unequalDifferentOrder.enqueue(10);

        ArrayQueue<Integer> unequalDifferentSizes = new ArrayQueue<>();
        unequalDifferentSizes.enqueue(10);
        unequalDifferentSizes.enqueue(20);

        ArrayQueue<Integer> unequalSomeEqual = new ArrayQueue<>();
        unequalSomeEqual.enqueue(20);
        unequalSomeEqual.enqueue(30);
        unequalSomeEqual.enqueue(40);

        new EqualsTester().addEqualityGroup(ArrayQueue.class)
                .addEqualityGroup(emptyA, emptyB, emptyC)
                .addEqualityGroup(singletonA, singletonB, singletonC)
                .addEqualityGroup(manyA, manyB, manyC)
                .addEqualityGroup(unequalDifferentValues)
                .addEqualityGroup(unequalDifferentOrder)
                .addEqualityGroup(unequalDifferentSizes)
                .addEqualityGroup(unequalSomeEqual)
                .testEquals();
    }
}
