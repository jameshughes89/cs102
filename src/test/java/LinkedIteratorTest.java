import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedIteratorTest {

    @SafeVarargs
    private <T> Node<T> makeLinkedStructure(T t1, T... ts) {
        Node<T> head = new Node<>(t1);
        Node<T> current = head;
        for (int i = 0; i < ts.length; ++i) {
            Node<T> node = new Node<>(ts[i]);
            current.setNext(node);
            current = node;
        }
        return head;
    }

    @Test
    void hasNext_sizeZeroLinkedStructure_returnsFalse() {
        Node<Integer> head = null;
        Iterator<Integer> it = new LinkedIterator<>(head);
        assertFalse(it.hasNext());
    }

    @Test
    void hasNext_sizeOneLinkedStructure_returnsTrue() {
        Node<Integer> head = new Node<>(10);
        Iterator<Integer> it = new LinkedIterator<>(head);
        assertTrue(it.hasNext());
    }

    @Test
    void hasNext_sizeFiveLinkedStructure_returnsTrue() {
        Node<Integer> head = makeLinkedStructure(10, 11, 12, 13, 14);
        Iterator<Integer> it = new LinkedIterator<>(head);
        assertTrue(it.hasNext());
    }

    @Test
    void hasNext_sizeOneLinkedStructureAfterHasNext_doesNotChangeState() {
        Node<Integer> head = new Node<>(10);
        Iterator<Integer> it = new LinkedIterator<>(head);
        it.hasNext();
        assertTrue(it.hasNext());
        assertEquals(10, it.next());
    }

    @Test
    void hasNext_sizeFiveLinkedStructureAfterFiveHasNext_doesNotChangeState() {
        Node<Integer> head = makeLinkedStructure(10, 11, 12, 13, 14);
        Iterator<Integer> it = new LinkedIterator<>(head);
        it.hasNext();
        assertTrue(it.hasNext());
        assertEquals(10, it.next());
    }

    @Test
    void hasNext_endOfSizeOneLinkedStructure_returnsFalse() {
        Node<Integer> head = new Node<>(10);
        Iterator<Integer> it = new LinkedIterator<>(head);
        it.next();
        assertFalse(it.hasNext());
    }

    @Test
    void hasNext_endOfSizeFiveLinkedStructure_returnsFalse() {
        Node<Integer> head = makeLinkedStructure(10, 11, 12, 13, 14);
        Iterator<Integer> it = new LinkedIterator<>(head);
        for (int i = 0; i < 5; ++i) {
            it.next();
        }
        assertFalse(it.hasNext());
    }

    @Test
    void next_sizeZeroLinkedStructure_throwsException() {
        Node<Integer> head = null;
        Iterator<Integer> it = new LinkedIterator<>(head);
        assertThrows(NoSuchElementException.class, () -> it.next());
    }

    @Test
    void next_sizeOneLinkedStructure_returnsElement() {
        Node<Integer> head = new Node<>(10);
        Iterator<Integer> it = new LinkedIterator<>(head);
        assertEquals(10, it.next());
    }

    @Test
    void next_sizeFiveLinkedStructure_returnsElementsInCorrectOrder() {
        Node<Integer> head = makeLinkedStructure(10, 11, 12, 13, 14);
        Iterator<Integer> it = new LinkedIterator<>(head);
        assertEquals(10, it.next());
        assertEquals(11, it.next());
        assertEquals(12, it.next());
        assertEquals(13, it.next());
        assertEquals(14, it.next());
    }

    @Test
    void next_endOfSizeFiveLinkedStructure_throwsException() {
        Node<Integer> head = makeLinkedStructure(10, 11, 12, 13, 14);
        Iterator<Integer> it = new LinkedIterator<>(head);
        for (int i = 0; i < 5; ++i) {
            it.next();
        }
        assertThrows(NoSuchElementException.class, () -> it.next());
    }
}
