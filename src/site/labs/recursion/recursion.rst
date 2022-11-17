*********
Recursion
*********

* Feel free to use your laptop if you have it
* I strongly encourage you to work with others in the lab

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


Factorial
=========

`Factorial? <https://letmegooglethat.com/?q=factorial>`_

#. Write an **iterative** method to return the factorial of ``n``.

    * This method will take ``n`` as a parameter
    * The method will return the factorial


#. Write a **recursive** method to return the factorial of ``n``.

    * This method will take ``n`` as a parameter
    * This recursive method must start at ``n`` and work *down* to ``1``
    * The method will return the factorial


#. Write a **recursive** method to return the factorial of ``n``.

    * This method will take ``n`` and ``cur`` as a parameter
    * This recursive method must start at ``cur`` (which will start at ``1``) and work *up* to ``n``
    * The method will return the factorial


Sum
===

#. Write an **iterative** method to sum the numbers between ``1`` and ``n`` inclusively.

    * The method will take a single integer ``n`` as a parameter
    * The method will return the sum


#. Write a **recursive** method to sum the numbers between ``1`` and ``n`` inclusively.

    * The method will take a single integer ``n`` as a parameter
    * The method will return the sum


#. Write a **recursive** method to sum the numbers between ``cur`` and ``n`` inclusively.

    * The method will take two parameters ``cur`` and ``n``
    * The method will return the sum


Linear Search on Arrays
=======================

#. Write a **recursive** method to do a linear search.

    * This method will take an array of integers ``toSearch``, an integer ``target`` as parameters, and the current index ``cur``
    * This method will return ``true``/``false``
    * It is strongly recommended to work with others
    * Scrap paper is your friend


Building a Linked Structure
===========================

#. Write a **recursive** method to build a linked structure containing the numbers ``0`` -- ``(n-1)``.

    * This method will take an integer ``n``
    * This method will return a reference to the head of the linked structure
    * The first node must contain ``0``, not ``5``
    * You will need a ``Node`` class
    * It is strongly recommended to work with others
    * Scrap paper is your friend


Linear Search on Linked Structure
=================================

#. Write a **recursive** method that performs a linear search on a linked structure.

    * The method will take a reference to the current ``Node`` called ``cur`` and the ``target``
    * This method will return ``true``/``false``
    * It is strongly recommended to work with others
    * Scrap paper is your friend


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