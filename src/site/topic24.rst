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
    * It checks if the root happens to be the left most node
        * If it is, then make the root's right child the new root of the whole tree
    * Otherwise, call the private recursive method looking down the left subtree

* If the public method doesn't remove the minimum, the recursive private method is the one that goes looking for the minimum to remove
* At this point we know that ``leftChild`` exists (is not ``null``) since this was checked in the calling method
    * Remember, if the root's left child does not exist, then the root must contain the minimum value in the tree

* We'll start with the recursive case --- if ``leftChild``'s left child does exist, then we call the recursive function again to keep looking down the left subtrees

* If ``LeftChild``'s left subtree does **not** exist, then we know that ``leftChild`` contains the minimum value
    * Simply replace ``current``'s left child (which ``leftChild`` also references) with ``leftChild``'s right child
        * It does not matter if the left child's right child is ``null`` or not, it works either way


**Remove Maximum**

* We could implement the ``removeMax`` with the same idea, but to show an alternative idea, an iterative method will be used instead

.. code-block:: java
    :linenos:

    public T removeMax() {
        T returnElement = null;
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (root.getRight() == null) {
            returnElement = root.getData();
            root = root.getLeft();
        } else {
            Node<T> parent = root;
            Node<T> rightChild = root.getRight();

            // Iterate right until we find the right most node
            while (rightChild.getRight() != null) {
                parent = rightChild;
                rightChild = rightChild.getRight();
            }
            returnElement = rightChild.getData();
            parent.setRight(rightChild.getLeft());
        }
        size--;
        return returnElement;
    }

* ``removeMax`` is similar to the public ``removeMin`` method
    * Check if the root exists
    * Check if the root's right exists

* It's the else case that's different
* The idea is, loop down to the right until there is no more right children
* Then, once we find the right most node, set it's ``parent``'s right child to the node being removed's left child
    * Again, it doesn't matter if the left child is ``null`` or not


General Remove
==============

* This is probably the most complex functionality we will discuss
* To help, the discussion will be broken up

.. code-block:: java
    :linenos:

    public T remove(T element) {
        T returnElement = null;
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (root.getData().equals(element)) {
            returnElement = root.getData();
            root = findReplacementNode(root);
        } else if (root.getData().compareTo(element) > 0) {
            returnElement = remove(element, root, root.getLeft());
        } else {
            returnElement = remove(element, root, root.getRight());
        }
        size--;
        return returnElement;
    }

* The public ``remove`` method is similar to the public ``removeMin`` and ``removeMax``
* It checks the root node to see if it is the value to be removed
* Otherwise, it checks which subtree to continue the search down and calls the recursive private ``remove``


.. code-block:: java
    :linenos:

    private T remove(T element, Node<T> parent, Node<T> child) {
        if (child == null) {
            throw new NoSuchElementException();
        } else if (child.getData().equals(element)) {
            if (parent.getData().compareTo(element) > 0) {
                parent.setLeft(findReplacementNode(child));
            } else {
                parent.setRight(findReplacementNode(child));
            }
            return child.getData();
        } else if (child.getData().compareTo(element) > 0) {
            return remove(element, child, child.getLeft());
        } else {
            return remove(element, child, child.getRight());
        }
    }

* The private ``remove`` is basically doing a binary search through the tree looking for the value to be removed
* Unlike the binary search however, this method must
    * Remove the element
    * Potentially address a gap in the tree if the node being removed is an internal node
    * Ensure the binary search tree ordering is preserved

* To do this, we make use of another private method called ``findReplacementNode``


.. code-block:: java
    :linenos:

    private Node<T> findReplacementNode(Node<T> toRemove) {
        Node<T> replacementNode = null;
        if (toRemove.getLeft() == null && toRemove.getRight() == null) {
            replacementNode = null;
        } else if (toRemove.getLeft() != null && toRemove.getRight() == null) {
            replacementNode = toRemove.getLeft();
        } else if (toRemove.getLeft() == null && toRemove.getRight() != null) {
            replacementNode = toRemove.getRight();
        } else {
            Node<T> parent = toRemove;
            Node<T> child = toRemove.getRight();

            // Find the in order successor (right child's left
            // most node (minimum node))
            while (child.getLeft() != null) {
                parent = child;
                child = child.getLeft();
            }

            // Set replacement node's left to
            // the node being removed's (subtree root's) left
            child.setLeft(toRemove.getLeft());

            // If the immediate in order successor is NOT the
            // node being replaced's right child, the parent
            // node's new left becomes the child node's right
            // and the child node's right is replaced with
            // the node being replaced's right
            if (toRemove.getRight() != child) {
                parent.setLeft(child.getRight());
                child.setRight(toRemove.getRight());
            }
            replacementNode = child;
        }
        return replacementNode;
    }

* ``findReplacementNode`` looks rather intimidating at first, but it you take your time looking at it, you will see that it's simple
* The first part, the first ``if`` s and ``else if``s check if the node being removed is a leaf node, or if it has one child
    * If it's a leaf node, there is no replacement
    * If there is only one child, then that child becomes the replacement

* The other case is when there are two children
* Here, the idea is to find the in order successor node
    * The right child's left most node

* You may see that this code is very similar to the private ``removeMax`` method
    * Iterate down the tree until we find the left most node in the subtree
    * This node will become the replacement node

* The replacement node's left subtree will be the removed node's old left subtree
    * The replacement node contains the smallest thing in the whole right subtree
    * But since it is in the right subtree, it is bigger than everything in the removed node's left subtree

* If it happens that the node being removed's right child is the replacement node, we're done

* If it is *not* the right child, then
    * The replacement node's parent may need to take care of the replacement node's right subtree
    * The node being removed may have a right subtree, when all is said and done, that still needs to go somewhere

* The idea is, since the parent to the replacement node must be larger than everything in its left subtree, the replacement node's right subtree is also less than the parent
    * Therefore, make the parent node's new left subtree the replacement node's right subtree

* Since we know that the replacement node is the smallest thing in the right subtree, we know we can make the replacement node's right subtree the removed node's right subtree


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
    * Otherwise, if we get ``null`` back, return false

* As this method is written, duplicate values are assumed to be in the right subtree


Get Count
=========

.. code-block:: java
    :linenos:
    :emphasize-lines: 12, 13

    public int getCount(T element) {
        if (isEmpty()) {
            return 0;
        }
        return getCount(element, root);
    }

    private int getCount(T element, Node<T> current) {
        if (current == null) {
            return 0;
        }
        if (current.getData().equals(element)) {
            return 1 + getCount(element, current.getRight());
        } else if (current.getData().compareTo(element) > 0) {
            return getCount(element, current.getLeft());
        } else {
            return getCount(element, current.getRight());
        }
    }

* Counting the number of times a given element exists within the tree will be similar to a binary search
* The key difference will be, do a binary search, but if you find what you're looking for, continue looking in the subtree where duplicates are placed
* The below example assumes duplicate values go to the right
* Notice the line ``return 1 + getCount(element, current.getRight())`` for when we find what we're looking for
    * This continues the search to the right
    * But whatever the result of the search down the right subtree returns, we add one to it before we return


For next time
=============

* If you have not yet, look at the :download:`BinarySearchTree <../main/java/BinarySearchTree.java>` interface
* Look at the :download:`LinkedBinarySearchTree <../main/java/LinkedBinarySearchTree.java>` implementation
* Read Chapter 11 Sections 1 -- 3
    * 17 pages
