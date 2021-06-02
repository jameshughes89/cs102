***************************
Topic #3 --- Objects Review
***************************

* Let's review the idea of objects


Objects and Classes
===================

* Objects are *things* that typically know stuff, can do actions, and can be acted on
* Often, when programming with Java, we will have interacting objects

Objects
-------

* All objects have
    * **Properties**
        * These are the *data*
        * These are called *fields*
        * They're variables, but they belong to an object

    * **Behaviours**
        * This is what the object can do
        * These are called **methods**
        * They're functions, but they belong to an object

Class
-----

* Every object belongs to a *class*
    * A *class* defines what it means to be an object of that class

* For example
    * We can think of ``Human`` as a class
        * With the fields ``firstName`` and ``lastName``
        * And methods ``eat()`` and ``goToBed()``

    * We can make Bob Smith an instance of the ``Human`` class
        * ``firstName`` is Bob
        * ``lastName`` is Smith

* All objects of the same class have the same fields, but their values can differ
    * All instances of ``Human`` have ``firstName`` and ``lastName``
    * But Bob Smith's ``firstName`` is Bob
    * If we made an instance for Jane Doe, then their ``firstName`` would be Jane


But Why?
--------

* Classes and objects make abstraction pretty easy
    * How many of you know exactly how an internal combustion engine works?
    * How many of you drove here today in a car with an internal combustion engine?

* It also lets us encapsulate ideas together
    * Although, there are arguments as to why this isn't great


High-Level Idea
---------------

* Your typical class will consist of
    * Fields
    * Methods
    * Constructors (which are also methods)

* In Java, we write our class code in a file with the same name as the class with the file extension being .java
    * The ``Human`` class would be in a file called Human.java

Contact List Example
====================

* The above is very high-level
* It may be easiest to learn with an example
* Let's say we want to write a program to keep track of the contact information of our friends
* I will make a class that will define what a ``Friend`` is
* I will make another class that will define how we will manage a collection of ``Friend`` objects

.. warning::

    The example may not make complete sense until it comes together in the end.


Friend Class
------------

* What type of information should our ``Friend`` class keep track of?
    * First Name
    * Last Name
    * Email Address
    * ...

* We know we need a constructor, which was ``__init__`` in Python

* What behaviours should our ``Friend`` instances have?
    * Hmmmmmm....
    * Well, based on what I remember from Python, we should have
        * accessors and mutators
            * getters and setters
        * the ``__repr__`` thing?
        * ``__eq__``?


Setting Fields and Writing the Constructor
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

* The constructor is a special method that is called automatically when an object of the class is created
* We'd typically setup stuff that needs to be setup for an instance of the class in the constructor

**Python**

.. code-block:: python
    :linenos:
    :emphasize-lines: 5

    class Friend:

        # Python --- Constructor and
        # creating and setting fields
        def __init__(self, first_name, last_name, email):
            self.first_name = first_name
            self.last_name = last_name
            self.email = email

* Remember, in Python we use ``self`` to refer to an instance of the class


**Java**

.. code-block:: java
    :linenos:
    :emphasize-lines: 4,5,6,10,11,12

    public class Friend {

        // Class Attribute Declaration
        private String firstName;
        private String lastName;
        private String email;

        // Constructor and assigning fields
        public Friend(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }
    }

* The class is set to ``public`` so we can access it from any other class
* We define the fields to have scope to the class
    * So they are accessible to the whole class

* The fields are ``private`` since we want to control how these fields are used
* The constructor is ``public``, has the same name as the class, and does not have a ``self`` parameter
* The ``this`` in the above example let's Java resolve the ambiguity
    * ``this.firstName`` is the class attribute where ``firstName`` is a local parameter for the constructor
    * It is not always necessary to use ``this`` in Java like how we use ``self`` in Python


Getters and Setters
^^^^^^^^^^^^^^^^^^^

**Java**

.. code-block:: java
    :linenos:
    :emphasize-lines: 2

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

* Getter and setter for ``firstName``
    * Would be the same for ``lastName``

* Notice that we do not need the ``this`` in front of ``firstName``

* You may still feel like making the fields private and then writing the getters and setters is silly
    * Honestly, in this example, it likely is a bad idea
    * We will revisit the use of the getters and setters in this class later

* Here is a contrived example to show where the use of a setter can check the data first before making a change


**Java**

.. code-block:: java
    :linenos:
    :emphasize-lines: 2

    /**
     * Update the email address. Will only work if the email address
     * contains the @ symbol for simple data correctness check
     *
     * @param email     new email address
     */
    public void setEmail(String email) {
        if (email.contains("@")) {
            this.email = email;
        }
    }

toString
^^^^^^^^



equals
^^^^^^



Contact List Class
------------------



What We Get
===========

* Modularity
    * Break a problem down into smaller components
    * Ideally, these components should be independent from each other
    * Each component performs a well defined task
    * We encapsulate data and behaviours together

* Information Hiding
    * Hide some of the implementation details
    * It can protect important pieces of the system from being modified by others bits
    * It gives us some control over how our code is used
    * For example
        * You all used Python lists, but you didn't know any of their implementation details
        * And it didn't matter!

For next time
=============

* Read Chapter X of your text