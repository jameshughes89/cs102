************
Binary Trees
************

* Refer to the topic pages for this lab
    * You will find many of the answers to your questions there
* Feel free to use your laptop if you have it
* I strongly encourage you to work with others in the lab
* Ensure I have recorded your completion. Failure to do so will result in a grade of 0
* When you get stuck, do me a favour and ask those sitting around you for help
    * I want people to get used to working together in the labs
    * Peer teaching and peer learning is super effective

.. Note::

    We are simply playing with binary nodes in this lab and not a tree class, nor are we creating a tree class. We
    are, however, still making a tree with these nodes.


Draw The Tree
=============

1. Get a piece of paper
2. Draw the tree that the following code generates
3. Keep the paper to scratch other ideas down throughout the lab

.. code-block:: java

    public static void main(String[] args){
        BinaryNode<Integer> root = new BinaryNode<>(6);

        root.setLeft(new BinaryNode<>(2));
        root.setRight(new BinaryNode<>(8));

        root.getLeft().setLeft(new BinaryNode<>(1));
        root.getLeft().setRight(new BinaryNode<>(4));

        root.getRight().setLeft(new BinaryNode<>(7));
        root.getRight().setRight(new BinaryNode<>(9));

        root.getLeft().getRight().setLeft(new BinaryNode<>(3));
        root.getLeft().getRight().setRight(new BinaryNode<>(5));
    }


Binary Node
===========

1. Create a project
2. Create a ``BinaryNode`` class
    * This can be taken from the :download:`LinkedBinarySearchTree <../../../main/java/LinkedBinarySearchTree.java>` class since the static inner class is for binary nodes
    * Just note that you will have to change the class name from ``Node`` to ``BinaryNode``

3. Make sure it's all working by running the above provided ``main`` method for generating the tree


In-Order Traversal
==================

1. Create a recursive ``inOrderTraversal``
    * :ref:`Review the traversals if you do not remember what an inorder traversal is <label-topic22-binary_trees-traversals>`

.. code-block:: java

    public static <T> void inOrderTraversal(BinaryNode<T> current){
        // Fill me in
    }


Number of Nodes
===============

1. Write a recursive ``numberOfNodes`` method to count the number of nodes within the tree

.. code-block:: java

    public static <T> int numberOfNodes(BinaryNode<T> current){
        // Fill me in
    }


Depth
=====

1. Write a recursive ``treeDepth`` method to calculate the depth of the tree
    * :ref:`Be sure to remember the definition of the height of a tree <label-topic21-trees-properties>`
    * Check out ``Math.max``

.. code-block:: java

    public static <T> int treeDepth(BinaryNode<T> current){
        // Fill me in
    }


Balanced
========

.. warning::

    Many will find this method much more challenging than the previous few. Feel free to jump to the Kattis problems
    if you find yourself stuck.


1. Write a recursive ``isBalanced`` method to determine if a given tree is balanced
    * :ref:`Be sure to know the definition of a balanced tree <label-topic23-binary_search_trees-balanced>`


.. code-block:: java

    public static <T> boolean isBalanced(BinaryNode<T> current){
        // Fill me in
    }


Kattis Problems
===============

Recommended Kattis Problems (don't worry, you don’t need to do all of them or anything):

1. https://open.kattis.com/problems/quadrant
2. https://open.kattis.com/problems/judgingmoose
3. https://open.kattis.com/problems/timeloop
4. https://open.kattis.com/problems/oddities
5. https://open.kattis.com/problems/fizzbuzz
6. https://open.kattis.com/problems/twostones
7. https://open.kattis.com/problems/spavanac
8. https://open.kattis.com/problems/cetvrta
9. https://open.kattis.com/problems/bus
10. https://open.kattis.com/problems/timeloop
11. https://open.kattis.com/problems/oddities
12. https://open.kattis.com/problems/fizzbuzz
13. https://open.kattis.com/problems/sibice
14. https://open.kattis.com/problems/datum
15. https://open.kattis.com/problems/dicecup
16. https://open.kattis.com/problems/autori
17. https://open.kattis.com/problems/apaxiaaans
18. https://open.kattis.com/problems/hissingmicrophone
19. https://open.kattis.com/problems/trik
20. https://open.kattis.com/problems/pot
21. https://open.kattis.com/problems/filip
22. https://open.kattis.com/problems/reversebinary
23. https://open.kattis.com/problems/sevenwonders
24. https://open.kattis.com/problems/zamka
25. https://open.kattis.com/problems/bijele
26. https://open.kattis.com/problems/cold
27. https://open.kattis.com/problems/nastyhacks
28. https://open.kattis.com/problems/grassseed
29. https://open.kattis.com/problems/pet
30. https://open.kattis.com/problems/batterup
31. https://open.kattis.com/problems/aboveaverage
32. https://open.kattis.com/problems/icpcawards
33. https://open.kattis.com/problems/quickbrownfox
34. https://open.kattis.com/problems/nodup
35. https://open.kattis.com/problems/conundrum
36. https://open.kattis.com/problems/bela
37. https://open.kattis.com/problems/kornislav
