*************************************
Topic #18 --- Memory & The Call Stack
*************************************


Memory Allocation
=================

* Memory is broken down into two broad sections

1. The Stack
    * Stores information about the current method running
        * Local variables
        * Formal parameters
        * Return address

2. The Heap
    * Which can be broken down further into storage for
    a. Static information
        * e.g. your code
    b. Instance information
        * e.g. Objects
        * Technically, in Java, this can be broken down further into an area for longer living objects and an area for younger ones
            * We will ignore this here


.. image:: img/memory_abstraction.png
   :width: 500 px
   :align: center


* For example, if I were to run ``SortedBag<T> myBag = new ArraySortedBag<>();`` in my main method
    * The information on what an ``ArraySortedBag`` is is stored in the static area of the heap
    * The ``ArraySortedBag`` that is created is put into the instance area of the heap
    * The reference variable ``myBag`` is stored in the stack


The Call Stack
==============


Call Frame
----------


Heap
====


Static Space
------------


Object Space
------------


Garbage Collection
==================


Stack Overflow
==============

* What do you think would happen if I run the following method from ``main``?

.. code-block:: java
    :linenos:

    static void uhOh() {
        System.out.println("Weeeeeeeeeeeeeeeeeeeeeeee!!!");
        uhOh();
    }

.. image:: img/memory_overflow.png
   :width: 500 px
   :align: center


For next time
=============

* Read Chapter 8
    * 28 pages
