import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;
//import static org.assertj.core.api.Assertions.*;

class ArrayStackTest {

    @Test
    @DisplayName("Stack starts empty and isEmpty true when size is 0.")
    public void startEmptySizeZero() {
        Stack<Integer> stack = new ArrayStack<>();
        assertTrue(stack.isEmpty());
        assertEquals(stack.size(), 0);
    }

    @Test
    @DisplayName("Pushing a single element on the stack is top.")
    public void pushSingle() {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(99);
        assertEquals(99, stack.peek());
        assertEquals(1, stack.size());
        assertFalse(stack.isEmpty());
    }

    @Test
    @DisplayName("Pushing 6 elements on stack expands capacity.")
    public void pushMany() {
        Stack<Integer> stack = new ArrayStack<>(5);
        for (int i = 0; i < 6; ++i) {
            stack.push(i);
        }
        assertEquals(5, stack.peek());
        assertEquals(6, stack.size());
    }

    @Test
    @DisplayName("Push and Pop returns in LIFO order.")
    public void pushPopLIFO() {
        Stack<Integer> stack = new ArrayStack<>(5);
        for (int i = 0; i < 6; ++i) {
            stack.push(i);
        }
        for (int i = 5; i >= 0; --i) {
            assertEquals(i, stack.pop());
        }
        assertTrue(stack.isEmpty());
    }

    @Test
    @DisplayName("Pop and Peek throw EmptyStackException when empty.")
    public void popPeekEmptyException() {
        Stack<Integer> stack = new ArrayStack<>(5);
        assertThrows(EmptyStackException.class, () -> stack.pop());
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }



}
