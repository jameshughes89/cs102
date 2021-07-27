import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SearchingMethodsTest {

    @Test
    void iterativeLinearSearch_nullArray_throwsException() {
        Integer[] myArray = null;
        Integer myTarget = 99;
        assertThrows(NullPointerException.class, () -> SearchingMethods.iterativeLinearSearch(myTarget, myArray));
    }

    @Test
    void iterativeLinearSearch_nullTarget_throwsException() {
        Integer[] myArray = new Integer[99];
        Integer myTarget = null;
        assertThrows(NullPointerException.class, () -> SearchingMethods.iterativeLinearSearch(myTarget, myArray));
    }

    @Test
    void iterativeLinearSearch_mismatchTypes_returnsSentinel() {
        Integer[] myArray = new Integer[0];
        String myTarget = "99";
        assertEquals(-1, SearchingMethods.iterativeLinearSearch(myTarget, myArray));
    }

    @Test
    void iterativeLinearSearch_sizeZeroArray_returnsSentinel() {
        Integer[] myArray = new Integer[0];
        Integer myTarget = 99;
        assertEquals(-1, SearchingMethods.iterativeLinearSearch(myTarget, myArray));
    }

    @Test
    void iterativeLinearSearch_targetNotWithinArray_returnsSentinel() {
        Integer[] myArray = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myTarget = 99;
        assertEquals(-1, SearchingMethods.iterativeLinearSearch(myTarget, myArray));
    }

    @Test
    void iterativeLinearSearch_targetAtZeroIndex_returnsCorrectIndex() {
        Integer[] myArray = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myTarget = 0;
        assertEquals(0, SearchingMethods.iterativeLinearSearch(myTarget, myArray));
    }

    @Test
    void iterativeLinearSearch_targetAtNthIndex_returnsCorrectIndex() {
        Integer[] myArray = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myTarget = 98;
        assertEquals(23, SearchingMethods.iterativeLinearSearch(myTarget, myArray));
    }

    @Test
    void iterativeLinearSearch_targetAtArbitraryIndex_returnsCorrectIndex() {
        Integer[] myArray = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myTarget = 55;
        assertEquals(15, SearchingMethods.iterativeLinearSearch(myTarget, myArray));
    }

    @Test
    void iterativeLinearSearch_multipleEqualTargets_returnsFirstOccurrenceIndex() {
        Integer[] myArray = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myTarget = 40;
        assertEquals(11, SearchingMethods.iterativeLinearSearch(myTarget, myArray));
    }

    @Test
    void recursiveLinearSearch_nullArray_throwsException() {
        Integer[] myArray = null;
        Integer myTarget = 99;
        assertThrows(NullPointerException.class, () -> SearchingMethods.recursiveLinearSearch(myTarget, myArray, 0));
    }

    @Test
    void recursiveLinearSearch_nullTarget_throwsException() {
        Integer[] myArray = new Integer[99];
        Integer myTarget = null;
        assertThrows(NullPointerException.class, () -> SearchingMethods.recursiveLinearSearch(myTarget, myArray, 0));
    }

    @Test
    void recursiveLinearSearch_mismatchTypes_returnsSentinel() {
        Integer[] myArray = new Integer[0];
        String myTarget = "99";
        assertEquals(-1, SearchingMethods.recursiveLinearSearch(myTarget, myArray, 0));
    }

    @Test
    void recursiveLinearSearch_sizeZeroArray_returnsSentinel() {
        Integer[] myArray = new Integer[0];
        Integer myTarget = 99;
        assertEquals(-1, SearchingMethods.recursiveLinearSearch(myTarget, myArray, 0));
    }

    @Test
    void recursiveLinearSearch_targetNotWithinArray_returnsSentinel() {
        Integer[] myArray = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myTarget = 99;
        assertEquals(-1, SearchingMethods.recursiveLinearSearch(myTarget, myArray, 0));
    }

    @Test
    void recursiveLinearSearch_targetAtZeroIndex_returnsCorrectIndex() {
        Integer[] myArray = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myTarget = 0;
        assertEquals(0, SearchingMethods.recursiveLinearSearch(myTarget, myArray, 0));
    }

    @Test
    void recursiveLinearSearch_targetAtNthIndex_returnsCorrectIndex() {
        Integer[] myArray = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myTarget = 98;
        assertEquals(23, SearchingMethods.recursiveLinearSearch(myTarget, myArray, 0));
    }

    @Test
    void recursiveLinearSearch_targetAtArbitraryIndex_returnsCorrectIndex() {
        Integer[] myArray = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myTarget = 55;
        assertEquals(15, SearchingMethods.recursiveLinearSearch(myTarget, myArray, 0));
    }

    @Test
    void recursiveLinearSearch_multipleEqualTargets_returnsFirstOccurrenceIndex() {
        Integer[] myArray = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myTarget = 40;
        assertEquals(11, SearchingMethods.recursiveLinearSearch(myTarget, myArray, 0));
    }

    @Test
    void iterativeBinarySearch_nullArray_throwsException() {
        Integer[] myArray = null;
        Integer myTarget = 99;
        assertThrows(NullPointerException.class, () -> SearchingMethods.iterativeBinarySearch(myTarget, myArray));
    }

    @Test
    void iterativeBinarySearch_nullTarget_throwsException() {
        Integer[] myArray = new Integer[99];
        Integer myTarget = null;
        assertThrows(NullPointerException.class, () -> SearchingMethods.iterativeBinarySearch(myTarget, myArray));
    }

    @Test
    void iterativeBinarySearch_sizeZeroArray_returnsSentinel() {
        Integer[] myArray = new Integer[0];
        Integer myTarget = 99;
        assertEquals(-1, SearchingMethods.iterativeBinarySearch(myTarget, myArray));
    }

    @Test
    void iterativeBinarySearch_targetNotWithinArray_returnsSentinel() {
        Integer[] myArray = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myTarget = 99;
        assertEquals(-1, SearchingMethods.iterativeBinarySearch(myTarget, myArray));
    }

    @Test
    void iterativeBinarySearch_targetAtZeroIndex_returnsCorrectIndex() {
        Integer[] myArray = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myTarget = 0;
        assertEquals(0, SearchingMethods.iterativeBinarySearch(myTarget, myArray));
    }

    @Test
    void iterativeBinarySearch_targetAtNthIndex_returnsCorrectIndex() {
        Integer[] myArray = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myTarget = 98;
        assertEquals(23, SearchingMethods.iterativeBinarySearch(myTarget, myArray));
    }

    @Test
    void iterativeBinarySearch_targetAtArbitraryIndex_returnsCorrectIndex() {
        Integer[] myArray = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myTarget = 55;
        assertEquals(15, SearchingMethods.iterativeBinarySearch(myTarget, myArray));
    }

    @Test
    void iterativeBinarySearch_unorderedArray_returnsSentinel() {
        Integer[] myArray = {40, 49, 63, 0, 4, 8, 12, 18, 81, 89, 90, 33, 36, 35, 37, 40, 40, 74, 81, 89, 90, 98, 25, 31, 55, 61, 62,};
        Integer myTarget = 89;
        assertEquals(-1, SearchingMethods.iterativeBinarySearch(myTarget, myArray));
    }

    @Test
    void recursiveBinarySearch_nullArray_throwsException() {
        Integer[] myArray = null;
        Integer myTarget = 99;
        assertThrows(NullPointerException.class, () -> SearchingMethods.recursiveBinarySearch(myTarget, myArray, 0, myArray.length));
    }

    @Test
    void recursiveBinarySearch_nullTarget_throwsException() {
        Integer[] myArray = new Integer[99];
        Integer myTarget = null;
        assertThrows(NullPointerException.class, () -> SearchingMethods.recursiveBinarySearch(myTarget, myArray, 0, myArray.length));
    }

    @Test
    void recursiveBinarySearch_sizeZeroArray_returnsSentinel() {
        Integer[] myArray = new Integer[0];
        Integer myTarget = 99;
        assertEquals(-1, SearchingMethods.recursiveBinarySearch(myTarget, myArray, 0, myArray.length));
    }

    @Test
    void recursiveBinarySearch_targetNotWithinArray_returnsSentinel() {
        Integer[] myArray = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myTarget = 99;
        assertEquals(-1, SearchingMethods.recursiveBinarySearch(myTarget, myArray, 0, myArray.length));
    }

    @Test
    void recursiveBinarySearch_targetAtZeroIndex_returnsCorrectIndex() {
        Integer[] myArray = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myTarget = 0;
        assertEquals(0, SearchingMethods.recursiveBinarySearch(myTarget, myArray, 0, myArray.length));
    }

    @Test
    void recursiveBinarySearch_targetAtNthIndex_returnsCorrectIndex() {
        Integer[] myArray = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myTarget = 98;
        assertEquals(23, SearchingMethods.recursiveBinarySearch(myTarget, myArray, 0, myArray.length));
    }

    @Test
    void recursiveBinarySearch_targetAtArbitraryIndex_returnsCorrectIndex() {
        Integer[] myArray = {0, 4, 8, 12, 18, 25, 31, 33, 36, 35, 37, 40, 40, 40, 49, 55, 61, 62, 63, 74, 81, 89, 90, 98};
        Integer myTarget = 55;
        assertEquals(15, SearchingMethods.recursiveBinarySearch(myTarget, myArray, 0, myArray.length));
    }

    @Test
    void recursiveBinarySearch_unorderedArray_returnsSentinel() {
        Integer[] myArray = {40, 49, 63, 0, 4, 8, 12, 18, 81, 89, 90, 33, 36, 35, 37, 40, 40, 74, 81, 89, 90, 98, 25, 31, 55, 61, 62,};
        Integer myTarget = 89;
        assertEquals(-1, SearchingMethods.recursiveBinarySearch(myTarget, myArray, 0, myArray.length));
    }
}
