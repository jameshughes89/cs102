**********
Exceptions
**********


.. image:: exceptions.png
   :width: 500 px
   :align: center
   :target: https://www.tutorialspoint.com/java/java_exceptions.htm

* Exceptions are great for keeping a logical separation between the regular code and the exceptional situations
* They make it easy to propagate the exception up the call stack such that the situation can be managed in a desired place
* They also allow for differentiating between exception types and how to deal with them specifically


Errors
======

* In Java, there are two classes of throwable objects
    * A *throwable* object is one that can be thrown with a ``throw`` statement

* Errors are one of the two throwable classes
* Errors are typically for unrecoverable situations
    * They're generally **very** abnormal situations
* We will not try to handle and catch Errors
* Errors and regarded as *unchecked* for the purpose of compile-time checks


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
