*********************
Topic #25 --- Sorting
*********************

* Like searching, sorting is a classic problem that we take for granted
* We have all sorted things before
* We know what it *means*
* We know what a correct outcome is
* But, chances are, you have not spent a lot of time really analyzing *how* you have sorted things

* Perhaps even more interesting, until relatively recently, we've been pretty terrible at it
    * And chances are, you are too

* There are many sorting algorithms out there
* They will work different ways, but result in sorted collections
* Some will more or less be the same in terms of the amount of computation required
* And some will be much better than others

* `Here is a simple visualization of some popular sorting algorithms <https://www.toptal.com/developers/sorting-algorithms>`_


Sorting Problem
===============

* Given a collection of *things*
    * Numbers
    * Strings
    * People
    * Car Parts

* The goal is to arrange the collection of *things* such that they are *in order*


Order
-----

* What *in order* means however will depend on what is being sorted
* For example
    * Numbers come with an intrinsic ordering
        * Java uses the `Natural Order <https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Comparable.html>`_
        * *"This ordering is referred to as the class's natural ordering, and the class's compareTo method is referred to as its natural comparison method."*
    * Strings could be ordered alphabetically
        * Perhaps by length?
    * Sort people based on height
        * Or age?
        * Or month and day of birthday?
    * Car Parts by mass?
        * Or production code?
        * Date they were made?
        * Volume?
        * The amount of dust particles on the surface?

* With numbers, we don't feel the need to ask
* But with other things, we need to have a well defined ordering for the *things*
    * The things themselves have the order-*ness* property, not a sorting algorithm

* We've already discussed this a few times already in the context of an ordered bag and binary search tree
    * `Comparable defines a natural ordering <https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Comparable.html>`_

* We may also want to have more complex orderings of things
    * For example, comparing things based on multiple values
    * I like to sort my music by artist and year
    * `Comparator defines an unnatural ordering <https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Comparator.html>`_

.. note::

    * For ease, we will use numbers in the examples, but the ideas are generalizable to other *things* if they have a defined order

    * We will define a collection of numbers ordered if and only if the elements are non-decreasing order
    * If we want to be more specific and include include duplicate values, we could say that the elements are *monotonically increasing*
        * A fancy way of saying the numbers are increasing or the same as we go, but **never** decreasing
            * For example: :math:`1, 2, 3, 5, 5, 6, 8, 8, 8, 9`

    * There is nothing stopping us from defining the order we want to be decreasing, but here we will simply use increasing


Bogosort
========


Bubble Sort
===========


Insertion Sort
==============


Selection Sort
==============


Bucket Sort
===========


Mergesort
=========


Quicksort
=========


Heapsort
========


For next time
=============

* Read Chapter 9 Section 2
    * 26 pages
