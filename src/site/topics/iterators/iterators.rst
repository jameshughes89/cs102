*********
Iterators
*********

* It is often necessary to access every element in some *thing*

    * Like an array, ``Stack``, ``Queue``, or ``Bag``


* This is called *iterating* over the *things*
* This has already been done countless times with arrays

.. code-block:: Java
    :linenos:

    for (int i = 0; i < someArray.length; i++) {
        process(someArray[i]);
    }


* However, not everything one may want to iterate over is an array
* Trying to use a ``for`` loop for iterating over a linked structure doesn't work as nicely
* Instead, a ``while`` loop is typically used


.. code-block:: Java
    :linenos:

    while (currentNode != null) {
        process(currentNode.getData());
        currentNode = currentNode.getNext();
    }


Iterators
=========

* Java provides a common uniform way to iterate over *things*
* Iterators are objects that allow *iterating* over something one element at a time

    * Get each element in an array
    * Get each element from a ``Bag``


* There are two important relevant interfaces:

    * ``Iterator`` --- used when creating an iterator object
    * ``Iterable`` --- used when creating something one may want to iterate over



Iterator Interface
==================

* Iterator objects are typically very simple
* To define an iterator for a class, define the class such that it ``implements Iterator<T>``

    * Uses the `Iterator interface <https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Iterator.html>`_


* There are two abstract methods included in the interface to focus on

    * ``T next()`` --- retrieve the next element
    * ``boolean hasNext()`` --- checks if another element exists


* With these, it becomes possible to iterate over elements without needing to worry about the underlying container

.. code-block:: Java
    :linenos:

    Iterator<T> iterator = arbitraryIterableThing.iterator();

    while (iterator.hasNext()) {
        process(iterator.next());
    }


Array Iterator
--------------

* Although it is not required to know what the underlying container is when using the iterator
* It is required to define an iterator for the underlying container
* For example, if defining a collection that makes use of an array, an ``ArrayIterator`` will need to be defined


.. literalinclude:: /../main/java/ArrayIterator.java
    :language: java
    :lineno-match:
    :start-after: // [start-class_fields]
    :end-before: // [end-class_fields]


* The fields only include

    * ``size`` --- number of elements in the collection
    * ``elements`` --- the array of elements to iterate over
    * ``index`` --- the current index the iterator is at


.. literalinclude:: /../main/java/ArrayIterator.java
    :language: java
    :lineno-match:
    :start-after: // [start-constructor]
    :end-before: // [end-constructor]


* Constructor sets the iterator up to start at the beginning of the array


.. literalinclude:: /../main/java/ArrayIterator.java
    :language: java
    :lineno-match:
    :start-after: // [start-hasNext]
    :end-before: // [end-hasNext]


* ``hasNext`` returns a ``boolean`` indicating if there is an element to retrieve
* Simply check if the current index (``index``) is less than the number of elements in the array (``size``)


.. literalinclude:: /../main/java/ArrayIterator.java
    :language: java
    :lineno-match:
    :start-after: // [start-next]
    :end-before: // [end-next]


* ``next`` returns the next element and updates ``index``

    * It returns the element and sets the iterator up to return the subsequent element when needed


* The way this is written, if ``next`` is called when there are no more elements to retrieve, an exception is thrown


* Notice that

    * This iterator can only go in one direction
    * Once the iterator object hits the end of the collection, it does **not** reset
    * To start iterating again, a new iterator would need to be created


.. note::

    There is nothing preventing someone from writing an iterator class that returns the element in some other order. For
    example, reverse order.


.. warning::

    Consider that the ``ArrayIterator`` has reference to the underlying array container. Generally, iterators should not
    modify the collections they are iterating over. Side effects like this are a recipe for disaster.



Linked Iterator
---------------


.. literalinclude:: /../main/java/LinkedIterator.java
    :language: java
    :lineno-match:


* For the ``LinkedIterator``, all that is needed is a reference to the current node
* The constructor sets the current node to reference the head of the linked structure
* ``hasNext`` just checks if ``current`` references ``null``
* ``next`` returns the next element and sets the iterator up to return the subsequent element when needed

* Just like the ``ArrayIterator``

    * The iterator only goes in one direction
    * Once an element is retrieved with ``next()``, it is not possible to retrieve it again unless creating a new iterator


.. warning::

    If the ``Node`` class is an internal class, then the ``LinkedIterator`` will need to be internal too.



Collection Iterators
--------------------

* Consider a ``SortedBag``
* If using an ``ArraySortedBag`` implementation, the ``iterator`` method would need to return an ``ArrayIterator``


    .. code-block:: Java
        :linenos:

            @Override
            public Iterator<T> iterator() {
                return new ArrayIterator<>(bag, size());
            }


