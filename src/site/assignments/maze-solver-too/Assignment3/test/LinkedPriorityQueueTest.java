import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.NoSuchElementException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedPriorityQueueTest {

    private PriorityQueue<String> classUnderTest;
    private PriorityQueue<String> preState;

    @BeforeEach
    void newPriorityQueue() {
        classUnderTest = new LinkedPriorityQueue<>();
        preState = new LinkedPriorityQueue<>();
    }

    @Nested
    class WhenNewEmpty {

        @Test
        void enqueue_noPriority_returnsTrue() {

        }

        @Test
        void enqueue_priority_returnsTrue() {

        }

        @Test
        void enqueue_noPriority_updatesFront() {

        }

        @Test
        void dequeue_empty_throwException() {

        }

        @Test
        void first_empty_throwException() {

        }

        @Test
        void isEmpty_empty_returnsTrue() {

        }

        @Test
        void size_empty_returnsZero() {

        }

        @Test
        void toString_empty_stringFront() {

        }

        @Nested
        class WhenSingleton {

            @BeforeEach
            void enqueueSingleElement() {
                classUnderTest.enqueue("C", 10);
                preState.enqueue("C", 10);
            }

            @Test
            void enqueue_noPriority_returnsTrue() {

            }

            @Test
            void enqueue_priority_returnsTrue() {

            }

            @Test
            void enqueue_noPriority_unchangedFront() {

            }

            @Test
            void enqueue_lowerPriority_updatesFront() {

            }

            @Test
            void enqueue_higherPriority_unchangedFront() {

            }

            @Test
            void dequeue_singleton_returnsFront() {

            }

            @Test
            void dequeue_singleton_emptyPriorityQueue() {

            }

            @Test
            void first_singleton_returnsFront() {

            }

            @Test
            void first_singleton_unchanged() {

            }

            @Test
            void isEmpty_singleton_returnsFalse() {

            }

            @Test
            void size_singleton_returnsOne() {

            }

            @Test
            void toString_singleton_correctString() {

            }

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class WhenMany {

                @BeforeEach
                void enqueueMoreElements() {
                    // Order should be A, B, C, D, E
                    classUnderTest.enqueue("A", 0);
                    classUnderTest.enqueue("E", 20);
                    classUnderTest.enqueue("B", 5);
                    classUnderTest.enqueue("D", 15);
                    preState.enqueue("A", 0);
                    preState.enqueue("E", 20);
                    preState.enqueue("B", 5);
                    preState.enqueue("D", 15);
                }

                @Test
                void enqueue_noPriority_returnsTrue() {

                }

                @Test
                void enqueue_priority_returnsTrue() {

                }

                @Test
                void enqueue_noPriority_unchangedFront() {

                }

                @Test
                void enqueue_lowerPriority_updatesFront() {

                }

                @Test
                void enqueue_higherPriority_unchangedFront() {

                }

                @Test
                void dequeue_many_returnsElementsInCorrectSequence() {

                }

                @Test
                void dequeue_many_changedPriorityQueue() {

                }


                @Test
                void first_many_returnsLowestPriorityData() {

                }

                @Test
                void first_many_unchanged() {

                }

                @Test
                void isEmpty_many_returnsFalse() {

                }

                @Test
                void size_many_returnsFive() {

                }


                @Test
                void toString_many_correctString() {

                }
            }

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class WhenDuplicatePriorities {

                @BeforeEach
                void enqueueMoreElements() {
                    // Order should be one of:
                    //      A, B, C, D, E, F
                    //      A, B, C, E, D, F
                    //      A, B, D, C, E, F
                    //      A, B, D, E, C, F
                    //      A, B, E, C, D, F
                    //      A, B, E, D, C, F
                    classUnderTest.enqueue("A", 0);
                    classUnderTest.enqueue("D", 10);
                    classUnderTest.enqueue("B", 5);
                    classUnderTest.enqueue("E", 10);
                    classUnderTest.enqueue("F", 15);
                    preState.enqueue("A", 0);
                    preState.enqueue("D", 10);
                    preState.enqueue("B", 5);
                    preState.enqueue("E", 10);
                    preState.enqueue("F", 15);
                }

                @Test
                void dequeue_duplicates_returnsElementsInCorrectSequence() {

                }
            }
        }
    }
}

