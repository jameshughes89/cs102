************************
Topic #12 --- ArrayQueue
************************

Idea #1
=======

Idea #2
=======

Idea #3
=======

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


Implementing a Queue --- Array Container
========================================


For next time
=============

* Read Chapter 5 Section 7
    * 7 pages
