**********
Exceptions
**********

* Exceptions are great for keeping a logical separation between the regular code and the exceptional situations
* They make it easy to propagate the exception up the call stack such that the situation can be managed in a desired place
* They also allow for differentiating between exception types and how to deal with them specifically

.. figure:: exceptions.png
    :width: 500 px
    :align: center
    :target: https://www.tutorialspoint.com/java/java_exceptions.htm

    Java's ``Throwable`` class hierarchy.



Errors
======

* In Java, there are two classes of throwable objects

    * A *throwable* object is one that can be thrown with a ``throw`` statement

* Errors are one of the two throwable classes
* Errors are typically for unrecoverable situations

    * They're generally **very** abnormal situations


* Typically, these are not to be caught and handled
* Errors and regarded as *unchecked* for the purpose of compile-time checks



Throwing an Exception
=====================

* Several methods written so far have thrown exceptions
* Below is the ``remove`` method from the ``ArraySortedBag`` implementation

    * ``remove`` may throw an exception when removing from an empty bag, or if the element does not exist within the bag
    * Both cases throw a ``NoSuchElementException``
    * The only difference is the message


.. literalinclude:: /../main/java/ArraySortedBag.java
    :language: java
    :lineno-match:
    :lines: 116-128


.. note::

    Although the ``remove`` method is throwing two possible exceptions of the same type, methods can throw exceptions of
    different types. For example, there could be a case where a certain condition would throw a
    ``NoSuchElementException`` and another condition when a ``ArrayIndexOutOfBoundsException`` would be thrown.


* In the ``remove`` example, the exception being thrown, ``NoSuchElementException``,  is a subclass of ``RuntimeException``

    * It is an unchecked exception, so the method does not need to include a ``throws NoSuchElementException`` in the method signature


* The motivation for using an exception here is that if someone tries to ``remove`` from an empty bag, or if the element does not exist within the bag, what should happen?
* This is going to be situational

    * Perhaps this means some critical error happened and the program must stop immediately
    * Or maybe the program using the bag can just ignore the exception and carry on


* Either way, as the writers of the ``ArraySortedBag``, it is not possible to know how the user of the ``ArraySortedBag`` should address the situation


* Also notice the strings provided the the exceptions' constructors

    * ``"Empty bag"``
    * ``Objects.toString(element)``


* These strings are the *messages* the exceptions provide to give details on the exception

    * Without them, if ``remove`` threw a ``NoSuchElementException``, it would not be possible to know what caused it


* Consider how an ``ArrayIndexOutOfBoundsException`` provides details on the index used that caused the exception


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
    Object o = stack.peek();
    doSomething(o);

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
        Object o = stack.peek();
        doSomething(o);
    } catch (NoSuchElementException e) {
        someCleanUpMethod();
        System.exit(1);
    }


Carry On
--------

* Maybe they can catch it, print out the stack trace, and then carry on and ignore the issue
    * The program keeps our spaceship running, so it better not crash

.. code-block:: java
    :linenos:

    try {
        Object o = stack.peek();
        doSomething(o);
    } catch (NoSuchElementException e) {
        System.out.println("Caught an Exception");
        e.printStackTrace();
    }

Rethrow
-------

* Perhaps we want to catch the exception and then rethrow it as something more appropriate for our context

.. code-block:: java
    :linenos:

    try {
        Object o = stack.peek();
        doSomething(o);
    } catch (NoSuchElementException e) {
        throw new MySpecificDoSomethingException(e);
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


Finally
^^^^^^^

* There is another special keyword, ``finally`` that comes up when dealing with exceptions
* The code within the ``finally`` block will always run, regardless of if an exception was thrown or which exception was caught
* This comes in handy if you have any code that should be run either way
    * Eg. Closing files



For next time
=============

* Read the :doc:`aside on creating your own exceptions. <create>`
* Go back and read Chapter 3 Section 5
    * 2 pages
