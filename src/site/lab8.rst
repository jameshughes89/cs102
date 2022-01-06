******
Lab #8
******

* Refer to the topic pages for this lab
    * You will find many of the answers to your questions there
* Feel free to use your laptop if you have it
* I strongly encourage you to work with others in the lab
* Ensure I have recorded your completion. Failure to do so will result in a grade of 0
* When you get stuck, do me a favour and ask those sitting around you for help
    * I want people to get used to working together in the labs
    * Peer teaching and peer learning is super effective


Recursion Visualization
=======================

* Check out the following websites that help you visualize recursion:
    * https://visualgo.net/en/recursion?slide=1
    * https://cscircles.cemc.uwaterloo.ca/java_visualize/

* Try running the following in the visualizer

    .. code-block:: java
        :linenos:

        public class Recursion {
            public static int sum(int n) {
                if (n == 1) {
                    return 1;
                }
                return n + sum(n - 1);
            }

            public static void main(String[] args) {
                sum(5);
            }
        }


Sum
===

1. Write an **iterative** method to sum the numbers between ``1`` and ``n`` inclusively
    * The method will take a single integer ``n`` as a parameter
    * The method will return the sum

2. Write a **recursive** method to sum the numbers between ``1`` and ``n`` inclusively
    * The method will take a single integer ``n`` as a parameter
    * The method will return the sum

3. Write a **recursive** method to sum the numbers between ``cur`` and ``n`` inclusively
    * The method will take two parameters ``cur`` and ``n``
    * The method will return the sum


Factorial
=========

`Factorial? <https://letmegooglethat.com/?q=factorial>`_

1. Write an **iterative** method to return the factorial of ``n``
    * This method will take ``n`` as a parameter
    * The method will return the factorial

2. Write a **recursive** method to return the factorial of ``n``
    * This method will take ``n`` as a parameter
    * This recursive method must start at ``n`` and work *down* to 1
    * The method will return the factorial

3. Write a **recursive** method to return the factorial of ``n``
    * This method will take ``n`` and ``cur`` as a parameter
    * This recursive method must start at ``cur`` (which will start at ``1``) and work *up* to ``n``
    * The method will return the factorial


Linear Search on Arrays
=======================

1. Write a **recursive** method to do a linear search
    * This method will take an array of integers ``toSearch``, an integer ``target`` as parameters, and the current index ``cur``
    * This method will return ``true``/``false``
    * It is strongly recommended to work with others
    * Scrap paper is your friend


Building a Linked Structure
===========================

1. Write a **recursive** method to build a linked structure containing the numbers ``0`` -- ``(n-1)``
    * This method will take an integer ``n``
    * This method will return a reference to the head of the linked structure
    * The first node must contain ``0``, not ``5``
    * You will need a ``Node`` class
    * It is strongly recommended to work with others
    * Scrap paper is your friend


Linear Search on Linked Structure
=================================

1. Write a **recursive** method that performs a linear search on a linked structure
    * The method will take a reference to the current ``Node`` called ``cur`` and the ``target``
    * This method will return ``true``/``false``
    * It is strongly recommended to work with others
    * Scrap paper is your friend


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
