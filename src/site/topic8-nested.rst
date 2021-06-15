************************************
Topic #8 Aside --- Nested Node Class
************************************

* Consider the doubly linked structure

.. image:: img/links_double.png
   :width: 500 px
   :align: center

* Since we need a reference to both the ``next`` and ``previous`` nodes, we can't use our existing ``Node`` :class:
    * Simple to make, but still needs a change

* Also consider that the ``Node`` class would only be used for a linked implementation of something
    * As far as the user of a ``LinkedStack`` is concerned, they don't care about the ``Node`` class, they just care that the ``LinkedStack`` works
    * Kinda like the private method ``expandCapacity`` in the ``ArrayStack``

* Does it make sense to have the ``Node`` class accessible from everywhere?

