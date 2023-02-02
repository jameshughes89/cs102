import java.util.Objects;

public class SearchingMethods {

    public static <T> int iterativeLinearSearch(T needle, T[] haystack) {
        for (int i = 0; i < haystack.length; i++) {
            if (Objects.equals(haystack[i], needle)) {
                return i;
            }
        }
        return -1;
    }

    public static <T> int recursiveLinearSearch(T needle, T[] haystack, int currentIndex) {
        // Not Found
        if (currentIndex == haystack.length) {
            return -1;
        } else if (Objects.equals(haystack[currentIndex], needle)) {
            return currentIndex;
        } else {
            return recursiveLinearSearch(needle, haystack, currentIndex + 1);
        }
    }

    public static <T extends Comparable<? super T>> int iterativeBinarySearch(T needle, T[] haystack) {
        int lowIndex = 0;
        int highIndex = haystack.length;
        int midpoint = (highIndex - lowIndex) / 2;

        while (lowIndex < highIndex) {
            if (Objects.compare(haystack[midpoint], needle, T::compareTo) == 0) {
                return midpoint;
            } else if (Objects.compare(haystack[midpoint], needle, T::compareTo) > 0) {
                highIndex = midpoint - 1;
                midpoint = lowIndex + (highIndex - lowIndex) / 2;
            } else {
                lowIndex = midpoint + 1;
                midpoint = lowIndex + (highIndex - lowIndex) / 2;
            }
        }
        return -1;
    }

    public static <T extends Comparable<? super T>> int recursiveBinarySearch(T needle, T[] haystack, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return -1;
        }
        int midpoint = lowIndex + (highIndex - lowIndex) / 2;
        if (Objects.compare(haystack[midpoint], needle, T::compareTo) == 0) {
            return midpoint;
        } else if (Objects.compare(haystack[midpoint], needle, T::compareTo) > 0) {
            return recursiveBinarySearch(needle, haystack, lowIndex, midpoint - 1);
        } else {
            return recursiveBinarySearch(needle, haystack, midpoint + 1, highIndex);
        }
    }
}
