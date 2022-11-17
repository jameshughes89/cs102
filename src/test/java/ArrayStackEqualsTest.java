import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArrayStackEqualsTest {

    @Test
    @SuppressWarnings("UnstableApiUsage")
    @DisplayName("Verify Equals.")
    public void equals_verify_contract() {
        ArrayStack<Integer> gEmptyDefault = new ArrayStack<>();
        ArrayStack<Integer> gEmptyCapacity = new ArrayStack<>(10);
        ArrayStack<Integer> gSingletonDefault = new ArrayStack<>();
        ArrayStack<Integer> gSingletonCapacity = new ArrayStack<>(10);
        ArrayStack<Integer> gManyOneDefaultA = new ArrayStack<>();
        ArrayStack<Integer> gManyOneDefaultB = new ArrayStack<>();
        ArrayStack<Integer> gManyOneCapacity = new ArrayStack<>(5);
        ArrayStack<Integer> gManyTwoDefault = new ArrayStack<>();
        ArrayStack<Integer> gManyTwoCapacity = new ArrayStack<>(10);
        ArrayStack<Integer> gReverseDefault = new ArrayStack<>();
        ArrayStack<Integer> gReverseCapacity = new ArrayStack<>(10);
        ArrayStack<Character> gTypeDefault = new ArrayStack<>();
        ArrayStack<Character> gTypeCapacity = new ArrayStack<>(10);

        for (int i = 0; i < 6; i++) {
            gManyOneDefaultA.push(i);
            gManyOneDefaultB.push(i);
            gManyOneCapacity.push(i);
            gManyTwoDefault.push(i * 11);
            gManyTwoCapacity.push(i * 11);
            gReverseDefault.push(5 - i);
            gReverseCapacity.push(5 - i);
            gTypeDefault.push((char) i);
            gTypeCapacity.push((char) i);
        }
        gSingletonDefault.push(100);
        gSingletonCapacity.push(100);

        new EqualsTester().addEqualityGroup(ArrayStack.class).addEqualityGroup(gEmptyDefault, gEmptyCapacity).addEqualityGroup(gSingletonDefault, gSingletonCapacity).addEqualityGroup(gManyOneDefaultA, gManyOneDefaultB, gManyOneCapacity).addEqualityGroup(gManyTwoDefault, gManyTwoCapacity).addEqualityGroup(gReverseDefault, gReverseCapacity).addEqualityGroup(gTypeDefault, gTypeCapacity).testEquals();
    }
}
