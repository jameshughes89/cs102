**********
ArrayQueue
**********

* Things needed for the implementation

    * A container
    * A way to keep track of the front/head
    * A way to keep track of the rear/tail
    * A way to keep track of the size


* A linked structure was used as a container for a ``Queue``
* Now an array will be used to implement the ``Queue``


Idea #1
=======

* Use an array for the container
* Keep track of the front by simply having it always be index ``0``
* Keep track of the ``rear`` index
* Size will conveniently be equal to ``rear``


.. figure:: arrayqueue_first_idea0.png
    :width: 500 px
    :align: center

    An example of idea #1's ``ArrayQueue`` containing four elements. This implementation requires that index ``0``
    always be the front. Note the value stored in ``rear`` refers to the next available spot in the array. Also notice
    that the value in ``rear`` corresponds to the number of elements currently in the queue.


* All adding (``enqueue``) happens at the ``rear`` end
* Add the element to index ``rear``
* Increment ``rear``


.. figure:: arrayqueue_first_idea1.png
    :width: 500 px
    :align: center

    The state of idea #1's ``ArrayQueue`` after an element was enqueued. Note that the element was added at index
    ``rear`` and the value of ``rear`` was increased such that it refers to the next available spot in the array.


* All removing (``dequeue``) happens at index ``0``
* Requires that elements are shuffled down ``1`` index
* Decrement ``rear``


.. figure:: arrayqueue_first_idea2.png
    :width: 500 px
    :align: center

    The state of idea #1's ``ArrayQueue`` after an element was dequeued. Note that the element at index ``0`` was
    removed and all elements moved down one index in the array. Further, the value of ``rear`` was decreased by one.



Discussion
----------

* Will this implementation work?

    * Is it *correct*


* Knowing that this is an array implementation, will something like an ``expandCapacity`` be required?
* What is the computational complexity of an ``enqueue`` with this idea?

    * Amortized :math:`O(1)`


* What is the computational complexity of a ``dequeue`` with this idea?

    * :math:`O(n)` as it requires all :math:`n` elements be shuffle down one index in the array


* The drawback of idea #1 is a :math:`O(n)` ``dequeue``

    * The ``LinkedQueue`` implementation has an :math:`O(1)` ``dequeue``


Idea #2
=======

* Use an array for the container
* Keep track of the ``front`` index
* Keep track of the ``rear`` index
* Size will conveniently be ``rear - front``


.. figure:: arrayqueue_second_idea0.png
    :width: 500 px
    :align: center

    An example of idea #2's ``ArrayQueue`` containing four elements. This implementation keeps track of the ``front``
    and ``rear`` indices. Note the value stored in ``rear`` refers to the next available spot in the array. Also notice
    that the difference between ``rear`` and ``front`` corresponds to the number of elements currently in the queue.


* All adding (``enqueue``) happens at the ``rear`` end
* Add the element to index ``rear``
* Increment ``rear``


.. figure:: arrayqueue_second_idea1.png
    :width: 500 px
    :align: center

    The state of idea #1's ``ArrayQueue`` after an element was enqueued. Note that the element was added at index
    ``rear`` and the value of ``rear`` was increased such that it refers to the next available spot in the array.


* All removing (``dequeue``) happens at index ``front``
* Remove the element at index ``front``
* Increment ``front``


.. figure:: arrayqueue_second_idea2.png
    :width: 500 px
    :align: center

    The state of idea #2's ``ArrayQueue`` after an element was dequeued. Note that the element at index ``front`` was
    removed and the value of ``front`` increased by one. Note that, with the exception of the removed element, no other
    elements were required to be moved within the array.



Discussion
----------

* Will this implementation work?

    * Is it *correct*


* Knowing that this is an array implementation, will something like an ``expandCapacity`` be required?
* What is the computational complexity of an ``enqueue`` with this idea?

    * Amortized :math:`O(1)`


* What is the computational complexity of a ``dequeue`` with this idea?

    * :math:`O(1)`


* The drawback of idea #2 is the wasted space caused by ``dequeue``

    * All indices before ``front`` are wasted
    * ``expandCapacity`` would need to be called after :math:`n + 1` enqueues despite the number of elements actually in the queue



Idea #3
=======

* Use an array for the container
* Keep track of the ``front`` index
* Keep track of the ``rear`` index
* Keep track of the ``size``
* If there are empty indices before the ``front``, loop the ``rear`` back to ``0`` when the end of the array is hit


.. figure:: arrayqueue_third_idea1.png
    :width: 500 px
    :align: center

    An example of idea #3's ``ArrayQueue`` containing four elements. Note that the ``rear`` index has looped back to the
    beginning of the "circular" array.


