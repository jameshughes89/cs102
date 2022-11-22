import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SearchingMethodsTest {

    @Test
    void iterativeLinearSearch_nullHaystack_throwsException() {
        Integer[] myHaystack = null;
        Integer myNeedle = 99;
        assertThrows(NullPointerException.class, () -> SearchingMethods.iterativeLinearSearch(myNeedle, myHaystack));
    }

    @Test
    void iterativeLinearSearch_nullNeedle_throwsException() {
        Integer[] myHaystack = new Integer[99];
        Integer myNeedle = null;
        assertThrows(NullPointerException.class, () -> SearchingMethods.iterativeLinearSearch(myNeedle, myHaystack));
    }

    @Test
    void iterativeLinearSearch_mismatchTypes_returnsSentinel() {
        Integer[] myHaystack = new Integer[0];
        String myNeedle = "99";
        assertEquals(-1, SearchingMethods.iterativeLinearSearch(myNeedle, myHaystack));
    }

    @Test
    void iterativeLinearSearch_sizeZeroHaystack_returnsSentinel() {
        Integer[] myHaystack = new Integer[0];
        Integer myNeedle = 99;
        assertEquals(-1, SearchingMethods.iterativeLinearSearch(myNeedle, myHaystack));
    }

    @Test
    void iterativeLinearSearch_needleNotWithinHaystack_returnsSentinel() {
        Integer[] myHaystack = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myNeedle = 99;
        assertEquals(-1, SearchingMethods.iterativeLinearSearch(myNeedle, myHaystack));
    }

    @Test
    void iterativeLinearSearch_needleAtZeroIndex_returnsCorrectIndex() {
        Integer[] myHaystack = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myNeedle = 0;
        assertEquals(0, SearchingMethods.iterativeLinearSearch(myNeedle, myHaystack));
    }

    @Test
    void iterativeLinearSearch_needleAtEndOfHaystack_returnsCorrectIndex() {
        Integer[] myHaystack = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myNeedle = 98;
        assertEquals(23, SearchingMethods.iterativeLinearSearch(myNeedle, myHaystack));
    }

    @Test
    void iterativeLinearSearch_needleAtMiddleOfHaystack_returnsCorrectIndex() {
        Integer[] myHaystack = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myNeedle = 55;
        assertEquals(15, SearchingMethods.iterativeLinearSearch(myNeedle, myHaystack));
    }

    @Test
    void iterativeLinearSearch_multipleEqualNeedles_returnsFirstOccurrenceIndex() {
        Integer[] myHaystack = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myNeedle = 40;
        assertEquals(11, SearchingMethods.iterativeLinearSearch(myNeedle, myHaystack));
    }

    @Test
    void recursiveLinearSearch_nullHaystack_throwsException() {
        Integer[] myHaystack = null;
        Integer myNeedle = 99;
        assertThrows(NullPointerException.class, () -> SearchingMethods.recursiveLinearSearch(myNeedle, myHaystack, 0));
    }

    @Test
    void recursiveLinearSearch_nullNeedle_throwsException() {
        Integer[] myHaystack = new Integer[99];
        Integer myNeedle = null;
        assertThrows(NullPointerException.class, () -> SearchingMethods.recursiveLinearSearch(myNeedle, myHaystack, 0));
    }

    @Test
    void recursiveLinearSearch_mismatchTypes_returnsSentinel() {
        Integer[] myHaystack = new Integer[0];
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
    void iterativeBinarySearch_nullHaystack_throwsException() {
        Integer[] myHaystack = null;
        Integer myNeedle = 99;
        assertThrows(NullPointerException.class, () -> SearchingMethods.iterativeBinarySearch(myNeedle, myHaystack));
    }

    @Test
    void iterativeBinarySearch_nullNeedle_throwsException() {
        Integer[] myHaystack = new Integer[99];
        Integer myNeedle = null;
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
    void recursiveBinarySearch_nullHaystack_throwsException() {
        Integer[] myHaystack = null;
        Integer myNeedle = 99;
        assertThrows(NullPointerException.class,
                () -> SearchingMethods.recursiveBinarySearch(myNeedle, myHaystack, 0, myHaystack.length));
    }

    @Test
    void recursiveBinarySearch_nullNeedle_throwsException() {
        Integer[] myHaystack = new Integer[99];
        Integer myNeedle = null;
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
