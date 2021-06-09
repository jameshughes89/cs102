***********************
Topic #6 --- ArrayStack
***********************

* We now are familiar with *what* we want the stack ADT to do without talking about *how*
* Obviously, in order to use a stack in Java, we need to actually implement a stack

* We now need to think about implementation issues
    * How are we going to keep track of our data?
    * How will we know where the top is?
        * This will depend on the choice of how we store the data

Implementing a Stack --- Array Container
========================================

ArrayStack Implementation Issues
--------------------------------

* We've already seen that arrays are great for storing contiguous data

.. image:: ../img/array.png
   :width: 500 px
   :align: center

* If this is the case, how should we keep track of the top of the stack?

* What are the pros and cons of making keeping the top index 0?
    * We always know where the top is
    * Every time we ``push`` or ``pop`` we'd need to move everything in the stack down one spot

* What are the pros and cons of making the top the other end?
    * We'd need another variable to keep track of where the top is
    * We do not need to shuffle anything around

* The strategy we will use is a variable to keep track of *the next available spot* in the array
    * ``push`` at the ``top`` index and update ``top``
    * ``pop at the ``top - 1`` index and update ``top``
* Also, due to zero based indexing, the variable keeping track of top will always be the number of things in the stack (``size``)





Expand Capacity
---------------



Exceptional Situations
----------------------


For next time
=============

* Finish reading Chapter 3
    * 16 pages
