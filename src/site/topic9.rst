*******************************
Topic #9 --- Algorithm Analysis
*******************************

* What does it mean for an algorithm to be *good*?
* What makes one algorithm for solving a given problem better than another?
* Your algorithm may be correct, but is it practical?

* These questions can be answered in many ways, but one important measurement is how much resources does your algorithm need?
    * How much time to compute?
    * How much memory does it need?
    * How many processors does it need?
    * How does the amount of resources change relative to some input value?

* The above considerations are all important, but we will start by focusing on *Time Complexity*


Time Complexity
===============

* We analyze the amount of time the algorithm needs *relative to the input size*
    * How long does it take to sort 10 items?
    * How long does it take to sort 10,000 items?

* We also consider the number of operations needed for the algorithm, and the time complexity of those operations
    * Addition
    * Comparisons

* When we have a better understanding of our algorithm's time complexity, it can help us choose the right tool for the job


Growth Function
===============


Asymptotic Growth
=================

* We **don't** care about constants
* We **don't** care about non dominant terms

* We **do** care about *asymptotic complexity*
    * Fancy way of saying *The time the algorithm takes as a function of* :math:`n` *will grow like...*


Big-O Notation
==============


Examples
========





For next time
=============

* Read Chapter 2 of your text
    * 14 pages
