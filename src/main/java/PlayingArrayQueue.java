import java.util.NoSuchElementException;

public class PlayingArrayQueue {
    public static void main(String[] args) {
        // Create a ArrayQueue
        Queue<Integer> myQueue = new ArrayQueue<>(5);

        // Check queue is empty
        System.out.println(myQueue.size());
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue);

        // Test enqueue
        myQueue.enqueue(0);
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        System.out.println(myQueue.size());
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue);

        // Test enqueue more to check expandCapacity
        myQueue.enqueue(10);
        myQueue.enqueue(11);
        myQueue.enqueue(12);
        myQueue.enqueue(13);
        myQueue.enqueue(14);
        System.out.println(myQueue.size());
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue);

        // Test first
        System.out.println(myQueue.first());
        System.out.println(myQueue.size());
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue);

        // Test dequeue
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.size());
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue);

        // Test first and dequeue throwing exception
        try {
            myQueue.first();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        try {
            myQueue.dequeue();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}
