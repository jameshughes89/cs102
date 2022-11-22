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

                anInt = 5
                aFloat = 5.5
                aString = "5"

      -     .. code-block:: java
                :emphasize-lines: 3,4,5,6

                public class SomeClass {
                    public static void main(String[] args){
                        int anInt = 5;
                        double aFloat = 5.5;    // doubles now for float
                        String aString = "5";   // Mind the double quotes
                        char aCharacter = '5';  // Single quote for character

                    }
                }

* Notice a few main differences:

    #. We **must** declare the variables with their types
    #. We will use the word ``double`` to be floating point numbers

        * Technically we could still use ``float``, but ``double`` is very common
        * A ``float`` takes up 4 bytes and a ``double`` takes up 8 --- *double* the amount

    #. We use ``"double quotes"`` for strings --- single quotes are used for a single character: ``'a'``

        * That does mean that we have a new type: a character (``char``)
        * ``char theLetterB = 'B';``

    #. We use ``// for comments`` instead of ``# like in Python``
    #. We end our statements in Java with a semicolon (``;``)


.. warning::

    For the sake of brevity, from now on the ``class`` stuff and ``public static void main(String[] args)`` boilerplate
    code will **not** be included in the code examples unless necessary.


.. warning::

    In Python one could change the value stored in a variable to something of a different type. In Java, this is **not**
    possible since we need to be explicit about what the type of the value is to be stored in a variable.

    If one writes code that would put a value of a type into a variable of another type, Java will not even compile the
    code; the code will not even run. At first this may seem frustrating, but this ends up being very helpful as it
    protects against certain bugs before the code even starts running.

    .. list-table::
        :header-rows: 1

        * - Python
          - Java
        * -     .. code-block:: python

                    otherInt = 5
                    otherInt = 'totally not 5'

          -     .. code-block:: java
                    :emphasize-lines: 3

                    int otherInt = 5;
                    otherInt = "totally not 5";     // Compiler error


Declaring & Assigning Variables
-------------------------------

* There is a difference between *declaring* and *assigning* a variable
* In Python, one did not need to explicitly *declare* variables

    * They got created and automatically declared once they are assigned a value

* In Java, one must explicitly declare variables

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


* However, in Java, one could declare and assign a variable in a single line of code, like in the above examples

    * ``int anotherInt = 11;`` --- variable is declared and assigned in a single line


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


* The Python and Java code is nearly the same
* The difference with Java is the need to explicitly declare the variable the first time they are used

.. warning::

    Although it is fine to reuse variables, it is often not overly helpful. The above example really only makes sense
    given that they are arbitrary values stored in variables with nondescript names.

    Consider a variable for storing a temperature in Celsius --- ``temperatureInCelsius``. The circumstances where it
    would make sense to assign a brand new value to this variable would be very limited.


Constants
---------

* Recall *constants*

    * Variables that are set by the programmer but are not changed *throughout the execution of the program*

* Python, the language, does not enforce the rule that constants should not be altered
* The idea of constants are maintained and respected among programmers
* The convention is to use all upper case letters and separate words with underscores

    * ``THIS_IS_A_CONSTANT``

* Although one could change the values during execution, it would break the convention

* Java will, however, ensure that the value of the constant is set once and not changed during execution
* The special keyword ``final`` is used to declare a constant

    * Forces the variable to be set exactly once
    * If somehow no value was assigned, there will be a compiler error

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


* Remember, it is possible to change a constant's value before runtime
* The point is that they will not change at runtime


Arrays
======

* Java does not come with lists ready to go like Python does

    * They are not provided as a *language primitive*

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

    * Squiggly braces (``{ ... }``)  are used instead of brackets (``[ ... ]``)


* One difference is that Java arrays can't contain mixed types like a Python list

    * There is an asterisk added to this statement that will be discussed later


* One **major** difference is that the Java array used in the above example will **always** be size 4

    * One cannot simply list append to an array like with lists in Python

        * ``aList.append(34)``

* In Java, arrays have fixed sizes
* This means that one cannot start with an empty array and have it grow and grow


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
                :emphasize-lines: 2, 5, 6

                // Create a new array of size 1,000
                int[] anArray = new int[1000];

                // Put a number in each index in the array
                for(int i = 0; i < anArray.length; i++){
                    anArray[i] = i;
                }

* Mind line 2, showing how to make an empty array of a specific size

    * They will be filled with some default value (0 in this case)

* Mind line 5, showing:

    * A ``for`` loop (more on this later)
    * Arrays have an attribute ``length`` that returns the array's capacity

* Mind line 6 indexing the array in order to assign it a value


* One could make the size of the array based on some runtime determined value --- for example:

        * Reading data from a file to be stored in an array --- how big should the array be?
        * Perhaps the first line of the file contains how long the file is
        * ``String[] fileContents = new String[someValueReadIn]``

