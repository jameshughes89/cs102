**************
Objects Review
**************

* Defining objects and data structures is similar between Python and Java
* Most of the differences are syntax related


Objects and Classes
===================

* Objects are *things* that typically contain data, can do some actions, and can be acted on
* Often, when programming with Java, several objects will be interacting


Objects
-------

* All objects have

    * Properties

        * These are the *data*
        * These are called *fields*
        * They're variables, but they belong to an instance of an object


    * Behaviours

        * This is what the object can do
        * These are called **methods**
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
====================

* It may be easier to learn these ideas with an example
* Let's consider the following problem

    * There is a need to keep track of the name and email address of friends
    * There is also a need to manage several friends' names and email addresses


* To do this, a class could be made to represent a friend --- ``Friend`` class
* Another class can be made to keep track of the collection of friends --- ``ContactList`` class


Friend Class
------------

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
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

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
    :linenos:
    :lineno-start: 3
    :lines: 3-27
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

* You may remember that ``__repr__`` in python was a special method that would return a string version of the object
    * And, if you called ``print(some_object)``, the ``__repr__`` would automatically get called

* When we wrote our own classes, we ended up overriding the ``__repr__`` we got for free
    * The default one simply prints out the object name and a memory address, which wasn't very helpful
    * ``<__main__.Friend object at 0x7f130d9c52e0>``
    * *Technically*, the behaviour we get for free is inherited from the closest "super" class
        * We will learn more about this later

* An example of a ``__repr__`` for our ``Friend`` class might look something like this
* We just print out the name of the ``Friend`` and their email

**Python**

.. code-block:: python
    :linenos:

    # Python --- __repr__
    def __repr__(self):
        return self._first_name + " " + self._last_name \
               + ":\t" + self._email


* We can do the same thing in Java, but in java it's called ``toString()``
* If we do not write our own, the default behaviour is to return a string of the class name and a *hash code*
    * ``Friend@77459877``
    * Again, *technically* the behaviour we get for free is inherited

.. code-block:: java
    :linenos:

        public String toString() {
            return firstName + " " + lastName + ":\t" + email;
        }

* And like Python, we can simply print it and ``toString`` will automatically get called
    * ``System.out.println(aFriend);``

.. warning::

    The idea is that this *returns* a string; we do not want to just print something


equals
^^^^^^

* We had another special function that we liked to use called ``__eq__``
* ``__eq__`` let us define what it means for two of the objects to be equivalent
* It also let us call ``==`` on the objects too

* In Java, we use the ``equals()`` method to define what it means for two of the objects to be equivalent
* **HOWEVER**, unlike Python, this doesn't overload the ``==`` operator
    * ``==`` for the objects is reserved to check if the objects are literally the same object
    * Same memory address --- it compares the memory addresses

* On the other hand, ``.equals()`` is used to actually compare the content of the objects in some way
    * We need to think about what it means for two objects of the type to be &equivalent*

* The default behaviour is to is to check if the objects are in the same memory address (``==``)
    * Similar to ``toString``, the behaviour we get for free is inherited


* So, what should it mean for two ``Friend`` objects to be *equal*?
* Well, **we** get to define this
* We can make it whatever we want
    * Same eye colour?
    * Same height and weight?
    * Same number of skin cells?

* But, we need to really think about what makes sense in our context
    * Let's go with their ``firstName`` and ``lastName`` being equal
        * Although, this example is perhaps still not overly great

.. code-block:: java
    :linenos:

        /**
         * Sample equals method for comparing two friend objects.
         * In this example, we will simply compare first and last
         * names.
         *
         * This example is deliberately kept very simple
         *
         * @return      if the two friend objects are equal
         */
        public boolean equals(Friend other) {
            return this.firstName.equals(other.firstName)
                    && this.lastName.equals(other.lastName);
        }

* Notice how we actually use the string's ``equals`` too
* In the above example, using ``this`` is not necessary, but may be helpful in eliminating ambiguity

.. warning::

    The example ``equals()`` included in the ``Friend.java`` file is a little more complex,
    but is a more complete and correct ``equals``. :doc:`See this aside for more details. <equals>`


Creating an Instance of a Friend
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

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

* Here's an example of us actually creating an instance of the ``Friend`` class
* This is a really really really simple example where we create it and do nothing with it

