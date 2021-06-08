**************************
Topic #5 --- The Stack ADT
**************************


Stack Operations
================

Collection Operations
---------------------

* For the collections we're looking at, we need a way to:
    * Add something to the collection
    * Remove something from the collection
    * Look at something, but do not remove it

* However, the way these are done may differ between collections

* Other things we will want to do with our collections are:
    * `isEmpty` --- see if the collection is empty
    * `size` --- Check how many things are in the collection
    * `toString` --- Get a string version of the collection


Stack Context
-------------

* **Push**
    * Add something to the *top* of the stack

* **Pop**
    * Remove something from the *top* of the stack

* **Peek**
    * Look at the thing on the *top* of the stack, but do **not** remove it

* And we will also want out `isEmpty`, `size` and `toString`


.. warning::

    It is against our definition of a stack to access anything from anywhere other than the *top* of the stack.


Stack ADT
---------

* With this, we now know what the operators are and how they are used

* Notice how none of the above explains a single thing about *how* the stack is implemented
    * Nothing about where we store the data
    * Nothing about how the operators do what they do

* Notice that this also has nothing to do with Java
    * Or Python
    * Or C++
    * Or ...

* This is just the definition of the stack ADT


Example Uses
============


Interface
=========

Generics
--------


For next time
=============

* Read Chapter 3 Sections 2 -- 6
    * 13 pages