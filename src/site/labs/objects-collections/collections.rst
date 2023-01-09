***********
Collections
***********

* Feel free to use your laptop
* You are strongly encourage to work with others

    * When you get stuck, ask those sitting around you for help
    * Get used to working together in the labs
    * Peer teaching and peer learning has been empirically shown to be very effective


Creating Objects
================

The goal is to make a program that will keep track of a suite of courses. To do this, two classes will be written ---
one for keeping track of the information about a single course, and another for keeping track of multiple courses. In
this lab, the ``CourseList`` class will be created as the ``Course`` class was written in the previous lab.


Course List Class
-----------------

A ``CourseList`` will be a collection of ``Course`` objects.
:doc:`Refer to the data structures review topic </topics/objects-review/data-structures-review>` for guidance on
creating this class. It is recommended to go through the topic and refactor the relevant code to fit the requirements of
this lab. 


#. Make a ``CourseList`` class that has two private fields (``list`` & ``size``) and a constant for a default capacity

    * ``list`` will be an array that holds references to ``Course`` objects
    * ``size`` will be the number of ``Course`` objects currently in ``list``

        * Remember, the capacity of the array and ``size`` are not the same thing

    * ``DEFAULT_CAPACITY`` is a constant that will be used for creating the ``list`` array if no capacity is provided


#. Write two constructors

    * One takes no parameter and makes ``list`` based on ``DEFAULT_CAPACITY``
    * The other takes a parameter ``initialCapacity`` for the starting capacity of ``list``
    * :doc:`Try to use constructor chaining </topics/objects-review/chaining>`


#. Write an ``add`` method that takes a ``Course`` object and adds it to the collection

    * This will require a mechanism to "expand the capacity" of the array  to work properly


#. Write a ``contains`` method that takes a ``Course`` as a parameter and returns ``true`` if it exists in the collection and ``false`` otherwise
#. Write a ``indexOf`` method that returns the index of a specified ``Course`` object

    * If no such ``Course``  exists, this method should throw an exception


#. Write a ``remove`` method that takes a ``Course`` to remove from the collection as a parameter

    * If no such ``Course``  exists, this method should throw an exception
    * Make use of the ``Course`` object's ``equals`` method


#. Write a ``get`` method that returns the ``Course`` object at the specified index in the ``CourseList``

    * If the provided index is out of bounds, this method should throw an exception


#. Write a ``size`` method to return the number of ``Course`` objects in the collection
#. Write a ``toString`` for the class
#. Test the ``CourseList`` class by creating an instance of it and using the methods

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