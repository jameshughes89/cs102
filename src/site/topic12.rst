************************
Topic #12 --- ArrayQueue
************************

* We need to think of:
    * A container
    * A way to keep track of the front/head
    * A way to keep track of the rear/tail
    * A way to keep track of the size

* We used a linked structure last time
* Let's now use an array...
* But how...


Idea #1
=======

Idea #2
=======

* Use an array for the container
* Keep track of the ``front`` index
* Keep track of the ``rear`` index
* Size will conveniently be ``rear - front``

.. image:: img/arrayqueue_2idea0.png
   :width: 500 px
   :align: center

* All adding happens at the ``rear`` end
* Add the element to index ``rear``
* Increment ``rear``

.. image:: img/arrayqueue_2idea1.png
   :width: 500 px
   :align: center

* ``dequeue`` always happens at index ``front````
* Increment ``front``


.. image:: img/arrayqueue_2idea2.png
   :width: 500 px
   :align: center

Discussion
----------

* Will this implementation work?
    * Is it *correct*
* Will we ever need to call ``expandCapacity``?
* What is the computational complexity of this ``enqueue``?
* What is the computational complexity of this ``dequeue``?
* How often will we call ``expandCapacity`` relative to idea #1?
* What drawback do you see?


Idea #3
=======

Implementing a Queue --- Array Container
========================================


For next time
=============

* Read Chapter 5 Section 7
    * 7 pages
