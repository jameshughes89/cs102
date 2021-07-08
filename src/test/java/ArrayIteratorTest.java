import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayIteratorTest {

    // Note:
    //      Size is the number of "meaningful" elements in the array
    //      Capacity is the number of available indices in the array

    @Test
    void hasNext_capacityZeroArray_returnsFalse() {
        Integer[] a = {};
        Iterator<Integer> it = new ArrayIterator<>(a, 0);
        assertFalse(it.hasNext());
    }

    @Test
    void hasNext_fullCapacityOneArray_returnsTrue() {
        Integer[] a = {10};
        Iterator<Integer> it = new ArrayIterator<>(a, 1);
        assertTrue(it.hasNext());
    }

    @Test
    void hasNext_endOfFullCapacityOneArray_returnsFalse() {
        Integer[] a = {10};
        Iterator<Integer> it = new ArrayIterator<>(a, 1);
        it.next();
        assertFalse(it.hasNext());
    }

    @Test
    void hasNext_sizeZeroArray_returnsFalse() {
        Integer[] a = {null, null, null, null, null, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 0);
        assertFalse(it.hasNext());
    }

    @Test
    void hasNext_sizeOneArray_returnsTrue() {
        Integer[] a = {10, null, null, null, null, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 1);
        assertTrue(it.hasNext());
    }

    @Test
    void hasNext_sizeFiveArray_returnsTrue() {
        Integer[] a = {10, 11, 12, 13, 14, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 5);
        assertTrue(it.hasNext());
    }

    @Test
    void hasNext_sizeOneArrayAfterHasNext_doesNotChangeState() {
        Integer[] a = {10, null, null, null, null, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 1);
        it.hasNext();
        assertTrue(it.hasNext());
        assertEquals(10, it.next());
    }

    @Test
    void hasNext_sizeFiveArray_doesNotChangeState() {
        Integer[] a = {10, 11, 12, 13, 14, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 5);
        it.hasNext();
        it.hasNext();
        it.hasNext();
        it.hasNext();
        it.hasNext();
        assertTrue(it.hasNext());
        assertEquals(10, it.next());
    }

    @Test
    void hasNext_endOfSizeOneArray_returnsFalse() {
        Integer[] a = {10, null, null, null, null, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 1);
        it.next();
        assertFalse(it.hasNext());
    }

    @Test
    void hasNext_endOfSizeFiveArray_returnsFalse() {
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
    void next_capacityZeroArray_throwsException() {
        Integer[] a = {};
        Iterator<Integer> it = new ArrayIterator<>(a, 0);
        assertThrows(NoSuchElementException.class, () -> it.next());
    }

    @Test
    void next_fullCapacityOneArray_returnsElement() {
        Integer[] a = {10};
        Iterator<Integer> it = new ArrayIterator<>(a, 1);
        assertEquals(10, it.next());
    }

    @Test
    void nest_endOfFullCapacityOneArray_throwsException() {
        Integer[] a = {10};
        Iterator<Integer> it = new ArrayIterator<>(a, 1);
        it.next();
        assertThrows(NoSuchElementException.class, () -> it.next());
    }

    @Test
    void next_sizeZeroArray_throwsException() {
        Integer[] a = {null, null, null, null, null, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 0);
        assertThrows(NoSuchElementException.class, () -> it.next());
    }

    @Test
    void next_sizeOneArray_returnsElement() {
        Integer[] a = {10, null, null, null, null, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 1);
        assertEquals(10, it.next());
    }

    @Test
    void next_sizeFiveArray_returnsElementsInCorrectOrder() {
        Integer[] a = {10, 11, 12, 13, 14, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 5);
        assertEquals(10, it.next());
        assertEquals(11, it.next());
        assertEquals(12, it.next());
        assertEquals(13, it.next());
        assertEquals(14, it.next());
    }

    @Test
    void next_endOfSizeFiveArray_throwsException() {
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
