***************
Java vs. Python
***************

.. list-table:: Hello World
    :header-rows: 1

    * - Python
      - Java

    * -     .. code-block:: python
                :linenos:

                print("Hello, world!")

      -     .. code-block:: java
                :linenos:

                public class SomeClass {
                    public static void main(String[] args){
                        System.out.println("Hello, world!");
                    }
                }



Variables and Types
===================


.. list-table:: Declaring Variables
    :header-rows: 1

    * - Python
      - Java

    * -     .. code-block:: python
                :linenos:

                anInt = 5
                aFloat = 5.5
                aString = "5"

      -     .. code-block:: java
                :linenos:
                :emphasize-lines: 3,4,5,6

                public class SomeClass {
                    public static void main(String[] args){
                        int anInt = 5;
                        double aFloat = 5.5;    // doubles now for float
                        String aString = "5";   // Mind the double quotes
                        char aCharacter = '5';  // Single quote for character

                    }
                }

* Notice the five main differences:
    1. We **must** declare the variables with their types
    2. We will use the word ``double`` to be floating point numbers
        * Technically we could still use ``float``, but I almost always see ``double``
        * A ``float`` takes up 4 bytes and a ``double`` takes up 8 (double the amount)
    3. We use ``"double quotes"`` for strings --- a single character only uses single quotes: ``'a'``
        * That does mean that we have a new type: a character (``char``)
        * ``char theLetterB = 'B';``
    4. We use ``// for comments`` instead of ``# like in Python``
    5. We end our statements in Java with a semicolon (``;``)

.. warning::

    From now on, I will **not** be including the ``class`` stuff and  ``public static void main(String[] args)`` unless necessary.


.. warning::

    Unlike how in Python you can change the type that the variable has, you cannot do that in Java; Java will not
    compile the above code.

    .. list-table::
        :header-rows: 1

        * - Python
          - Java
        * -     .. code-block:: python
                    :linenos:

                    otherInt = 5
                    otherInt = 'totally Not 5'

          -     .. code-block:: java
                    :linenos:
                    :emphasize-lines: 3

                    int otherInt = 5;
                    otherInt = "totally Not 5";     // Nope



Declaring & Assigning Variables
-------------------------------

* There is a difference between *declaring* and *assigning* a variable
* In Python, we didn't need to explicitly *declare* variables
    * They got created and automatically declared once they are assigned a value

* In Java, we have to explicitly declare variables
    * This tells the computer that you need to set aside enough memory for something of the specified type

.. list-table:: Declaring and Assigning Variables
    :header-rows: 1

    * - Python
      - Java

    * -     .. code-block:: python
                :linenos:

                anotherInt = 11
                print(anotherInt)

      -     .. code-block:: java
                :linenos:

                int anotherInt;                     // Declaration
                anotherInt = 11;                    // Assignment
                System.out.println(anotherInt);

* However, you can declare and assign a variable in a single line of code, like we saw in the examples above


Reusing Variables
-----------------

.. list-table:: Reusing Variables
    :header-rows: 1

    * - Python
      - Java

    * -     .. code-block:: python
                :linenos:

                a = 5
                print(a + 2)

                b = a + 7
                print(b)

                b = b + 1
                print(b)

                b += 1
                print(b)

      -     .. code-block:: java
                :linenos:
                :emphasize-lines: 1, 4

                int a = 5;
                System.out.println(a + 2);

                int b = a + 7;
                System.out.println(b);

                b = b + 1;
                System.out.println(b);

                b += 1;
                System.out.println(b);


* It's the same except for explicitly declaring the types for the variables the first time you use them

.. warning::

    Just because you *can* doesn't mean you *should*. This isn't something you would likely want to be doing though.


Constants
---------

* Recall *constants*
    * Variables that are set by the programmer but are **not** changed throughout execution of the program

* Python, the language, does not enforce constants to not be altered
* The idea of constants are maintained and respected among programmers
* The convention is to use all upper case letters and separate words with underscores
    * ``THIS_IS_A_CONSTANT``
* You **can** change the values during execution, but you shouldn't, because then you're breaking the convention
* Java will ensure that the value of the constant is set once and only once during the execution of the program
* We use the special keyword ``final``