.. figure:: arrayqueue_third_idea2.png
    :width: 500 px
    :align: center

    An example of idea #3's ``ArrayQueue`` containing four elements. This figure contains the same ``ArrayQueue`` shown
    in the previous figure but with the "circular" array shown as a typical linear array.



"Circular" Array
----------------

* *Pretend* the array is a circle

    * The array is still, in reality, a linear array


* For example, given an array with a capacity of ``n``
* The indices' order would be

    ``..., 0, 1, 2, 3, ..., n-2, n-1, 0, 1, 2, 3, ..., n-2, n-1, 0, 1, 2, 3, ...``


* The index that comes after ``n-1`` is ``0``
* The index that comes before ``0`` is ``n-1``

.. figure:: arrayqueue_circle0.png
    :width: 500 px
    :align: center

    Example "circular" array with a capacity of 13. This figure shows the array containing seven elements stored in
    indices ``0`` -- ``6``. Within the context of the ``ArrayQueue``, ``front`` would be index ``0`` and ``rear`` would
    be ``7``.


.. figure:: arrayqueue_circle1.png
    :width: 500 px
    :align: center

    Example "circular" array with a capacity of 13 containing two elements stored in indices ``5`` and ``6``. This would
    be the state of the ``ArrayQueue`` shown in the proceeding figure after ``dequeue`` is called five times.


.. figure:: arrayqueue_circle2.png
    :width: 500 px
    :align: center

    Example "circular" array with a capacity of 13 containing 10 elements stored in indices ``5`` -- ``12``, ``0`` and
    ``1``. This would be the state of the ``ArrayQueue`` shown in the proceeding figure after ``enqueue`` is called
    eight times. Notice that ``rear`` looped back to the beginning of the array.



Modulo --- ``%``
----------------

* The modulo (``%``) operator provides a way to get the remainder of a division

    * ``4 % 2``

        * ``4/2 == 0`` remainder ``0``
        * Therefore, ``4 % 2`` is ``0``


    * ``5 % 4``

        * ``5/4 == 1`` remainder ``1``
        * Therefore, ``5 % 4`` is ``1``


    * ``7 % 8``

        * ``7/8 == 0`` remainder ``7``
        * Therefore, ``7 % 8`` is ``7``


* Knowing the remainder provides a way to loop back to the beginning of an array

``rear = (rear + 1) % queue.length``
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

* Assume an array with a capacity ``10``
* Also assume ``rear`` is currently ``9``
* ``rear`` should always be the index of the next available spot in the array

* If ``enqueue`` is called, the new element is added to index ``9`` and ``rear`` is updated
* However, ``rear`` cannot simply be incremented to ``10`` since there is no index ``10`` in an array of capacity ``10``
* Instead, in this case, ``rear`` should be updated to ``0``

* This *could* be achieved with an ``if`` statement --- ``if (rear == queue.length) rear = 0``
* But notice that when ``rear == queue.length``, ``rear % queue.length`` is ``0``
* But also notice that when ``rear`` is another number, like ``4``, ``rear % queue.length`` would be ``4``
* With this information, the following expression for incrementing the ``rear`` should make sense

    ``rear = (rear + 1) % queue.length``


* If ``rear`` is ``9`` and this idea is used, ``rear`` will end up being ``(9 + 1) % 10 == 10 % 10 == 0``
* If ``rear`` is any other number ``< 10``, the number is not divisible by ``10`` and the ``%`` will make no difference



Discussion
----------

* Does the strategy for updating ``front`` need to also be changed?
* Will this "circular" array ever run out of room?


.. warning::

    Sometimes, *good enough is good enough*.

    With this ``ArrayQueue`` implementation scenario, idea #3 is quite clearly the superior option and is not overly
    difficult to implement. However, as one continues in computer science and works on more complex problems, sometimes
    ease of implementation and maintainability becomes very important.

    Better algorithms always exist, but a subpar implementation may do the trick, especially when the problem space is
    small enough that performance doesn't matter.

    Computational complexity is very important, but sometimes in practice one may lose the forrest through the trees. If
    an algorithm can be changed from :math:`O(n^{2})` to :math:`O(n)`, then do it. But then again, if the updated
    algorithm will take a day to implement and it only needs to be run once on a small problem, perhaps :math:`O(n^{2})`
    is good enough.

    Even worse, trying to save a few *FLOPS* here and there is great and all, but if that's distracting someone from
    other more important issues, perhaps they should move on.

    Donald Knuth, a very famous computer scientist, says:

        *Programmers waste enormous amounts of time thinking about, or worrying about, the speed of noncritical parts of their programs, and these attempts at efficiency actually have a strong negative impact when debugging and maintenance are considered. We should forget about small efficiencies, say about 97% of the time: premature optimization is the root of all evil. Yet we should not pass up our opportunities in that critical 3%.*



