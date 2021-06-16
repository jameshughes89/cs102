***************************
Topic #10 --- The Queue ADT
***************************

* Queues are a collection of elements where
    * Things are added to one end (rear or tail)
    * Things are removed from the other end (front or head)

* This is *First in First out* (FIFO)

* Given this, the **F**\ irst thing **I**\ n will be the **F**\ irst thing **O**\ ut
    * FIFO

* For example, any ordinary single file line you have ever lined up in
    * Assuming people were following the rules and not cutting in line

.. image:: img/queue.png
   :width: 500 px
   :align: center

**Adding to a Queue**

.. image:: img/queue_add.png
   :width: 500 px
   :align: center

**Removing from a Queue**

.. image:: img/queue_remove.png
   :width: 500 px
   :align: center


Queue Operations
================

* Like other collections, we need ways to
    * Add something to the collection
    * Remove something from the collection
    * Look at something, but do not remove it

* Within the context of a queue, we have
    * **Enqueue**
        * Add something to the rear/tail
    * **Dequeue**
        * Remove something from the front/head
    * **First**
        * Look at the thing at the front/head of the queue, but do not remove it

* We will also want our ``isEmpty``, ``size``, and ``toString``

.. warning::

    If you look at `Java's Queue Interface <https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Queue.html>`_, you will
    see that they use ``add``, ``remove``, and ``element`` along with ``offer``, ``poll``, and ``peek``. The first three
    are the same as our ``enqueue``, ``dequeue``, and ``first`` and the other three are the same, but do not throw
    exceptions.

    We will use the ``enqueue``, ``dequeue``, and ``first`` names as it is what they are `typically called when referring
    to a Queue ADT <https://en.wikipedia.org/wiki/Queue_(abstract_data_type)>`_.


Example Uses
============


Interface
=========

For next time
=============

* Read Chapter 5 Sections 1 -- 5
    * 14 pages
