************************
Topic #15 --- ArrayLists
************************


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

* Download and play with the :download:`ArrayIndexedBag <../main/java/ArrayIndexedBag.java>` and  :download:`ArraySortedBag <../main/java/ArraySortedBag.java>` code
* Read Chapter 6 Sections 6 & 7
    * 17 pages
