************************
Topic #15 --- ArrayLists
************************


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
    :download:`ArraySortedBag <../main/java/ArraySortedBag.java>` implementation to view the full implementation.

.. code-block:: Java
    :linenos:
    :emphasize-lines: 4

    import java.util.Iterator;
    import java.util.NoSuchElementException;

    public class ArraySortedBag<T extends Comparable<? super T>> implements SortedBag<T> {

        private static final int DEFAULT_CAPACITY = 100;
        private static final int NOT_FOUND = -1;
        protected T[] bag;
        protected int rear;

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

* By saying ``T extends Comparable``, this means that the type ``T`` we want in our ``ArraySortedBag`` has some defined ordering
    * Which is needed, if we want to sort things

* Finally, with ``Comparable<? super T>``, we are saying that ``T`` or one of its superclasses must extend ``Comparable``
    * ``?`` is a *wildcard*
    * If our type ``T`` does not extend ``Comparable`` and have a ``compareTo`` method written, that may be fine as long as one of its superclasses does

* Putting this all together, ``<T extends Comparable<? super T>>`` means that our type ``T`` must have a defined ordering for itself either through a direct implementation of ``compareTo`` or through inheriting from a superclass



For next time
=============

* Read Chapter 6 Sections 6 & 7
    * 17 pages
