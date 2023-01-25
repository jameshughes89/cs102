***********
The Bag ADT
***********

* Like stacks and queues, a bag is a data structure
* However, bags are more general than stacks and queues

* Bags have more flexibility on how they are used

    * Where and how elements are added, removed, and accessed



Bags
====

.. figure:: bag_general1.png
    :width: 500 px
    :align: center

    A representation of an arbitrary bag containing seven elements.


* By default, bags shouldn't really be thought of as having an ordering

    * The underlying implementation may be with some linear container
    * But the idea is that the information in the bag has no meaningful order


* Like the other collections, there needs to be a way to

    * Add
    * Remove
    * Get the size
    * Check if it's empty


* But given the more general definition of the bag, how exactly these should be done is not obvious

    * Adding to a Bag

        * How should elements be added?
        * Where should they go?


    * Removing from a Bag

        * How should elements be removed?
        * Where should they be removed from?


    * Other potential functionality?

        * Access a specific element?
        * Check if a given element exists?
        * ...


Sorted Bags
-----------

* If the elements must be sorted, then how they are added and removed must be done carefully

    * Unlike the general bag, this specific kind of bag will have an ordering


* The ordering of the elements will depend on some characteristic of the contents of the bag

    * Numbers in ascending order
    * Strings in alphabetical order


* The elements themselves are what determine the ordering

.. figure:: bag_sorted_bag0.png
    :width: 500 px
    :align: center

    Example sorted bag of seven integers. The integer 58 is to be added to the collection.


* There is only one way to add the element to the sorted bag

    * The element must be added such that the sorted property of the bag is preserved


.. figure:: bag_sorted_bag1.png
    :width: 500 px
    :align: center

    Example of inserting the integer ``58`` into the only valid spot in the sorted bag. Notice that the integer ``67``
    is the first element within the sorted bag that is larger than the element being added.


* Should there be restrictions on how elements are removed?



Indexed Bags
------------

* Indexed bags are bags where the elements are referenced by a numeric position
    * Numeric position is called the index
    * This is like arrays or the Python lists you're used to
* Like the sorted bag, this specific kind of bag will have an ordering

* Element position is important
* User determines the ordering of the elements
* Every time something is added or removed, the indices of the elements will need to be updated

.. image:: bag_indexed_bag0.png
   :width: 500 px
   :align: center

* We can add to any arbitrary index, assuming it is valid

.. image:: bag_indexed_bag1.png
   :width: 500 px
   :align: center

* We also will have removes from arbitrary locations


Functionality
=============

* We will keep our functionality of the bag simple
    * Add stuff
    * Remove stuff
    * Check if something is in the bag
    * Count the number of times something exists in the bag
    * See if it's empty
    * Get the size
    * Get an iterator for the bag
        * Iterators are handy tools for looping and consistency
        * More on iterators later


.. code-block:: java
    :linenos:

    import java.util.Iterator;

    public interface Bag<T> {

        void add(T element);

        T remove(T element);

        boolean contains(T target);

        int getCount(T target);

        boolean isEmpty();

        int size();

        Iterator<T> iterator();
    }


Sorted Bag Functionality
------------------------

* We want our sorted bags to be bags and have all the functionality as the bag
    * Add stuff
    * Remove stuff
    * Check if something is in the bag
    * Count the number of times something exists in the bag
    * See if it's empty
    * Get the size
    * Get an iterator for the bag

* However, there will be some functionality specific to the sorted bag that we will want
    * We have to make sure our ``add`` adds stuff to the proper location in the bag
    * Remove the first element
    * Remove the last element
    * Check the first element (but leave it in the bag)
    * Check the last element (but leave it in the bag)


.. code-block:: java
    :linenos:
    :emphasize-lines: 1

    public interface SortedBag<T> extends Bag<T> {

        // Special add to keep proper order
        void add(T element);

        T removeFirst();

        T removeLast();

        T first();

        T last();
    }

* You will notice that, despite wanting all the functionality of the bag, we do not write them in our interface
* You will also notice that the first line says ``public interface SortedBag<T> extends Bag<T>``

* The ``extends`` keyword means that we will *inherit* all the functionality from the class we are extending
    * ``Bag`` is being extended in this case

* This means that, although we did not write the functions from the ``Bag`` interface in the ``SortedBag`` ourselves, they are still part of what makes up a ``SortedBag``
    * If you try to implement a ``SortedBag`` without implementing all the functionality from the ``Bag`` interface, it won't work

* The idea of inheritance will be discussed further later


Indexed Bag
-----------

* Similar to the sorted bag, the indexed bag will make use of inheritance to get all the functionality for bags
* We will also add specific functionality for our indexed bag
    * Stuff to be able to specify indices in the data structure

.. code-block:: java
    :linenos:

    public interface IndexedBag<T> extends Bag<T> {

        void add(T element);

        void add(int index, T element);

        void set(int index, T element);

        T get(int index);

        // Mind the difference in function signature
        // from the inherited remove
        T remove(int index);

        int indexOf(T element);
    }


For next time
=============

* Download the various bag interfaces:
    * :download:`Bag </../main/java/Bag.java>`
    * :download:`SortedBag </../main/java/SortedBag.java>`
    * :download:`IndexedBag </../main/java/IndexedBag.java>`

* Read Chapter 6 Section 1 -- 5 on Lists
    * 23 pages
