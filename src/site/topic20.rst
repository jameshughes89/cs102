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

* We have used linear search many times already
* Start at the beginning of an array and sequentially look at each element until we find a matching element
    * If we find it, then we conclude that it is there
    * If we get to the end and do not find it, then we conclude that it is not there

* Notice that this description of the algorithm doesn't really go into any more details
    * It is fairly high-level --- abstract

* We've also discussed the computational complexity
    * Worst case scenario, we look at every element in the array before we make a conclusion --- linear :math:`O(n)`
    * Best case scenario, the thing we are looking for is the first element --- constant :math:`O(1)`
    * On average, the element will be in the middle --- linear :math:`O(n)` --- remember, we ignore non-dominant terms, and :math:`1/2` is a constant, which is dominated by a linear term
        * For every time it's the first element, it could be the last element in another search
        * For every time it's the 2nd element, it could be in the second last position in another search
        * ...

    .. image:: img/search_linear.png
       :width: 500 px
       :align: center

* In the above example, to know if something is or is not there, we would need to look at all :math:`n` elements


Iterative
---------

* Below is a generic implementation of a linear search on an array of type ``T``
* Other than being a generic method, this should be something you are familiar with

.. code-block:: java
    :linenos:

    public static <T> int iterativeLinearSearch(T needle, T[] haystack) {
        for (int i = 0; i < haystack.length; ++i) {
            if (haystack[i].equals(needle)) {
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

* Now that we are more familiar with recursion, here is the same high-level abstract idea, but implemented with recursion

.. code-block:: java
    :linenos:

    public static <T> int recursiveLinearSearch(T needle, T[] haystack, int currentIndex) {
        // Not Found
        if (currentIndex == haystack.length) {
            return -1;
        } else if (haystack[currentIndex].equals(needle)) {
            return currentIndex;
        } else {
            return recursiveLinearSearch(needle, haystack, currentIndex + 1);
        }
    }

* If I wanted to call this method, I would start with ``currentIndex`` as ``0``
    * ``recursiveLinearSearch(someNeedle, someHaystack, 0)``

* This may seem quite different from the iterative implementation, but take some time to look at the code and see what's happening
    * Start ``currentIndex`` at ``0``
    * Are we past the end of the array? If so, we conclude we didn't find it and we're done
    * If the element at index ``currentIndex`` is what we're looking for, we've found it and we're done
    * Otherwise, if we're not at the end and we didn't find it, check ``currentIndex + 1``


Binary Search
=============


Iterative
---------

* Below is a generic implementation of an iterative binary search on an array of type ``T``
    * Take note that ``T`` or one of their superclasses must extend ``Comparable``
    * This is because the elements must be ordered

.. code-block:: java
    :linenos:

    public static <T extends Comparable<? super T>> int iterativeBinarySearch(T needle, T[] haystack) {
        int lowIndex = 0;
        int highIndex = haystack.length;
        int midpoint = (highIndex - lowIndex) / 2;

        while (lowIndex < highIndex) {
            if (haystack[midpoint].equals(needle)) {
                return midpoint;
            } else if (haystack[midpoint].compareTo(needle) > 0) {
                highIndex = midpoint - 1;
                midpoint = lowIndex + (highIndex - lowIndex) / 2;
            } else {
                lowIndex = midpoint + 1;
                midpoint = lowIndex + (highIndex - lowIndex) / 2;
            }
        }
        return -1;
    }

* This may look complicated, but again, take your time

* Here is what's happening
    * While we have not exhausted the search space (``lowIndex < highIndex``)
        * If ``lowIndex`` is ever greater than or equal to ``highIndex``, there are no more indices the element *could* exist  
    * Look at the middle
    * If what you are looking at is what you're looking for
        * Done
    * If what you are looking at is less than what you're looking for
        * Continue the search on the remaining upper half by looking at the midpoint of the remaining elements
    * If what you are looking at is greater than than what you're looking for
        * Continue the search on the remaining lower half by looking at the midpoint of the remaining elements


Recursive
---------


For next time
=============

* Read Chapter 9 Section 1
    * 7 pages

