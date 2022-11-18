*****************
Linked Structures
*****************

* Feel free to use your laptop if you have it
* I strongly encourage you to work with others in the lab

    * When you get stuck, do me a favour and ask those sitting around you for help
    * I want people to get used to working together in the labs
    * Peer teaching and peer learning is super effective


Making a Linked Structure
=========================

Start by building a linked structure. The idea is to simply have a series of ``Node`` objects.


Node Class
----------

#. Create a project and make a class where you will put your main method.

#. Create a generic ``Node`` class. If you download the one from the course website, be sure to understand it.

#. Do a simple test to see if it works by making an instance in your main method and using the node's methods.

    .. code-block:: java

        Node<Integer> myNode = new Node<>(5);
        // Use the node class' methods here


Create the Linked Structure
---------------------------

#. Write a static method in the same class as your ``main`` called ``makeLinkedStructure`` that will

    a. Create a linked structure containing the numbers 0 -- 9.

        * One number referenced in each node

    b. Return a reference to the head of the linked structure.

    .. code-block:: java

        public static Node<Integer> makeLinkedStructure() {
            // Stuff
        }


#. Verify it works by adding this to your ``main`` method.

    .. code-block:: java

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

#. Write a static method in the same class as your ``main`` called ``addToFront`` that will

    a. Take a reference to the head of a linked structure and an integer to add.
    b. Insert a new node containing reference to a new integer passed to the method as a parameter.
    c. Return a reference to the new head of the linked structure.

    .. code-block:: java

        public static <T> Node<T> addToFront(Node<T> head, T toAdd) {
            // Stuff
        }


#. Verify it works by adding this to your ``main`` method.

    .. code-block:: java

        head = addToFront(head, 99);
        currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }


Removing from the Front of the Structure
----------------------------------------

#. Write a static method in the same class as your ``main`` called ``removeFromFront`` that will

    a. Take a reference to the head of a linked structure.
    b. Remove the first node from the structure.
    c. Return a reference to the new head of the linked structure.

    .. code-block:: java

        public static <T> Node<T> removeFromFront(Node<T> head) {
            // Stuff
        }


#. Verify it works by adding this to your ``main`` method.

    .. code-block:: java

        head = removeFromFront(head) ;
        currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }


Adding to the Middle of the Structure
-------------------------------------

#. Write a static method in the same class as your ``main`` called ``addToMiddle`` that will

    a. Take a reference to the head of a linked structure, an integer to add, and a number we want to insert our new number after.

        * For example, if we call ``addToMiddle(head, 99, 5)``, we will add a node containing a reference to ``99`` after the node containing a reference to the number ``5`` (if it exists)

    b. Insert a new node containing reference to a new integer passed to the method as a parameter after the specified value.
    c. Return a reference to the head of the linked structure.

    .. code-block:: java

        public static <T> Node<T> addToMiddle(Node<T> head, T toAdd, T addAfter) {
            // Stuff
        }


#. Verify it works by adding this to your ``main`` method.

    .. code-block:: java

        head = addToMiddle(head, 99, 5);
        currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }

.. note::

    What do you think should happen if we specify a value for ``addAfter`` that is not contained in the linked
    structure?


Removing from the Middle of the Structure
-----------------------------------------

#. Write a static method in the same class as your ``main`` called ``removeFromMiddle`` that will
    a. Take a reference to the head of a linked structure and a value we want to remove from our linked structure.
    b. Remove the node containing a reference to the specified value from the structure.
    c. Return a reference to the head of the linked structure.

    .. code-block:: java

        public static <T> Node<T> removeFromMiddle(Node<T> head, T toRemove) {
            // Stuff
        }


#. Verify it works by adding this to your ``main`` method

    .. code-block:: java

        head = removeFromMiddle(head, 99) ;
        currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }


.. note::

    What do you think should happen if we specify a value for ``toRemove`` that is not contained within the linked
    structure?


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