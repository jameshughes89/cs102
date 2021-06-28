******
Lab #2
******

* Refer to the slides for this lab. You will find many of the answers to your questions there
* Feel free to use your laptop if you have it
* I strongly encourage you to work with others in the lab
* Ensure I have recorded your completion. Failure to do so will result in a grade of 0
* When you get stuck, do me a favour and ask those sitting around you for help
    * I want people to get used to working together in the labs
    * Peer teaching and peer learning is super effective


Playing with Objects
====================

We will make a program that will keep track of a collection of courses offered at StFX. To do this we will write two
classes that, one for keeping track of the information about a single course, and another for keeping track of multiple
courses.


Course Class
------------

A ``Course`` is a simple object that keeps track of data for us.

1. Create a class called ``Course`` that has three private fields: ``programCode``, ``courseCode``, and ``courseTitle``
    * For example, this course would have the following values for the fields
        * ``programCode`` --- ``"CSCI"``
        * ``courseCode`` --- ``"162"``
        * ``courseTitle`` --- ``"Programming and Data Structures"``

2. Write a single constructor to take and assign values to the fields

3. Write getters and setters for each field

4. Write a ``toString`` method that returns ``programCode``, followed by a space, followed by the ``courseCode``
    * ``"CSCI 162"``

5. Write ``equals`` that checks if two ``Course`` objects are equivalent
    * We will say that two courses are the same if their ``programCode`` and ``courseCode`` are the same
    * Remember to be careful with ``==``

6. Test the ``Course`` class by making a few instances of them and calling the methods and see if they work as you expect


Course List Class
-----------------

A ``CourseList`` will be a collection of ``Course`` objects that we can add and remove from.

1. Make a ``CourseList`` class that has two private fields (``list`` and ``size``) and a constant for a default capacity
    * ``list`` will be an array that holds references to ``Course`` objects
    * ``size`` will be the number of ``Courses`` currently in ``list``
        * Remember, the capacity of the array and ``size`` are not the same thing
    * ``DEFAULT_CAPACITY`` is a constant that will be used for creating the ``list`` array if no capacity is provided

2. Write two constructors
    * One that takes no parameter and makes ``list`` based on ``DEFAULT_CAPACITY``
    * The other takes a parameter ``initialCapacity`` for the capacity of ``list``
    * Try to use *constructor chaining*

3. Write an ``add`` method that takes the necessary parameters to create a new ``Course`` object and add it to the collection
    * You will need to also make a private ``expandCapacity`` method for ``add`` to work properly

4. Write a ``remove`` method that takes the necessary parameters to find and remove a ``Course`` from the collection
    * You may want to make use of the ``Course`` object's ``equals`` method

5. Write a ``size`` method to return the number of ``Course`` objects in the collection

6. Write a reasonable ``toString`` for the class

7. Test the ``CourseList`` class by calling the methods


Kattis Problems
===============

Recommended Kattis Problems (don't worry, you don’t need to do all of them or anything):

1. https://open.kattis.com/problems/quadrant
2. https://open.kattis.com/problems/judgingmoose
3. https://open.kattis.com/problems/timeloop
4. https://open.kattis.com/problems/oddities
5. https://open.kattis.com/problems/fizzbuzz
6. https://open.kattis.com/problems/twostones
7.  https://open.kattis.com/problems/spavanac
8. https://open.kattis.com/problems/cetvrta
9. https://open.kattis.com/problems/bus
10. https://open.kattis.com/problems/timeloop
11. https://open.kattis.com/problems/oddities
12. https://open.kattis.com/problems/fizzbuzz
13. https://open.kattis.com/problems/sibice
14. https://open.kattis.com/problems/datum
15. https://open.kattis.com/problems/dicecup
16. https://open.kattis.com/problems/autori
17. https://open.kattis.com/problems/apaxiaaans
18. https://open.kattis.com/problems/hissingmicrophone
19. https://open.kattis.com/problems/trik
20. https://open.kattis.com/problems/pot
21. https://open.kattis.com/problems/filip
22. https://open.kattis.com/problems/reversebinary
23. https://open.kattis.com/problems/sevenwonders
24. https://open.kattis.com/problems/zamka
25. https://open.kattis.com/problems/bijele
26. https://open.kattis.com/problems/cold
27. https://open.kattis.com/problems/nastyhacks
28. https://open.kattis.com/problems/grassseed
29. https://open.kattis.com/problems/pet
30. https://open.kattis.com/problems/batterup
31. https://open.kattis.com/problems/aboveaverage
32. https://open.kattis.com/problems/icpcawards
33. https://open.kattis.com/problems/quickbrownfox
34. https://open.kattis.com/problems/nodup
35. https://open.kattis.com/problems/conundrum
36. https://open.kattis.com/problems/bela
37. https://open.kattis.com/problems/kornislav