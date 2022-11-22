***********
Collections
***********

* Collections
* Abstract Data Types
* Data Structures
* Implementations
* Abstraction


Collections and ADTs
====================

* A collection is a group of *things* that are to be treated as a special conceptual unit

    * A contact list
    * A stamp collection


* In computer science there a few popular elementary collections

    * Stacks
    * Queues
    * Bags
    * Lists
    * Trees
    * Graphs


* This list is far from complete, but they will be a big part of your early computer science courses


Linear Collections
------------------

* Linear collections are those that arrange data in a sequential way where each thing has a predecessor and a successor

    * Except for the ends


Stack
^^^^^

.. figure:: /topics/stacks/stack_example.png
    :width: 500 px
    :align: center


* Adding and removing data from a stack happens from one end
* The last thing added to the stack will be the first thing removed


Queue
^^^^^

.. figure:: /topics/queues/queue_example.png
    :width: 500 px
    :align: center

* Adding and removing data from a queue happens at *different* ends

    * Adding happens to one end
    * Removing happens from the other

* The first thing that gets added would be the first thing to be removed


Bag
^^^

.. figure:: /topics/intro/ordered_bag_example.png
    :width: 500 px
    :align: center

* Adding and removing from a bag will depend on the type of bag we have
* In the above example, the bag is ordered, so adding to the bag must preserve the order


Nonlinear Collections
---------------------

* Sometimes there is no natural way to arrange data in a linear sequence
* Sometimes there are many successors
* Sometimes the idea of successor does not make sense


Trees
^^^^^

* Trees are a generalization of lists

.. figure:: /topics/trees/tree_example.png
    :width: 500 px
    :align: center

* If one were asked "What comes after Program Files" in the above example, there is no obvious answer
* The data is arranged in a hierarchical way
* Every element has at most one *parent*, but potentially many *children*


Graphs
^^^^^^

* Graphs are a generalization of trees

.. figure:: /topics/intro/graph_example.png
    :width: 500 px
    :align: center

* Data may be represented with relationships to other data
* Graphs are made up of

    * Vertices/Nodes
    * Edges

* In the above example, each vertex/node (box) is an airport
* The edges (lines) between the vertices/nodes represent the existence of a direct flight between the airports

    * The relationship the airports have with one another


Abstraction
===========

* An important idea for problem solving is *abstraction*

    * We do this a lot in every day life

* It is often helpful to try to separate the **what** from the **how**

    * *What* we can do
    * *How* it's actually done

    * One may know *what* they have to do to drive a car
    * But they don't need to know *how* cars actually work in detail in order to use the car

    * One may know that they want to append things to lists in Python
    * But they don't need to know how a Python list actually does that


* The above ADTs are all just the *what*

    * We can add and remove things from a stack

* This is how one *interfaces* with the thing
* As of now, there has been no discussion on *how* these ADTs actually work under the hood

    * The implementation of these ADTs will come later
    * In fact, there is often several reasonable options *how* for a single *what*

        * Implement a stack with an array?
        * Implement a stack with a linked structure?


Layering
--------

* If our systems are large, we may start to have multiple levels, or, *layers*, of abstraction
* If this is the case, one may want to group components and restrict how our layers of abstraction interact

* Often we do this in real life too

    * Tell me how to cook pasta?

        * Boil salted water and then add pasta

    * Tell me in more detail

        * Get a pot, fill with water, put on stove, and ....

    * ...
    * ...
    * ...

    * Tell me in more detail

        * Neurons start to fire and muscles contract...

    * More detail please

        * Ion pumps and ....


* The point is, it's `turtles all the way down <https://en.wikipedia.org/wiki/Infinite_regress>`_
* If I want to make pasta for dinner, I don't want to care about ion pumps

    * Fortunately there are several layers between cooking pasta and the polarity of particles


Data Structures
===============

* A data structure is an actual implementation of an ADT

* Using the ``ContactList`` example, the *what* would be:

    * Keep track of ``Friend`` objects
    * Add and remove ``Friend`` objects
    * Get a ``Friend``
    * ...

* The *how* would be the actual code we see

    * An array was used to keep track of the ``Friend`` objects
    * A linear search was done to check if a given ``Friend`` object was in the ``ContactList``

* A large focus of this class will be both the *what* and the *how* and how to keep them separate

    * The interface and the implementation

.. warning::

    It is not uncommon for people to use data structure as a catch all to mean both the ADT and the specific
    implementation.


For Next Time
=============

* Read Chapter 3 Section 1 of your text

    * 3 pages
