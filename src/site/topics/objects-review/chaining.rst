******************************
Aside --- Constructor Chaining
******************************

* Constructor Chaining allows a constructor to call another constructor
* In the below example, when ``this(DEFAULT_CAPACITY)`` is called, it actually calls the constructor that takes an int
* This then has the second constructor do the work

.. note::

    The call to ``this`` must be first statement in the constructor body.


.. code-block:: java
    :linenos:
    :emphasize-lines: 3

        public ContactList() {
            // Calls the constructor that takes an int as parameter
            this(DEFAULT_CAPACITY);
        }

        public ContactList(int capacity) {
            size = 0;
            friends = new Friend[capacity];
        }