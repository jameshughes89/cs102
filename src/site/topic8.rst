************************
Topic #8 --- LinkedStack
************************

* We have already implemented a ``Stack`` as an ``ArrayStack``
* We have also seen how we can use a series of nodes to create a linked structure
* Let's now implement a ``Stack`` as a ``LinkedStack`` which uses a linked structure to hold onto the data

StackADT
========

* :download:`We already wrote our Stack.java<../main/java/Stack.java>` interface

* Remember, for a ``Stack`` we want
    * ``push``
    * ``pop``
    * ``peek``
    * ``size``
    * ``isEmpty``

* Also remember that these say nothing about *how* exactly these are implemented


Implementing a Stack --- Linked Container
=========================================

* We will keep track of the top of the stack with a field called ``top`` that references the head of the linked structure
    * All pushing and popping happens at the head end of the linked structure
* We will also keep track of the count

.. image:: img/linkedstack0.png
   :width: 500 px
   :align: center

.. image:: img/linkedstack1.png
   :width: 500 px
   :align: center

.. image:: img/linkedstack2.png
   :width: 500 px
   :align: center

.. image:: img/linkedstack3.png
   :width: 500 px
   :align: center


Implementation
--------------

.. code-block:: java
    :linenos:

    import java.util.EmptyStackException;

    public class LinkedStack<T> implements Stack<T> {

        private Node<T> top;
        private int size;

        public LinkedStack() {
            top = null;
            size = 0;
        }

* Like the ``ArrayStack``, we want our ``LinkedStack`` to implement the ``Stack`` interface
* The constructor starts the stack as empty with nothing on it


Push
^^^^

.. code-block:: java
    :linenos:
    :emphasize-lines: 4, 5

        @Override
        public void push(T element) {
            Node<T> toPush = new Node<T>(element);
            toPush.setNext(top);
            top = toPush;
            size++;
        }

* In ``push``, notice how this is just *adding to the front of a linked structure*


Pop & Peek
^^^^^^^^^^

.. code-block:: java
    :linenos:
    :emphasize-lines: 7

        @Override
        public T pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            T returnElement = top.getData();
            top = top.getNext();
            size--;
            return returnElement;
        }

        @Override
        public T peek() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return top.getData();
        }

* Like the ``ArrayStack``, popping or peeking from an empty stack throws an exception
* Notice how ``pop`` does a *remove/delete from the front of a linked structure*


Size and isEmpty
^^^^^^^^^^^^^^^^

.. code-block:: java
    :linenos:

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public int size() {
            return size;
        }

* The ``LinkedStack`` is empty if its ``size == 0``
    * Can you think of another way to check if it's empty?


toString
^^^^^^^^

.. code-block:: java
    :linenos:

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(", ");
            Node<T> currentNode = top;
            while (currentNode != null) {
                builder.insert(0, currentNode.getData());
                builder.insert(0, ", ");
                currentNode = currentNode.getNext();
            }
            builder.delete(0, 2);
            builder.append("<-- Top\n");
            return builder.toString();
        }

* It's a little ugly here
* We have it matching the output format that the ``ArrayStack``'s ``toString`` had


Playing
=======

* We can use the same code we used for the ``ArrayStack`` to play with the ``LinkedStack``
* We only need to make one change
    * ``ArrayStack`` -> ``LinkedStack``

.. code-block:: java
    :linenos:

    // Create an ArrayStack
    Stack<Integer> myStack = new LinkedStack<Integer>();

    // Check stack is empty
    System.out.println(myStack.size());
    System.out.println(myStack.isEmpty());
    System.out.println(myStack);

    // Test push
    myStack.push(0);
    myStack.push(1);
    myStack.push(2);
    myStack.push(3);
    myStack.push(4);
    System.out.println(myStack.size());
    System.out.println(myStack.isEmpty());
    System.out.println(myStack);

    // Test expand capacity
    myStack.push(10);
    myStack.push(11);
    myStack.push(12);
    myStack.push(13);
    myStack.push(14);
    System.out.println(myStack.size());
    System.out.println(myStack.isEmpty());
    System.out.println(myStack);

    // Test peek
    System.out.println(myStack.peek());
    System.out.println(myStack.size());
    System.out.println(myStack.isEmpty());
    System.out.println(myStack);

    // Test Pop
    System.out.println(myStack.pop());
    System.out.println(myStack.pop());
    System.out.println(myStack.pop());
    System.out.println(myStack.pop());
    System.out.println(myStack.pop());
    System.out.println(myStack.pop());
    System.out.println(myStack.pop());
    System.out.println(myStack.pop());
    System.out.println(myStack.pop());
    System.out.println(myStack.pop());
    System.out.println(myStack.size());
    System.out.println(myStack.isEmpty());
    System.out.println(myStack);

    // Test peek and pop throwing exception
    try {
        myStack.peek();
    }
    catch (EmptyStackException e) {
        System.out.println("Caught exception on peek.");
    }
    try {
        myStack.pop();
    }
    catch (EmptyStackException e) {
        System.out.println("Caught exception on pop.");
    }


For next time
=============

* Download and play with the :download:`LinkedStack <../main/java/LinkedStack.java>` code
* Download and run the :download:`LinkedStackTest <../test/java/LinkedStackTest.java>` tests
* Read Chapter 4 Section 6
    * 13 pages
