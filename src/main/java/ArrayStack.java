import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ArrayStack<T> implements Stack<T> {

    private static final int DEFAULT_CAPACITY = 100;
    private T[] stack;
    private int top;

    /**
     * Create an ArrayStack of the default capacity.
     */
    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Create an ArrayStack with the specified size.
     *
     * @param initialCapacity Starting capacity of the fixed length array.
     */
    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity) {
        top = 0;
        // Generic types cannot be instantiated so we cast.
        // This does generate a compile time warning that
        // is being suppressed with the @ annotation.
        stack = (T[]) new Object[initialCapacity];
    }

    @Override
    public void push(T element) {
        if (top == stack.length) {
            expandCapacity();
        }
        stack[top] = element;
        top++;
    }

    /**
     * Doubles the size of the stack array and copy the
     * contents over.
     */
    @SuppressWarnings("unchecked")
    private void expandCapacity() {
        T[] newStack = (T[]) new Object[stack.length * 2];
        for (int i = 0; i < stack.length; ++i) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Popping from an empty stack.");
        }
        top--;
        T returnElement = stack[top];
        stack[top] = null;
        return returnElement;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Peeking from an empty stack.");
        }
        return stack[top - 1];
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < top; ++i) {
            builder.append(stack[i]);
            builder.append(", ");
        }
        builder.append("<-- Top");
        return builder.toString();
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayStack<?> that = (ArrayStack<?>) o;
        return top == that.top
                && Arrays.equals(this.stack, 0, this.top, that.stack, 0, that.top);
    }

    @Override
    public final int hashCode() {
        int result = Objects.hash(top);
        result = 31 * result;
        for (int i = 0; i < Math.min(this.top, this.stack.length); i++){
            result += stack[i].hashCode();
        }
        return result;
    }
}
