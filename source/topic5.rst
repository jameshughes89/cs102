**************************
Topic #5 --- The Stack ADT
**************************

* Stacks are a collection of elements that are only added and removed from one end
    * The *top*

* Given this, the **L**\ ast thing **I**\ n will be the **F**\ irst thing **O**\ ut
    * LIFO

* For example
    * A stack of plates that you'd see at a buffet
    * Webpage history with the back button
    * Undo in your text editor
    * Callstack

**Adding to a Stack**

.. image:: ../img/stack_add.png
   :width: 500 px
   :align: center

**Removing from a Stack**

.. image:: ../img/stack_remove.png
   :width: 500 px
   :align: center


Stack Operations
================

Collection Operations
---------------------

* For the collections we're looking at, we need a way to:
    * Add something to the collection
    * Remove something from the collection
    * Look at something, but do not remove it

* However, the way these are done may differ between collections

* Other things we will want to do with our collections are:
    * ``isEmpty`` --- see if the collection is empty
    * ``size`` --- Check how many things are in the collection
    * ``toString`` --- Get a string version of the collection


Stack Context
-------------

* **Push**
    * Add something to the *top* of the stack

* **Pop**
    * Remove something from the *top* of the stack

* **Peek**
    * Look at the thing on the *top* of the stack, but do **not** remove it

* And we will also want out ``isEmpty``, ``size`` and ``toString``


.. warning::

    It is against our definition of a stack to access anything from anywhere other than the *top* of the stack.


Stack ADT
---------

* With this, we now know what the operators are and how they are used

* Notice how none of the above explains a single thing about *how* the stack is implemented
    * Nothing about where we store the data
    * Nothing about how the operators do what they do

* Notice that this also has nothing to do with Java
    * Or Python
    * Or C++
    * Or ...

* This is just the definition of the stack ADT




Example Uses
============




Interface
=========

* There are many possible ways one could implement a stack data structure
* But, all implementations must be a *stack*
    * They must follow our definition of a stack ADT

* In Java, we can create an **interface** that defines what the operations of the stack ADT are without actually implementing it
* Then, when someone implements the stack ADT, the interface will make sure that the implementation *implements* the operators

* The interface will simply be a list of *abstract methods* and relevant constants
    * Abstract methods are the method signature/header and no actual body
    * Our methods will be ``public``
        * ``public int someMethod(int a, int b);``
        * Although, we don't actually have to say ``public`` here since it has to be
    * Constants will be ``static final``

Stack Interface
------------------

.. code-block:: java
    :linenos:

    public interface Stack <T> {

        // Javadoc comments within Stack.java file
        void push(T element);
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
    * ``public push(String element);``
    * ``public String pop();``
    * ...

* Then maybe a stack of Friends
    * ``public push(Friend element);``
    * ``public Friend pop();``
    * ...


There has to be a Better Way!
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

* There is, **genetics**

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


For next time
=============

* Checkout the :download:`Stack.java<../src/main/java/Stack.java>` interface.
* Read Chapter 3 Sections 2 -- 6
    * 13 pages