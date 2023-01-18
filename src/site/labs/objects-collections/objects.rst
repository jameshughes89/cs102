*******
Objects
*******

* Feel free to use your laptop
* You are strongly encourage to work with others

    * When you get stuck, ask those sitting around you for help
    * Get used to working together in the labs
    * Peer teaching and peer learning has been empirically shown to be very effective


Creating Objects
================

The goal is to make a program that will keep track of a suite of courses. To do this, two classes will be written ---
one for keeping track of the information about a single course, and another for keeping track of multiple courses. In
this lab, the ``Course`` class will be created.


Course Class
------------

A ``Course`` is a simple object to keeps track of data.
:doc:`Refer to the objects review topic </topics/objects-review/objects-review>` for guidance on creating this class.


#. Create a class called ``Course`` that has three private fields: ``programCode``, ``courseCode``, and ``courseTitle``

    * For example, this course would have the following values for the fields

        * ``programCode`` --- ``"CSCI"``
        * ``courseCode`` --- ``"162"``
        * ``courseTitle`` --- ``"Programming and Data Structures"``


#. Write a single constructor to take and assign values to the fields
#. Write accessor methods for the three fields

    * For example, ``getCourseCode``


#. Write a ``toString`` method that returns a string representation of the object

    * The string should be of the form ``"Course(programCode, courseCode, courseTitle)"``


#. Write an ``equals`` method that checks if two ``Course`` objects are equivalent

    * Two ``Course`` objects are considered equal if all their fields match
    * Remember, do not check string equality with ``==``


#. Write a ``hashCode`` method
#. Test the ``Course`` class by making instances of them and calling the methods to see if they work as expected

    * Create a few instances of the ``Course`` class in ``main``
    * Call their methods and check if their behaviour is as expected
    * Be sure to check all methods



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