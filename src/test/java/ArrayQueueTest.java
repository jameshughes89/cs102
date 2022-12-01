import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest {

    private ArrayQueue<Integer> classUnderTest;
    private ArrayQueue<Integer> preState;

    @BeforeEach
    void createStack() {
        classUnderTest = new ArrayQueue<>();
        preState = new ArrayQueue<>();
    }

    @Nested
    class WhenNewEmpty {

        @Test
        void enqueue_successfullyAdds_returnsTrue() {
            assertTrue(classUnderTest.enqueue(11));
        }

        @Test
        void enqueue_empty_newTop() {
            classUnderTest.enqueue(11);
            assertEquals(11, classUnderTest.first());
        }

        @Test
        void dequeue_empty_throwsEmptyCollectionException() {
            assertThrows(EmptyCollectionException.class, () -> classUnderTest.dequeue());
        }

        @Test
        void first_empty_throwsEmptyCollectionException() {
            assertThrows(EmptyCollectionException.class, () -> classUnderTest.first());
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
                classUnderTest.enqueue(10);
                preState.enqueue(10);
            }

            @Test
            void enqueue_successfullyAdds_returnsTrue() {
                assertTrue(classUnderTest.enqueue(11));
            }

            @Test
            void enqueue_singleton_unchangedFirst() {
                classUnderTest.enqueue(11);
                assertEquals(10, classUnderTest.first());
            }

            @Test
            void dequeue_singleton_returnsFirst() {
                assertEquals(10, classUnderTest.dequeue());
            }

            @Test
            void dequeue_singleton_emptyQueue() {
                classUnderTest.dequeue();
                assertEquals(new ArrayQueue<>(), classUnderTest);
            }

            @Test
            void first_singleton_returnsFirst() {
                assertEquals(10, classUnderTest.first());
            }

            @Test
            void first_singleton_unchanged() {
                classUnderTest.first();
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
                    classUnderTest.enqueue(20);
                    classUnderTest.enqueue(30);
                    classUnderTest.enqueue(40);
                    preState.enqueue(20);
                    preState.enqueue(30);
                    preState.enqueue(40);
                }


                @Test
                void enqueue_successfullyAdds_returnsTrue() {
                    assertTrue(classUnderTest.enqueue(11));
                }

                @Test
                void enqueue_many_unchangedFirst() {
                    classUnderTest.enqueue(11);
                    assertEquals(10, classUnderTest.first());
                }

                @Test
                void dequeue_many_returnsFirst() {
                    assertEquals(10, classUnderTest.dequeue());
                }

                @Test
                void dequeue_many_newFirst() {
                    classUnderTest.dequeue();
                    assertEquals(20, classUnderTest.first());
                }

                @Test
                void first_many_returnsFirst() {
                    assertEquals(10, classUnderTest.first());
                }

                @Test
                void first_many_unchanged() {
                    classUnderTest.first();
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
                    assertEquals("10, 20, 30, 40, ", classUnderTest.toString());
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

        @Test
        void dequeue_large_fifoOrdering() {
            for (int i = 0; i < 1000; i++) {
                classUnderTest.enqueue(i);
            }
            for (int i = 0; i < 500; i++) {
                classUnderTest.dequeue();
            }
            for (int i = 1000; i < 1500; i++) {
                classUnderTest.enqueue(i);
            }
            for (int i = 500; i < 1500; i++) {
                assertEquals(i, classUnderTest.dequeue());
            }
        }
    }
}
