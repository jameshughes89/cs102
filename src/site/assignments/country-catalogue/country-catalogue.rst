************************************************
Assignment #1: Playing with Objects is Still Fun
************************************************

* **Worth**: 5%
* **DUE**: TBD 11:55pm; submitted on MOODLE.



Task
====

The goal is to create a collection of ``Country`` objects. The collection, called a ``CountryCatalogue``, will provide
functionality to store (add/remove) the ``Country`` objects in addition to making inquiries about the data in the
collection.

Effectively, the idea is to recreate your assignment 4 from CSCI 161, but in Java. Be aware that the assignment is not
identical and the requirements outlined here will be what is required.

You will

* Create a ``Country`` class to store details about a country
* Create a ``CountryCatalogue`` class

    * Provide a way to add and remove ``Country`` objects
    * Search through the catalogue
    * Ask questions about the data in the catalogue
    * Filter data in the catalogue


* Test the implementation with the provided test classes
* Use the classes to build a ``CountryCatalogue``
* Read data from a file
* Write data to a file



Provided Files
==============

You are provided with

* A nearly empty *Country.java* file to be completed
* A nearly empty *CountryCatalogue.java* file to be completed
* A completed *Asn1.java* file with a ``main`` method and some testing code
* A csv file called *country_data.csv* containing information about countries to be added to a ``CountryCatalogue``
* A completed *CountryTest.java* file containing unit tests for the ``Country`` class
* A completed *CountryCatalogueTest.java* file containing unit tests for the ``CountryCatalogue`` class


* :download:`All of this can be downloaded from here <Assignment1.zip>`

    * This is a compressed IntelliJ project
    * Just unzip, put it where you want on your computer, and you should be able to open this project through IntelliJ


.. warning::

    When opening the project, IntelliJ may mention a missing JDK. If this is the case, simply select the download link
    in the notification to download and install the missing JDK.



Part 0 --- Read the Assignment
==============================

Read the assignment description in its entirety before starting.



Part 1 --- Country
==================

The ``Country`` class will store data related to the country it represents. The data stored will be the  country
``name``, ``population``, ``area``, and ``continent``. The ``CountryCatalogue`` class described in part 2 will store
instances of the ``Country`` class.


#. Write a constructor for the ``Country`` class that takes four (4) parameters to be stored as class fields

    * ``name`` --- type ``String``
    * ``continent`` --- type ``String``
    * ``population`` -- type ``long``
    * ``area`` --- type ``double``

    .. note::

        Notice that the type for ``population`` is a ``long``. One may be tempted to simply use an ``int``, but the
        ``int`` type has a limitation.

        In Java, ``int`` values are stored in four bytes (4B)/32 bits (32b), which means the number of unique values the
        ``int`` can represent is :math:`2^{32}`, which is :math:`4,294,967,296`. More specifically, ``int`` values can
        store values between :math:`-2,147,483,648` and :math:`+2,147,483,647`. Since the population of continents can
        exceed two billion, the ``int`` is not going to work.

        The simplest solution to this problem is to make use of the ``long`` type. ``long`` values are just like ``int``
        values, but are stored in eight bytes (8B)/64 bits (64b). This means a ``long`` can represent :math:`2^{64}`
        (:math:`1.84^{19}`) unique values.


#. Write accessor/getter methods for each class field
#. Write a method to calculate and return the population density (``population/area``)
#. Write a ``toString`` method to return a string following the pattern ``ClassName(field=value, field=value, ... )``

    * For example --- ``Country(name=Canada, continent=North America, population=34207000, area=9976140.00)``
    * Mind the format of the string --- the area field has two decimal places

        * `Consider using the format method from the String class <https://www.google.com/search?q=java+string+format>`_


#. Write an ``equals`` and ``hashCode`` method

    * Two ``Country`` objects will be considered equal if all fields match
    * `Be mindful of how the double values are compared <https://www.google.com/search?q=java+double+compare>`_


#. Run the unit tests to ensure the ``Country`` class works properly



Part 2 --- Country Catalogue
============================

The ``CountryCatalogue`` class will be a collection of ``Country`` objects.

There will be two fields

    * ``size``, an int to keep track of the number of countries in the catalogue
    * ``catalogue``, an array of ``Country`` objects

There will also be a static constant

    * An integer for this class called ``DEFAULT_CAPACITY`` that should be set to 10
        * This will be used as a starting size for the ``catalogue`` array

#. Create a constructor that will setup and create an empty catalogue of countries
    * This constructor should set the ``size`` and ``catalogue`` fields appropriately

#. Write an ``add`` method that will take all the information needed to create a new ``Country`` object (name, population, area, continent) as parameters and add it to the ``catalogue``
    * It is possible that our ``catalogue`` array runs out of space, so we may need to ``expandCapacity``
    * Be sure to properly keep track of the number of countries in the catalogue

