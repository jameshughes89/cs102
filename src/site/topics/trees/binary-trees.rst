************
Binary Trees
************

* A general **tree** is one where each node can have any number of children
* An **n-ary** tree is one where each node has no more than :math:`n` children


Binary Tree Definition
======================

.. figure:: binary_tree_example.png
    :width: 500 px
    :align: center

    Binary tree containing nine (9) nodes. Each node has no more than two (2) children. The left/right position of child
    nodes is important for binary trees.


* A **binary** tree is one where each node has no more than two (2) children

    * 2-ary tree
    * Tree with a degree/arity of 2


* If a node has children, they are referred to as the *left* and *right* children

    * Which are also referred to as the left and right subtrees
    * In the above example, *B* is the left subtree and *C* is the right subtree of *A*


* In a binary tree, position matters

    * It matters if a subtree is the left or right


* A recursive definition of a binary tree is

    * An empty tree
    * Or, a tree that has a root whose left and right subtrees are binary trees


.. note::

   Based on this information, what would a *unary* tree be?



.. _label-binary_trees-traversals:

Traversals
==========

.. figure:: /topics/linked-structures/example1.png
    :width: 500 px
    :align: center

    A linear linked structure of singly linked nodes.


* With a simple linear structure, the order in which the nodes are traversed is rather natural

    * Start at one end and go to the other
    * For example, start at the head node and visit each node's next until there are no more nodes


* Other traversal orders could be defined for linear collections if desired, but that would be atypical


.. figure:: binary_tree_example.png
    :width: 500 px
    :align: center

    A nonlinear linked structure --- a binary tree.


* With a nonlinear data structure like a binary tree, the order to traverse the nodes in is not immediately obvious
* There are a few common options to choose from


Pre-order
---------

* A pre-order traversal is a common order to traverse a binary tree
* The general idea is

    * Start at the root
    * *Access the node*, then go to the left child, then the right child


* To get more precise in a recursive definition

.. code-block:: text
    :linenos:

    Define PreOrderTraversal
        If the node exists
            Access the node
            Call PreOrderTraversal on the left child node
            Call PreOrderTraversal on the right child node


* Notice that the root of the (sub)tree is accessed before (*pre-*) any recursive calls

.. figure:: binary_tree_example.png
    :width: 500 px
    :align: center

    A pre-order traversal of the binary tree would visit the nodes in the order ``A, B, D, H, E, C, F, I, G``.


In-order
--------

* An in-order traversal is another common traversal
* The general idea is

    * Start at the root
    * Go to the left child, *Access the node*, then the right child

* To get more precise in a recursive definition

.. code-block:: text
    :linenos:

    Define InOrderTraversal
        If the node exists
            Call PreOrderTraversal on the left child node
            Access the node
            Call PreOrderTraversal on the right child node


* Notice that the root of the (sub)tree is accessed *in* between any recursive calls


.. figure:: binary_tree_example.png
    :width: 500 px
    :align: center

    An in-order traversal of the binary tree would visit the nodes in the order ``D, H, B, E, A, I, F, C, G``


Post-order
----------

* Take a wild guess at what this one will be

* A post-order traversal is another traversal
* The general idea is

    * Start at the root
    * Go to the left child, then the right child, then *Access the node*,


* To get more precise in a recursive definition

.. code-block:: text
    :linenos:

    Define PostOrderTraversal
        If the node exists
            Call PreOrderTraversal on the left child node
            Call PreOrderTraversal on the right child node
            Access the node


* Notice that the root of the (sub)tree is accessed after (*post-*) any recursive calls

.. figure:: binary_tree_example.png
    :width: 500 px
    :align: center

    A post-order traversal of the binary tree would visit the nodes in the order ``H, D, E, B, I, F, G, C, A``.


Level-order
-----------

* A level-order traversal is a little different when compared to the others
* The search doesn't work it's way down each branch of the tree one by one
* Instead, it traverses the *breadth* of the tree on the way down all branches

* The idea is

    * Start at the root
    * Visit the nodes in each level from left to right


* With this idea, there is no immediately obvious recursive definition of this traversal
* An iterative definition of the traversal is perhaps simpler to derive


.. code-block:: text
    :linenos:

    Define LevelOrderTraversal
        If the root node exists
            Enqueue the root node to a queue

        While the queue is not empty
            Dequeue a node
            Access the dequeued node

            If the left child exists
                Enqueue the left child to the queue

            If the right child exists
                Enqueue the right child to the queue



.. figure:: binary_tree_example.png
    :width: 500 px
    :align: center

    A level-order traversal of the binary tree would visit the nodes in the order ``A, B, C, D, E, F, G, H, I``.



Iterative Pre/In/Post-Order
---------------------------

* With the iterative level-order traversal, a *queue* was used
* What would happen if a *stack* was used?

* With the recursive pre-/in-/post-order traversals, a stack was used

    * The *call stack*
    * No directly instantiated stack data structure was used, but one could have been used


* How would the level-order traversal need to be changed to do a pre-/in-/post-order traversal?



Traversal Analysis
------------------

.. image:: binary_tree_example.png
   :width: 500 px
   :align: center


* Consider a binary tree with :math:`n` nodes
* If all :math:`n` nodes are to be visited, what is the computational complexity of

    * pre-order traversal?
    * in-order traversal?
    * post-order traversal?
    * level-order traversal?


