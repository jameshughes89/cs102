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

.. image:: img/links_example1.png
   :width: 500 px
   :align: center

* With a simple linear structure, the order in which you traverse the nodes is rather natural
* Start at one end and go to the other
* For example, start at the head node and visit each node's next

* We could define other traversal orders if we wanted to, but that would be atypical

.. image:: img/binarytree_example.png
   :width: 500 px
   :align: center

* With a nonlinear data structure like a binary tree, the order to traverse the nodes in is not immediately obvious
* We have a few common options to choose from


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

* An in-order traversal is another common traversal
* The general idea is
    * Start at the root
    * Go to the left child, *Access the node*, then the right child

* To get more precise in a recursive definition

* **Inorder Traversal**
    * If the (sub)tree is not empty
        * Do an **Inorder Traversal** on the left subtree
        * Access the root of the (sub)tree
        * Do an **Inorder Traversal** on the right subtree

* Notice that the root of the (sub)tree is accessed *in* between any recursive calls

.. image:: img/binarytree_example.png
   :width: 500 px
   :align: center

* With the definition of a in-order traversal, what order would the nodes be visited?

    ``D, H, B, E, A, I, F, C, G``


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
