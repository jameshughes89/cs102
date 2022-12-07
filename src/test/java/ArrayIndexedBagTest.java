import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayIndexedBagTest {

    @Test
    void add_successfullyAdds_returnsTrue() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        assertTrue(bag.add(10));
    }

    @Test
    void add_successfullyAddsAtIndex_returnsTrue() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        assertTrue(bag.add(0, 10));
    }

    @Test
    void remove_successfullyremoves_returnsTrue() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(10);
        assertTrue(bag.remove(Integer.valueOf(10)));
    }

    @Test
    void set_successfullySets_returnsPreviousElement() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(10);
        assertEquals(10, bag.set(0, 20));
    }

    @Test
    void aNewIndexedBagIsEmpty() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        assertTrue(bag.isEmpty());
    }

    @Test
    void emptyIndexedBagHasSizeZero() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        assertEquals(0, bag.size());
    }

    @Test
    void nonEmptyIndexedBagIsEmptyReturnsFalse() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(99);
        assertFalse(bag.isEmpty());
    }

    @Test
    void addingToEndOfIndexedBagUpdatesSize() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(99);
        bag.add(101);
        assertEquals(2, bag.size());
    }

    @Test
    void addingToIndexOfIndexedBagUpdatesSize() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(99);
        bag.add(0, 101);
        assertEquals(2, bag.size());
    }

    @Test
    void containsAddedElementToIndexedBagReturnsTrue() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(99);
        assertTrue(bag.contains(99));
    }

    @Test
    void containsMultipleExistingElementToIndexedBagReturnsTrue() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(99);
        bag.add(99);
        bag.add(99);
        assertTrue(bag.contains(99));
    }

    @Test
    void containsNonAddedElementToIndexedBagReturnsFalse() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(99);
        assertFalse(bag.contains(101));
    }

    @Test
    void getCountOfElementWithSingleCopyInIndexedBagReturnsCorrectCount() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(0);
        bag.add(99);
        bag.add(1);
        bag.add(99);
        bag.add(2);
        bag.add(99);
        assertEquals(1, bag.count(1));
    }

    @Test
    void getCountOfElementWithMultipleCopiesInIndexedBagReturnsCorrectCount() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(0);
        bag.add(99);
        bag.add(1);
        bag.add(99);
        bag.add(2);
        bag.add(99);
        assertEquals(3, bag.count(99));
    }

    @Test
    void getCountOfElementNotInIndexedBagReturnsZero() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(0);
        bag.add(99);
        bag.add(1);
        bag.add(99);
        bag.add(2);
        bag.add(99);
        assertEquals(0, bag.count(101));
    }

    @Test
    void addingToEndOfIndexedBagPutsElementAtEnd() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        for (int i = 0; i < 6; ++i) {
            bag.add(i);
        }
        for (int i = 0; i < 6; ++i) {
            assertEquals(i, bag.get(i));
        }
    }

    @Test
    void addingToIndexZeroOfIndexedBagPutsElementAtFront() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        for (int i = 0; i < 6; ++i) {
            bag.add(0, i);
        }
        int index = 0;
        for (int value = 5; value >= 0; --value) {
            assertEquals(index, bag.get(value));
            index++;
        }
    }

    @Test
    void addingToSpecifiedIndicesInIndexedBagResultsInSpecifiedOrder() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(4);
        bag.add(0, 0);
        bag.add(1, 2);
        bag.add(3, 5);
        bag.add(2, 3);
        bag.add(1, 1);
        for (int i = 0; i < 6; ++i) {
            assertEquals(i, bag.get(i));
        }
    }

    @Test
    void addingBeyondCapacityOfIndexedBagCallsExpandCapacityToMakeRoomWhileMaintainingOrdering() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>(5);
        for (int i = 0; i < 10; ++i) {
            bag.add(i);
        }
        for (int i = 0; i < 10; ++i) {
            assertEquals(i, bag.get(i));
        }
    }

    @Test
    void addingToIndexNotInRangeOfIndexedBagThrowsException() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        assertThrows(IndexOutOfBoundsException.class, () -> bag.add(99, 101));
    }

    @Test
    void addingToNegativeIndexOfIndexedBagPropagatesException() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        assertThrows(IndexOutOfBoundsException.class, () -> bag.add(-1, 101));
    }

    @Test
    void gettingFromAnIndexNotInRangeOfIndexedBagThrowsException() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        assertThrows(IndexOutOfBoundsException.class, () -> bag.get(99));
    }

    @Test
    void gettingFromNegativeIndexOfIndexedBagPropagatesException() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        assertThrows(IndexOutOfBoundsException.class, () -> bag.get(-1));
    }

    @Test
    void indexOfReturnsIndexOfElementInIndexedBag() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(101);
        bag.add(102);
        bag.add(103);
        bag.add(104);
        bag.add(2, 99);
        assertEquals(2, bag.indexOf(99));
    }

    @Test
    void indexOfReturnsFirstIndexOfElementWithManyCopiesInIndexedBag() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(101);
        bag.add(103);
        bag.add(102);
        bag.add(102);
        bag.add(1, 102);
        assertEquals(1, bag.indexOf(102));
    }

    @Test
    void indexOfNonExistingElementInIndexedBagThrowsException() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        assertThrows(NoSuchElementException.class, () -> bag.indexOf(99));
    }

    @Test
    void settingElementAtIndexOfIndexedBagUpdatesValue() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(99);
        bag.add(101);
        bag.add(110);
        bag.set(1, 55);
        assertEquals(55, bag.get(1));
    }

    @Test
    void settingAnIndexNotInRangeOfIndexedBagThrowsException() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        assertThrows(IndexOutOfBoundsException.class, () -> bag.set(99, 101));
    }

    @Test
    void settingANegativeIndexOfIndexedBagPropagatesException() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        assertThrows(IndexOutOfBoundsException.class, () -> bag.set(-1, 101));
    }

    @Test
    void removeByValueFromIndexedBagReturnsTrue() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(99);
        bag.add(101);
        bag.add(103);
        assertTrue(bag.remove(Integer.valueOf(101)));
    }

    @Test
    void removeByValueRemovesElementFromIndexedBag() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(99);
        bag.add(101);
        bag.add(103);
        bag.remove(Integer.valueOf(101));
        assertFalse(bag.contains(101));
    }

    @Test
    void removeByValueRemovesSingleElementFromIndexedBag() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(99);
        bag.add(99);
        bag.add(99);
        bag.remove(Integer.valueOf(99));
        assertEquals(2, bag.count(99));
    }

    @Test
    void removeByValueRemovesFirstElementWithManyCopiesFromIndexedBag() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(99);
        bag.add(101);
        bag.add(103);
        bag.add(101);
        bag.add(101);
        bag.remove(Integer.valueOf(101));
        assertNotEquals(101, bag.get(1));
    }

    @Test
    void removeByValueForIndexedBagUpdatesSize() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(99);
        bag.add(101);
        bag.add(103);
        bag.remove(Integer.valueOf(101));
        assertEquals(2, bag.size());
    }

    @Test
    void removeByValueSoleElementForIndexedBagIsEmpty() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(99);
        bag.remove(Integer.valueOf(99));
        assertTrue(bag.isEmpty());
    }

    @Test
    void removeByValueOfNonExistingElementInIndexedBagThrowsException() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(99);
        bag.add(101);
        bag.add(103);
        assertThrows(NoSuchElementException.class, () -> bag.remove(Integer.valueOf(110)));
    }

    @Test
    void removeByIndexFromIndexedBagReturnsValue() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(99);
        bag.add(101);
        bag.add(103);
        assertEquals(101, bag.remove(1));
    }

    @Test
    void removeByIndexRemovesElementFromIndexedBag() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(99);
        bag.add(101);
        bag.add(103);
        bag.remove(1);
        assertFalse(bag.contains(101));
    }

    @Test
    void removeByIndexOfIndexedBagUpdatesSize() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(99);
        bag.add(101);
        bag.add(103);
        bag.remove(1);
        assertEquals(2, bag.size());
    }

    @Test
    void removeByIndexSoleElementForIndexedBagIsEmpty() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(99);
        bag.remove(0);
        assertTrue(bag.isEmpty());
    }

    @Test
    void removeByIndexNotInRangeOfIndexedBagThrowsException() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(99);
        bag.add(101);
        bag.add(103);
        assertThrows(IndexOutOfBoundsException.class, () -> bag.remove(22));
    }

    @Test
    void removeByNegativeIndexOfIndexedBagPropagatesException() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        assertThrows(IndexOutOfBoundsException.class, () -> bag.remove(-1));
    }

    @Test
    void iteratorHasNextOnEmptyIndexedBagReturnsFalse() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        Iterator<Integer> it = bag.iterator();
        assertFalse(it.hasNext());
    }

    @Test
    void iteratorHasOneElementForIndexedBagWithOneElement() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(99);
        Iterator<Integer> it = bag.iterator();
        assertEquals(99, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void iteratorNextOnNonEmptyIndexedBagReturnsElementsInCorrectOrder() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        bag.add(99);
        bag.add(0, 101);
        bag.add(44);
        bag.add(1, 55);
        bag.add(1, 22);
        Iterator<Integer> it = bag.iterator();
        int currentIndex = 0;
        while (it.hasNext()) {
            assertEquals(it.next(), bag.get(currentIndex));
            currentIndex++;
        }
        assertThrows(NoSuchElementException.class, () -> it.next());
    }

    @Test
    void iteratorNextOnEmptyIndexedBagThrowsException() {
        IndexedBag<Integer> bag = new ArrayIndexedBag<>();
        Iterator<Integer> it = bag.iterator();
        assertThrows(NoSuchElementException.class, () -> it.next());
    }
}
