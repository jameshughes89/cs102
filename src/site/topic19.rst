***********************
Topic #19 --- Recursion
***********************

|lineA| |lineB| |lineC|

.. |lineA| image:: img/recursion_line.png
    :width: 25%

.. |lineB| image:: img/recursion_line.png
    :width: 25%

.. |lineC| image:: img/recursion_line.png
    :width: 25%

* How many people are in this line?
    * How would you count them?

* I'd say the answer is, just by looking at the first person, it's exactly ``1 + `` the number of people after the first person


Iterative Definition vs. Recursive Definition
=============================================


Groups of People
----------------


Series of Numbers
-----------------


Lists
-----


Recursion
=========

* In counting example, it may feel like cheating by saying "1 + however many are after the front"
    * *however many are after the front* seems like we're skipping a step

* However, with the list example, we also see the we repeatedly apply the same rule over and over again on smaller and smaller lists until we get to the end (the empty list)
    * This pattern arises a lot with recursion --- repeatedly apply the same rules on slightly different versions of the problem

* As mentioned earlier, we're typically going to have a **base case** and a *8recursive case**
* In fact, we can have multiple base cases and recursive cases
    * We will see examples of these when discussing trees


Going Up and Down
-----------------

* Sometimes we start at the base case and work our way *up*
    * 0 is a natural number
    * A natural number + 1 is a natural number
        * 0 is a natural number
        * Therefore, 1 (0 + 1) is a natural number
        * Therefore, 2 (1 + 1) is a natural number
        * Therefore, 3 (2 + 1) is a natural number
        * ...

* This is a great way to mathematically define something infinite
    * Though, your computers will not be all too happy with running this

* Sometimes we work our way *down* towards a base case
    * Is 4 a natural number?
    * Is 3 + 1 a natural number?
    * Is (2 + 1) + 1 a natural number?
    * Is ((1 + 1) + 1) + 1) a natural number?
    * Is ((((0 + 1) + 1) + 1) + 1) a natural number?
    * Zero is a natural number, therefore they're all natural numbers


Factorial
---------


Recursive Programming
=====================


Factorial
---------


Sum
---


Observations
============


Computational Complexity
========================


Fibonacci
---------


Towers of Hanoi
===============


For next time
=============

* Read Chapter 8
    * 28 pages
