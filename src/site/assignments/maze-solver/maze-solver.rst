********************************
Maze Solver --- A Path is a Path
********************************

* **Worth**: 5%
* **DUE**: February 26, 11:55pm; submitted on MOODLE.


Task
====

The goal is to solve a maze with a *depth first search* implemented with a stack.

You will:

* Create a ``DfsMazeSolver`` class that implements the ``MazeSolver`` interface

    * Within this class, you will write the ``solve`` method


* Use the ``DfsMazeSolver``, along with some of the other provided classes, in the ``main`` to:

    * Create the maze
    * Solve the maze
    * Display the solution


* Test the implementation with the provided test classes



Provided Files
==============

You are provided with:

* A package containing maze specific classes

    * A ``Cell`` class with ``CellTest`` unit tests
    * A ``Maze`` class with ``MazeTest`` unit tests
    * A ``MazeRenderer`` class with ``MazeRendererTest`` unit tests
    * Two exceptions --- ``LocationNotInMazeException`` and ``MazeEndpointsException``
    * A ``MazeSolver`` interface


* A ``Stack`` interface
* An ``ArrayStack`` class with ``ArrayStackTest`` unit tests
* A nearly empty ``DfsMazeSolver`` with a complete ``DfsMazeSolverTest`` test class
* An ``Asn2`` class with an empty ``main``
* Three maze files


* :download:`All of this can be downloaded from here <Assignment2.zip>`

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

At the end of this assignment page, there is a list of some code peculiarities you may not be familiar with. Be sure to
read through this before really jumping into coding.


Part 2 --- Run Unit Tests
=========================

* Run all the tests for the provided completed classes

    * Everything except the ``DfsMazeSolverTest``


* All these tests should pass

    * If not, something has gone wrong

        * Did you change the code?
        * Did your test folder get changed?
        * Try re-downloading the project and starting over if they do not pass


* As discussed in Part 1, be sure to take your time to look through these test methods



Part 3 --- Complete ``DfsMazeSolver``
=====================================

It is in the ``DfsMazeSolver`` object's ``solve`` method where the magic happens. This assignment requires an
implementation of a *Depth First Search* (DFS).

Given the stack's LIFO property, it's great for keeping track of where we are and how we got there. If we ever want to
backtrack, we simply pop things off the stack until we rewind to where we want --- think undo, or the back button on a
browser. In other words, we will be making use of an ``Stack`` of ``Cell`` objects (``Stack<Cell>``) for our DFS --- we
go as deep as we can down a path until we find the end, or we find a dead end and need to backtrack.

The general idea is this

    * Start with the maze's starting ``Cell`` and push it on the stack

        * Look at the top cell of the stack
        * If it's the end, we're done
        * If it's not, find an unvisited valid neighbour and push it on the stack

            * When looking for a valid neighbour, consider looking in a clockwise manner starting at 12 o'clock
            * Only consider the four directions (up, right, down, left)


        * If there are no valid neighbours, we're at a dead end --- we must backtrack
        * Repeat



When the method finishes, it must return a ``Set`` of ``Cell`` objects (``Set<Cell>``) containing the ``Cell``
objects in the solution.



Suggestions
-----------

* Make use of a ``HashSet`` for keeping track of visited ``Cell`` objects
* Consider writing private helper methods in the ``DfsMazeSolver`` class

    * Note that only public methods are typically tested; private methods are not tested



Part 4 --- Putting it Together
==============================

Once the ``DfsMazeSolver`` is working correctly, write the main method. Expect it to be short (less than 10 lines); if
it ends up getting long, you're probably doing something wrong and working too hard.

In order to actually solve a maze, one needs

    * A ``Maze``
    * A ``MazeSolver`` to solve the maze
    * A ``MazeRenderer`` for rendering the maze with the solution


You will want to run your program on mazes from files. I have provided you with a ``RELATIVE_RESOURCES`` constant in the
``Asn2`` class. This is the relative path to the directory where the maze files are stored. Simply take this relative
path and concatenate it with the file name of the maze you want to open.


Part 5 --- Testing
==================

You may have already verified the correctness of your ``DfsMazeSolver`` with the ``DfsMazeSolverTest`` class. If not, do
it!

If you have, for good measure, re-run all the tests provided to you. If they all pass, you should be pretty confident
that you have everything working correctly.


There is no test provided for the ``Asn2`` class, but that's nothing to worry about. You can get a sense that it is
working correctly by

    * Running your program on the maze files provided
    * Create your own maze programs and try running on them too


Code Peculiarities of Note
==========================

Exceptions
----------

* There are two exceptions included that are not provided by Java by default

    * ``LocationNotInMazeException``
    * ``MazeEndpointsException``


* These are used/thrown by the ``Maze`` class under certain circumstances

    * When a given cell coordinate is not in the maze
    * When there are issues with the start and/or end cells of a maze


Final Class and Fields
----------------------

* You will notice that the ``Maze`` and ``Cell`` classes are set to ``final``

    * e.g. ``public final class Cell``
    * All it means is that this class cannot be inherited from
    * We have yet to discuss inheritance, so do worry too much about this


* The ``Maze`` and ``Cell`` objects' fields are set to ``final``

    * This means we do not allow any fields to change

        * You will also notice no setters in these classes


    * We can have Java explicitly make sure they stay unchanged



Missing Constructors
--------------------

* In the ``MazeRenderer`` and ``DfsMazeSolver``, you will notice there are no constructors
* This may seem strange, but if you do not write a constructor, Java is still happy to create an instance of the object

    * e.g. ``MazeRenderer renderer = new MazeRenderer();``


* This is because Java automatically adds a default constructor with no parameters if it does not exist in the class
* Not writing in constructors is reasonable in our case since

    * These classes have no fields
    * Do not need any special setup code



Private Constructor
-------------------

* You may notice the constructor for ``Maze`` is set to ``private``
* This may seem odd since any method set to ``private`` is not accessible outside the class
* And if you cannot access it outside the class, how can you create an instance of a ``Maze``?

* The trick is, *you* don't, the *class* does

* Ideally, constructors should be simple and serve a single purposed

    * Like setting fields


* But if we start having constructors read files, parse large strings, etc., we're starting to break this principle

* The alternative is to create static *factory* methods

    * e.g. ``public static Maze fromFile(String mazeFile)``


* The factory method does the heavy lifting, and then creates and returns a new ``Maze`` instance
* Long story short, you will **not** be making a ``Maze`` like this

    * ``Maze myMaze = newMaze(x, y, z);``


* Instead, you will make your maze by getting the class to do it like this

    * ``Maze myMaze = Maze.fromFile(someFile);``


Fancier Tests
-------------

* Within some test classes, like ``CellTest`` and ``MazeTest``, you will notice ``ParameterizedTest``
* This makes it such that we can have a single test run multiple times checking slight variations
* It's probably easier to get a sense of what this means by having a look at one of these methods

    * e.g ``void isVisitable_visitable_returnsTrue(char symbol)``



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

    * *DfsMazeSolver.java* and *Asn2.java*
    * Do **not** submit the *test* classes
    * Do **not** submit the *.csv* files
    * Do **not** submit the *.class* files
    * Do **not** compress the files



.. warning::

    Verify that your submission to Moodle worked. If you submit incorrectly, you will get a 0.



Assignment FAQ
==============

* :doc:`See the general FAQ </assignments/faq>`

