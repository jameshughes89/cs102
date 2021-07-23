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

* Now that we are more familiar with recursion, here is the exact same high-level abstract idea, but implemented with recursion

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

* If I wanted to call this method, I would start with ``currentIndex`` as ``0``
    * ``recursiveLinearSearch(someTarget, someArray, 0)``

* This may seem quite different from the iterative implementation, but take some time to look at the code and see what's happening
    * Start ``currentIndex`` at ``0``
    * Are we past the end of the array? If so, we conclude we didn't find it and we're done
    * If the element at index ``currentIndex`` is what we're looking for, we've found it and we're done
    * Otherwise, if we're not at the end and we didn't find it, check ``currentIndex + 1``


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

