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
    void hasNext_sizeZeroCapacityTenArray_returnsFalse() {
        Integer[] a = {null, null, null, null, null, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 0);
        assertFalse(it.hasNext());
    }

    @Test
    void hasNext_sizeOneCapacityTenArray_returnsTrue() {
        Integer[] a = {10, null, null, null, null, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 1);
        assertTrue(it.hasNext());
    }

    @Test
    void hasNext_sizeFiveCapacityTenArray_returnsTrue() {
        Integer[] a = {10, 11, 12, 13, 14, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 5);
        assertTrue(it.hasNext());
    }

    @Test
    void hasNext_sizeOneCapacityTenArrayAfterHasNext_doesNotChangeState() {
        Integer[] a = {10, null, null, null, null, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 1);
        it.hasNext();
        assertTrue(it.hasNext());
        assertEquals(10, it.next());
    }

    @Test
    void hasNext_sizeFiveCapacityTenArrayAfterHasNext_doesNotChangeState() {
        Integer[] a = {10, 11, 12, 13, 14, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 5);
        it.hasNext();
        assertTrue(it.hasNext());
        assertEquals(10, it.next());
    }

    @Test
    void hasNext_endOfSizeOneCapacityTenArray_returnsFalse() {
        Integer[] a = {10, null, null, null, null, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 1);
        it.next();
        assertFalse(it.hasNext());
    }

    @Test
    void hasNext_endOfSizeFiveCapacityTenArray_returnsFalse() {
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
    void hasNext_endOfFullCapacityTenArray_returnsFalse() {
        Integer[] a = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        Iterator<Integer> it = new ArrayIterator<>(a, 10);
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
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
    void nest_endOfFullCapacityOneArray_throwsException() {
        Integer[] a = {10};
        Iterator<Integer> it = new ArrayIterator<>(a, 1);
        it.next();
        assertThrows(NoSuchElementException.class, () -> it.next());
    }

    @Test
    void next_sizeZeroCapacityTenArray_throwsException() {
        Integer[] a = {null, null, null, null, null, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 0);
        assertThrows(NoSuchElementException.class, () -> it.next());
    }

    @Test
    void next_sizeOneCapacityTenArray_returnsElement() {
        Integer[] a = {10, null, null, null, null, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 1);
        assertEquals(10, it.next());
    }

    @Test
    void next_sizeFiveCapacityTenArray_returnsElementsInCorrectOrder() {
        Integer[] a = {10, 11, 12, 13, 14, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 5);
        assertEquals(10, it.next());
        assertEquals(11, it.next());
        assertEquals(12, it.next());
        assertEquals(13, it.next());
        assertEquals(14, it.next());
    }

    @Test
    void next_endOfSizeFiveCapacityTenArray_throwsException() {
        Integer[] a = {10, 11, 12, 13, 14, null, null, null, null, null};
        Iterator<Integer> it = new ArrayIterator<>(a, 5);
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        assertThrows(NoSuchElementException.class, () -> it.next());
    }

    @Test
    void next_endOfFullCapacityTenArray_throwsException() {
        Integer[] a = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        Iterator<Integer> it = new ArrayIterator<>(a, 10);
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        assertThrows(NoSuchElementException.class, () -> it.next());
    }
}
