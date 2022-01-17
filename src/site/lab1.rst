******
Lab #1
******

* Feel free to use your laptop if you have it
* I strongly encourage you to work with others in the lab
* I will not be helping people setup IntelliJ on their laptops
* Ensure I have recorded your completion. Failure to do so will result in a grade of 0
* When you get stuck, do me a favour and ask those sitting around you for help
    * I want people to get used to working together in the labs
    * Peer teaching and peer learning is super effective

Creating a Project
==================

1. Open IntelliJ
2. Create a new project
    * You may see a start page
    * Or you may need to go *File -> New -> Project*
    * Don't use the templates
    * You should see something like this

    .. image:: img/lab1_empty.png
       :width: 500 px
       :align: center

3. Add a Java class to the project
    * Right click *src* in the project explorer
    * *New -> Java Class*
    * Give your class a name, something like *Lab1*
        * By convention, **always start your class names with an uppercase letter**

4. Add a ``main`` method to your class and have it do ``Hello, world!``

    .. code-block:: java

        public static void main(String[] args) {
            System.out.println("Hello, world!");
        }

5. Run your program
    * *Run -> Run*
    * You may have to select the class you want to run

    .. image:: img/lab1_helloworld.png
       :width: 500 px
       :align: center


Simple Problems
===============

1. Now see if you can figure out how to read standard in input with a BufferedReader as discussed in :ref:`topic 2 <label-topic2-java_vs_python-input_output>`

2. `See if you can figure out how to read input with a Scanner <https://www.google.com/search?q=java+scanner+example&oq=java+scanner+ex&aqs=chrome.0.0l2j69i57j0l4j0i20i263j0l2.2278j0j4&sourceid=chrome&ie=UTF-8>`_

3. Write a program that will
    * Ask the user for two integers
    * Read the input
    * Sum the values and store it in another variable
    * Print out the result


Kattis
======

0. If you have not already, create a *Kattis* account, otherwise, login
    * https://open.kattis.com/
    * Specify that StFX is your institution

.. note::

    I realize many of you will have solved these already in Python. Good, but now do it in Java.

    Don't know how to do things in Java? Check out :doc:`topic 1 </topic1>` and :doc:`topic 2 </topic2>`.

    Still stumped?
        * `Variables in Java? <https://www.google.ca/search?q=variables+in+java>`_
        * `Functions in Java? <https://www.google.ca/search?q=functions+in+java>`_
        * `If statements in Java? <https://www.google.ca/search?q=if+statements+in+java>`_
        * `Loops in Java? <https://www.google.ca/search?q=loops+in+java>`_
        * ...


1. https://open.kattis.com/problems/hello
2. https://open.kattis.com/problems/carrots
3. https://open.kattis.com/problems/r2
4. https://open.kattis.com/problems/faktor
5. https://open.kattis.com/problems/ladder

6. `If you finish all these, sort all the problems by difficulty and work your way up <https://open.kattis.com/problems?order=problem_difficulty>`_

**ENSURE WE HAVE RECORDED YOUR COMPLETION. FAILURE TO DO SO WILL RESULT IN A GRADE OF 0!**
