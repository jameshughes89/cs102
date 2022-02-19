import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedQueueThoroughTest {

    private Queue<Integer> classUnderTest;
    private Queue<Integer> preState;

    @BeforeEach
    void newQueue() {
        classUnderTest = new LinkedQueue<>();
        preState = new LinkedQueue<>();
    }

    @Nested
    class WhenNewEmpty {

        @Test
        void isEmpty_empty_returnsTrue() {
            assertTrue(classUnderTest.isEmpty());
        }

        @Test
        void size_empty_returnsZero() {
            assertEquals(0, classUnderTest.size());
        }

        @Test
        void first_empty_throwsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.first());
        }

        @Test
        void dequeue_empty_throwsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.dequeue());
        }

        @Test
        void toString_empty_returnsStringFront() {
            String expected = "Front --> ";
            assertEquals(expected, classUnderTest.toString());
        }

        @Nested
        class WhenSingleton {

            @BeforeEach
            void addSingleInteger() {
                classUnderTest.enqueue(11);
                preState.enqueue(11);
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
            void first_singleton_returnsFront() {
                assertEquals(11, classUnderTest.first());
            }

            @Test
            void first_singleton_unchanged() {
                classUnderTest.first();
                assertEquals(preState, classUnderTest);
            }

            @Test
            void dequeue_singleton_returnsFront() {
                assertEquals(11, classUnderTest.dequeue());
            }

            @Test
            void dequeue_singleton_emptyStack() {
                classUnderTest.dequeue();
                assertEquals(new LinkedQueue<>(), classUnderTest);
            }

            @Test
            void toString_singleton_returnsCorrectString() {
                String expected = "Front --> 11, ";
                assertEquals(expected, classUnderTest.toString());
            }

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class WhenMany {

                @BeforeEach
                void addMoreIntegers() {
                    classUnderTest.enqueue(22);
                    classUnderTest.enqueue(33);
                    preState.enqueue(22);
                    preState.enqueue(33);
                }

                @Test
                void isEmpty_many_returnsFalse() {
                    assertFalse(classUnderTest.isEmpty());
                }

                @Test
                void size_many_returnsThree() {
                    assertEquals(3, classUnderTest.size());
                }

                @Test
                void enqueue_many_firstUnchanged() {
                    classUnderTest.enqueue(44);
                    assertEquals(preState.first(), classUnderTest.first());
                }

                @Test
                void first_many_returnsFront() {
                    assertEquals(11, classUnderTest.first());
                }

                @Test
                void first_many_unchanged() {
                    classUnderTest.first();
                    assertEquals(preState, classUnderTest);
                }

                @Test
                void dequeue_many_returnsFront() {
                    assertEquals(11, classUnderTest.dequeue());
                }

                @Test
                void dequeue_many_removesFront() {
                    classUnderTest.dequeue();
                    assertNotEquals(11, classUnderTest.first());
                }

                @Test
                void toString_many_returnsCorrectString() {
                    String expected = "Front --> 11, 22, 33, ";
                    assertEquals(expected, classUnderTest.toString());
                }
            }
        }
    }

    @Nested
    class WhenLarge {

        @Test
        void enqueue_large_successfullyExpandsCapacity() {
            for (int i = 0; i < 1000; i++) {
                classUnderTest.enqueue(i);
            }
            assertEquals(1000, classUnderTest.size());
        }
    }
}
