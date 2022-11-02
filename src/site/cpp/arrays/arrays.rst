**********************
C++ Lessons --- Arrays
**********************

.. warning::

    * For these, I will only go over the C++ details at a high level
    * Getting into the nitty gritty of C++ is not the purpose of this aside
    * Some of the concepts require knowledge of more advanced ideas that have not been covered yet
        * If this happens, do not panic
        * it probably makes more sense to revisit this later in the course
    * For simplicity, some of the examples will use less than ideal implementations


.. note::

    Here we will go over the basics of arrays in C/C++; however, in practice you will likely be making use of C++'s
    standard library's `std::vector <https://en.cppreference.com/w/cpp/container/vector/>`__.


Static Arrays
=============

* *Static* arrays mean that the **size** is known at compile time and is not going to change
* In the below example, we are setting aside a chunk of memory that is ready to store 5 integers
* Unlike Java however, there are no default values set in the array

.. code-block:: cpp
    :linenos:

    int foo[5];


.. image:: static_array.png
   :width: 400 px
   :align: center
   :target: http://www.cplusplus.com/doc/tutorial/arrays/

* We can also assign values to the array on creation


.. code-block:: cpp
    :linenos:

    int foo[] = {16, 2, 77, 40, 12071};


.. image:: static_array_set.png
   :width: 400 px
   :align: center
   :target: http://www.cplusplus.com/doc/tutorial/arrays/



Changing/Accessing Data
-----------------------

* Or we can assign/change and/or retrieve the values with indexing
* These static arrays have known sizes at compile time, but we can still change the contents
* In the below example
    * The value at index ``3`` in ``foo`` will be set to ``99``
    * The value from index ``3`` in ``foo`` (``99``) will be copied to ``x``

.. code-block:: cpp
    :linenos:

    foo[3] = 99;
    int x = foo[3];


As Function Parameters
----------------------

* As you would expect, arrays can be passed to functions as parameters

.. code-block:: cpp
    :linenos:

    void printArray(int toPrint[], int length){
        for(int i = 0; i < length; i++){
            std::cout << toPrint[i] << std::endl;
        }
    }


.. warning::

    These arrays are just chunks of RAM and do **not** know their own size; we must keep track of the array length on
    our own. In the above example, notice how the ``length`` was also included as a parameter.

    There is a way to get the length of an array, but it's a little cumbersome. The ``sizeof`` operator tells you how
    much RAM a given value/type takes up. For example, if you ask ``sizeof(someInt)``, it will return the number of bytes
    an integer needs (typically 4 bytes). Further, if you have an array ``int foo[5]``,  and ask ``sizeof(foo)``, it
    will return the total amount of RAM that array uses (in this case, one would expect 20 bytes --- room for 5
    integers, and an integer takes up 4 bytes). With this, I can calculate the size of the array with
    ``sizeof(foo)/sizeof(foo[0])``.


Arrays vs. Pointers
-------------------

* Arrays and pointers behave similarly
* In the below example, the when printing out ``foo`` we get the memory address of where the array starts
* When printing out ``&foo[0]``, we get the memory address of the first element in the array
    * These are the same
    * ``foo == &foo[0]``

.. code-block:: cpp
    :linenos:

    int foo[5];

    // These are equivalent
    std::cout << foo << std::endl;
    std::cout << &foo[0] << std::endl;


* In fact, we can even index an ``int*`` if it's pointing to an array
    * You can also do this if it's not pointing to an array too, but this is a recipe for disaster

.. code-block:: cpp
    :linenos:

    int foo[5] = {10, 11, 12, 13, 14};
    int* bar = foo;

    // These are equivalent
    std::cout << foo[1] << std::endl;
    std::cout << bar[1] << std::endl;


* Even more interesting is pointer arithmetic for indexing
    * Just because we can, doesn't mean we should though

* This means, take the memory address, add 1 to it, and then dereference to get the contents of the address
    * This does not actually add 1 --- it will add one integer's worth of bytes (so this would be + 4)

