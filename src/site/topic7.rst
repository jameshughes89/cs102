******************
Topic #7 --- Links
******************

.. warning::

    We are not yet defining a new ADT. We're just prepping to start implementing other ADTs with something other than an array.


* Arrays have a fixed size
    * But we can change capacity

* When using an array, we may have to shift things around when adding and removing
* Traditionally speaking, arrays are in contiguous memory addresses
    * JVM asterisk --- In Java, arrays are objects, and objects go into the *heap*, which isn't necessarily contiguous.


Linked Structure
================

Nodes
=====


Inserting into a Linked Structure
=================================

.. image:: img/links_example1.png
   :width: 500 px
   :align: center


* Given the example linked structure
* How would you access the *first* item's data?
* How would you access the *second* item's data?
* How would you access the *third* item's data?
* How would you access the predecessor?
* **HINT:** What are the fields we would have in our node object?

* How would we add something to the *front* of this linked structure?
* How would we add something to the *middle* of this linked structure?
* How would we add something to the *end* of this linked structure?

* How would we remove something to the *front* of this linked structure?
* How would we remove something to the *middle* of this linked structure?
* How would we remove something to the *end* of this linked structure?


Adding to the Front
-------------------

.. image:: img/links_addfront0.png
   :width: 500 px
   :align: center

* Make the node we want to insert's next point to the current head

.. image:: img/links_addfront1.png
   :width: 500 px
   :align: center

* Make head, the reference to the start of the linked structure, point to the new node

.. image:: img/links_addfront2.png
   :width: 500 px
   :align: center

Adding to the Middle
--------------------

Adding to the End
-----------------

Removing from a Linked Structure
=================================

Deleting from the Front
-----------------------

Deleting from the Middle
------------------------

Deleting from the End
---------------------

Node Implementation
===================

Explore the Implementation
--------------------------



Variations
==========

* For many of the stuff we're learning, there are variations
* You may be wondering: *Can we add references going more than one direction?*
    * Absolutely

Doubly Linked
-------------



For next time
=============

* Read Chapter 4 Sections 1 -- 3
    * 7 pages
