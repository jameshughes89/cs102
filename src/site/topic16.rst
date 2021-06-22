************************
Topic #16 --- Exceptions
************************

* We've seen a number of exceptions at this point
* We should also be familiar with them at a fairly high level
* We should know how to use them and handle them

.. image:: img/exceptions.png
   :width: 500 px
   :align: center
   :target: https://www.tutorialspoint.com/java/java_exceptions.htm

* Exceptions are great for keeping a logical separation between the regular code and the exceptional situations
* They make it easy to propagate the exception up the call stack so the situation can be managed in a desired place
* It also allows us to group and differentiate between exception types and how to deal with them specifically


Errors
======

* In Java, there are two classes of throwable objects
    * A *throwable* object is one that can be thrown with a ``throw`` statement

* Errors are one of the two throwable classes
* Errors are typically for unrecoverable situations
    * They're generally **very** abnormal situations
* We will not try to handle and catch Errors
* Errors and regarded as *unchecked* for the purpose of compile-time checks


Exceptions
==========

* Exceptions are *exceptional* situations that programs may want to handle
* There are two types of exceptions
    * Unchecked
    * Checked

Unchecked
---------

* Unchecked exceptions are ``RuntimeException``s
* These are exceptions that can be thrown during the normal operation of the JVM
* Many of the exceptions you have come across are examples of unchecked exceptions

.. code-block:: java
    :linenos:

    Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 7 out of bounds for length 5
        at SomeClass.main(SomeClass.java:7)

.. code-block:: java
    :linenos:

    Exception in thread "main" java.lang.NullPointerException
        at SomeClass.main(SomeClass.java:8)

.. code-block:: java
    :linenos:

    Exception in thread "main" java.lang.ArithmeticException: / by zero
        at SomeClass.main(SomeClass.java:10)

* Unchecked exceptions are propagated to the calling method if they are not handled within the method the exception was thrown from


Checked
-------

* Checked exceptions are those that are ``Exception``s but **not** ``RuntimeException``s
* Checked exceptions must be explicitly addressed by either
    * Handling the exception within the method
    * Propagating the exception to the calling method
        * ``throws``

* At compile-time, these exceptions are checked to see if they are managed
* If you do not, Java or your IDE will tell you
    * More specifically, Java's *type checker* will yell at you
    * The *type checker* is the process of ensuring that the types of expressions are consistent

.. code-block:: java
    :linenos:

    SomeClass.java:14: error: unreported exception FileNotFoundException; must be caught or declared to be thrown


Example
^^^^^^^

.. code-block:: java
    :linenos:
    :emphasize-lines: 2

    /** Checks to make sure that the stream has not been closed */
    private void ensureOpen() throws IOException {
        if (in == null)
            throw new IOException("Stream closed");
    }

* The method ``ensureOpen`` is straight from ``java.io``'s ``BufferedReader`` class
* An ``IOException`` is an example of a checked exception, thus it must be explicitly and deliberately addressed in some way
* This method, ``ensureOpen``, is being called by various other methods within the ``BufferedReader`` class and it doesn't make much sense to handle the exception here within this method
* For this reason, we will let Java know that we will *propagate* the checked exception to the calling method by adding ``throws IOException`` to the method signature
* The calling method will have to either handle it then and there, or it too must let Java know that we will propagate the exception to its calling method with the ``throws`` keyword

* We didn't need the ``throws`` keyword for unchecked exceptions, but need it for checked exceptions since Java requires us to explicitly and deliberately manage the checked exceptions


Throwing an Exception
=====================

* We have seen multiple examples of throwing an exception
* Below is ``peek`` from our ``LinkedStack`` implementation
* ``peek`` may throw an exception if we try to ``peek`` from an empty stack
    * Note, although a method can only throw one exception at a time, it may have multiple throw statements with various types of exceptions

.. code-block:: java
    :linenos:
    :emphasize-lines: 3

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Popping from an empty stack.");
        }
        return top.getData();
    }

* In this ``peek`` example, the exception being thrown, ``NoSuchElementException``,  is a subclass of ``RuntimeException``
    * It is an unchecked exception, so we don't explicitly need to add ``throws`` to our method signature

* The motivation for using an exception here is that if someone tries to ``peek`` at an empty stack and it's empty, what should happen?
* This is going to be situational
    * Perhaps this means some critical error happened, so the program must stop immediately
    * Or maybe the program using our stack can just ignore the exception and carry on
    * Either way, I cannot know today how you may want to address this exception in your code tomorrow

* You will also see the string ``"Popping from an empty stack."`` in the ``peek`` method
    * This is the exception message
* This would be like the message you see when you get an ``ArrayIndexOutOfBoundsException`` or ``NullPointerException``
* When your program crashes due to a runtime exception, you will also see the *stack trace*

Catching Exceptions
===================



For next time
=============

* Go back and read Chapter 3 Section 5
    * 2 pages
