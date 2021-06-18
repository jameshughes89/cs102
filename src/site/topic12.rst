************************
Topic #12 --- ArrayQueue
************************

Idea #1
=======

Idea #2
=======

Idea #3
=======

* An array for the container
* Keep track of the ``front`` index
* Keep track of the ``rear`` index
* If there is space at the front of the array, loop the indices back to ``0`` once we hit the end

"Circular Array"
----------------

* We can *pretend* our array is a circle
    * It's still a linear array, but that's OK

* For example, pretend we have an array with a capacity of ``n``
* The indices order would be

    ``0, 1, 2, 3, 4, ..., n-2, n-1, 0, 1, 2, 3, 4, ..., n-2, n-1, 0, 1, 2, 3, 4, ...``

* The index that comes before ``n-1`` is ``n-2``
* The index that comes after ``n-1`` is ``0``
* The index that comes before ``0`` is ``n-1``
* The index that comes after ``0`` is ``1``

* Take this "circular array" with 7 things in it

.. image:: img/arrayqueue_circle0.png
   :width: 500 px
   :align: center

* If we ``dequeue`` 5 times, we end up with this

.. image:: img/arrayqueue_circle1.png
   :width: 500 px
   :align: center

* And after 8 more ``enqueues`` we have this

.. image:: img/arrayqueue_circle2.png
   :width: 500 px
   :align: center


* With this idea, we can think of our idea #3 implementation as this

.. image:: img/arrayqueue_2idea0.png
   :width: 500 px
   :align: center

* After a bunch of ``enqueues`` and ``dequeues`` it will loop around like this

.. image:: img/arrayqueue_2idea1.png
   :width: 500 px
   :align: center

* Here is the same scenario, but with the array shown as a linear array

.. image:: img/arrayqueue_2idea2.png
   :width: 500 px
   :align: center


Implementing a Queue --- Array Container
========================================


For next time
=============

* Read Chapter 5 Section 7
    * 7 pages
