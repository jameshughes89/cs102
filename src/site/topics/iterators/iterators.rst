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

    * Instead, this is typically done with a ``while`` loop


.. code-block:: Java
    :linenos:

    while (currentNode != null) {
        process(currentNode.getData());
        currentNode = currentNode.getNext();
    }


Iterators
=========

* Java provides a common uniform way to iterate over *things*
* Iterators are objects that allow *iterating* over a collection, one element at a time

    * Get each element in an array
    * Get each element from a ``Bag``


* There are two important relevant interfaces:

    * ``Iterator`` --- used when creating an iterator object
    * ``Iterable`` --- used when creating something one may want to iterate over



Iterator Interface
------------------

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
^^^^^^^^^^^^^^

* Although it is not required to know what the underlying container is when using the iterator
* It is required to define an iterator for the underlying container
* For example, if defining a collection that makes use of an array, an ``ArrayIterator`` will need to be defined


.. literalinclude:: /../main/java/ArrayIterator.java
    :language: java
    :lineno-match:
    :lines: 1-8


* The fields only include

    * ``size`` --- number of elements in the collection
    * ``elements`` --- the array of elements to iterate over
    * ``index`` --- the current index the iterator is at


.. literalinclude:: /../main/java/ArrayIterator.java
    :language: java
    :lineno-match:
    :lines: 10-17


* Constructor sets the iterator up to start at the beginning of the array


.. literalinclude:: /../main/java/ArrayIterator.java
    :language: java
    :lineno-match:
    :lines: 19-22


* ``hasNext`` returns a ``boolean`` indicating if there is an element to retrieve
* Simply check if the current index (``index``) is less than the number of elements in the array (``size``)


.. literalinclude:: /../main/java/ArrayIterator.java
    :language: java
    :lineno-match:
    :lines: 24-32


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

    Consider that the ``ArrayIterator`` has reference to the underlying array contained. Generally, iterators should not
    modify the collections they are iterating over. Side effects like this are a recipe for disaster.



Linked Iterator
---------------

* Similarly, if we want to make an iterator for a collection that has a linked structure for the underlying container, then we make a :download:`LinkedIterator </../main/java/LinkedIterator.java>`

.. code-block:: Java
    :linenos:

    import java.util.Iterator;
    import java.util.NoSuchElementException;

    public class LinkedIterator<T> implements Iterator<T> {

        Node<T> current;

        public LinkedIterator(Node<T> head) {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

* For the `LinkedIterator`, all we need is a reference to the current node
* If the current is not null, then there is a next element to be returned

.. code-block:: Java
    :linenos:

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T returnElement = current.getData();
            current = current.getNext();
            return returnElement;
        }
    }

* If there is no next, throw an exception
* Otherwise, move the node reference to the next node and return the data

* Just like the ``ArrayIterator``
    * The iterator only goes in one direction
    * Once we get an element with ``next()``, we can't go back unless we start with a new iterator

.. warning::

    If you made your ``Node`` class an internal class, then you will need to make your ``LinkedIterator`` internal too.


Collection Iterators
====================

* If we create a ``SortedBag`` with an array, our ``ArraySortedBag``'s ``iterator`` method would need to return an ``ArrayIterator``

.. code-block:: Java
    :linenos:

        @Override
        public Iterator<T> iterator() {
            return new ArrayIterator<>(bag, rear);
        }


* Similarly, a ``LinkedSortedBag`` would need to return a ``LinkedIterator``

.. code-block:: Java
    :linenos:

        @Override
        public Iterator<T> iterator() {
            return new LinkedIterator<>(head);
        }


* Since both versions of the ``SortedBag`` return an ``Iterator``, and to use an ``Iterator`` I don't really care if it's an array or linked one, I can use it like this

.. code-block:: Java
    :linenos:

        Iterator<Integer> it = myBag.iterator();

        while (it.hasNext()) {
            process(it.next());
        }


* In the end, what the implementation of ``SortedBag`` I have does not impact my ability to get an iterator and use it


toString
--------

* Here is an example of using an iterator for the ``toString`` within a ``SortedBag`` implementation

.. code-block:: Java
    :linenos:

        public String toString() {
            StringBuilder builder = new StringBuilder();
            Iterator<T> it = this.iterator();
            while(it.hasNext()) {
                builder.append(it.next());
                builder.append(", ");
            }
            return builder.toString();
        }

* Just by looking at this, you can't tell me if this is an ``ArrayIterator`` or a ``LinkedIterator``
    * This is a fantastic example of *abstraction*
    * I can now iterate over something (what) without needing to worry about the implementation details (how)


Iterable
========

* The ``Iterator`` interface is used for creating an iterator object to iterate over something
* If we are making a class that we want to be able to iterate over, we will have that class ``implement Iterable<T>``
    * For example, asking our collection for an iterator
        * ``myBag.iterator()``

* When looking at the `Iterable interface <https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Iterable.html>`_, you will find one abstract method --- ``iterator()``
* If we correctly implement the ``Iterable`` interface, we can guarantee that our class is in fact iterable


For Each
--------

* For things that are iterable, we can make use of the *enhanced* for loop --- for each loop

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

* Revisiting the ``toString()`` example from above, we can alter it further


.. code-block:: Java
    :linenos:

        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (T bagElement : this) {     // 'this' is the iterable thing
                builder.append(bagElement);
                builder.append(", ");
            }
            return builder.toString();
        }



For next time
=============

* Download the :download:`ArrayIterator </../main/java/ArrayIterator.java>` and its :download:`tests </../test/java/ArrayIteratorTest.java>`.
* Download the :download:`LinkedIterator </../main/java/LinkedIterator.java>` and its :download:`tests </../test/java/LinkedIteratorTest.java>`.
* Read Chapter 7
    * 12 pages
