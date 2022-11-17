import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LinkedQueueEqualsTest {

    @Test
    @SuppressWarnings("UnstableApiUsage")
    @DisplayName("Verify Equals.")
    public void equals_verify_contract() {
        LinkedQueue<Integer> gEmpty = new LinkedQueue<>();
        LinkedQueue<Integer> gSingleton = new LinkedQueue<>();
        LinkedQueue<Integer> gManyOneA = new LinkedQueue<>();
        LinkedQueue<Integer> gManyOneB = new LinkedQueue<>();
        LinkedQueue<Integer> gManyOneDequeued = new LinkedQueue<>();
        LinkedQueue<Integer> gManyTwo = new LinkedQueue<>();
        LinkedQueue<Integer> gReverse = new LinkedQueue<>();
        LinkedQueue<Character> gType = new LinkedQueue<>();

        // Move front down
        gManyOneDequeued.enqueue(0);
        gManyOneDequeued.dequeue();

        for (int i = 0; i < 6; i++) {
            gManyOneA.enqueue(i);
            gManyOneB.enqueue(i);
            gManyOneDequeued.enqueue(i);
            gManyTwo.enqueue(i * 11);
            gReverse.enqueue(5 - i);
            gType.enqueue((char) i);
        }

        gSingleton.enqueue(100);

        new EqualsTester().addEqualityGroup(LinkedQueue.class).addEqualityGroup(gEmpty).addEqualityGroup(gSingleton).addEqualityGroup(gManyOneA, gManyOneB, gManyOneDequeued).addEqualityGroup(gManyTwo).addEqualityGroup(gReverse).addEqualityGroup(gType).testEquals();
    }
}
