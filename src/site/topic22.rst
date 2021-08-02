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


Level-order
-----------

* A level-order traversal is a little different when compared to the others
* The search doesn't work it's way down each breanch of the tree one by one
* Instead, it traverses the *breadth* of the tree on the way down all branches

* The idea is
    * Start at the root
    * Visit the nodes in each level from left to right

* With this idea, there is no immediately obvious recursive definition of this traversal
* An iterative definition of the traversal is perhaps simpler to derive

* **Levelorder Traversal**
    * If it exists, add the root to a *queue*
    * While the queue is not empty
        * Dequeue a node
        * Access the dequeued node
        * If it exists, enqueue the left child
        * If it exists, enqueue the right child


.. image:: img/binarytree_example.png
   :width: 500 px
   :align: center

* With the definition of a level-order traversal, what order would the nodes be visited?

    ``A, B, C, D, E, F, G, H, I``


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
