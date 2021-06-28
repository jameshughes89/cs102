************************
Topic #15 --- ArrayLists
************************


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
    * ``add(T element)`` even hijacks ``add(int index, T element)`` for ease

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

* The ``remove(T element)`` method hijacks the ``remove(int index)`` for ease
* You will also see that we do not use ``sentinelIndexOf`` since we do want the call to ``remove(T element)`` to propagate an exception if the element does not exist


For next time
=============

* Read Chapter 6 Sections 6 & 7
    * 17 pages
