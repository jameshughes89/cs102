************************
Unit Testing Collections
************************

* There has been an emphasis on writing code defensively
* Ideally, code is written in such a way that, not only is correct, but easy to test, understand, and reason about
* For example:

    * Immutability --- If the data cannot change, it makes the program more predictable
    * Avoiding side effects --- Functions/methods do not modify anything
    * Functions operate independently --- Self contained functionality is easier to understand and use


* However, collections pose a problem since they are often

    * Mutable --- their states change constantly through adding and removing data
    * Side effects --- their methods may have side effects (modifying the contents of the collection)
    * Interconnected methods --- Adding and removing data from a collection are inextricably connected


Collection Testing Complexities
===============================

* Like before, there is still a need to test all public methods
* However, unlike before, there is a need to test methods under certain conditions

* Consider the ``pop`` method from the stack

    * What should happen when ``pop`` is called on an empty stack?

        * An exception should be thrown

        .. literalinclude:: /../test/java/ArrayStackTest.java
            :language: java
            :linenos:
            :lineno-start: 33
            :lines: 33-36


    * What should happen when ``pop`` is called on a stack with one thing in it?

        * Returns top
        * Result in an empty stack

        .. literalinclude:: /../test/java/ArrayStackTest.java
            :language: java
            :linenos:
            :lineno-start: 78
            :lines: 78-87


    * What should happen when ``pop`` is called on a stack with many things in it?

        * Returns top
        * Results in a new top

        .. literalinclude:: /../test/java/ArrayStackTest.java
            :language: java
            :linenos:
            :lineno-start: 140
            :lines: 140-149


* Notice that the expected behaviors differs depending on the state
* Further, it's not possible to test ``pop`` without first having elements in the stack

    * Having called ``push``


Strategies for Testing Collections
==================================



* How to cope


* Setup code
* Nested class
* Example tests



For Next Time
=============

* Download and play with

    * :download:`Stack </../main/java/Stack.java>`
    * :download:`ArrayStack </../main/java/ArrayStack.java>`
    * :download:`ArrayStackTest </../test/java/ArrayStackTest.java>`


* Finish reading Chapter 3

    * 16 pages