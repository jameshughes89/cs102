************************
Topic #16 --- Exceptions
************************

Runtime Errors
==============

Throwing an Exception
=====================

Catching Exceptions
===================

* If someone is using our ``LinkedStack`` for their code 2 years from now, I can't know what they should do to manage peeking from an empty stack
* The users of our class will need to deal with this how they want


Ignore
------

* Maybe this doesn't matter to them and they don't even try to catch the exception
    * If the exception is thrown, their program will crash, but this doesn't matter to them

.. code-block:: java
    :linenos:

    // I know this may throw an exception, but whatever
    stack.peek();

* Since the exception is not caught here, the exception would be propagated to the calling method
* This exception will keep being propagated to the calling methods until it is either
    * Caught somewhere
    * The main method propagates the exception and the program crashes


Stop Immediately
----------------

* Maybe they need to stop the execution of the code immediately
    * They are running medical equipment that delivers radiation therapy

.. code-block:: java
    :linenos:

    try {
        stack.peek();
    } catch (NoSuchElementException e) {
        System.out.println("HALTING EXECUTION IMMEDIATELY!");
        System.exit(1);
    }


Carry On
--------

* Maybe they can catch it, print out the stack trace, and then carry on and ignore the issue
    * The program keeps our spaceship running, so it better not crash

.. code-block:: java
    :linenos:

    try {
        stack.peek();
    } catch (NoSuchElementException e) {
        System.out.println("Caught an Exception");
        e.printStackTrace();
    }


In General
----------

* If it is possible that the code we are trying may throw different types of exceptions, we can have a catch for each
* The general idea is as follows

.. code-block:: java
    :linenos:

    try {
        mayThrowVariousExceptions();
    } catch (SomeExceptionA e) {
        handleSomeExceptionA();
    } catch (SomeExceptionB e) {
        handleSomeExceptionB();
    } catch (SomeExceptionC e) {
        handleSomeExceptionC();
    } finally {
        codeThatWillAlwaysRun();
    }

* If you have multiple ``catch`` statements, we must be careful to mind our exception hierarchy
* Always order your ``catch`` statements from most specific to most general
* Take for example ``IOException`` and ``FileNotFoundException``

.. code-block:: java
    :linenos:

    // This is bad
    try {
        ...
    } catch (IOException e) {
        ...
    } catch (FileNotFoundException e) {
        ...
    }

* Since ``FileNotFoundException`` is a subclass of ``IOException``, if a ``FileNotFoundException`` is thrown the first ``catch`` statement will catch it
* In this scenario, it would not be possible to run the code within the second ``catch`` statement
* This is easily fixed by switching the order of the ``catch`` statements



For next time
=============

* Go back and read Chapter 3 Section 5
    * 2 pages
