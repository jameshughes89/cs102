****************
Aside --- Equals
****************

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

.. code-block:: java
    :linenos:

    /**
     * Checks if two Friend objects are equal. Friend objects are considered equal if all their attributes are equal.
     *
     * @param o an "object" being compared to.
     * @return True if the two objects are equal, false otherwise.
     */
    public boolean equals(Object o) {
        // If o is actually in the same memory address of this
        if (o == this) {
            return true;
        }
        // If o is null, then it's not equal
        if (o == null) {
            return false;
        }
        // if o and this are of different classes, they're not the equal
        if (o.getClass() != this.getClass()) {
            return false;
        }
        // Cast o as a friend
        Friend other = (Friend) o;
        return Objects.equals(this.firstName, other.firstName) &&
                Objects.equals(this.lastName, other.lastName) &&
                Objects.equals(this.email, other.email);
    }