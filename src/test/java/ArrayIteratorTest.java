import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
            assertEquals(10, iterator.next());
        }

        @Test
        void next_capacityMany_returnsElement() {
            ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{10, null, null, null, null}, 1);
            assertEquals(10, iterator.next());
        }

        @Test
        void hasNext_postNextCapacityOne_returnsFalse() {
            ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{10}, 1);
            iterator.next();
            assertFalse(iterator.hasNext());
        }

        @Test
        void hasNext_postNextCapacityMany_returnsFalse() {
            ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{10, null, null, null, null}, 1);
            iterator.next();
            assertFalse(iterator.hasNext());
        }

        @Test
        void next_postNextCapacityOne_throwsNoSuchElementException() {
            ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{10}, 1);
            iterator.next();
            assertThrows(NoSuchElementException.class, () -> iterator.next());
        }

        @Test
        void next_postNextCapacityMany_throwsNoSuchElementException() {
            ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{10, null, null, null, null}, 1);
            iterator.next();
            assertThrows(NoSuchElementException.class, () -> iterator.next());
        }
    }

    @Nested
    class WhenMany {

        @Test
        void hasNext_capacityMany_returnsTrue() {
            ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{10, 11, 12, 13, 14}, 5);
            assertTrue(iterator.hasNext());
        }

        @Test
        void next_calledManyCapacityMany_returnsElements() {
            ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{10, 11, 12, 13, 14}, 5);
            assertAll(() -> assertEquals(10, iterator.next()),
                    () -> assertEquals(11, iterator.next()),
                    () -> assertEquals(12, iterator.next()),
                    () -> assertEquals(13, iterator.next()),
                    () -> assertEquals(14, iterator.next()));
        }

        @Test
        void hasNext_postNextCalledManyCapacityMany_returnsFalse() {
            ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{10, 11, 12, 13, 14}, 5);
            iterator.next();
            iterator.next();
            iterator.next();
            iterator.next();
            iterator.next();
            assertFalse(iterator.hasNext());
        }

        @Test
        void next_postNextCalledManyCapacityMany_throwsNoSuchElementException() {
            ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{10, 11, 12, 13, 14}, 5);
            iterator.next();
            iterator.next();
            iterator.next();
            iterator.next();
            iterator.next();
            assertThrows(NoSuchElementException.class, () -> iterator.next());
        }
    }
}
