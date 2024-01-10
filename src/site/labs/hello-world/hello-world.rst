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

    .. figure:: new_class.png
        :width: 350 px
        :align: center

        Window to name the new class being created.


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



Practice IO
===========

#. Figure out how to read standard input with a BufferedReader

    * Refer to the :ref:`Java vs. Python topic <label-java_vs_python-input_output>`


#. `Figure out how to read input with a Scanner <https://www.google.com/search?q=java+scanner+example>`_


#. Write a program that will

    * Ask the user for two integers
    * Read the input
    * Sum the values and store the result in another variable
    * Print out the result


Kattis
======

.. note::

    Many will have solved these already in Python. Now try to solve these problems in Java.

    Don't know how to do things in Java?

        * :doc:`Introduction topic </topics/intro/introduction>`
        * :doc:`Java vs. Python topic </topics/java-vs-python/java-vs-python>`.


    Still stumped?

        * `Variables in Java? <https://www.google.ca/search?q=variables+in+java>`_
        * `Functions in Java? <https://www.google.ca/search?q=functions+in+java>`_
        * `If statements in Java? <https://www.google.ca/search?q=if+statements+in+java>`_
        * `Loops in Java? <https://www.google.ca/search?q=loops+in+java>`_
        * ...


.. warning::

    In Java, the name of the class and the name of the file must be the same. Thus, for Kattis to compile the Java
    submissions, the names must match. For example, the below figure shows the default file name Kattis provided as
    "hello.java" (which is not following proper convention of starting all classes with an uppercase letter) and the
    class name used in this lab --- ``Lab1``. The solution here is to either rename the file by selecting "hello.java"
    or rename the class.

    .. figure:: kattis_name.png
        :width: 600 px
        :align: center

        Example of the Hello World problem solution with non-matching class name and file name. If this were submitted
        to Kattis, it would produce a compiler error.




#. If not already done, create a *Kattis* account

    * https://open.kattis.com/
    * Specify our school as the institution

#. Login to Kattis
#. https://open.kattis.com/problems/hello
#. https://open.kattis.com/problems/carrots
#. https://open.kattis.com/problems/r2
#. https://open.kattis.com/problems/faktor
#. https://open.kattis.com/problems/ladder


If the above are completed,
`sort all the problems by difficulty and start solving <https://open.kattis.com/problems?order=problem_difficulty>`_.
