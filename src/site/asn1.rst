************************************************
Assignment #1: Playing with Objects is Still Fun
************************************************

* **Worth**: 10%
* **DUE**: TBD at 11:55pm; submitted on MOODLE.


Task
====

You will be creating a simple collection to keep track of ``Country`` objects. This will require you to write classes,
use the classes, and write some various methods outlined below.

Effectively, the idea is to recreate your assignment 4 from CSCI 161, but in Java. Be aware that the assignment is not
identical and the requirements outlined here will be what is required.

You will

* Write a ``Country`` class with a few simple methods
* Write a ``CountryCatalogue`` class with methods making use of instances of a ``Country``
* Testing your implementation


Provided Files
==============

You are provided with

* A nearly empty *Country.java* file where you will write your ``Country`` class
* A nearly empty *CountryCatalogue.java* file where you will write your ``CountryCatalogue`` class
* An *Asn1.java* file with a ``main`` method and some testing code
* Data files
    * A *data.txt* file containing some country details
    * A *continent.txt* file containing country and continent information


Part 0 --- Read the Assignment
==============================

Read the assignment description in its entirety before starting.


Part 1 --- Country
==================

You will be creating a class called ``Country`` that will hold some basic data. The data being stored will be the
country ``name`` (string), ``population`` (int), ``area`` (double), and ``continent`` (string). This class will be used by the
``CountryCatalogue`` class discussed in Part 2.

#. Write a constructor for the ``Country`` class that takes four (4) parameters that will be stored as class fields
    * String ``name``
    * int ``population``
    * double ``area``
    * String ``continent``

#. Write getter methods for each class field

#. Write a setter method for the country's ``population``
    * This will be the only setter we need as the other fields do not typically change all too often for countries

#. Write a ``toString`` method that returns a string containing the country ``name``, ``continent``, ``population``, and ``area``, all seperated by commas and a space

    ``"Canada, North America, 34207000, 9976140.00"``

#. Write an ``equals`` method
    * We will want to get an ``Object`` as a parameter, **not** simply a ``Country`` --- :doc:`follow topic 3's aside on equals </topic3-equals>`
    * Simply check if all fields are the same --- for our purposes, if they are, then we'll say they are equal

#. You will notice an existing method called ``hashCode`` within the ``Country`` class that returns an integer
    * This was briefly discussed last semester when learning about dictionaries
    * This method turns an object into an integer (*ideally* unique) for the purposes of hashing
    * Do not worry about understanding this completely at this stage
        * It's here because it is needed for the hash map in the ``CountryCatalogue`` class discussed below
        * `If you are interested, checkout the relevant wiki article <https://en.wikipedia.org/wiki/Hash_function>`_

#. Write some simple testing code to ensure the object is working as you expect
    * Try creating instances
    * Getting their fields, setting the population, etc.
    * This testing code is **not** to be submitted


Part 2 --- Country Catalogue
============================

The ``CountryCatalogue`` class will be a collection of ``Country`` objects.

There will be three fields

    * ``size``, an int to keep track of the number of countries in the catalogue
    * ``catalogue``, an array of ``Country`` objects
    * ``countryContinent``, a *hash map* to keep track of the country/continent relationships
        * A map is the same idea as a dictionary from Python
        * `How does one use a hash map? <https://www.google.com/search?q=java+hashmap&oq=java+hashmap>`_

There will also be a static constant

    * An integer for this class called ``DEFAULT_CAPACITY`` that should be set to 10
        * This will be used as a starting size for the ``catalogue`` array

#. Create a constructor that will setup and create an empty catalogue of countries
    * This constructor should set the ``size``, ``catalogue``, and ``countryContinent`` fields appropriately

#. Write an ``add`` method that will take all the information needed to create a new ``Country`` object (name, population, area, continent) as parameters and add it to the ``catalogue``
    * It is possible that our ``catalogue`` array runs out of space, so we may need to ``expandCapacity``
    * Be sure to properly keep track of the number of countries in the catalogue
    * Do not forget about the ``countryContinent`` map

#. Write a private method called ``expandCapacity`` that will double the size of the ``Country`` array used for holding reference to the countries
    * Always double the size of the array

#. Create a ``remove`` method that removes a ``Country`` object from the ``catalogue`` based on the parameterized country name
    * Remember to keep track of the size
    * Do not worry about eliminating anything from the ``countryContinent`` map
    * Be careful about how you are comparing strings
    * If the country is not in the ``catalogue``, everything should be left alone

#. Write a ``find`` method to perform a linear search for a ``Country`` based on the country name passed to the method as a parameter
    * This method will return the ``Country`` object
    * If the specified country does not exist, return ``null``


#. Create a method called ``setPopulation`` that takes a name of a country and a new population value for that country as parameters

#. Have a method called ``numberCountriesOnContinent`` that takes a continent name as a parameter and returns the number of ``Country`` objects on that continent

#. Write a method called ``filterCountriesByContinent`` that takes a continent name as a parameter and returns a new ``CountryCatalogue`` instance containing only the countries on the specified continent

