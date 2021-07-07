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


Iterator Interface
------------------


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


Collection Iterators
====================


toString
--------


Iterable
========


For Each
--------


For next time
=============

* Download the :download:`ArrayIterator <../src/main/java/ArrayIterator.java>`.
* Read Chapter 7
    * 12 pages
