*****
Links
*****

.. note::

    This topic is not introducing a ADT. Instead, it is introducing the idea of linked structures. These linked
    structures may be used to implement ADTs


* Arrays have a fixed size

    * But the ``expandCapacity`` trick can hide this


* When using an array, data may need to me shifted around when adding and/or removing
* Traditionally speaking, arrays are in contiguous memory addresses

    * The successor value is in the next array cell
    * JVM asterisk --- In Java, arrays are objects, and objects go into the *heap*, which isn't necessarily contiguous



Linked Structure
================

* A linked data structure is one that consists of objects referencing other objects

    .. figure:: example0.png
        :width: 500 px
        :align: center

        Example linked structure consisting of five "nodes". Note that "head" is not a node, but a reference to a node.


* Linked structures do not have a fixed size
* With this linking idea, data does not need to be stored in consecutive memory locations

    * Successors can be anywhere


* Data can be inserted and removed by updating the references/links

    * No need to shift data around



Nodes
=====

* A *node* is a basic unit in the linked structures
* For the following examples, the focus is on *singly linked structures*

    * Each node has only one *link*

* The series of nodes linked together is what makes up the singly linked structure

    * The nodes link to their successor nodes


    .. figure:: node_example.png
        :width: 400 px
        :align: center

        Example single node containing a reference to some data and a reference to a successor/next node. These
        references may refer to null.


* A node for a singly linked structure typically has two fields

    * **data** --- a reference to the data to be stored

        * To compare to the array, this would be the data put into the cells of the array


    * **next** --- a reference to the successor/next node

        * Arrays don't have this because the successor is just in the next cell in the array



Inserting into a Linked Structure
=================================

.. figure:: example1.png
    :width: 500 px
    :align: center

    Example of a singly linked structure. Note that "head" is not a node, but a reference to a node.


* With a reference to the head of the linked structure and the two fields (``data`` and ``next``) of the node class

    * How would one access the *first* node's data?
    * How would one access the *second* node's data?
    * How would one access an arbitrary node's data?
    * How would you access the predecessor?

    * How would we add something to the *front* of this linked structure?
    * How would we add something to the *middle* of this linked structure?
    * How would we add something to the *end* of this linked structure?

    * How would we remove something to the *front* of this linked structure?
    * How would we remove something to the *middle* of this linked structure?
    * How would we remove something to the *end* of this linked structure?



Adding to the Front
-------------------

* Given a reference to the front of the linked structure (``head``) and a reference to the node to be inserted (``node``)


.. figure:: add_front0.png
    :width: 500 px
    :align: center

* Have the node to be inserted's ``next`` reference the node referenced by ``head``


.. figure:: add_front1.png
    :width: 500 px
    :align: center

* Have ``head`` reference the new node, which is the new front of the linked structure


.. figure:: add_front2.png
    :width: 500 px
    :align: center

* The new node is now at the front of the linked structure


Adding to the Middle
--------------------

* Given a reference to the front of the linked structure (``head``) and a reference to the node to be inserted (``node``)


.. figure:: add_middle0.png
    :width: 500 px
    :align: center

* Locate the node the new node will be inserted after
* In this example, ``current`` is a reference to the node the new node will be inserted after


.. figure:: add_middle1.png
    :width: 500 px
    :align: center

* Have the new node's ``next`` reference its soon to be predecessor's (``current``) ``next``

    * This is the node that the node being inserted will come before


.. figure:: add_middle2.png
    :width: 500 px
    :align: center

* Update the predecessor's (``current``) ``next`` to reference the new node being inserted

.. figure:: add_middle3.png
    :width: 500 px
    :align: center

* The new node is now at the desired location


Adding to the End
-----------------

* Adding to the middle is a more general case compared to adding to the front

    * Adding to the front is a special case


* The process to add to the end of a linked structure is the same as adding to the middle

    * The difference is that the predecessor's next will have been ``null``, but this does not change the algorithm


Removing from a Linked Structure
=================================

Remove from the Front
---------------------

* Removing from the front may be the easiest operation
* Given a reference to the front of the linked structure (``head``)

.. figure:: remove_front0.png
    :width: 500 px
    :align: center

* Update ``head``, the reference to the front of the linked structure, to refer to the current front's ``next``


.. figure:: remove_front1.png
    :width: 500 px
    :align: center

* With no reference to the old front, it is effectively removed from the linked structure


Remove from the Middle
----------------------

* Given a reference to the front of the linked structure (``head``)
* Locate the node to be removed (``current``) and the node immediately before it (``previous``)

.. figure:: remove_middle0.png
    :width: 500 px
    :align: center

* Have the predecessor's (``previous``) ``next`` refer to the node being removed's (``current``) ``next``


.. figure:: remove_middle1.png
    :width: 500 px
    :align: center

* There is now no way to access the removed node from the linked structure


Remove from the End
-------------------

* Like adding to the end of a linked structure, the process of removing from the end is the same as removing from the middle


Node Implementation
===================

.. figure:: reference_variable.png
    :width: 400 px
    :align: center

* Remember, reference variables contain a reference to an object
* The linked structure uses these references to link the structure together

* The node implementation for the singly linked structure is kept simple

    * A field to keep track of the data
    * A field to keep track of the next/successor node
    * Constructors
    * Getters and setters


.. literalinclude:: /../main/java/Node.java
    :language: java
    :linenos:



Explore the Implementation
--------------------------

.. literalinclude:: /../main/java/PlayingLinks.java
    :language: java
    :linenos:



.. warning::

    As previously mentioned, ``head`` is **not** a node; ``head`` is a reference to a node. For example,
    ``head = someNode;`` and ``head.setNext(someNode);`` have two very different meanings. The first means that the
    node reference variable ``head`` will refer to the node ``someNode``, while the second means that the node
    referenced by ``head``\'s ``next`` node reference will refer to ``someNode``.

    .. figure:: head_equals_someNode.png
        :width: 333 px
        :align: center

        Result of ``head = someNode;``. The reference variable ``head`` is updated to reference the node also referenced
        by the reference variable ``someNode``.


    .. figure:: head_set_next_someNode.png
        :width: 333 px
        :align: center

        Result of ``head.setNext(someNode);``. The node referenced by ``head`` is updated such that it's ``next`` field
        refers to the node also referenced by the reference variable ``someNode``.



Variations
==========

* Like most things learned in this course, there are variations for nodes
* One may be wondering: *Can nodes have references to their predecessors too?*

    * Absolutely


Doubly Linked
-------------

.. figure:: double_links.png
    :width: 400 px
    :align: center

    An example of a doubly linked structure. In addition to the ``data`` and ``next`` field, each node also has a field
    to access its predecessor. This particular example includes reference variables for the front (``head``) and end
    (``tail``) of the linked structure.


* How would the ``Node`` implementation need to change to facilitate this?


For Next Time
=============

* Read Chapter 4 Sections 1 -- 3

    * 7 pages


Playing Code
------------

* Try writing code to add/remove from the front/middle/end of the linked structure
* Download and play with

    * :download:`Node </../main/java/Node.java>`
    * :download:`NodeTest </../test/java/NodeTest.java>`
    * :download:`Linked structure playing code </../main/java/PlayingLinks.java>`



