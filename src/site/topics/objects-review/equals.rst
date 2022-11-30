****************************
Aside --- Equals & Hash Code
****************************

Equals
======

* Below is an improved and more correct implementation of the ``equals`` method
* You will notice the type of the parameter has changed from ``Friend`` to ``Object``

    * The ``Object`` class is at the top of the class hierarchy
    * Every class we write will all have ``Object`` as a superclass
    * Every class we can have will actually be an ``Object``
    * More details on this will come later in the course


* Here it checks if the ``Object`` ``o`` is the actual thing being compared to --- ``if (o == this)``

    * If they are aliases for the same object
    * If they are, then obviously they are equal


* It also check if it is null --- ``if (o == null)``

    * If it is null, then clearly ``this`` cannot be equal to ``o``


* It then checks if they are of the same class --- ``if (o.getClass() != this.getClass())``

    * If they are not, then they are not equal


* If the method gets to this point, it knows that ``o`` is of class ``Friend``
* It *downcast* the ``Object`` to class ``Friend``

    * This allows for accessing the fields and methods from ``Friend``
    * Again, more on this later in the course


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


.. literalinclude:: /../main/java/Friend.java
    :language: java
    :linenos:
    :lineno-start: 61
    :lines: 61-86


* Below is an example of the ``equals`` method for the ``ContactList`` class

    * Notice that it follows the same pattern
    * The only difference is the check on what needs to be equal
    * Here, ``Arrays.equals`` is used to check the equality on the array

        * The alternative would be to loop over the array and check equality on each element within the loop
        * `Have a look at the relevant javadocs <https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Arrays.html#equals(boolean%5B%5D,int,int,boolean%5B%5D,int,int)>`__


.. literalinclude:: /../main/java/ContactList.java
    :language: java
    :linenos:
    :lineno-start: 186
    :lines: 186-203



Hash Code
=========

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


* Below is an example of the ``hashCode`` method for the ``ContactList`` class

    * Although clearly more complex than the ``Friend`` class, it still follows the same basic idea

        * Sum the hash values of all the fields
        * Although, the summing was delegated to the ``Objects`` ``hash`` function in the ``Friend`` class


* First the ``size`` value is hashed
* Then the array is iterated over and each element's hash is included to the running total that is ultimately returned
* Also notice the use of the ``Objects`` class' ``hashCode`` function

    * Like the ``Objects`` class' ``equals`` function, this is a null safe way to use the ``Friend`` class' ``hashCode``


* The value ``97`` is used to scale the result since it is a prime number

    * This increases the chance of producing a unique hash value


.. literalinclude:: /../main/java/ContactList.java
    :language: java
    :linenos:
    :lineno-start: 205
    :lines: 205-212