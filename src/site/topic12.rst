************************
Topic #12 --- ArrayQueue
************************

Idea #1
=======

Idea #2
=======

Idea #3
=======

Implementing a Queue --- Array Container
========================================

Testing
=======

* The testing code is available for download at the bottom of the page
* Here, a noteworthy test is presented

.. code-block:: java
    :linenos:

    @Test
    @DisplayName("Enqueuing 6 elements expands capacity while maintaining queues FIFO ordering.")
    void enqueuingBeyondCapacityCallsExpandCapacityToMakeRoomWhileMaintainingQueueOrdering() {
        Queue<Integer> queue = new ArrayQueue<>(5);
        queue.enqueue(99);
        queue.dequeue();
        for (int i = 0; i < 6; ++i) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 6; ++i) {
            assertEquals(i, queue.dequeue());
        }
    }

* Here, what we want to test is that the we can enqueue and dequeue and have ``expandCapacity`` called without messing up the ordering of the queue
* The ``enqueue`` and ``dequeue`` on lines 5 & 6 are to have ``front == rear == 1``
    * Just not at ``0``

* Six ``enqueues`` will require that ``expandCapacity`` is called, but now ``front == rear == 1`` again
* If the ``expandCapacity`` was broken, it would be possible that we overwrite the first element in the queue

* After ``expandCapacity`` is called, ``front`` is ``0`` and ``rear is ``6``, but I don't actually care what the indicies are
* All I care about is that I can ``dequeue`` the ``6`` elements and get them in FIFO order


For next time
=============

* Read Chapter 5 Section 7
    * 7 pages
