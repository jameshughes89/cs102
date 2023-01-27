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

* Below are example unit tests for all methods within the ``ArrayStack`` class when it has a single element within it
* Notice the inclusion of the new class field called ``preState``
* This ``preState`` will effectively be a duplicate of ``classUnderTest`` that can be used to check that a method had no side effect
* Consider ``peek_singleton_unchanged`` for an example

    * Calling ``peek`` should not have any side effect; it should not mutate the object in any way
    * To verify this, one can assert equality between ``preState`` and ``classUnderTest`` after calling ``peek`` on ``classUnderTest``


.. note::

    Although ``preState`` is only actually used on one of the tests so far, it is convenient to always have an
    equivalent object to ``classUnderTest`` within the test class. For this reason, ``preState`` is made a class field
    and is always setup the same way as ``classUnderTest``.



.. code-block:: java
    :linenos:
    :emphasize-lines: 2,7,47,49

    private ArrayStack<Integer> classUnderTest;
    private ArrayStack<Integer> preState;

    @BeforeEach
    void createStack() {
        classUnderTest = new ArrayStack<>();
        preState = new ArrayStack<>();
    }

    // Empty tests excluded here

    @Test
    void push_singleton_returnsTrue() {
        classUnderTest.push(10);
        preState.push(10);
        assertTrue(classUnderTest.push(11));
    }

    @Test
    void push_singleton_newTop() {
        classUnderTest.push(10);
        preState.push(10);
        classUnderTest.push(11);
        assertEquals(11, classUnderTest.peek());
    }

    @Test
    void pop_singleton_returnsTop() {
        classUnderTest.push(10);
        preState.push(10);
        assertEquals(10, classUnderTest.pop());
    }

    @Test
    void pop_singleton_emptyStack() {
        classUnderTest.push(10);
        preState.push(10);
        classUnderTest.pop();
        assertEquals(new ArrayStack<>(), classUnderTest);
    }

    @Test
    void peek_singleton_returnsTop() {
        classUnderTest.push(10);
        preState.push(10);
        assertEquals(10, classUnderTest.peek());
    }

    @Test
    void peek_singleton_unchanged() {
        classUnderTest.push(10);
        preState.push(10);
        classUnderTest.peek();
        assertEquals(preState, classUnderTest);
    }

    @Test
    void isEmpty_singleton_returnsFalse() {
        classUnderTest.push(10);
        preState.push(10);
        assertFalse(classUnderTest.isEmpty());
    }

    @Test
    void size_singleton_returnsOne() {
        classUnderTest.push(10);
        preState.push(10);
        assertEquals(1, classUnderTest.size());
    }

    @Test
    void toString_singleton_returnsCorrectString() {
        classUnderTest.push(10);
        preState.push(10);
        assertEquals("10, ", classUnderTest.toString());
    }


.. note::

    When considering ``peek_singleton_returnsTop``, it may become clear that ``push_empty_newTop`` and
    ``push_singleton_newTop`` are redundant tests since the ``peek_singleton_returnsTop`` will test ``peek`` after a
    ``push`` has happened anyways, effectively checking that a ``push`` results in the expected top. When looking at the
    code in the tests, it's clear that the tests are effectively identical. Thus, it is not really necessary to include
    any of the ``push`` causing a new top test.

        .. code-block:: java
            :linenos:

            @Test
            void push_empty_newTop() {
                classUnderTest.push(11);
                assertEquals(11, classUnderTest.peek());
            }

            @Test
            void peek_singleton_returnsTop() {
                classUnderTest.push(10);
                assertEquals(10, classUnderTest.peek());
            }


    This highlights the complexities caused by the *interconnectedness* of the collection's methods --- one cannot test
    that ``push`` results in a new top without using ``peek``, and one cannot test ``peek`` without having already
    called ``push``.



Nested Test Classes
-------------------

* Notice that, once again, each of these tests have the same setup code

    * ``classUnderTest.push(10);``


* Unfortunately, unlike with the empty tests, one cannot simply add this to the existing ``@BeforeEach`` set up code

    * This would break the empty tests since the stack will have something added before each test is run


* With *nested test classes*, there is a way to add another ``@BeforeEach`` setup code that applies to the singleton tests and not the empty tests
* Further, this strategy helps group the tests together nicely
* Below is an example of using the nested test classes

