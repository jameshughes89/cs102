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

* Two easy ways to help manage the complexities of testing collections

    * Common setup code
    * Laying out the tests with nested classes


Common Setup Code
-----------------

.. literalinclude:: /../test/java/ArrayStackTest.java
    :language: java
    :linenos:
    :lineno-start: 1
    :lines: 1-17
    :emphasize-lines: 10, 11, 13-17


* The above code is the beginning of the test class for the array stack
* Notice the use of class fields ``classUnderTest`` and ``preState``

    * ``classUnderTest`` is a reference to a stack instance used for testing
    * ``preState`` is a reference to a copy of the stack instance that is used to check for changes to the stack (more on this later)


* Also notice the ``createStack`` method that is annotated with ``@BeforeEach``

    * This method actually creates the instances of the stacks
    * This method will be called *before* each test method is invoked


* With this common setup code, all tests within the test class will have access to the field

    * Thus, there is no need to create an instance of a stack inside each test


Nested Test Classes
-------------------

* Another way to help layout the tests in a clean way is to use nested test classes
* A nested test class can share the setup code from the enclosing/outside class while also allowing for additional setup code

.. literalinclude:: /../test/java/ArrayStackTest.java
    :language: java
    :lines: 8-9, 13-21, 58-66, 115-128, 176-178


* The above example is the skeleton of the test class for the array stack
* This example contains three nested classes

    * ``WhenNewEmpty``, which is nested within ``ArrayStackTest``
    * ``WhenSingleton``, which is nested within ``WhenNewEmpty``
    * ``WhenMany``, which is nested within ``WhenSingleton``

* Each of these nested classes is annotated with ``Nested``
* The ``WhenMany`` class also has the ``@TestInstance(TestInstance.Lifecycle.PER_CLASS)`` annotation

    * This specifies that a new test instance is created once per test class
    * For now, do not worry about this detail too much




.. note::

    The above suggested layout is by no means the *correct* way or a standard for testing collections. It is simply a
    strategy to help manage the complexities of testing collections.


For Next Time
=============

* Download and play with

    * :download:`Stack </../main/java/Stack.java>`
    * :download:`ArrayStack </../main/java/ArrayStack.java>`
    * :download:`ArrayStackTest </../test/java/ArrayStackTest.java>`


* Finish reading Chapter 3

    * 16 pages