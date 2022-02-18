********************************************
Assignment #2: Maze Solver: A Path is a Path
********************************************

* **Worth**: 10%
* **DUE**: March 7th 11:55pm; submitted on MOODLE.


Task
====

Your goal is to solve a maze with a *depth first search* implemented with a stack.

You will:

* Write a ``DFSMazeSolver`` class that implements the ``MazeSolver`` interface
    * Within this class, you will write the ``solve`` method.
* You will use the ``DFSMazeSolver``, along with some of the other provided classes, in the ``main`` to:
    * Create the maze
    * Solve the maze
    * Print out the solution
* You will also be testing your implementation with the provided test classes


Provided Files
==============

You are provided with:

* A ``Stack`` interface
* An ``ArrayStack`` class with ``ArrayStackTest`` unit tests
* A ``Cell`` class with ``CellTest`` unit tests
* A ``Maze`` class with ``MazeTest`` unit tests
* A ``MazeRenderer`` class with ``MazeRenderer`` unit tests
* Two exceptions: ``LocationNotInMazeException`` and ``MazeEndpointsException``
* A ``MazeSolver`` interface
* A nearly empty ``DFSMazeSolver`` with a complete ``DFSMazeSolverTest``
* An ``Asn2`` class with an empty ``main``
* A bunch of maze files

* :download:`All of this can be downloaded from here<./data/Assignment2.zip>`
    * This is a compressed IntelliJ project
    * Just unzip, put it where you want on your computer, and you should be able to open this project through IntelliJ

.. warning::

    When you open the project, IntelliJ may notify you about a missing JDK. If this is the case, simply select the
    download link in the notification.


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
you. You may want to do some brief reading on
`@Nested <https://junit.org/junit5/docs/current/user-guide/#writing-tests-nested>`_ and
`@ParameterizedTest <https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests>`_. The
documentation may seem intimidating at first, but take your time and have a read. You may be surprised at how helpful
reading the docs actually is.

Lastly, it's not just having a superficial understanding of the provided code. Sure, one of the big points of
abstraction is not needing to fully understand everything *under the hood*; however, you're still new at this, and
taking the time to understand what is happening in the code and how it does it is important.

At the end of this assignment page, there is a list of some code peculiarities you may not be familiar with. Be sure to
read through this before really jumping into coding.


Part 2 --- Run Unit Tests
=========================


Part 3 --- Complete ``DFSMazeSolver``
=====================================


Part 5 --- Putting it Together
==============================


Part 5 --- Testing
==================


Code Peculiarities of Note
==========================


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


FAQ:
====

* I don't know where to start.
    * Did you read the assignment description?

* I still don't know where to start.
    * Part 0.

* Should I be making any significant changes to the provided code/files?
    * Unless it's an empty class you are to complete, no.

* I know you told me to do it this way, but I did it another way, and I think my way is better.
    * Your way may be better, but do it the way I told you.

* I don't know how to do *X*.
    * OK, go to `google.ca <https://www.google.ca>`_ and type in *X*.

* You have asked us to do something you never taught us.
    * Good thing google exists and you're capable of learning learn on your own.
    * Jokes aside, reading docs and figuring out how to do stuff is a huge part of your job.

* Can I email you or the TA for help?
    * Absolutely, *buuuuut*
    * Tell me all the things you have tried before emailing. If it's a short list, I may ignore you.
    * Do not send me code, do not send me screenshots of code, do not try to describe chunks of code in english, etc.
    * Email is appropriate for quick clarification questions.
    * Anything beyond that should be addressed at office hours.
    * Please do not just send the email anyways to fish and see if I will answer --- I won't, and I'll be annoyed.

* I swear I did everything right, but my files are not opening.
    * This one isn't uncommon.
    * Your files may be in the wrong location on your computer.
    * I provided you with a constant for the relative path to the files, so that should work.

* It's not working, therefore Java is broken!
    * Probably not; you're likely doing something wrong.

* There is a bug in my code and it's not working
    * Welcome to writing code.
    * Keep at it, you'll get there.

* There is a bug in my code and it's not working after hours of debugging
    * This is normal.
    * Keep at it, you'll get there.
    * I believe in you.
    * You are a capable human being.

* Do I have enough comments?
    * I don't know, maybe?
    * If you're looking at code and have to ask if you should comment it... just comment it.
    * That said, don't write me a book.

* I know I cheated, I know I know I was cheating, but I'm reeeeaaaaaaaaallllllly sorry [that I got caught]. Can we just ignore it this time?
    * No.
    * Catching cheaters is one of my only joys in life.

* What's this whole *due date* and *cutoff date* business?
    * The due date is the due date, so hand things in before the due date, otherwise it is considered late.
    * But you may submit your late assignment with no penalty up to the cutoff date.
    * There are no extensions beyond the cutoff date.

* Can I have an extension?
    * You can have the 7 days before the cutoff period.
    * After the cutoff date though, no --- no extension.

* If I submit it at 11:56pm, you'll still mark it, right? I mean, commmmon!
    * No.
    * 11:55pm and earlier is on time.
    * Anything after 11:55pm is late.
    * Anything late is not marked.
    * It's rather simple really.

* Moodle was totally broken, it's not my fault it's late.
    * Nice try.
    * But to hedge, don't try to submit it at the last minute.

* I accidentally submitted the wrong code. Here is the right code, but it's late. But you can see that I submitted the wrong code on time! You'll still accept it, right?
    * Do you think I was born yesterday?
    * No.

* Will I really get 0 if I do the submission wrong? Like, what if I submit the .class instead of the .java?
    * Yes, you'll really get a **ZERO**.
    * Just double check to make sure your submission is correct.

