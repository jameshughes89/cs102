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
    * ``Iterable`` --- used when creating some collection that we want to be iterable


Iterator Interface
------------------

* Iterator objects are typically very simple
* To define our own iterator, we will make a class that ``implements Iterator<T>``
    * Uses the `Iterator interface <https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Iterator.html>`_

* There are four abstract methods included in the interface, two of which we will focus on:
    * ``T next()`` --- retrieve the next element
    * ``boolean hasNext()`` --- tells us if there exists another element

* In the end, if we use an iterator, we do not care what the underlying container is for the data since, no matter what it is, we get each element with ``next`` and check if there are more elements with ``hasNext``


* For example, here is an example of using an iterator to iterate over an arbitrary collection of things of type ``T``

.. code-block:: Java
    :linenos:

    Iterator<T> it = new arbitraryCollection.iterator();

    while (it.hasNext()) {
        process(it.next());
    }


Array Iterator
--------------


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

* Read Chapter 7
    * 12 pages
