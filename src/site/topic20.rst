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


Binary Search
=============

* Let's say you're looking for page 554 in a textbook
* You'd probably open the book somewhere in the middle-ish
* If the page you end up turning to is page 383, which half of the book should you continue your search on?
    * Left pages, or right pages?
* Since 554 is greater than 383, it must be in the set of right pages
    * We eliminate the 383 pages from the set of left pages from our search since 554 must **not** be there
* Next, you turn to a page somewhere between pages 383 and the end of the book and see page number 621
    * Which set of pages do you then continue your search down?

* This general idea is the basis of binary search

* There is, however, a catch with binary search when compared to a linear search
    * The collection we're searching, must be sorted, otherwise we would not be able to conclude which half our needle is


Iterative
---------


Recursive
---------


For next time
=============

* Read Chapter 9 Section 1
    * 7 pages

