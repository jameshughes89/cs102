***********************************************************
Assignment #3: Maze Solver --- A Better Path is Also a Path
***********************************************************

* **Worth**: 10%
* **DUE**: March 28th 11:55pm; submitted on MOODLE.


Task
====

Your goal is to solve a maze, again, but this time with artificial intelligence (AI). You will implement the A* (A-star)
algorithm, which in our case, is guaranteed to find an optimal solution.

You will:

* Write a ``LinkedPriorityQueue`` class that implements a ``PriorityQueue``
    * This data structure greatly helps with the implementation of A*
* Write an ``AStarMazeSolver`` class that implements the ``MazeSolver`` interface
    * Within this class, you will write the ``solve`` method
* You will use the ``AStarMazeSolver``, along with some of the other provided classes, in the ``main`` to
    * Create the maze
    * Solve the maze
    * Print out the solution
* You will also be testing your implementation with test classes


Provided Files
==============

* A **package** called maze containing all the relevant maze code from the previous assignment (using a package helps with organization)
    * A ``Cell`` class with ``CellTest`` unit tests
    * A ``Maze`` class with ``MazeTest`` unit tests
    * A ``MazeRenderer`` class with ``MazeRendererTest`` unit tests
    * Two exceptions: ``LocationNotInMazeException`` and ``MazeEndpointsException``
    * A ``MazeSolver`` interface
* A ``Queue`` and ``PriorityQueue`` interface
* A nearly empty ``LinkedPriorityQueue`` class with a ``LinkedPriorityQueueTest`` class containing empty tests
* A nearly empty ``AStarMazeSolver`` with an ``AStarMazeSolverTest`` class containing empty tests
* An ``Asn3`` class with an empty ``main``
* Three maze files

* :download:`All of this can be downloaded from here<Assignment3.zip>`
    * This is a compressed IntelliJ project
    * Just unzip, put it where you want on your computer, and you should be able to open this project through IntelliJ

.. warning::

    When you open the project, IntelliJ may notify you about a missing JDK. If this is the case, simply select the
    download link in the notification.

.. warning::

    Java may say that it cannot find JUnit. If this happens, you need to add JUnit to the project. Simply follow the
    first few steps of :doc:`Topic 6's aside on testing </topics/stacks/unit-tests>`.


Part 0 --- Read the Assignment
==============================

Read the assignment description in its entirety before starting.


Part 1 --- Read Through the Provided Code
=========================================

Read through all the provided code. The code is commented and there are method headers describing everything. These are
objects and methods you will be using to solve the problem.

Reading through and understanding existing code is a **huge** part of the assignment. Although there are no marks
directly associated with it, it is a requirement in order to do anything useful. Further, if you continue studying CS,
you will be reading documentation and other people's code **a lot**.

Be sure to also read through all the test classes. Take the time to make sense of what is going on --- these will save
you.

Lastly, it's not just having a superficial understanding of the provided code. Sure, one of the big points of
abstraction is not needing to fully understand everything *under the hood*; however, you're still new at this, and
taking the time to understand what is happening in the code, and how it does it, is important.


Part 2 --- Run Unit Tests
=========================

* Run all the tests for the maze package to make sure everything is working

* All these tests should pass
    * If not, something has gone wrong
        * Did you change the code?
        * Did your test folder get changed?
        * Try re-downloading the project if they do not pass

* You will notice the test classes ``AStarMazeSolverTest`` and ``LinkedPriorityQueueTest`` are provided, but incomplete
    * They have empty tests left for you to complete in their respective parts discussed below

* As discussed in Part 1, be sure to take your time to look through these test methods


Part 3 --- Complete ``LinkedPriorityQueue``
===========================================

A priority queue is going to help with the implementation of the A* algorithm.
`Feel free to read up on priority queues <https://en.wikipedia.org/wiki/Priority_queue>`_, but in short, a priority
queue is a queue with a twist --- whenever you dequeue something, you get the element with the most important priority.
In other words, you enqueue and dequeue things, but the order they come out is based on the priority value, not the
standard FIFO of a regular queue.

An example of this is triage at an emergency room: you may have arrived at the emergency room with a bad cut earlier
than the person with a giant crack in their skull, but they will get seen before you given the severity of their injury.


Notes About Your Implementation
-------------------------------

