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
    * Best case scenario, the thing we are looking for is the first element --- constant :math:`O(n)`
    * On average, the element will be in the middle --- linear :math:`O(n)` --- remember, we ignore constants, and :math:`1/2` is a constant
        * For every time it's the last element, it could be the first element in another search
        * For every time it's the 2nd element, it could be in the second position in another search
        * ...


Iterative
---------


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

