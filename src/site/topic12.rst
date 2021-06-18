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


For next time
=============

* Read Chapter 5 Section 7
    * 7 pages