* There is a bit going on here:
    * Declare a ``Friend`` variable
        * ``Friend aFriend``
    * Create an instance of a ``Friend``
        * ``new Friend("Bob", "Smith", "bsmith@gmail.com")``
    * Assign the variable to reference the newly created object
        * The equals bit
        * We have to be careful about what is actually stored in the ``aFriend``

        .. image:: reference_aFriend.png
           :width: 250 px
           :align: center



* If I were to write another line of code like this
    * ``Friend bFriend = new Friend("Jane", "Doe", "jdoe@gmail.com");``
* ``aFriend`` would have a ``firstName`` of Bob
* ``bFriend`` has a ``firstName`` of Jane
* They both have the ``firstName`` field, but the actual value associated with it differs

    .. image:: reference_aFriend_bFriend.png
       :width: 500 px
       :align: center


* Below is an example of two ``Friend`` objects being created and being used
    * We get ``aFriend``'s first name
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


* What do you think the output of this would be?


References
^^^^^^^^^^

* We have to be careful about what is actually stored in these variables
* We're not storing the object in that variable --- we store a reference to where the object is in memory

.. code-block:: java
    :linenos:
    :emphasize-lines: 4

    Friend aFriend = new Friend("Bob", "Smith", "bsmith@gmail.com");
    Friend bFriend = new Friend("Jane", "Doe", "jdoe@gmail.com");

    bFriend = aFriend;


* In the above example, ``bFriend = aFriend`` copies the contents of ``aFriend`` and puts the copy in ``bFriend``
    * So, the reference stored in ``aFriend`` gets copied

* This also means that the object that ``bFriend`` used to point to now has no reference to it

    .. image:: reference_lost.png
       :width: 500 px
       :align: center

.. warning::

    You may think that assignment works differently for primitive types when compared and objects,
    but, think about what is actually stored in the variable.


Contact List Class
------------------

* We need a way to keep track of our ``Friend`` objects
* To do this, we will make a new class called ``ContactList``
* What fields should this have?
    * A list of the ``Friends`` we're keeping track of
        * For this we can use an array
    * A count of how many ``Friend`` objects our ``ContactList`` contains
        * Just an ``int``


Setting Fields and Writing the Constructor
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

