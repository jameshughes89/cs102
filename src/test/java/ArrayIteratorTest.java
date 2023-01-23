import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayIteratorTest {

    @Test
    void hasNext_empty_returnsFalse() {
        ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{null, null, null, null, null}, 0);
        assertFalse(iterator.hasNext());
    }

    @Test
    void next_empty_throwsNoSuchElementException() {
        ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{null, null, null, null, null}, 0);
        assertThrows(NoSuchElementException.class, () -> iterator.next());
    }

    @Test
    void hasNext_singleton_returnsTrue() {
        ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{10, null, null, null, null}, 1);
        assertTrue(iterator.hasNext());
    }

    @Test
    void next_singleton_returnsElement() {
        ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{10, null, null, null, null}, 1);
        assertEquals(10, iterator.next());
    }

    @Test
    void hasNext_many_returnsTrue() {
        ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{10, 11, 12, 13, null}, 4);
        assertTrue(iterator.hasNext());
    }

    @Test
    void next_many_returnsElement() {
        ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{10, 11, 12, 13, null}, 4);
        assertEquals(10, iterator.next());
    }
}
