*************
The Stack ADT
*************

* Stacks are a linear collection of elements
* All adding and removing of elements happen at one end of the stack --- the *top*

    * All elements are pushed (added) to the top of the stack
    * All elements are popped (removed) from the top of the stack


* Given this, the **L**\ ast thing **I**\ n will be the **F**\ irst thing **O**\ ut

    * LIFO


* For example

    * A stack of plates that you'd see at a buffet
    * Webpage history with the back button
    * Undo in your text editor
    * Callstack


.. figure:: stack_add.png
    :width: 500 px
    :align: center

    Adding (pushing) to the top of a stack.


.. figure:: stack_remove.png
    :width: 500 px
    :align: center

    Removing (popping) from the top of a stack.


Stack Operations
================

Collection Operations
---------------------

* In general, for the collections being discussed in this course, there needs to be a way to

    * Add something to the collection
    * Remove something from the collection
    * Look at something, but do not remove it
    * Check if the collection is empty
    * Determine the number of things in the collection

* However, the way these are done may differ between the different types of collections

* Additionally, it may be helpful to

    * Generate a string representation of the collection --- ``toString``
    * Check if two collections are equal --- ``equals``


Stack Context
-------------

* Push

    * Add an element to the collection
    * The element added will be the element on the top of the stack


* Pop

    * Remove an element from the collection
    * The removed element will be the current top of the stack
    * The element after the removed element will be the new top, if it exists
    * The element removed is returned


* Peek

    * Return the element on the top of the stack, but leave it on the stack
    * Peeking does not remove the element from the stack


.. warning::

    It is against this definition of a stack to access anything from anywhere other than the *top* of the stack.


Stack ADT
---------

* The above describes the *what* of the stack

    * What can a stack do


* Notice how none of the above explains a single thing about *how* the stack is implemented

    * Nothing about where the data is stored
    * Nothing about how the methods do what they do


* Also notice that this has nothing to do with Java

    * Or Python
    * Or C++
    * Or ...


* This is just the definition of the stack ADT


Example Use
===========

* With only the *what*, it is possible to solve complex problems


Maze Solving
------------

    .. figure:: maze.png
        :width: 250 px
        :align: center

        A 6x6 maze. The green and red cells represent the start and end locations respectively. Black cells represent
        walls and light blue represent open spaces.


* Finding a path through a maze can be done with a simple *depth first search* algorithm
* The high-level idea is simple

    * Pick a path not visited yet
    * Keep travelling down the path until the end or a dead end is found
    * If the end is found, done
    * If a dead end is found, backtrack until another available unvisited path is found
    * Repeat


* The backtracking is handled by a stack

    * The top of the stack is the last thing (cell) visited
    * The thing after/below the top is the second last thing (cell) visited
    * ...


* Thus, backtracking is done by

    * Popping from the stack
    * Checking if the top has any available unvisited paths


Pseudocode for Traversing a Maze
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. code-block:: text
    :linenos:

    Add the start of the maze to the stack

    While the stack is not empty
        Get the top of the stack with a peek (current cell)
        If the top is the end
            done

        If an unvisited neighbour of the current cell exists
            Push the neighbour onto the stack

        If no admissible neighbour exists
            Pop from the stack

    If the loop ever exists because of an empty stack, there is no solution


Example
^^^^^^^

    .. figure:: maze_animate.gif
        :width: 250 px
        :align: center

        Animation of a depth first search through a 6x6 maze. The green and red cells represent the start and end
        locations respectively. Black cells represent walls and light blue represent open spaces. Purple represents the
        current location in the maze (top of the stack), grey represent spaces in a pathway being explored (currently
        within the stack, but not the top), and orange represents spaces that were part of a dead end path (popped from
        the stack).


* Try to see where the ``push``, ``pop``, and ``peek`` operations are happening
* Again, notice that this algorithm was described with only the *what* of a stack

    * There was no need to know how the stack was implemented in order to use it to solve a problem


Interface
=========

* There are many possible ways one could implement a stack data structure
* But, all implementations must be a *stack*

    * They must follow definition of what a stack ADT is


* In Java, one can create an **interface** that defines what the operations of the stack ADT are
* However, the interface only defines the *what*

    * Interfaces do not define the *how*


* If someone wants to implement the *how* of a stack ADT, the interface dictates what must be implemented
* If the implementation does not implement the interface completely, a compile time error will occur

* An interface is simply a list of *abstract methods* and relevant constants

    * Abstract methods are the method signature with no actual body

        * ``int someMethod(int a, int b);``
        * No visibility modifier is included as it must be public


    * Relevant constants will be ``static final``


Stack Interface
------------------

* Below is the Stack interface

    * It only includes the *what*
    * No actual implementation of any method is included

.. code-block:: java
    :linenos:

    public interface Stack <T> {

        // Javadoc comments within Stack.java file
        boolean push(T element);
        T pop();
        T peek();
        boolean isEmpty();
        int size();
    }


Generics
--------

* You are probably wondering what ``<T>`` is

* Imagine you wanted to have a stack of type ``Integer``, then you'd have to make
    * ``public void push(Integer element);``
    * ``public Integer pop();``
    * ...

* Then, maybe you want to make a stack of Strings
    * ``public void push(String element);``
    * ``public String pop();``
    * ...

* Then maybe a stack of Friends
    * ``public void push(Friend element);``
    * ``public Friend pop();``
    * ...


There has to be a Better Way!
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

* There is, **generics**

* ``<T>`` is a stand-in for a specific type that we can specify later when we want to create a stack with a specific type
    * You can think of it as like a variable for a type

* Jumping ahead a little, we can specify the type of things we want in our stack like this
    * We will talk about ``ArrayStack`` in the next topic

.. code-block:: java
    :linenos:

    public class SomeClass {
        public static void main(String[] args) {

            Stack<Integer> myIntegerStack = new ArrayStack<Integer>();
            Stack<String> myStringStack = new ArrayStack<String>();
            Stack<Friend> myFriendStack = new ArrayStack<Friend>();
        }
    }

* In the above example, we are creating three stacks, each with a different type of object as its contents
* We have gotten a little ahead of ourselves, but the takeaway is, when we create the instance of the stack, we specify the type we want within the ``<`` and ``>`` brackets
    * We will talk a little more about this in the next topic

.. warning::

    We do not actually need to include the ``<Type>`` on the instantiation side. From now on, for simplicity, I will use the *diamond operator* (``<>``) like so:

        .. code-block:: java
            :linenos:

                    Stack<Integer> myIntegerStack = new ArrayStack<>();
                    Stack<String> myStringStack = new ArrayStack<>();
                    Stack<Friend> myFriendStack = new ArrayStack<>();



For next time
=============

* Checkout the :doc:`Postfix expression evaluation stack example. <postfix>`
* Checkout the :download:`Stack.java</../main/java/Stack.java>` interface.
* Read Chapter 3 Sections 2 -- 6
    * 13 pages
