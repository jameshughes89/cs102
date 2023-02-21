**************************
Linked Binary Search Trees
**************************

* Given the way the binary search tree ideas were presented, a linked implementation may feel like an obvious choice

    * Though, there is nothing preventing an array based implementation


Constructors
============

.. literalinclude:: /../main/java/LinkedBinarySearchTree.java
    :language: java
    :lineno-match:
    :lines: 1-20


* Like the other implementations, this class ``implement`` the interface
* The data structure is to be generic
* Like the sorted bag, since it is concerned with the ordering, ensure that the objects are comparable

* There is a single constructor to create an empty binary search tree



Static Node Class
=================

* Notice the use of ``Node<T> root``
* Like the linked stack and linked queue, this linked binary search tree will make use of nodes
* To keep things clean, a nested node class is used

.. literalinclude:: /../main/java/LinkedBinarySearchTree.java
    :language: java
    :lineno-match:
    :lines: 447-491

* Things of note for this node class

    * This is a binary tree node, thus it has a left and right reference for the left and right subtrees
    * This nested static class is contained within the ``LinkedBinarySearchTree`` class



Add to Binary Search Tree
=========================

.. literalinclude:: /../main/java/LinkedBinarySearchTree.java
    :language: java
    :lineno-match:
    :lines: 15-40


* A public helper method is used to setup a call to the private recursive add

* This method is very similar to a binary search
* Keep going left/right down the tree based on the ordering of the tree and value of the element being added
* As soon as an empty spot is found, insert the node there
* The inserted value will be in a leaf node


Minimum & Maximum
=================

.. literalinclude:: /../main/java/LinkedBinarySearchTree.java
    :language: java
    :lineno-match:
    :lines: 191-228


* Fortunately the minimum and maximum methods are simple
* Due to the ordered nature of the binary search tree, go all the way to the left/right for the minimum/maximum value

* The minimum functionality is implemented recursively and the maximum is implemented iteratively

    * This is done for demonstration purposes only




Remove Minimum & Maximum
========================

* Finding the minimum and maximum values in the linked binary search tree is relatively simple
* However, *removing* from the tree adds extra complexity as there is a need to preserve the binary search tree ordering of the tree


Remove Minimum
--------------

.. literalinclude:: /../main/java/LinkedBinarySearchTree.java
    :language: java
    :lineno-match:
    :lines: 130-159


* Above are two functions that work together to remove the minimum value

* First, take note of the public method

    * It checks if the tree is empty
    * It checks if the root happens to be the left most node

        * If it is, then make the root's right child the new root of the whole tree


    * Otherwise, call the private recursive method looking down the left subtree


* If the public method doesn't remove the minimum, the recursive private method is the one that goes looking for the minimum to remove
* At this point, ``current`` exists (is not ``null``) since this was checked in the calling method

    * Remember, if the root's left child does not exist, then the root must contain the minimum value in the tree


* Start with the recursive case --- if ``current``'s left child does exist, then call the recursive function again to keep looking down the left subtrees

* If ``current``'s left subtree does **not** exist, then ``current`` contains the minimum value

    * Simply replace ``parent``'s left child (which ``current`` also references) with ``current``'s right child

        * It does not matter if ``current``'s right child is ``null`` or not, it works either way



Remove Maximum
--------------

* ``removeMax`` could be implemented with the same recursive idea as ``removeMin``
* However, for demonstration purposes, an iterative method is used instead

.. literalinclude:: /../main/java/LinkedBinarySearchTree.java
    :language: java
    :lineno-match:
    :lines: 161-189


* ``removeMax`` is similar to the public ``removeMin`` method

    * Check if the root exists
    * Check if the root's right exists


* It's the else case that's different
* The idea is, loop down to the right until there is no more right children
* Then, once the right most node is found, set it's ``parent``'s right child to the node being removed's left child

    * Again, it doesn't matter if the left child is ``null`` or not



General Remove
==============

