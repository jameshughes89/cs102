******************************************
Topic #1 Aside --- C++ vs. Java vs. Python
******************************************

* For these, I will only go over the C++ details at a high level
* Getting into the nitty gritty of C++ is not the purpose of this aside

**Python**

.. code-block:: python
    :linenos:

    # Python --- hello world
    print("Hello, world!")


**Java**

.. code-block:: java
    :linenos:

    // Java --- hello world
    public class SomeClass {
        public static void main(String[] args){
            System.out.println("Hello, world!");
        }
    }


**C++**

.. code-block:: cpp
    :linenos:

    #include <iostream>

    // Cpp --- hello world
    int main() {
        std::cout << "Hello, World!" << std::endl;
        return 0;
    }

* ``#include`` is basically ``import`` like we used in Python
* ``<iostream>`` in the standard input/output library for C++
    * It let's us use ``std::cout``, which is how we can print things

* ``int main()`` is just a function
    * With C++, we need a main function --- this is where the program begins
    * ``int`` is the function return type --- more on this later
    * Although not necessary, we see ``return 0`` at the end
        * This is the value that the ``main`` function is returning
        * Typically ``0`` is an *exit code* that means things went well

* The ``"Hello, World!"`` is simply the string being output

* The ``std::cout`` is how we will print things out
    * The ``std`` part is the namespace where ``cout`` is
        * Like the ``math`` in ``math.sin`` in Python
    * ``std`` is short for *standard*

* ``std::endl`` is how we end the line we're printing
    * We could simply use a new line character, but the benefit of using ``endl`` is that we flush the buffer

* Like Java:
    * You will also see the use of semicolons (``;``) at the end of the lines of code (we need these)
    * We use squiggly brackets for starting end ending the function ``{ ... }``

