************************
Topic #12 --- ArrayQueue
************************

* We need to think of:
    * A container
    * A way to keep track of the front/head
    * A way to keep track of the rear/tail
    * A way to keep track of the size

* We used a linked structure last time
* Let's now use an array...
* But how...


Idea #1
=======

Idea #2
=======

* Use an array for the container
* Keep track of the ``front`` index
* Keep track of the ``rear`` index
* Size will conveniently be ``rear - front``

.. image:: img/arrayqueue_2idea0.png
   :width: 500 px
   :align: center

* All adding happens at the ``rear`` end
* Add the element to index ``rear``
* Increment ``rear``

.. image:: img/arrayqueue_2idea1.png
   :width: 500 px
   :align: center

* ``dequeue`` always happens at index ``front````
* Increment ``front``


.. image:: img/arrayqueue_2idea2.png
   :width: 500 px
   :align: center

Discussion
----------

* Will this implementation work?
    * Is it *correct*
* Will we ever need to call ``expandCapacity``?
* What is the computational complexity of this ``enqueue``?
* What is the computational complexity of this ``dequeue``?
* How often will we call ``expandCapacity`` relative to idea #1?
* What drawback do you see?


Idea #3
=======

* An array for the container
* Keep track of the ``front`` index
* Keep track of the ``rear`` index
* If there is space at the front of the array, loop the indices back to ``0`` once we hit the end

"Circular Array"
----------------

* We can *pretend* our array is a circle
    * It's still a linear array, but that's OK

* For example, pretend we have an array with a capacity of ``n``
* The indices order would be

    ``0, 1, 2, 3, 4, ..., n-2, n-1, 0, 1, 2, 3, 4, ..., n-2, n-1, 0, 1, 2, 3, 4, ...``

* The index that comes before ``n-1`` is ``n-2``
* The index that comes after ``n-1`` is ``0``
* The index that comes before ``0`` is ``n-1``
* The index that comes after ``0`` is ``1``

* Take this "circular array" with 7 things in it

.. image:: img/arrayqueue_circle0.png
   :width: 500 px
   :align: center

* If we ``dequeue`` 5 times, we end up with this

.. image:: img/arrayqueue_circle1.png
   :width: 500 px
   :align: center

* And after 8 more ``enqueues`` we have this

.. image:: img/arrayqueue_circle2.png
   :width: 500 px
   :align: center


* With this idea, we can think of our idea #3 implementation as this

.. image:: img/arrayqueue_2idea0.png
   :width: 500 px
   :align: center

* After a bunch of ``enqueues`` and ``dequeues`` it will loop around like this

.. image:: img/arrayqueue_2idea1.png
   :width: 500 px
   :align: center

* Here is the same scenario, but with the array shown as a linear array

.. image:: img/arrayqueue_2idea2.png
   :width: 500 px
   :align: center


Modulo
------

* We've already seen the modulo operator: ``%``
* With this ``%`` operator, we can get the remainder of a division
    * ``4 % 2``
        * :math:`4/2 = 0` remainder :math:`0`
        * Therefore, ``4 % 2`` is :math:`0`
    * ``5 % 4``
        * :math:`5/4 = 1` remainder :math:`1`
        * Therefore, ``5 % 4`` is :math:`1`
    * ``7 % 8``
        * :math:`7/8 = 0` remainder :math:`7`
        * Therefore, ``7 % 8`` is :math:`7`

* The modulo operator is handy for checking if a number is even or odd
    * ``x % 2`` will be 0 when the number is evenly divisible by 2 and will be 1 if there is a remainder (not evenly divisible)

* We can make use of this ``%`` operator to help us loop back around to the beginning of our linear array

* We'll try to derive this ourselves
* Assume we have an array with a capacity ``10``
* Our ``rear`` is currently ``9``
* If we do an ``enqueue`` we simply add the element to index ``9`` and increment ``rear`` such that it's now ``10``
* **However** this causes a problem because there is no index ``10``; we want ``rear`` to become ``0`` instead

* We *could* do this with an ``if`` statement and just check ``if (rear == queue.length) rear = 0``
* But notice that when ``rear == queue.length``, that would mean that ``rear % queue.length`` is ``0``
* But also notice that, if ``rear`` was another number, like ``4``, then ``rear % queue.length`` would be ``4``

* With this information, the following expression for incrementing the ``rear`` should make sense

    ``rear = (rear + 1) % queue.length;``

* If ``rear`` is ``9`` and we use this expression, ``rear`` will end up being ``(9 + 1) % 10 == 10 % 10 == 0``
* If ``rear`` is any other number ``< 10``, the number is not divisible by ``10`` and the ``%`` will effectively make no difference


Discussion
----------

* With this special expression for updating the ``rear``, do we need it for updating the ``front``?
* With this idea, will we ever run out of room in our array?


Implementing a Queue --- Array Container
========================================


For next time
=============

* Read Chapter 5 Section 7
    * 7 pages
