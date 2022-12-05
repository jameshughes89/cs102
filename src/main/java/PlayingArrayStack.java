public class PlayingArrayStack {
    public static void main(String[] args) {
        // Create an ArrayStack
        Stack<Integer> myStack = new ArrayStack<>(5);

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

        // Test expand capacity
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
        } catch (EmptyCollectionException e) {
            e.printStackTrace();
        }
        try {
            myStack.pop();
        } catch (EmptyCollectionException e) {
            e.printStackTrace();
        }
    }
}
