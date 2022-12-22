public class PlayingLinks {
    public static void main(String[] args) {
        // Create a Node
        Node<Integer> head = new Node<>(0);
        System.out.println(head.getData());

        // Make a linked structure of the numbers 0 -- 9
        Node<Integer> currentNode = head;
        Node<Integer> newNode;

        for (int i = 1; i < 10; i++) {
            newNode = new Node<>(i);
            currentNode.setNext(newNode);
            currentNode = currentNode.getNext();
        }

        // Print the contents of the linked structure
        currentNode = head;
        while (currentNode!= null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }

        // Try adding to the front, middle, and end of the structure

        // Try removing from the front, middle, and end of the structure

    }
}
