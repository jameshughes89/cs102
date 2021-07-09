*************************************
Topic #18 --- Memory & The Call Stack
*************************************


Memory Allocation
=================


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
