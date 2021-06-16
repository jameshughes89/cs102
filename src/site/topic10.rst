***************************
Topic #10 --- The Queue ADT
***************************

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

    If you look at `Java's Queue Interface <https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html>`_, you will
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
