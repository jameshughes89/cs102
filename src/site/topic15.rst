************************
Topic #15 --- ArrayLists
************************


ArrayIndexedBag
---------------

* In addition to the functionality of the ``Bag``, we want to add a few more methods for our ``IndexedBag`` implementation
    * ``void add(T element)`` --- add to the end of the bag
    * ``void add(int index, T element)``
    * ``T remove(int index)`` --- remove from a specific index
    * ``void set(int index, T element)``
    * ``T get(int index)``
    * ``int indexOf(T element)``

* Let's start exploring the implementation

.. warning::

    Only areas of note are presented here and some methods are skipped. See the
    :download:`ArrayIndexedBag <../main/java/ArrayIndexedBag.java>` implementation to view the full implementation.


.. code-block:: Java
    :linenos:
    :emphasize-lines: 1, 7

    import java.util.Iterator;
    import java.util.NoSuchElementException;

    public class ArrayIndexedBag<T> implements IndexedBag<T> {

        private static final int DEFAULT_CAPACITY = 100;
        private static final int NOT_FOUND = -1;
        protected T[] bag;
        protected int rear;

        public ArrayIndexedBag() {
            this(DEFAULT_CAPACITY);
        }

        @SuppressWarnings("unchecked")
        public ArrayIndexedBag(int initialCapacity) {
            bag = (T[]) new Object[initialCapacity];
            rear = 0;
        }


* There are a couple things to note so far
1. We are importing something called ``Iterator``
    * Iterators are used for *iterating* over a collection
    * More on this later

2. The use of the constant ``NOT_FOUND`` that is set to ``-1``
    * We will use ``-1`` as a *sentinel* value to mean that something was not found
        * A value that, in the context of how it's used, has a special meaning
    * Unfortunately, if you are looking at this code for the first time, ``-1`` may be very unclear
    * By using a constant with the name ``NOT_FOUND`` in place of ``-1``, it's meaning is far less unclear
    * This will make more sense below when we see how it's used


Private Methods
^^^^^^^^^^^^^^^

* We will make a few private helper methods

.. code-block:: Java
    :linenos:

        private void expandCapacity() {
            T[] newBag = (T[]) new Object[bag.length * 2];
            for (int i = 0; i < bag.length; ++i) {
                newBag[i] = bag[i];
            }
            bag = newBag;
        }

        private void shiftLeft(int start) {
            for (int i = start; i < rear - 1; ++i) {
                bag[i] = bag[i + 1];
            }
            bag[rear - 1] = null;
        }

        private void shiftRight(int start) {
            for (int i = rear; i > start; --i) {
                bag[i] = bag[i - 1];
            }
            bag[start] = null;
        }

        private int sentinelIndexOf(T target) {
            int searchIndex = 0;
            Iterator<T> it = this.iterator();
            while (it.hasNext()) {
                if (it.next().equals(target)) {
                    return searchIndex;
                }
                searchIndex++;
            }
            return NOT_FOUND;
        }

* We are well familiar with ``expandCapacity``
* We've also added a ``shiftLeft`` and ``shiftRight``
    * These move elements up or down the array to make or eliminate extra room for adding and removing elements

* ``sentinelIndexOf``, which will tell us the index of a specified element, but return ``NOT_FOUND`` (``-1``) if it's not found
    * This method will be helpful for a few other methods in our class
* This seems very similar to ``indexOf``, except, like our other collections, we want our ``indexOf`` to throw an exception if something is not found
    * If we suddenly switch this method to not throw an exception, this may be very confusing
    * Nuances will be discussed further later

* We also make use of an ``Iterator`` here
* Remember how looping through an array, we would almost always use a ``for`` loop with indices
* Also how looping through a linked structure, we would use a ``while`` loop checking something like ``cur != null``
* Iterators provide us with a way to iterate over *something* the same way, regardless with what the underlying *thing* is
    * In our case, the *something* is a collection
    * The underlying *thing* is out array
* Here we're using two methods from the iterator
    * ``hasNext()``, which returns a boolean telling us if there is anything left in the collection
    * ``next()``, which returns the next element in the collection



For next time
=============

* Read Chapter 6 Sections 6 & 7
    * 17 pages
