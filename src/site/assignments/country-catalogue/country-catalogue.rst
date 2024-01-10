*********************************
Playing with Objects is Still Fun
*********************************

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

    * With floating point numbers (doubles included), division by zero results in a special value --- ``Infinity``
    * If this method is called on a ``Country`` object with an ``area`` of zero, it should return ``Infinity``
    * In other words, this method should not perform any special check for ``area`` being zero


#. Write a ``toString`` method to return a string following the pattern ``ClassName(field=value, field=value, ... )``

    * For example --- ``Country(name=Canada, continent=North America, population=34207000, area=9976140.00)``
    * Mind the format of the string --- the area field has two decimal places

        * `Consider using the format method from the String class <https://www.google.com/search?q=java+string+format>`_


#. Write an ``equals`` and ``hashCode`` method

    * Two ``Country`` objects will be considered equal if all fields match
    * `Be mindful of how the double values are compared <https://www.google.com/search?q=java+double+compare>`_


#. Run the unit tests to ensure the ``Country`` class works properly

    * It may be necessary to add JUnit to the class path, as described in the :doc:`testing topic </topics/testing/unit-tests>`

    .. warning::

        Be sure to use JUnit 5. If you use JUnit 4, the tests will not work. Further, if you select JUnit 4 by accident,
        changing the project to use JUnit 5 can be difficult.



Part 2 --- Country Catalogue
============================

The ``CountryCatalogue`` class holds references to ``Country`` objects. Additionally, the ``CountryCatalogue`` provides
functionality to add and remove ``Country`` objects to itself and ask questions about the data. The ``CountryCatalogue``
is effectively a *list* keeping track of the ``Country`` objects with additional functionality.

Although the description of this class is provided with an order and each part is numbered, one should feel free to
complete the methods in any order they see fit. Additionally, feel free to write and use additional private methods as
needed.

The ``CountryCatalogue`` class will need two fields

    * ``size`` --- an ``int`` to keep track of the number of ``Country`` objects in the catalogue
    * ``catalogue`` --- an array of ``Country`` objects


The class will also have two static constants

    * An ``int`` called ``NOT_FOUND`` that is set to ``-1``

        * This constant serves as a nice way to indicate, with a sentinel value, that something was not found


    * An ``int`` for this class called ``DEFAULT_CAPACITY`` that should be set to ``10``

        * This will be used as a starting size for the ``catalogue`` array if none is specified upon creation



#. Write two constructors for the ``CountryCatalogue`` class

    * One creates the ``CountryCatalogue`` with the ``catalogue`` array being the default size
    * One takes a parameter to create a ``CountryCatalogue`` with the ``catalogue`` array being the size specified by the parameter


#. Write an ``add`` method to add a ``Country`` object to the ``CountryCatalogue``

    * This method takes the ``Country`` object to be added as a parameter
    * This method returns a ``boolean`` indicating if the add was successful
    * This method must still work if the ``catalogue`` array is full


#. Write a ``remove`` method that removes a ``Country`` object from the ``CountryCatalogue``

    * This method takes the ``Country`` object to be removed as a parameter
    * This method returns a ``boolean`` indicating if the remove was successful

        * Returns ``true`` if the remove was successful
        * Returns ``false`` if the remove was unsuccessful; if the element to be removed does not exist


    * If more than one matching ``Country`` object exists, only remove the first occurrence
    * If a ``Country`` object is removed, the order of the remaining ``Country`` objects must remain unchanged

        * For example, if ``A`` is removed from ``C, A, R, L``, the result should be ``C, R, L``



#. Write a ``contains`` method that searches for a ``Country`` object within the ``CountryCatalogue``

    * This method takes the ``Country`` to search for as a parameter
    * This method returns a ``boolean`` indicating if the specified ``Country`` object is within the ``CountryCatalogue``


#. Write an ``indexOf`` method that finds the index of a ``Country`` object within the ``CountryCatalogue``

    * This method takes the ``Country`` to search for as a parameter
    * This method returns the index of the specified ``Country`` object within the ``CountryCatalogue``
    * This method throws a ``NoSuchElementException`` if no matching ``Country`` object exists


#. Write a ``get`` method that returns the ``Country`` object at a specified index within the ``CountryCatalogue``

    * This method takes an index as a parameter
    * This method returns a reference to the ``Country`` object at the specified index in the ``catalogue`` array
    * This method throws a ``IndexOutOfBoundsException`` if an inadmissible index is provided


#. Write a ``smallestPopulationDensity`` method that returns the ``Country`` in the ``CountryCatalogue`` with the smallest population density

    * This method returns a reference to the ``Country`` object with the smallest population density
    * If more than one ``Country`` object has the same smallest population density, return the first occurrence
    * This method throws a ``NoSuchElementException`` if the ``CountryCatalogue`` is empty


#. Write a ``largestPopulationDensity`` method that returns the ``Country`` in the ``CountryCatalogue`` with the largest population density

    * This method returns a reference to the ``Country`` object with the largest population density
    * If more than one ``Country`` object has the same largest population density, return the first occurrence
    * This method throws a ``NoSuchElementException`` if the ``CountryCatalogue`` is empty


