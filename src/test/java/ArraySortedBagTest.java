import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ArraySortedBagTest {

    @Test
    void aNewSortedBagIsEmpty() {
        SortedBag<Integer> bag = new ArraySortedBag<>();
        assertTrue(bag.isEmpty());
    }

    @Test
    void emptySortedBagIHasSizeZero() {
        SortedBag<Integer> bag = new ArraySortedBag<>();
        assertEquals(0, bag.size());
    }

    @Test
    void nonEmptySortedBagIsEmptyReturnsFalse() {
        SortedBag<Integer> bag = new ArraySortedBag<>();
        bag.add(99);
        assertFalse(bag.isEmpty());
    }

    @Test
    void containsAddedElementtoSortedBagReturnsTrue() {
        SortedBag<Integer> bag = new ArraySortedBag<>();
        bag.add(99);
        assertTrue(bag.contains(99));
    }

    @Test
    void containsNonAddedElementToSortedBagReturnsFalse() {
        SortedBag<Integer> bag = new ArraySortedBag<>();
        bag.add(99);
        assertFalse(bag.contains(101));
    }

    @Test
    void getCountOfElementWithMultipleCopiesInSortedBagReturnsCorrectCount() {
        SortedBag<Integer> bag = new ArraySortedBag<>();
        bag.add(0);
        bag.add(99);
        bag.add(1);
        bag.add(99);
        bag.add(2);
        bag.add(99);
        assertEquals(3, bag.getCount(99));
    }

    @Test
    void getCountOfElementNotInSortedBagReturnsZero() {
        SortedBag<Integer> bag = new ArraySortedBag<>();
        bag.add(0);
        bag.add(99);
        bag.add(1);
        bag.add(99);
        bag.add(2);
        bag.add(99);
        assertEquals(0, bag.getCount(101));
    }

    @Test
    void addingElementsToSortedBagAreAddedInCorrectOrder() {
        SortedBag<Integer> bag = new ArraySortedBag<>();
        bag.add(5);
        bag.add(1);
        bag.add(2);
        bag.add(0);
        bag.add(4);
        bag.add(3);
        for (int i = 0; i < 6; ++i) {
            assertEquals(i, bag.removeFirst());
        }
    }

    @Test
    void addingBeyondCapacityOfSortedBagCallsExpandCapacityToMakeRoomWhileMaintainingOrdering() {
        SortedBag<Integer> bag = new ArraySortedBag<>(5);
        bag.add(5);
        bag.add(1);
        bag.add(2);
        bag.add(0);
        bag.add(4);
        bag.add(3);
        for (int i = 0; i < 6; ++i) {
            assertEquals(i, bag.removeFirst());
        }
    }

    @Test
    void firstReturnsFirstElementFromSortedBag() {
        SortedBag<Integer> bag = new ArraySortedBag<>();
        bag.add(99);
        bag.add(101);
        assertEquals(99, bag.first());
    }

    @Test
    void firstLeavesElementInSortedBag() {
        SortedBag<Integer> bag = new ArraySortedBag<>();
        bag.add(99);
        bag.add(101);
        bag.first();
        assertTrue(bag.contains(99));
    }

    @Test
    void firstFromEmptySortedBagThrowsException() {
        SortedBag<Integer> bag = new ArraySortedBag<>();
        assertThrows(NoSuchElementException.class, () -> bag.first());
    }

    @Test
    void lastReturnsLastElementFromSortedBag() {
        SortedBag<Integer> bag = new ArraySortedBag<>();
        bag.add(99);
        bag.add(101);
        assertEquals(101, bag.last());
    }

    @Test
    void lastLeavesElementInSortedBag() {
        SortedBag<Integer> bag = new ArraySortedBag<>();
        bag.add(99);
        bag.add(101);
        bag.last();
        assertTrue(bag.contains(101));
    }

    @Test
    void lastFromEmptySortedBagThrowsException() {
        SortedBag<Integer> bag = new ArraySortedBag<>();
        assertThrows(NoSuchElementException.class, () -> bag.last());
    }

    @Test
    void removeFirstReturnsFirstElementFromSortedBag() {
        SortedBag<Integer> bag = new ArraySortedBag<>();
        bag.add(99);
        bag.add(101);
        assertEquals(99, bag.removeFirst());
    }

    @Test
    void removeFirstRemovesFirstElementFromSortedBag() {
        SortedBag<Integer> bag = new ArraySortedBag<>();
        bag.add(99);
        bag.add(101);
        bag.removeFirst();
        assertFalse(bag.contains(99));
    }

    @Test
    void removeFirstFromSortedBagUpdatesSize() {
        SortedBag<Integer> bag = new ArraySortedBag<>();
        bag.add(99);
        bag.add(101);
        bag.removeFirst();
        assertEquals(1, bag.size());
    }

    @Test
    void removeFirstFromEmptySortedBagThrowsException() {
        SortedBag<Integer> bag = new ArraySortedBag<>();
        assertThrows(NoSuchElementException.class, () -> bag.removeFirst());
    }

    @Test
    void removeLastReturnsLastElementFromSortedBag() {
        SortedBag<Integer> bag = new ArraySortedBag<>();
        bag.add(99);
        bag.add(101);
        assertEquals(101, bag.removeLast());
    }

    @Test
    void removeLastRemovesLastElementFromSortedBag() {
        SortedBag<Integer> bag = new ArraySortedBag<>();
        bag.add(99);
        bag.add(101);
        bag.removeLast();
        assertFalse(bag.contains(101));
    }

    @Test
    void removeLastFromSortedBagUpdatesSize() {
        SortedBag<Integer> bag = new ArraySortedBag<>();
        bag.add(99);
        bag.add(101);
        bag.removeLast();
        assertEquals(1, bag.size());
    }

    @Test
    void removeLastFromEmptySortedBagThrowsException() {
        SortedBag<Integer> bag = new ArraySortedBag<>();
        assertThrows(NoSuchElementException.class, () -> bag.removeLast());
    }

    @Test
    void removeReturnsSpecifiedElementFromSortedBag() {
        SortedBag<Integer> bag = new ArraySortedBag<>();
        bag.add(99);
        bag.add(101);
        bag.add(103);
        assertEquals(101, bag.remove(101));
    }

    @Test
    void removeRemovesSpecifiedElementFromSortedBag() {
        SortedBag<Integer> bag = new ArraySortedBag<>();
        bag.add(99);
        bag.add(101);
        bag.add(103);
        bag.remove(101);
        assertFalse(bag.contains(101));
    }

    @Test
    void removeFromSortedBagUpdatesSize() {
        SortedBag<Integer> bag = new ArraySortedBag<>();
        bag.add(99);
        bag.add(101);
        bag.remove(101);
        assertEquals(1, bag.size());
    }

    @Test
    void removeFromEmptySortedBagThrowsException() {
        SortedBag<Integer> bag = new ArraySortedBag<>();
        assertThrows(NoSuchElementException.class, () -> bag.remove(55));
    }

    @Test
    void removeNonExistingElementFromSortedBagThrowsException() {
        SortedBag<Integer> bag = new ArraySortedBag<>();
        bag.add(99);
        bag.add(101);
        assertThrows(NoSuchElementException.class, () -> bag.remove(55));
    }
}
