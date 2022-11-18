**********
Unit Tests
**********

* Feel free to use your laptop if you have it
* I strongly encourage you to work with others in the lab

    * When you get stuck, do me a favour and ask those sitting around you for help
    * I want people to get used to working together in the labs
    * Peer teaching and peer learning is super effective


Unit Testing
============

We're going to write tests for our ``CourseList`` class from the
:doc:`Objects and Collections Lab </labs/objects-collections/objects-collections>`.
:doc:`The Stack topic's aside on testing will be of great help here </topics/stacks/unit-tests>`.


Have a Working Implementation
-----------------------------

#. If you have not already, finish the
:doc:`Objects and Collections Lab </labs/objects-collections/objects-collections>`


Writing Tests
-------------

.. note::

    Make your test method names as descriptive as possible while still being brief. Follow some convention for your
    method names, something like ``method_condition_expected()``. For example

        * ``size_emptyCourse_returnsZero()``
        * ``indexOf_existingCourse_returnsCorrectIndex()``


#. Create your testing class for ``CourseList`` called ``CourseListTest``.

#. Write unit tests to test the ``size()`` method.

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