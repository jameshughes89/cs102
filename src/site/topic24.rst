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

.. code-block:: java
    :linenos:

    public void add(T element) {
        root = add(element, root);
        size++;
    }

    private Node<T> add(T element, Node<T> current) {
        if (current == null) {
            return new Node<>(element);
        } else if (current.getData().compareTo(element) > 0) {
            current.setLeft(add(element, current.getLeft()));
        } else {
            current.setRight(add(element, current.getRight()));
        }
        return current;
    }


* We use a helper method to setup a call to the recursive method

* This method is very similar to a binary search
* Keep going left/right down the tree based on the ordering of the tree and value of the element being added
* As soon as we find an empty spot, insert the node there
* Inserted value will be in a leaf node


Minimum & Maximum
=================

.. code-block:: java
    :linenos:

    public T min() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return min(root);
    }

    private T min(Node<T> current) {
        if (current.getLeft() == null) {
            return current.getData();
        } else {
            return min(current.getLeft());
        }
    }


    public T max() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return max(root);
    }

    private T max(Node<T> current) {
        if (current.getRight() == null) {
            return current.getData();
        } else {
            return max(current.getRight());
        }
    }

* Fortunately minimum and maximum are simple
* Due to the ordered nature of the binary search tree, just go all the way to the left or right for the minimum or maximum value respectively


Remove Minimum & Maximum
========================

* Finding the minimum and maximum values in the linked binary search tree is relatively simple
* However, *removing* from the tree adds extra complexity as we need to preserve the binary search tree ordering of our tree

**Remove Minimum**

.. code-block:: java
    :linenos:

    public T removeMin() {
        T returnElement = null;
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (root.getLeft() == null) {
            returnElement = root.getData();
            root = root.getRight();
        } else {
            returnElement = removeMin(root, root.getLeft());
        }
        size--;
        return returnElement;
    }

    private T removeMin(Node<T> current, Node<T> leftChild) {
        if (leftChild.getLeft() == null) {
            current.setLeft(leftChild.getRight());
            return leftChild.getData();
        } else {
            return removeMin(current.getLeft(), leftChild.getLeft());
        }
    }

* Above are two functions that work together to remove the minimum value

* First, take note of the public method
    * It checks if the tree is empty
    * It checks if the root is the left most node
        * If it is, then make the right child the new root
    * Otherwise, call a private recursive method looking down the left subtree

* If not successful in removing the minimum yet, the recursive private method is the one that goes looking for the minimum to remove
* At this point we know that ``leftChild`` exists (is not ``null``) since this was checked in the calling method
* If the left child's left subtree does **not** exist, then we know that ``leftChild`` contains the minimum value
    * Simply replace ``current``'s left child (which ``leftChild`` also references) with ``leftChild``'s right child
        * What's interesting here is, it does not matter if the left child's right child is ``null`` or not, it works either way

* If ``leftChild``'s left child is not ``null``, then we call the recursive function again to keep looking down the left subtrees



**Remove Maximum**


General Remove
==============


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

* Above, you will see that the method is called ``contains``, and it calls the recursive ``binarySearch`` method
* What's interesting here is the helper method needs to return a boolean, but the ``binarySearch`` returns a reference to a node
* A way to address this is to simply check if ``binarySearch`` returned a reference to a node or not
    * If ``contains`` gets a node back, then we return true
    * Otherwise, if we get ``null` back, return false

* As this method is written, duplicate values are assumed to be in the right subtree


Get Count
=========



For next time
=============

* If you have not yet, look at the :download:`BinarySearchTree <../main/java/BinarySearchTree.java>` interface
* Look at the :download:`LinkedBinarySearchTree <../main/java/LinkedBinarySearchTree.java>` implementation
* Read Chapter 11 Sections 1 -- 3
    * 17 pages
