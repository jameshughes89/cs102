***********************
Topic #6 --- ArrayStack
***********************

* We now are familiar with *what* we want the stack ADT to do without talking about *how*
* Obviously, in order to use a stack in Java, we need to actually implement a stack

* We now need to think about implementation issues
    * How are we going to keep track of our data?
    * How will we know where the top is?
        * This will depend on the choice of how we store the data

Implementing a Stack --- Array Container
========================================


Implementation
--------------

* Let's start our implementation of the ``ArrayStack``

.. code-block:: Java
    :linenos:
    :emphasize-lines: 1

    public class ArrayStack<T> implements Stack<T> {

        private static final int DEFAULT_CAPACITY = 100;
        private T[] stack;
        private int top;

    }


* We want our ``ArrayStack`` to implement the ``Stack`` interface
    * This way anyone using our implementation knows that it is a ``Stack``
    * Note line 1 where we specifically say ``ArrayStack<T> implements Stack<T>``

* Since our ``ArrayStack`` is generic, we don't know what type the array should be at this stage, so we make it an array of type ``T``


Expand Capacity
^^^^^^^^^^^^^^^


Exceptional Situations
----------------------


For next time
=============

* Finish reading Chapter 3
    * 16 pages
