************************
Topic #16 --- Exceptions
************************

Runtime Errors
==============


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


Checked
-------

* Checked exceptions are those that are ``Exception``s but **not** ``RuntimeException``s
* Checked exceptions must be explicitly addressed by either
    * Handling the exception within the method
    * Propagating the exception to the calling method
        * ``throws``

* At compile-time, these exceptions are checked to see if they are managed
* If you do not, Java or your IDE will tell you

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
* Unchecked exceptions will simply be propagated to the calling method if they are not handled within the method the exception was thrown from


Throwing an Exception
=====================

Catching Exceptions
===================

For next time
=============

* Go back and read Chapter 3 Section 5
    * 2 pages