#. A method called ``findCountryLargestPopulation`` that returns the ``Country`` with the largest population in the ``catalogue``

#. Have a method called ``findMostPopulousContinent`` that returns the name of the continent with the largest total population based on the countries in the ``catalogue``

#. Write the ``toString`` method to return a ``String`` with each ``Country`` object's details on a separate line
    * The ``Country`` class' ``toString`` will be useful for getting the object's details
    * Below is an example

            ``China, Asia, 1339190000, 9596960.0``

            ``United States of America, North America, 309975000, 9629091.0``

            ``Brazil, South America, 193364000, 8511965.0``



Part 3 --- Load Files
=====================

#. Create a constructor that will setup the catalogue of countries based on some text files --- you may find this to be the must difficult part of the assignment
    * Takes two strings as parameters for the file names of the text files to be opened
    * Based on the continent file, the constructor will populate the ``countryContinent`` map
    * Based on the file containing the country details, along with the ``countryContinent`` data, populate the ``catalogue`` array with appropriate ``Country`` objects
        * Be sure to keep track of the size of the ``catalogue``
        * Maybe one of the below methods will help make this part easier?
    * **Note:** To keep things simpler, the constructor will have ``throws IOException`` so you do not need to worry about the ``try`` and ``catch`` blocks for the file I/O


Part 4 --- Testing
==================

#. Run the main method and check if the output is what you would expect
    * I am not going to provide you with the correct output
    * You should be able to determine this on your own


Some Hints
==========

* Work on one method at a time.
* Get each method *working perfectly* before you go on to the next one.
* *Test* each method as you write it.
    * This is a really nice thing about programming; you can call your methods and see what result gets returned. Does it seem correct?
    * Mentally test before you even write --- what does this method do? What problem is it solving?
* If you need help, **ask**! Drop by my office hours.


Some Marking Details
====================

.. warning::
    Just because your program produces the correct output, that does not necessarily mean that you will get perfect, or even that your program is correct.

Below is a list of both *quantitative* and *qualitative* things we will look for:

* Correctness?
* Did you follow instructions?
* Comments?
* Variable Names?
* Style?
* Did you do just weird things that make no sense?


What to Submit to Moodle
========================

Submit your work on Moodle.

* Your ``.java`` files. Please do not compress them.

* Make sure your **NAME** and **STUDENT NUMBER** appear in a comment at the top of the program.

**VERIFY THAT YOUR SUBMISSION TO MOODLE WORKED!**
**IF YOU SUBMIT INCORRECTLY, YOU WILL GET A 0**


FAQ:
====

* I don't know where to start.
    * Did you read the assignment description?

* I still don't know where to start.
    * Part 1.

* Should I be making any changes to the provided code/files?
    * No.

* I know you told me to do it this way, but I did it another way, and I think my way is better.
    * Your way may be better, but do it the way I told you.

* I don't know how to do *X*.
    * OK, go to `google.ca <https://www.google.ca>`_ and type in *X*.

* You have asked us to do something you never taught us.
    * Good thing google exists and you're capable of learning learn on your own.

* Can I email you or the TA for help?
    * Absolutely, *buuuuut*, do not send me code, do not send me screenshots of code, do not try to describe chunks of code in english, etc.
    * Email is appropriate for quick clarification questions.
    * Anything beyond that should be addressed at office hours.
    * Please do not just send the email anyways to fish and see if I will answer --- I won't, and I'll be annoyed.

* I swear I did everything right, but my files are not opening.
    * This one isn't uncommon.
    * Your files may be in the wrong location on your computer.

* It's not working, therefore Java is broken!
    * Probably not; you're likely doing something wrong.

* There is a bug in my code and it's not working
    * Welcome to writing code.
    * Keep at it, you'll get there.

* There is a bug in my code and it's not working after hours of debugging
    * This is normal.
    * Keep at it, you'll get there.
    * I believe in you.

* Do I have enough comments?
    * I don't know, maybe?
    * If you're looking at code and have to ask if you should comment it... just comment it.
    * That said, don't write me a book.

* I know I cheated, I know I know I was cheating, but I'm reeeeaaaaaaaaallllllly sorry [that I got caught]. Can we just ignore it this time?
    * No.

* What's this whole *due date* and *cutoff date* business?
    * The due date is the due date, so hand things in before the due date, but you may submit your assignment with no penalty up to the cutoff date.

* Can I have an extension?
    * You can have the 7 days before the cutoff period.
    * After the cutoff date though, no --- no extension.

* If I submit it at 11:56pm, you'll still mark it, right? I mean, commmmon!
    * No.
    * 11:55pm and earlier is on time.
    * Anything after 11:55pm is late.
    * Anything late is not marked.
    * It's rather simple really.

* Moodle was totally broken, it's not my fault it's late.
    * Nice try.

* I accidentally submitted the wrong code. Here is the right code, but it's late. But you can see that I submitted the wrong code on time! You'll still accept it, right?
    * Do you think I was born yesterday?
    * No.

* Will I really get 0 if I do the submission wrong? Like, what if I submit the .class instead of the .java?
    * Yes, you'll really get a **ZERO**.

