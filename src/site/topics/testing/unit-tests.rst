**********
Unit Tests
**********

* At the end of the objects review topic the implementation was played with
* This allowed testing the basic functionality
* However, the testing was far from through or systematic


Unit Testing
============

* Ideally, when testing code, each *unit* or *component* should be tested

    * *Unit Testing*
    * Ideally with good *coverage*


* When doing so, individual test functions are written to test the units/components
* These tests can also be run automatically

* By writing tests like this, it adds intentionality to the code and tests

    * Take the time to think of the cases needing testing
    * It can also help keep the units/components isolated


* It also obviously helps with testing and debugging
* It there are ever breaking changes to the unit/component being tested, the automated testing should find it

* Writing tests can be a bit of an art, so it's best to get a lot of practice


JUnit
=====

* JUnit is a very popular unit testing framework for Java
* It's simple to use and automates testing
* Within IntelliJ, there is a simple way to setup JUnit

#. Make a new folder/directory called ``test`` in the project next to ``src``

    .. figure:: test_folder.png
        :width: 600 px
        :align: center

        Right click the project in the project view and select New -> Directory. Call this new directory "test".


#. Right click the ``test`` folder and select *Mark Directory as -> Test Sources Root*

    .. figure:: mark_tests.png
        :width: 600 px
        :align: center

        Right click the new "test" folder to mark it as the "Test Sources Root".


#. Create a new class for testing named such that it is the class name followed by "Test"

    * For example, ``FriendTest``


#. Add JUnit to the class path

    * A simple way to do it is to write ``@Test`` in the new class and press Alt + Enter


#. Select *Add 'JUnit5....*

    .. figure:: alt_enter.png
        :width: 600 px
        :align: center

        Pressing Alt + Enter with ``@Test`` selected will cause a popup to appear where "Junit5..." will be an option.
        Alternatively, one could select the dropdown arrow on the red light bulb for the same menu.


Testing the Friend Class
========================

* Checkout the :download:`FriendTest.java</../test/java/FriendTest.java>` for testing the ``Friend`` class
* For now, the new ideas introduced here are

    * ``@Test`` annotation --- marking a method as a test
    * Assertions --- a mechanism for checking something


* Below are excerpts from the ``FriendTest`` class

.. literalinclude:: /../test/java/FriendTest.java
    :language: java
    :lineno-match:
    :lines: 9-13


* Consider the first test within the test class as shown above
* The method is marked with ``@Test`` to mark the method as a test method for Junit
* It has a descriptive name of the form ``unitUnderTest_case_expectedResult``

    * ``getFirstName_generalCase_returnsFirstName``
    * ``getFirstName`` is the method being tested
    * Since there is no real special condition or case for this test, it has ``generalCase`` in its name
    * ``returnsFirstName`` is the expected result of calling the method

* It uses ``assertEquals`` to check that the expected string ``"qwerty"`` is what is returned by ``getFirstName()``


.. literalinclude:: /../test/java/FriendTest.java
    :language: java
    :lineno-match:
    :lines: 27-39


* Consider the above two tests

    * ``equals_equalFriendObjects_areEqual``
    * ``equals_unequalFriendObjects_areNotEqual``


* These tests are named such that the cases (equal/unequal ``Friend`` objects) is clear
* These tests also make use of different asserts

    * ``assertEquals``
    * ``assertNotEquals``


.. warning::

    The above tests for equality are sufficient for the purposes of this course, but they could be improved. Within the
    provided ``FriendTest`` class is a test method that makes use of ``EqualsVerifier``, which helps with testing
    equality on objects. Although this improved equality test is provided, the simpler equality tests are sufficient
    here. Do note that ``EqualsVerifier`` is an external dependency that is not included with Java or IntelliJ. 

        .. literalinclude:: /../test/java/FriendTest.java
            :language: java
            :lineno-match:
            :lines: 47-54



For Next Time
=============

* Read Chapter 1 of the text

    * 15 pages


Playing Code
------------

* Download and play with

    * :download:`Friend </../main/java/Friend.java>`
    * :download:`FriendTest.java</../test/java/FriendTest.java>`