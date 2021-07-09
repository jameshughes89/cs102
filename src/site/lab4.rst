******
Lab #4
******

* Refer to the slides for this lab. You will find many of the answers to your questions there
* Feel free to use your laptop if you have it
* I strongly encourage you to work with others in the lab
* Ensure I have recorded your completion. Failure to do so will result in a grade of 0
* When you get stuck, do me a favour and ask those sitting around you for help
    * I want people to get used to working together in the labs
    * Peer teaching and peer learning is super effective


Playing with Stacks
===================

We're going to implement an ``ArrayStack`` based on what we learned in class and use it to solve a simple problem.


Implementing a Stack
--------------------

1. Create a project and make a class where you will put your main method
    * Perhaps call it ``Lab4``

2. Download the :download:`Stack interface.<../main/java/Stack.java>` and add it to your project

3. Create a new class for our ``ArrayStack`` implementation

4. :doc:`Complete your ArrayStack based on the course notes </topic6>`

.. warning::

    I realize you can simply download the :download:`ArrayStack <../main/java/ArrayStack.java>` code and copy/paste, but
    this defeats the purpose. I want you to slowly and deliberately implement each function and take the time to
    understand the details.

5. Test your ``ArrayStack`` with the following

    .. code-block:: java
        :linenos:

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


6. Now create an instance of a stack for characters and rewrite the test code above to test its functionality


Reversing a String
------------------

1. Write a method that takes a string and returns a new string that is the reverse of the original
    * This function **must** use a stack for the reversing of the string
        * **Hint:** Remember what LIFO order is
    * I have provided you with a skeleton of the method and some simple testing code below


    .. code-block:: java
        :linenos:

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

1. https://open.kattis.com/problems/quadrant
2. https://open.kattis.com/problems/judgingmoose
3. https://open.kattis.com/problems/timeloop
4. https://open.kattis.com/problems/oddities
5. https://open.kattis.com/problems/fizzbuzz
6. https://open.kattis.com/problems/twostones
7.  https://open.kattis.com/problems/spavanac
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