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

    For ease, we will use numbers in the examples, but the ideas are generalizable to other *things* if they have a
    defined order.

    We will define a collection of numbers ordered if and only if the elements are non-decreasing order. If we want to
    be more specific and include include duplicate values, we could say that the elements are
    *monotonically increasing*. This is just fancy way of saying the numbers are increasing or the same/equal as we go,
    but **never** decreasing. For example:

        :math:`1, 2, 3, 5, 5, 6, 8, 8, 8, 9`

    There is nothing stopping us from defining the order we want to be decreasing, but here we will simply use
    increasing.


Bogosort
========

* Here's a fun idea

1. Assume we have a function called ``isSorted(collection)`` that returns true if the collection is sorted, false otherwise
    * :math:`O(n)`
2. Assume we have another function called ``shuffle(collection)`` that randomly shuffles the collection
    * :math:`O(n)`
    * Think of shuffling a deck of cards

* The algorithm is then:
    ``while not isSorted(collection): shuffle(collection)``

* Best case scenario, we get lucky with our collection already being sorted as we only need to use ``isSorted`` once
* Worst case is... *forever?*
* Really, we could get **really** unlucky and shuffle the elements such that they are the same, not in order order every time

* As you can probably tell, this is not a particularly great sorting algorithm in terms of computation required
* If your :math:`n` is very small, sure you will *probably* end up with a sorted collection after a while
* But to put things into perspective, there are a total :math:`8.0658175x10^{67}` permutations of a deck of 52 cards``!``
    * To put this in perspective, there are roughly :math:`2.4x10^{67}` atoms in the Milky Way
    * If we assigned each possible ordering to every atom in the Milky Way, we'd run out of atoms
        * we'd have roughly :math:`5.7\times10^{67}` permutations left over
    * `There's also a fun story to go with this <https://www.reddit.com/r/AskReddit/comments/6il1jx/comment/dj71u1v/?utm_source=share&utm_medium=web2x&context=3>`_


Bubble Sort
===========

.. image:: img/sort_bubblesort.png
   :width: 500 px
   :align: center
   :target: https://en.wikipedia.org/wiki/Bubble_sort

* The general idea of bubble sort is to look at the list, and if we see any adjacent numbers out of order, swap them
* What's neat about this is, as long as we swap *out of order* adjacent values, it actually doesn't matter the order we apply the swaps

    :math:`4, 3, 2, 1`

* With the above example, we *could* go this route

    :math:`4, 3, 2, 1`

    :math:`3, 4, 2, 1`

    :math:`3, 2, 4, 1`

    :math:`2, 3, 4, 1`

    :math:`2, 3, 1, 4`

    :math:`2, 1, 3, 4`

    :math:`1, 2, 3, 4`


* Or, we could go this way

    :math:`4, 3, 2, 1`

    :math:`4, 3, 1, 2`

    :math:`3, 4, 1, 2`

    :math:`3, 1, 4, 2`

    :math:`3, 1, 2, 4`

    :math:`1, 3, 2, 4`

    :math:`1, 2, 3, 4`


* Selecting an arbitrary pair of values to switch works, but we would like to have a more systematic strategy
* Instead of randomly selecting, start at the beginning and look at each adjacent par and move up the list

**Pass 1**

    :math:`4, 3, 2, 1`

    :math:`3, 4, 2, 1`

    :math:`3, 2, 4, 1`

    :math:`3, 2, 1, 4`


* However, simply doing one pass does not guarantee that the list will be in order
* In fact, all it does guarantee is that the largest value in the list will have *bubbled up* to its correct spot

* The trick is to repeat this process until the list is sorted

**Pass 2**

    :math:`3, 2, 1, 4`

    :math:`2, 3, 1, 4`

    :math:`2, 1, 3, 4`

**Pass 3**

    :math:`1, 2, 3, 4`


Worst Case Scenario
-------------------

* The above example showed the *worst case scenario* for this specific bubble sort idea --- the list is in reverse order
* The question is, how many passes must we do to guarantee that the list is sorted?

* If the list is length :math:`n`
* And after a single pass the largest value is in its proper location
* After a second pass, the second largest value is in its proper location
* After a third, the third largest will be where it needs to
* ...
* After :math:`n` passes, we know the list is sorted
    * Actually, :math:`n-1` since putting the :math:`(n-1)^{th}` thing in its proper spot would result in also having the last element, the :math:`n^{th}`, also be in its proper spot
    * See the above example, where :math:`n = 4` and we needed only 3 passes


Best Case Scenario
------------------

* Consider the case where the list is already in order

    :math:`1, 2, 3, 4`

* If may feel rather silly doing a total of :math:`n-1` passes since after a single pass we can conclude that it's already sorted
* In this case, an easy way to stop the sort is to check if we ever finish a pass and make no swaps
    * If we never swapped anything, then nothing was out of order, therefore the list must be sorted


Algorithm
---------

* While the list is not sorted
    * Compare each adjacent pair of values
        * If they are out of order
            * Swap them
            * Note that the list is not yet known to be sorted


Computational Complexity
------------------------

* For the best case scenario, we still need to do a complete pass over all :math:`n` elements since we can only conclude if it is sorted or not by looking at the whole list
    * Best case :math:`O(n)`

* For the worst case, each pass is :math:`O(n)`, but we need a total of :math:`n-1` passes
    * Worse Case :math:`O(n^{2})`


Insertion Sort
==============


Selection Sort
==============


Radix Sort
==========

Distributed Non-Comparative Sorting
-----------------------------------


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
