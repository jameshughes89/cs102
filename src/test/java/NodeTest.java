import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {
    private Node<Integer> classUnderTest;

    @Test
    void getData_dataNotExists_returnsNull() {
        classUnderTest = new Node<>();
        assertNull(classUnderTest.getData());
    }

    @Test
    void getNext_nextNotExists_returnsNull() {
        classUnderTest = new Node<>();
        assertNull(classUnderTest.getNext());
    }

    @Test
    void getData_dataExists_returnsData() {
        classUnderTest = new Node<>();
        classUnderTest.setData(10);
        assertEquals(10, classUnderTest.getData());
    }

    @Test
    void getNext_nextExists_returnsNext() {
        classUnderTest = new Node<>();
        Node<Integer> nextNode = new Node<>();
        classUnderTest.setNext(nextNode);
        assertSame(nextNode, classUnderTest.getNext());
    }
}
