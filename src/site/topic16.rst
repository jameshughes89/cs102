***********************
Topic #16 --- Iterators
***********************

* Often we need to access every element in some *thing*
    * like an array, ``Stack``, ``Queue``, or ``Bag``
* We call this *iterating* over the things

* We've done this countless times already with something like an array

.. code-block:: Java
    :linenos:

    for(int i = 0; i < someArray.length; ++i) {
        process(someArray[i]);
    }


* However, not everything we may want to iterate over is an array, and trying to use the for loop with a linked structure won't work quite as nicely
    * Typically you'd see a ``while`` loop

.. code-block:: Java
    :linenos:

    while(currentNode.getNext() != null) {
        process(currentNode.getData());
        currentNode = currentNode.getNext();
    }

* The good news is, Java provides us with a common, uniform way to iterate over something
* It is also independent of the implementation of the thing we want to iterate over


Iterators
=========

* Iterators are objects that allow us to *iterate* over a collection, one element at a time
    * Get each element in an array
    * Get all the elements from a bag

* There are two important interfaces:
    * ``Iterator`` --- used when creating an iterator object
    * ``Iterable`` --- used when creating something we may want to iterate over


Iterator Interface
------------------

* Iterator objects are typically very simple
* To define our own iterator, we will make a class that ``implements Iterator<T>``
    * Uses the `Iterator interface <https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Iterator.html>`_

* There are two abstract methods included in the interface which we will focus on:
    * ``T next()`` --- retrieve the next element
    * ``boolean hasNext()`` --- tells us if there exists another element

* In the end, if we use an iterator, we do not care what the underlying container is for the data since, no matter what it is, we get each element with ``next`` and check if there are more elements with ``hasNext``


* For example, here is an example of using an iterator to iterate over an arbitrary iterable thing of type ``T``

.. code-block:: Java
    :linenos:

    Iterator<T> it = arbitraryIterableThing.iterator();

    while (it.hasNext()) {
        process(it.next());
    }


Array Iterator
--------------

* I do not need to know what kind of underlying container there is for the data to use the iterator
* However, if I am making my own collection, I will need to create an iterator for that collection and the underlying container

* If the collection we are making is using an array, such as the ``ArrayStack``, we will make an iterator for an array
    * :download:`ArrayIterator <../src/main/java/ArrayIterator.java>`

.. code-block:: Java
    :linenos:

    import java.util.Iterator;
    import java.util.NoSuchElementException;

    public class ArrayIterator<T> implements Iterator<T> {

        private final int size;
        private int currentIndex;
        private final T[] items;

* The fields only include
    * Size (how many things are in the collection)
    * The current index, which corresponds to which index the ``next`` element to be returned is in
    * A reference to the array holding the data

.. code-block:: Java
    :linenos:

        public ArrayIterator(T[] items, int size) {
            this.items = items;
            this.size = size;
            this.currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

* The easiest way to know if there is anything left in the collection to iterate over is to see if the current index is less than the number of things in the collection

.. code-block:: Java
    :linenos:

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T returnElement = items[currentIndex];
            currentIndex++;
            return returnElement;
        }
    }

* The way this is written, if we try to access the ``next`` thing when there are no more things, then we will throw an exception
* Otherwise, update the ``currentIndex`` and return the element

* Important things to note here:
    * This iterator can only go in one direction
    * Once the iterator object gets to the end of the collection, it does **not** reset
    * If we want to iterate over the collection again, we create a new iterator


Linked Iterator
---------------

* Similarly, if we want to make an iterator for a collection that has a linked structure for the underlying container, then we make a :download:`LinkedIterator <../src/main/java/LinkedIterator.java>`

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

* If we create a ``SortedBag` with an array, our ``ArraySortedBag``'s ``iterator`` method would need to return an ``ArrayIterator``

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
            Iterator<Integer> it = this.iterator();
            while(it.hasNext()) {
                builder.append(it.next());
                builder.append(", ");
            }
            return builder.toString();
        }

* Just by looking at this, you can't tell me if this is an ``ArrayIterator`` or a ``LinkedIterator``


Iterable
========


For Each
--------


For next time
=============

* Download the :download:`ArrayIterator <../src/main/java/ArrayIterator.java>`.
* Read Chapter 7
    * 12 pages
