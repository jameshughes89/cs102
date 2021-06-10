import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class ArrayStackTest {

    @Test
    @DisplayName("Pushing a single element on the stack")
    public void push_pushSingle_oneElementOnStack() {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(99);
        assertEquals(99, stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    public void expandCapacity_pushSix_callExpandCapacity() {
    assertj


    }



}
