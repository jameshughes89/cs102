***********************
Topic #6 --- ArrayStack
***********************

* We now are familiar with *what* we want the stack ADT to do without talking about *how*
* Obviously, in order to use a stack in Java, we need to actually implement a stack

* We now need to think about implementation issues
    * How are we going to keep track of our data?
    * How will we know where the top is?
        * This will depend on the choice of how we store the data

Implementing a Stack --- Array Container
========================================

ArrayStack Implementation Issues
--------------------------------

* We've already seen that arrays are great for storing contiguous data

.. image:: img/array.png
   :width: 500 px
   :align: center

* If this is the case, how should we keep track of the top of the stack?

* What are the pros and cons of making keeping the top index 0?
    * We always know where the top is
    * Every time we ``push`` or ``pop`` we'd need to move everything in the stack

* What are the pros and cons of making the top the other end?
    * We'd need another variable to keep track of where the top is
    * We do not need to shuffle anything around

* The strategy we will use is a variable to keep track of *the next available spot* in the array
    * ``push`` at the ``top`` index and update ``top``
    * ``pop`` at the ``top - 1`` index and update ``top``
* Also, due to zero based indexing, the variable keeping track of ``top`` will always be the number of things in the stack (``size``)

.. image:: img/arraystack0.png
   :width: 500 px
   :align: center

.. image:: img/arraystack1.png
   :width: 500 px
   :align: center

.. image:: img/arraystack2.png
   :width: 500 px
   :align: center

.. image:: img/arraystack3.png
   :width: 500 px
   :align: center


Implementation
--------------

* Let's start our implementation of the ``ArrayStack``

.. code-block:: Java
    :linenos:
    :emphasize-lines: 1

    public class ArrayStack<T> implements Stack<T> {

        private static final int DEFAULT_CAPACITY = 100;
        private T[] stack;
        private int top;

    }


* We want our ``ArrayStack`` to implement the ``Stack`` interface
    * This way anyone using our implementation knows that it is a ``Stack``
        * The ``ArrayStack`` **is a** ``Stack``
        * Anything expecting a ``Stack`` will be happy getting an ``ArrayStack`` since **it is a stack**
    * Note line 1 where we specifically say ``ArrayStack<T> implements Stack<T>``

* Since our ``ArrayStack`` is generic, we don't know what type the array should be at this stage, so we make it an array of type ``T``

.. warning::

    When you start implementing an interface, you may see your IDE to tell you there is an error. This is because, since
    you are saying that you are implementing the interface, Java is expecting you to implement all abstract methods from
    the interface.

        .. image:: img/warning_implement.png
           :width: 500 px
           :align: center


Constructors
^^^^^^^^^^^^

* Like the ``ContactList`` example, we will make two constructors
    * One will use the default value
    * The other will allow us ot provide a starting size of the array


.. code-block:: Java
    :linenos:
    :emphasize-lines: 2, 9

        public ArrayStack() {
            this(DEFAULT_CAPACITY);
        }

        public ArrayStack(int size) {
            top = 0;
            // Generic types cannot be instantiated so we cast
            // This does generate a compile time warning
            stack = (T[]) new Object[size];
        }

* You will see what we are doing overloading and  :doc:`constructor chaining </topic3-chaining>`
* You will also see that we are creating an array of type ``Object`` and then *casting* it to the generic type `T`
    * We cannot actually instantiate (create) a generic type
        * Asterisk
    * Java also forbids creating a generic array
        * `Details are outside the scope of this topic and likely class <https://dzone.com/articles/covariance-and-contravariance>`_

* When doing this, Java will warn us that there is now an unchecked type conversion
    * Java can't guarantee that the cast will work right

* We can actually suppress the warning by adding the following before the constructor
    * ``@SuppressWarnings("unchecked")``


* Creating an instance ``Stack<Integer> s = new ArrayStack<>(5);``

        .. image:: img/arraystack_empty.png
           :width: 500 px
           :align: center
           


Push
^^^^

.. code-block:: Java
    :linenos:
    :emphasize-lines: 2, 3, 13

        public void push(T element) {
            if (top == stack.length) {
                expandCapacity();
            }
            stack[top] = element;
            top++;
        }

        /**
         * Doubles the size of the stack array and copy the
         * contents over.
         */
        private void expandCapacity() {
            T[] newStack = (T[]) new Object[stack.length * 2];
            for (int i = 0; i < stack.length; ++i) {
                newStack[i] = stack[i];
            }
            stack = newStack;
        }

* Like the ``ContactList`` example, we will need to watch the size of our array


Pop and Peek
^^^^^^^^^^^^

* ``pop`` and ``peek`` will be similar, except peek leaves the top alone

.. code-block:: Java
    :linenos:
    :emphasize-lines: 2, 3, 4, 12, 13, 14

        public T pop() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            top--;
            T returnElement = stack[top];
            stack[top] = null;
            return returnElement;
        }

        public T peek() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            return stack[top - 1];
        }




**Exceptional Situations**

* What should we do when someone tries to ``pop`` or ``peek`` from an empty stack?
    * Ignore and do nothing?
    * Crash the program?
    * ...

* Hard to say
* What should be done is not up to us as the people implementing the stack

* As a rule, you should follow `the principal of least surprise<https://en.wikipedia.org/wiki/Principle_of_least_astonishment>`_
* Should we expect to get nothing back when requesting the top?
* Perhaps it's more reasonable that the request was invalid in the first place

* Imagine having two apples and asking the two apples for the third apple
* The natural response the apples would have is "...wut?"
    * An exception

* Remember, we are implementing a stack that can be used somewhere else
* What should be done will depend on what the code using the stack is doing
* The point is, I cannot possibly know what you will want to do tomorrow with my stack implementation

* What I can do however is throw an exception to let the user know something exceptional happened
* It is up to them to deal with the situation

.. warning::

    To use the ``NoSuchElementException``, we will need to import it --- ``import java.util.NoSuchElementException;``

size and isEmpty
^^^^^^^^^^^^^^^^

.. code-block:: Java
    :linenos:
    :emphasize-lines: 2

        public int size() {
            return top;
        }

        public boolean isEmpty() {
            return size() == 0;
        }

* Notice how, because of zero based indexing
    * ``top`` tells us the next available spot in the array
    * And the number of things in the stack

toString
^^^^^^^^

.. code-block:: Java
    :linenos:

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < top; ++i) {
            builder.append(stack[i]);
            builder.append(", ");
        }
        builder.append("<-- Top");
        return builder.toString();
    }

* See if you can figure out what the toString will return based on this code


For next time
=============

* Download and test the :download:`Stack <../main/java/Stack.java>` and  :download:`ArrayStack <../main/java/ArrayStack.java>` code
* :doc:`Check out the aside on testing </topic6-testing>`
* Finish reading Chapter 3
    * 16 pages

Code
====

* If everything was done correctly, the following code should work

.. code-block:: java
    :linenos:

    // Create an ArrayStack
    Stack<Integer> myStack = new ArrayStack<>(5);

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
    catch (NoSuchElementException e) {
        e.printStackTrace();
    }
    try {
        myStack.pop();
    }
    catch (NoSuchElementException e) {
        e.printStackTrace();
    }