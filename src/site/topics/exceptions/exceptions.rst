**********
Exceptions
**********

* Exceptions provides a way to logical separate the regular code and what to do in an exceptional situation
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
    * The only difference is the string provided to the constructor of the exception --- the  *message*


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
* All that can be done is to throw the exception to inform the user of the ``ArraySortedBag`` that something exceptional happened



Messages
--------

* Notice the strings provided the the exceptions' constructors

    * ``"Empty bag"``
    * ``Objects.toString(element)``


* These strings are the *messages* the exceptions provide to give details on the exception

    * Without them, if ``remove`` threw a ``NoSuchElementException``, it would not be possible to know what caused it


* Consider how an ``ArrayIndexOutOfBoundsException`` provides details on the index used that caused the exception



Catching Exceptions
===================

* If someone is using the ``ArraySortedBag`` implementation two years from now, it's not possible to know what they should do to manage the exceptional situations
* The users of the ``ArraySortedBag`` class will need to deal with them as they see fit

    * What should be done if calling ``remove`` on an empty ``ArraySortedBag``?
    * What should be done if calling ``remove`` when the element does not exist within the ``ArraySortedBag``?


Ignore
------

* Maybe this doesn't matter and they don't even try to catch the exception

    * If the exception is thrown, their program will crash, but this doesn't matter to them


.. code-block:: java
    :linenos:

    // I know this may throw an exception, but whatever
    bag.remove(element);



* Since the exception is not caught here, the exception would be propagated to the calling method
* This exception will keep being propagated to the calling methods until it is either

    * Caught somewhere
    * The ``main`` method propagates the exception and the program crashes



Stop Immediately
----------------

* Maybe they need to stop the execution of the code immediately

    * They are running medical equipment that delivers radiation therapy


.. code-block:: java
    :linenos:

    try {
        bag.remove(element);
    } catch (NoSuchElementException e) {
        someCleanUpMethod();
        System.exit(1);
    }



Carry On
--------

* Maybe they can catch it, print out the stack trace, and then carry on and ignore the issue

    * The program keeps the spaceship running, so it better not crash


.. code-block:: java
    :linenos:

    try {
        bag.remove(element);
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
        bag.remove(element);
    } catch (NoSuchElementException e) {
        throw new MySpecificException(e);
    }



Catching Different Exception Types
==================================

* It is possible that the code being called may throw different exception types
* These can be individually caught and handled accordingly
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


* With multiple ``catch`` statements, the exception class hierarchy must be considered
* Always order the ``catch`` statements from most specific to most general
* For example ``IOException`` and ``FileNotFoundException``

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


* Since ``FileNotFoundException`` is a subclass of ``IOException``, if a ``FileNotFoundException`` is thrown, the first ``catch`` statement will catch it
* In this scenario, it would not be possible for the code within the second ``catch`` statement to ever run
* This is easily fixed by switching the order of the ``catch`` statements



Finally
-------

* Sometimes it is necessary to have some code run regardless of if an exception was thrown or which exception was caught
* The ``finally`` keyword is used to specify code to be run no matter what happens

    * Eg. Closing files



For Next Time
=============

* Go back and read Chapter 3 Section 5

    * 2 pages
