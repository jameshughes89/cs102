/**
 * A stack is a linear data structure that has all the action happen from one end referred to as the "top"; all
 * additions (pushes) and removals (pops) happen from the same end, the "top". This data structure has a "last in,
 * first out" (LIFO) property --- the last thing that was added to the stack would be the first thing removed from
 * the stack if a remove were to happen. Adding and removing from anywhere else in the stack is disallowed.
 *
 * @param <T> Type of elements that are to be on the stack.
 */
public interface Stack<T> {

    /**
     * Pushes (adds) an item onto the top of the stack. After the method completes
     * the item added will be the thing on the top of the stack.
     *
     * @param element The item to be pushed (added) to the stack.
     */
    void push(T element);

    /**
     * Pops (removes) the item from the top of the stack and returns it as the value
     * of this method. After the method completes, the item after the top will be the
     * new top if it exists, otherwise the stack will be empty.
     *
     * @return The item at the top of the stack.
     */
    T pop();

    /**
     * Peeks (looks) at the item at the top of the stack and returns it as the value
     * of this method. After the method completes, the item will still be on the top
     * of the stack.
     *
     * @return The item at the top of the stack.
     */
    T peek();

    /**
     * Tests if the stack is empty and returns a Boolean.
     *
     * @return true if the stack is empty (no items), false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the stack. This method does not handle
     * the size exceeding Integer.MAX_VALUE.
     *
     * @return The number of elements in the stack.
     */
    int size();
}
