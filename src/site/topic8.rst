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


For next time
=============

* Read Chapter 4 Section 6
    * 13 pages
