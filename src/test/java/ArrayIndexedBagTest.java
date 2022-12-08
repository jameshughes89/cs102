import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayIndexedBagTest {


    private ArrayIndexedBag<Integer> classUnderTest;
    private ArrayIndexedBag<Integer> preState;

    @BeforeEach
    void createStack() {
        classUnderTest = new ArrayIndexedBag<>();
        preState = new ArrayIndexedBag<>();
    }

    @Nested
    class WhenNewEmpty {

        @Nested
        class WhenSingleton {

            @BeforeEach
            void addSingleton() {

            }

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class WhenMany {

                @BeforeEach
                void addMany() {

                }
            }

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class WhenDuplicate {

                @BeforeEach
                void addDuplicated() {

                }

            }
        }
    }

    @Nested
    class WhenLarge {

        @Test
        void add_large_successfullyExpandsCapacity() {
            for (int i = 0; i < 1000; i++) {
                classUnderTest.add(i);
            }
            assertEquals(1000, classUnderTest.size());
        }
    }
}