#. Write a private method called ``expandCapacity`` that will double the size of the ``Country`` array used for holding reference to the countries
    * Always double the size of the array

#. Create a ``remove`` method that removes a ``Country`` object from the ``catalogue`` based on the parameterized country name
    * Remember to keep track of the size
    * Be careful about how you are comparing strings
    * If the country is not in the ``catalogue``, everything should be left alone
    * If more than one ``Country`` object with the same name exists in the ``catalogue``, only remove the first one

#. Write a ``find`` method to perform a linear search for a ``Country`` based on the country name passed to the method as a parameter
    * This method will return the ``Country`` object
    * If the specified country does not exist, return ``null``


#. Create a method called ``setPopulation`` that takes a name of a country and a new population value for that country as parameters

#. Have a method called ``numberCountriesOnContinent`` that takes a continent name as a parameter and returns the number of ``Country`` objects on that continent

#. Write a method called ``filterCountriesByContinent`` that takes a continent name as a parameter and returns a new ``CountryCatalogue`` instance containing only the countries on the specified continent

#. A method called ``findCountryLargestPopulation`` that returns the ``Country`` with the largest population in the ``catalogue``

#. Have a method called ``findMostPopulousContinent`` that returns the name of the continent with the largest total population based on the countries in the ``catalogue``
    * I strongly recommend making use of a *hash map* to keep track of continent populations
    * A map is the same idea as a dictionary from Python
    * `How does one use a hash map? <https://www.google.com/search?q=java+hashmap&oq=java+hashmap>`_

#. Write the ``toString`` method to return a ``String`` with each ``Country`` object's details on a separate line
    * The ``Country`` class' ``toString`` will be useful for getting the object's details
    * Note that you may see some of the area vales represented in scientific notation --- this is OK
        * Something like 1.234E8
    * Below is an example

            ``China, Asia, 1339190000, 9596960.0``

            ``United States of America, North America, 309975000, 9629091.0``

            ``Brazil, South America, 193364000, 8511965.0``



Part 3 --- File IO and Using Classes
====================================



This part is about populating the country catalogue based on information contained within text files. You will be
required to perform some file I/O.

#. Create a static method within the ``Asn1`` class called ``loadCountries``
    * This method will take two strings as parameters for the file names of the text files to be read
    * There will be a third parameter for a ``CountryCatalogue`` instance that will contain ``Country`` objects created based on the text files
    * Based on the contents of the continent file, keep track of the country/continent relationships
        * I strongly recommend making use of a *hash map* to keep track of the country name/continent name relationships
        * A map is the same idea as a dictionary from Python
        * `How does one use a hash map? <https://www.google.com/search?q=java+hashmap&oq=java+hashmap>`_
    * Based on the file containing the country details, along with the country name/continent name relationships, populate the ``CountryCatalogue`` with appropriate ``Country`` objects
    * **Note:** To keep things simpler, the method will have ``throws IOException`` so you do not need to worry about the ``try`` and ``catch`` blocks for the file I/O


Part 4 --- Testing
==================

You may have already verified the correctness of your ``Country`` and ``CountryCatalogue`` classes by running their test
classes. If not, do it!

If you have, for good measure, re-run all the tests provided to you. If they all pass, you should be pretty confident
that you have everything working correctly.

There are no tests provided for the ``Asn1`` class, but that's nothing to worry about. You can get a sense that it is
working correctly by running the ``main`` method and checking that everything worked as expected.



Some Hints
==========

* Work on one function at a time
* Get each function working perfectly before you go on to the next one
* Test each function as you write it

    * This is a really nice thing about programming; you can call your functions and see what result gets returned
    * Mentally test before you even write --- what does this function do? What problem is it solving?


* If you need help, ask

    * Drop by office hours



Some Marking Details
====================

.. warning::

    Just because your program produces the correct output, that does not necessarily mean that you will get perfect, or
    even that your program is correct.


Below is a list of both *quantitative* and *qualitative* things we will look for:

* Correctness?
* Did you follow instructions?
* Comments?
* Variable Names?
* Style?
* Did you do just weird things that make no sense?



What to Submit to Moodle
========================

* Make sure your **NAME**, **STFX EMAIL**, and **STUDENT NUMBER** appear in a comment at the top of the classes
* Submit your completed *.java* files to Moodle

    * *Country.java* and *CountryCatalogue.java*
    * Do **not** submit the *Asn1.java* file
    * Do **not** submit the *.csv* files
    * Do **not** submit the *.class* files
    * Do **not** compress the files


.. warning::

    Verify that your submission to Moodle worked. If you submit incorrectly, you will get a 0.


Assignment FAQ
==============

* :doc:`See the general FAQ </assignments/faq>`
