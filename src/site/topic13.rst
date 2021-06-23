***********************
Topic #13 --- Lists ADT
***********************



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

For next time
=============

* Read Chapter 6 Section 1 -- 5
    * 23 pages
