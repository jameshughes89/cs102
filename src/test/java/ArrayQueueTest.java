import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        @Nested
        class WhenSingleton {

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class WhenMany {

            }
        }

    }

    @Nested
    class WhenLarge {
        @Test
        void push_large_successfullyExpandsCapacity() {
            for (int i = 0; i < 1000; i++) {
                classUnderTest.enqueue(i);
            }
            assertEquals(1000, classUnderTest.size());
        }
    }
}
