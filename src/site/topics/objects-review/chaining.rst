***************************************
Topic #3 Aside --- Constructor Chaining
***************************************

* Constructor Chaining allows us to call a constructor from another constructor
* In the below example, when we call ``this(MAX_CAPACITY)``, we're actually calling the second constructor
* This then has the second constructor do the work

.. code-block:: java
    :linenos:
    :emphasize-lines: 4

        public ContactList() {
            // Call the constructor that
            // takes an int as param
            this(DEFAULT_CAPACITY);
        }

        public ContactList(int capacity) {
            friendCount = 0;
            friends = new Friend[capacity];
        }