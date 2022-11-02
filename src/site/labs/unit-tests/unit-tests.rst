**********
Unit Tests
**********

* Refer to the topic pages for this lab
    * You will find many of the answers to your questions there
* Feel free to use your laptop if you have it
* I strongly encourage you to work with others in the lab
* Ensure I have recorded your completion. Failure to do so will result in a grade of 0
* When you get stuck, do me a favour and ask those sitting around you for help
    * I want people to get used to working together in the labs
    * Peer teaching and peer learning is super effective


Unit Testing
============

We're going to write tests for our ``CourseList`` class from :doc:`Lab2 </lab2>`. :doc:`Topic 6's aside on testing will be of great help here </topic6-testing>`.


Have a Working Implementation
-----------------------------

1. If you have not already, finish :doc:`Lab2 </lab2>`


Writing Tests
-------------

**Tips**

* Make your test method names as descriptive as possible while still being brief
* Follow some convention for your method names, something like ``methodConditionExpected()``
    * ``sizeOfEmptyCourseListReturnsZero()``
    * ``addingBeyondCapacityCallsExpandCapacityToMakeRoomForAdd()``


1. Create your testing class for ``CourseList`` called ``CourseListTest``

2. Write unit tests to test the ``size()`` method
    * empty list has size zero?
    * non empty list has proper size?
    * list that has been emptied via removes has size zero?

3. Write tests for ``add``
    * Is the added element added?
    * Can we add beyond a capacity limit?

4. Write tests for ``remove``
    * Does the element get removed?
    * What happens if we try to remove something that doesn't exist?
    * What happens when we call remove once for something that exists more than once in the ``CourseList``?

5. Write tests for ``get``
    * Does it return the element from the correct index?
    * What happens if you try to get something from beyond the range?
    * What happens if you try to get something from a negative index?


6. Write tests for ``indexOf``
    * Try to figure out which tests you should have on your own/with a friend

7. Write tests for the ``Course`` class
    * Try to figure out which tests you should have on your own/with a friend


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