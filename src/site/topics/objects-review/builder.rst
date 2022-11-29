************************
Aside --- String Builder
************************

* Due how ``String`` objects work, it ends up being wasteful to continually append to strings

    * ``String`` objects are *immutable*

        * They cannot be changed once they are created

    * When appending, a new ``String`` object needs to be created


* An alternative to continually appending to a ``String`` is a ``StringBuilder``, which eliminates the extra overhead
* See the below example of the ``ContactList`` class' ``toString`` that makes use of a ``StringBuilder``

.. literalinclude:: /../main/java/ContactList.java
    :language: java
    :linenos:
    :lineno-start: 177
    :lines: 177-184
    :emphasize-lines: 4


.. note::

    In the above example, the instances of ``Friend`` objects are not having their ``.toString()`` methods called.
    This is unnecessary here since the ``StringBuilder`` object's ``append`` method would call this automatically.