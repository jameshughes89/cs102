import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    @Test
    @DisplayName("A new stack starts empty.")
    void aNewStackIsEmpty() {
        Stack<Integer> stack = new ArrayStack<>();
        assertTrue(stack.isEmpty());
    }

    @Test
    @DisplayName("An empty stack has size 0.")
    void emptyStackHasSizeZero() {
        Stack<Integer> stack = new ArrayStack<>();
        assertEquals(0, stack.size());
    }

    @Test
    @DisplayName("isEmpty return false when it is non empty.")
    void nonEmptyStackIsEmptyReturnsFalse() {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(99);
        assertFalse(stack.isEmpty());
    }

    @Test
    @DisplayName("Pushing items updates the size of the stack.")
    void pushingUpdatesSize() {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(99);
        stack.push(101);
        assertEquals(2, stack.size());
    }

    @Test
    @DisplayName("Pushing an item results in it being on the top.")
    void pushedItemIsTopOfStack() {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(99);
        assertEquals(99, stack.peek());
    }

    @Test
    @DisplayName("Pushing 6 elements on stack expands capacity.")
    void pushingBeyondCapacityCallsExpandCapacityToMakeRoom() {
        // Initializing to 5 means pushing 6 items should call
        // expandCapacity() such that the sixth item pushed
        // would be on top
        Stack<Integer> stack = new ArrayStack<>(5);
        for (int i = 0; i < 6; ++i) {
            stack.push(i);
        }
        assertEquals(5, stack.peek());
    }

    @Test
    @DisplayName("Push and Pop returns in LIFO order.")
    void pushingAndPoppingReturnsElementsInLIFOOrder() {
        Stack<Integer> stack = new ArrayStack<>();
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
        Stack<Integer> stack = new ArrayStack<>();
        assertThrows(NoSuchElementException.class, () -> stack.pop());
    }

    @Test
    @DisplayName("Peek throws NoSuchElementException when stack is empty.")
    void peekEmptyStackThrowsException() {
        Stack<Integer> stack = new ArrayStack<>();
        assertThrows(NoSuchElementException.class, () -> stack.peek());
    }
}
