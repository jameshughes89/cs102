**********
Unit Tests
**********

* Feel free to use your laptop
* You are strongly encourage to work with others

    * When you get stuck, ask those sitting around you for help
    * Get used to working together in the labs
    * Peer teaching and peer learning has been empirically shown to be very effective


Before Unit Testing
===================

This lab focuses on writing unit tests for the ``Course`` and ``CourseList`` classes described in the
:doc:`Objects Lab </labs/objects-collections/objects>` and
:doc:`Collections Lab </labs/objects-collections/collections>` respectively. These classes are to be completed before
writing the unit tests. If these classes are not complete, complete them before continuing.


Unit Testing
============

It is always important to ensure code correctness. For this reason, unit tests are written as they help programmers test
their code to demonstrate correctness in a systematic way. While working on this lab, it is strongly recommended to
:doc:`refer to the relevant topic on unit testing </topics/testing/unit-tests>`.



Testing the ``Course`` Class
----------------------------

.. note::

    Give the test methods descriptive names while still being brief. The recommended convention to follow is
    ``method_condition_expected()``, for example:

        * ``getFirstName_generalCase_returnsFirstName``
        * ``size_empty_returnsZero()``
        * ``indexOf_singleton_returnsCorrectIndex()``


#. Create the test class for ``Course`` called ``CourseTest``
#. Write a unit test for ``getProgramCode``
#. Write a unit test for ``getCourseCode``
#. Write a unit test for ``getCourseTitle``
#. Write a unit test for ``toString``
#. Write a unit test for ``equals``

    ** Do **not** write tests for ``hashCode``




    * empty list has size zero?
    * non empty list has proper size?
    * list that has been emptied via removes has size zero?

#. Write tests for ``add``.

    * Is the added element added?
    * Can we add beyond a capacity limit?

#. Write tests for ``remove``.

    * Does the element get removed?
    * What happens if we try to remove something that doesn't exist?
    * What happens when we call remove once for something that exists more than once in the ``CourseList``?

#. Write tests for ``get``.

    * Does it return the element from the correct index?
    * What happens if you try to get something from beyond the range?
    * What happens if you try to get something from a negative index?


#. Write tests for ``indexOf``.

    * Try to figure out which tests you should have on your own/with a friend

#. Write tests for the ``Course`` class.

    * Try to figure out which tests you should have on your own/with a friend


Kattis Problems
===============

Recommended Kattis Problems (don't worry, you don’t need to do all of them or anything):

#. https://open.kattis.com/problems/quadrant
#. https://open.kattis.com/problems/judgingmoose
#. https://open.kattis.com/problems/timeloop
#. https://open.kattis.com/problems/oddities
#. https://open.kattis.com/problems/fizzbuzz
#. https://open.kattis.com/problems/twostones
#. https://open.kattis.com/problems/spavanac
#. https://open.kattis.com/problems/cetvrta
#. https://open.kattis.com/problems/bus
#. https://open.kattis.com/problems/timeloop
#. https://open.kattis.com/problems/oddities
#. https://open.kattis.com/problems/fizzbuzz
#. https://open.kattis.com/problems/sibice
#. https://open.kattis.com/problems/datum
#. https://open.kattis.com/problems/dicecup
#. https://open.kattis.com/problems/autori
#. https://open.kattis.com/problems/apaxiaaans
#. https://open.kattis.com/problems/hissingmicrophone
#. https://open.kattis.com/problems/trik
#. https://open.kattis.com/problems/pot
#. https://open.kattis.com/problems/filip
#. https://open.kattis.com/problems/reversebinary
#. https://open.kattis.com/problems/sevenwonders
#. https://open.kattis.com/problems/zamka
#. https://open.kattis.com/problems/bijele
#. https://open.kattis.com/problems/cold
#. https://open.kattis.com/problems/nastyhacks
#. https://open.kattis.com/problems/grassseed
#. https://open.kattis.com/problems/pet
#. https://open.kattis.com/problems/batterup
#. https://open.kattis.com/problems/aboveaverage
#. https://open.kattis.com/problems/icpcawards
#. https://open.kattis.com/problems/quickbrownfox
#. https://open.kattis.com/problems/nodup
#. https://open.kattis.com/problems/conundrum
#. https://open.kattis.com/problems/bela
#. https://open.kattis.com/problems/kornislav