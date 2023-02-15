*********
Recursion
*********

* Feel free to use your laptop
* You are strongly encourage to work with others

    * When you get stuck, ask those sitting around you for help
    * Get used to working together in the labs
    * Peer teaching and peer learning has been empirically shown to be very effective


Recursion Visualization
=======================

#. Check out the following website to help visualize recursion:

    * https://cscircles.cemc.uwaterloo.ca/java_visualize/


#. Try running the following in the visualizer

    .. code-block:: java

        public class Recursion {
            public static void main(String[] args) {
                sum(5);
            }

            public static int sum(int n) {
                if (n == 1) {
                    return 1;
                }
                return n + sum(n - 1);
            }
        }


Factorial
=========

#. Read up on `factorial <https://en.wikipedia.org/wiki/Factorial>`_
#. Write an **iterative** method to return the factorial of ``n``

    * This method will take ``n`` as a parameter
    * The method will return the factorial


#. Write a **recursive** method to return the factorial of ``n``

    * This method will take ``n`` as a parameter
    * This recursive method must start at ``n`` and work *down* to ``1``
    * The method will return the factorial


#. Write a **recursive** method to return the factorial of ``n``

    * This method will take ``n`` and ``current`` as a parameter
    * This recursive method must start at ``current`` (which will start at ``1``) and work *up* to ``n``
    * The method will return the factorial



Linear Search on an Array
=========================

#. Write a **recursive** method to do a linear search

    * This method will take an array of integers ``haystack``, an integer ``needle``, and the current index ``current`` as parameters
    * This method will return a boolean indicating if the ``needle`` was found


Building a Linked Structure
===========================

#. Write a **recursive** method to build a linked structure containing the numbers ``0`` -- ``(n-1)``

    * This method will take an integer ``n``
    * This method will return a reference to the head of the linked structure
    * The first node must contain ``0``
    * This will require a working ``Node`` class


Linear Search on a Linked Structure
===================================

#. Write a **recursive** method that performs a linear search on a linked structure

    * The method will take a reference to the current node called ``current`` and the ``needle``
    * This method will return a boolean indicating if the ``needle`` was found


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