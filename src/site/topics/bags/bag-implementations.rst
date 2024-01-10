*******************
Bag Implementations
*******************

* Given the definition of a ``Bag``
* And given the definitions of the specialized bags

    * ``IndexedBag``
    * ``SortedBag``


* How can they be implemented?



Array Implementation Idea
=========================

.. figure:: array_bag.png
    :width: 500 px
    :align: center

    A representation of how a ``Bag`` could be implemented with an array.


* The idea will be similar to the ``Stack`` and ``Queue`` array based implementations
* Unlike a ``Queue``, the front will always be at index 0

    * With bags, adding and removing can happen anywhere
    * Adding to the middle would require a linear time operation to make room
    * Removing from the middle would require a linear time operation to eliminate the gap


* An ``expandCapacity`` will be required

    * The simpler version though since the front is always index 0


* The functionality of a ``Bag``, regardless of what specific version it is

    * ``boolean add(T element)``
    * ``boolean remove(T element)``
    * ``boolean contains(T element)``
    * ``int count(T element)``
    * ``boolean isEmpty()``
    * ``int size()``
    * ``Iterator<T> iterator()``



ArrayIndexedBag
===============

* In addition to the functionality of the ``Bag``, an ``IndexedBag`` must also be able to

    * ``boolean add(int index, T element)``
    * ``T remove(int index)``
    * ``T set(int index, T element)``
    * ``T get(int index)``
    * ``int indexOf(T element)``


.. note::

    For brevity, only a subset of methods are included below. See the
    :download:`ArrayIndexedBag </../main/java/ArrayIndexedBag.java>` class for the full implementation.


.. literalinclude:: /../main/java/ArrayIndexedBag.java
    :language: java
    :lineno-match:
    :start-after: // [start-class_fields_constructor]
    :end-before: // [end-class_fields_constructor]


* Note the import of ``Iterator`` and the implementation of ``Iterator<T>``

    * Iterators are used for *iterating* over a collection
    * More on this later



Private Methods
---------------

.. literalinclude:: /../main/java/ArrayIndexedBag.java
    :language: java
    :lineno-match:
    :start-after: // [start-shiftLeft_shiftRight]
    :end-before: // [end-shiftLeft_shiftRight]


* ``shiftLeft`` and ``shiftRight``

    * These move elements up or down the array to make or eliminate room for adding and removing elements



Iterator Method
---------------

.. warning::

    Iterators are the focus of another topic, so they are only briefly presented here.


* Iterators are used to provide a common way to iterator over a collection, regardless of the underlying container

    * Array vs. linked structure


.. literalinclude:: /../main/java/ArrayIndexedBag.java
    :language: java
    :lineno-match:
    :start-after: // [start-iterator]
    :end-before: // [end-iterator]


* All this method does is create an instance of an ``ArrayIterator`` and return it
* What the ``ArrayIterator`` class looks like is discussed later in the course


Add Methods
-----------

.. literalinclude:: /../main/java/ArrayIndexedBag.java
    :language: java
    :lineno-match:
    :start-after: // [start-add]
    :end-before: // [end-add]


* Note that ``add(T element)`` simply delegates to ``add(int index, T element)`` for ease and code/logic reuse
* Unlike the methods for adding to a ``Stack`` or ``Queue``, this method may throw an exception

    * The exception is thrown if the specified index is out of bounds


* Like the ``Stack`` and ``Queue``, the array may run out of space
* Unlike before, an ``expandCapacity`` method is not included
* Instead, the ``copyOf`` function from the ``Arrays`` class is used

    * It creates a new array with the specified capacity containing a copy of the elements in the original array


* The ``shiftRight`` private method is used to make room for the element to be added



Remove
------

.. literalinclude:: /../main/java/ArrayIndexedBag.java
    :language: java
    :lineno-match:
    :start-after: // [start-remove]
    :end-before: // [end-remove]


