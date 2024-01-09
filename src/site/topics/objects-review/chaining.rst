******************************
Aside --- Constructor Chaining
******************************

* Constructor Chaining allows a constructor to call another constructor
* In the below example, when ``this(DEFAULT_CAPACITY)`` is called, it actually calls the constructor that takes an int
* This then has the second constructor do the work

.. note::

    The call to ``this`` must be first statement in the constructor body.


.. literalinclude:: /../main/java/ContactList.java
    :language: java
    :linenos:
    :emphasize-lines: 6
    :start-at: public ContactList() {
    :end-before: // [end-class_fields_constructor]

