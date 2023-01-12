import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    private ArrayStack<Integer> classUnderTest;
    private ArrayStack<Integer> preState;

    @BeforeEach
    void createStack() {
        classUnderTest = new ArrayStack<>();
        preState = new ArrayStack<>();
    }

    @Nested
    class WhenNewEmpty {

        @Test
        void push_empty_returnsTrue() {
            assertTrue(classUnderTest.push(11));
        }

        @Test
        void pop_empty_throwsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.pop());
        }

        @Test
        void peek_empty_throwsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.peek());
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
            void push_singleton_returnsTrue() {
                assertTrue(classUnderTest.push(11));
            }

            @Test
            void pop_singleton_returnsTop() {
                assertEquals(10, classUnderTest.pop());
            }

            @Test
            void pop_singleton_emptyStack() {
                classUnderTest.pop();
                assertEquals(new ArrayStack<>(), classUnderTest);
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
                void push_many_returnsTrue() {
                    assertTrue(classUnderTest.push(11));
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
                void toString_many_returnsCorrectString() {
                    assertEquals("40, 30, 20, 10, ", classUnderTest.toString());
                }
            }
        }
    }

    @Nested
    class WhenLarge {

        @Test
        void push_large_successfullyExpandsCapacity() {
            for (int i = 0; i < 1000; i++) {
                classUnderTest.push(i);
            }
            assertEquals(1000, classUnderTest.size());
        }
    }
}
