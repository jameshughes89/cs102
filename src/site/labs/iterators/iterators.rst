*********
Iterators
*********

* Feel free to use your laptop
* You are strongly encourage to work with others

    * When you get stuck, ask those sitting around you for help
    * Get used to working together in the labs
    * Peer teaching and peer learning has been empirically shown to be very effective


Playing with Iterators
======================

The goal is to redefine stacks and queues such that the collections are iterable based on the details discussed in the
:doc:`Iterators Topic </topics/iterators/iterators>`.


Create an Array Iterator
------------------------

#. Create an ``ArrayIterator`` class that implements the ``Iterator`` interface


.. note::

    Obviously one can simply download the :download:`ArrayIterator <../../../main/java/ArrayIterator.java>` code, but
    this defeats the purpose of the lab. Instead, slowly and deliberately implement each method and take the time to
    understand the details.



Create an Iterable Stack
------------------------

#. Download the :download:`Stack interface <../../../main/java/Stack.java>` and add it to the project
#. Modify the interface such that ``Stack`` extends ``Iterable``
#. Add the required ``iterator`` method to the interface

#. Download the :download:`ArrayStack <../../../main/java/ArrayStack.java>` class and add it to the project
#. Modify the ``ArrayStack`` such that it implements the ``iterator`` method

    * Simply have it return the ``ArrayIterator``


#. Modify the stack's existing ``toString`` method such that it uses an iterator

    * Refer to the ``toString`` from the :download:`ArraySortedBag <../../../main/java/ArraySortedBag.java>` for help



Create an Iterable Queue
------------------------



Make the Linked Stack and Queue Iterable
----------------------------------------



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