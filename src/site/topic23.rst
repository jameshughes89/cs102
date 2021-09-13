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
* For this section, we will assume we are using a linked implementation of a binary search tree
    * More on this below

Naive Search
------------

* Since the binary search tree is a binary tree, we could use the search presented in the previous topic
* Remember that this search strategy has a computational complexity of :math:`O(n)`, where :math:`n` is the number of nodes in the tree

.. code-block:: java
    :linenos:

    public boolean contains(T needle) {
        return contains(root, needle);
    }

    private boolean contains(Node<T> current, T needle) {
        if (current == null) {
            return false;
        } else if (current.getData().equals(needle)) {
            return true;
        } else {
            return contains(current.getLeft(), needle) || contains(current.getRight(), needle);
        }
    }


Binary Search
-------------

.. image:: img/binarysearchtree_binarysearch0.png
   :width: 250 px
   :align: center

* Consider the above binary search tree
* Based on the special ordering binary search trees have, can you devise an improved search?
    * **Hint:** If I am looking for a number greater than 14, which subtree must the element be in if it exists in the tree?

.. code-block:: java
    :linenos:

    public boolean contains(T needle) {
        return binarySearch(root, needle) != null;
    }

    private boolean binaryContains(Node<T> current, T needle) {
        if (current == null) {
            return false;
        } else if (current.getData().equals(needle)) {
            return true;
        } else {
            if (current.getData().compareTo(needle) > 0) {
                return binarySearch(current.getLeft(), needle);
            } else {
                return binarySearch(current.getRight(), needle);
            }
        }
    }

* Notice the similarity between the naive search and the binary search
* They are nearly the same, except you will notice that, the naive search may search both subtrees
* However, binary search will only ever travel down one subtree due to the ``if (current.getData().compareTo(needle) > 0) `` statement

.. image:: img/binarysearchtree_binarysearch1.png
   :width: 250 px
   :align: center

* In the above example, if we search for the number 12, we can conclude that it exist in the tree since
    * 12 is less than 14, so it must be in the left subtree of the node containing 14
    * 12 is greater than 8, thus it must be in the right subtree
    * 12 is equal to 12, therefore we conclude that we found it

* If, however, we search for the number 13, we can conclude that it must not exist in the tree since
    * 13 is less than 14, so it must be in the left subtree of the node containing 14
    * 13 is greater than 8, thus it must be in the right subtree
    * 13 is greater than 12, therefore it must be in the right subtree
    * 12 has no right subtree, therefore 13 must **not** be in the tree

.. image:: img/binarysearchtree_binarysearch2.png
   :width: 250 px
   :align: center

* In the above example here, if we are searching for the number 22, we can conclude that it must not be in the tree since
    * 22 is greater than 14, so go right
    * 22 is less than 26, go left
    * 22 is greater than 19, so go right
    * 22 is less than 23, so go left
    * 23 has no left subtree, therefore 22 must **not** be in the tree


Binary Search Tree Operations
=============================

* Like most collections we've seen so far, we will want to be able to get the number of elements in it, check if it's empty, and get iterators
    * By this stage these should be simple

* We'll want to add and remove elements too, but this is where the complexity comes in


Add
---

* Adding is going to be similar to a binary search
* We do a binary search until there is no child
    * Assuming we allow duplicates
    * And elements we want to add that are equal to a given node go to the right subtree
    * If we ever find an element that is equal, we continue the search in the right subtree

* Insert the element where the child does not exist
* New nodes will be added as a leaf

* **In English, add would look something like this**
    * If the root of the (sub)tree is empty
        * Insert new node here with the data
    * If (sub)tree is not empty
        * If the element is less than the root of the (sub)tree, call **add** on left subtree
        * If the element is greater than or equal to the root of the (sub)tree, call **add** on right subtree

* Given the above pseudocode, consider adding 13 to the binary search tree

.. image:: img/binarysearchtree_add0.png
   :width: 250 px
   :align: center

* Starting with an empty tree, follow the pseudocode to add the following 6 elements

.. image:: img/binarysearchtree_add1.png
   :width: 250 px
   :align: center


Min & Remove Min
----------------

* Given the nature of the binary search tree ordering, the node with the minimum element **must** be in the leftmost node in the tree
* There are three cases we'll have to take care of when looking for the minimum node
    1. The leftmost node is a leaf node
    2. The leftmost node is an interior node
    3. The leftmost node is the root


Max & Remove Max
----------------


General Remove
--------------


Contains
--------


Counting the Number of a Given Element
--------------------------------------



Linked Binary Search Tree
=========================


Degenerate vs. Balanced
=======================


For next time
=============

* Have a look at the :download:`BinarySearchTree <../main/java/BinarySearchTree.java>` interface
* Have a look at the :download:`LinkedBinarySearchTree <../main/java/LinkedBinarySearchTree.java>` implementation
* Read Chapter 11 Sections 1 -- 3
    * 17 pages
