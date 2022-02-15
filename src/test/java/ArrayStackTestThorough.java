import org.junit.jupiter.api.*;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


class ArrayStackTestThorough {

    private Stack<Integer> classUnderTest;
    private Stack<Integer> preState;

    @BeforeEach
    void newStack(){
        classUnderTest = new ArrayStack<>();
        preState = new ArrayStack<>();
    }

    @Nested
    class WhenNewEmpty{

        @Test
        @DisplayName("New or empty Stack isEmpty returns true.")
        void isEmpty_empty_returnsTrue(){
            assertTrue(classUnderTest.isEmpty());
        }

        @Test
        @DisplayName("Empty Stack size returns 0.")
        void size_empty_returnsZero(){
            assertEquals(0, classUnderTest.size());
        }

        @Test
        @DisplayName("Empty Stack peek throws NoSuchElementException.")
        void peek_empty_throwException(){
            assertThrows(NoSuchElementException.class, () -> classUnderTest.peek());
        }

        @Test
        @DisplayName("Empty Stack pop throws NoSuchElementException.")
        void pop_empty_throwException(){
            assertThrows(NoSuchElementException.class, () -> classUnderTest.pop());
        }

        @Test
        @DisplayName("Empty Stack toString returns '<-- Top'.")
        void toString_empty_stringTop(){
            assertEquals("<-- Top", classUnderTest.toString());
        }

        @Nested
        class WhenSingleton {

            @BeforeEach
            void addSingleInteger(){
                classUnderTest.push(11);
                preState.push(11);
            }

            @Test
            @DisplayName("Singleton Stack is not empty.")
            void isEmpty_singleton_returnsFalse(){
                assertFalse(classUnderTest.isEmpty());
            }

            @Test
            @DisplayName("Singleton Stack size is one.")
            void size_singleton_returnsOne(){
                assertEquals(1, classUnderTest.size());
            }

            @Test
            @DisplayName("Push on singleton Stack adds element to top.")
            void push_singleton_isTop(){
                classUnderTest.push(22);
                assertEquals(22, classUnderTest.peek());
            }

            @Test
            @DisplayName("Pop on singleton Stack returns top.")
            void pop_singleton_returnsTop(){
                assertEquals(11, classUnderTest.pop());
            }

            @Test
            @DisplayName("Pop on singleton Stack results in an empty stack.")
            void pop_singleton_emptyStack(){
                classUnderTest.pop();
                assertEquals(new ArrayStack<>(), classUnderTest);
            }

            @Test
            @DisplayName("Peek on singleton Stack returns top.")
            void peek_singleton_returnsTop(){
                assertEquals(11, classUnderTest.peek());
            }

            @Test
            @DisplayName("Peek on singleton Stack results in unchanged stack.")
            void peek_singleton_unchanged(){
                classUnderTest.peek();
                assertEquals(preState, classUnderTest);
            }

            @Test
            @DisplayName("Singleton Stack toString returns correct string.")
            void toString_singleton_correctString(){
                assertEquals("11, <-- Top", classUnderTest.toString());
            }

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class WhenMany{

                @BeforeEach
                void addMoreIntegers(){
                    classUnderTest.push(22);
                    classUnderTest.push(33);
                    classUnderTest.push(44);
                    preState.push(22);
                    preState.push(33);
                    preState.push(44);
                }

                @Test
                @DisplayName("Many Stack is not empty.")
                void isEmpty_many_returnsFalse(){
                    assertFalse(classUnderTest.isEmpty());
                }

                @Test
                @DisplayName("Many Stack size is correct size.")
                void size_many_returnsFour(){
                    assertEquals(4, classUnderTest.size());
                }

                @Test
                @DisplayName("Push on many Stack adds element to top.")
                void push_many_isTop(){
                    classUnderTest.push(55);
                    assertEquals(55, classUnderTest.peek());
                }

                @Test
                @DisplayName("Pop on many Stack returns top element.")
                void pop_many_returnsTop(){
                    assertEquals(44, classUnderTest.pop());
                }

                @Test
                @DisplayName("Pop on many Stack removes top element.")
                void pop_many_removesTop(){
                    classUnderTest.pop();
                    assertNotEquals(44, classUnderTest.peek());
                }

                @Test
                @DisplayName("Peek on many Stack returns top element.")
                void peek_many_returnsTop(){
                    assertEquals(44, classUnderTest.peek());
                }

                @Test
                @DisplayName("Peek on many Stack leaves Stack unchanged.")
                void peek_many_unchanged(){
                    classUnderTest.peek();
                    assertEquals(preState, classUnderTest);
                }

                @Test
                @DisplayName("Many Stack toString returns correct string.")
                void toString_many_correctString(){
                    assertEquals("11, 22, 33, 44, <-- Top", classUnderTest.toString());
                }
            }
        }
    }

    @Nested
    class WhenLarge{

        @Test
        @DisplayName("Pushing beyond capacity automatically calls expandCapacity.")
        void push_large_successfullyExpandsCapacity(){
            // Default capacity is 10
            for (int i = 0; i < 1000; i++) {
                classUnderTest.push(i);
            }
            assertEquals(1000, classUnderTest.size());
        }
    }
}
