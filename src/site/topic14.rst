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


Collections Example
===================

.. image:: img/inheritance_collections.png
   :width: 500 px
   :align: center
   :target: https://en.wikipedia.org/wiki/Java_collections_framework

* This is a visualization of part of Java's collections' class hierarchy

Abstract Class
--------------

* You will notice that there is an *Abstract Class* designation
* An abstract class is one that
    * Is declared with the ``abstract`` keyword
    * May or may not include abstract methods
        * Methods declared, but with no implementation, like interfaces
    * May **not** be instantiated
    * May be subclassed/inherited from

* An abstract class may include some concrete implementation of methods that will be the same among multiple subclasses

* `Take Java's AbstractQueue class <https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/AbstractQueue.html>`_ and its subclass, `PriorityQueue <https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/AbstractQueue.html>`_

* The ``AbstractQueue`` has a few important concrete methods implemented within the abstract class (it also inherits a bunch from superclasses too)
    * ``add``
    * ``addAll``
    * ``clear``
    * ``element``
    * ``remove``

* The ``PriorityQueue`` class, which ``extends AbstractQueue``, makes direct use of a few of these methods
    * ``addAll``
    * ``element``
    * ``remove``

* But the ``PriorityQueue`` also overrides a few of the methods from ``AbstractQueue`` since it needs a specific implementation
    * ``add``
    * ``clear``

* If you open the ``PriorityQueue.java`` file
    * You will not find ``addAll``, ``element``, or ``removed`` within it since it is inherited
    * You will find the overridden methods (``add`` and ``clear``)


For next time
=============

* Check out the `JDK specification links <https://docs.oracle.com/en/java/javase/11/docs/api/index.html>`_ provided
* Go back and read Chapter 3 Section 3
    * 3 pages