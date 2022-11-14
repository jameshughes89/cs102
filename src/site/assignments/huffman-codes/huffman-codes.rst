*******************************************************
Assignment #4: 1100010110111010001110110100111110001001
*******************************************************

* **Worth**: 10%
* **UPDATED DUE DATE**: April 14th 11:55pm; submitted on MOODLE.


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
* A nearly empty ``HuffmanLeaf`` class with a skeletal ``HuffmanLeafTest`` class
* A nearly empty ``HuffmanInternal`` class with a skeletal ``HuffmanInternalTest`` class
* A skeletal ``HuffmanNodeComparator`` class with a complete ``HuffmanNodeComparatorTest`` class
* A skeletal ``HuffmanCode`` class with a skeletal ``HuffmanCodeTest`` class
* An ``Asn4`` class with an empty ``main``
* A text file that may be used to seed the Huffman Code


* :download:`All of this can be downloaded from here<Assignment4.zip>`
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

The Huffman nodes are an important piece of the Huffman Codes. Based on your reading of Huffman Codes, you will have
learned that there are two types of nodes

    * Nodes that store a character and it's weight (leaf nodes)
    * Nodes that have a left and right subtree and a weight (internal nodes)

Both types of nodes have a weight; leaf nodes have a weight equal to the number of times a given character is contained
within some string, and the internal nodes' weight is the sum of their left and right subtrees' weights.


Implementing the Classes
------------------------

You are provided with a complete ``HuffmanNode`` interface that will be implemented by the ``HuffmanLeaf`` and
``HuffmanInternal`` classes. You will notice that the interface is very short --- ``getWeight()``.

Both the ``HuffmanLeaf`` and ``HuffmanInternal`` will have a ``weight`` field, but the ``HuffmanLeaf`` will also need to
keep track of which character it has. Have your constructor for the leaf nodes always convert the character to lower
case. Additionally, the ``HuffmanInternal`` needs references to its left and right subtrees.

Only worry about writing getters for these classes as we will never be updating any of the fields after the objects are
initialized.

To help with testing, also write a ``toString`` method.


Implementing the Unit Tests
---------------------------

There are skeletal test classes with incomplete test methods for each of the node types. The method names should give
you a good enough idea about what each method should be testing. Complete the unit tests and ensure the node classes you
wrote are working correctly.


Part 3 --- Complete ``HuffmanNodeComparator``
=============================================

Although we have seen ``comparable`` when implementing the ``ArraySortedBag`` and ``LinkedBinarySearchTree``, here we
make use of a `Comparator <https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Comparable.html>`_ .
A ``Comparator`` is a very similar idea to ``comparable``, but it allows for more flexibility when needing to define
more complex orderings.


Implementing the Class
----------------------

Write the ``int compare(HuffmanNode huff1, HuffmanNode huff2)`` method in the provided ``HuffmanNodeComparator`` class.

You must have ``compare`` return a negative integer if ``huff1 < huff2``, zero if ``huff1 == huff2``, and a positive
number if ``huff1 > huff2``.

Make sure you have a good sense of the order the ``HuffmanNode`` objects must have based on the Huffman Code compression
strategy

    * Nodes with smaller weights come first
    * If a leaf and an internal node have the same weight, the leaf comes first
    * If two leaf nodes have the same weight, the one with the smaller ASCII value comes first
    * If two internal nodes have the same weight, the order does not matter

You can check if a given reference variable is referencing an object of a specific type with the
``instanceof`` operator. For example, ``huff1 instanceof HuffmanLeaf`` results in ``true`` if ``huff1`` is referencing
something of type (or subtype) of ``HuffmanLeaf``.


Run the Unit Tests
------------------

Since testing ``Comparator`` objects can be quite tedious, I have provided a complete set of unit tests for the class.
If everything is working properly in your ``HuffmanNodeComparator`` class, the tests should pass.

Make sure to take your time investigating these unit tests. One thing of note is that the primary way the
``HuffmanNodeComparator`` is tested is by sorting a list based on the order defined by the ``HuffmanNodeComparator``. In
the method ``compare_unsortedList_sortsList``

    * A list of ``HuffmanNode`` objects in their proper order, referenced by ``sorted``, is created
    * A copy of that list is made and referenced by ``unsorted``
    * The ``unsorted`` list is shuffled (to make it actually unsorted)
    * The ``unsorted`` list is then sorted based on the ordering of the ``HuffmanNodeComparator`` (``classUnderTest``)

