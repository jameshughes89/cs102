import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class ContactListTest {

    private static final Friend EXISTING_FRIEND = new Friend("Bob", "Smith", "bsmith@gmail.com");
    private static final Friend EXISTING_FRIEND_FIRST = new Friend("Bob", "Smith", "bsmith@gmail.com");
    private static final Friend EXISTING_FRIEND_MIDDLE = new Friend("Clarence", "Cartwrite", "treelover@hotmail.com");
    private static final Friend EXISTING_FRIEND_END = new Friend("Adam", "Fluffson", "fluffyman28@hotmail.com");
    private static final Friend NONEXISTENT_FRIEND = new Friend("Adrian", "Andrews", "aandrews@hotmail.com");

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
                assertTrue(classUnderTest.contains(EXISTING_FRIEND_FIRST));
            }

            @Test
            void contains_nonexistentFriend_returnsFalse() {
                assertFalse(classUnderTest.contains(NONEXISTENT_FRIEND));
            }

            @Test
            void indexOf_existingFriend_returnsCorrectIndex() {
                assertEquals(0, classUnderTest.indexOf(EXISTING_FRIEND_FIRST));
            }

            @Test
            void indexOf_nonexistentFriend_throwsNoSuchElementException() {
                assertThrows(NoSuchElementException.class, () -> classUnderTest.indexOf(NONEXISTENT_FRIEND));
            }

            @Test
            void get_validIndex_returnsCorrectFriend() {
                assertEquals(EXISTING_FRIEND_FIRST, classUnderTest.get(0));
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
                classUnderTest.remove(EXISTING_FRIEND_FIRST);
                assertEquals(new ContactList(), classUnderTest);
            }

            @Test
            void remove_existingFriend_returnsTrue() {
                assertTrue(classUnderTest.remove(EXISTING_FRIEND_FIRST));
            }

            @Test
            void remove_existingFriend_removesFriend() {
                classUnderTest.remove(EXISTING_FRIEND_FIRST);
                assertFalse(classUnderTest.contains(EXISTING_FRIEND_FIRST));
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
                    classUnderTest.add(new Friend("Clarence", "Cartwrite", "treelover@hotmail.com"));
                    classUnderTest.add(new Friend("Sandy", "Seaside", "boatsboatsboats@yachtclub500.com"));
                    classUnderTest.add(new Friend("Adam", "Fluffson", "fluffyman28@hotmail.com"));
                }

                @Test
                void add_successfullyAdd_returnsTrue() {
                    assertTrue(classUnderTest.add(new Friend("", "", "")));
                }

                @Test
                void contains_existingFriend_returnsTrue() {
                    assertTrue(classUnderTest.contains(EXISTING_FRIEND_MIDDLE));
                }

                @Test
                void contains_nonexistentFriend_returnsFalse() {
                    assertFalse(classUnderTest.contains(NONEXISTENT_FRIEND));
                }

                @Test
                void indexOf_existingFriend_returnsCorrectIndex() {
                    assertEquals(2, classUnderTest.indexOf(EXISTING_FRIEND_MIDDLE));
                }

                @Test
                void indexOf_nonexistentFriend_throwsNoSuchElementException() {
                    assertThrows(NoSuchElementException.class, () -> classUnderTest.indexOf(NONEXISTENT_FRIEND));
                }

                @Test
                void get_validIndex_returnsCorrectFriend() {
                    assertEquals(EXISTING_FRIEND_MIDDLE, classUnderTest.get(2));
                }

                @Test
                void get_negativeIndex_throwsIndexOutOfBoundsException() {
                    assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.get(-1));
                }

                @Test
                void get_tooLargeIndex_throwsIndexOutOfBoundsException() {
                    assertThrows(IndexOutOfBoundsException.class, () -> classUnderTest.get(5));
                }

                @Test
                void remove_existingFriend_returnsTrue() {
                    assertTrue(classUnderTest.remove(EXISTING_FRIEND_MIDDLE));
                }

                @Test
                void remove_existingFriend_removesFriend() {
                    classUnderTest.remove(EXISTING_FRIEND_MIDDLE);
                    assertFalse(classUnderTest.contains(EXISTING_FRIEND_MIDDLE));
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
                    assertEquals(5, classUnderTest.size());
                }

                @Test
                void toString_many_returnsCorrectString() {
                    String expected = "Friend(Bob, Smith, bsmith@gmail.com)\n" +
                            "Friend(Jane, Doe, jdoe@gmail.com)\n" +
                            "Friend(Clarence, Cartwrite, treelover@hotmail.com)\n" +
                            "Friend(Sandy, Seaside, boatsboatsboats@yachtclub500.com)\n" +
                            "Friend(Adam, Fluffson, fluffyman28@hotmail.com)\n";
                    ;
                    assertEquals(expected, classUnderTest.toString());
                }
            }

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class WhenDuplicate {

                @BeforeEach
                void addDuplicated() {
                    classUnderTest.add(new Friend("Clarence", "Cartwrite", "treelover@hotmail.com"));
                    classUnderTest.add(new Friend("Bob", "Smith", "bsmith@gmail.com"));
                    classUnderTest.add(new Friend("Bob", "Smith", "bsmith@gmail.com"));
                    classUnderTest.add(new Friend("Sandy", "Seaside", "boatsboatsboats@yachtclub500.com"));
                }

                @Test
                void indexOf_existingFriend_returnsIndexOfFirstOccurrence() {
                    assertEquals(0, classUnderTest.indexOf(EXISTING_FRIEND));
                }

                @Test
                void remove_allDuplicates_removesAllOccurrence() {
                    classUnderTest.remove(EXISTING_FRIEND);
                    classUnderTest.remove(EXISTING_FRIEND);
                    classUnderTest.remove(EXISTING_FRIEND);
                    assertFalse(classUnderTest.contains(EXISTING_FRIEND));
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
