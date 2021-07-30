**************************
Topic #22 --- Binary Trees
**************************


Binary Tree Definition
======================


Traversals
==========


Pre-order
--------


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
