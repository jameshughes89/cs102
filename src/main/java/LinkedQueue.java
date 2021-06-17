public class LinkedQueue<T> implements Queue<T> {

    Node<T> front;
    Node<T> rear;
    int size;

    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public void enqueue(T element) {

    }

    @Override
    public T dequeue() {
        return null;
    }

    @Override
    public T first() {
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


    /**
     * A Node class for a singly linked structure. Each node
     * contains a reference to data of type T, which may be
     * null, and a reference to the next/subsequent/successor
     * singly linked node, which may also be null.
     *
     * This class is a static nested class since the node
     * class is only needed for the implementation of the
     * LinkedQueue.
     *
     * @param <T>   Type of the data being stored in the node
     */
    private static class Node<T> {

        private T data;
        private LinkedQueue.Node<T> next;

        public Node() {
            this(null);
        }

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public LinkedQueue.Node<T> getNext() {
            return next;
        }

        public void setNext(LinkedQueue.Node<T> next) {
            this.next = next;
        }
    }
}
