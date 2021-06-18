************************
Topic #12 --- ArrayQueue
************************

Idea #1
=======

Idea #2
=======

Idea #3
=======


Expand Capacity
---------------

.. image:: img/arrayqueue_expand0.png
   :width: 500 px
   :align: center

* Suppose we ``enqueue`` one more element

.. image:: img/arrayqueue_expand1.png
   :width: 500 px
   :align: center

* Now the queue is full
    * ``size == queue.length``

* If we ``enqueue`` again, we'll need to call ``expandCapacity``
* **However** we can't just double the size of the array and copy the contents over like we did before

.. Skip arrayqueue_expand2 since it is just a copy of 1
.. image:: img/arrayqueue_expand3.png
   :width: 500 px
   :align: center

* Instead, we should copy the contents into contiguous indices starting at index ``front``

.. image:: img/arrayqueue_expand4.png
   :width: 500 px
   :align: center

* Or, we could even copy the contents into contiguous indices starting at the beginning (index ``0``) of the new array

.. image:: img/arrayqueue_expand5.png
   :width: 500 px
   :align: center

* Doing another ``enqueue`` will add the element at index ``rear``
* Update ``rear`` with ``rear = (rear + 1) % queue.length;``


Discussion Again
----------------

* Will this implementation work?
    * Is it *correct*
* What is the computational complexity of this ``enqueue``?
* What is the computational complexity of this ``dequeue``?
* How often will this call ``expandCapacity`` relative to idea #1 and #2?


Implementing a Queue --- Array Container
========================================


For next time
=============

* Read Chapter 5 Section 7
    * 7 pages
