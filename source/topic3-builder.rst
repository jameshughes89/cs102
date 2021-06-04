**************************
Topic #3 Aside --- Builder
**************************

* Due to how Strings work, it ends up being wasteful to append to strings
    * They're *immutable**
        * Can't be changed once created
    * Every time we append, we actually create a new string object

* Instead, the ``StringBuilder`` object can be used to eliminate the extra overhead

.. code-block:: java
    :linenos:

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < friendCount; ++i) {
            builder.append(friends[i].toString());
            builder.append("\n");
        }
        return builder.toString();
    }