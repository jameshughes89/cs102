*******************
Sorting Recursively
*******************

* Feel free to use your laptop
* You are strongly encourage to work with others

    * When you get stuck, ask those sitting around you for help
    * Get used to working together in the labs
    * Peer teaching and peer learning has been empirically shown to be very effective


Starting Point
==============

* This lab focuses on the sorting algorithms discussed in the :doc:`Sorting Recursively Topic </topics/sorting/sorting-recursive>`
* Unlike the previous lab, an ``IndexedBag`` is used

* The below code can be used for setting up an array to be sorted
* This code can also be used for timing the different sorting algorithms


.. code-block:: java

    public static void main(String[] args){

        IndexedBag<Integer> toSort = createUnsortedIntBag(10000, 10);
        System.out.println(toSort);

        double startTime = System.nanoTime();
        //quicksort(toSort);
        //mergesort(toSort);
        double endTime = System.nanoTime();

        System.out.println(toSort);
        System.out.println("runtime: " + (endTime - startTime)/1000000 + " ms");
    }

    public static IndexedBag createUnsortedIntBag(int n, int maxValue){
        IndexedBag<Integer>  toSort= new ArrayIndexedBag<>(n);
        for(int i = 0; i < n; ++i){
            toSort.add((int)(Math.random() * maxValue));
        }
        return toSort;
    }


Quicksort
=========

#. Implement the quicksort algorithm
#. Make sure it works and run it a few times to see what the runtimes are

    * Change the size of the array and the max value and see how it impacts runtimes
    * For the purposes of this lab, do not worry about writing unit tests

.. code-block:: java

    public static <T extends Comparable<T>> void quicksort(IndexedBag<T> toSort){
        // Fill me in
    }


Mergesort
=========

#. Implement the mergesort algorithm
#. Make sure it works and run it a few times to see what the runtimes are

    * Change the size of the array and the max value and see how it impacts runtimes
    * For the purposes of this lab, do not worry about writing unit tests

.. code-block:: java

    public static <T extends Comparable<T>> void mergesort(IndexedBag<T> toSort){
        // Fill me in
    }


Comparing Sorts
===============

#. Run each of the sorts a few times and take note of the runtimes

    * Play around with the size of the lists and the max value
    * Compare the runtimes of each algorithm to what was expected based on their computational complexities


#. Compare these runtimes to the sorting algorithms implemented in the previous lab


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