* The ``remove(T element)`` method delegates to the ``remove(int index)`` for ease and code/logic reuse
* Note that ``indexOf`` will throw an exception if the element does not exist within the bag 


ArraySortedBag
==============

* In addition to the functionality of the ``Bag``, a ``SortedBag`` must also be able to

    * ``T removeFirst()``
    * ``T removeLast()``
    * ``T first()``
    * ``T last()``


* Further, the overloaded ``add`` and ``remove`` methods must preserve the ordering of the elements

.. note::

    For brevity, only a subset of methods are included below. See the
    :download:`ArrayIndexedBag </../main/java/ArraySortedBag.java>` class for the full implementation.


.. literalinclude:: /../main/java/ArraySortedBag.java
    :language: java
    :lineno-match:
    :emphasize-lines: 7
    :start-after: // [start-class_fields_constructor]
    :end-before: // [end-class_fields_constructor]


* Notice ``<T extends Comparable<? super T>>``
* There is a little bit to unpack here

* First, when something extends `Comparable <https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Comparable.html>`_, it means that the type has some defined ordering

    * The method ``compareTo`` is implemented for the type


* If ``x.compareTo(y)`` is called

    * Return a negative integer if ``x < y``
    * Return zero if ``x == y``
    * Return a positive integer if ``x > y``


* When something extends ``Comparable<T>``, that means ``this`` can be compared to some type ``T``

    * ``this`` can be compared to things of type ``T``, but not the other way around


* ``T extends Comparable<T>`` means that the type ``T`` can be compared to things of type ``T`` to provide some defined ordering

    * Which is needed, if the elements are to be sorted


* Finally, ``<T extends Comparable<? super T>>`` means that ``T`` can be compared to something of type ``T`` or a superclass of ``T``

    * ``?`` is a *wildcard*


* Thus, this means that ``T`` must have a defined ordering for itself through either

    * A direct implementation of ``compareTo``
    * Inheritance



Adding Method
-------------

.. literalinclude:: /../main/java/ArraySortedBag.java
    :language: java
    :lineno-match:
    :emphasize-lines: 6
    :start-after: // [start-add]
    :end-before: // [end-add]



* The ``add`` method makes use of a private method ``findInsertIndex``
* ``findInsertIndex`` makes use of the class' iterator method to iterate over the collection

    * It is simply used to perform a linear search


* It also makes use of the ``compareTo`` method
* Remember, the elements themselves determine the ordering

    * One does not know what the type ``T`` is, so how can they be compared?

        * *If* they're numbers, ``<``, ``>``, ``==``, would work
        * But what if sorting strings? Colours?


* Since ``T`` must have a ``compareTo`` implemented, it can be used to guarantee a proper ordering, regardless of the type

    * ``T`` must have a ``compareTo`` since it must extend ``Comparable<? super T>``



* Given this, the loop executes until it finds the index where the element to be inserted is less than the current element in the collection

    * Or, in other words, it loops while

        * There are more elements in the collection
        * The thing to be inserted belongs after the current element in the collection



Linked Implementation
=====================

.. figure:: linked_bag.png
    :width: 500 px
    :align: center

    A representation of how a ``Bag`` could be implemented with a linked structure.


* Although not discussed here, a linked implementation of the bags could also be written
* :doc:`Reviewing the different types of insertions and removals from a linked structure would help </topics/linked-structures/linked-structures>`


For Next Time
=============

.. note::

    Note that there are better implementations of these data structures. One will be discussed later in the course.


* Read Chapter 6 Sections 6 & 7

    * 17 pages


Playing Code
------------

* Download and play with

    * :download:`ArrayIndexedBag </../main/java/ArrayIndexedBag.java>`
    * :download:`ArraySortedBag </../main/java/ArraySortedBag.java>`
    * :download:`ArrayIndexedBagTest </../test/java/ArrayIndexedBagTest.java>`
    * :download:`ArraySortedBagTest </../test/java/ArraySortedBagTest.java>`

