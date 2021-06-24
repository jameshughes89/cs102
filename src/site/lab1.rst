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
        * **Always start your class names with an uppercase letter**

4. Add a ``main`` method to your class and have it do ``Hello, world!``

    .. code-block:: java
        :linenos:

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

1. `Now see if you can figure out how to read standard in input with a BufferedReader <https://people.stfx.ca/jhughes/cs162/topic2.html#input-output>`_

2. `See if you can figure out how to read input with a Scanner <https://www.google.com/search?q=java+scanner+example&oq=java+scanner+ex&aqs=chrome.0.0l2j69i57j0l4j0i20i263j0l2.2278j0j4&sourceid=chrome&ie=UTF-8>`_

3. Write a program that will
    * Ask the user for two integers
    * Read the input
    * Sum the values and store it in another variable
    * Print out the result

**ENSURE WE HAVE RECORDED YOUR COMPLETION. FAILURE TO DO SO WILL RESULT IN A GRADE OF 0!**
