************************
Topic #12 --- ArrayQueue
************************

Idea #1
=======

* Use an array for the container
* Keep track of the ``front`` by simply having it always be index ``0``
* Keep track of the ``rear`` index
* Size will conveniently be ``rear``

.. image:: img/arrayqueue_1idea0.png
   :width: 500 px
   :align: center

* All adding happens at the ``rear`` end
* Add the element to index ``rear``
* Increment ``rear``

.. image:: img/arrayqueue_1idea1.png
   :width: 500 px
   :align: center

* ``dequeue`` always happens at index ``0``
* Requires that elements are shuffled down ``1`` index
* Decrement ``rear``

.. image:: img/arrayqueue_1idea2.png
   :width: 500 px
   :align: center

Discussion
----------

* Will this implementation work?
    * Is it *correct*
* Knowing that this is an array implementation, will we ever need to call ``expandCapacity``?
* What is the computational complexity of this ``enqueue``?
* What is the computational complexity of this ``dequeue``?


Idea #2
=======

Idea #3
=======

Implementing a Queue --- Array Container
========================================


For next time
=============

* Read Chapter 5 Section 7
    * 7 pages
