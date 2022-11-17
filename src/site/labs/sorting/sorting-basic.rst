*******
Sorting
*******

* Feel free to use your laptop if you have it
* I strongly encourage you to work with others in the lab

    * When you get stuck, do me a favour and ask those sitting around you for help
    * I want people to get used to working together in the labs
    * Peer teaching and peer learning is super effective

.. note::

    This lab is making use of integer arrays for sorting, but if you would like, feel free to use ``IndexedBags``. If
    choose to do this, here's a tip for your method declarations:

    ``public static <T extends Comparable<T>> void bubbleSort(IndexedBag<T> toSort)``

    Also remember to use ``.compareTo``.


Starting Point
==============

This lab focuses on the sorts discussed in :doc:`topic 25 </topics/sorting/sorting-basic>`.

The below code can be used for setting up an array to be sorted and timing the different sorting algorithms.

.. code-block:: java

    public static void main(String[] args){

        int[] toSort = createUnsortedArray(10000, 10);
        printArray(toSort);

        double startTime = System.nanoTime();
        bubbleSort(toSort);
        //insertionSort(toSort);
        //selectionSort(toSort);
        double endTime = System.nanoTime();

        printArray(toSort);
        System.out.println("runtime: " + (endTime - startTime)/1000000 + " ms");
    }

    public static int[] createUnsortedArray(int n, int maxValue){
        int[]  toSort= new int[n];
        for(int i = 0; i < n; ++i){
            toSort[i] = (int)(Math.random() * maxValue);
        }
        return toSort;
    }

    public static void printArray(int[] toPrint){
        for(int value: toPrint){
            System.out.print(value + ", ");
        }
        System.out.println();
    }


Bubble Sort
===========

#. Implement the bubble sort algorithm.
#. Make sure it works and test it a few times and see what the runtimes are.

    * Change the size of the array and the max value and see how it impacts runtimes
    * For the purposes of this lab, do not worry about writing unit tests

.. code-block:: java

    public static void bubbleSort(int[] toSort){
        // Fill me in
    }


Insertion Sort
==============

#. Implement the insertion sort algorithm.
#. Make sure it works and test it a few times and see what the runtimes are.

    * Change the size of the array and the max value and see how it impacts runtimes
    * For the purposes of this lab, do not worry about writing unit tests

.. code-block:: java

    public static void insertionSort(int[] toSort){
        // Fill me in
    }


Selection Sort
==============

#. Implement the selection sort algorithm.
#. Make sure it works and test it a few times and see what the runtimes are.

    * Change the size of the array and the max value and see how it impacts runtimes
    * For the purposes of this lab, do not worry about writing unit tests

.. code-block:: java

    public static void selectionSort(int[] toSort){
        // Fill me in
    }


Comparing Sorts
===============

#. Run each of the sorts a few times and take note of the runtimes.

    * Play around with the size of the arrays and the max value
    * Do the times align with what you'd expect based on the computational complexities of each of the algorithms

#. Try throwing a counter variable into the inner loops of each of the sorts to see how many times the loops ran.

    * Calculate what the counts should be for each sort, in the worst and best cases, based on the size of the arrays you used
    * :doc:`Refer to the computational complexity analysis provided on these sorting algorithms </topics/sorting/sorting-basic>`

#. Can you rationalize the differences in runtimes?


Kattis Problems
===============

Recommended Kattis Problems (don't worry, you don’t need to do all of them or anything):

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
