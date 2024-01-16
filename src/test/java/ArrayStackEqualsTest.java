import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.Test;
import playground.ArrayStack;

class ArrayStackEqualsTest {

    @Test
    @SuppressWarnings("UnstableApiUsage")
    public void equals_verify_contract() {
        ArrayStack<Integer> emptyA = of();
        ArrayStack<Integer> emptyB = of();
        ArrayStack<Integer> emptyC = ofCapacity();

        ArrayStack<Integer> singletonA = of(10);
        ArrayStack<Integer> singletonB = of(10);
        ArrayStack<Integer> singletonC = ofCapacity(10);

        ArrayStack<Integer> manyA = of(10, 20, 30);
        ArrayStack<Integer> manyB = of(10, 20, 30);
        ArrayStack<Integer> manyC = ofCapacity(10, 20, 30);

        ArrayStack<Integer> unequalDifferentValues = of(110, 120, 130);
        ArrayStack<Integer> unequalDifferentOrder = of(30, 20, 10);
        ArrayStack<Integer> unequalDifferentSizes = of(10, 20);
        ArrayStack<Integer> unequalSomeEqual = of(20, 30, 40);

        new EqualsTester().addEqualityGroup(ArrayStack.class)
                .addEqualityGroup(emptyA, emptyB, emptyC)
                .addEqualityGroup(singletonA, singletonB, singletonC)
                .addEqualityGroup(manyA, manyB, manyC)
                .addEqualityGroup(unequalDifferentValues)
                .addEqualityGroup(unequalDifferentOrder)
                .addEqualityGroup(unequalDifferentSizes)
                .addEqualityGroup(unequalSomeEqual)
                .testEquals();
    }

    private <T> ArrayStack<T> of(T... ts) {
        ArrayStack<T> stack = new ArrayStack<>();
        for (T element : ts) {
            stack.push(element);
        }
        return stack;
    }

    private <T> ArrayStack<T> ofCapacity(T... ts) {
        ArrayStack<T> stack = new ArrayStack<>(1000);
        for (T element : ts) {
            stack.push(element);
        }
        return stack;
    }
}
