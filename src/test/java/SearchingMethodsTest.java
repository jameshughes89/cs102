import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SearchingMethodsTest {

    private static final Integer[] UNSORTED_ARRAY = {33, 36, 35, 37, 40, 40, 49, 55, 61, 98, 18, 12, 8, 4, 0, 40, 25, 31, 62, 63, 74, 81, 89, 90};
    private static final Integer[] SORTED_ARRAY = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};

    private static final Integer NOT_WITHIN_HAYSTACK = 99;
    private static final Integer DUPLICATE_NEEDLE = 40;
    private static final int NOT_FOUND = -1;

    @Test
    void iterativeLinearSearch_nullHaystack_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> SearchingMethods.iterativeLinearSearch(99, null));
    }

    @Test
    void iterativeLinearSearch_nullNeedle_returnsSentinel() {
        assertEquals(NOT_FOUND, SearchingMethods.iterativeLinearSearch(null, UNSORTED_ARRAY));
    }

    @Test
    void iterativeLinearSearch_mismatchTypes_returnsSentinel() {
        assertEquals(NOT_FOUND, SearchingMethods.iterativeLinearSearch("99", UNSORTED_ARRAY));
    }

    @Test
    void iterativeLinearSearch_sizeZeroHaystack_returnsSentinel() {
        assertEquals(NOT_FOUND, SearchingMethods.iterativeLinearSearch(99, new Integer[0]));
    }

    @Test
    void iterativeLinearSearch_needleNotWithinHaystack_returnsSentinel() {
        assertEquals(NOT_FOUND, SearchingMethods.iterativeLinearSearch(NOT_WITHIN_HAYSTACK, UNSORTED_ARRAY));
    }

    @ParameterizedTest
    @CsvSource({"33,0", "0,14", "90,23"})
    void iterativeLinearSearch_needleAtZeroIndex_returnsCorrectIndex(Integer needle, int index) {
        assertEquals(index, SearchingMethods.iterativeLinearSearch(needle, UNSORTED_ARRAY));
    }

    @Test
    void iterativeLinearSearch_multipleEqualNeedles_returnsFirstOccurrenceIndex() {
        assertEquals(4, SearchingMethods.iterativeLinearSearch(DUPLICATE_NEEDLE, UNSORTED_ARRAY));
    }


    @Test
    void recursiveLinearSearch_nullHaystack_throwsNullPointerException() {
        Integer[] myHaystack = null;
        Integer myNeedle = 99;
        assertThrows(NullPointerException.class, () -> SearchingMethods.recursiveLinearSearch(myNeedle, myHaystack, 0));
    }

    @Test
    void recursiveLinearSearch_mismatchTypes_returnsSentinel() {
        Integer[] myHaystack = new Integer[10];
        String myNeedle = "99";
        assertEquals(-1, SearchingMethods.recursiveLinearSearch(myNeedle, myHaystack, 0));
    }

    @Test
    void recursiveLinearSearch_sizeZeroHaystack_returnsSentinel() {
        Integer[] myHaystack = new Integer[0];
        Integer myNeedle = 99;
        assertEquals(-1, SearchingMethods.recursiveLinearSearch(myNeedle, myHaystack, 0));
    }

    @Test
    void recursiveLinearSearch_needleNotWithinHaystack_returnsSentinel() {
        Integer[] myHaystack = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myNeedle = 99;
        assertEquals(-1, SearchingMethods.recursiveLinearSearch(myNeedle, myHaystack, 0));
    }

    @Test
    void recursiveLinearSearch_needleAtZeroIndex_returnsCorrectIndex() {
        Integer[] myHaystack = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myNeedle = 0;
        assertEquals(0, SearchingMethods.recursiveLinearSearch(myNeedle, myHaystack, 0));
    }

    @Test
    void recursiveLinearSearch_needleAtEndOfHaystack_returnsCorrectIndex() {
        Integer[] myHaystack = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myNeedle = 98;
        assertEquals(23, SearchingMethods.recursiveLinearSearch(myNeedle, myHaystack, 0));
    }

    @Test
    void recursiveLinearSearch_needleAtMiddleOfHaystack_returnsCorrectIndex() {
        Integer[] myHaystack = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myNeedle = 55;
        assertEquals(15, SearchingMethods.recursiveLinearSearch(myNeedle, myHaystack, 0));
    }

    @Test
    void recursiveLinearSearch_multipleEqualNeedles_returnsFirstOccurrenceIndex() {
        Integer[] myHaystack = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myNeedle = 40;
        assertEquals(11, SearchingMethods.recursiveLinearSearch(myNeedle, myHaystack, 0));
    }

    @Test
    void iterativeBinarySearch_nullHaystack_throwsNullPointerException() {
        Integer[] myHaystack = null;
        Integer myNeedle = 99;
        assertThrows(NullPointerException.class, () -> SearchingMethods.iterativeBinarySearch(myNeedle, myHaystack));
    }

    @Test
    void iterativeBinarySearch_sizeZeroHaystack_returnsSentinel() {
        Integer[] myHaystack = new Integer[0];
        Integer myNeedle = 99;
        assertEquals(-1, SearchingMethods.iterativeBinarySearch(myNeedle, myHaystack));
    }

    @Test
    void iterativeBinarySearch_needleNotWithinHaystack_returnsSentinel() {
        Integer[] myHaystack = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myNeedle = 99;
        assertEquals(-1, SearchingMethods.iterativeBinarySearch(myNeedle, myHaystack));
    }

    @Test
    void iterativeBinarySearch_needleAtZeroIndex_returnsCorrectIndex() {
        Integer[] myHaystack = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myNeedle = 0;
        assertEquals(0, SearchingMethods.iterativeBinarySearch(myNeedle, myHaystack));
    }

    @Test
    void iterativeBinarySearch_needleAtEndOfHaystack_returnsCorrectIndex() {
        Integer[] myHaystack = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myNeedle = 98;
        assertEquals(23, SearchingMethods.iterativeBinarySearch(myNeedle, myHaystack));
    }

    @Test
    void iterativeBinarySearch_needleAtMiddleOfHaystack_returnsCorrectIndex() {
        Integer[] myHaystack = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myNeedle = 55;
        assertEquals(15, SearchingMethods.iterativeBinarySearch(myNeedle, myHaystack));
    }

    @Test
    void recursiveBinarySearch_nullHaystack_throwsNullPointerException() {
        Integer[] myHaystack = null;
        Integer myNeedle = 99;
        assertThrows(NullPointerException.class,
                () -> SearchingMethods.recursiveBinarySearch(myNeedle, myHaystack, 0, myHaystack.length));
    }


    @Test
    void recursiveBinarySearch_sizeZeroHaystack_returnsSentinel() {
        Integer[] myHaystack = new Integer[0];
        Integer myNeedle = 99;
        assertEquals(-1, SearchingMethods.recursiveBinarySearch(myNeedle, myHaystack, 0, myHaystack.length));
    }

    @Test
    void recursiveBinarySearch_needleNotWithinHaystack_returnsSentinel() {
        Integer[] myHaystack = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myNeedle = 99;
        assertEquals(-1, SearchingMethods.recursiveBinarySearch(myNeedle, myHaystack, 0, myHaystack.length));
    }

    @Test
    void recursiveBinarySearch_needleAtZeroIndex_returnsCorrectIndex() {
        Integer[] myHaystack = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myNeedle = 0;
        assertEquals(0, SearchingMethods.recursiveBinarySearch(myNeedle, myHaystack, 0, myHaystack.length));
    }

    @Test
    void recursiveBinarySearch_needleAtEndOfHaystack_returnsCorrectIndex() {
        Integer[] myHaystack = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myNeedle = 98;
        assertEquals(23, SearchingMethods.recursiveBinarySearch(myNeedle, myHaystack, 0, myHaystack.length));
    }

    @Test
    void recursiveBinarySearch_needleAtMiddleOfHaystack_returnsCorrectIndex() {
        Integer[] myHaystack = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myNeedle = 55;
        assertEquals(15, SearchingMethods.recursiveBinarySearch(myNeedle, myHaystack, 0, myHaystack.length));
    }
}
