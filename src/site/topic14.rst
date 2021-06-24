*************************
Topic #14 --- Inheritance
*************************




Terminology
===========

* The class that is being inherited *from* is referred to as the **superclass**
    * Parent class
    * Base class

* The class that is inheriting from a superclass is called the **subclass**
    * Child class
    * Derived class

* When considering the hierarchies, these terms are relative
    * A ``SortedBag`` is a subclass of a ``Bag``
    * A ``Bag`` is a superclass of a ``IndexedBag``
    * An ``Object`` is also a superclass of ``Bag``, ``SortedBag``, and ``IndexedBag``


Polymorphism
============

* Polymorphism is the idea that behavior can change depending on the type of the object
* We've already made use of this idea without having gone into any details
    ``Stack<Integer> myStack = new ArrayStack<>();``
    ``Stack<Integer> myStack = new LinkedStack<>();``

* Our reference variables here is for something of type ``Stack``
* Yet, it can reference an object of type ``ArrayStack`` or ``LinkedStack``
* This is because, ``ArrayStack`` *is a* ``Stack`` and ``LinkedStack`` *is a* ``Stack``

* You **cannot** however do this
    ``ArrayStack<Integer> myStack = new LinkedStack<>();``

* This is because a ``LinkedStack`` is **not** an ``ArrayStack``

.. warning::

    If we did something like this:

        .. code-block:: java
            :linenos:

            Stack<Integer> myStack = new LinkedStack<>();
            Object o = myStack;

    The thing both ``myStack`` and ``o`` reference is still a ``LinkedStack`` object. It is the reference variable
    that's type changed; the type of the object itself does not change.


Dynamic Binding
---------------



For next time
=============

* Go back and read Chapter 3 Section 3
    * 3 pages