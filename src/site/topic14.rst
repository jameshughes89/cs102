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


Object
======

* The class ``Object`` is the root of the hierarchy
* Every class you make will inherit from the ``Object`` class
    * This is done automatically, so you do not ``extend`` it explicitly

* Since we inherit everything from the superclasses we inherit from, this means that we get all methods from the ``Object`` class without having to write them ourselves
    * Although, we almost always override them if were using them
* We have seen and used a few of these already
    * ``equals``
    * ``toString``

* However, we ended up *overriding* these methods a bunch of times
    * We inherited them, but we wrote our own implementations for our needs

* The inherited behaviour of ``equals`` checks if the references are to the same exact object
    * ``x.equals(y)`` checks if ``x`` and ``y`` are the same object (same as ``x == y``)

* The inherited behaviour of ``toString`` is to return a string of the object's class name + @ + the has code of the object

* If we do not override these methods in our classes, we can still use them, but get the default behaviour


For next time
=============

* Go back and read Chapter 3 Section 3
    * 3 pages