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
        someMethod(someArray[i]);
    }


* However, not everything we may want to iterate over is an array, and trying to use the for loop with a linked structure won't work quite as nicely

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
