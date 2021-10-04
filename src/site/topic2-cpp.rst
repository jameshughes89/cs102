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

* You could also use a preprocessor definition, but using ``const`` is nicer


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
    double FtoC(double fahrenheit){
        double celsius = (fahrenheit - 32) * 5.0/9.0;
        return celsius;
    }


Booleans
========

* Python --- ``someBool = True``
* Java --- ``boolean someBool = true;``
* C++ --- ``bool someBool = true;``

.. warning::

    Although C++ has booleans, you will see the value ``1`` mean ``true``, and ``0`` mean ``false (or, really, anything
    *not* ``1`` is ``false``).


Conditionals
------------

**Python**

.. code-block:: Python
    :linenos:

    # Python --- if/else
    # Assume someBool exists and is a boolean
    if someBool:
        print("it was true")
    else:
        print("it was false")


**Java**

.. code-block:: Java
    :linenos:

    // Java --- if/else
    // Assume someBool exists and is a boolean
    if (someBool) {
        System.out.println("it was true");
    } else {
        System.out.println("it was false");
    }


**C++**

.. code-block:: cpp
    :linenos:

    // C++ --- if/else
    // Assume someBool exists and is a boolean
    if (someBool) {
        std::cout << "it was true" << std::endl;
    } else {
	    std::cout << "it was false" << std::endl;
    }


Boolean Operators
-----------------

* Same as Java
    * less than --- ``a < b``
    * sameness --- ``c == d``
    * *not* sameness --- ``e != f``

* We've also got our logical operators
    * and --- ``v && w``
    * or --- ``x || y``
    * not --- ``!z``


Loops
=====

While Loops
-----------

**Python**

.. code-block:: Python
    :linenos:

    # Python --- while loop
    c = 0

    # While some condition is true
    while c < 10:
        print("c is now: " + str(c))
        c+=1

**Java**

.. code-block:: Java
    :linenos:
    :emphasize-lines: 5

    // Java --- while loop
    int c = 0;

    // While some condition is true
    while (c < 10) {
        System.out.println("c is now: " + c);
        c++;
    }


**C++**

.. code-block:: cpp
    :linenos:
    :emphasize-lines: 5

    // C++ --- while loop
    int c = 0;

    // While some condition is true
    while (c < 10) {
        std::cout << "c is now: " << c << std::endl;
        c++;
    }


More While Loops
----------------

**Python**

.. code-block:: Python
    :linenos:

    # Python --- while loop again
    stop = False
    c = 0

    while not stop:
        print("c is now: " + str(c))
        c+=1
        if c == 5:
            stop = True

**Java**

.. code-block:: Java
    :linenos:

    // Java --- while loop again
    boolean stop = false;
    int c = 0;

    while (!stop) {
        System.out.println("c is now: " + c);
        c++;
        if (c == 5) {
            stop = true;
        }
    }


**C++**

.. code-block:: cpp
    :linenos:

    // C++ --- while loop
    bool stop = false;
    int c = 0;

    while (!stop) {
        std::cout << "c is now: " << c << std::endl;
        c++;
        if (c == 5) {
            stop = true;
        }
    }


For Each Loop
-------------

**Python**

.. code-block:: Python
    :linenos:

    # Python --- for loop
    aList = ['a', 'b', 'c', 'd']

    # For each thing 'c' in aList
    for c in aList:
        print(c)

**Java**

.. code-block:: Java
    :linenos:

    // Java --- for each loop
    char[] anArray = {'a', 'b', 'c', 'd'};

    // For each character 'c' in anArray
    for (char e : anArray) {
        System.out.println(e);
    }


**C++**

.. code-block:: cpp
    :linenos:
    :emphasize-lines: 2

    // C++ --- for each loop
    char anArray[] = {'a', 'b', 'c', 'd'};

    // For each character 'c' in anArray
    for (char e : anArray) {
        std::cout << e << std::endl;
    }

* The only real difference here is how we are defining the array
    * We will discuss more on arrays in another aside


For Loop
--------

**Python**

.. code-block:: Python
    :linenos:

    # Python --- for loop
    # Run loop 10 times (0 -- 9)
    for i in range(10):
        print(i)


**Java**

.. code-block:: Java
    :linenos:
    :emphasize-lines: 3

    // Java --- for loop
    // Run loop 10 times (0 -- 9)
    for (int i = 0; i < 10; ++i) {
            System.out.println(i);
    }


**C++**

.. code-block:: cpp
    :linenos:
    :emphasize-lines: 2

    // C++ --- for loop
    // Run loop 10 times (0 -- 9)
    for (int i = 0; i < 10; ++i) {
       std::cout << i << std::endl;
    }


For next time
=============

* Practice
    * Use Kattis and solve problems you have already solved in Python, but use C++