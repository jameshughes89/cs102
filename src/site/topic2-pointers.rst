***************************
Topic #2 Aside --- Pointers
***************************

* Variables we make in our program go into RAM

.. code-block:: cpp
    :linenos:

    int anInt = 5;

* This makes a variable called ``anInt`` and assigns it the value ``5``
* The value ``5`` is stored in RAM somewhere, and we use the label ``anInt`` to access it
* Generally, where in RAM the value is actually stored is up to the operating system
* But a neat thing about C++ is that we can ask *where* in RAM the value is stored


Address Of Operator
===================

* The address of operator --- ``&``
    * The symbol ``&`` is used a lot, but it is context sensitive

* We can get the memory address of where a given variable is stored by putting the ``&`` right in front of the variable name

.. code-block:: cpp
    :linenos:

    int anInt = 5;
    std::cout << anInt << " is at " << &anInt << std::endl;

* The result would look something *like* this

    ``5 is at 0x7ffde2544134``

* This tells us that the operating system used memory address ``0x7ffde2544134`` to store the value ``5``
    * Note that this memory address is represented in *hexadecimal*
    * Also note that your memory address will differ if you run this, and will differ every time you run the program

* The variable name, ``anInt``, is the label for this memory address in this context


Pointer Variable
================

* Instead of simply printing out the memory address, we can store it in a variable for later use
* The trick here is to be mindful of the type of data we are storing
    * If we want to store an integer pointer, we will have an integer pointer type


.. code-block:: cpp
    :linenos:

    int myVar = 25;

    // Create a pointer variable
	int* foo = &myVar;
	int bar = myVar;

* In the above example, notice the asterisk (``*``) next to the ``int``
* This means that the data being stored in the variable labelled ``foo`` must be of type integer pointer
* ``bar`` on the other hand just has type ``int``


.. image:: img/cpp_pointer0.png
   :width: 200 px
   :align: center
   :target: https://www.cplusplus.com/doc/tutorial/pointers/

* In the above example, assuming ``myVar`` is stored at address ``1776``
    * The address is stored in the integer pointer ``foo``
    * The integer from ``myVar`` is copied to the integer ``bar``