.. list-table:: Constants
    :header-rows: 1

    * - Python
      - Java

    * -     .. code-block:: python
                :linenos:

                SALES_TAX = 1.15    # Leave me alone

      -     .. code-block:: java
                :linenos:

                final double SALES_TAX = 1.15;


* We can change constant's values however we want while writing the code
* The point is that they will **not** change once set


Arrays
======

* Java does not come with lists ready to go like Python does
    * Or, at least, we don't get them *as a language primitive*
* Java does however have *arrays*, which are similar-ish to lists
    * They store data in a sequential linear collection
    * They have a **fixed** size
    * They have fewer built in functions


.. list-table:: Lists & Arrays
    :header-rows: 1

    * - Python
      - Java

    * -     .. code-block:: python
                :linenos:

                aList = [10, 11, 12, 13]

                # Access the list at index 1
                print(aList[1])

                # Modify the list at index 1
                aList[1] = 21
                print(aList[1])

      -     .. code-block:: java
                :linenos:

                int[] anArray = {10, 11, 12, 13};

                // Access the array at index 1
                System.out.println(anArray[1]);

                // Modify the array at index 1
                anArray[1] = 21;
                System.out.println(anArray[1]);


* With the exception of the type and syntax, these look the same
    * We have to specify the type for Java ``int[]``
        * Note that ``int`` is an int and ``int[]`` is an array of ints
    * We use squiggly braces (``{ ... }``) instead of brackets (``[ ... ]``)

* One difference is that the Java arrays can't have mixed types like a Python list
    * There is an asterisk added to this statement that we weill talk about later

* One **huge** difference is that the Java array used in the above example will **always** be size 4
    * We **can't** list append to an array like we did with lists in Python
        * ``aList.append(34)``

* This means that we can't just start with an empty array and have it grow and grow
* In Java, arrays have fixed sizes

.. list-table:: "Growing" a List/Array
    :header-rows: 1

    * - Python
      - Java

    * -     .. code-block:: python
                :linenos:

                # List will start with 0
                aList = []

                # List will grow to size 1,000
                for i in range(1000):
                    aList.append(i)

      -     .. code-block:: Java
                :linenos:

                // Create a new array of size 1,000
                int[] anArray = new int[1000];

                // Put a number in each index in the array
                for(int i = 0; i < anArray.length; i++){
                    anArray[i] = i;
                }

* Mind line 3, showing how to make an array of some size
    * They will be filled with some default value (0 in this case)
* Mind line 6, showing:
    * A ``for`` loop (more on this later)
    * Arrays have an attribute ``length`` that tells us its capacity
* Mind line 7 showing us indexing the array in order to assign it a value


* We can even make the size of the array based on some runtime determined value
    * For example:
        * If you have to read from a file, how big should the array be?
        * Perhaps the first line of the file contains how long the file is
        * ``String[] fileContents = new String[someValueReadIn]``

.. warning::

    In Java, we **cannot** index our arrays backwards like we could in Python.


.. _label-topic2-java_vs_python-input_output:


Input & Output
==============

* We've already seen standard output in Java
    * ``System.out.print("print");``
    * ``System.out.println("print a line");``

* Standard input with Java is a lot more verbose
    * This is because Java isn't designed for console applications
    * Besides, the only place we will use this is on Kattis anyways

.. list-table:: Reading Input
    :header-rows: 1

    * - Python
      - Java

    * -     .. code-block:: Python
                :linenos:

                theInput = input()
                print(theInput)

      -     .. code-block:: Java
                :linenos:

                // Outside class definition
                import java.io.BufferedReader;
                import java.io.InputStreamReader;
                import java.io.IOException;

                ...

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
                    System.out.println("Something bad happened.");
                }


* Mind the ``import`` statements
* We read from a *stream*
    * Here our stream is the standard input (``System.in``)

* We create an ``InputStreamReader`` object
    * The thing that reads the input from the stream
    * Sadly, this will be one thing at a time

* We use a ``BufferedReader`` to *buffer* the stream reader
    * So we can read in more than one at a time

* You will also see that we put a ``try`` and ``catch`` around the ``reader.readLine()``
    * This is done because ``.readLine()`` has an exception that may be thrown that you must deal with
    * Don't worry, we'll go in more details on exceptions later in the class

* Like Python's ``input()``, ``.readLine()`` returns a ``String``

