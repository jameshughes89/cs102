import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedIteratorTest {

    @Test
    void hasNext_emptyLinked_returnsFalse() {
        Node<Integer> head = null;
        Iterator<Integer> it = new LinkedIterator<>(head);
        assertFalse(it.hasNext());
    }

    @Test
    void hasNext_singleElementLinked_returnsTrue() {
        Node<Integer> head = new Node<>(10);
        Iterator<Integer> it = new LinkedIterator<>(head);
        assertTrue(it.hasNext());
    }

    @Test
    void hasNext_multiElementLinked_returnsTrue() {
        Node<Integer> head = new Node<>(10);
        head.setNext(new Node<>(11));
        head.getNext().setNext(new Node<>(12));
        head.getNext().getNext().setNext(new Node<>(13));
        head.getNext().getNext().getNext().setNext(new Node<>(14));
        Iterator<Integer> it = new LinkedIterator<>(head);
        assertTrue(it.hasNext());
    }

    @Test
    void hasNext_singleElementLinkedAfterHasNextAndNoNextCall_returnsTrue() {
        Node<Integer> head = new Node<>(10);
        Iterator<Integer> it = new LinkedIterator<>(head);
        it.hasNext();
        assertTrue(it.hasNext());
    }

    @Test
    void hasNext_multiElementLinkedAfterHasNextAndNoNextCall_returnsTrue() {
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
    }

    @Test
    void hasNext_endOfSingleElementLinked_returnsFalse() {
        Node<Integer> head = new Node<>(10);
        Iterator<Integer> it = new LinkedIterator<>(head);
        it.next();
        assertFalse(it.hasNext());
    }

    @Test
    void hasNext_endOfSingleElementLinkedAfterHasNext_returnsFalse() {
        Node<Integer> head = new Node<>(10);
        Iterator<Integer> it = new LinkedIterator<>(head);
        it.next();
        it.hasNext();
        assertFalse(it.hasNext());
    }

    @Test
    void hasNext_endOfMultiElementLinked_returnsFalse() {
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
    void hasNext_endOfMultiElementLinkedAfterHasNext_returnsFalse() {
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
        it.hasNext();
        assertFalse(it.hasNext());
    }

    @Test
    void next_emptyLinked_throwsException() {
        Node<Integer> head = null;
        Iterator<Integer> it = new LinkedIterator<>(head);
        assertThrows(NoSuchElementException.class, () -> it.next());
    }

    @Test
    void next_singleElementLinked_returnsElement() {
        Node<Integer> head = new Node<>(10);
        Iterator<Integer> it = new LinkedIterator<>(head);
        assertEquals(10, it.next());
    }

    @Test
    void next_multiElementLinked_returnsElementsInCorrectOrder() {
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
    void next_endOfMultiElementLinked_throwsException() {
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
