********************************************
Maze Solver --- A Better Path is Also a Path
********************************************

* **Worth**: 5%
* **DUE**: March 13th 11:55pm; submitted on MOODLE


Task
====

The goal is to solve a maze, again, but this time with artificial intelligence (AI). The A* (A-star) algorithm will be
used to find an optimal solution.

You will:

* Create a ``LinkedPriorityQueue`` class that implements a ``PriorityQueue``

    * This data structure greatly helps with the implementation of A*


* Create an ``AStarMazeSolver`` class that implements the ``MazeSolver`` interface

    * Within this class, you will write the ``solve`` method


* You will use the ``AStarMazeSolver``, along with some of the other provided classes, in the ``main`` to

    * Create the maze
    * Solve the maze
    * Display the solution


* Test the implementation with test classes


Provided Files
==============

* A package containing maze specific classes

    * A ``Cell`` class with ``CellTest`` unit tests
    * A ``Maze`` class with ``MazeTest`` unit tests
    * A ``MazeRenderer`` class with ``MazeRendererTest`` unit tests
    * Two exceptions --- ``LocationNotInMazeException`` and ``MazeEndpointsException``
    * A ``MazeSolver`` interface


* A ``Queue`` and ``PriorityQueue`` interface
* A nearly empty ``LinkedPriorityQueue`` class with a ``LinkedPriorityQueueTest`` class containing empty tests
* A nearly empty ``AStarMazeSolver`` with an ``AStarMazeSolverTest`` class containing empty tests
* An ``Asn3`` class with an empty ``main``
* Three maze files


* :download:`All of this can be downloaded from here <Assignment3.zip>`

    * This is a compressed IntelliJ project
    * Just unzip, put it where you want on your computer, and you should be able to open this project through IntelliJ


.. warning::

    When opening the project, IntelliJ may mention a missing JDK. If this is the case, simply select the download link
    in the notification to download and install the missing JDK.



Part 0 --- Read the Assignment
==============================

Read the assignment description in its entirety before starting.


Part 1 --- Read Through the Provided Code
=========================================

Read through all the provided code. The code is commented and there is documentation describing everything. These are
several objects and methods you will be using to solve the problem.

Reading through and understanding existing code is a significant part of the assignment. Although there are no marks
directly associated with it, it is a requirement in order to do anything useful. Further, if you continue studying CS,
you will be reading documentation and other people's code a lot.

Be sure to also read through all the test classes. Take the time to make sense of what is going on --- these will save
you. You may want to do some brief reading on
`@Nested <https://junit.org/junit5/docs/current/user-guide/#writing-tests-nested>`_ and
`@ParameterizedTest <https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests>`_. The
documentation may seem intimidating at first, but take your time and have a read. You may be surprised at how helpful
reading the docs actually is.

Lastly, it's not just having a superficial understanding of the provided code. Sure, one of the big points of
abstraction is not needing to fully understand everything *under the hood*; however, you're still new at this, and
taking the time to understand what is happening in the code, and how it does it, is important.


Part 2 --- Run Unit Tests
=========================

* Run all the tests for the provided completed classes

* All these tests should pass

    * If not, something has gone wrong

        * Did you change the code?
        * Did your test folder get changed?
        * Try re-downloading the project and starting over if they do not pass


* You will notice the test classes ``AStarMazeSolverTest`` and ``LinkedPriorityQueueTest`` are provided, but incomplete

    * They have empty tests left for you to complete in their respective parts discussed below



Part 3 --- Complete ``LinkedPriorityQueue``
===========================================

A priority queue is going to help with the implementation of the A* algorithm.
`Feel free to read up on priority queues <https://en.wikipedia.org/wiki/Priority_queue>`_, but in short, a priority
queue is a queue with a twist --- whenever dequeuing something, the element with the most *important* priority is
returned. In other words, the order the elements are removed is based on the priority value, not the standard FIFO of a
regular queue.

An example of this is triage at an emergency room: someone may have arrived at the emergency room with a bad cut earlier
than the person with a giant crack in their skull, but they will get seen before given the severity of their injury.


Notes About The Implementation
------------------------------

* The regular ``LinkedQueue`` may provide a good reference
* Have priority values that are lower be considered "more important" (lower values get dequeued first)
* Given the definition, all that matters is that when something gets dequeued, it has the most important priority

    * Enqueue with a linear search for the correct insertion spot (:math:`O(n)`) and then always dequeue from the front (:math:`O(1)`)?
    * Or enqueue always append to the end (:math:`O(1)`) and do a linear search for the most important priority on the dequeue (:math:`O(n)`)?
    * The former is suggested --- have the enqueue find the correct spot to add the element, and have the dequeue simply remove from the front


* An already complete ``equals`` and ``hashCode`` method for the ``LinkedPriorityQueue`` class is provided

    * Leave these alone


* A complete ``PriorityNode`` class contained within the ``LinkedPriorityQueue`` class is provided

    * Leave this alone


Implementing the Class
----------------------

