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


Post-order
---------

* Take a wild guess at what this one will be

* A post-order traversal is another traversal
* The general idea is
    * Start at the root
    * Go to the left child, then the right child, then *Access the node*,

* To get more precise in a recursive definition

* **Postorder Traversal**
    * If the (sub)tree is not empty
        * Do an **Postorder Traversal** on the left subtree
        * Do an **Postorder Traversal** on the right subtree
        * Access the root of the (sub)tree

* Notice that the root of the (sub)tree is accessed after (*post-*) any recursive calls

.. image:: img/binarytree_example.png
   :width: 500 px
   :align: center

* With the definition of a post-order traversal, what order would the nodes be visited?

    ``H, D, E, B, I, F, G, C, A``


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