* The ``createStack()`` setup code will be run before the empty tests *and* singleton tests
* But the ``addSingleton()`` setup code only runs before the singleton tests, but *after* ``createStack()`` is run

    * This way the ``ArrayStack`` instances exist before the pushing takes place inside ``addSingleton()``



.. code-block:: java
    :linenos:

    private ArrayStack<Integer> classUnderTest;
    private ArrayStack<Integer> preState;

    @BeforeEach
    void createStack() {
        classUnderTest = new ArrayStack<>();
        preState = new ArrayStack<>();
    }

    @Nested
    class WhenNewEmpty {

        @Test
        void push_empty_returnsTrue() {
            assertTrue(classUnderTest.push(11));
        }

        @Test
        void pop_empty_throwsNoSuchElementException() {
            assertThrows(NoSuchElementException.class, () -> classUnderTest.pop());
        }

        // Remaining empty tests excluded here

        @Nested
        class WhenSingleton {

            @BeforeEach
            void addSingleton() {
                classUnderTest.push(10);
                preState.push(10);
            }

            @Test
            void push_singleton_returnsTrue() {
                assertTrue(classUnderTest.push(11));
            }

            @Test
            void pop_singleton_returnsTop() {
                assertEquals(10, classUnderTest.pop());
            }

            @Test
            void pop_singleton_emptyStack() {
                classUnderTest.pop();
                assertEquals(new ArrayStack<>(), classUnderTest);
            }

            // Remaining empty tests excluded here

        }
    }



General Case Stack Tests
========================

* The tests for the more general case of an ``ArrayStack`` with several elements within it are going to follow the same pattern

    * Nested test class
    * Common setup code with a ``BeforeEach``


* In the below code, a noteworthy difference is the use of the ``@TestInstance(TestInstance.Lifecycle.PER_CLASS)`` annotation before the nested test class

    * This specifies that a new test instance is created once per test class
    * For now, do not worry about this detail too much


.. code-block:: java
    :linenos:
    :emphasize-lines: 39


    private ArrayStack<Integer> classUnderTest;
    private ArrayStack<Integer> preState;

    @BeforeEach
    void createStack() {
        classUnderTest = new ArrayStack<>();
        preState = new ArrayStack<>();
    }

    @Nested
    class WhenNewEmpty {

        @Test
        void push_empty_returnsTrue() {
            assertTrue(classUnderTest.push(11));
        }

        // Remaining empty tests excluded here


        @Nested
        class WhenSingleton {

            @BeforeEach
            void addSingleton() {
                classUnderTest.push(10);
                preState.push(10);
            }

            @Test
            void push_singleton_returnsTrue() {
                assertTrue(classUnderTest.push(11));
            }

            // Remaining empty tests excluded here


            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            class WhenMany {

                @BeforeEach
                void addMany() {
                    classUnderTest.push(20);
                    classUnderTest.push(30);
                    classUnderTest.push(40);
                    preState.push(20);
                    preState.push(30);
                    preState.push(40);
                }

                @Test
                void push_many_returnsTrue() {
                    assertTrue(classUnderTest.push(11));
                }

                @Test
                void pop_many_returnsTop() {
                    assertEquals(40, classUnderTest.pop());
                }

                @Test
                void pop_many_newTop() {
                    classUnderTest.pop();
                    assertEquals(30, classUnderTest.peek());
                }

                @Test
                void peek_many_returnsTop() {
                    assertEquals(40, classUnderTest.peek());
                }

                @Test
                void peek_many_unchanged() {
                    classUnderTest.peek();
                    assertEquals(preState, classUnderTest);
                }

                @Test
                void isEmpty_many_returnsFalse() {
                    assertFalse(classUnderTest.isEmpty());
                }

                @Test
                void size_many_returnsCorrectSize() {
                    assertEquals(4, classUnderTest.size());
                }

                @Test
                void toString_many_returnsCorrectString() {
                    assertEquals("40, 30, 20, 10, ", classUnderTest.toString());
                }
            }
        }
    }


.. note::

    The above suggested layout is by no means the *correct* way or a standard for testing collections. It is simply a
    strategy to help manage the complexities of testing collections.



For Next Time
=============

* Finish reading Chapter 3

    * 16 pages


Playing Code
------------

* Download and play with

    * :download:`Stack </../main/java/Stack.java>`
    * :download:`ArrayStack </../main/java/ArrayStack.java>`
    * :download:`ArrayStackTest </../test/java/ArrayStackTest.java>`
