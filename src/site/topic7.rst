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

* A _node_ is a basic unit in our linked structures
* Here we are focusing on *singly linked structures*
    * Each node has only one *link*

* The series of nodes linked together is what makes up the singly linked structure
    * They link to their successor

.. image:: img/node_example.png
   :width: 500 px
   :align: center

* A node for a singly linked structure typically has only two fields
    * **data** --- the stuff we want to hold
        * To compare to the array, this would be the stuff we're putting into the cells of the array
    * **next** --- a reference to the successor/next node
        * Arrays don't have this because the successor is just in the next index in the array
            * Asterisk


Inserting into a Linked Structure
=================================

Adding to the Front
-------------------

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
