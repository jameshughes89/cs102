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


Remove Minimum & Maximum
========================


Contains
========


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
