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