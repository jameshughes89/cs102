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


toString
--------


Iterable
========


For Each
--------


For next time
=============

* Read Chapter 7
    * 12 pages