.. warning::

    In Java, it is not possible to index arrays backwards with negative values like in Python.


.. _label-java_vs_python-input_output:
Input & Output
==============

* Several of the above examples included the use of Java's standard output

    * ``System.out.print("print");``
    * ``System.out.println("print a line");``


* Standard input with Java is more verbose than Python's

    * This is because Java is not designed for console applications
    * Fortunately, the only place this is used in this course is for the Kattis problems


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


* Mind the ``import`` statements for Java
* In Java, one reads from a *stream*

    * Here the stream is the standard input (``System.in``)


* An ``InputStreamReader`` object is created

    * The thing that reads the input from the stream
    * With this, it only reads one thing at a time


* A ``BufferedReader`` is used to *buffer* the stream reader

    * To make it easier to read in more than one at a time


* Also note the use of ``try`` and ``catch`` around the ``reader.readLine()``

    * This is done because ``readLine()`` has an exception that may be thrown that you must deal with
    * Although discussed last semester, exceptions will be covered in more detail later in the course


* Like Python's ``input()``, ``readLine()`` returns a ``String``

* Alternatively, one could modify the above code to, arguably, clean it up

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


* This just passes the buck of dealing with the exception to the caller of the function/method

    * In this example, it's the ``main`` method, so this will throw the exception at the person who ran the program
    * This would cause the program to crash


Functions/Methods
=================

.. list-table:: Function/Method Definitions
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
                :emphasize-lines: 4, 9

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


* In Java, functions/methods must be explicitly told what their return type is

    * ``int`` in this example, because the value being returned is an ``int``
    * In the case where the method returns no value, the return type is set to ``void``

        * ``static void someOtherMethod( ... ) {``


* Parameters have their types included

    * ``int a`` and ``int b`` in the parameter list

* In the above example, the function is ``static``, which means it is a function and not a method

    * This is a function that belongs to the class, not an instance of the class
    * If the function is not written with ``static``, it is then an instance method
    * In other words, it's not a method we will call on an instance of some object


* As seen in the above example, the function is defined *after* it is called

    * The function ``someFunction`` is called within ``main``, but it is written below ``main``
    * This is not required in Java, but is something one could do
    * In Python, the interpreter needed to know the function existed before it could be referenced


Instance Methods
----------------

* For instance methods in Java, there is no need to include ``self`` in the parameter list

    * Although, Java has a similar keyword --- ``this``


.. list-table:: Methods
    :header-rows: 1

    * - Python
      - Java

    * -     .. code-block:: Python
                :linenos:

                def some_method(self, add_me):
                    self.some_instance_variable += add_me

      -     .. code-block:: Java
                :linenos:

                public void someMethod(int addMe) {
                    some_instance_variable += add_me
                }


Visibility Modifiers
--------------------

* In Python, there is a convention of adding an underscore (``_``) to the beginning of an attribute or method name
* This is done to indicate that the attribute or method is not to be accessed directly from outside the class
* In Java, the keywords ``public`` and ``private`` are used instead to specify attribute and method visibility
* Further, Java will produce a compiler error if one tries to access something declared to be private


.. list-table:: Visibility Modifiers
    :header-rows: 1

    * - Python
      - Java
    * -     .. code-block:: Python
                :linenos:

                def you_can_touch_me(self):
                    # ...

                def _do_not_touch_me(self):
                    # ...

      -     .. code-block:: Java
                :linenos:

                public void youCanTouchMe() {
                    // ...
                }

                private void doNotTouchMe() {
                    // ...
                }


Temperature Converter
---------------------

.. list-table:: Function/Method to Convert Fahrenheit to Celsius
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


* Pay special attention to the division taking place on like 2
* If one wrote ``5/9``, since both ``5`` and ``9`` are integers, it will do integer division
* Since integers do not have decimal values, it truncates the decimal off --- ``5/9 = 0``

    * In reality, we know it is 0.55555555555, but we are ditching everything after the decimal point


* This integer division functionality is more typical

    * In fact, Python used to work this way too, and they made people mad when they changed
    * If one truly wants floating point division, then be sure to divide floating point values



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
    static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5.0/9.0;
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

.. list-table:: Conditionals (If/Else)
    :header-rows: 1

    * - Python
      - Java

    * -     .. code-block:: Python
                :linenos:

                if some_boolean:
                    print("it was true")
                else:
                    print("it was false")

      -     .. code-block:: Java
                :linenos:

                if (someBoolean) {
                    System.out.println("it was true");
                } else {
                    System.out.println("it was false");
                }


* Both examples above assume the variable ``someBoolean`` exists and is a boolean
* Notice how, unlike Python, the condition is in parentheses in the Java example

    * ``( ... )``


Boolean Operators
-----------------

* Just like Python, Java has comparison operators that return booleans

    * less than --- ``a < b``
    * sameness --- ``c == d``
    * *not* sameness --- ``e != f``


* Logical operators also exist, but their syntax is a little different

    * and --- ``v and w`` vs ``v && w``
    * or --- ``x or y`` vs ``x || y``
    * not --- ``not z`` vs ``!z``


Loops
=====

* Just as one would expect, Java has loops too


While Loops
-----------

.. list-table:: While Loops with Counter
    :header-rows: 1

    * - Python
      - Java

    * -     .. code-block:: Python
                :linenos:

                c = 0

                # While some condition is true
                while c < 10:
                    print("c is now: " + str(c))
                    c+=1

      -     .. code-block:: Java
                :linenos:
                :emphasize-lines: 4

                int c = 0;

                // While some condition is true
                while (c < 10) {
                    System.out.println("c is now: " + c);
                    c++;
                }


* Just like the ``if`` statements, the condition is in parentheses
* Note the ``c++`` --- this is the same thing as ``c+=1``, but even shorter

    * One could still use ``c+=1`` in Java though


.. list-table:: Another While Loops Example
    :header-rows: 1

    * - Python
      - Java

    * -     .. code-block:: Python
                :linenos:

                stop = False
                c = 0

                while not stop:
                    print("c is now: " + str(c))
                    c+=1
                    if c == 5:
                        stop = True

      -     .. code-block:: Java
                :linenos:

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

* For loops in Python are effectively *for each* loops

.. list-table:: For Each Loops
    :header-rows: 1

    * - Python
      - Java

    * -     .. code-block:: Python
                :linenos:

                aList = ['a', 'b', 'c', 'd']

                # For each thing 'c' in aList
                for c in aList:
                    print(c)

      -     .. code-block:: Java
                :linenos:

                char[] anArray = {'a', 'b', 'c', 'd'};

                // For each character 'c' in anArray
                for (char c : anArray) {
                    System.out.println(c);
                }


* It's very similar, except

    * The type of ``c`` is specified
    * A colon (``:``) is used instead of ``in``


For Loop
--------

* Looping a specific number of times

.. list-table:: Counting For Loops
    :header-rows: 1

    * - Python
      - Java

    * -     .. code-block:: Python
                :linenos:

                # Run loop 10 times (0 -- 9)
                for i in range(10):
                    print(i)

      -     .. code-block:: Java
                :linenos:
                :emphasize-lines: 2

                // Run loop 10 times (0 -- 9)
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }


