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

* A queue is great and all, but there are variations in real life we are probably aware of
* One that comes to my mind is a *priority queue*
* Think of triage at a hospital
* Sure, it's kinda' first-come-first-serve
* But if you are there for a cut thumb and someone comes in with an arrow sticking out of their knee, they will likely be helped first
* In other words, it's first-come-first-serve, but those with a priority value deemed more important will be jump the line

What
^^^^

* Think about how we could describe the *what* of a priority queue
* Everything would be the same except ``dequeue``
* We would need to get the element with the most important priority of all those in the queue
    * If there is a tie, then use first-come-first-serve to break the tie

How
^^^

* Now think about how this could be implemented
* We have a decision to make

* We can make it that every ``enqueue`` inserts something into the queue such that the queue is ordered based on priority and time of arrival
    * If we do a linear search to find the right place to insert, this would be :math:`O(n)`
* Then our ``dequeue`` would be a simple :math:`O(1)` operation since it's just removing the front of the queue

* Or, we could make it that every ``enqueue`` just adds the thing to the end of the queue
    * :math:`O(1)`
* Then our ``dequeue`` would need to do the search through the queue to find the thing with the most important priority
    * If we use a linear search, then this is :math:`O(n)`

* Which implementation is better?

For next time
=============

* Download and play with the :download:`LinkedQueue <../main/java/LinkedQueue.java>` code
* Download and run the :download:`LinkedQueueTest <../test/java/LinkedQueueTest.java>` tests
* Read Chapter 5 Section 6
    * 6 pages