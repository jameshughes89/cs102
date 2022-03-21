*****************************
C++ Lessons #3 --- References
*****************************

.. warning::

    * For these, I will only go over the C++ details at a high level
    * Getting into the nitty gritty of C++ is not the purpose of this aside
    * Some of the concepts require knowledge of more advanced ideas that have not been covered yet
        * If this happens, do not panic
        * it probably makes more sense to revisit this later in the course
    * For simplicity, some of the examples will use less than ideal implementations


What Are They?
==============

.. warning::

    Although the word used here is "reference", these are not the same as a reference variable in Java. The closest
    analogue to a reference variable from Java in Cpp is an automatically dereferenced pointer.


* Reference variables are a way to give a variable another name
    * Alias

* The ``&`` character is used to create reference variables
    * ``&`` is already used for *and* and *address of*, but it is context sensitive

* To create a reference for an integer, we use ``int&``
    * Note the similarity to the pointer variables

* Reference variables are assigned their value on creation
* They cannot change which variable they are a reference for
* They do not need to be dereferenced


How To Use Them
===============



