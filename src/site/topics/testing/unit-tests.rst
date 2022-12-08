**********
Unit Tests
**********

* At the end of the objects review topic the implementation was played with
* This allowed testing the basic functionality,
* However, the testing was far from through or systematic


Unit Testing
============

* Ideally, when testing code, each *unit* or *component* should be tested

    * *Unit Testing*
    * Ideally with good *coverage*


* When doing so, individual test functions are written to test the units/components
* These tests can also be run automatically

* By writing tests like this, it adds intentionality to the code and tests

    * Take the time to think of the cases needing testing
    * It can also help keep the units/components isolated


* It also obviously helps with testing and debugging
* It there are ever breaking changes to the unit/component being tested, the automated testing will find it

* Writing tests can be a bit of an art, so it's best to get a lot of practice


JUnit
=====

* JUnit is a very popular unit testing framework for Java
* It's simple to use and automates testing
* Within IntelliJ, there is a simple way to setup JUnit

#. Make a new folder/directory called ``test`` in the project next to ``src``

    .. figure:: test_folder.png
        :width: 600 px
        :align: center


#. Right click the ``test`` folder and select *Mark Directory as -> Test Sources Root*

    .. figure:: mark_tests.png
        :width: 600 px
        :align: center


#. Create a new class for testing named such that it is the class name followed by "Test"

    * For example, ``FriendTest``


#. Add JUnit to the class path

    * A simple way to do it is to write ``@Test`` in the new class and press Alt+Enter


#. Select *Add 'JUnit5....*

    .. figure:: alt_enter.png
        :width: 600 px
        :align: center


Testing ArrayStack
==================

* For now, the new ideas introduced here are

    * ``@Test`` annotation
    * Assertions

* Checkout the :download:`ArrayStackTest.java</../test/java/ArrayStackTest.java>` for testing the ``ArrayStack``.
* Have a look at all the methods, the imports, function names, etc.

* Below are some examples from the file:

.. code-block:: java
    :linenos:
    :emphasize-lines: 5

    @Test
    @DisplayName("A new stack starts empty.")
    void aNewStackIsEmpty() {
        Stack<Integer> stack = new ArrayStack<>();
        assertTrue(stack.isEmpty());
    }

* Things to note:
    * We add ``@Test`` before the function name
    * We include ``@DisplayName`` to provide a good description of what is being tested
        * This is not actually needed
    * The function name ``aNewStackIsEmpty`` is descriptive

* The ``assertTrue`` is being used to test a specific thing here
    * If the stack is in fact empty after it is created


.. code-block:: java
    :linenos:
    :emphasize-lines: 5

    @Test
    @DisplayName("An empty stack has size 0.")
    void emptyStackHasSizeZero() {
        Stack<Integer> stack = new ArrayStack<>();
        assertEquals(0, stack.size());
    }

* Given that we have a test for ``aNewStackIsEmpty``, if this passes, we know our newly created stack is empty
* We can now test if the ``size`` of the stack is 0 when it is empty
