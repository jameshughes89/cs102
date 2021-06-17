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


Dequeue & First
---------------

.. code-block:: java
    :linenos:

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Dequeueing from an empty queue.");
        }
        T returnElement = front.getData();
        front = front.getNext();
        size--;
        if (isEmpty()) {
            rear = null;
        }
        return returnElement;
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new NoSuchElementException("First from an empty queue.");
        }
        return front.getData();
    }

* Like ``LinkedStack`` and ``ArrayStack``, trying to access something from the empty queue throws an exception

* Notice in ``dequeue`` that, if it's not empty, we just *remove/delete from the front of a linked structure*
    * This was the same as ``pop`` in the ``LinkedStack``

* In addition to being empty, the only other edge case we need to watch out for is if the ``dequeue`` makes the queue empty
* If this happens, we must set ``front`` to ``null``
    * This is actually taken care of already since ``front``'s next would be ``null``, and saying ``front = front.getNext()`` makes ``front`` ``null``

* We should also set ``rear`` to ``null``
* This helps with garbage collection and keeping the state of the queue *correct*
* If we don't do this, ``rear`` will continue to point to a node that should not be in the queue anymore
    * Our current implementation will handel this scenario fine as an enqueue on an empty queue sets both ``front`` and ``rear`` to ``null``
    * But imagine also haveing a messed up count and ``enqueuing`` after this without setting ``rear`` to ``null``
    * If we ``enqueue`` in this case, we might end up saying ``rear.setNext(toEnqueue)``
    * What would that mean?
    * What would that look like?


Variations
==========

* We can define any variation we could want

Priority Queue
--------------



For next time
=============

* Read Chapter 5 Section 6
    * 6 pages