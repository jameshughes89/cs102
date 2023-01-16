***********
LinkedStack
***********

* The ``Stack`` was defined with an interface
* An array based implementation of the stack was created --- ``ArrayStack``
* Now, being aware of linked structures, a linked based stack may be implemented --- ``LinkedStack``


Stack ADT
=========

* :download:`The Stack interface was already written </../main/java/Stack.java>`

* Remember, based on the interface, a stack must implement the following methods

    * ``push``
    * ``pop``
    * ``peek``
    * ``isEmpty``
    * ``size``


* Also remember that the interface strictly defines the *what* and says nothing about the *how*


Implementing a Stack with a Linked Structure
============================================

* The top of the stack will be managed by a field called ``top`` that is a reference to the head of a linked structure
* All pushing and popping will happen at the head end of the linked structure
* An additional field will be needed to keep track of the size of the stack

.. figure:: linked_stack0.png
    :width: 500 px
    :align: center

    An example ``LinkedStack`` containing four elements. Note the value stored in ``top`` is a reference to a ``Node``
    object that contains the element on the *top* of the stack.


.. figure:: linked_stack1.png
    :width: 500 px
    :align: center

    The state of the ``LinkedStack`` after an element was pushed. Note that ``top`` changed to reference a new ``Node``
    containing the newly pushed element.


.. figure:: linked_stack2.png
    :width: 500 px
    :align: center

    The state of the ``LinkedStack`` after an element was popped. Note that ``top`` changed to reference the ``Node``
    that was after the ``Node`` that contained the element on the top of the stack (the ``Node`` that was removed).


.. figure:: linked_stack3.png
    :width: 500 px
    :align: center

    The state of the ``LinkedStack`` after another element was popped. Note that, again, ``top`` changed to reference
    the ``Node`` that was after the ``Node`` that contained the element on the top of the stack.



Implementation
==============

.. literalinclude:: /../main/java/LinkedStack.java
    :language: java
    :linenos:
    :lineno-start: 10
    :lines: 10-21


* Like the ``ArrayStack``, the ``LinkedStack`` will implement the ``Stack`` interface
* The constructor creates an empty stack with nothing in it


``Push``
--------

.. literalinclude:: /../main/java/LinkedStack.java
    :language: java
    :linenos:
    :lineno-start: 23
    :lines: 23-30


* In ``push``, notice how this is just *adding to the front of a linked structure*



``Pop`` & ``Peek``
------------------

.. literalinclude:: /../main/java/LinkedStack.java
    :language: java
    :linenos:
    :lineno-start: 32
    :lines: 32-49


* Like the ``ArrayStack``, popping or peeking from an empty stack throws an exception
* Notice how ``pop`` does a *remove/delete from the front of a linked structure*


``size`` and ``isEmpty``
------------------------

.. literalinclude:: /../main/java/LinkedStack.java
    :language: java
    :linenos:
    :lineno-start: 51
    :lines: 51-59


* The ``LinkedStack`` is empty if its ``size() == 0``

    * How else could this condition be checked?


``toString``
------------

.. literalinclude:: /../main/java/LinkedStack.java
    :language: java
    :linenos:
    :lineno-start: 61
    :lines: 61-71


* This is matching the output format that the ``ArrayStack``\'s ``toString`` had


``equals`` & ``hashCode``
-------------------------

.. literalinclude:: /../main/java/LinkedStack.java
    :language: java
    :linenos:
    :lineno-start: 73
    :lines: 73-106


Nested Node Class
=================

* Consider the doubly linked structure

.. figure:: /topics/linked-structures/double_links.png
    :width: 400 px
    :align: center

* Since this structure need a reference to both the ``next`` and ``previous`` nodes, the existing ``Node`` class will not work
* Also consider that the ``Node`` class would only be used for a linked implementation of something

    * As far as the user of a ``LinkedStack`` is concerned, they don't care about the ``Node`` class, they just care that the ``LinkedStack`` works

        * *I don't know, I don't want to know*


    * Similar idea to the private method ``expandCapacity`` in the ``ArrayStack``


* Does it make sense to have the ``Node`` class accessible from everywhere?


Nested Classes
--------------

* Thinking about the doubly linked structure, what should the node class be called, ``Node``?

    * This would be a problem if there already exists a ``Node`` class


* Instead, the ``Node`` class can be put inside the ``LinkedStack`` class

    * If this is done, the ``Node`` class can still be accessed by the ``LinkedStack`` class
    * But, it's only accessible from within that class, so it keeps the ``Node`` class out of the way of all other classes


* Going back to the doubly linked structure, a ``Node`` class can exist within the class using the doubly linked structure

    * It will not introduce any ambiguity since the singly linked and doubly linked structure's ``Node`` classes are nested within their respective classes


* Perhaps this is not *that* big of a problem, and there are other ways around it
* But since the two classes are inextricably connected, nesting ``Node`` makes sense


Nesting in LinkedStack
----------------------

* Below is an example of the nested ``Node`` class at the end of the ``LinkedStack`` class

    * Notice that it is both ``private`` and ``static``

.. literalinclude:: /../main/java/LinkedStack.java
    :language: java
    :linenos:
    :lineno-start: 108
    :lines: 108-143



For Next Time
=============

* Read Chapter 4 Section 6

    * 13 pages


Playing Code
------------

* Download and play with

    * :download:`LinkedStack </../main/java/LinkedStack.java>`
    * :download:`LinkedStackTest </../test/java/LinkedStackTest.java>`
    * :download:`LinkedStack playing code </../main/java/PlayingLinkedStack.java>`


* One could use the same code from ``PlayingArrayStack`` to play with the ``LinkedStack``
* Only need to make one change

    * ``ArrayStack`` -> ``LinkedStack``


* If everything was done correctly, the following code from ``PlayingLinkedStack`` should work

.. literalinclude:: /../main/java/PlayingLinkedStack.java
    :language: java
    :linenos:
    :emphasize-lines: 6
