***********************************************
Topic #16 Aside --- Creating Our Own Exceptions
***********************************************

* We can even create our own exceptions fairly easily

.. code-block:: java
    :linenos:

    public class EmptyCollectionException extends RuntimeException {
        public EmptyCollectionException(String message) {
            super(message);
        }
    }

* Since I want my exception to be an unchecked runtime exception, I will ``extend`` the ``RuntimeException`` class
* All I really want out of my new exception is to have the specific type ``EmptyCollectionException`` and to be able to add a message to the exception

* With our new exception, we could go and replace our exceptions
    * Although, we won't

.. code-block:: java
    :linenos:

    public T peek() {
        if (isEmpty()) {
            throw new EmptyCollectionException("Peeking from an empty stack.");
        }
        return top.getData();
    }