* Alternatively, we can modify the above code to, arguably, clean up the code
* This way, we just pass the buck of dealing with the exception to the caller of the function
    * THEY need to deal with it, not us here
    * In this example, it's the ``main`` method, so this will throw the exception at the person who ran the program


.. code-block:: Java
    :linenos:
    :emphasize-lines: 6

    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.io.IOException;

    public class SomeClass {
        public static void main(String[] args) throws IOException {

            // Create a Stream Reader with the standard input
            InputStreamReader stream = new InputStreamReader(System.in);

            // Give the Stream Reader to a Buffered Reader
            BufferedReader reader = new BufferedReader(stream);

            // We use the Buffered Reader to read the actual stream
            String theLine = reader.readLine();
            System.out.println(theLine);
        }
    }


Functions
=========

.. list-table:: Function Definitions
    :header-rows: 1

    * - Python
      - Java

    * -     .. code-block:: Python
                :linenos:
                :emphasize-lines: 2, 7

                # Declaring a function
                def someFunction(a, b):
                    c = a + b
                    return c

                # Call the function
                result = someFunction(1, 2)
                print(result)

      -     .. code-block:: Java
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

* We **must** tell the function its return type
    * ``int`` in this example, because the thing being returned is an int
    * If we happen to have no return value for our function, then use ``void``
        * ``static void someOtherFunction( ... ) { ``

* Parameters have their types set

* In the above example, the function is ``static``
    * This is a function that belongs to the class, not an instance of the class
        * In fact, we could have used this instead ``int result = SomeClass.someFunction(1, 2);``
    * It's not a function we will call on an instance of some object

* You will also see that, unlike in the Python example, we can declare the functions after the calling code


Temperature Converter
---------------------

.. list-table:: Function to Convert Fahrenheit to Celsius
    :header-rows: 1

    * - Python
      - Java

    * -     .. code-block:: Python
                :linenos:
                :emphasize-lines: 2

                def fahrenheit_to_celsius(fahrenheit):
                    celsius = (fahrenheit - 32) * 5/9
                    return celsius

      -     .. code-block:: Java
                :linenos:
                :emphasize-lines: 2

                static double fahrenheitToCelsius(double fahrenheit) {
                    double celsius = (fahrenheit - 32) * 5.0/9.0;
                    return celsius;
                }


* Pay special attention to the division taking place on like 3
* If we wrote ``5/9``, since both ``5`` and ``9`` are integers, it will do integer division
* Since integers do not have decimal values, we truncate the decimal off, so, ``5/9 = 0``
    * In reality, we know it is 0.55555555555, but we are ditching everything after the decimal point

* This functionality is more typical
    * In fact, Python used to work this way too, and they made people mad when they changed


Comments
========

.. code-block:: Java
    :linenos:

    // This is a single line comment in Java

    /*
    This is a
    multi line
    comment in
    Java
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
        double celsius = (fahrenheit - 32) * 5/9;
        return celsius;
    }

* In the above Java example you will see
    * An example single line comment (``//``)
    * A multiline comment (``/* ... /*``)
    * An example of javadoc comments (``/** ... */``)
        * Mind the ``@param`` and ``@return``


Booleans
========

* Java has Boolean values, except they start with lower case letters
    * Python --- ``some_boolean = True``
    * Java --- ``boolean someBoolean = true;``

Conditionals
------------

.. code-block:: Python
    :linenos:

    # Python --- if/else
    # Assume some_boolean exists and is a boolean
    if some_boolean:
        print("it was true")
    else:
        print("it was false")


.. code-block:: Java
    :linenos:

    // Java --- if/else
    // Assume someBoolean exists and is a boolean
    if (someBoolean) {
        System.out.println("it was true");
    } else {
        System.out.println("it was false");
    }

* Both examples above assume the variable ``someBoolean`` exists and is a boolean
* Notice how the condition is in parentheses in the Java example
    * ``( ... )``

Boolean Operators
-----------------

* Just like Python, we have comparison operators that return booleans
    * less than --- ``a < b``
    * sameness --- ``c == d``
    * *not* sameness --- ``e != f``

* We've also got our logical operators
    * and --- ``v && w``
    * or --- ``x || y``
    * not --- ``!z``

Loops
=====

* Just as you would expect, Java has loops too

While Loops
-----------

.. code-block:: Python
    :linenos:

    # Python --- while loop
    c = 0

    # While some condition is true
    while c < 10:
        print("c is now: " + str(c))
        c+=1


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

