import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArrayQueueEqualsTest {

    @Test
    @SuppressWarnings("UnstableApiUsage")
    @DisplayName("Verify Equals.")
    public void equals_verify_contract() {
        ArrayQueue<Integer> gEmptyDefault = new ArrayQueue<>();
        ArrayQueue<Integer> gEmptyCapacity = new ArrayQueue<>(10);
        ArrayQueue<Integer> gSingletonDefault = new ArrayQueue<>();
        ArrayQueue<Integer> gSingletonCapacity = new ArrayQueue<>(10);
        ArrayQueue<Integer> gManyOneDefaultA = new ArrayQueue<>();
        ArrayQueue<Integer> gManyOneDefaultB = new ArrayQueue<>();
        ArrayQueue<Integer> gManyOneCapacity = new ArrayQueue<>(5);
        ArrayQueue<Integer> gManyOneDequeued = new ArrayQueue<>();
        ArrayQueue<Integer> gManyTwoDefault = new ArrayQueue<>();
        ArrayQueue<Integer> gManyTwoCapacity = new ArrayQueue<>(10);
        ArrayQueue<Integer> gReverseDefault = new ArrayQueue<>();
        ArrayQueue<Integer> gReverseCapacity = new ArrayQueue<>(10);
        ArrayQueue<Character> gTypeDefault = new ArrayQueue<>();
        ArrayQueue<Character> gTypeCapacity = new ArrayQueue<>(10);

        // Move front down
        gManyOneDequeued.enqueue(0);
        gManyOneDequeued.dequeue();

        for (int i = 0; i < 6; i++) {
            gManyOneDefaultA.enqueue(i);
            gManyOneDefaultB.enqueue(i);
            gManyOneCapacity.enqueue(i);
            gManyOneDequeued.enqueue(i);
            gManyTwoDefault.enqueue(i * 11);
            gManyTwoCapacity.enqueue(i * 11);
            gReverseDefault.enqueue(5 - i);
            gReverseCapacity.enqueue(5 - i);
            gTypeDefault.enqueue((char) i);
            gTypeCapacity.enqueue((char) i);
        }

        gSingletonDefault.enqueue(100);
        gSingletonCapacity.enqueue(100);

        new EqualsTester()
                .addEqualityGroup(ArrayQueue.class)
                .addEqualityGroup(gEmptyDefault,
                        gEmptyCapacity)
                .addEqualityGroup(gSingletonDefault,
                        gSingletonCapacity)
                .addEqualityGroup(gManyOneDefaultA,
                        gManyOneDefaultB,
                        gManyOneCapacity,
                        gManyOneDequeued)
                .addEqualityGroup(gManyTwoDefault,
                        gManyTwoCapacity)
                .addEqualityGroup(gReverseDefault,
                        gReverseCapacity)
                .addEqualityGroup(gTypeDefault,
                        gTypeCapacity)
                .testEquals();
    }
}