Expand Capacity
---------------

.. image:: arrayqueue_expand_capacity0.png
   :width: 500 px
   :align: center

* Suppose we ``enqueue`` one more element

.. image:: arrayqueue_expand_capacity1.png
   :width: 500 px
   :align: center

* Now the queue is full
    * ``size == queue.length``

* If we ``enqueue`` again, we'll need to call ``expandCapacity``
* **However** we can't just double the size of the array and copy the contents over like we did before
    * :doc:`See the aside on expandCapacity. <expand-capacity>`

.. Skip arrayqueue_expand_capacity2 since it is just a copy of 1
.. image:: arrayqueue_expand_capacity3.png
   :width: 500 px
   :align: center

* Instead, we could copy the contents into contiguous indices starting at index ``front``

.. image:: arrayqueue_expand_capacity4.png
   :width: 500 px
   :align: center

* Or, we could even copy the contents into contiguous indices starting at the beginning (index ``0``) of the new array

.. image:: arrayqueue_expand_capacity5.png
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


* All code is available for download from links at the bottom of the page
* Here, only a subset of methods are shown


enqueue
-------

.. code-block:: java
    :linenos:
    :emphasize-lines: 4, 7

    @Override
    public void enqueue(T element) {
        if (size == queue.length) {
            expandCapacity();
        }
        queue[rear] = element;
        rear = (rear + 1) % queue.length;
        size++;
    }

* Note the call to ``expandCapacity``
* Also note the use of the ``%`` operator for updating ``rear``


.. code-block:: java
    :linenos:
    :emphasize-lines: 4, 5, 7, 8

    private void expandCapacity() {
        T[] newQueue = (T[]) new Object[queue.length * 2];
        for (int i = 0; i < queue.length; ++i) {
            newQueue[i] = queue[front];
            front = (front + 1) % queue.length;
        }
        front = 0;
        rear = size;
        queue = newQueue;
    }

* ``expandCapacity`` is different from before
* First, we're copying into index ``i`` from index ``front``
    * Previously for the stack, we used ``newStack[i] = stack[i]``
* Then we update ``front`` with the use of ``%``

* After all the copying, the ``front`` for the ``newQueue`` is set to ``0``
* ``rear`` is set to the size
    * When ``front`` is ``0``, ``rear`` must be equal to ``size``

.. warning::

    Take your time with this one and make sure you understand the nuance here.


dequeue
-------

.. code-block:: java
    :linenos:
    :emphasize-lines: 7

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Dequeueing from an empty queue.");
        }
        T returnElement = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return returnElement;
    }

* Since we're wrapping, we must remember that ``front`` may wrap around too


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

* What we're really testing is the ``Queue`` *interface*
* But, in order to do this, we have to make sure the implementation properly implements the interface
* We need to check that we can use enqueue and dequeue and have ``expandCapacity`` called without messing up the ordering of the queue
* The ``enqueue`` and ``dequeue`` on lines 5 & 6 are to have ``front == rear == 1``
    * Just not at ``0``

* Six ``enqueues`` will require that ``expandCapacity`` is called, but now ``front == rear == 1`` again
* If the ``expandCapacity`` was broken, it would be possible that we overwrite the first element in the queue

* After ``expandCapacity`` is called, ``front`` is ``0`` and ``rear`` is ``6``, but I don't actually care what the indicies are
* All I care about is that I can ``dequeue`` the ``6`` elements and get them in FIFO order

.. warning::

    Remember, we're testing the **interface**, not the implementation; however, we ultimately need to write tests that
    exercise the specific implementation we have in order to ensure the interface is implemented correctly.


For next time
=============

* Download and play with the :download:`ArrayQueue </../main/java/ArrayQueue.java>` code
* Download and run the :download:`ArrayQueueTest </../test/java/ArrayQueueTest.java>` tests
* Read Chapter 5 Section 7
    * 7 pages


Playing Code
============

.. code-block:: java

        // Create a ArrayQueue
        Queue<Integer> myQueue = new ArrayQueue<>(5);

        // Check queue is empty
        System.out.println(myQueue.size());
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue);

        // Test enqueue
        myQueue.enqueue(0);
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        System.out.println(myQueue.size());
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue);

        // Test enqueue more to check expandCapacity
        myQueue.enqueue(10);
        myQueue.enqueue(11);
        myQueue.enqueue(12);
        myQueue.enqueue(13);
        myQueue.enqueue(14);
        System.out.println(myQueue.size());
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue);

        // Test first
        System.out.println(myQueue.first());
        System.out.println(myQueue.size());
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue);

        // Test dequeue
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.size());
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue);

        // Test first and dequeue throwing exception
        try {
            myQueue.first();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        try {
            myQueue.dequeue();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }