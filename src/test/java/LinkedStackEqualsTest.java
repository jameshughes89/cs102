import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.Test;

class LinkedStackEqualsTest {

    @Test
    @SuppressWarnings("UnstableApiUsage")
    public void equals_verify_contract() {
        LinkedStack<Integer> emptyA = new LinkedStack<>();
        LinkedStack<Integer> emptyB = new LinkedStack<>();

        LinkedStack<Integer> singletonA = new LinkedStack<>();
        LinkedStack<Integer> singletonB = new LinkedStack<>();
        singletonA.push(10);
        singletonB.push(10);


        LinkedStack<Integer> manyA = new LinkedStack<>();
        LinkedStack<Integer> manyB = new LinkedStack<>();
        manyA.push(10);
        manyA.push(20);
        manyA.push(30);
        manyB.push(10);
        manyB.push(20);
        manyB.push(30);

        LinkedStack<Integer> unequalDifferentValues = new LinkedStack<>();
        unequalDifferentValues.push(110);
        unequalDifferentValues.push(120);
        unequalDifferentValues.push(130);

        LinkedStack<Integer> unequalDifferentOrder = new LinkedStack<>();
        unequalDifferentOrder.push(30);
        unequalDifferentOrder.push(20);
        unequalDifferentOrder.push(10);

        LinkedStack<Integer> unequalDifferentSizes = new LinkedStack<>();
        unequalDifferentSizes.push(10);
        unequalDifferentSizes.push(20);

        LinkedStack<Integer> unequalSomeEqual = new LinkedStack<>();
        unequalSomeEqual.push(20);
        unequalSomeEqual.push(30);
        unequalSomeEqual.push(40);

        new EqualsTester().addEqualityGroup(ArrayStack.class)
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
