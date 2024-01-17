import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.Test;

class LinkedQueueEqualsTest {

    @Test
    @SuppressWarnings("UnstableApiUsage")
    public void equals_verify_contract() {
        LinkedQueue<Integer> emptyA = of();
        LinkedQueue<Integer> emptyB = of();

        LinkedQueue<Integer> singletonA = of(10);
        LinkedQueue<Integer> singletonB = of(10);

        LinkedQueue<Integer> manyA = of(10, 20, 30);
        LinkedQueue<Integer> manyB = of(10, 20, 30);

        LinkedQueue<Integer> unequalDifferentValues = of(110, 120, 130);
        LinkedQueue<Integer> unequalDifferentOrder = of(30, 20, 10);
        LinkedQueue<Integer> unequalDifferentSizes = of(10, 20);
        LinkedQueue<Integer> unequalSomeEqual = of(20, 30, 40);

        new EqualsTester().addEqualityGroup(LinkedQueue.class)
                .addEqualityGroup(emptyA, emptyB)
                .addEqualityGroup(singletonA, singletonB)
                .addEqualityGroup(manyA, manyB)
                .addEqualityGroup(unequalDifferentValues)
                .addEqualityGroup(unequalDifferentOrder)
                .addEqualityGroup(unequalDifferentSizes)
                .addEqualityGroup(unequalSomeEqual)
                .testEquals();
    }

    private <T> LinkedQueue<T> of(T... ts) {
        LinkedQueue<T> queue = new LinkedQueue<>();
        for (T element : ts) {
            queue.enqueue(element);
        }
        return queue;
    }
}
