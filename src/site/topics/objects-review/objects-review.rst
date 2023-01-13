**************
Objects Review
**************

* Defining objects is similar between Python and Java
* Most of the differences are syntax related


Objects and Classes
===================

* Objects are *things* that typically contain data, can do some actions, and can be acted on
* Often, when programming with Java, several objects will be interacting


Objects
-------

* All objects have

    * Properties

        * These are the data
        * These are called *fields*
        * They're variables, but they belong to an instance of an object


    * Behaviours

        * This is what the object can do
        * These are called *methods*
        * They're functions, but they belong to an object


Class
-----

* Every object belongs to a *class*

    * A *class* defines what it means to be an object of that class


* For example

    * One could think of ``Human`` as a class

        * With the fields ``firstName`` and ``lastName``
        * And methods ``eat()`` and ``goToBed()``


    * One could make Bob Smith an instance of the ``Human`` class

        * ``firstName`` is Bob
        * ``lastName`` is Smith
        *  Calling the method ``eat()`` would tell the specific instance to eat


* All objects of the same class have the same fields, but their values can differ

    * All instances of ``Human`` have ``firstName`` and ``lastName``
    * But Bob Smith's ``firstName`` is Bob
    * If there was another instance for Jane Doe, then their ``firstName`` would be Jane


* Objects of the same class have the same methods, but calling a method on an instance only calls it on *that* instance


But Why?
--------

* Classes and objects make abstraction easier

    * How many of you know exactly how your HVAC system works?
    * How many of you have ever turned up the heat in your house?


* It also makes encapsulating ideas together easier

    * Although, there are several arguments as to why this isn't always great


High-Level Idea
---------------

* A typical class will consist of

    * Fields
    * Methods
    * Constructors (which are also methods)


* In Java, class code is written in a file with the same name of the class

    * The code is written in a file with a ".java" file extension
    * The ``Human`` class would be in a file called Human.java


Contact List Example
--------------------

* It may be easier to learn these ideas with an example
* Consider the following problem

    * There is a need to keep track of the name and email address of friends
    * There is also a need to manage several friends' names and email addresses


* To do this, a class could be made to represent a friend --- ``Friend`` class
* Another class can be made to keep track of the collection of friends --- ``ContactList`` class

    * This will be covered in the following topic


Friend Class
============

* For this particular problem, the ``Friend`` class can be kept simple

    * This is a good thing


* The only information the ``Friend`` objects need to know is their

    * First Name
    * Last Name
    * Email Address


* A constructor will be be needed that describes the setup for the ``Friend`` object

    * Assigning the values to the fields


* The behaviours of the ``Friend`` class

    * A way to retrieve information from the ``Friend``
    * A way to obtain a string representation of the ``Friend``
    * A way to check if two ``Friend`` objects are equal


Setting Fields and Writing the Constructor
------------------------------------------

* The constructor is a special method that is called automatically when an object of the class is created
* Typically, setup related things that needs to happen for the object will be put in the constructor

* In Python, the ``Friend`` class' constructor and the creation and assigning of fields would look like the following

    * Remember, in Python ``self`` is used to refer to an instance of the class

.. code-block:: python
    :linenos:
    :emphasize-lines: 4

    class Friend:

        # Python --- Constructor and creating and setting fields
        def __init__(self, first_name, last_name, email):
            self.first_name = first_name
            self.last_name = last_name
            self.email = email


In Java, the class' declaration of fields, constructor, and assigning values to the fields would look like the following