* In Java, the first statement within the parentheses is run once before anything loops

    * ``int i = 0``
    * Create an integer ``i`` and assign it to ``0``


* The second statement in the parentheses is the condition checked every time the loop runs

    * ``i < 10``
    * Check if ``i`` is less than ``10``
    * This could be a more general conditionals if needed


* The third statement in the parentheses runs after each time the code block in the loop finishes

    * ``i++``
    * After the body of the loop finishes a single iteration, add ``1`` to ``i``


* Overall, this says:

    * Create an ``int i`` and set it to ``0``
    * If ``i`` is less than ``10``, run the loop
    * Add ``1`` to ``i`` every time the loop runs


* In other words, this loop will run 10 times
    * ``0 -- 9``


Comparison of For Loop to While Loop
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

* It may be useful to show the comparison of a for loop to a while loop in Java

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
        loop stuff;
        step;
    }

* In the above example, both loops are doing the same thing and have the same functionality
* The only functional difference is scope
* In the for loop example, the initialized stuff only exists within the loop

    * The ``i`` in ``int = i`` cannot be accessed outside the loop
    * The initialized stuff in the while loop example will exist outside the loop


Java Conventions
================

* The following is **not** exhaustive, but here are some important Java conventions to follow

* Have one public class per file

    * Not a convention; this is required


* Class names start with capital letters

    * ``SomeClass``


* File names are the same as the class

    * ``SomeClass.java``
    * Not a convention; this is required


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

    If at any point you are thinking "Uh oh, how on earth am I going to remember all these differences?",
    `you're doing programming wrong <https://www.google.com/search?q=how+to+use+for+loops+in+java>`_.


* Practice

    * Use Kattis and solve problems you have already solved in Python, but use Java
    * `If at any point you feel stuck because you don't know how to do something in Java, I have good news for you <https://www.google.com/>`_.

* `Check out Java's code conventions <https://www.oracle.com/java/technologies/javase/codeconventions-contents.html>`_

* Read Chapter 1 of your text

    * 15 pages


* :doc:`Although outside the scope of the course, if you would like to see how a C++ differs, check out the relevant C++ lesson. </cpp/syntax/syntax>`
* :doc:`Although not part of the course, if you would like, check out the C++ lesson on pointers. </cpp/pointers/pointers>`


