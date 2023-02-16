****************************************
1100010110111010001110110100111110001001
****************************************

* **Worth**: 5%
* **DUE DATE**: April 3rd 11:55pm; submitted on MOODLE.


Task
====

The goal is to compress data such that they take up less space, but can be uncompressed without losing any information.
Huffman Coding is to be used as the compression mechanism. The data will be compressed with an encoding process, and
uncompressed with a decoding process.

Objectives:

* Create ``HuffmanLeaf`` and ``HuffmanInternal`` classes that implement ``HuffmanNode``

    * These will help with the creation of the Huffman Codes


* Create a ``HuffmanNodeComparator`` class that implements the ``Comparator`` interface

    * This is what defines the order of the ``HuffmanNode`` objects


* Create a ``HuffmanCode`` class that will encode and decode strings
* The ``HuffmanCode`` object will be used in the ``main`` to:

    * Encode strings
    * Decode strings
    * Measure the compression percentage


* Test the implementation with test classes



Provided Files
==============

* A complete ``HuffmanNode`` interface
* A nearly empty ``HuffmanLeaf`` class with a ``HuffmanLeafTest`` class containing empty tests
* A nearly empty ``HuffmanInternal`` class with a ``HuffmanInternalTest`` class containing empty tests
* A nearly empty ``HuffmanNodeComparator`` class with a complete ``HuffmanNodeComparatorTest`` class
* A nearly empty ``HuffmanCode`` class with a ``HuffmanCodeTest`` class containing empty tests
* An ``Asn4`` class with an empty ``main``
* A text file that may be used to seed the Huffman Code


* :download:`All of this can be downloaded from here <Assignment4.zip>`

    * This is a compressed IntelliJ project
    * Just unzip, put it in the desired location on the computer, and open the project through IntelliJ


.. warning::

    When opening the project, IntelliJ may mention a missing JDK. If this is the case, simply select the download link
    in the notification to download and install the missing JDK.



Part 0 --- Read the Assignment
==============================

Read the assignment description in its entirety before starting.


Part 1 --- Read Up on Huffman Codes
===================================

Read up on Huffman Codes. Be sure to dig deeper than just how it is used to compress data. Having a strong understanding
of how it works will greatly help with completing the assignment.
`The Wikipedia page gives details <https://en.wikipedia.org/wiki/Huffman_coding>`_ but it is suggested to find
additional resources to learn from. Perhaps YouTube or other online resources will prove helpful.

Things of note related to Huffman Codes to look out for:

    * How data is stored within nodes in a binary tree structure
    * How a priority queue can be used
    * How the nodes are ordered
    * How to encode
    * How to decode


Part 2 --- Complete Huffman Nodes
=================================

The Huffman nodes are an important piece of the Huffman Codes. There are two types of nodes:

    * Nodes that store a character and it's weight (leaf nodes)
    * Nodes that have a left and right subtree and a weight (internal nodes)


Both types of nodes have a weight; leaf nodes have a weight equal to the number of times a given character is contained
within some string, and the internal nodes' weight is the sum of their left and right subtrees' weights.


Implementing the Classes
------------------------

A complete ``HuffmanCode`` interface is provided. This interface will be implemented by the ``HuffmanLeaf`` and
``HuffmanInternal`` classes. Notice that the interface is very short --- ``getWeight()``.

Both the ``HuffmanLeaf`` and ``HuffmanInternal`` will have a ``weight`` field, but the ``HuffmanLeaf`` will also need to
keep track of which character it has. Have the constructor for the leaf nodes always convert the character to lower
case. Additionally, the ``HuffmanInternal`` needs fields for referencing its left and right subtrees (``HuffmanNode``
objects).

These classes will be immutable; only write getters as the data within the fields will not need to be updated after
the objects are initialized.

To help with testing, also write a ``toString`` method.


Implementing the Unit Tests
---------------------------

There are skeletal test classes with incomplete test methods for each of the node types. The method names should provide
an idea of what each method should be testing. Complete the unit tests and ensure the implemented node classes are
working correctly.


Part 3 --- Complete ``HuffmanNodeComparator``
=============================================

Although ``comparable`` was used when implementing the ``ArraySortedBag`` and ``LinkedBinarySearchTree``, here a
`Comparator <https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Comparable.html>`_  is to be used.
A ``Comparator`` is a very similar idea to ``comparable``, but it allows for more flexibility when needing to define
more complex orderings.


Implementing the Class
----------------------

Write the ``int compare(HuffmanNode huff1, HuffmanNode huff2)`` method in the provided ``HuffmanNodeComparator`` class.

The ``compare`` method must return a negative integer if ``huff1 < huff2``, zero if ``huff1 == huff2``, and a positive
integer if ``huff1 > huff2``.

Make sure to have a good sense of the order the ``HuffmanNode`` objects must have based on the Huffman Code compression
strategy:

    * Nodes with smaller weights come first
    * If a leaf and an internal node have the same weight, the leaf comes first
    * If two leaf nodes have the same weight, the one with the smaller ASCII value comes first
    * If two internal nodes have the same weight, the order does not matter


