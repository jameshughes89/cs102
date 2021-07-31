**************************
Topic #22 --- Binary Trees
**************************


Binary Tree Definition
======================


Traversals
==========


Pre-order
--------

* A pre-order traversal is a common order to traverse a binary tree
* The general idea is
    * Start at the root
    * *Access the node*, then go to the left child, then the right child

* To get more precise in a recursive definition

* **Preorder Traversal**
    * If the (sub)tree is not empty
        * Access the root of the (sub)tree
        * Do a **Preorder Traversal** on the left subtree
        * Do a **Preorder Traversal** on the right subtree

* Notice that the root of the (sub)tree is accessed before (*pre-*) any recursive calls

.. image:: img/binarytree_example.png
   :width: 500 px
   :align: center

* With the definition of a pre-order traversal, what order would the nodes be visited?

    ``A, B, D, H, E, C, F, I, G``


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