* In order to complete the ``LinkedPriorityQueue``, write a constructor and implement all the required methods:

    * ``void enqueue(T element, int priority)``
    * ``void enqueue(T element)``
    * ``T dequeue()``
    * ``T first()``
    * ``int size()``
    * ``boolean isEmpty()``


* Also write a ``String toString()`` method for the class



Implementing the Unit Tests
---------------------------

The ``LinkedPriorityQueueTest`` class contains empty test methods, but each has a name that explains what the test
should do --- complete all these methods. As a starting point, look at any of the unit tests for any of the
ADTs implemented.

There is no need to test the provided ``equals`` method as it has already been tested. Having a working ``equals`` makes
it safe to use ``assertEquals`` in the unit tests.

Having complete tests should help with debugging the ``LinkedPriorityQueue`` class.


Part 4 --- Complete ``AStarMazeSolver``
=======================================

`Read up on the A* algorithm <https://en.wikipedia.org/wiki/A*_search_algorithm>`_. The linked article is great, and
there are likely  many YouTube videos on the subject.

One of the key parts of A* is the estimated cost function

    :math:`f(x) = g(x) + h(x)`

    * :math:`x` is some maze cell
    * :math:`g(x)` is the cost of getting to :math:`x` from the start
    * :math:`h(x)` is the heuristic's estimated cost of getting to the end from :math:`x`
    * :math:`f(x)` is the total estimated cost of a path from start to finish going through :math:`x`


Notes About the Implementation
------------------------------

* :math:`g(x)` will be the number of steps it takes to get to :math:`x` from the start
* :math:`h(x)` will be the estimated distance to the end from :math:`x` based on the `Manhattan Distance <https://en.wikipedia.org/wiki/Taxicab_geometry>`_

    * :math:`\lvert x_{1} - x_{2} \rvert + \lvert y_{1} - y_{2} \rvert`


* :math:`f(x)` will be the *priority* of the cell :math:`x`



Implementing the Class
----------------------

Write the ``solve`` method to find an optimal path in the maze using A*.

The general idea is this

    * Dequeue from the priority queue
    * If it's the end, done
    * If it's not, calculate all the neighbours' :math:`f(x)` (priority) and add each to the priority queue
    * Repeat


* Something for keeping track of the number of steps it takes to get to a given cell is needed

    * Perhaps a ``Map``?


* Something for keeping track of each cell's predecessor in the path is needed

    * Which cell was step *from* to get to the current cell?
    * Perhaps a ``Map``?


* Feel free to use as many private helper methods as needed


.. warning::

    Do not get distracted by the depth first search solution in ``DfsMazeSolver``. Although there are similarities, the
    actual algorithms have several noteworthy differences.



Implementing the Unit Tests
---------------------------

The ``AStarMazeSolverTest`` class contains a few constants and empty test methods. The constants are provided to help
with writing the tests. Each method has a name that explains what the test should do --- complete all these methods. As
a starting point, look at the ``DfsMazeSolverTest`` class provided in previous assignment.

Having complete tests should help with debugging the ``AStarMazeSolver`` class.



Part 5 --- Putting it Together
==============================

Once comfortable that the ``LinkedPriorityQueue`` and ``AStarMazeSolver`` are working correctly, write a main method.
Expect it to be short (less than 10 lines); if the main is long, something is wrong and you are working too hard. The
final main method is remarkably similar to the one from assignment 2.

In order to actually solve a maze, a few objects are needed

    * A ``Maze``
    * A ``MazeSolver`` to solve the maze
    * A ``MazeRenderer`` for rendering the maze with the solution so it can be printed out


Run the program on the mazes from files. There is a provided ``RELATIVE_RESOURCES`` constant within the ``Asn3`` class.
This is the relative path to the directory where the maze files are stored. Simply take this relative path and
concatenate it with the file name of the maze to be opened.


Part 6 --- Testing
==================

You may have already verified the correctness of your ``LinkedPriorityQueue`` and ``AStarMazeSolver`` classes by
completing and running their test classes. If not, do it!

If you have, for good measure, re-run all the tests provided to you and the ones you wrote. If they all pass, you should
be pretty confident that you have everything working correctly.

There is no test provided for the ``Asn3`` class, but that's nothing to worry about. You can get a sense that it is
working correctly by

    * Running your program on the maze files provided
    * Create your own maze programs and try running on them too


Some Hints
==========

* Work on one method at a time.
* Use the unit tests.
* Get each method *working perfectly* before you go on to the next one.
* *Test* each method as you write it.
    * This is a really nice thing about programming; you can call your methods and see what result gets returned. Does it seem correct?
    * Mentally test before you even write --- what does this method do? What problem is it solving?
* If you need help, **ask**! Drop by my office hours.


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

Submit your work on Moodle.

* Your ``.java`` files. Please do not compress them.

* Make sure your **NAME** and **STUDENT NUMBER** appear in a comment at the top of the program.

**VERIFY THAT YOUR SUBMISSION TO MOODLE WORKED!**
**IF YOU SUBMIT INCORRECTLY, YOU WILL GET A 0**


Assignment FAQ
==============

* :doc:`See the general FAQ </assignments/faq>`
