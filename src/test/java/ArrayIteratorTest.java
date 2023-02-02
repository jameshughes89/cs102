import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayIteratorTest {

    @Nested
    class WhenEmpty {

        @Test
        void hasNext_capacityZero_returnsFalse() {
            ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{}, 0);
            assertFalse(iterator.hasNext());
        }

        @Test
        void hasNext_capacityOne_returnsFalse() {
            ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{null}, 0);
            assertFalse(iterator.hasNext());
        }

        @Test
        void hasNext_capacityMany_returnsFalse() {
            ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{null, null, null, null, null}, 0);
            assertFalse(iterator.hasNext());
        }

        @Test
        void next_capacityZero_throwsNoSuchElementException() {
            ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{}, 0);
            assertThrows(NoSuchElementException.class, () -> iterator.next());
        }

        @Test
        void next_capacityOne_throwsNoSuchElementException() {
            ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{null}, 0);
            assertThrows(NoSuchElementException.class, () -> iterator.next());
        }

        @Test
        void next_capacityMany_throwsNoSuchElementException() {
            ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{null, null, null, null, null}, 0);
            assertThrows(NoSuchElementException.class, () -> iterator.next());
        }
    }

    @Nested
    class WhenSingleton {

        @Test
        void constructor_capacityZero_throwsIllegalArgumentException() {
            assertThrows(IllegalArgumentException.class, () -> new ArrayIterator<>(new Integer[]{}, 1));
        }


        @Test
        void hasNext_capacityOne_returnsTrue() {
            ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{10}, 1);
            assertTrue(iterator.hasNext());
        }

        @Test
        void hasNext_capacityMany_returnsTrue() {
            ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{10, null, null, null, null}, 1);
            assertTrue(iterator.hasNext());
        }

        @Test
        void next_capacityOne_returnsElement() {
            ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{10}, 1);
            List<Integer> list = new ArrayList<>();
            iterator.forEachRemaining(list::add);
            assertEquals(List.of(10), list);
        }

        @Test
        void next_capacityMany_returnsElement() {
            ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{10, null, null, null, null}, 1);
            List<Integer> list = new ArrayList<>();
            iterator.forEachRemaining(list::add);
            assertEquals(List.of(10), list);
        }
    }

    @Nested
    class WhenMany {

        @Test
        void constructor_capacityZero_throwsIllegalArgumentException() {
            assertThrows(IllegalArgumentException.class, () -> new ArrayIterator<>(new Integer[]{}, 5));
        }

        @Test
        void constructor_capacityOne_throwsIllegalArgumentException() {
            assertThrows(IllegalArgumentException.class, () -> new ArrayIterator<>(new Integer[]{10}, 5));
        }

        @Test
        void hasNext_capacityMany_returnsTrue() {
            ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{10, 11, 12, 13, 14}, 5);
            assertTrue(iterator.hasNext());
        }

        @Test
        void next_capacityMany_returnsElements() {
            ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{10, 11, 12, 13, 14}, 5);
            List<Integer> list = new ArrayList<>();
            iterator.forEachRemaining(list::add);
            assertEquals(List.of(10, 11, 12, 13, 14), list);
        }
    }
}
