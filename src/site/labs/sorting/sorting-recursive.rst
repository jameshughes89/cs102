*******************
Sorting Recursively
*******************

* Refer to the topic pages for this lab
    * You will find many of the answers to your questions there
* Feel free to use your laptop if you have it
* I strongly encourage you to work with others in the lab
* Ensure I have recorded your completion. Failure to do so will result in a grade of 0
* When you get stuck, do me a favour and ask those sitting around you for help
    * I want people to get used to working together in the labs
    * Peer teaching and peer learning is super effective


Starting Point
==============

This lab focuses on the sorts discussed in :doc:`topic 26 </topics/sorting/sorting-recursive>`. Note that, unlike the previous lab, here we use
an unsorted bag instead of an array.

.. code-block:: java

    public static void main(String[] args){

        IndexedBag<Integer> toSort = createUnsortedIntBag(10000, 10);
        System.out.println(toSort);

        double startTime = System.nanoTime();
        //quicksort(toSort);
        mergesort(toSort);
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

1. Implement the quicksort algorithm
2. Make sure it works and test it a few times and see what the runtimes are
    * Change the size of the bag and the max value and see how it impacts runtimes
    * For the purposes of this lab, do not worry about writing unit tests

.. code-block:: java

    public static <T extends Comparable<T>> void quicksort(IndexedBag<T> toSort){
        // Fill me in
    }


Mergesort
=========

1. Implement the mergesort algorithm
2. Make sure it works and test it a few times and see what the runtimes are
    * Change the size of the bag and the max value and see how it impacts runtimes
    * For the purposes of this lab, do not worry about writing unit tests

.. code-block:: java

    public static <T extends Comparable<T>> void mergesort(IndexedBag<T> toSort){
        // Fill me in
    }


Comparing Sorts
===============

1. Run each of the sorts a few times and take note of the runtimes
    * Play around with the size of the lists and the max value
    * Do the times align with what you'd expect based on the computational complexities of each of the algorithms

2. Compare these runtimes to the sorts completed in the previous lab.


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
