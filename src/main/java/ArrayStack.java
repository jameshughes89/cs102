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
}
