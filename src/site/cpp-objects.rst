**************************
C++ Lessons #4 --- Objects
**************************

.. warning::

    * For these, I will only go over the C++ details at a high level
    * Getting into the nitty gritty of C++ is not the purpose of this aside
    * Some of the concepts require knowledge of more advanced ideas that have not been covered yet
        * If this happens, do not panic
        * it probably makes more sense to revisit this later in the course
    * For simplicity, some of the examples will use less than ideal implementations


* The same example described in :doc:`Topic3 </topic3.rst>` is used here
    * A collection of ``Friend`` objects stored in an ``ContactList`` obejct


Friend
======

* We will create a ``Friend`` class to keep track of a few details
    * First Name
    * Last Name
    * Email

* We will also want
    * Constructor
    * Some getters/setters

* That's about it


Header
------

* The first thing we want is a *header* file
* Call this ``Friend.h``
* This is where we typically declare all the member fields and methods the class will have
* This file will also have all our ``#include``s too
* Below is a complete ``Friend.h``


.. code-block:: cpp
    :linenos:

    // Friend.h
    #include <string>

    class Friend {
        private:
            // Starting with underscore is convention for private variables
            std::string _firstName;
            std::string _lastName;
            std::string _email;

        public:
            Friend();
            Friend(std::string, std::string, std::string);
            std::string getFirstName();
            std::string getLastName();
            std::string getEmail();
            void setEmail(std::string);
    };



Class
-----

* The class file is where we typically define and write the actual methods
* Mind the use of ``Friend::`` before all the method names

.. code-block:: cpp
    :linenos:

    // Friend.cpp
    #include "Friend.h"

    Friend::Friend() {
        _firstName = "Person";
        _lastName = "Doe";
        _email = "pDoe@email.com";
    }

    Friend::Friend(std::string firstName, std::string lastName, std::string email) {
        _firstName = firstName;
        _lastName = lastName;
        _email = email;
    }

    std::string Friend::getFirstName() {
        return _firstName;
    }

    std::string Friend::getLastName() {
        return _lastName;
    }

    std::string Friend::getEmail() {
        return _email;
    }

    void Friend::setEmail(std::string email) {
        _email = email;
    }


Using the Friend Class
----------------------

* We can create ``Friend`` objects on the stack, or the heap
* In the below example
    * The variable ``aFriend`` is a variable containing a ``Friend`` object
    * ``bFriend`` is a variable containing the memory address of where a ``Friend`` object is in memory

.. code-block:: cpp
    :linenos:

    int main() {
        Friend aFriend("Bob", "Smith", "bSmith@gmail.com");

        Friend* bFriend = new Friend("Jane", "Doe", "jdoe@gmail.com");
    }




ContactList
===========


Further Reading
===============

* Read the `cplusplus.com <http://www.cplusplus.com/doc/tutorial/classes/>`_ tutorial on classes
* Read the other `cplusplus.com <http://www.cplusplus.com/doc/tutorial/templates/>`_ tutorial on classes
