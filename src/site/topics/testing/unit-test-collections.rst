************************
Unit Testing Collections
************************

* There has been an emphasis on writing code defensively
* Ideally, code is written in such a way that is, not only correct, but easy to test, understand, and reason about
* For example:

    * Immutability --- If the data cannot change, it makes the program more predictable
    * Avoiding side effects --- Functions/methods do not modify anything
    * Functions operate independently --- Self contained functionality is easier to understand and use


* However, collections pose a problem

    * Mutable --- their states change constantly through adding and removing data
    * Side effects --- their methods may have side effects (modifying the contents of the collection)
    * Interconnected methods --- Adding and removing data from a collection are inextricably connected


* Additionally, their expected behaviour may be different depending on their state
* Consider the ``pop`` method for a ``Stack``

    * What should happen when ``pop`` is called on an empty ``Stack``?

        * Throw an exception


    * What should happen when ``pop`` is called on a ``Stack`` with one element in it?

        * Return the top and result in an empty stack


    * What should happen when ``pop`` is called on a ``Stack`` in a more general case?

        * Return the top and result in a changed stack



Empty Stack Tests
=================

* To simplify the process of writing unit tests for the ``ArrayStack``,  start with one of the states
* Perhaps the simplest state to test under is when the ``ArrayStack`` is empty
* Below are example unit tests for all methods within the ``ArrayStack`` class when it is empty
* Consider, for example, the two ``push`` related tests

    * There is a test that it returns what is expected
    * There is also a test to check that it had the proper side effect


* This is an example of the added complexity of testing a method with a side effect

    * One cannot simply test the output given the input
    * There is also a necessity to test the side effects


.. code-block:: java
    :linenos:

    @Test
    void push_empty_returnsTrue() {
        ArrayStack<Integer> classUnderTest = new ArrayStack<>();
        assertTrue(classUnderTest.push(11));
    }

    @Test
    void push_empty_newTop() {
        ArrayStack<Integer> classUnderTest = new ArrayStack<>();
        classUnderTest.push(11);
        assertEquals(11, classUnderTest.peek());
    }

    @Test
    void pop_empty_throwsNoSuchElementException() {
        ArrayStack<Integer> classUnderTest = new ArrayStack<>();
        assertThrows(NoSuchElementException.class, () -> classUnderTest.pop());
    }

    @Test
    void peek_empty_throwsNoSuchElementException() {
        ArrayStack<Integer> classUnderTest = new ArrayStack<>();
        assertThrows(NoSuchElementException.class, () -> classUnderTest.peek());
    }

    @Test
    void isEmpty_empty_returnsTrue() {
        ArrayStack<Integer> classUnderTest = new ArrayStack<>();
        assertTrue(classUnderTest.isEmpty());
    }

    @Test
    void size_empty_returnsZero() {
        ArrayStack<Integer> classUnderTest = new ArrayStack<>();
        assertEquals(0, classUnderTest.size());
    }

    @Test
    void toString_empty_returnsEmptyString() {
        ArrayStack<Integer> classUnderTest = new ArrayStack<>();
        assertEquals("", classUnderTest.toString());
    }


.. note::

    In the above tests, the name of the reference variable to the ``ArrayStack`` being tested is ``classUnderTest``.
    This is a common convention ---  use the name ``classUnderTest`` for the object being used to test the class.



Common Setup Code
-----------------

* Notice that each of the above example tests starts with the exact same code

    * The creation of an ``ArrayStack``
    * ``ArrayStack<Integer> classUnderTest = new ArrayStack<>();``


* To help simplify each of the individual tests, this setup code can be removed and added to its own method
* This method will be annotated with ``@BeforeEach``
* To make use of this, however, the variable ``classUnderTest`` will be made a field for the ``ArrayStackTest`` class
* The below code shows an example of the setup method with the two ``push`` unit tests updated to not include the creation of the ``ArrayStack``

    * For brevity, only the two ``push`` tests are shown
    * This would work similarly for each of the previously discussed empty tests


.. code-block:: java
    :linenos:

    private ArrayStack<Integer> classUnderTest;

    @BeforeEach
    void createStack() {
        classUnderTest = new ArrayStack<>();
    }

    @Test
    void push_empty_returnsTrue() {
        assertTrue(classUnderTest.push(11));
    }

    @Test
    void push_empty_newTop() {
        classUnderTest.push(11);
        assertEquals(11, classUnderTest.peek());
    }

    .
    .
    .




Singleton Case Stack Tests
==========================


General Case Stack Tests
========================



For Next Time
=============

* Download and play with

    * :download:`Stack </../main/java/Stack.java>`
    * :download:`ArrayStack </../main/java/ArrayStack.java>`
    * :download:`ArrayStackTest </../test/java/ArrayStackTest.java>`


* Finish reading Chapter 3

    * 16 pages