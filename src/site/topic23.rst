*********************************
Topic #23 --- Binary Search Trees
*********************************

* Now that we have covered binary trees, we can look at more specific types of binary trees
    * Namely, the binary *search* tree

* Compared to a binary tree, binary *search* trees have specific properties and constraints that must be followed
* We can take advantage of these properties and constraints for extra improvements in certain functionality


Binary Search Tree Definition
=============================

* A binary *search* tree is a binary tree where:
    * All values in the left subtree are less than the value in the root node
    * All values in the right subtree are greater than or equal to the value in the root node

.. note::

    We could make the left subtree less than or equal to and the right subtree strictly greater than too. All that
    matters is that only on subtree includes the *equal to* part.

    Alternatively, we could make the right subtree exclusively greater than, but this would disallow duplicates.


.. image:: img/binarysearchtree_noyes.png
   :width: 500 px
   :align: center

* In the above example, the tree on the left is **not** a binary search tree since a value in the left subtree of the subtree with root 15 is greater than it (16)
* The left tree is an example of a binary search tree

    .. image:: img/binarysearchtree_base.png
       :width: 250 px
       :align: center

* In the above example, note that the leftmost node is the smallest value in the tree and the rightmost is the largest.


A Binary Search Tree is a Binary Tree
-------------------------------------

* A binary search tree is a special case of a binary tree
    * Therefore, it will have all the operations we would want our binary tree to have

* But we will have a few additional operations
    * Add, but based on the important ordering
    * Remove, but must preserve ordering
    * Remove max
    * Remove min


Searching a Binary Search Tree
==============================

* The special ordering property allows us to search for items within the binary search tree more efficiently than a regular search through a tree

Naive Search
------------


Binary Search
-------------


Binary Search Tree Operations
=============================


Linked Binary Search Tree
=========================


Degenerate vs. Balanced
=======================


For next time
=============

* Read Chapter 11 Sections 1 -- 3
    * 17 pages
