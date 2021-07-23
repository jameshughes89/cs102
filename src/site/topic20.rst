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

* Below is a generic Java implementation of a linear search on an array of type ``T``
* Other than being a generic method, this should be something you are familiar with

.. code-block:: java
    :linenos:

    public static <T> int iterativeLinearSearch(T toFind, T[] data) {
        for (int i = 0; i < data.length; ++i) {
            if (data[i].equals(toFind)) {
                return i;
            }
        }
        return -1;
    }

* This iterative implementation is also fairly similar to the high-level description of the algorithm
    * Start at ``i = 0`` --- the beginning of the array
    * If the element at index ``i`` is what we're looking for, we've found it and we're done
    * Otherwise continue and increment ``i``
    * If we ever look at all indices and do not find it, then we conclude that it's not there and we're done


Recursive
---------


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

