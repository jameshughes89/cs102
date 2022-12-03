import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.Test;

class LinkedQueueEqualsTest {

    @Test
    @SuppressWarnings("UnstableApiUsage")
    public void equals_verify_contract() {
        LinkedQueue<Integer> emptyA = new LinkedQueue<>();
        LinkedQueue<Integer> emptyB = new LinkedQueue<>();

        LinkedQueue<Integer> singletonA = new LinkedQueue<>();
        LinkedQueue<Integer> singletonB = new LinkedQueue<>();
        singletonA.enqueue(10);
        singletonB.enqueue(10);


        LinkedQueue<Integer> manyA = new LinkedQueue<>();
        LinkedQueue<Integer> manyB = new LinkedQueue<>();
        manyA.enqueue(10);
        manyA.enqueue(20);
        manyA.enqueue(30);
        manyB.enqueue(10);
        manyB.enqueue(20);
        manyB.enqueue(30);

        LinkedQueue<Integer> unequalDifferentValues = new LinkedQueue<>();
        unequalDifferentValues.enqueue(110);
        unequalDifferentValues.enqueue(120);
        unequalDifferentValues.enqueue(130);

        LinkedQueue<Integer> unequalDifferentOrder = new LinkedQueue<>();
        unequalDifferentOrder.enqueue(30);
        unequalDifferentOrder.enqueue(20);
        unequalDifferentOrder.enqueue(10);

        LinkedQueue<Integer> unequalDifferentSizes = new LinkedQueue<>();
        unequalDifferentSizes.enqueue(10);
        unequalDifferentSizes.enqueue(20);

        LinkedQueue<Integer> unequalSomeEqual = new LinkedQueue<>();
        unequalSomeEqual.enqueue(20);
        unequalSomeEqual.enqueue(30);
        unequalSomeEqual.enqueue(40);

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
}
