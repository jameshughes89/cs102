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
     * Adds (pushes) an element to the stack. The push adds the element to the stack such that it becomes the new
     * "top" of the stack.
     *
     * @param element The item to be pushed (added) to the stack.
     * @return True if the element was pushed (added) successfully, false otherwise.
     */
    boolean push(T element);

    /**
     * Removes (pops) an element from the stack and returns the removed element. The pop removes the element from the
     * "top" of the stack such that the subsequent element, if it exists, becomes the new "top" of the stack. If no
     * subsequent element exists, the "top" will be null and the stack will be empty.
     *
     * @return The element on the "top" of the stack.
     * @throws EmptyCollectionException Throw if removing from an empty stack.
     */
    T pop();

    /**
     * Return the element on the "top" of the stack. Peeking leaves the element on the "top" of the stack and leaves
     * the collection unchanged.
     *
     * @return The element on the "top" of the stack.
     * @throws EmptyCollectionException Throw if peeking from an empty stack.
     */
    T peek();

    /**
     * Checks if the stack is currently empty.
     *
     * @return True if the stack is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the stack. This method does not handle the case of size exceeding
     * Integer.MAX_VALUE.
     *
     * @return The number of elements in the stack.
     */
    int size();
}
