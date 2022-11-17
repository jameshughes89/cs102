import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LinkedStackEqualsTest {

    @Test
    @SuppressWarnings("UnstableApiUsage")
    @DisplayName("Verify Equals.")
    public void equals_verify_contract() {
        LinkedStack<Integer> gEmpty = new LinkedStack<>();
        LinkedStack<Integer> gSingleton = new LinkedStack<>();
        LinkedStack<Integer> gManyOneA = new LinkedStack<>();
        LinkedStack<Integer> gManyOneB = new LinkedStack<>();
        LinkedStack<Integer> gManyTwo = new LinkedStack<>();
        LinkedStack<Integer> gReverse = new LinkedStack<>();
        LinkedStack<Character> gType = new LinkedStack<>();

        for (int i = 0; i < 6; i++) {
            gManyOneA.push(i);
            gManyOneB.push(i);
            gManyTwo.push(i * 11);
            gReverse.push(5 - i);
            gType.push((char) i);
        }
        gSingleton.push(100);

        new EqualsTester().addEqualityGroup(LinkedStack.class).addEqualityGroup(gEmpty).addEqualityGroup(gSingleton).addEqualityGroup(gManyOneA, gManyOneB).addEqualityGroup(gManyTwo).addEqualityGroup(gReverse).addEqualityGroup(gType).testEquals();
    }
}
