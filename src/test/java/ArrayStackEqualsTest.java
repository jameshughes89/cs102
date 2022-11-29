import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.Test;

class ArrayStackEqualsTest {

    @Test
    @SuppressWarnings("UnstableApiUsage")
    public void equals_verify_contract() {
        ArrayStack<Integer> emptyA = new ArrayStack<>();
        ArrayStack<Integer> emptyB = new ArrayStack<>();
        ArrayStack<Integer> emptyC = new ArrayStack<>(1000);

        ArrayStack<Integer> singletonA = new ArrayStack<>();
        ArrayStack<Integer> singletonB = new ArrayStack<>();
        ArrayStack<Integer> singletonC = new ArrayStack<>(1000);
        singletonA.push(10);
        singletonB.push(10);
        singletonC.push(10);

        ArrayStack<Integer> manyA = new ArrayStack<>();
        ArrayStack<Integer> manyB = new ArrayStack<>();
        ArrayStack<Integer> manyC = new ArrayStack<>(1000);
        manyA.push(10);
        manyA.push(20);
        manyA.push(30);
        manyB.push(10);
        manyB.push(20);
        manyB.push(30);
        manyC.push(10);
        manyC.push(20);
        manyC.push(30);

        ArrayStack<Integer> unequalDifferentValues = new ArrayStack<>();
        unequalDifferentValues.push(110);
        unequalDifferentValues.push(120);
        unequalDifferentValues.push(130);

        ArrayStack<Integer> unequalDifferentOrder = new ArrayStack<>();
        unequalDifferentOrder.push(30);
        unequalDifferentOrder.push(20);
        unequalDifferentOrder.push(10);

        ArrayStack<Integer> unequalDifferentSizes = new ArrayStack<>();
        unequalDifferentSizes.push(10);
        unequalDifferentSizes.push(20);

        ArrayStack<Integer> unequalSomeEqual = new ArrayStack<>();
        unequalSomeEqual.push(20);
        unequalSomeEqual.push(30);
        unequalSomeEqual.push(40);


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
}
