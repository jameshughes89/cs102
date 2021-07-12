*************************************
Topic #18 --- Memory & The Call Stack
*************************************


* When running programs on our computer, memory is used and accessed in different ways
* Typically, we physically store instructions *and* data in the same address space
    * Note that there are other architectures/strategies one could use for a computational system

* This could be a recipe for disaster, but our modern systems have strategies for mitigating this
* For many programming languages, Java included, we logically separate out memory into areas for
    * Instructions
        * e.g. Classes & Interfaces
    * Dynamically allocated stuff
        * e.g. Objects
    * Stuff related to what is currently happening
        * e.g. Variables & parameters

.. warning::

    The content of this topic is kept at a high-level for introductory purposes. There may be many asterisks added to many of the
    statements contained within.


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

* Very broadly speaking, the heap can be broken into static space and object space

Static Space
------------

* The static space contains one copy of all your code
    * Classes
    * Static methods
    * Static variables
    * Interfaces


Object Space
------------

* The object space stores the created objects
    * The object type
    * Values of the object's fields
        * This includes primitive types and references variables to other objects in the heap

* In Java, this is broken down into
    * Young generation
    * Old/Tenured generation

* The young generation area can be broken down further into
    * Eden space
    * Survivor space

* When an object is created, it is put into *eden space*
* If the object survives for long enough, it gets promoted to *survivor space*
* If an object survives long enough in survivor space, it gets promoted to *old/tenured space*


.. note::

    For the purposes of this course, we will not worry about these extra details; we will keep the focus on the stack,
    object space in the heap, and the static space in the heap.


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
