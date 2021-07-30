**************************
Topic #22 --- Binary Trees
**************************

* A general **tree** is one where each node can have any number of children

* An **n-ary** tree is one where each node has no more than :math:`n` children


Binary Tree Definition
======================

.. image:: img/binarytree_example.png
   :width: 500 px
   :align: center

* A **binary** tree is one where each node has no more than two (2) children
    * 2-ary tree
    * Tree with a degree/arity of 2

* If a node has children, they are referred to as the *left* and *right* children
    * Which are also referred to as the left and right subtrees
    * In the above example, *B* is the left subtree and *C* is the right subtree of *A*

* In a binary tree, position matters --- it matters if a subtree is the left or right

* A recursive definition of a binary tree is
    * An empty tree
    * Or, a tree that has a root whose left and right subtrees are binary trees

.. admonition::

   Based on this information, what would a *unary* tree be?


Traversals
==========


Pre-order
--------


In-order
-------


Post-order
---------


Level-order
-----------


Iterative Pre/In/Post-Order
---------------------------


Traversal Analysis
------------------

.. image:: img/binarytree_example.png
   :width: 500 px
   :align: center

* Consider a binary tree with :math:`n` nodes
* Without getting too deep into analysis territory, if we want to traverse all :math:`n` nodes, what is the computational complexity of
    * pre-order traversal?
    * in-order traversal?
    * post-order traversal?
    * level-order traversal?

* Intuitively, they're all :math:`O(n)` since we will need to visit each node once and only once

* If I change the question slightly, consider a binary tree with **height** :math:`h`
    * What is the computational complexity of the traversals?

* :math:`O(2^{h})`
* Why?
* Consider the relationship between the height of a binary tree and the number of nodes within the tree  

Interface
=========


Implementation
==============


Linked Implementation
---------------------


Binary Tree Node
^^^^^^^^^^^^^^^^


Linked Binary Tree
^^^^^^^^^^^^^^^^^^


For next time
=============

* Have a look at the :download:`BinaryTree <../main/java/BinaryTree.java>` interface
* Read Chapter 10 Sections 4 -- 7
    * 34 pages (mostly code though)
