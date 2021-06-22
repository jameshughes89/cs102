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
* Errors and regarded as *unchecked* exceptions for the purpose of compile-time checking of exceptions


Throwing an Exception
=====================

Catching Exceptions
===================



For next time
=============

* Go back and read Chapter 3 Section 5
    * 2 pages
