import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayIteratorTest {

    @Test
    void hasNext_emptyArray_returnsFalse() {
        Integer[] a = {null, null, null, null, null, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 0);
        assertFalse(it.hasNext());
    }

    @Test
    void hasNext_singleElementArray_returnsTrue() {
        Integer[] a = {10, null, null, null, null, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 1);
        assertTrue(it.hasNext());
    }

    @Test
    void hasNext_multiElementArray_returnsTrue() {
        Integer[] a = {10, 11, 12, 13, 14, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 5);
        assertTrue(it.hasNext());
    }

    @Test
    void hasNext_singleElementArrayAfterHasNextAndNoNextCall_returnsTrue() {
        Integer[] a = {10, null, null, null, null, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 1);
        it.hasNext();
        assertTrue(it.hasNext());
    }

    @Test
    void hasNext_multiElementArrayAfterHasNextAndNoNextCall_returnsTrue() {
        Integer[] a = {10, 11, 12, 13, 14, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 5);
        it.hasNext();
        it.hasNext();
        it.hasNext();
        it.hasNext();
        it.hasNext();
        assertTrue(it.hasNext());
    }

    @Test
    void hasNext_endOfSingleElementArray_returnsFalse() {
        Integer[] a = {10, null, null, null, null, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 1);
        it.next();
        assertFalse(it.hasNext());
    }

    @Test
    void hasNext_endOfSingleElementArrayAfterHasNext_returnsFalse() {
        Integer[] a = {10, null, null, null, null, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 1);
        it.next();
        it.hasNext();
        assertFalse(it.hasNext());
    }

    @Test
    void hasNext_endOfMultiElementArray_returnsFalse() {
        Integer[] a = {10, 11, 12, 13, 14, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 5);
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        assertFalse(it.hasNext());
    }

    @Test
    void hasNext_endOfMultiElementArrayAfterHasNext_returnsFalse() {
        Integer[] a = {10, 11, 12, 13, 14, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 5);
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.hasNext();
        assertFalse(it.hasNext());
    }

    @Test
    void next_emptyArray_throwsException() {
        Integer[] a = {null, null, null, null, null, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 0);
        assertThrows(NoSuchElementException.class, () -> it.next());
    }

    @Test
    void next_singleElementArray_returnsElement() {
        Integer[] a = {10, null, null, null, null, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 1);
        assertEquals(10, it.next());
    }

    @Test
    void next_multiElementArray_returnsElementsInCorrectOrder() {
        Integer[] a = {10, 11, 12, 13, 14, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 5);
        assertEquals(10, it.next());
        assertEquals(11, it.next());
        assertEquals(12, it.next());
        assertEquals(13, it.next());
        assertEquals(14, it.next());
    }

    @Test
    void next_endOfMultiElementArray_throwsException() {
        Integer[] a = {10, 11, 12, 13, 14, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 5);
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        assertThrows(NoSuchElementException.class, () -> it.next());
    }
}
