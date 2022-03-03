*******************************************************
Assignment #4: 1100010110111010001110110100111110001001
*******************************************************

* **Worth**: 10%
* **DUE**: April 11th 11:55pm; submitted on MOODLE.


Task
====

Your goal is to compress data such that they take up less space, but can be uncompressed without losing any information.
You implement Huffman Coding as the compression mechanism. The data will be compressed with an encoding process, and
uncompressed with a decoding process.

You will:

* Write ``HuffmanLeaf`` and ``HuffmanInternal`` classes that implements ``HuffmanNode``
    * These will help with the creation of the Huffman Codes
* Write a ``HuffmanNodeComparator`` class that implements the ``Comparator`` interface
    * This is what defines the order of the ``HuffmanNode`` objects
* Write a ``HuffmanCode`` class that will encode and decode strings
* You will use the ``HuffmanCode`` in the ``main`` to
    * Encode strings
    * Decode strings
    * Measure the compression percentage
* You will also be testing your implementation with test classes


Provided Files
==============

* A complete ``HuffmanNode`` interface
* A nearly empty ``HuffmanLeaf`` class with a skeleton ``HuffmanLeafTest`` class
* A nearly empty ``HuffmanInternal`` class with a skeleton ``HuffmanInternalTest`` class
* A skeleton ``HuffmanNodeComparator`` class with a complete ``HuffmanNodeComparatorTest`` class
* A skeleton ``HuffmanCode`` class with a skeleton ``HuffmanCodeTest`` class
* An ``Asn4`` class with an empty ``main``
* A text file that may be used to seed the Huffman Code


* :download:`All of this can be downloaded from here<./data/Assignment4.zip>`
    * This is a compressed IntelliJ project
    * Just unzip, put it where you want on your computer, and you should be able to open this project through IntelliJ

.. warning::

    When you open the project, IntelliJ may notify you about a missing JDK. If this is the case, simply select the
    download link in the notification.

.. warning::

    Java may say that it cannot find JUnit. If this happens, you need to add JUnit to the project. Simply follow the
    first few steps of :doc:`Topic 6's aside on testing </topic6-testing>`.


Part 0 --- Read the Assignment
==============================

Read the assignment description in its entirety before starting.


Part 1 --- Read Up on Huffman Codes
===================================

Read up on Huffman Codes. Be sure to dig deeper than just how it is used to compress data. You will want to see how it
works. `The Wikipedia page gives details <https://en.wikipedia.org/wiki/Huffman_coding>`_ but I did not find it to be
all that helpful myself. I suggest you do some digging around online or find some YouTube videos that
explain the details.

Things of note related to Huffman Codes to look out for

    * How data is stored within nodes in a binary tree structure
    * How a priority queue can be used
    * How the nodes are ordered
    * How to encode
    * How to decode


Part 2 --- Complete Huffman Nodes
=================================


Notes About Your Implementation
-------------------------------


Implementing the Class
----------------------


Implementing the Unit Tests
---------------------------


Part 3 --- Complete ``HuffmanNodeComparator``
=============================================

Although we have seen ``comparable`` when implementing the ``ArraySortedBag`` and ``LinkedBinarySearchTree``, here we
make use of a `Comparator <https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Comparable.html>`_ .
A ``Comparator`` is a very similar idea to ``comparable``, but it allows for more flexibility when needing to define more complex
orderings.


Implementing the Class
----------------------

Write the ``int compare(HuffmanNode huff1, HuffmanNode huff2)`` method in the provided ``HuffmanNodeComparator`` class.

You must have ``compare`` return a negative integer if ``huff1 < huff2``, zero if ``huff1 == huff2``, and a positive
number if ``huff1 > huff2``.

Make sure you have a good sense of the order the ``HuffmanNode`` objects have

    * Nodes with smaller weights come first
    * If a leaf and an internal node have the same weight, the leaf comes first
    * If two leaf nodes have the same weight, the one with the smaller ASCII value comes first
    * If two internal nodes have the same weight, the order does not matter


Run the Unit Tests
------------------


Part 4 --- Complete ``HuffmanCode``
===================================



Notes About Your Implementation
-------------------------------


Implementing the Class
----------------------


Implementing the Unit Tests
---------------------------


Part 5 --- Putting it Together
==============================


Part 6 --- Testing
==================


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
    * Good thing google exists and you're capable of learning on your own.
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
