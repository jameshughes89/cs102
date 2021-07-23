***********************
Topic #20 --- Searching
***********************

* For our needs, we will say we want to search for a specified *thing* in *something* and know if it exists there or not
* For example, does a given number exist within an array of numbers
    * We will use this version of the problem here

* If we want to write an algorithm to solve this problem, all we really need is something that tells us if it's there or not
    * That's all that's required
    * We could write any algorithm that works

* However, we're going to look at two intuitive ideas that all of you have, more or less, used in one way or another many times in your life
    * Linear Search
    * Interpolation Search
        * We will discuss a specific kind of interpolation search called a *binary search*


Linear Search
=============


Iterative
---------


Recursive
---------

.. code-block:: java
    :linenos:

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

Binary Search
=============


Iterative
---------


Recursive
---------


For next time
=============

* Read Chapter 9 Section 1
    * 7 pages

