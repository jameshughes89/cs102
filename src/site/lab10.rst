*******
Lab #10
*******

* Refer to the topic pages for this lab
    * You will find many of the answers to your questions there
* Feel free to use your laptop if you have it
* I strongly encourage you to work with others in the lab
* Ensure I have recorded your completion. Failure to do so will result in a grade of 0
* When you get stuck, do me a favour and ask those sitting around you for help
    * I want people to get used to working together in the labs
    * Peer teaching and peer learning is super effective

.. Note::

    We have not gone over this topic in lecture, but this should not be a problem


Heaps
=====

Have you ever wanted to store a binary tree in an array?

.. image:: img/heap_example.png
   :width: 333 px
   :align: center
   :target: https://en.wikipedia.org/wiki/Heap_(data_structure)

* The root of the tree is always at index :math:`0`
* Given an element at index :math:`i`
    * Its left child can be found at :math:`2i + 1`
    * Its right child can be found at :math:`2i + 2`
    * Assuming it's not the root, it's parent can be found at :math:`\lfloor (i-1)/2 \rfloor`
        * :math:`\lfloor x \rfloor` just means to round down if needed

* For example, consider the element 17 located at index :math:`3` in the array
    * Left child would be at :math:`3*2 + 1 = 7`
    * Right child would be at :math:`3*2 + 2 = 8`
    * Parent would be at :math:`\lfloor (3-1)/2 \rfloor = 1`


Min Heap
========


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
