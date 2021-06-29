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

Linked Implementation
=====================

.. image:: img/bag_linkedBag.png
   :width: 500 px
   :align: center

* There is nothing stopping us from building a linked implementation of the bag
* :doc:`Reviewing the different types of insertions and removals from a linked structure will help </topic7>`

Iterator Method
^^^^^^^^^^^^^^^

.. warning::

    Iterators are the focus of the next topic, so they are only presented briefly here.


* We made use of this method in other methods by calling ``this.iterator()``
* Which calls the method ``iterator`` from this class

.. code-block:: Java
    :linenos:

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(bag, size());
    }

* All this method does is create an instance of an ``ArrayIterator`` and return it
* We will look at what the ``ArrayIterator`` class looks like in the next topic

Add Methods
^^^^^^^^^^^

.. code-block:: Java
    :linenos:

        @Override
        public void add(int index, T element) {
            if (index > size()) {
                throw new IndexOutOfBoundsException(String.format("Bag has no index %d to add to.", index));
            }
            if (size() == bag.length) {
                expandCapacity();
            }
            shiftRight(index);
            bag[index] = element;
            rear++;
        }

        @Override
        public void add(T element) {
            add(rear, element);
        }


* There is nothing overly sophisticated taking place in these add methods
    * ``add(T element)`` even delegates to ``add(int index, T element)`` for ease and code/logic reuse

* Unlike our methods for adding things to a ``Stack`` or ``Queue``, this method may throw an exception since we can specify an invalid index
* Like the ``Stack`` and ``Queue``, we may need to call ``expandCapacity``
* Since we can add to an arbitrary index, we may need to make room in our array with the method ``shiftRight``

Index Of, Contains, Remove
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. code-block:: Java
    :linenos:

        @Override
        public int indexOf(T target) {
            int index = sentinelIndexOf(target);
            if (index == NOT_FOUND) {
                throw new NoSuchElementException("Element not contained in bag.");
            }
            return index;
        }

        @Override
        public boolean contains(T target) {
            return sentinelIndexOf(target) != NOT_FOUND;
        }

* Our ``indexOf`` and ``contains`` methods makes use of the ``sentinelIndexOf`` method
* The difference between ``IndexOf`` and ``sentinelIndexOf`` is that one may throw an exception, while the other may return a sentinel value
* At first this may seem silly
    * Why not cut ``sentinelIndexOf`` and just use ``indexOf``, and instead of checking for ``NOT_FOUND``, just catch the exception?

.. code-block:: Java
    :linenos:

        @Override
        public boolean contains(T target) {
            try {
                indexOf(target);
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        }

* However, remember that we keep exceptions and regular functionality separate
* If we use this option where we catch the exception, we are now letting these worlds collide

.. code-block:: Java
    :linenos:

        @Override
        public T remove(T element) {
            if (isEmpty()) {
                throw new NoSuchElementException("Removing from an empty bag.");
            }
            // If indexOf throws an exception, this method propagates it
            int removeIndex = indexOf(element);
            return remove(removeIndex);
        }

        @Override
        public T remove(int index) {
            if (index >= size()) {
                throw new IndexOutOfBoundsException(String.format("Bag has no element at index %d.", index));
            }
            T returnElement = bag[index];
            shiftLeft(index);
            rear--;
            return returnElement;
        }

* The ``remove(T element)`` method delegates to the ``remove(int index)`` for ease and code/logic reuse 
* You will also see that we do not use ``sentinelIndexOf`` since we do want the call to ``remove(T element)`` to propagate an exception if the element does not exist


For next time
=============

.. warning::

    Note that there are better implementations of these data structures. We will see one later in the course.

* Download and play with the :download:`ArrayIndexedBag <../main/java/ArrayIndexedBag.java>` and  :download:`ArraySortedBag <../main/java/ArraySortedBag.java>` code
* Read Chapter 6 Sections 6 & 7
    * 17 pages
