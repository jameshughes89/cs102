import java.util.EmptyStackException;

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
     * @param size      Starting size of the fixed length array.
     */
    @SuppressWarnings("unchecked")
    public ArrayStack(int size) {
        top = 0;
        // Generic types cannot be instantiated so we cast.
        // This does generate a compile time warning that
        // is being suppressed with the @ annotation.
        stack = (T[]) new Object[size];
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
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;

    @Override
    public void push(T element) {

    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;

    }

    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        top--;
        T returnElement = stack[top];
        stack[top] = null;
        return returnElement;
    }

    public T peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
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
        builder.append("<-- Top\n");
        return builder.toString();
    }

}
