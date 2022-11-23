************************
Aside --- String Builder
************************

* Due how ``String`` objects work, it ends up being wasteful to continually append to strings

    * ``String`` objects are *immutable*

        * They cannot be changed once they are created

    * When appending, a new ``String`` object needs to be created


* An alternative to continually appending to a ``String`` is a ``StringBuilder``, which eliminates the extra overhead
* See the below example of the ``ContactList`` class' ``toString`` that makes use of a ``StringBuilder``

.. code-block:: java
    :linenos:
    :emphasize-lines: 4

        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < size(); i++) {
                builder.append(friends[i].toString());
                builder.append("\n");
            }
            return builder.toString();
        }