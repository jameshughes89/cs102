import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {
    @Test
    void getData_dataNotExists_returnsNull() {
        assertNull(new Node<>().getData());
    }

    @Test
    void getNext_nextNotExists_returnsNull() {
        assertNull(new Node<>().getNext());
    }

    @Test
    void getData_dataExists_returnsData() {
        Node<Integer> node = new Node<>();
        node.setData(10);
        assertEquals(10, node.getData());
    }

    @Test
    void getNext_nextExists_returnsNext() {
        Node<Integer> node = new Node<>();
        Node<Integer> nextNode = new Node<>();
        node.setNext(nextNode);
        assertSame(nextNode, node.getNext());
    }

    @Test
    void getData_dataConstructor_returnsData() {
        assertEquals(10, new Node<>(10).getData());
    }

    @Test
    void getNext_dataConstructor_returnsNull() {
        assertNull(new Node<>().getNext());
    }
}
