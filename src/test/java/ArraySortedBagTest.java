import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ArraySortedBagTest {
    private ArraySortedBag<Integer> classUnderTest;

    @BeforeEach
    void createStack() {
        classUnderTest = new ArraySortedBag<>();
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
        void add_large_successfullyExpandsCapacity() {
            for (int i = 0; i < 1000; i++) {
                classUnderTest.add(i);
            }
            assertEquals(1000, classUnderTest.size());
        }
    }
}