* You may find the regular ``LinkedQueue`` a good reference for starting
* Have priority values that are lower be considered "more important" (lower values get dequeued first)
* Given the definition, all that matters is that when something gets dequeued, it has the most important priority
    * Do you write your enqueue such that you search for the correct insertion spot (:math:`O(n)`) and then always dequeue from the front (:math:`O(1)`)?
    * Or have your enqueue always append to the end (:math:`O(1)`) and do a linear search for the most important priority on the dequeue (:math:`O(n)`)?
    * I suggest you go with the former --- have the enqueue find the correct spot to add the element, and have the dequeue simply remove from the front
* I provided an already complete ``equals`` and ``hashCode`` method for the ``LinkedPriorityQueue``
    * Leave these alone
    * Equals can be very difficult to write for collections, and this will help with testing
* I provided a complete ``PriorityNode`` class contained within the ``LinkedPriorityQueue`` class
    * Leave this alone


Implementing the Class
----------------------

In order to complete the ``LinkedPriorityQueue``, you will need write a constructor and implement all the required methods:
    * ``void enqueue(T element, int priority)``
    * ``void enqueue(T element)``
    * ``T dequeue()``
    * ``T first()``
    * ``int size()``
    * ``boolean isEmpty()``

* You should also write a ``String toString()`` method for the class


Implementing the Unit Tests
---------------------------

The ``LinkedPriorityQueueTest`` class contains empty test methods, but each has a name that tells you what the test
should do. You are to complete all these methods. As a starting point, look at the ``ArrayStackTest`` class provided in
assignment 2.

You do not need to test the provided ``equals`` method as I have already done that. Knowing you have a working
``equals`` makes it safe to use ``assertEquals`` in the unit tests.

Having complete tests should help you debug your ``LinkedPriorityQueue`` class.


Part 4 --- Complete ``AStarMazeSolver``
=======================================

`Read up on the A* algorithm <https://en.wikipedia.org/wiki/A*_search_algorithm>`_. The linked article is great, and I
am sure there are many YouTube videos on the subject.

One of the key parts of A* is the estimated cost function

    :math:`f(x) = g(x) + h(x)`

    * :math:`x` is some maze cell
    * :math:`g(x)` is the cost of getting to :math:`x` from the start
    * :math:`h(x)` is the heuristic's estimated cost of getting to the end from :math:`x`
    * :math:`f(x)` is the total estimated cost of a path from start to finish going through :math:`x`


Notes About Your Implementation
-------------------------------

* :math:`g(x)` will be the number of steps it takes to get to :math:`x` from the start
* :math:`h(x)` will be the estimated distance to the end from :math:`x` based on the `Manhattan Distance <https://en.wikipedia.org/wiki/Taxicab_geometry>`_
    * :math:`\lvert x_{1} - x_{2} \rvert + \lvert y_{1} - y_{2} \rvert`

* :math:`f(x)` will be the *priority* of the cell :math:`x`


Implementing the Class
----------------------

Write the ``solve`` method to find an optimal path in the maze using A*.

The general idea is this

    * Dequeue from the priority queue
    * If it's the end, we're done
    * If it's not, calculate all the neighbours' :math:`f(x)` (priority) and add each to the priority queue
    * Repeat


* You'll need a way to keep track of the number of steps it took to get to a given cell
    * Perhaps a ``Map``?
* You'll need a way to keep track of each cell's predecessor in the path
    * Which cell did I step from to get to the current cell?
    * Perhaps a ``Map``?
* Feel free to use as many private helper methods as you need

.. warning::
    Do not get distracted by your assignment 2 solution in ``DfsMazeSolver``. Although there are similarities, the
    actual algorithms have several noteworthy differences.


Implementing the Unit Tests
---------------------------

The ``AStarMazeSolverTest`` class contains a few constants and empty test methods. The constants are provided to help
with your tests. Each method has a name that tells you what the test should do. You are to complete all these methods.
As a starting point, look at the ``DfsMazeSolverTest`` class provided in assignment 2.

Having complete tests should help you debug your ``AStarMazeSolver`` class.


Part 5 --- Putting it Together
==============================

Once you are comfortable that your ``LinkedPriorityQueue`` and ``AStarMazeSolver`` are working correctly, write your
main method. Expect it to be short (less than 10 lines); if your main is long, you're probably doing something wrong and
working too hard. You will likely find that your main method is remarkably similar to the one from assignment 2.

In order to actually solve a maze, you need

    * A ``Maze``
    * A ``MazeSolver`` to solve the maze
    * A ``MazeRenderer`` for rendering the maze with the solution so it can be printed out

You will want to run your program on mazes from files. I have provided you with a ``RELATIVE_RESOURCES`` constant in the
``Asn3`` class. This is the relative path to the directory where the maze files are stored. Simply take this relative
path and concatenate it with the file name of the maze you want to open.


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
