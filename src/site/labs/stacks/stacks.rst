******
Stacks
******

* Feel free to use your laptop if you have it
* I strongly encourage you to work with others in the lab

    * When you get stuck, do me a favour and ask those sitting around you for help
    * I want people to get used to working together in the labs
    * Peer teaching and peer learning is super effective


Playing with Stacks
===================

We're going to implement an ``ArrayStack`` based on what we learned in class and use it to solve a simple problem.


Implementing a Stack
--------------------

#. Create a project and make a class where you will put your main method.

#. Download the :download:`Stack interface <../../../main/java/Stack.java>` and add it to your project.

#. Create a new class for our ``ArrayStack`` implementation.

#. :doc:`Complete your ArrayStack based on the course notes. </topics/stacks/array-stack>`

    .. note::

        I realize you can simply download the :download:`ArrayStack <../../../main/java/ArrayStack.java>` code and
        copy/paste, but this defeats the purpose. I want you to slowly and deliberately implement each function and take
        the time to understand the details.


#. Test your ``ArrayStack`` with the following.

    .. code-block:: java

            public static void main(String[] args) {
                Stack<Integer> myStack = new ArrayStack<>();

                System.out.println(myStack);

                for (int i = 0; i < 10; ++i) {
                    myStack.push(i);
                }

                System.out.println(myStack);

                while (!myStack.isEmpty()) {
                    System.out.println(myStack.pop());
                }
                System.out.println(myStack);
            }


#. Now create an instance of a stack for characters and rewrite the test code above to test its functionality.


Reversing a String
------------------

#. Write a method that takes a string and returns a new string that is the reverse of the original.

    * This function **must** use a stack for the reversing of the string
    * I have provided you with a skeletal method and some simple testing code below


    .. code-block:: java

        public static void main(String[] args) {
            String alphabet = "abcdefghijklmnopqrstuvwxyz";
            String tebahpla = reverseString(alphabet);

            System.out.println(alphabet);
            System.out.println(tebahpla);
        }

        public static String reverseString(String originalString) {
            Stack<Character> characterStack = new ArrayStack<>();
            String newString = "";

            // Add Code Here

            return newString;
        }


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