* Just like the ``if`` statements, we put the condition in parentheses
* Note the ``c++`` --- this is the same thing as ``c+=1``, but even shorter
    * You can still use your ``c+=1`` all you want in Java

* Here is another example

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

For Each Loop
-------------

* For loops in Python are basically *for each* loops


.. code-block:: Python
    :linenos:

    # Python --- for loop
    aList = ['a', 'b', 'c', 'd']

    # For each thing 'c' in aList
    for c in aList:
        print(c)


.. code-block:: Java
    :linenos:

    // Java --- for each loop
    char[] anArray = {'a', 'b', 'c', 'd'};

    // For each character 'c' in anArray
    for (char c : anArray) {
        System.out.println(c);
    }

* It's remarkably similar, except
    * we specify the type of ``c``
    * use a ``:`` instead of a ``in``


For Loop
--------

* In Python, when we wanted to loop some number of times, often we would do something like this


.. code-block:: Python
    :linenos:

    # Python --- for loop
    # Run loop 10 times (0 -- 9)
    for i in range(10):
        print(i)


* In Java, we'd typically do it this way


.. code-block:: Java
    :linenos:
    :emphasize-lines: 3

    // Java --- for loop
    // Run loop 10 times (0 -- 9)
    for (int i = 0; i < 10; ++i) {
        System.out.println(i);
    }

* Here, we're running the first statement within the parentheses by the for loop once
    * ``int i = 0``
    * Create an int ``i`` and set it to ``0``

* The second statement in the parentheses is the condition we check every time the loop runs
    * ``i < 10``
    * check if ``i`` is less than ``10``
    * This could be more general conditionals too

* The third statement in the parentheses runs after each time the code block in the loop finishes
    * ``++i``
    * After we have finished the body of the for loop (``System.out.println(i);``), add ``1`` to ``i``

* Overall, this says:
    * Create an ``int i`` and set it to 0
    * If ``i`` is less than ``10``, run the loop
    * Add ``1`` to ``i`` every time the loop runs

* In other words, this loop will run 10 times
    * ``0 -- 9``

Comparison of For to While
^^^^^^^^^^^^^^^^^^^^^^^^^^

* It may be useful to show the comparison of a for loop to a while loop

.. code-block:: Java
    :linenos:

    // For loop
    for (initializer; condition; step) {
        loop stuff;
    }

    // The same functionality as a while loop
    // although, scope does come into play
    initializer;
    while (condition) {
        loop;
        step;
    }

* In the above example, both loops are doing the same thing and have the same functionality
* The only functional difference is scope
* In the for loop example, the initialized stuff only exists within the loop
    * The ``i`` in ``int = i`` cannot be accessed outside the loop
    * The initialized stuff for the while loop will exist outside the loop

Java Conventions
================

* The following is **not** exhaustive, but here are some important ones

* Have one public class per file
    * Not really a convention, more like a **must do**

* Class names start with capital letters
    * ``SomeClass``

* File names are the same as the class
    * ``SomeClass.java``
    * Also not so much of a convention as a requirement

* Functions/methods should be *camel case*, starting with a lower case
    * ``someFunction( ... )``
    * ``someOtherFunction( ... )``

* Variables should be camelcase, starting with a lower case
    * ``int someVariable = 5;``
    * ``int someOtherVariable = 55;``

* Constants are all uppercase with underscores separating words (*snake case*)
    * ``static final int THIS_IS_A_CONSTANT = 555;``


For Next Time
=============

.. warning::

    If at any point you are thinking "Oh crap, how on earth am I going to remember all these differences?", `you're doing programming wrong <https://www.google.com/search?q=how+to+use+for+loops+in+java>`_.


* Practice
    * Use Kattis and solve problems you have already solved in Python, but use Java
    * `If at any point you feel stuck because you don't know how to do something in Java, I have good news for you <https://www.google.com/>`_.

* `Check out Java's code conventions <https://www.oracle.com/java/technologies/javase/codeconventions-contents.html>`_

* Read Chapter 1 of your text
    * 15 pages


* :doc:`Although outside the scope of the course, if you would like to see how a C++ differs, check out the relevant C++ lesson. </cpp/syntax/syntax>`
* :doc:`Although not part of the course, if you would like, check out C++ lesson on pointers. </cpp/pointers/pointers>`


