import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class ContactListTest {

    private static final Friend EXISTING_FRIEND = new Friend("Bob", "Smith", "bsmith@gmail.com");
    private static final Friend NONEXISTENT_FRIEND = new Friend("Adam", "Fluffson", "fluffyman28@hotmail.com");

    private ContactList classUnderTest;
    private ContactList preState;

    @BeforeEach
    void createContactLists() {
        classUnderTest = new ContactList();
        preState = new ContactList();
    }

    @Nested
    class WhenNewEmpty {

        @Test
        void contains_empty_returnsFalse() {
            assertFalse(classUnderTest.contains(NONEXISTENT_FRIEND));
        }

        @Test
        void indexOf_empty_throwsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.indexOf(NONEXISTENT_FRIEND));
        }

        @Test
        void indexOf_negativeIndex_throwsIndexOutOfBoundsException() {
            assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.get(-1));
        }

        @Test
        void indexOf_tooLargeIndex_throwsIndexOutOfBoundsException() {
            assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.get(0));
        }

        @Test
        void remove_empty_throwsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.remove(NONEXISTENT_FRIEND));
        }

        @Test
        void clear_empty_emptyCollection() {
            classUnderTest.clear();
            assertEquals(new ContactList(), classUnderTest);
        }

        @Test
        void isEmpty_empty_returnsTrue() {
            assertTrue(classUnderTest.isEmpty());
        }

        @Test
        void size_empty_returnsZero() {
            assertEquals(0, classUnderTest.size());
        }

        @Test
        void toString_empty_returnsEmptyString() {
            assertEquals("", classUnderTest.toString());
        }

    }

    @Nested
    class WhenLarge {

        @Test
        void add_large_successfullyExpandsCapacity() {
            for (int i = 0; i < 1000; i++) {
                classUnderTest.add(new Friend("", "", ""));
            }
            assertEquals(1000, classUnderTest.size());
        }
    }

}
