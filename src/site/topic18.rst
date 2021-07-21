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

* The call stack is the part of memory where the information about the current method being run is stored
    * Along with the other methods that were running, but are waiting on the current running method to end so it can resume

* The call stack is also a *stack* --- we push and pop information to/from the stack at one end


Call Frame
----------

* Each time we start running a method, a *call frame* containing relevant information for the method is created and pushed onto the stack

* The call frame contains important information for the execution of the method
    * Space for the parameters passed to the method
    * Space for local variables
        * If the data type is a primitive type, the data is simply stored here
        * If the data is an object, then the data stored is a reference to where the object is in the heap
    * Memory address of where the program returns to when the method finishes
        * Where the calling method's call frame can be found in memory

* When the running method finishes, it is popped from the stack and the memory it used is deallocated

.. code-block:: java
    :linenos:

    public static void main(String[] args) {
        function1();
    }

    static void function1() {
        System.out.println("Starting function1");
        System.out.println("Calling function2");
        function2();
        System.out.println("Calling function3");
        function3();
        System.out.println("Finished function1");
    }

    static void function2() {
        System.out.println("Starting function2");
        System.out.println("Calling function4");
        function4();
        System.out.println("Finished function2");
    }

    static void function3() {
        System.out.println("Starting function3");
        System.out.println("Finished function3");
    }

    static void function4() {
        System.out.println("Starting function4");
        System.out.println("Finished function4");
    }

* Running the above example would result in the call stack behaving like the below gif

.. image:: img/callstack_gif.gif
   :width: 250 px
   :align: center



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

* When an object is created, it is put into the object part of the heap


Garbage Collection
==================

* When a method finishes running and the call frame from the call stack is not needed anymore, the memory is deallocated
* When an object in the object space is not needed anymore, *garbage collection* comes into play

* In some programming languages, when we don't need something from the heap that we've allocated anymore, we need to deallocate the memory it used
    * If we don't we have a *memory leak*

* In Java, and most modern languages, if an object is not reachable anymore, then it can't be used, thus it is available for garbage collection
    * Not reachable?

* An object is *not reachable* when we can't get reference to it anymore

.. image:: img/links_example1.png
   :width: 500 px
   :align: center

* In the above example there is the reference variable ``head`` and each of the node's ``next`` fields
    * There are also references to the data being referenced by the ``data`` field, but we will ignore those here

* For example, if we have ``head`` as a reference variable in our ``main`` method, everything in this linked structure is accessible
    * ``head``
    * ``head.getNext()``
    * ``head.getNext().getNext()``
    * etc.

* If one of the links in the structure gets lost, all nodes after the lost link become unreachable
    * e.g. ``head.getNext().getNext().setNext(null)``
* All the nodes after the removed link are now deemed available for garbage collection

* If ``head`` gets reassigned and we have no other reference to the first node in the linked structure, all nodes become unreachable
    * e.g. ``head = null``
* Even though all nodes, except for the first one, have references to them via their predecessor's ``next`` field, none are actually reachable anymore
* In the end, all nodes end up being available for garbage collection


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
   :width: 250 px
   :align: center


For next time
=============

* Read Chapter 8
    * 28 pages
