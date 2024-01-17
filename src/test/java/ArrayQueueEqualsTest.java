import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.Test;

class ArrayQueueEqualsTest {

    @Test
    @SuppressWarnings("UnstableApiUsage")
    public void equals_verify_contract() {
        ArrayQueue<Integer> emptyA = of();
        ArrayQueue<Integer> emptyB = of();
        ArrayQueue<Integer> emptyC = ofCapacity();

        ArrayQueue<Integer> singletonA = of(10);
        ArrayQueue<Integer> singletonB = of(10);
        ArrayQueue<Integer> singletonC = ofCapacity(10);
        ArrayQueue<Integer> singletonD = new ArrayQueue<>();            // Different start
        singletonD.enqueue(0);
        singletonD.dequeue();
        singletonD.enqueue(10);

        ArrayQueue<Integer> manyA = of(10, 20, 30);
        ArrayQueue<Integer> manyB = of(10, 20, 30);
        ArrayQueue<Integer> manyC = ofCapacity(10, 20, 30);
        ArrayQueue<Integer> manyD = new ArrayQueue<>();                 // Different start
        ArrayQueue<Integer> manyW = new ArrayQueue<>(5);    // Wraps rear
        manyD.enqueue(0);
        manyD.dequeue();
        manyD.enqueue(10);
        manyD.enqueue(20);
        manyD.enqueue(30);
        manyW.enqueue(0);
        manyW.enqueue(0);
        manyW.enqueue(0);
        manyW.dequeue();
        manyW.dequeue();
        manyW.dequeue();
        manyW.enqueue(10);
        manyW.enqueue(20);
        manyW.enqueue(30);

        ArrayQueue<Integer> unequalDifferentValues = of(110, 120, 130);
        ArrayQueue<Integer> unequalDifferentOrder = of(30, 20, 10);
        ArrayQueue<Integer> unequalDifferentSizes = of(10, 20);
        ArrayQueue<Integer> unequalSomeEqual = of(20, 30, 40);

        new EqualsTester().addEqualityGroup(ArrayQueue.class)
                .addEqualityGroup(emptyA, emptyB, emptyC)
                .addEqualityGroup(singletonA, singletonB, singletonC, singletonD)
                .addEqualityGroup(manyA, manyB, manyC, manyD, manyW)
                .addEqualityGroup(unequalDifferentValues)
                .addEqualityGroup(unequalDifferentOrder)
                .addEqualityGroup(unequalDifferentSizes)
                .addEqualityGroup(unequalSomeEqual)
                .testEquals();
    }

    private <T> ArrayQueue<T> of(T... ts) {
        ArrayQueue<T> queue = new ArrayQueue<>();
        for (T element : ts) {
            queue.enqueue(element);
        }
        return queue;
    }

    private <T> ArrayQueue<T> ofCapacity(T... ts) {
        ArrayQueue<T> queue = new ArrayQueue<>(1000);
        for (T element : ts) {
            queue.enqueue(element);
        }
        return queue;
    }
}
