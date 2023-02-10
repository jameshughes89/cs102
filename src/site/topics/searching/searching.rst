*********
Searching
*********

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

* Throughout this topic, the thing we're looking for will be referred to as the *needle* and the collection we're searching will be referred to as the *haystack*


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

    .. image:: linear_search.png
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

* It is also common to have a *helper* method that makes the first recursive call with the proper values

.. code-block:: java
    :linenos:

    public static <T> int recursiveLinearSearch(T needle, T[] haystack) {
        return recursiveLinearSearch(someNeedle, someHaystack, 0);
    }


* This may seem quite different from the iterative implementation, but take some time to look at the code and see what's happening
    * Start ``currentIndex`` at ``0``
    * Are we past the end of the array? If so, we conclude we didn't find it and we're done
    * If the element at index ``currentIndex`` is what we're looking for, we've found it and we're done
    * Otherwise, if we're not at the end and we didn't find it, check ``currentIndex + 1``


Binary Search
=============

* Imagine looking for page 554 in a roughly 1000 page textbook
* It would be reasonable to start by opening the textbook somewhere in the middle-ish
* If the page landed on was page 402, which half of the book must page 553 be in?

    * Left set of pages, or right set of pages?


* Since 554 is greater than 383, it must be in the right set of pages

    * This means, after looking at a single page, the 401 pages in the left set can be ignored


* With this information, imagine turning to another page in the right set of pages and landing on page 621

    * Which remaining set of pages must the page 554 be in?
    * In the left set of pages (403 -- 620), or the right set (622 -- 1000)?


* This general idea is the basis of binary search

    * Technically, this is `interpolation search <https://en.wikipedia.org/wiki/Interpolation_search>`_
    * A binary search is a special kind of interpolation search


* There is, however, a catch with binary search when compared to a linear search
* The ``haystack`` being searched must be sorted
* If it was not sorted, it would not be possible to conclude which half the ``needle`` is in after investigating an element

* The complexity analysis of binary search may feel intimidating, but the trick is to visualize the work being done

.. figure:: binary_search.png
    :width: 500 px
    :align: center

    Visualization of how to search for a number within the range 1 -- 15. The initial guess would be the halfway point
    and each subsequent guess would be the halfway point of the remaining elements. Elements at the bottom would take
    4 guesses to find.


* To analyze the complexity, consider the worst case scenario

    * Look for an element at the bottom as it would take the most number of guesses to find
    * Looking for an element that does not exist would also work


* First, imagine performing a *linear search* where the ``needle`` is ``15``
* In this case, all :math:`15` elements in the ``haystack`` would need to be investigated before the ``needle`` was found

    * Since it is at the end of the ``haystack``


* When considering a *binary search*, how many things would need to be looked at before ``15`` is found?

    * :math:`4`
    * ``8`` -> ``12`` -> ``14`` -> ``15``


* The reason this takes fewer steps is because roughly half of the remaining elements are ignored after each check

    * For example, ``15`` is greater than ``8``, therefore the numbers ``1`` -- ``7`` can be ignored
    * In other words, with *linear search*, after a single guess, only the element checked can be eliminated
    * But with *binary search*, the element checked, plus roughly half the remaining elements, can be ignored


* There is a relationship between the maximum number of checks and the number of elements :math:`n` in the ``haystack``

    * :math:`n = 2^{h + 1} - 1`, where `h` is the "height" of the "tree", or, the number of steps needed to get from the top to the bottom
    * :math:`h = log_{2}(n + 1) - 1`


* Thus, the computational complexity of binary search is :math:`O(log_{2}(n))`

    * As :math:`n` grows, the maximum number of steps that could be taken grows like :math:`log_{2}(n)`


.. warning::

    The above explanation uses details not discussed in this course yet, but they be covered in subsequent topics. In
    other words, don't be too concerned if these ideas are not 100% clear yet.



Iterative
---------

* Below is a generic implementation of an iterative binary search

    * Take note that ``T`` or one of their superclasses must extend ``Comparable``
    * This is because the elements must be ordered


.. literalinclude:: /../main/java/SearchingFunctions.java
    :language: java
    :lineno-match:
    :lines: 27-44


* Here is what's happening

    * While search space has not been exausted (``lowIndex < highIndex``)

        * If ``lowIndex`` is ever greater than or equal to ``highIndex``, there are no more indices the element *could* exist


    * Look at the middle
    * If the element in the middle is the ``needle``

        * Done


    * If the element in the middle is less than the ``needle``

        * Continue the search on the remaining upper half by looking at the midpoint of the remaining elements


    * If the element in the middle is greater than the ``needle``

        * Continue the search on the remaining lower half by looking at the midpoint of the remaining elements



Recursive
---------

* Below is a recursive implementation of a binary search
* Notice that, other than being recursive, the underlying high-level algorithm is the same as the iterative implementation

.. literalinclude:: /../main/java/SearchingFunctions.java
    :language: java
    :lineno-match:
    :lines: 46-58


* To call this method to initiate a search, start with ``lowIndex`` as ``0`` and ``highIndex`` as ``someHaystack.length``

    * ``recursiveBinarySearch(someNeedle, someHaystack, 0, someHaystack.length)``



For Next Time
=============

* Read Chapter 9 Section 1

    * 7 pages


Playing Code
------------

* Download and play with

    * :download:`SearchingFunctions </../main/java/SearchingFunctions.java>`
    * :download:`SearchingFunctionsTest </../test/java/SearchingFunctionsTest.java>`
