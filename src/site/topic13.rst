***********************
Topic #13 --- Bag ADT
***********************

* Like stacks and queues, bags are another data structure
* However, bags are more general than stacks and queues
    * We have more flexibility on where we add and remove elements

Bags
=====

.. image:: img/bag_general1.png
    :width: 500 px
    :align: center

* By default, our bag shouldn't really be thought of as having an ordering
    * It's implementation may be with some sort of linear collection, but the idea is that the information in the bag has no order

* What things do we want to do with our new data structure?
    * Add things
    * Remove things
    * Get the size
    * Check if it's empty

* Adding to a Bag
    * How should we add things?
    * Where should they go?

* Removing from a Bag
    * How should we remove things?
    * Where should they be removed from?

* Other things me may want to do?
    * Take a minute and think about potential ideas


Sorted Bags
-----------

* If we want a specific kind of bag that keeps our elements sorted based on some ordering, adding will need to be done carefully
    * Unlike the general bag, this specific kind of bag will have an ordering

* The ordering of the elements will depend on some characteristic of the contents of the bag
    * Numbers in ascending order
    * Strings in alphabetical order

* The elements themselves are what determine the ordering

.. image:: img/bag_sortedBag0.png
   :width: 500 px
   :align: center

* There really is only one way to add elements to this sorted bag
    * The elements **must** go where it belongs
* We cannot specify where we add it because that may break our sorted ordering

.. image:: img/bag_sortedBag1.png
   :width: 500 px
   :align: center

* Should there be rules restricting removing from the bag?


Indexed Bags
------------

* Indexed bags are bags where the elements are referenced by a numeric position
    * Numeric position is called the index
    * This is like arrays or the Python lists you're used to
* Like the sorted bag, this specific kind of bag will have an ordering

* Element position is important
* User determines the ordering of the elements
* Every time something is added or removed, the indices of the elements will need to be updated

.. image:: img/bag_IndexedBag0.png
   :width: 500 px
   :align: center

* We can add to any arbitrary index, assuming it is valid

.. image:: img/bag_IndexedBag1.png
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


Bag Interface
-------------


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



For next time
=============

* Read Chapter 6 Section 1 -- 5 on Lists
    * 23 pages
