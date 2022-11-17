************
Binary Trees
************

* Feel free to use your laptop if you have it
* I strongly encourage you to work with others in the lab

    * When you get stuck, do me a favour and ask those sitting around you for help
    * I want people to get used to working together in the labs
    * Peer teaching and peer learning is super effective

.. Note::

    We are simply playing with binary nodes in this lab and not a tree class, nor are we creating a tree class. We
    are, however, still making a tree with these nodes.


Draw The Tree
=============

#. Get a piece of paper.

#. Draw the tree that the following code generates.

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

#. Keep the paper to scratch other ideas down throughout the lab.


Binary Node
===========

#. Create a project.

#. Create a ``BinaryNode`` class.

    * This can be taken from the :download:`LinkedBinarySearchTree <../../../main/java/LinkedBinarySearchTree.java>` class since the static inner class is for binary nodes
    * Just note that you will have to change the class name from ``Node`` to ``BinaryNode``

#. Make sure it's all working by running the above provided ``main`` method for generating the tree.


In-Order Traversal
==================

#. Create a recursive ``inOrderTraversal``.

    * :ref:`Review the traversals if you do not remember what an inorder traversal is <label-binary_trees-traversals>`

    .. code-block:: java

        public static <T> void inOrderTraversal(BinaryNode<T> current){
            // Fill me in
        }


Number of Nodes
===============

#. Write a recursive ``numberOfNodes`` method to count the number of nodes within the tree.

    .. code-block:: java

        public static <T> int numberOfNodes(BinaryNode<T> current){
            // Fill me in
        }


Depth
=====

#. Write a recursive ``treeDepth`` method to calculate the depth of the tree.

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
    if you find yourself getting frustrated.


#. Write a recursive ``isBalanced`` method to determine if a given tree is balanced.

    * :ref:`Be sure to know the definition of a balanced tree <label-binary_search_trees-balanced>`


    .. code-block:: java

        public static <T> boolean isBalanced(BinaryNode<T> current){
            // Fill me in
        }


Kattis Problems
===============

Recommended Kattis Problems (don't worry, you don’t need to do all of them or anything):

#. https://open.kattis.com/problems/quadrant
#. https://open.kattis.com/problems/judgingmoose
#. https://open.kattis.com/problems/timeloop
#. https://open.kattis.com/problems/oddities
#. https://open.kattis.com/problems/fizzbuzz
#. https://open.kattis.com/problems/twostones
#. https://open.kattis.com/problems/spavanac
#. https://open.kattis.com/problems/cetvrta
#. https://open.kattis.com/problems/bus
#. https://open.kattis.com/problems/timeloop
#. https://open.kattis.com/problems/oddities
#. https://open.kattis.com/problems/fizzbuzz
#. https://open.kattis.com/problems/sibice
#. https://open.kattis.com/problems/datum
#. https://open.kattis.com/problems/dicecup
#. https://open.kattis.com/problems/autori
#. https://open.kattis.com/problems/apaxiaaans
#. https://open.kattis.com/problems/hissingmicrophone
#. https://open.kattis.com/problems/trik
#. https://open.kattis.com/problems/pot
#. https://open.kattis.com/problems/filip
#. https://open.kattis.com/problems/reversebinary
#. https://open.kattis.com/problems/sevenwonders
#. https://open.kattis.com/problems/zamka
#. https://open.kattis.com/problems/bijele
#. https://open.kattis.com/problems/cold
#. https://open.kattis.com/problems/nastyhacks
#. https://open.kattis.com/problems/grassseed
#. https://open.kattis.com/problems/pet
#. https://open.kattis.com/problems/batterup
#. https://open.kattis.com/problems/aboveaverage
#. https://open.kattis.com/problems/icpcawards
#. https://open.kattis.com/problems/quickbrownfox
#. https://open.kattis.com/problems/nodup
#. https://open.kattis.com/problems/conundrum
#. https://open.kattis.com/problems/bela
#. https://open.kattis.com/problems/kornislav