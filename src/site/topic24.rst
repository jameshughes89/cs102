****************************************
Topic #24 --- Linked Binary Search Trees
****************************************

* Since we know the idea behind the binary search tree, we can now implement one
* Given the way the binary search tree ideas were presented, a linked implementation may feel like an obvious choice
    * Though, there is nothing stopping us from implementing one with an array


Constructors
============

.. code-block:: java
    :linenos:

    import java.util.Iterator;
    import java.util.NoSuchElementException;

    public class LinkedBinarySearchTree<T extends Comparable<? super T>> implements BinarySearchTree<T> {

        private int size;
        private Node<T> root;

        public LinkedBinarySearchTree() {
            root = null;
            size = 0;
        }

        public LinkedBinarySearchTree(T element) {
            this();
            add(element);
        }

* Like the other implementations, we will be sure to ``implement`` the interface
* We want the data structure to be generic
* And, like the sorted bag, since we are concerned with the ordering, we will ensure that our objects are comparable

* Here we have two constructors
    * A default constructor, which just sets up an empty binary search tree
    * A constructor that we could give an element to be the tree's root
        * This constructor is probably unnecessary, but let's keep it


Static Node Class
=================

* You likely noticed the use of ``Node<T> root``
* Like the linked stack and linked queue, we will make use of nodes
* You may remember that we had two options for doing this
    1. Simply create a top level node class
    2. Create a :doc:`nested node class aside. </topic8-nested>`

* To keep things clean, we will go with option #2

.. code-block:: java
    :linenos:

    // This class exists within the LinkedBinarySearchTree class
    private static class Node<T> {

        private T data;
        private Node<T> left;
        private Node<T> right;

        private Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        private T getData() {
            return data;
        }

        private void setData(T data) {
            this.data = data;
        }

        private Node<T> getLeft() {
            return left;
        }

        private void setLeft(Node<T> left) {
            this.left = left;
        }

        private Node<T> getRight() {
            return right;
        }

        private void setRight(Node<T> right) {
            this.right = right;
        }
    }


* Things of note for this node class
    * This is a binary tree node, thus it has a left and right reference for the left and right subtrees
    * This nested static class is contained within the ``LinkedBinarySearchTree`` class


Add to Binary Search Tree
=========================


Minimum & Maximum
=================


Remove Minimum & Maximum
========================


Contains
========

* All data structures we've implemented have a way to check if a given element is within it
* The binary search tree is no different, but here we do not need to do a linear search
* Here, we can make use of a binary search to help find the element within the data structure

.. code-block:: java
    :linenos:

    public boolean contains(T element) {
        return binarySearch(element, root) != null;
    }

    private Node<T> binarySearch(T element, Node<T> current) {
        if (current == null) {
            return null;
        } else if (current.getData().equals(element)) {
            return current;
        } else {
            if (current.getData().compareTo(element) > 0) {
                return binarySearch(element, current.getLeft());
            } else {
                return binarySearch(element, current.getRight());
            }
        }
    }

Get Count
=========


Traversals
==========


For next time
=============

* If you have not yet, look at the :download:`BinarySearchTree <../main/java/BinarySearchTree.java>` interface
* Look at the :download:`LinkedBinarySearchTree <../main/java/LinkedBinarySearchTree.java>` implementation
* Read Chapter 11 Sections 1 -- 3
    * 17 pages
