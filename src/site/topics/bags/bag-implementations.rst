*******************
Bag Implementations
*******************

* :doc:`We already know what we want to do with our bags <bag-adt>`
* We also extended the ``Bag`` to make more specialized bags
    * ``IndexedBag``
    * ``SortedBag``

* Let's implement them now


Array Implementation Idea
=========================

.. image:: array_bag.png
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
    :download:`ArrayIndexedBag </../main/java/ArrayIndexedBag.java>` implementation to view the full implementation.


.. code-block:: Java
    :linenos:
    :emphasize-lines: 1, 7

    import java.util.Iterator;
    import java.util.NoSuchElementException;

    public class ArrayIndexedBag<T> implements IndexedBag<T> {

        private static final int DEFAULT_CAPACITY = 100;
        private static final int NOT_FOUND = -1;
        private T[] bag;
        private int rear;

        public ArrayIndexedBag() {
            this(DEFAULT_CAPACITY);
        }

        @SuppressWarnings("unchecked")
        public ArrayIndexedBag(int initialCapacity) {
            bag = (T[]) new Object[initialCapacity];
            rear = 0;
        }


There are a couple things to note so far:

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


ArraySortedBag
--------------

* In addition to the functionality of the ``Bag``, we want to add a few more methods for our ``SortedBag`` implementation
    * ``void add(T element)`` --- add to the proper spot in the sorted bag to preserve the sorted order
    * ``T removeFirst()``
    * ``T removeLast()``
    * ``T first()``
    * ``T last()``

.. warning::

    Like the indexed bag, some methods are skipped. See the
    :download:`ArraySortedBag </../main/java/ArraySortedBag.java>` implementation to view the full implementation.

.. code-block:: Java
    :linenos:
    :emphasize-lines: 4

    import java.util.Iterator;
    import java.util.NoSuchElementException;

    public class ArraySortedBag<T extends Comparable<? super T>> implements SortedBag<T> {

        private static final int DEFAULT_CAPACITY = 100;
        private static final int NOT_FOUND = -1;
        private T[] bag;
        private int rear;

        public ArraySortedBag() {
            this(DEFAULT_CAPACITY);
        }

        @SuppressWarnings("unchecked")
        public ArraySortedBag(int initialCapacity) {
            bag = (T[]) new Comparable[initialCapacity];
            rear = 0;
        }

* This looks nearly the same as the ``ArrayIndexedBag`` implementation, but we see one major difference

    ``<T extends Comparable<? super T>>``

* There is a little bit to unpack here

* First, when something extends `Comparable <https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Comparable.html>`_, it means that the type has some defined ordering
    * The method ``compareTo`` is implemented for the type

* If we call ``x.compareTo(y)``
    * Return a negative integer if ``y < x``
    * Return zero if ``y == x``
    * Return a positive integer if ``y > x``

* When we have something that is extending ``Comparable<T>``, that means we can compare ``this`` to some type ``T``
    * ``this`` can be compared to things of type ``T``, but not the other way around

* By saying ``T extends Comparable<T>``, this means that the type ``T`` we want in our ``ArraySortedBag`` can be compared to things of type ``T`` to provide some defined ordering
    * Which is needed, if we want to sort things

* Finally, with ``Comparable<? super T>``, we are saying that ``T`` or one of its superclasses must extend ``Comparable``
    * ``?`` is a *wildcard*
    * If our type ``T`` does not extend ``Comparable`` and have a ``compareTo`` method written, that may be fine as long as one of its superclasses does

* Putting this all together, ``<T extends Comparable<? super T>>`` means that our type ``T`` must have a defined ordering for itself either through a direct implementation of ``compareTo`` or through inheriting from a superclass



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


Testing
-------

* Although not discussed in depth here, check out the testing methods for these implementations to get a sense of what functionality is being tested and how
    * :download:`ArrayIndexedBagTest <../test/java/ArrayIndexedBagTest.java>`
    * :download:`ArraySortedBagTest <../test/java/ArraySortedBagTest.java>` code


Linked Implementation
=====================

.. image:: linked_bag.png
   :width: 500 px
   :align: center

* There is nothing stopping us from building a linked implementation of the bag
* :doc:`Reviewing the different types of insertions and removals from a linked structure will help </topics/linked-structures>`


For next time
=============

.. warning::

    Note that there are better implementations of these data structures. We will see one later in the course.

* Download and play with the :download:`ArrayIndexedBag </../main/java/ArrayIndexedBag.java>` and  :download:`ArraySortedBag </../main/java/ArraySortedBag.java>` code
* Download and play with the :download:`ArrayIndexedBagTest </../test/java/ArrayIndexedBagTest.java>` and :download:`ArraySortedBagTest </../test/java/ArraySortedBagTest.java>` code
* Read Chapter 6 Sections 6 & 7
    * 17 pages
