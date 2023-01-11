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



Testing the ``CourseList`` Class
--------------------------------

.. warning::

    Writing unit tests for collections is quite difficult for a variety of reasons. For example, consider that
    collections can have various different states --- empty, single element, many elements, duplicate elements.

    Consider ``remove``:

        * What should happen when ``remove`` is called on an empty ``CourseList``?
        * What should happen when ``remove`` is called on a ``CourseList`` with one element?
        * What should happen when calling it on a ``CourseList`` with many elements?
        * What should happen when trying to ``remove`` an element that does not exist in the ``CourseList``?
        * What should happen when there are multiple equal ``Course`` objects to be removed?


    Try to test each method as thorough as possible.


#. Write unit tests for ``add``
#. Write unit tests for ``contains``
#. Write unit tests for ``indexOf``
#. Write unit tests for ``remove``
#. Write unit tests for ``get``
#. Write unit tests for ``size``
#. Write unit tests for ``toString``



Kattis Problems
===============

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