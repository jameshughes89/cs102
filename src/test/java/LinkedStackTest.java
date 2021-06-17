import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {

    @Test
    @DisplayName("A new stack starts empty.")
    void aNewStackIsEmpty() {
        Stack<Integer> stack = new LinkedStack<>();
        assertTrue(stack.isEmpty());
    }

    @Test
    @DisplayName("An empty stack has size 0.")
    void emptyStackHasSizeZero() {
        Stack<Integer> stack = new LinkedStack<>();
        assertEquals(0, stack.size());
    }

    @Test
    @DisplayName("isEmpty return false when it is non empty.")
    void nonEmptyStackIsEmptyReturnsFalse() {
        Stack<Integer> stack = new LinkedStack<>();
        stack.push(99);
        assertFalse(stack.isEmpty());
    }

    @Test
    @DisplayName("Pushing items updates the size of the stack.")
    void pushingUpdatesSize() {
        Stack<Integer> stack = new LinkedStack<>();
        stack.push(99);
        stack.push(101);
        assertEquals(2, stack.size());
    }

    @Test
    @DisplayName("Pushing an item results in it being on the top.")
    void pushedItemIsTopOfStack() {
        Stack<Integer> stack = new LinkedStack<>();
        stack.push(99);
        assertEquals(99, stack.peek());
    }

    @Test
    @DisplayName("Push and Pop returns in LIFO order.")
    void pushingAndPoppingReturnsElementsInLIFOOrder() {
        Stack<Integer> stack = new LinkedStack<>();
        for (int i = 0; i < 6; ++i) {
            stack.push(i);
        }
        for (int i = 5; i >= 0; --i) {
            assertEquals(i, stack.pop());
        }
    }

    @Test
    @DisplayName("Pop throws NoSuchElementException when stack is empty.")
    void popEmptyStackThrowsException() {
        Stack<Integer> stack = new LinkedStack<>();
        assertThrows(NoSuchElementException.class, () -> stack.pop());
    }

    @Test
    @DisplayName("Peek throws NoSuchElementException when stack is empty.")
    void peekEmptyStackThrowsException() {
        Stack<Integer> stack = new LinkedStack<>();
        assertThrows(NoSuchElementException.class, () -> stack.peek());
    }

}