The ``instanceof`` operator can be used to check if a given reference variable is referencing an object of a specific
type. For example, ``huff1 instanceof HuffmanLeaf`` results in ``true`` if ``huff1`` is referencing something of type
(or subtype) of ``HuffmanLeaf``.


Run the Unit Tests
------------------

Since testing ``Comparator`` objects can be quite tedious, a complete set of unit tests for the class is provided. If
everything is working properly in the ``HuffmanNodeComparator`` class, the tests should pass.

Make sure to take time investigating these unit tests. One thing of note is that the primary way the
``HuffmanNodeComparator`` is tested is by sorting a list based on the order defined by the ``HuffmanNodeComparator``.

In the method ``compare_unsortedList_sortsList``:

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


Notes About the Implementation
------------------------------

* A ``PriorityQueue`` should be used, but instead of implementing one, `use the one from java.util <https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/PriorityQueue.html>`_

    * `Make use of the constructor that takes a comparator <https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/PriorityQueue.html#%3Cinit%3E(java.util.Comparator)>`_
    * Take care to notice the methods as this implementation does not call the add/remove ``enqueue``/``dequeue``


* Make use of factory methods for instantiating the objects

    * Refer to the ``Maze`` class from assignments 2 and 3
    * Make the constructor private
    * An already "complete" ``fromFile`` factory method is provided

        * Although, it delegates all the work to the ``fromString`` method that needs to be implemented


* Under the hood, this class is creating and storing a binary tree of ``HuffmanNode`` objects
* It is recommended to have a field within the class that stores each character's encoding in a ``Map<Character, String>``
* Do not be afraid to make use of private helper methods as needed


Implementing the Class
----------------------

The class should have at least one field --- a reference to the root of the Huffman Tree. As discussed above, it is
recommended to also include another field --- a map storing each character's bitstring encoding.

Complete the ``public static HuffmanCode fromString(String seed)`` method. This factory method will do all the setup for
the class and return a reference to a ``HuffmanCode`` object. Expect this method to:

    * Count the number of times each character exists in the seed string
    * Initialize the priority queue
    * Build the tree
    * Populate the character encoding map
    * Return a new ``HuffmanCode``


It is recommended to make use of a private helper method to populate the character encoding map. A recursive traversal
of the tree would work well in this scenario.

Complete the ``public String encode(String string)`` method which takes a string and returns a bitstring encoding. The
encoding is based on the encoding of each character.

Complete the ``public String decode(String bits)`` method for decoding the bitstring. This is the inverse operation of
``encode``. With the use of a private helper method, decode the string recursively.


Implementing the Unit Tests
---------------------------

There is a skeletal test class with incomplete test methods for the ``HuffmanCode`` class. The method names should
provide an idea of what each method should be testing. Complete the unit tests and ensure the class is working
correctly.


Part 5 --- Putting it Together
==============================

Once everything is done, write the ``main`` method to compress some strings. Like the previous assignments, this method
will likely be short.

This method must:

    * Create a ``HuffmanCode`` instance from a string or a file
    * Encode some string
    * Decode the string
    * Print out the original, encoded, and decoded strings
    * Print out the percentage the message got compressed


To calculate the compression percentage, make a few assumptions:

    * Assume that a given character takes up 1 byte (8 bits)

        * If the string has 10 characters, then we will assume it takes up 80 bits
        * In reality, characters may take up more space than 8 bits, but ignore this here


    * Assume that the 0s and 1s in the encoded message are each 1 bit

        * If the encoded bitstring has 20 characters, then assume it takes up 20 bits
        * In reality, the 0s and 1s are being stored in a string, meaning each is actually a character that takes up more space, but ignore this here


Part 6 --- Testing
==================

The correctness of the classes may have already been verified by completing and running their test classes. If not, do
it!

If they have already been verified, for good measure, re-run all the tests provided and the ones completed for the
assignment. If they all pass, one should be pretty confident that everything is working correctly.

There is no test provided for the ``Asn4`` class, but that's nothing to worry about. Get a sense that it is working
correctly by

    * Running the program on different seeds
    * Encoding and decoding various strings


Some Hints
==========

* Work on one function at a time
* Get each function working perfectly before you go on to the next one
* Test each function as you write it

    * This is a really nice thing about programming; you can call your functions and see what result gets returned
    * Mentally test before you even write --- what does this function do? What problem is it solving?


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

* Make sure your **NAME**, **STFX EMAIL**, and **STUDENT NUMBER** appear in a comment at the top of the classes
* Submit the completed *.java* files to Moodle

    * *HuffmanLeaf.java* and *HuffmanLeafTest.java*
    * *HuffmanInternal.java* and *HuffmanInternalTest.java*
    * *HuffmanNodeComparator.java*
    * *HuffmanCode.java* and *HuffmanCodeTest.java*
    * *Asn4.java*
    * Do **not** submit the provided *test* classes
    * Do **not** submit the seed file
    * Do **not** submit the *.class* files
    * Do **not** compress the files


* Your ``.java`` files. Please do not compress them.


.. warning::

    Verify that your submission to Moodle worked. If you submit incorrectly, you will get a 0.


Assignment FAQ
==============

* :doc:`See the general FAQ </assignments/faq>`
