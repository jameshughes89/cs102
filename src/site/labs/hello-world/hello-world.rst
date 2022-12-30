***********
Hello World
***********

* Feel free to use your laptop
* You are strongly encourage to work with others

    * When you get stuck, ask those sitting around you for help
    * Get used to working together in the labs
    * Peer teaching and peer learning has been empirically shown to be very effective



Creating a Project
==================

#. Open IntelliJ

#. Create a new project

    * A start page may be shown with an option to create a new project
    * Or an existing project may be shown

        * If this is the case, select *File -> New -> Project*


    * After selecting new project, something like the following figure should be displayed

        .. figure:: new_project.png
            :width: 500 px
            :align: center

            New project screen with appropriate settings selected. This figures shows the project named "csci162-labs"
            being created and saved to the desktop, but it is recommended to save the project to a more fitting
            location.


    * After selecting "Create", something like the following figure should be displayed

        .. figure:: empty_project.png
            :width: 600 px
            :align: center

            IntelliJ displaying the contents of a new project called "csci162-labs".


#. Add a Java class to the project

    * Right click *src* in the project explorer on left hand side of the window
    * Select *New -> Java Class*
    * Give the class a name, something like *Lab1*

        * By convention, **always start your class names with an uppercase letter**


#. Add a ``main`` method to the class and have it run ``Hello, world!``

    * Below is an example of hello world that can be copied and pasted into the class

        .. code-block:: java

            public static void main(String[] args) {
                System.out.println("Hello, world!");
            }


#. Run the program

    * Select *Run -> Run*

        * One may have to select the class you want to run
        * Alternatively, select the green play triangle next to the main method by the line numbers

        .. figure:: hello_world_project.png
            :width: 600 px
            :align: center

            IntelliJ after the hello world program was executed. Note the ``Hello, World!`` output near the bottom of
            the window as this was the result of the program.



Simple Problems
===============

#. Figure out how to read standard input with a BufferedReader

    * Refer to the :ref:`Java vs. Python topic <label-java_vs_python-input_output>`


#. `See if you can figure out how to read input with a Scanner <https://www.google.com/search?q=java+scanner+example>`_


#. Write a program that will

    * Ask the user for two integers
    * Read the input
    * Sum the values and store it in another variable
    * Print out the result


Kattis
======

.. note::

    I realize many of you will have solved these already in Python. Good, but now do it in Java.

    Don't know how to do things in Java?
    Check out the :doc:`Introduction topic </topics/intro/introduction>`
    and the :doc:`Java vs. Python topic </topics/java-vs-python/java-vs-python>`.

    Still stumped?

        * `Variables in Java? <https://www.google.ca/search?q=variables+in+java>`_
        * `Functions in Java? <https://www.google.ca/search?q=functions+in+java>`_
        * `If statements in Java? <https://www.google.ca/search?q=if+statements+in+java>`_
        * `Loops in Java? <https://www.google.ca/search?q=loops+in+java>`_
        * ...

#. If you have not already, create a *Kattis* account, otherwise, login

    * https://open.kattis.com/
    * Specify that StFX is your institution

#. https://open.kattis.com/problems/hello
#. https://open.kattis.com/problems/carrots
#. https://open.kattis.com/problems/r2
#. https://open.kattis.com/problems/faktor
#. https://open.kattis.com/problems/ladder
#. `If you finish all these, sort all the problems by difficulty and work your way up <https://open.kattis.com/problems?order=problem_difficulty>`_