* Intuitively, they're all :math:`O(n)` since all :math:`n` nodes must be visited once and only once
* If the question was changed slightly, consider a binary tree with **height** :math:`h`

    * What is the computational complexity of the traversals?
    * Consider the relationship between the height of a binary tree and the number of nodes within the tree
    * :math:`O(2^{h})`



Interface
=========

* What would a binary tree need to do?

    * Check if an element exists in the tree
    * Count the number of occurrences of a given element
    * Check if its empty
    * Get the size
    * Traverse the tree
    * Add elements

        * But where?

    * Remove elements

        * Which one, from where?


* Adding/removing something to a stack and queue was more straightforward

    * Pushing and popping happened at the top of the stack
    * Enqueuing and dequeueing happen at opposite ends


* For a binary tree, with add and remove, what is wanted/what it means will depend on the type of binary tree
* Similar to the bag, elements must be able to be added and removed from the binary tree
* But what what exactly add and remove means may differ depending on the specific type of binary tree


.. code-block:: java
    :linenos:

    import java.util.Iterator;
    import java.util.NoSuchElementException;

    public interface BinaryTree<T> extends Iterable<T> {

        boolean add(T element);
        boolean remove(T element);
        boolean contains(T element);
        int count(T target);
        boolean isEmpty();
        int size();
        Iterator<T> iterator();
        Iterator<T> preOrderIterator();
        Iterator<T> inOrderIterator();
        Iterator<T> postOrderIterator();
        Iterator<T> levelOrderIterator();
    }



Linked Implementation
=====================

* No binary tree implementation is being created; it will be inherited from for specific binary tree implementations

    * For example, a ``BinarySearchTree``


* One way to implement a binary tree is with a collection of linked nodes
* Use a size field to keep track of the number of elements within the tree
* Use a field to reference the root node

    * Like how a reference was used to keep track of the top of a stack or the front of a queue



Binary Tree Node
----------------

* Until now, the node class has only had a single successor
* However, there is no rule saying that there can't be more than one successor

.. figure:: binary_tree_node.png
    :width: 500 px
    :align: center

    Example node containing data and references to two successor nodes. These successors are referred to as left and
    right.


* Here, have the node contain:

    * A reference to some element
    * A reference to a left child
    * A reference to a right child


* A new ``Node`` a standalone class, but this may cause confusion between singly linked nodes and nodes with two successors
* A simple way to address this is to make the ``Node`` class a static nested class inside the specific ``BinaryTree`` implementation


.. literalinclude:: /../main/java/LinkedBinarySearchTree.java
    :language: java
    :lineno-match:
    :lines: 447-491



Linked Binary Tree
------------------

* Although there will be no implementation of a general ``BinaryTree``, general binary tree related methods can be discussed


``size``
^^^^^^^^

* Given some arbitrary binary tree with no ``size`` field, the number of elements can be counted recursively

    * If the current node exists, then the size of the (sub)tree it is the root of will be 1 + the size of the left subtree + the size of the right subtree

.. code-block:: java
    :linenos:

    public int size() {
        return size(root);
    }

    private int size(Node<T> current) {
        if (current == null) {
            return 0;
        } else {
            return 1 + size(current.getLeft()) + size(current.getRight());
        }
    }

* Here a public setup method is used to start the private recursive method call on the root

* What is the computational complexity of this ``size()`` method?

    * :math:`O(n)`, where :math:`n` is the number of nodes in the tree



``contains``
^^^^^^^^^^^^

* Given some arbitrary binary tree, a specific element can be searched for recursively

    * If the current element is what is being looking for, done
    * Otherwise, check the left subtree
    * If it wasn't found in the left subtree, then check the right subtree


.. code-block:: java
    :linenos:

    public boolean contains(T needle) {
        return contains(root, needle);
    }

    private boolean contains(Node<T> current, T needle) {
        if (current == null) {
            return false;
        } else if (Objects.equals(current.getData(), needle)) {
            return true;
        } else {
            return contains(current.getLeft(), needle) || contains(current.getRight(), needle);
        }
    }


* Mind the use of the short-circuit or in the above example
* What is the computational complexity of this ``contains()`` method?

    * :math:`O(n)`, where :math:`n` is the number of nodes in the tree
    * Although the right subtree may not have been searched, the worst case scenario is considered


Traversals
^^^^^^^^^^

* Preorder traversal printing out the elements


.. code-block:: java
    :linenos:

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node<T> current) {
        if (current != null) {
            System.out.println(current.getData());
            preOrder(current.getLeft());
            preOrder(current.getRight());
        }
    }


* An inorder traversal, but instead of printing out the contents, add them to some other collection

.. code-block:: java
    :linenos:

    public IndexedBag<T> inOrder() {
        IndexedBag<T> sequence = new ArrayIndexedBag<>();
        inOrder(root, sequence);
        return sequence;
    }

    private void inOrder(Node<T> current, IndexedBag<T> sequence) {
        if (current != null) {
            inOrder(current.getLeft(), sequence);
            sequence.add(current.getData());
            inOrder(current.getRight(), sequence);
        }
    }


For Next Time
=============

* Read Chapter 10 Sections 4 -- 7

    * 34 pages (mostly code though)


Playing Code
------------

* Download and play with the :download:`BinaryTree </../main/java/BinaryTree.java>` interface
