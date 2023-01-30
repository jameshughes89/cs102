*****************
Linked Structures
*****************

* Feel free to use your laptop
* You are strongly encourage to work with others

    * When you get stuck, ask those sitting around you for help
    * Get used to working together in the labs
    * Peer teaching and peer learning has been empirically shown to be very effective



Linked Structure
================

The goal is to create a linked structure with a series of ``Node`` objects.


Node Class
----------

#. Create a generic ``Node`` class
#. Download and run the :download:`NodeTest </../test/java/NodeTest.java>` class to ensure the ``Node`` class is implemented correctly

    * This test class must be added to the project's test folder



Create the Linked Structure
---------------------------

#. Write a static method in the same class as the ``main`` called ``makeLinkedStructure`` that will

    * Create a linked structure containing the numbers 0 -- 9

        * One number referenced in each node


    * Return a reference to the head of the linked structure

    .. code-block:: java

        public static Node<Integer> makeLinkedStructure() {
            // ...
        }


#. Verify it works as expected by adding this to the ``main`` method and running it

    .. code-block:: java

        Node<Integer> head = makeLinkedStructure();
        Node<Integer> currentNode = head;

        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }



Manipulating the Linked Structure
=================================

Start manipulating the linked structure by adding and removing elements.


Adding to the Front of the Structure
------------------------------------

#. Write a static method in the same class as the ``main`` called ``addToFront`` that will

    * Take a reference to the head of a linked structure and an integer to add
    * Create a new ``Node`` containing a reference to the integer passed to the method as an argument
    * Insert the newly created ``Node`` to the front of the linked structure
    * Return a reference to the new head of the linked structure

    .. code-block:: java

        public static <T> Node<T> addToFront(Node<T> head, T toAdd) {
            // ...
        }


#. Verify it works as expected by adding this to the ``main`` method and running it

    .. code-block:: java

        head = addToFront(head, 99);
        currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }



Removing from the Front of the Structure
----------------------------------------

#. Write a static method in the same class as the ``main`` called ``removeFromFront`` that will

    * Take a reference to the head of a linked structure
    * Remove the first ``Node`` from the structure
    * Return a reference to the new head of the linked structure

    .. code-block:: java

        public static <T> Node<T> removeFromFront(Node<T> head) {
            // ...
        }


#. Verify it works as expected by adding this to the ``main`` method and running it

    .. code-block:: java

        head = removeFromFront(head) ;
        currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }



Adding to the Middle of the Structure
-------------------------------------

#. Write a static method in the same class as the ``main`` called ``addToMiddle`` that will

    * Take a reference to the head of a linked structure, an integer to add, and a number the new integer should be added after
    * Create a new ``Node`` containing a reference to the integer passed to the method as an argument
    * Insert the new ``Node`` *after* the ``Node`` containing the specified integer to be added after
    * Return a reference to the head of the linked structure
    * For example, calling ``addToMiddle(head, 99, 5)``, will add a ``Node`` containing a reference to ``99`` after the node containing a reference to the number ``5``

    .. code-block:: java

        public static <T> Node<T> addToMiddle(Node<T> head, T toAdd, T addAfter) {
            // ...
        }


#. Verify it works as expected by adding this to the ``main`` method and running it

    .. code-block:: java

        head = addToMiddle(head, 99, 5);
        currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }


.. note::

    What should happen if the specified value for ``addAfter`` is not contained in the linked structure?


Removing from the Middle of the Structure
-----------------------------------------

#. Write a static method in the same class as your ``main`` called ``removeFromMiddle`` that will

    * Take a reference to the head of a linked structure and a value to be removed from the linked structure
    * Remove the ``Node`` containing a reference to the specified value to be removed from the structure
    * Return a reference to the head of the linked structure

    .. code-block:: java

        public static <T> Node<T> removeFromMiddle(Node<T> head, T toRemove) {
            // ...
        }


#. Verify it works as expected by adding this to the ``main`` method and running it

    .. code-block:: java

        head = removeFromMiddle(head, 99) ;
        currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }


.. note::

    What should happen if the specified value for ``toRemove`` is not contained in the linked structure?




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