import java.util.NoSuchElementException;

public class PlayingLinkedStack {
    public static void main(String[] args) {
        // Create a LinkedStack
        Stack<Integer> myStack = new LinkedStack<>();

        // Check stack is empty
        System.out.println(myStack.size());
        System.out.println(myStack.isEmpty());
        System.out.println(myStack);

        // Test push
        myStack.push(0);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println(myStack.size());
        System.out.println(myStack.isEmpty());
        System.out.println(myStack);

        // No test for expandCapacity since LinkedStack
        // doesn't need it, but test more pushes anyways
        // as the functionality does not change either way
        myStack.push(10);
        myStack.push(11);
        myStack.push(12);
        myStack.push(13);
        myStack.push(14);
        System.out.println(myStack.size());
        System.out.println(myStack.isEmpty());
        System.out.println(myStack);

        // Test peek
        System.out.println(myStack.peek());
        System.out.println(myStack.size());
        System.out.println(myStack.isEmpty());
        System.out.println(myStack);

        // Test Pop
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.size());
        System.out.println(myStack.isEmpty());
        System.out.println(myStack);

        // Test peek and pop throwing exception
        try {
            myStack.peek();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        try {
            myStack.pop();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}
