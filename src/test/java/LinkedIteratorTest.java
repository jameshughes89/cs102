import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedIteratorTest {

    @Test
    void hasNext_sizeZero_returnsFalse() {
        Node<Integer> head = null;
        Iterator<Integer> it = new LinkedIterator<>(head);
        assertFalse(it.hasNext());
    }

    @Test
    void hasNext_sizeOne_returnsTrue() {
        Node<Integer> head = new Node<>(10);
        Iterator<Integer> it = new LinkedIterator<>(head);
        assertTrue(it.hasNext());
    }

    @Test
    void hasNext_sizeFive_returnsTrue() {
        Node<Integer> head = new Node<>(10);
        head.setNext(new Node<>(11));
        head.getNext().setNext(new Node<>(12));
        head.getNext().getNext().setNext(new Node<>(13));
        head.getNext().getNext().getNext().setNext(new Node<>(14));
        Iterator<Integer> it = new LinkedIterator<>(head);
        assertTrue(it.hasNext());
    }

    @Test
    void hasNext_sizeOneAfterHasNext_doesNotChangeState() {
        Node<Integer> head = new Node<>(10);
        Iterator<Integer> it = new LinkedIterator<>(head);
        it.hasNext();
        assertTrue(it.hasNext());
        assertEquals(10, it.next());
    }

    @Test
    void hasNext_sizeFiveAfterFiveHasNext_doesNotChangeState() {
        Node<Integer> head = new Node<>(10);
        head.setNext(new Node<>(11));
        head.getNext().setNext(new Node<>(12));
        head.getNext().getNext().setNext(new Node<>(13));
        head.getNext().getNext().getNext().setNext(new Node<>(14));
        Iterator<Integer> it = new LinkedIterator<>(head);
        it.hasNext();
        it.hasNext();
        it.hasNext();
        it.hasNext();
        it.hasNext();
        assertTrue(it.hasNext());
        assertEquals(10, it.next());
    }

    @Test
    void hasNext_endOfSizeOne_returnsFalse() {
        Node<Integer> head = new Node<>(10);
        Iterator<Integer> it = new LinkedIterator<>(head);
        it.next();
        assertFalse(it.hasNext());
    }

    @Test
    void hasNext_endOfSizeFive_returnsFalse() {
        Node<Integer> head = new Node<>(10);
        head.setNext(new Node<>(11));
        head.getNext().setNext(new Node<>(12));
        head.getNext().getNext().setNext(new Node<>(13));
        head.getNext().getNext().getNext().setNext(new Node<>(14));
        Iterator<Integer> it = new LinkedIterator<>(head);
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        assertFalse(it.hasNext());
    }

    @Test
    void next_sizeZero_throwsException() {
        Node<Integer> head = null;
        Iterator<Integer> it = new LinkedIterator<>(head);
        assertThrows(NoSuchElementException.class, () -> it.next());
    }

    @Test
    void next_sizeOne_returnsElement() {
        Node<Integer> head = new Node<>(10);
        Iterator<Integer> it = new LinkedIterator<>(head);
        assertEquals(10, it.next());
    }

    @Test
    void next_sizeFive_returnsElementsInCorrectOrder() {
        Node<Integer> head = new Node<>(10);
        head.setNext(new Node<>(11));
        head.getNext().setNext(new Node<>(12));
        head.getNext().getNext().setNext(new Node<>(13));
        head.getNext().getNext().getNext().setNext(new Node<>(14));
        Iterator<Integer> it = new LinkedIterator<>(head);
        assertEquals(10, it.next());
        assertEquals(11, it.next());
        assertEquals(12, it.next());
        assertEquals(13, it.next());
        assertEquals(14, it.next());
    }

    @Test
    void next_endOfSizeFive_throwsException() {
        Node<Integer> head = new Node<>(10);
        head.setNext(new Node<>(11));
        head.getNext().setNext(new Node<>(12));
        head.getNext().getNext().setNext(new Node<>(13));
        head.getNext().getNext().getNext().setNext(new Node<>(14));
        Iterator<Integer> it = new LinkedIterator<>(head);
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        assertThrows(NoSuchElementException.class, () -> it.next());
    }
}
