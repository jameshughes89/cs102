***********************
Objects and Collections
***********************

* Feel free to use your laptop
* You are strongly encourage to work with others

    * When you get stuck, ask those sitting around you for help
    * Get used to working together in the labs
    * Peer teaching and peer learning has been empirically shown to be very effective


Creating Objects
================

The goal is to make a program that will keep track of a suite of courses. To do this, two classes will be written ---
one for keeping track of the information about a single course, and another for keeping track of multiple courses.


Course Class
------------

A ``Course`` is a simple object to keeps track of data. Refer to topic
:doc:`Java vs. Python topic </topics/objects-review/objects-review>` for guidance on creating this class.


#. Create a class called ``Course`` that has three private fields: ``programCode``, ``courseCode``, and ``courseTitle``

    * For example, this course would have the following values for the fields

        * ``programCode`` --- ``"CSCI"``
        * ``courseCode`` --- ``"162"``
        * ``courseTitle`` --- ``"Programming and Data Structures"``


#. Write a single constructor to take and assign values to the fields
#. Write accessors methods for the three fields

    * For example, ``getCourseCode``


#. Write a ``toString`` method that returns a string representation of the object

    * The string should be of the form ``"Course(programCode, courseCode, courseTitle)"``


#. Write an ``equals`` method that checks if two ``Course`` objects are equivalent

    * Two ``Course`` objects are considered equal if all their fields match
    * Remember, do not check string equality with ``==``


#. Write a ``hashCode`` method
#. Test the ``Course`` class by making instances of them and calling the methods to see if they as expected



Course List Class
-----------------

A ``CourseList`` will be a collection of ``Course`` objects that we can add and remove from.

#. Make a ``CourseList`` class that has two private fields (``list`` & ``size``) and a constant for a default capacity.

    * ``list`` will be an array that holds references to ``Course`` objects
    * ``size`` will be the number of ``Courses`` currently in ``list``

        * Remember, the capacity of the array and ``size`` are not the same thing

    * ``DEFAULT_CAPACITY`` is a constant that will be used for creating the ``list`` array if no capacity is provided

#. Write two constructors.

    * One that takes no parameter and makes ``list`` based on ``DEFAULT_CAPACITY``
    * The other takes a parameter ``initialCapacity`` for the capacity of ``list``
    * Try to use *constructor chaining*

#. Write an ``add`` method that takes a ``Course`` object and adds it to the collection.

    * You will need to also make a private ``expandCapacity`` method for ``add`` to work properly

#. Write a ``remove`` method that takes a ``Course`` to find and remove a ``Course`` from the collection.

    * Make use of the ``Course`` object's ``equals`` method

#. Write a ``get`` method that returns the ``Course`` object from the specified index in the ``CourseList``.

#. Write a ``indexOf`` method that returns the index of a specified ``Course`` object.

#. Write a ``size`` method to return the number of ``Course`` objects in the collection.

#. Write a reasonable ``toString`` for the class.

#. Test the ``CourseList`` class by calling the methods.


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