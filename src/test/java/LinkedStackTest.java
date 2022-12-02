import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {


    private LinkedStack<Integer> classUnderTest;
    private LinkedStack<Integer> preState;

    @BeforeEach
    void createStack() {
        classUnderTest = new LinkedStack<>();
        preState = new LinkedStack<>();
    }

    @Nested
    class WhenNewEmpty {

        @Test
        void push_successfulAdd_returnsTrue() {
            assertTrue(classUnderTest.push(11));
        }

        @Test
        void push_empty_newTop() {
            classUnderTest.push(11);
            assertEquals(11, classUnderTest.peek());
        }

        @Test
        void pop_empty_throwsEmptyCollectionException() {
            assertThrows(EmptyCollectionException.class, () -> classUnderTest.pop());
        }

        @Test
        void peek_empty_throwsEmptyCollectionException() {
            assertThrows(EmptyCollectionException.class, () -> classUnderTest.peek());
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
                classUnderTest.push(10);
                preState.push(10);
            }

            @Test
            void push_successfullyAdds_returnsTrue() {
                assertTrue(classUnderTest.push(11));
            }

            @Test
            void push_singleton_newTop() {
                classUnderTest.push(11);
                assertEquals(11, classUnderTest.peek());
            }

            @Test
            void pop_singleton_returnsTop() {
                assertEquals(10, classUnderTest.pop());
            }

            @Test
            void pop_singleton_emptyStack() {
                classUnderTest.pop();
                assertEquals(new LinkedStack<>(), classUnderTest);
            }

            @Test
            void peek_singleton_returnsTop() {
                assertEquals(10, classUnderTest.peek());
            }

            @Test
            void peek_singleton_unchanged() {
                classUnderTest.peek();
                assertEquals(preState, classUnderTest);
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
                assertEquals("10, ", classUnderTest.toString());
            }

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class WhenMany {

                @BeforeEach
                void addMany() {
                    classUnderTest.push(20);
                    classUnderTest.push(30);
                    classUnderTest.push(40);
                    preState.push(20);
                    preState.push(30);
                    preState.push(40);
                }

                @Test
                void push_successfullyAdds_returnsTrue() {
                    assertTrue(classUnderTest.push(11));
                }

                @Test
                void push_many_newTop() {
                    classUnderTest.push(11);
                    assertEquals(11, classUnderTest.peek());
                }

                @Test
                void pop_many_returnsTop() {
                    assertEquals(40, classUnderTest.pop());
                }

                @Test
                void pop_many_newTop() {
                    classUnderTest.pop();
                    assertEquals(30, classUnderTest.peek());
                }

                @Test
                void peek_many_returnsTop() {
                    assertEquals(40, classUnderTest.peek());
                }

                @Test
                void peek_many_unchanged() {
                    classUnderTest.peek();
                    assertEquals(preState, classUnderTest);
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
                void toString_singleton_returnsCorrectString() {
                    assertEquals("40, 30, 20, 10, ", classUnderTest.toString());
                }
            }
        }
    }

    @Nested
    class WhenLarge {

        @Test
        void pop_large_lifoOrdering() {
            for (int i = 0; i < 1000; i++) {
                classUnderTest.push(i);
            }
            for (int i = 0; i < 500; i++) {
                classUnderTest.pop();
            }
            for (int i = 1000; i < 1500; i++) {
                classUnderTest.push(i);
            }
            for (int i = 1500 - 1; i >= 1000; i--) {
                assertEquals(i, classUnderTest.pop());
            }
            for (int i = 500 - 1; i >= 0; i--) {
                assertEquals(i, classUnderTest.pop());
            }
        }
    }
}
