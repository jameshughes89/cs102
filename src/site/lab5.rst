******
Lab #5
******

* Refer to the topic pages for this lab
    * You will find many of the answers to your questions there
* Feel free to use your laptop if you have it
* I strongly encourage you to work with others in the lab
* Ensure I have recorded your completion. Failure to do so will result in a grade of 0
* When you get stuck, do me a favour and ask those sitting around you for help
    * I want people to get used to working together in the labs
    * Peer teaching and peer learning is super effective


Making a Linked Structure
==========================

Start by building a linked structure. The idea is to simply have a series of ``Node`` objects.


Node Class
----------

1. Create a project and make a class where you will put your main method
    * Perhaps call it ``Lab5``

2. Create a generic ``Node`` class
    * Feel free to :download:`download this one <../main/java/Node.java>`
        * If you do though, be sure to understand it and don't just copy/paste

3. Do a simple test to see if it works by making an instance in your main method and using the node's methods

    .. code-block:: java
        :linenos:

        Node<Integer> myNode = new Node<>(5);
        // Use the node class' methods here


Create the Linked Structure
---------------------------

1. Write a static method in the same class as your ``main`` called ``makeLinkedStructure`` that will
    a. Create a linked structure containing the numbers 0 -- 9
        * One number referenced in each node
    b. Return a reference to the head of the linked structure

    .. code-block:: java
        :linenos:

        public static <T> Node<T> makeLinkedStructure() {
            // Stuff
        }


2. Verify it works by adding this to your ``main`` method

    .. code-block:: java
        :linenos:

        Node<Integer> head = makeLinkedStructure();
        Node<Integer> currentNode = head;

        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }


Manipulating the Linked Structure
=================================

Start adding and removing things to the linked structure.


Adding to the Front of the Structure
------------------------------------

1. Write a static method in the same class as your ``main`` called ``addToFront`` that will
    a. Take a reference to the head of a linked structure and an integer to add
    b. Insert a new node containing reference to a new integer passed to the method as a parameter
    c. Return a reference to the new head of the linked structure

    .. code-block:: java
        :linenos:

        public static <T> Node<T> addToFront(Node<T> head, T toAdd) {
            // Stuff
        }


2. Verify it works by adding this to your ``main`` method

    .. code-block:: java
        :linenos:

        head = addToFront(head, 99);
        currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }


Removing from the Front of the Structure
----------------------------------------

1. Write a static method in the same class as your ``main`` called ``removeFromFront`` that will
    a. Take a reference to the head of a linked structure
    b. Remove the first node from the structure
    c. Return a reference to the new head of the linked structure

    .. code-block:: java
        :linenos:

        public static <T> Node<T> removeFromFront(Node<T> head) {
            // Stuff
        }


2. Verify it works by adding this to your ``main`` method

    .. code-block:: java
        :linenos:

        head = removeFromFront(head) ;
        currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }


Adding to the Middle of the Structure
------------------------------------

1. Write a static method in the same class as your ``main`` called ``addToMiddle`` that will
    a. Take a reference to the head of a linked structure, an integer to add, and a number we want to insert our new number after
        * For example, if we call ``addToMiddle(head, 99, 5)``, we will add a node containing a reference to ``99`` after the node containing a reference to the number ``5`` (if it exists)
    b. Insert a new node containing reference to a new integer passed to the method as a parameter after the specified value
    c. Return a reference to the head of the linked structure

    .. code-block:: java
        :linenos:

        public static <T> Node<T> addToMiddle(Node<T> head, Integer toAdd, T addAfter) {
            // Stuff
        }


2. Verify it works by adding this to your ``main`` method

    .. code-block:: java
        :linenos:

        head = addToMiddle(head, 99, 5);
        currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }

.. warning::

    What do you think should happen if we specify a value for ``addAfter`` that is not contained in the linked
    structure?


Removing from the Middle of the Structure
-----------------------------------------

1. Write a static method in the same class as your ``main`` called ``removeFromMiddle`` that will
    a. Take a reference to the head of a linked structure and a value we want to remove from our linked structure
    b. Remove the node containing a reference to the specified value from the structure
    c. Return a reference to the head of the linked structure

    .. code-block:: java
        :linenos:

        public static <T> Node<T> removeFromMiddle(Node<T> head, T toRemove) {
            // Stuff
        }


2. Verify it works by adding this to your ``main`` method

    .. code-block:: java
        :linenos:

        head = removeFromMiddle(head, 99) ;
        currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }


.. warning::

    What do you think should happen if we specify a value for ``toRemove`` that is not contained within the linked
    structure?


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