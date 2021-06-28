**********************
Topic #15 --- ArrayBag
**********************

* :doc:`We already know what we want to do with our bags </topic13>`
* We also extended the ``Bag`` to make more specialized bags
    * ``IndexedBag``
    * ``SortedBag``

* Let's implement them now


Array Implementation Idea
=========================

.. image:: img/bag_arrayBag.png
   :width: 500 px
   :align: center

* The idea will be similar to the ``Stack`` and ``Queue`` array based implementations
* Unlike a ``Queue``, we will keep the front always at index 0
    * Any ideas why?

* We will need to use ``expandCapacity`` again since our arrays are fixed size
    * The simpler version though, since, again, front is always index 0

* The functionality we want out of our ``Bag``, regardless of what implementation it is:
    * ``void add(T element)``
    * ``T remove(T element)``
    * ``boolean contains(T element)``
    * ``int getCount(T element)``
    * ``boolean isEmpty()``
    * ``int size()``
    * ``Iterator<T> iterator()``

Adding Method
^^^^^^^^^^^^^

.. code-block:: Java
    :linenos:

        private int findInsertIndex(T element) {
            int searchIndex = 0;
            Iterator<T> it = this.iterator();
            while ((it.hasNext() && it.next().compareTo(element) > 0) {
                searchIndex++;
            }
            return searchIndex;
        }

        @Override
        public void add(T element) {
            if (size() == bag.length) {
                expandCapacity();
            }
            int insertIndex = findInsertIndex(element);
            shiftRight(insertIndex);
            bag[insertIndex] = element;
            rear++;
        }

* The ``add`` method makes use of the private method ``findInsertIndex``
* When analyzing this method, notice that we are using an iterator
    * Ultimately, this method is doing a linear search
* We are also making use of the ``compareTo`` method
* Remember
    * The elements themselves should determine the ordering
    * We do not know what the type ``T``, so how can we compare them?
        * Sure, if they're numbers we can use ``<``, ``>``, ``==``, and so on
        * What if we are sorting strings? Or Colours?

* Since I know that type ``T`` has a ``compareTo`` implemented, we will make use of it so I can guarantee I always get the proper ordering, regardless of the type

* Given this, the loop will execute while:
    * There are more elements in the collection
    * and the thing we want to insert is belongs after the current element in the collection

For next time
=============

.. warning::

    Note that there are better implementations of these data structures. We will see one later in the course.

* Download and play with the :download:`ArrayIndexedBag <../main/java/ArrayIndexedBag.java>` and  :download:`ArraySortedBag <../main/java/ArraySortedBag.java>` code
* Read Chapter 6 Sections 6 & 7
    * 17 pages
