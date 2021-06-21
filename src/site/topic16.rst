************************
Topic #16 --- Exceptions
************************

Runtime Errors
==============

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
