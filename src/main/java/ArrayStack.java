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
        for (int i = 0; i < stack.length; ++i) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }
}
