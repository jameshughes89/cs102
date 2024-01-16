import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.Test;

class LinkedStackEqualsTest {

    @Test
    @SuppressWarnings("UnstableApiUsage")
    public void equals_verify_contract() {
        LinkedStack<Integer> emptyA = of();
        LinkedStack<Integer> emptyB = of();

        LinkedStack<Integer> singletonA = of(10);
        LinkedStack<Integer> singletonB = of(10);

        LinkedStack<Integer> manyA = of(10, 20, 30);
        LinkedStack<Integer> manyB = of(10, 20, 30);

        LinkedStack<Integer> unequalDifferentValues = of(110, 120, 130);
        LinkedStack<Integer> unequalDifferentOrder = of(30, 20, 10);
        LinkedStack<Integer> unequalDifferentSizes = of(10, 20);
        LinkedStack<Integer> unequalSomeEqual = of(20, 30, 40);

        new EqualsTester().addEqualityGroup(LinkedStack.class)
                .addEqualityGroup(emptyA, emptyB)
                .addEqualityGroup(singletonA, singletonB)
                .addEqualityGroup(manyA, manyB)
                .addEqualityGroup(unequalDifferentValues)
                .addEqualityGroup(unequalDifferentOrder)
                .addEqualityGroup(unequalDifferentSizes)
                .addEqualityGroup(unequalSomeEqual)
                .testEquals();
    }

    private <T> LinkedStack<T> of(T... ts) {
        LinkedStack<T> stack = new LinkedStack<>();
        for (T element : ts) {
            stack.push(element);
        }
        return stack;
    }
}
