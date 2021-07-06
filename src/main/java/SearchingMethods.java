public class SearchingMethods {

    public static <T> int iterativeLinearSearch(T toFind, T[] data) {
        for (int i = 0; i < data.length; ++i) {
            if (data[i].equals(toFind)) {
                return i;
            }
        }
        return -1;
    }

    public static <T> int recursiveLinearSearch(T toFind, T[] data, int currentIndex) {
        // Not Found
        if (currentIndex == data.length) {
            return -1;
        } else if (data[currentIndex].equals(toFind)) {
            return currentIndex;
        } else {
            return recursiveLinearSearch(toFind, data, currentIndex + 1);
        }
    }

    public static <T extends Comparable<? super T>> int iterativeBinarySearch(T toFind, T[] data) {
        int lowIndex = 0;
        int highIndex = data.length;
        int midpoint = (highIndex - lowIndex) / 2;

        while (lowIndex < highIndex) {
            if (data[midpoint].equals(toFind)) {
                return midpoint;
            } else if (data[midpoint].compareTo(toFind) > 0) {
                highIndex = midpoint - 1;
                midpoint = lowIndex + (highIndex - lowIndex) / 2;
            } else {
                lowIndex = midpoint + 1;
                midpoint = lowIndex + (highIndex - lowIndex) / 2;
            }
        }
        return -1;
    }

    public static <T extends Comparable<? super T>> int recursiveBinarySearch(T toFind, T[] data, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return -1;
        }
        int midpoint = lowIndex + (highIndex - lowIndex) / 2;
        if (data[midpoint].equals(toFind)) {
            return midpoint;
        } else if (data[midpoint].compareTo(toFind) > 0) {
            highIndex = midpoint - 1;
        } else {
            lowIndex = midpoint + 1;
        }
        return recursiveBinarySearch(toFind, data, lowIndex, highIndex);
    }
}