The idea here is, if the ``HuffmanNodeComparator`` sorts the whole list such that the elements return to their correct
sorted order as laid out in ``sorted``, then the ``HuffmanNodeComparator`` should be correct.


Part 4 --- Complete ``HuffmanCode``
===================================

The ``HuffmanCode`` class will make use of the ``HuffmanNode`` and ``HuffmanNodeComparator`` class to implement the
compression. Ultimately, this class will be responsible for building the Huffman Tree based on some seed string and
encoding and decoding strings.


Notes About Your Implementation
-------------------------------

* You will want to use a ``PriorityQueue``, but instead of implementing one on your own, `this time you will use the one from java.util. <https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/PriorityQueue.html>`_
    * `Make use of the constructor that takes a comparator <https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/PriorityQueue.html#%3Cinit%3E(java.util.Comparator)>`_
    * Take care to notice the methods as this implementation does not call their add/remove ``enqueue``/``dequeue``


* You will be making use of factory methods for instantiating the objects
    * Refer to the ``Maze`` class from assignments 2 and 3
    * Make your constructor private
    * I have provided you with an already "complete" ``fromFile`` factory method
        * Although, it delegates all the work to the ``fromString`` you are to write, so you may be disappointed

* Under the hood, this class is creating and storing a binary tree of ``HuffmanNode`` objects
* I recommend having a field within the class that stores each character's encoding in a ``Map<Character, String>``
* Do not be afraid to make use of private helper methods


Implementing the Class
----------------------

Your class should have at least one field --- a reference to the root of the Huffman Tree. As discussed above, it is
recommended that you also include another field --- a map storing each character's bit string encoding.

Complete the ``public static HuffmanCode fromString(String seed)`` method. This factory method will do all the setup for
the class and return a reference to a ``HuffmanCode`` object. Expect this method to

    * Count the number of times each character exists in the seed string
    * Initialize the priority queue
    * Build the tree
    * Populate the character map
    * Return a new ``HuffmanCode``

I suggest making a private method with recursive traversal through the tree for populating the map

Complete the ``public String encode(String string)`` method which takes a string and returns a bit string encoding. The
encoding is based on the encoding of each character.

Complete the ``public String decode(String bits)`` method for decoding the bit string. This is the inverse operation of
``encode``. With the use of a private helper method, decode the string recursively.


Implementing the Unit Tests
---------------------------

There is a skeletal test class with incomplete test methods for the ``HuffmanCode`` class. The method names should give
you a good enough idea about what each method should be testing. Complete the unit tests and ensure the class you wrote
is working correctly.

Part 5 --- Putting it Together
==============================

Once everything is done, write the ``main`` method to compress some strings. Like the previous assignments, this method
will likely be short.

This method must

    * Create a ``HuffmanCode`` instance from a string or a file
    * Encode some string
    * Decode the string
    * Print out the original, encoded, and decoded strings
    * Print out the percentage the message got compressed

To calculate the compression percentage, we will make a few assumptions

    * Assume that a given character takes up 1 byte (8 bits)
        * If the string has 10 characters, then we will assume it takes up 80 bits
        * In reality, characters may take up more space than 8 bits, but we will ignore this here
    * Assume that the 0s and 1s in the encoded message are each 1 bit
        * If the encoded string has 20 characters, then we assume it takes up 20 bits
        * In reality, we are storing the 0s and 1s in a string, meaning each is actually a character that takes up 8 bits, but we will ignore this here


Part 6 --- Testing
==================

You may have already verified the correctness of your classes by completing and running their test classes. If not, do
it!

If you have, for good measure, re-run all the tests provided to you and the ones you wrote. If they all pass, you should
be pretty confident that you have everything working correctly.

There is no test provided for the ``Asn4`` class, but that's nothing to worry about. You can get a sense that it is
working correctly by

    * Running your program on different seeds
    * Encoding and decoding various strings


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
