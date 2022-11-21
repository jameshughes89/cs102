import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

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
        void add_successfullyAdd_returnsTrue() {
            assertTrue(classUnderTest.add(new Friend("", "", "")));
        }

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

        @Nested
        class WhenSingleton {

            @BeforeEach
            void addSingleton() {
                classUnderTest.add(new Friend("Bob", "Smith", "bsmith@gmail.com"));
                preState.add(new Friend("Bob", "Smith", "bsmith@gmail.com"));
            }

            @Test
            void add_successfullyAdd_returnsTrue() {
                assertTrue(classUnderTest.add(new Friend("", "", "")));
            }

            @Test
            void contains_existingFriend_returnsTrue() {
                assertTrue(classUnderTest.contains(EXISTING_FRIEND));
            }

            @Test
            void contains_nonexistentFriend_returnsFalse() {
                assertFalse(classUnderTest.contains(NONEXISTENT_FRIEND));
            }

            @Test
            void indexOf_existingFriend_returnsCorrectIndex() {
                assertEquals(0, classUnderTest.indexOf(EXISTING_FRIEND));
            }

            @Test
            void indexOf_nonexistentFriend_throwsNoSuchElementException() {
                assertThrows(NoSuchElementException.class, () -> classUnderTest.indexOf(NONEXISTENT_FRIEND));
            }

            @Test
            void get_validIndex_returnsCorrectFriend() {
                assertEquals(EXISTING_FRIEND, classUnderTest.get(0));
            }

            @Test
            void get_negativeIndex_throwsIndexOutOfBoundsException() {
                assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.get(-1));
            }

            @Test
            void get_tooLargeIndex_throwsIndexOutOfBoundsException() {
                assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.get(1));
            }

            @Test
            void remove_existingFriend_returnsTrue() {
                assertTrue(classUnderTest.remove(EXISTING_FRIEND));
            }

            @Test
            void remove_existingFriend_removesFriend() {
                classUnderTest.remove(EXISTING_FRIEND);
                assertFalse(classUnderTest.contains(EXISTING_FRIEND));
            }

            @Test
            void remove_nonexistentFriend_throwsNoSuchElementException() {
                assertThrows(NoSuchElementException.class, () -> classUnderTest.remove(NONEXISTENT_FRIEND));
            }

            @Test
            void clear_singleton_emptyCollection() {
                classUnderTest.clear();
                assertEquals(new ContactList(), classUnderTest);
            }

            @Test
            void isEmpty_singleton_returnsFalse() {
                assertFalse(classUnderTest.isEmpty());
            }

            @Test
            void size_singleton_returnsOne() {
                assertEquals(1, classUnderTest.size());
            }

            @Test
            void toString_singleton_returnsCorrectString() {
                String expected = "Friend(Bob, Smith, bsmith@gmail.com)\n";
                assertEquals(expected, classUnderTest.toString());
            }

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class WhenMany {

                @Test
                void add_successfullyAdd_returnsTrue() {
                    assertTrue(classUnderTest.add(new Friend("", "", "")));
                }

                @Test
                void contains_existingFriend_returnsTrue() {

                }

                @Test
                void contains_nonexistentFriend_returnsFalse() {

                }

                @Test
                void indexOf_existingFriend_returnsCorrectIndex() {

                }

                @Test
                void indexOf_nonexistentFriend_throwsNoSuchElementException() {

                }

                @Test
                void get_validIndex_returnsCorrectFriend() {

                }

                @Test
                void get_negativeIndex_throwsIndexOutOfBoundsException() {

                }

                @Test
                void get_tooLargeIndex_throwsIndexOutOfBoundsException() {

                }

                @Test
                void remove_existingFriend_returnsTrue() {

                }

                @Test
                void remove_existingFriend_removesFriend() {

                }

                @Test
                void remove_nonexistentFriend_throwsNoSuchElementException() {

                }

                @Test
                void clear_singleton_emptyCollection() {

                }

                @Test
                void isEmpty_singleton_returnsFalse() {

                }

                @Test
                void size_singleton_returnsOne() {

                }

                @Test
                void toString_singleton_returnsCorrectString() {

                }
            }

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class WhenDuplicate {

                @Test
                void add_successfullyAdd_returnsTrue() {
                    assertTrue(classUnderTest.add(new Friend("Bob", "Smith", "bsmith@gmail.com")));
                }

                @Test
                void contains_existingFriend_returnsTrue() {

                }

                @Test
                void contains_nonexistentFriend_returnsFalse() {

                }

                @Test
                void indexOf_existingFriend_returnsCorrectIndex() {

                }

                @Test
                void indexOf_nonexistentFriend_throwsNoSuchElementException() {

                }

                @Test
                void get_validIndex_returnsCorrectFriend() {

                }

                @Test
                void get_negativeIndex_throwsIndexOutOfBoundsException() {

                }

                @Test
                void get_tooLargeIndex_throwsIndexOutOfBoundsException() {

                }

                @Test
                void remove_existingFriend_returnsTrue() {

                }

                @Test
                void remove_existingFriend_removesFriend() {

                }

                @Test
                void remove_nonexistentFriend_throwsNoSuchElementException() {

                }

                @Test
                void clear_singleton_emptyCollection() {

                }

                @Test
                void isEmpty_singleton_returnsFalse() {

                }

                @Test
                void size_singleton_returnsOne() {

                }

                @Test
                void toString_singleton_returnsCorrectString() {

                }
            }

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
