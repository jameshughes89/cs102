import java.util.Arrays;
import java.util.Objects;

/**
 * Implementation of a stack with an array as the container. The array container will automatically "grow" to
 * accommodate adding beyond the initial capacity.
 *
 * @param <T> Type of elements that are to be in the stack.
 */
public class ArrayStack<T> implements Stack<T> {

    private static final int DEFAULT_CAPACITY = 100;
    private T[] stack;
    private int top;

    /**
     * Create an empty ArrayStack of the default capacity.
     */
    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Create an empty ArrayStack with the specified capacity.
     *
     * @param initialCapacity Starting capacity of the fixed length array.
     */
    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity) {
        top = 0;
        // Generic types cannot be instantiated, so an array of type "Object" is created that is then cast to type T.
        // This does generate a compile time warning that is being suppressed with the @ annotation.
        stack = (T[]) new Object[initialCapacity];
    }

    @Override
    public boolean push(T element) {
        if (size() == stack.length) {
            expandCapacity();
        }
        stack[top] = element;
        top++;
        return true;
    }

    /**
     * Doubles the size of the stack array container and copy the contents from the old array to the new array.
     */
    @SuppressWarnings("unchecked")
    private void expandCapacity() {
        T[] newStack = (T[]) new Object[stack.length * 2];
        for (int i = 0; i < stack.length; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        T returnElement = stack[top - 1];
        stack[top - 1] = null;
        top--;
        return returnElement;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyCollectionException();
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
        for (int i = 0; i < size(); i++) {
            builder.insert(0, ", ");
            builder.insert(0, stack[i]);
        }
        return builder.toString();
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArrayStack<?> that = (ArrayStack<?>) o;
        return Arrays.equals(this.stack, 0, this.top, that.stack, 0, that.top);
    }

    @Override
    public final int hashCode() {
        int result = Objects.hash(top);
        for (int i = 0; i < size(); i++) {
            result = result * 97 + Objects.hashCode(stack[i]);
        }
        return result;
    }
}
