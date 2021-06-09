public interface Stack<T> {

    /**
     * Pushes (adds) an item onto the top of the stack. After the method completes
     * the item added will be the thing on the top of the stack.
     *
     * @param element   The item to be pushed (added) to the stack.
     */
    void push(T element);

    /**
     * Pops (removes) the item from the top of the stack and returns it as the value
     * of this method. After the method completes, the item after the top will be the
     * new top if it exists, otherwise the stack will be empty.
     *
     * @return          The item at the top of the stack.
     */
    T pop();

    /**
     * Peeks (looks) at the item at the top of the stack and returns it as the value
     * of this method. After the method completes, the item will still be on the top
     * of the stack.
     *
     * @return          The item at the top of the stack.
     */
    T peek();

    /**
     * Tests if the stack is empty and returns a Boolean.
     *
     * @return          true if the stack is empty (no items), false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the stack. This method does not handle
     * the size exceeding Integer.MAX_VALUE.
     *
     * @return          The number of elements in the stack.
     */
    int size();

}