#. Write a ``filterByPopulationDensity`` method that returns a new ``CountryCatalogue`` containing ``Country`` objects within the specified range

    * This method takes two parameters indicating the low and high limits for filtering

        * The lower limit is *inclusive* --- ``Country`` objects with population densities greater than or equal to this limit are included
        * The upper limit is *exclusive* --- ``Country`` objects with population densities strictly less than this limit are included


    * This method returns a new ``CountryCatalogue`` containing ``Country`` objects from the current ``CountryCatalogue`` that fall within the specified range
    * This method returns an empty ``CountryCatalogue`` if no ``Country`` objects exist within the specified range

        * This includes the case that the current ``CountryCatalogue`` is empty



#. Write a ``mostPopulousContinent`` method that returns the name of the continent with the largest population

    * This method returns a ``String`` of the name of the continent with the largest population
    * This method throws a ``NoSuchElementException`` if the ``CountryCatalogue`` is empty
    * This method only considers ``Country`` objects contained within the ``CountryCatalogue``
    * This method should work with an arbitrary number of possible continents

        * In other words, do not hard code the names of the continents on Earth


    * It is recommended to make use of a *hash map* for this method

        * A map is like a dictionary from Python
        * `How does one use a hash map? <https://www.google.com/search?q=java+hashmap&oq=java+hashmap>`_



#. Write an ``isEmpty`` method that returns a ``boolean`` indicating if the ``CountryCatalogue`` is empty or not
#. Write a ``size`` method that returns the number of ``Country`` objects within the ``CountryCatalogue``
#. Write a ``toString`` method that returns a ``String`` representation of the ``CountryCatalogue``

    * The ``String`` should be an aggregate of the ``String`` representations of the  ``Country`` objects within the ``CountryCatalogue``
    * Each ``Country`` object's ``String`` representation should be on its own line
    * For example

    .. code-block:: text

        Country(name=Nigeria, continent=Africa, population=186987563, area=912134.45)
        Country(name=Mexico, continent=North America, population=128632004, area=1969230.76)
        Country(name=Egypt, continent=Africa, population=93383574, area=1000000.00)
        Country(name=France, continent=Europe, population=64668129, area=541656.76)
        Country(name=Italy, continent=Europe, population=59801004, area=300000.00)



#. Uncomment out the provided ``equals`` and ``hashCode`` methods

    * These are provided since writing ``equals`` for collections and testing them can be tricky


#. Run the unit tests to ensure the ``Country`` class works properly



Part 3 --- File IO and Using Classes
====================================

A complete ``main`` method has been provided to you within the ``Asn1`` class. Take your time to read over the code
carefully and make sense of what it is doing. You are not required to make any changes to this code, but you are
required to understand it and how it works.

The first portion of ``main`` loads data from a file, parses it, and then uses the data to create ``Country`` objects to
add to a ``CountryCatalogue``.

The next portion simply alters the contents of the ``CountryCatalogue`` object and the third part queries the
``CountryCatalogue`` for some details.

The last portion of ``main`` creates a new ``CountryCatalogue`` by filtering the existing ``CountryCatalogue``. The
details of the ``Country`` objects within the new filtered ``CountryCatalogue`` are added to a string that is then
ultimately saved to a csv file.

There are no unit tests for ``main``. To test it, simply run it and check if it works as expected.

.. note::

    In CSCI 161, most file IO was done by reading/writing a single line at a time from/to the file. It is entirely
    possible to read/write one line at a time in Java, but here, when reading from a file, notice that the whole
    contents of the file is read as a single string and then parsed. Similarly, when writing to a file, the whole string
    is created before it is written to the file as a single string.


.. note::

    The functions ``Files.readString`` and ``Files.writeString`` used for file IO may throw ``IOExceptions``. Notice,
    however, that these calls are not wrapped with ``try``/``catch``. This is because ``main`` includes
    ``throws IOException`` in its signature, as described in the
    :ref:`Java vs. Python topic's IO Section <label-java_vs_python-input_output>`.




Part 4 --- Testing
==================

You might need to add JUnit to the classpath for the project, as described in the
:doc:`testing topic </topics/testing/unit-tests>`.

You may have already verified the correctness of your ``Country`` and ``CountryCatalogue`` classes by running their test
classes. If not, do it!

If you have, for good measure, re-run all the tests provided to you. If they all pass, you should be pretty confident
that you have everything working correctly.

There are no tests provided for the ``Asn1`` class, but that's nothing to worry about. You can get a sense that it is
working correctly by running the ``main`` method and checking that everything worked as expected.



Some Hints
==========

* Work on one method at a time
* Get each method working perfectly before you go on to the next one
* Test each method as you write it

    * This is a really nice thing about programming; you can call your methods and see what result gets returned
    * Mentally test before you even write --- what does this method do? What problem is it solving?


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

* Make sure your **NAME**, **SCHOOL EMAIL**, and **STUDENT NUMBER** appear in a comment at the top of the classes
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
