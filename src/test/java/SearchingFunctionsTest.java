import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SearchingFunctionsTest {

    private static final Integer[] UNSORTED_ARRAY = {33, 36, 35, 37, 40, 40, 49, 55, 61, 98, 18, 12, 8, 4, 0, 40, 25, 31, 62, 63, 74, 81, 89, 90};
    private static final Integer[] SORTED_ARRAY = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};

    private static final Integer NOT_WITHIN_HAYSTACK = 99;
    private static final Integer DUPLICATE_NEEDLE = 40;
    private static final int NOT_FOUND = -1;

    @Test
    void iterativeLinearSearch_nullHaystack_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> SearchingFunctions.iterativeLinearSearch(99, null));
    }

    @Test
    void iterativeLinearSearch_nullNeedle_returnsSentinel() {
        assertEquals(NOT_FOUND, SearchingFunctions.iterativeLinearSearch(null, UNSORTED_ARRAY));
    }

    @Test
    void iterativeLinearSearch_mismatchTypes_returnsSentinel() {
        assertEquals(NOT_FOUND, SearchingFunctions.iterativeLinearSearch("99", UNSORTED_ARRAY));
    }

    @Test
    void iterativeLinearSearch_sizeZeroHaystack_returnsSentinel() {
        assertEquals(NOT_FOUND, SearchingFunctions.iterativeLinearSearch(99, new Integer[0]));
    }

    @Test
    void iterativeLinearSearch_needleNotWithinHaystack_returnsSentinel() {
        assertEquals(NOT_FOUND, SearchingFunctions.iterativeLinearSearch(NOT_WITHIN_HAYSTACK, UNSORTED_ARRAY));
    }

    @ParameterizedTest
    @CsvSource({"33,0", "0,14", "90,23"})
    void iterativeLinearSearch_needleAtZeroIndex_returnsCorrectIndex(Integer needle, int index) {
        assertEquals(index, SearchingFunctions.iterativeLinearSearch(needle, UNSORTED_ARRAY));
    }

    @Test
    void iterativeLinearSearch_multipleEqualNeedles_returnsFirstOccurrenceIndex() {
        assertEquals(4, SearchingFunctions.iterativeLinearSearch(DUPLICATE_NEEDLE, UNSORTED_ARRAY));
    }

    @Test
    void recursiveLinearSearch_nullHaystack_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> SearchingFunctions.recursiveLinearSearch(99, null, 0));
    }

    @Test
    void recursiveLinearSearch_nullNeedle_returnsSentinel() {
        assertEquals(NOT_FOUND, SearchingFunctions.recursiveLinearSearch(null, UNSORTED_ARRAY, 0));
    }

    @Test
    void recursiveLinearSearch_mismatchTypes_returnsSentinel() {
        assertEquals(NOT_FOUND, SearchingFunctions.recursiveLinearSearch("99", UNSORTED_ARRAY, 0));
    }

    @Test
    void recursiveLinearSearch_sizeZeroHaystack_returnsSentinel() {
        assertEquals(NOT_FOUND, SearchingFunctions.recursiveLinearSearch(99, new Integer[0], 0));
    }

    @Test
    void recursiveLinearSearch_needleNotWithinHaystack_returnsSentinel() {
        assertEquals(NOT_FOUND, SearchingFunctions.recursiveLinearSearch(NOT_WITHIN_HAYSTACK, UNSORTED_ARRAY, 0));
    }

    @ParameterizedTest
    @CsvSource({"33,0", "0,14", "90,23"})
    void recursiveLinearSearch_needleAtZeroIndex_returnsCorrectIndex(Integer needle, int index) {
        assertEquals(index, SearchingFunctions.recursiveLinearSearch(needle, UNSORTED_ARRAY, 0));
    }

    @Test
    void recursiveLinearSearch_multipleEqualNeedles_returnsFirstOccurrenceIndex() {
        assertEquals(4, SearchingFunctions.recursiveLinearSearch(DUPLICATE_NEEDLE, UNSORTED_ARRAY, 0));
    }

    @Test
    void iterativeBinarySearch_nullHaystack_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> SearchingFunctions.iterativeBinarySearch(99, null));
    }

    @Test
    void iterativeBinarySearch_nullNeedle_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> SearchingFunctions.iterativeBinarySearch(null, SORTED_ARRAY));
    }

    @Test
    void iterativeBinarySearch_sizeZeroHaystack_returnsSentinel() {
        assertEquals(NOT_FOUND, SearchingFunctions.iterativeBinarySearch(99, new Integer[0]));
    }

    @Test
    void iterativeBinarySearch_needleNotWithinHaystack_returnsSentinel() {
        assertEquals(NOT_FOUND, SearchingFunctions.iterativeBinarySearch(NOT_WITHIN_HAYSTACK, SORTED_ARRAY));
    }

    @ParameterizedTest
    @CsvSource({"0,0", "37,10", "98,23"})
    void iterativeBinarySearch_needleAtZeroIndex_returnsCorrectIndex(Integer needle, int index) {
        assertEquals(index, SearchingFunctions.iterativeBinarySearch(needle, SORTED_ARRAY));
    }

    @Test
    void iterativeBinarySearch_multipleEqualNeedles_returnsFirstOccurrenceIndex() {
        assertEquals(12, SearchingFunctions.iterativeBinarySearch(DUPLICATE_NEEDLE, SORTED_ARRAY));
    }


    @Test
    void recursiveBinarySearch_nullHaystack_throwsNullPointerException() {
        SearchingFunctions.recursiveBinarySearch(99, null, 0, 0);
        assertThrows(NullPointerException.class, () -> SearchingFunctions.recursiveBinarySearch(99, null, 0, 1));
    }

    @Test
    void recursiveBinarySearch_nullNeedle_throwsNullPointerException() {
        assertThrows(NullPointerException.class,
                () -> SearchingFunctions.recursiveBinarySearch(null, SORTED_ARRAY, 0, 1));
    }

    @Test
    void recursiveBinarySearch_sizeZeroHaystack_returnsSentinel() {
        assertEquals(NOT_FOUND, SearchingFunctions.recursiveBinarySearch(99, new Integer[0], 0, 0));
    }

    @Test
    void recursiveBinarySearch_needleNotWithinHaystack_returnsSentinel() {
        assertEquals(NOT_FOUND,
                SearchingFunctions.recursiveBinarySearch(NOT_WITHIN_HAYSTACK, SORTED_ARRAY, 0, SORTED_ARRAY.length));
    }

    @ParameterizedTest
    @CsvSource({"0,0", "37,10", "98,23"})
    void recursiveBinarySearch_needleAtZeroIndex_returnsCorrectIndex(Integer needle, int index) {
        assertEquals(index, SearchingFunctions.recursiveBinarySearch(needle, SORTED_ARRAY, 0, SORTED_ARRAY.length));
    }

    @Test
    void recursiveBinarySearch_multipleEqualNeedles_returnsFirstOccurrenceIndex() {
        assertEquals(12,
                SearchingFunctions.recursiveBinarySearch(DUPLICATE_NEEDLE, SORTED_ARRAY, 0, SORTED_ARRAY.length));
    }
}