.. literalinclude:: /../main/java/Friend.java
    :language: java
    :start-at: /***
    :end-before: getFirstName
    :lineno-match:
    :emphasize-lines: 8, 9, 10, 21, 22, 23



* The class is set to ``public`` so it can be accessed from any other class
* The class is also set to ``final`` since, once an instance is created, it should not change --- immutable

* The fields are declared inside the class, but not within any method

    * They can be accessed by the whole class


* To provide control over how the fields are accessed outside the class, they are set to ``private`` and ``final``

    * ``private`` means the fields are not directly accessible outside the class

        * If they were assigned ``public``, it would behave like Python


    * Although ``private``, the values of the fields will ultimately be accessible, but through accessor methods

        * Discussed in more detail below


    * The ``Friend`` class will be made in such a way that the data is immutable --- it doesn't change once set

        * Thus, the fields are set to ``final`` so they can be set once and only once


* Notice the java documentation (javadoc) comment is *above* the method
* The constructor is ``public``, has the same name as the class and file, and does not have a ``self`` parameter

    * Although Java does have a similar keyword --- ``this``


* The ``this`` in the above example let's Java resolve the ambiguity between the field and constructor parameter

    * ``this.firstName`` is the field where ``firstName`` is a local parameter for the constructor
    * It is not always necessary to use ``this`` in Java like how ``self`` is used in Python


.. note::

    Two of the major differences seen between Python and Java is the use of the visibility modifiers
    ``public``/``private`` and ``final``. This was done to tell Java that instances of this class are to be immutable.

    At first one may feel these extra keywords make the code too verbose, but consider that these extra keywords provide
    the programmer with more explicit control over how their code is or is not used. Although these keywords are not
    *necessary*, they are very powerful.


Accessors
---------

* Below are the accessor/getter methods for the fields
* All these methods do are return their respective values
* They are ``public`` as they should be accessible outside the class
* Note, however, that there are no methods to set any of the field values

    * The ``Friend`` is immutable --- can access data, but cannot change it


.. literalinclude:: /../main/java/Friend.java
    :language: java
    :start-at: getFirstName
    :end-before: toString
    :lineno-match:


* In Python, accessors were not used as one could simply access the field directly

    * ``my_friend.first_name``


* This *could* be done in Java if the fields were set to ``public``
* However, it would make it possible to modify the fields directly, which is not ideal

    * Accessors allow the data to be accessed, but not changed



``toString``
------------

* In Python, for creating a string representation of an object, the ``__repr__`` magic method was used

    * If one called ``print(some_object)``, the ``__repr__`` would automatically get called


* All classes *inherited* a ``__repr__`` for free, but the default behaviors was not all too helpful

    * ``<__main__.Friend object at 0x7f130d9c52e0>``
    * The inherited one simply provides the object name and a memory address

        * Inheritance is a topic discussed later in the course


* If one wanted to change this behaviour, they would override the default ``__repr__``
* An example of a ``__repr__`` for the ``Friend`` class in Python is below

.. code-block:: python
    :linenos:

    def __repr__(self):
        return f"Friend({self.first_name}, {self.last_name}, {self.email})"

* An f-string was used in the above example, but string concatenation could have been used

    * ``"Friend(" + self.first_name + ", " + self.last_name + ", " + self.email + ")"``


* The same principal exists in Java, but the method is called ``toString``
* The inherited behaviour is a little different --- it returns a string of the class name and the object's  *hash code*

    * `This is, more or less, a memory address of where the object is in memory <https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Object.html#hashCode()>`__
    * For example --- ``Friend@77459877``


* One can override the inherited ``toString``

.. literalinclude:: /../main/java/Friend.java
    :language: java
    :start-at: toString
    :end-at: }
    :lineno-match:


* In the above example, ``String.format`` was used, but string concatenation could have been used

    * ``"Friend(" + firstName + ", " + lastName + ", " + email + ")"``


* Like Python, ``toString`` is automatically get called when printing the object

    * ``System.out.println(aFriend);``


.. warning::

    The idea is that this *returns* a string; it does not just print something.


``equals``
----------

* Python also provides the ``__eq__`` magic method for describing equality

.. code-block:: python
    :linenos:

    def __eq__(self, other) -> bool:
        if isinstance(other, Friend):
            return self.first_name == other.first_name and \
                        self.last_name == other.last_name and \
                        self.email == other.email
        return False


* In Java, there is an ``equals`` method to define what it means for two objects to be equivalent
* However, unlike Python, it does not overload the ``==`` operator

    * ``==`` for objects is reserved for checking if two things are literally the same object -- aliases

        * Same memory address --- it compares the memory addresses


* ``equals`` is used to compare the content of the objects in some way

    * This is where equality between objects of the class is defined


* Like ``toString``, if not overridden, ``equals`` has the inherited behavior of checking sameness --- ``==``

* For the ``Friend`` class, two objects will be equal if all their fields match

.. literalinclude:: /../main/java/Friend.java
    :language: java
    :linenos:
    :lineno-start: 61
    :lines: 61-86


* There is a lot going on in this method

* First it checks if the ``Object`` ``o`` is the actual thing being compared to --- ``if (o == this)``

    * If they are aliases for the same object
    * If they are, then obviously they are equal


* It also check if it is null --- ``if (o == null)``

    * If it is null, then clearly ``this`` cannot be equal to ``o``


* It then checks if they are of the same class --- ``if (o.getClass() != this.getClass())``

    * If they are not, then they are not equal


* If the method gets to this point, it knows that ``o`` is of class ``Friend``
* It *downcast* the ``Object`` to class ``Friend``

    * This allows for accessing the fields and methods from ``Friend``


* Lastly, it check if all the attributes are equal


.. note::

    It is important to understand the difference between ``someObject == someOtherObject``,
    ``someObject.equals(someOtherObject)``, and ``Objects.equals(someObject, someOtherObject)``.

    With ``someObject == someOtherObject``, it checks if ``someObject`` and ``someOtherObject`` are referencing the same
    object -- aliases.

    ``someObject.equals(someOtherObject)`` checks if ``someObject`` and ``someOtherObject`` are equivalent based on
    ``someObject`` class' ``equals`` method.

    ``Objects.equals(someObject, someOtherObject)`` is the same as ``someObject.equals(someOtherObject)``, but makes the
    equality check *null safe*. In other words, it first checks if both ``someObject`` and ``someOtherObject`` are null,
    because then they are equal. Further, it won't produce a ``NullPointerException`` if ``someObject`` happens to be
    ``null``.
    `Have a look at the relevant javadocs <https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Objects.html#equals(java.lang.Object,java.lang.Object)>`__

    The below example makes use of the third option to be safe around ``null``, but realistically, based on the way the
    ``Friend`` class is written, it is not possible for an instance of a ``Friend`` object to be created with ``null``
    fields. In other words, the second option would be fine, but using the third option would still be more defensive.


``hashCode``
^^^^^^^^^^^^

* When properly writing the ``equals`` method, one should also write another special method --- ``hashCode()``

    * The full details on what ``hashCode`` is and what it is for is beyond the scope of this course
    * Briefly, it is a function used to convert the object into an ``int`` hash value
    * Any two objects that are equal must have the same hash value
    * Ideally, the hash value should aim to have different hashes

        * Any *unequal* objects should have different hash values
        * Unfortunately, hash *collisions* --- cases where unequal things have the same hash --- are inevitable


* Below is an example ``hashCode`` for the ``Friend`` class

    * This ``hashCode`` effectively returns the sum of the hash values of the three ``String`` attributes
    * For simple classes like the ``Friend`` class, this pattern will be typical


.. literalinclude:: /../main/java/Friend.java
    :language: java
    :linenos:
    :lineno-start: 88
    :lines: 88-91



Creating an Instance of a Friend
================================

* Below is an example of creating an instance of a ``Friend`` object based on the ``Friend`` class
* It is a simple example where an instance is created, but that is all

.. code-block:: java
    :linenos:

    public class SomeClass {
        public static void main(String[] args) {

            // Declare a Friend variable
            // Create an instance of a Friend
            // Assign the variable to reference the newly created Friend
            Friend aFriend = new Friend("Bob", "Smith", "bsmith@gmail.com");
        }
    }

* There is a bit going on:

    * Declare a variable of type ``Friend``

        * ``Friend aFriend``


    * Create an instance of a ``Friend`` object

        * ``new Friend("Bob", "Smith", "bsmith@gmail.com")``


    * Assign the variable to reference the newly created object

        * The single equals is used for assignment --- ``=``


.. note::

    Be mindful about what is *actually* stored in the ``aFriend`` variable. The object is not stored in the variable,
    but a *reference* to the object is.


        .. figure:: reference_aFriend.png
            :width: 250 px
            :align: center

            The ``aFriend`` variable holds a *reference* to an instance of a ``Friend`` object, not a ``Friend``.



* If the following line of code was run, two instances of a ``Friend`` would exist

    * ``Friend bFriend = new Friend("Jane", "Doe", "jdoe@gmail.com");``

* ``aFriend`` would have a ``firstName`` of Bob
* ``bFriend`` has a ``firstName`` of Jane

* They both have the ``firstName`` field, but the actual value associated with it differs

    .. figure:: reference_aFriend_bFriend.png
        :width: 500 px
        :align: center

        Two reference variables referencing two separate individual ``Friend`` objects.


* Below is an example of two ``Friend`` objects being created and being used

    * Get ``aFriend``\'s first name
    * Use the ``toString`` method
    * Use the ``equals`` method

.. code-block:: java
    :linenos:

    Friend aFriend = new Friend("Bob", "Smith", "bsmith@gmail.com");
    Friend bFriend = new Friend("Jane", "Doe", "jdoe@gmail.com");

    System.out.println(aFriend.getFirstName());
    System.out.println(aFriend);
    System.out.println(bFriend);
    System.out.println(aFriend.equals(bFriend));


* What is the output of the above code?



References
==========

* As noted above, be careful about what is actually stored in these variables
* The objects themselves are not stored in the variables
* Instead, references to where the objects are in memory are stored in the variables

* In the below example, ``bFriend = aFriend`` copies the contents of ``aFriend`` and puts the copy in the ``bFriend``

    * But the contents of the ``aFriend`` variable is a reference to a ``Friend``
    * The *reference* stored in ``aFriend`` gets copied; the ``Friend`` is **not** copied
    * This results in an aliases --- both ``aFriend`` and ``bFriend`` reference the exact same object


.. code-block:: java
    :linenos:
    :emphasize-lines: 4

    Friend aFriend = new Friend("Bob", "Smith", "bsmith@gmail.com");
    Friend bFriend = new Friend("Jane", "Doe", "jdoe@gmail.com");

    bFriend = aFriend;


* This also means that the object that ``bFriend`` used to point to now has no reference to it
* This would cause Java to delete the Jane ``Friend`` object

    .. figure:: reference_lost.png
        :width: 500 px
        :align: center

        The ``Friend`` object that was referenced by ``bFriend`` now has no reference to it. The ``bFriend`` reference
        variable refers to the same ``Friend`` the ``aFriend`` reference variable refers to. The ``aFriend`` and
        ``bFriend`` reference variables are aliases for the same ``Friend`` object.


.. warning::

    One may feel that the assignment works different between primitive types when compared to objects, but this is
    wrong.

    Remember what is stored in the variables --- the contents of the variables are copied. The variables may store a
    primitive type, or maybe a reference to an object. Either way, it's the variable's contents that are copied.



For Next Time
=============

* Read Chapter 1 of the text

    * 15 pages


Playing Code
============

* Download and play with

    * :download:`Friend </../main/java/Friend.java>`
