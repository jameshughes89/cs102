******
Stacks
******

* Feel free to use your laptop
* You are strongly encourage to work with others

    * When you get stuck, ask those sitting around you for help
    * Get used to working together in the labs
    * Peer teaching and peer learning has been empirically shown to be very effective


Playing with Stacks
===================

The goal is to implement an ``ArrayStack`` based on the the details discussed in the
:doc:`Stack Interface Topic </topics/stacks/array-stack>` and the :doc:`ArrayStack Topic </topics/stacks/array-stack>`.


Implementing an ``ArrayStack``
------------------------------

#. Download the :download:`Stack interface <../../../main/java/Stack.java>` and add it to the ``src`` folder
#. Create an ``ArrayStack`` class for the implementation
#. Complete the ``ArrayStack`` class based on the :doc:`ArrayStack Topic's description </topics/stacks/array-stack>`

    .. note::

        Obviously one can simply download the :download:`ArrayStack <../../../main/java/ArrayStack.java>` code and
        copy/paste it into the ``ArrayStack`` class, but this defeats the purpose of the lab. Instead, slowly and
        deliberately implement each method and take the time to understand the details.


#. Add the :download:`ArrayStackTest </../test/java/ArrayStackTest.java>` unit tests to the project in a ``test`` folder

    * :doc:`Refer to the relevant topic on unit testing </topics/testing/unit-tests>`
    * :doc:`Refer to the relevant topic on unit testing collections </topics/testing/unit-test-collections>`


#. Run the ``ArrayStackTest`` unit tests and ensure all tests pass



Reversing a String
------------------

#. Write a function called ``reverseString`` that takes a string and returns the reverse of the original

    * This function must use a stack for the reversing of the string
    * Below is a skeletal method and some simple testing code

    .. code-block:: java

        public static void main(String[] args) {
            String alphabet = "abcdefghijklmnopqrstuvwxyz";
            String tebahpla = reverseString(alphabet);

            System.out.println(alphabet);
            System.out.println(tebahpla);
        }

        public static String reverseString(String originalString) {
            Stack<Character> characterStack = new ArrayStack<>();
            StringBuilder stringBuilder = new StringBuilder();

            // Add Code Here

            return stringBuilder.toString();
        }



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