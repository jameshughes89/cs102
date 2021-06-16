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


Asymptotic Growth & Big-O
=========================

* We **don't** care about constants
* We **don't** care about non dominant terms

* We **do** care about *asymptotic complexity*
    * Fancy way of saying *The time the algorithm takes as a function of* :math:`n` *will grow like...*

* We care about the *order* of the algorithm
* We specify the order by using *Big-O notation*
* In our example, :math:`t(n) = 15n^{2} + 45n` is :math:`O(n^{2})` since it grows like :math:`n^{2}`


Example Growth Functions and Their Order
----------------------------------------

+--------------------------------------+------------------------+
| *Growth Function*                    | *Order*                |
+======================================+========================+
| :math:`t(n) = 17`                    | :math:`O(1)`           |
+--------------------------------------+------------------------+
| :math:`t(n) = 20n - 4`               | :math:`O(n)`           |
+--------------------------------------+------------------------+
| :math:`t(n) = 12n log_{2}(n) + 100n` | :math:`O(nlog_{2}(n))` |
+--------------------------------------+------------------------+
| :math:`t(n) = 3n^{2} + 5n - 2`       | :math:`O(n^{2})`       |
+--------------------------------------+------------------------+
| :math:`t(n) = 2^{2} + 3n`            | :math:`O(2^{n})`       |
+--------------------------------------+------------------------+

    .. image:: img/complexity_growth1.png
       :width: 500 px
       :align: center

* `We often try to keep the expression in the Big-O notation simple <https://en.wikipedia.org/wiki/Big_O_notation#Orders_of_common_functions>`_

+--------------------------------------+------------------------+
| *Growth Function*                    | *Order*                |
+======================================+========================+
| :math:`t(n) = 5n^{2} + 3n`           | :math:`O(?)`           |
+--------------------------------------+------------------------+
| :math:`t(n) = n^{3} + log_{2}(n) - 4`| :math:`O(?)`           |
+--------------------------------------+------------------------+
| :math:`t(n) = 10n log_{2}(n) + 5`    | :math:`O(?)`           |
+--------------------------------------+------------------------+
| :math:`t(n) = 3n^{2} + 3n^{3} + 3`   | :math:`O(?)`           |
+--------------------------------------+------------------------+
| :math:`t(n) = 2^{n} + 18n^{100}`     | :math:`O(?)`           |
+--------------------------------------+------------------------+





For next time
=============

* Read Chapter 2 of your text
    * 14 pages
