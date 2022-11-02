*******
Sorting
*******

* Refer to the topic pages for this lab
    * You will find many of the answers to your questions there
* Feel free to use your laptop if you have it
* I strongly encourage you to work with others in the lab
* Ensure I have recorded your completion. Failure to do so will result in a grade of 0
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

This lab focuses on the sorts discussed in :doc:`topic 25 </topic25>`.

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

1. Implement the bubble sort algorithm
2. Make sure it works and test it a few times and see what the runtimes are
    * Change the size of the array and the max value and see how it impacts runtimes
    * For the purposes of this lab, do not worry about writing unit tests

.. code-block:: java

    public static void bubbleSort(int[] toSort){
        // Fill me in
    }


Insertion Sort
==============

1. Implement the insertion sort algorithm
2. Make sure it works and test it a few times and see what the runtimes are
    * Change the size of the array and the max value and see how it impacts runtimes
    * For the purposes of this lab, do not worry about writing unit tests

.. code-block:: java

    public static void insertionSort(int[] toSort){
        // Fill me in
    }


Selection Sort
==============

1. Implement the selection sort algorithm
2. Make sure it works and test it a few times and see what the runtimes are
    * Change the size of the array and the max value and see how it impacts runtimes
    * For the purposes of this lab, do not worry about writing unit tests

.. code-block:: java

    public static void selectionSort(int[] toSort){
        // Fill me in
    }


Comparing Sorts
===============

1. Run each of the sorts a few times and take note of the runtimes
    * Play around with the size of the arrays and the max value
    * Do the times align with what you'd expect based on the computational complexities of each of the algorithms

2. Try throwing a counter variable into the inner loops of each of the sorts to see how many times the loops ran
    * Calculate what the counts should be for each sort, in the worst and best cases, based on the size of the arrays you used
    * :doc:`Refer to the computational complexity analysis provided on these sorting algorithms </topic25>`

3. Can you rationalize the differences in runtimes?


Kattis Problems
===============

Recommended Kattis Problems (don't worry, you don’t need to do all of them or anything):

1. https://open.kattis.com/problems/quadrant
2. https://open.kattis.com/problems/judgingmoose
3. https://open.kattis.com/problems/timeloop
4. https://open.kattis.com/problems/oddities
5. https://open.kattis.com/problems/fizzbuzz
6. https://open.kattis.com/problems/twostones
7. https://open.kattis.com/problems/spavanac
8. https://open.kattis.com/problems/cetvrta
9. https://open.kattis.com/problems/bus
10. https://open.kattis.com/problems/timeloop
11. https://open.kattis.com/problems/oddities
12. https://open.kattis.com/problems/fizzbuzz
13. https://open.kattis.com/problems/sibice
14. https://open.kattis.com/problems/datum
15. https://open.kattis.com/problems/dicecup
16. https://open.kattis.com/problems/autori
17. https://open.kattis.com/problems/apaxiaaans
18. https://open.kattis.com/problems/hissingmicrophone
19. https://open.kattis.com/problems/trik
20. https://open.kattis.com/problems/pot
21. https://open.kattis.com/problems/filip
22. https://open.kattis.com/problems/reversebinary
23. https://open.kattis.com/problems/sevenwonders
24. https://open.kattis.com/problems/zamka
25. https://open.kattis.com/problems/bijele
26. https://open.kattis.com/problems/cold
27. https://open.kattis.com/problems/nastyhacks
28. https://open.kattis.com/problems/grassseed
29. https://open.kattis.com/problems/pet
30. https://open.kattis.com/problems/batterup
31. https://open.kattis.com/problems/aboveaverage
32. https://open.kattis.com/problems/icpcawards
33. https://open.kattis.com/problems/quickbrownfox
34. https://open.kattis.com/problems/nodup
35. https://open.kattis.com/problems/conundrum
36. https://open.kattis.com/problems/bela
37. https://open.kattis.com/problems/kornislav
