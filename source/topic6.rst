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

        .. image:: ../img/warning_implement.png
           :width: 500 px
           :align: center


**Constructors**

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
    * This includes instantiating arrays of the generic type like above

* When doing this, Java will warn us that there is now an unchecked type conversion
    * Java can't guarantee that the cast will work right

* We can actually suppress the warning by adding the following before the constructor
    * ``@SuppressWarnings("unchecked")``


* Creating an instance ``Stack<Integer> s = new ArrayStacm<Integer>(5);``

        .. image:: ../img/arraystack_empty.png
           :width: 500 px
           :align: center


Expand Capacity
^^^^^^^^^^^^^^^


Exceptional Situations
----------------------


For next time
=============

* Finish reading Chapter 3
    * 16 pages
