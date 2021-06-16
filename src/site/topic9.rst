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

* We want to understand the relationship between the size of the input :math:`n` and the time it takes to run the algorithm :math:`t(n)`
    * The size of input could be the length of a list to be sorted
    * How does the time to run the algorithm :math:`t(n)` change as :math:`n` changes?

* We call :math:`t(n)` the *growth function*
* Notice how :math:`t(n)` is a function of :math:`n'
    * This means the amount of time needed depends on :math:`n`

* Here is an arbitrary growth function
    * At this stage, don't worry about how we got it as we will come back to that

    :math:`t(n) = 15n^{2} + 25n`


.. image:: img/complexity_table.png
   :width: 500 px
   :align: center

* This table shows how each of the parts of the :math:`t(n)` growth function change as :math:`n` grows
* Take note as to which part can be blamed for most of the whole :math:`t(n)`

* When :math:`n` is small, which part of the expression gives a larger value?
* As :math:`n` **grows**, which becomes bigger?
* How much do the constants (:math:`15` and :math:`45`) impact the values?
    * Do they affect how big the numbers change as :math:`n` increases?


.. image:: img/complexity_growth0.png
   :width: 750 px
   :align: center

* This plot compares the parts of the function to the function itself
* Notice the scale of the axes
* See how the part that grows linearly, :math:`45n`, appears to be a horizontal line at this scale
* Also notice how the blue :math:`15n^{2}` line is perfectly covered by the green :math:`15n^{2} + 45n` line

* In other words, the :math:`45n` part of the function is effectively inconsequential when looking at the bigger picture
* Given this, and the fact that constants only scale the values, we say that the :math:`n^{2}` is the **dominant** term

.. warning::

    One thing students tend to miss when first learning about computational complexity is that the function tells us
    how things change relative to :math:`n`. At this stage, we're not worrying about any absolute values.

    For example, given this growth function...

        .. math::

            t(n) = n^{2} + 999n

    you may say that the :math:`999n` part of the function is going to dominate for all values :math:`n < 999`, which is
    true. However, this is not the point of complexity analysis. The point is identifying which part of the function
    **grows** faster, and in this example, :math:`n^{2}` absolutely grows faster.

    This is **not** to suggest that the observation of :math:`n < 999` is not important or valuable; this is only to
    highlight that it's about change and growth.


Asymptotic Growth
=================

Big-O Notation
==============


Examples
========





For next time
=============

* Read Chapter 2 of your text
    * 14 pages
