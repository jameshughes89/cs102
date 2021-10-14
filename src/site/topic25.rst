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


Bogosort
========

* Here's a fun idea

1. Assume we have a function called ``isSorted(collection)`` that returns true if the collection is sorted, false otherwise
    * :math:`O(n)`
2. Assume we have another function called ``shuffle(collection)`` that randomly shuffles the collection
    * :math:`O(n)`
    * Think of shuffling a deck of cards

* The algorithm is then:
    ``while not isSorted(collection)``
    ``    shuffle(collection)``

* Best case scenario, we get lucky with our collection already being sorted as we only need to use ``isSorted`` once
* Worst case is... *forever?*
* Really, we could get **really** unlucky and shuffle the elements such that they are the same, not in order order every time

* As you can probably tell, this is not a particularly great sorting algorithm in terms of computation required
* If your :math:`n` is very small, sure you will *probably* end up with a sorted collection after a while
* But to put things into perspective, there are a total :math:`8.0658175x10^{67}` permutations of a deck of 52 cards`!`


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
