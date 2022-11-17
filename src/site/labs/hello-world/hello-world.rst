***********
Hello World
***********

* Feel free to use your laptop if you have it
* I strongly encourage you to work with others in the lab

    * When you get stuck, do me a favour and ask those sitting around you for help
    * I want people to get used to working together in the labs
    * Peer teaching and peer learning is super effective


Creating a Project
==================

#. Open IntelliJ


#. Create a new project
    * You may see a start page
    * Or you may need to go *File -> New -> Project*
    * Don't use the templates
    * You should see something like this

    .. image:: empty_project.png
       :width: 500 px
       :align: center


#. Add a Java class to the project
    * Right click *src* in the project explorer
    * *New -> Java Class*
    * Give your class a name, something like *Lab1*

        * By convention, **always start your class names with an uppercase letter**


#. Add a ``main`` method to your class and have it do ``Hello, world!``

    .. code-block:: java

        public static void main(String[] args) {
            System.out.println("Hello, world!");
        }


#. Run your program
    * *Run -> Run*
    * You may have to select the class you want to run

    .. image:: hello_world_project.png
       :width: 500 px
       :align: center


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