* In the below examples, ``class ContactList:`` and ``public class ContactList {`` are excluded

**Python**

.. code-block:: python
    :linenos:

    def __init__(self):
        self._friend_count = 0
        self._friends = []


* In this Python example, keeping track of ``_friend_count`` is perhaps not necessary since we can simply use ``len(self._friends)``
* We can keep appending and appending to our ``_friends`` list

**Java**

.. code-block:: java
    :linenos:

    public class ContactList {

        static final int DEFAULT_CAPACITY = 10;

        private int friendCount;
        private Friend[] friends;

        public ContactList() {
            friendCount = 0;
            friends = new Friend[DEFAULT_CAPACITY];
        }

        public ContactList(int capacity) {
            friendCount = 0;
            friends = new Friend[capacity];
        }
    }


* First, notice that we actually wrote two constructors
    * Overloading
    * We can even do something called :doc:`constructor chaining <chaining>`

* Since arrays have a fixed size, our strategy here is to make an array with a sufficiently large size, but only use what we need
* The first constructor will make use of some constant value set in the class to make the array
* The second will take a capacity as a parameter and make the array that size

* If we create a ``ContactList`` object
    * ``ContactList contacts = new ContactList(5);``

* We will have something like this created

    .. image:: contacts.png
       :width: 600 px
       :align: center


Adding Friends
^^^^^^^^^^^^^^

**Python**

.. code-block:: python
    :linenos:

    def add(self, first_name, last_name, email):
        # Make the friend object
        new_friend = Friend(first_name, last_name, email)

        # Append friend to our friends list
        # and update friend count
        self._friends.append(new_friend)
        self._friends_count += 1


**Java**

.. code-block:: java
    :linenos:
    :emphasize-lines: 16, 17, 18

        /**
         * Add a new friend to the friends array. Will create an instance
         * of a Friend based on parameters. If our array runs out of space
         * we will expand capacity to manage the situation.
         *
         * @param firstName     friends first name
         * @param lastName      friends last name
         * @param email         friends email address
         */
        public void add(String firstName, String lastName, String email) {
            // Create the Friend object
            Friend newFriend = new Friend(firstName, lastName, email);

            // If we have run out of space in our array
            // we need to deal with it
            if (friendCount == friends.length) {
                expandCapacity();
            }
            // Add friend to the next available spot
            friends[friendCount] = newFriend;
            friendCount++;
        }

        private void expandCapacity() {
            // Make a new array of twice the size of the previous
            Friend[] newFriends = new Friend[friends.length * 2];

            // Copy over the contents of the friends list
            // to the new bigger friends list
            for(int i = 0; i < friends.length; ++i) {
                newFriends[i] = friends[i];
            }
            // Have friends now reference the new friends
            friends = newFriends;
        }

* You may notice that ``friendCount`` plays double duty here --- friends count and next available spot in the array

* Since our array has a fixed size, we can't simply keep adding to it
* Our solution is to ``expandCapacity``
    1. Create a new array twice as big as the original
    2. Copy over the contents of the original array to the new bigger array
        * `You could also use this instead <https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Arrays.html#copyOf(T%5B%5D,int)>`_
    3. Make out friends array now reference the new bigger array

.. image:: expand_capacity.png
       :width: 600 px
       :align: center

* The ``expandCapacity`` method gets called automatically by the ``add`` method if our array has run out of space
* If the array had enough room, ``expandCapacity`` is never called
* Either way, when we add the ``newFriend`` to our array, we are now guaranteed to have room

* You will also see that the ``expandCapacity`` method is ``private``
    * This method is important for the inner workings of the ``ContactList`` class
    * This method is not something I want the user of my class to care about
        * Abstraction


Remove Friends
^^^^^^^^^^^^^^

**Java**

.. code-block:: java
    :linenos:
    :emphasize-lines: 8, 11

        public void remove(String firstName, String lastName) {
            // Create a temp friend object for easy
            // use of the Friend class' equals()
            Friend toDelete = new Friend(firstName, lastName, "");

            // Linear search for the friend we are trying to delete
            for (int i = 0; i < friendCount; ++i) {
                if (toDelete.equals(friends[i])) {
                    // Have friend at the end of the array be referenced
                    // by the array index we removed from
                    friends[i] = friends[friendCount - 1];
                    friends[friendCount - 1] = null;
                    friendCount--;
                }
            }
        }

* We'll create a temporary ``Friend`` based on the parameters so we can make use of our ``Friend`` class' ``.equals``
* To remove the ``Friend`` all we need to do it lose reference to it
    * Garbage
* In the above example, we made the array at the index of the removed ``Friend`` to reference the ``Friend`` at the end of the array
    * ``friendCount - 1``
* After this, the array has no reference to the ``Friend`` that was removed

* You may notice that the array at index ``friendCount - 1`` is set to ``null``
    * This is done to deal with the edge case of removing the last friend

* You may also notice that this method, as it is written, will not do anything special if the ``Friend`` we try to remove does not exist
* What should we do in this scenario?
    * Ignore it?
    * Return a boolean?
    * Crash the program?
    * Explode?

* This will be discussed further a little later in the course

.. image:: remove.png
       :width: 600 px
       :align: center

.. warning::

    There is actually a bug in the above ``remove`` example. This is addressed below, but see if you can spot the bug
    yourself. **Hint:** It has to do with having multiple equal ``Friend`` objects in the ``friends`` array.


Update Friend's Email
^^^^^^^^^^^^^^^^^^^^^

.. code-block:: java
    :linenos:

        public void updateEmail(String firstName, String lastName, String newEmail) {
            // Create a temp friend object for easy
            // use of the Friend class' equals()
            Friend toUpdate = new Friend(firstName, lastName, "");

            // Linear search for the friend we are trying to update
            for (int i = 0; i < friendCount; ++i) {
                if (toUpdate.equals(friends[i])) {
                    friends[i].setEmail(newEmail);
                }
            }
        }


Index Of Friend
^^^^^^^^^^^^^^^

* You may have noticed that ``remove`` and ``updateEmail`` look very similar
* Perhaps we should make another method called ``indexOf`` that does a linear search through the array
* If we find the thing, we'll return its index, otherwise return -1

.. code-block:: java
    :linenos:
    :emphasize-lines: 18, 29

        public int indexOf(String firstName, String lastName) {
            // Create a temp friend object for easy
            // use of the Friend class' equals()
            Friend toFind = new Friend(firstName, lastName, "");

            // Linear search for the friend we are trying to find
            for (int i = 0; i < friendCount; ++i) {
                if (toFind.equals(friends[i])) {
                    return i;
                }
            }
            // -1 will signify that we didn't find
            // what we were looking for
            return -1;
        }

        public void remove(String firstName, String lastName) {
            int friendIndex = indexOf(firstName, lastName);
            if (friendIndex != -1) {
                // Have friend at the end of the array be referenced
                // by the array index we removed from
                friends[friendIndex] = friends[friendCount - 1];
                friends[friendCount - 1] = null;
                friendCount--;
            }
        }

        public void updateEmail(String firstName, String lastName, String newEmail) {
            int friendIndex = indexOf(firstName, lastName);
            if (friendIndex != -1) {
                friends[friendIndex].setEmail(newEmail);
            }
        }

.. warning::

    The above change actually altered the functionality of the ``remove`` and ``updateEmail`` methods.
    Try to figure out what has changed. Is this change good or bad? **Hint:** What happens if there are
    multiple ``Friend`` objects with the same ``firstName`` and ``lastName``?

    The bug mentioned under ``remove`` has to do with duplicates getting missed in the removal process. This can happen when the
    element at index ``i`` is being replaced with a reference to something that just so happens to be a duplicate. This
    would then cause this item to be skipped because ``i`` is immediately incremented after the replacement.


Get
^^^

* We will want a method to return an actual ``Friend`` object based on a given index

.. code-block:: java
    :linenos:
    :emphasize-lines: 3

        public Friend get(int index) {
            // Make sure the index provided is valid
            if (index > -1 && index < friendCount) {
                return friends[index];
            } else {
                return null;
            }
        }

* Realistically, the check on the index here could be much better, but we will talk about this stuff later in the course

* We could overload ``get`` and add another version that will take the ``firstName`` and ``lastName`` of a ``Friend`` and return that ``Friend``

.. code-block:: java
    :linenos:

        public Friend get(String firstName, String lastName) {
            int index = indexOf(firstName, lastName);
            return get(index);
        }

* Easy to write since we make use of the functions that exist that do all the work for us already


Clear Friends
^^^^^^^^^^^^^

.. code-block:: java
    :linenos:

        public void clear() {
            friends = new Friend[friends.length];
            friendCount = 0;
        }

* For this, just make a new, empty array of the same size of the original array
* Since the old array referenced by ``friends`` has no more reference, it get managed by the garbage collector

* We could have gone through the array and set each index to reference ``null``, but the above is easier



toString
^^^^^^^^

* What should the string representation of our ``ContactList`` class be?
* How about we simply print out the friend's information, one per line
* To make a ``toString`` for the ``ContactList`` class


.. code-block:: java
    :linenos:
    :emphasize-lines: 4

        public String toString() {
            String s = "";
            for (int i = 0; i < friendCount; ++i) {
                s = s + friends[i].toString() + "\n";
            }
            return s;
        }

* Notice that we can actually make good use of the ``Friend`` class' ``toString`` method


.. warning::

    Although the above example is correct, in practice we'd want to use something called a ``StringBuilder``.
    :doc:`See this aside for more details. <builder>`


Friend Count
^^^^^^^^^^^^

* We will want to be able to know how many ``Friend`` objects we have in our ``ContactList``
* Basically a getter for the ``friendCount`` field

.. code-block:: java
    :linenos:

        public int size() {
            return friendCount;
        }


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

* Assuming you have not done it, read Chapter 1 of your text
    * 15 pages


Playing Code
============

* Download and play with
    * :download:`Friend </../main/java/Friend.java>`
    * :download:`ContactList </../main/java/ContactList.java>` code
    * :download:`PlayingObjects </../main/java/PlayingObjects.java>`

* If everything was done correctly, the following code from ``PlayingObjects`` should work

.. literalinclude:: /../main/java/PlayingObjects.java
   :language: java
   :linenos:
