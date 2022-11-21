import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class ContactListTest {

    private static final Friend EXISTING_FRIEND = new Friend("Bob", "Smith", "bsmith@gmail.com");
    private static final Friend ANOTHER_EXISTING_FRIEND = new Friend("Clarence",
            "Cartwrite",
            "treelover1523@hotmail.com");
    private static final Friend NONEXISTENT_FRIEND = new Friend("Adam", "Fluffson", "fluffyman28@hotmail.com");

    private ContactList classUnderTest;

    @BeforeEach
    void createContactLists() {
        classUnderTest = new ContactList();
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
        void get_negativeIndex_throwsIndexOutOfBoundsException() {
            assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.get(-1));
        }

        @Test
        void get_tooLargeIndex_throwsIndexOutOfBoundsException() {
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
            void remove_singleton_emptyCollection() {
                classUnderTest.remove(EXISTING_FRIEND);
                assertEquals(new ContactList(), classUnderTest);
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

                @BeforeEach
                void addManyFriends() {
                    classUnderTest.add(new Friend("Jane", "Doe", "jdoe@gmail.com"));
                    classUnderTest.add(new Friend("Clarence", "Cartwrite", "treelover1523@hotmail.com"));
                    classUnderTest.add(new Friend("Sandy", "Seaside", "boatsboatsboats@yachtclub500.com"));
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
                    assertEquals(2, classUnderTest.indexOf(ANOTHER_EXISTING_FRIEND));
                }

                @Test
                void indexOf_nonexistentFriend_throwsNoSuchElementException() {
                    assertThrows(NoSuchElementException.class, () -> classUnderTest.indexOf(NONEXISTENT_FRIEND));
                }

                @Test
                void get_validIndex_returnsCorrectFriend() {
                    assertEquals(ANOTHER_EXISTING_FRIEND, classUnderTest.get(2));
                }

                @Test
                void get_negativeIndex_throwsIndexOutOfBoundsException() {
                    assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.get(-1));
                }

                @Test
                void get_tooLargeIndex_throwsIndexOutOfBoundsException() {
                    assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.get(4));
                }

                @Test
                void remove_existingFriend_correctOrder() {
                    ContactList expectAfterRemove = new ContactList();
                    expectAfterRemove.add(new Friend("Sandy", "Seaside", "boatsboatsboats@yachtclub500.com"));
                    expectAfterRemove.add(new Friend("Jane", "Doe", "jdoe@gmail.com"));
                    expectAfterRemove.add(new Friend("Clarence", "Cartwrite", "treelover1523@hotmail.com"));
                    classUnderTest.remove(EXISTING_FRIEND);
                    assertEquals(expectAfterRemove, classUnderTest);
                }

                @Test
                void remove_existingFriend_returnsTrue() {
                    assertTrue(classUnderTest.remove(ANOTHER_EXISTING_FRIEND));
                }

                @Test
                void remove_existingFriend_removesFriend() {
                    classUnderTest.remove(ANOTHER_EXISTING_FRIEND);
                    assertFalse(classUnderTest.contains(ANOTHER_EXISTING_FRIEND));
                }

                @Test
                void remove_nonexistentFriend_throwsNoSuchElementException() {
                    assertThrows(NoSuchElementException.class, () -> classUnderTest.remove(NONEXISTENT_FRIEND));
                }

                @Test
                void clear_many_emptyCollection() {
                    classUnderTest.clear();
                    assertEquals(new ContactList(), classUnderTest);
                }

                @Test
                void isEmpty_many_returnsFalse() {
                    assertFalse(classUnderTest.isEmpty());
                }

                @Test
                void size_many_returnsCorrectSize() {
                    assertEquals(4, classUnderTest.size());
                }

                @Test
                void toString_many_returnsCorrectString() {
                    String expected = "Friend(Bob, Smith, bsmith@gmail.com)\n" +
                            "Friend(Jane, Doe, jdoe@gmail.com)\n" +
                            "Friend(Clarence, Cartwrite, treelover1523@hotmail.com)\n" +
                            "Friend(Sandy, Seaside, boatsboatsboats@yachtclub500.com)\n";
                    assertEquals(expected, classUnderTest.toString());
                }
            }

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class WhenDuplicate {

                @BeforeEach
                void addDuplicated() {
                    classUnderTest.add(new Friend("Clarence", "Cartwrite", "treelover1523@hotmail.com"));
                    classUnderTest.add(new Friend("Bob", "Smith", "bsmith@gmail.com"));
                    classUnderTest.add(new Friend("Bob", "Smith", "bsmith@gmail.com"));
                    classUnderTest.add(new Friend("Sandy", "Seaside", "boatsboatsboats@yachtclub500.com"));
                }

                @Test
                void indexOf_existingFriend_returnsIndexOfFirstOccurrence() {
                    assertEquals(0, classUnderTest.indexOf(EXISTING_FRIEND));
                }

                @Test
                void remove_existingFriend_removesFirstOccurrence() {
                    ContactList expectAfterRemove = new ContactList();
                    expectAfterRemove.add(new Friend("Sandy", "Seaside", "boatsboatsboats@yachtclub500.com"));
                    expectAfterRemove.add(new Friend("Clarence", "Cartwrite", "treelover1523@hotmail.com"));
                    expectAfterRemove.add(new Friend("Bob", "Smith", "bsmith@gmail.com"));
                    expectAfterRemove.add(new Friend("Bob", "Smith", "bsmith@gmail.com"));
                    classUnderTest.remove(EXISTING_FRIEND);
                    assertEquals(expectAfterRemove, classUnderTest);
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
