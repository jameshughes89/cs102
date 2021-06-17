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

.. code-block:: java
    :linenos:

    public void enqueue(T element) {
        Node<T> toEnqueue = new Node<>(element);

        if (isEmpty()) {
            front = toEnqueue;
        }
        else {
           rear.setNext(toEnqueue);
        }
        rear = toEnqueue;
        size++;
    }

* Take your time looking at the ``enqueue`` method
* The easier things to notice are
    * Create a new node with the element being added
        * ``Node<T> toEnqueue = new Node<>(element);``
    * Once everything is done, set the rear to be the new enqueued node
        * ``rear = toEnqueue;``
    * Update the size
        * ``size++;``

* The ``if`` statement may be a little harder to chew on
* The trick to understanding it is to take your time, look at the code, and think carefully


Enqueuing into an Empty Queue
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

* **If** the queue is empty, both ``front`` and ``rear`` reference ``null``
* When this is the case, the thing being enqueued will be the only element in the queue
    * Thus, both ``front`` and ``rear`` need to reference the new node
    * The new node will be both the first and last thing in the queue

* When looking at the code, this would result in
    1. Making a new node with the element being enqueued
    2. Setting ``front`` to reference the new node
    3. Setting ``rear`` to reference the new node
    4. Updating the count


Enqueuing into a Nonempty Queue
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

* **If** the queue is not empty there is at least one element in it
    * It may be the case that both ``front`` and ``rear`` reference the same node (if there is only 1 thing in the queue)

* When looking at the code, this would result in
    1. Making a new node with the element being enqueued
    2. Setting the ``rear``'s next to be the new node
    3. Setting the ``rear`` to reference the new node
    4. Updating the count


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