.. code-block:: cpp
    :linenos:

    int foo[5] = {10, 11, 12, 13, 14};
    int* bar = foo;

    // These are equivalent
    std::cout << *(foo + 1) << std::endl;
    std::cout << *(bar + 1) << std::endl;


.. warning::

    Unlike Java and Python, there is nothing stopping you from indexing outside the array. For example, if
    ``int foo[5]`` exists, one can access ``foo[25]`` and cpp will gladly return whatever value is stored at that memory
    address.


Dynamic Arrays
==============

* The static arrays require a known size at compile time
* This is because cpp wants to allocate the RAM on the stack it needs before it starts running
    * Cpp will manage the memory on the stack for us

* This means determining the size of the array at runtime is problematic
* The below example will not work
    * On some platforms this will actually work, but assume it will not

.. code-block:: cpp
    :linenos:

    int size;
    std::cin >> size;
    int foo[size];


* However, it is not unreasonable to want to have an array that's size is determined at runtime
* Fortunately, there is still a way to do this, but we need to allocate the memory on the *heap*
    * Cpp does not manage this memory for us
    * We must take care to allocate and deallocate the memory we use in the heap
    * If we do not deallocate the memory, we end up with something called a memory leak
        * Your program is taking up more and more memory, but it's just waisting space

* In the below example, we can allocate memory in the heap with the ``new`` keyword
* Notice that the variable ``foo`` is a pointer to an integer

.. code-block:: cpp
    :linenos:

    int size;
    std::cin >> size;
    int* foo = new int[size];

* Even though the variable ``foo`` is an integer pointer, we can still index it like an array as we saw above
    * ``foo[1]``

* Now we can create arrays that have their size determined at runtime and use them like any other array

.. code-block:: cpp
    :linenos:

    // Create array
    int size;
    std::cin >> size;
    int* foo = new int[size];

    // Put contents into array
    for(int i = 0; i < size; i++){
        foo[i] = i;
    }

    // print out array contents
    for(int i = 0; i < size; i++){
        std::cout << foo[i] << std::endl;
    }

    // Delete the array
    // mind the []
    delete[] foo;


Deallocating Memory
-------------------

* There is a catch to these dynamic arrays
* Any memory we allocate on the heap needs to be managed by us
* Cpp will allocate/deallocate memory that is on the stack
* But cpp will trust that we will allocate/deallocate memory on the heap

* We allocated memory to make ``foo`` on the heap
* When we do not need the array anymore, we need to delete it
* Take note of the ``delete[]`` at the end of the above example
* This will tell cpp that the memory on the heap that was allocated for our array is not not needed anymore
* This does **not** delete the integer pointer ``foo``; this depletes what ``foo`` was pointing to
    * The integer pointer ``foo`` is allocated on the stack here

.. note::

    This will be similar-ish to what you are used to with Python and Java. The big difference here is deallocating and
    dereferencing where necessary.


The Heap?
=========

.. note::

    Going into detail on the stack vs. heap and the inner workings of cpp memory management is well outside the scope of
    these asides. Only a superficial level of ideas are persented here.


* We can allocate other things on the heap too if we want
* The below example creates a string on the heap
* When it is not needed anymore, it must be deleted
    * Note that in this case it was only ``delete``, where with the array it was ``delete[]``

* As a simple rule, whenever you have a ``new`` something, you will want to ``delete`` it when it's not needed anymore

.. code-block:: cpp
    :linenos:

    std::string* myString = new std::string("Hello");
    // Some code
    delete myString;


Further Reading
===============

* Read the `cplusplus.com <http://www.cplusplus.com/doc/tutorial/arrays/>`__ tutorial on arrays
    * Images are taken directly from the cplusplus page
    * Click the images to visit the page

* Read up on ``std::vector``
    * `cppreference.com <https://en.cppreference.com/w/cpp/container/vector>`__
    * `cplusplus.com <https://www.cplusplus.com/reference/vector/vector/>`__

* There also exists a ``std::array`` too, which you may find interesting
    * `cppreference.com <https://en.cppreference.com/w/cpp/container/array>`__
    * `cplusplus.com <https://www.cplusplus.com/reference/array/array/>`__