* This is probably the most complex functionality discussed this course
* To help, the discussion will be broken up

.. literalinclude:: /../main/java/LinkedBinarySearchTree.java
    :language: java
    :lineno-match:
    :lines: 42-59


* The public ``remove`` method is similar to the public ``removeMin`` and ``removeMax``
* It checks the root node to see if it is the value to be removed
* Otherwise, it checks which subtree to continue the search down and calls the recursive private ``remove``


.. literalinclude:: /../main/java/LinkedBinarySearchTree.java
    :language: java
    :lineno-match:
    :lines: 61-86


* The private ``remove`` is basically doing a binary search through the tree looking for the value to be removed
* Unlike the binary search however, this method must

    * Remove the element
    * Potentially address a gap in the tree if the node being removed is an internal node
    * Ensure the binary search tree ordering is preserved


* To do this, another private method called ``findReplacementNode`` is used

.. literalinclude:: /../main/java/LinkedBinarySearchTree.java
    :language: java
    :lineno-match:
    :lines: 88-128


* ``findReplacementNode`` looks rather intimidating at first, but if studied carefully, it is actually rather simple

* The first part, the first ``if`` s and ``else if`` s check if the node being removed is a leaf node, or if it has one child

    * If it's a leaf node, there is no replacement
    * If there is only one child, then that child becomes the replacement


* The other case is when there are two children
* Here, the idea is to find the in order successor node

    * The right child's left most node


* This code is very similar to the private ``removeMax`` method

    * Iterate down the tree until the left most node in the subtree is found
    * This node will become the replacement node


* The replacement node's left subtree will be the removed node's old left subtree

    * The replacement node contains the smallest thing in the whole right subtree
    * But since it is in the right subtree, it is bigger than everything in the removed node's left subtree


* If it happens that the node being removed's right child is the replacement node, then done
* If it is *not* the right child, then

    * The replacement node's parent may need to take care of the replacement node's right subtree
    * The node being removed may have a right subtree, that when all is said and done, still needs to go somewhere


* The idea is, since the parent to the replacement node must be larger than everything in its left subtree, the replacement node's right subtree is also less than the parent

    * Therefore, make the parent node's new left subtree the replacement node's right subtree


* Since the replacement node is the smallest thing in the right subtree, the replacement node's right subtree can be made to be the removed node's right subtree



``contains``
============

* All data structures implemented have a way to check if a given element is contained within it
* The binary search tree is no different, but here a linear search will not be used
* Instead, make use of a binary search to help find the element within the data structure

.. literalinclude:: /../main/java/LinkedBinarySearchTree.java
    :language: java
    :lineno-match:
    :lines: 230-256


* See the above method called ``contains`` and the recursive ``binarySearch`` method
* What's interesting here is the helper method needs to return a boolean, but the ``binarySearch`` returns a reference to a node
* A way to address this is to simply check if ``binarySearch`` returned a reference to a node or not

    * If ``contains`` gets a node back, then return ``true``
    * Otherwise, if ``null``, return ``false``


* As this method is written, duplicate values are assumed to be in the right subtree


``count``
=========

.. literalinclude:: /../main/java/LinkedBinarySearchTree.java
    :language: java
    :lineno-match:
    :lines: 258-286
    :emphasize-lines: 21, 22, 23


* Counting the number of times a given element exists within the tree will be similar to a binary search
* The key difference will be, do a binary search, but if the element is found, continue looking in the subtree where duplicates are added

* Notice the line ``return 1 + count(element, current.getRight())``

    * This continues the search to the right
    * Whatever the result of the search down the right subtree returns, add one to it before returning


For Next Time
=============

* Read Chapter 11 Sections 1 -- 3

    * 17 pages


Playing Code
------------

* Download and play with

    * :download:`BinarySearchTree </../main/java/BinarySearchTree.java>`
    * :download:`LinkedBinarySearchTree </../main/java/LinkedBinarySearchTree.java>`
