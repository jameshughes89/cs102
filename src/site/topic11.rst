*************************
Topic #11 --- LinkedQueue
*************************

* Now that we have an idea of what the Queue is, we need to think of how to implement it
    * Remember, the *what* and the *how* are separated

* We need to think of:
    * A container
    * A way to keep track of the front/head
    * A way to keep track of the rear/tail
    * A way to keep track of the size

Implementing a Queue --- Linked Container
=========================================

.. image:: img/linkedqueue0.png
   :width: 500 px
   :align: center

* Enqueuing happens at the rear
* Notice that the rear reference is updated to the newly added (enqueued) thing

.. image:: img/linkedqueue1.png
   :width: 500 px
   :align: center

* Dequeuing happens at the front
* Again, notice how the front reference must be updated to the successor node of the thing being removed (dequeued)

.. image:: img/linkedqueue2.png
   :width: 500 px
   :align: center


Edge Cases
----------

* What if the queue is empty?
* What if the queue only has one element in it?


Enqueue
-------


Dequeue
-------


Variations
==========

* We can define any variation we could want

Priority Queue
--------------



For next time
=============

* Read Chapter 5 Section 6
    * 6 pages