* Similarly, the ``iterator`` method for a ``LinkedSortedBag`` would need to return a ``LinkedIterator``

    .. code-block:: Java
        :linenos:

            @Override
            public Iterator<T> iterator() {
                return new LinkedIterator<>(head);
            }


* Since both versions of the ``SortedBag`` return an ``Iterator``
* And since the iterator provides a common way to iterate over the container
* It is possible to iterate over an array and linked structure the exact same way

.. code-block:: Java
    :linenos:

        Iterator<Integer> iterator = myBag.iterator();

        while (iterator.hasNext()) {
            process(iterator.next());
        }


* In the end, the actual underlying container has no impact on the code used to iterate


toString
^^^^^^^^

* Consider the following ``toString`` for some collection

.. code-block:: Java
    :linenos:

        public String toString() {
            StringBuilder builder = new StringBuilder();
            Iterator<T> iterator = this.iterator();
            while(iterator.hasNext()) {
                builder.append(iterator.next());
                builder.append(", ");
            }
            return builder.toString();
        }


* By looking at the above code, it is not possible to know if this is for an array or linked implementation

    * This is a fantastic example of *abstraction*
    * It is possible to iterate over something (what) without needing to worry about the implementation details (how)



Iterable Interface
==================

* The ``Iterator`` interface is used for creating an iterator object to iterate over something
* If making a class that is to be iterated over, then that class will ``implement Iterable<T>``

    * For example, asking the collection for an iterator

        * ``myBag.iterator()``


* Within the `Iterable interface <https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Iterable.html>`_ there is one abstract method --- ``iterator()``
* If this interface is implemented correctly, the collection is guaranteed to be iterable


For Each
--------

* For things that are iterable, *enhanced* for loop can be used --- for each loop
* In general, it looks like this

.. code-block:: Java
    :linenos:

    for (type refVar: iterableThing) {
        process(refVar);
    }


* An example for our ``SortedBag<Integer>`` may look like this

.. code-block:: Java
    :linenos:

    for (Integer x: myBag) {
        process(x);
    }


* Revisiting the ``toString()`` example from above with an enhanced for loop

.. code-block:: Java
    :linenos:

        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (T element : this) {     // 'this' is the iterable thing
                builder.append(element);
                builder.append(", ");
            }
            return builder.toString();
        }


.. note::

    The enhanced for loop is just syntactic sugar for what was already shown above. The enhanced for loop example

        .. code-block:: Java
            :linenos:

            for (Integer x: myBag) {
                process(x);
            }


    means the same thing as

        .. code-block:: Java
            :linenos:

            Iterator<Integer> iterator = myBag.iterator();
            while (iterator.hasNext()) {
                process(iterator.next());
            }



Equality of Stacks (and Queues)
===============================

* Consider the ``equals`` methods from :download:`ArrayStack </../main/java/ArrayStack.java>` and :download:`LinkedStack </../main/java/LinkedStack.java>`

.. literalinclude:: /../main/java/ArrayStack.java
    :language: java
    :lineno-match:
    :start-after: // [start-equals_hashCode]
    :end-before: // [end-equals_hashCode]


.. literalinclude:: /../main/java/LinkedStack.java
    :language: java
    :lineno-match:
    :start-after: // [start-equals_hashCode]
    :end-before: // [end-equals_hashCode]


* It should be possible to check equality between ``Stack`` objects, regardless of their implementation
* However, with the current implementation, it's not possible to compare an ``ArrayStack`` and ``LinkedStack``

* A solution to this problem is to make ``Stacks`` implement ``iterable``
* If this is done, there is a common way to iterate over the ``Stack`` independent of the underlying implementation


.. code-block:: Java
    :linenos:

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Stack)) {
            return false;
        }
        Stack<?> that = (Stack<?>) o;
        if (this.size() != that.size()) {
            return false;
        }
        Iterator<T> thisIterator = this.iterator();
        Iterator<?> thatIterator = that.iterator();
        while (thisIterator.hasNext()) {
            if (!Objects.equals(thisIterator.next(), thatIterator.next())) {
                return false;
            }
        }
        return true;
    }



For Next Time
=============

* Consider how the ``Stack`` and ``Queue`` could be made iterable 
* Read Chapter 7

    * 12 pages


Playing Code
------------

* Download and play with

    * :download:`ArrayIterator </../main/java/ArrayIterator.java>`
    * :download:`ArrayIteratorTest </../test/java/ArrayIteratorTest.java>`
    * :download:`LinkedIterator </../main/java/LinkedIterator.java>`
    * :download:`LinkedIteratorTest </../test/java/LinkedIteratorTest.java>`

