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


Variables and Types
===================


**Python**

.. code-block:: python
    :linenos:
    :emphasize-lines: 2,3,4

    # Python --- Declaring and assigning variables
    anInt = 5
    aFloat = 5.5
    aString = "5"       # Could have used '5'


**Java**

.. code-block:: java
    :linenos:
    :emphasize-lines: 4,5,6

    // Java --- Declaring and assigning variables
    public class SomeClass {
        public static void main(String[] args){
            int anInt = 5;
            double aFloat = 5.5;    // doubles now for float
            String aString = "5";   // Mind the double quotes

        }
    }


**C++**

.. code-block:: cpp
    :linenos:
    :emphasize-lines: 1,7

    #include <string>

    // Cpp --- Declaring and assigning variables
    int main() {
        int anInt = 5;
        double aFloat = 5.5;         // doubles now for float
        std::string aString = "5";   // Mind the double quotes
        return 0;
    }

* You will see that C++ and Java are very similar here
* The only catch is that, unlike Java and Python, we don't get strings for free out of the box
* We can use strings by including ``<string>``
    * Or ``<iostream>`` since we get strings that that too
* Also note the use of ``std`` before the string type

* Just like Java, with C++ you cannot swap the types we store in our variables like we could in Python
    * Although, there kinda' is a way to do this in C++, but we will ignore that

* Again, like Java, with C++ we can declare a variable on a single like and then assign it a value later


Constants
---------

**Python**

.. code-block:: python
    :linenos:

    # Python --- Constants
    SALES_TAX = 1.15    # This is a constant. Leave this alone!


**Java**

.. code-block:: java
    :linenos:

    // Java --- Constants
    final double SALES_TAX = 1.15;      // Java will get mad if we mess with this


**C++**

.. code-block:: cpp
    :linenos:

    // Cpp --- Constants
    const double SALES_TAX = 1.15;

* You could also use a preprocessor definition, but this is nicer


Input & Output
==============


**Python**

.. code-block:: Python
    :linenos:

    theInput = input("gimmie something: ")
    print(theInput)


**Java**

.. code-block:: Java
    :linenos:

    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.io.IOException;

    public class SomeClass {
        public static void main(String[] args){

            // Create a Stream Reader with the standard input
            InputStreamReader stream = new InputStreamReader(System.in);

            // Give the Stream Reader to a Buffered Reader
            BufferedReader reader = new BufferedReader(stream);

            // We use the Buffered Reader to read the actual stream
            // We use a try & catch because readLine may throw an
            // exception that we must deal with
            try {
                String theLine = reader.readLine();
                System.out.println(theLine);
            } catch (IOException e){
                System.out.println("Something bad happened when reading.");
            }
        }
    }


**C++**


* Below is an example of inputting a primitive type

.. code-block:: cpp
    :linenos:

    int a;
    std::cout << "gimmie something: ";
    std::cin >> a;
    std::cout << a << std::endl;


* If we want to read two things on a single line, you could do this

.. code-block:: cpp
    :linenos:

    int a, b;
    std::cout << "gimmie 2 somethings: ";
    std::cin >> a >> b;
    std::cout << a << " and " << b << std::endl;


* Reading in a string is a little different, but still relatively simple

.. code-block:: cpp
    :linenos:
    :emphasize-lines: 3

    std::string a;
    std::cout << "gimmie something: ";
    std::getline(std::cin, a);
    std::cout << a << std::endl;


Functions
=========

**Python**

.. code-block:: Python
    :linenos:
    :emphasize-lines: 2

    # Python --- Declaring a function
    def someFunction(a, b):
        c = a + b
        return c

    # Call the function
    result = someFunction(1, 2)
    print(result)


**Java**

.. code-block:: Java
    :linenos:
    :emphasize-lines: 5, 10

    // Java
    public class SomeClass {
        public static void main(String[] args) {
            // Call the function
            int result = someFunction(1, 2);
            System.out.println(result);
        }

        // Declare the Function
        static int someFunction(int a, int b) {
            int c = a + b;
            return c;
        }
    }


**C++**

.. code-block:: cpp
    :linenos:
    :emphasize-lines: 2, 8

    // Declare the function
    int someFunction(int a, int b){
        int c = a + b;
        return c;
    }

    int main(){
        std::cout << someFunction(1, 2) << std::endl;
    }

* You will see that the Java and C++ examples are very similar
* The one catch here is that the function is defined before main
    * We can put it after main if really we want, but then we would need to add a function prototype before the main
    * ``int someFunction(int, int);	// Function Prototype``


Temperature Converter
---------------------

**Python**

.. code-block:: Python
    :linenos:
    :emphasize-lines: 3

    # Python --- Convert farenheit to celcius
    def fahrenheit_to_celcius (fahrenheit):
        celsius = (fahrenheit - 32) * 5/9
        return celsius


**Java**

.. code-block:: Java
    :linenos:
    :emphasize-lines: 3

    // Java --- Convert farenheit to celcius
    static double fahrenheitToCelcius(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5.0/9.0;
        return celsius;
    }


**C++**

.. code-block:: cpp
    :linenos:
    :emphasize-lines: 2, 8

    // C++ --- Convert farenheit to celcius
    double FtoC(double fahrenheit){
        double celsius = (fahrenheit - 32) * 5.0/9.0;
        return celsius;
    }


Comments
========

.. code-block:: cpp
    :linenos:

    // This is a single line comment in C++

    /*
    This is a
    multi line
    comment in
    C++
     */

    /**
     * Convert the provided temperature from fahrenheit
     * to celsius.
     *
     * This also demonstrates how to write a javadoc
     * comment.
     *
     * @param fahrenheit    temperature in fahrenheit
     * @return              temperature in celsius
     */
    static double FtoC(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5.0/9.0;
        return celsius;
    }