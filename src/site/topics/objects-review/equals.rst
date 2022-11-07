*************************
Topic #3 Aside --- Equals
*************************

* Below is a better and more correct implementation of the ``equals`` method
* You will notice the type of the parameter has changed from ``Friend`` too ``Object``
    * The ``Object`` class is at the top of the class hierarchy
    * Every class we write will all have ``Object`` as a superclass
    * Every class we can have will actually be an ``Object``
    * The more details on this will come later in the course

* Here you will see that we check if the ``Object o`` is the actual thing we are comparing to
    * Then obviously they are equal

* We also check if it is null
    * If it is null, then clearly ``this`` cannot be equal to ``o``

* We check if they are of the same class or not
    * If they are not, we say they are not equal

* We then need to *downcast* the ``Object`` to something of class ``Friend``
    * This lets us access the fields and methods for ``Friend`` from ``o``
    * Again, more on this later in the course

* Lastly, we check if the ``firstName`` and ``lastName`` are the same

.. code-block:: java
    :linenos:

        /**
         * Sample equals method for comparing two friend objects.
         * In this example, we will simply compare first and last
         * names.
         *
         * @param o     an "object" being compared to
         *
         * @return      if the two friend objects are equal
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
            // if o and this are of different classes, they're not the same
            if (o.getClass() != this.getClass()) {
                return false;
            }
            // Cast o as a friend
            Friend other = (Friend) o;
            return this.firstName.equals(other.firstName)
                    && this.lastName.equals(other.lastName);
        }