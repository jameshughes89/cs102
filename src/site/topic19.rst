***********************
Topic #19 --- Recursion
***********************

|lineA| |lineB| |lineC|

.. |lineA| image:: img/recursion_line.png
    :width: 25%

.. |lineB| image:: img/recursion_line.png
    :width: 25%

.. |lineC| image:: img/recursion_line.png
    :width: 25%

* How many people are in this line?
    * How would you count them?

* I'd say the answer is, just by looking at the first person, it's exactly ``1 +`` the number of people after the first person


Iterative Definition vs. Recursive Definition
=============================================

* Iterative definitions of things are fairly natural for us
* Recursion on the other hand may *feel* a little less natural, but it pops up a lot in our lives and in nature
* Debugging can sometimes feel a little recursive
    * Ever been debugging to deal with bug ``a``
    * Then notice that to solve it, you need to fix ``b``
    * Then, to fix ``b``, you need to resolve ``c``
    * Once ``c`` is fixed, you can fix ``b``
    * Since ``b`` is fixed, you can finally finish ``a``


Groups of People
----------------

* Like the line of people example above, it may seem like a silly question because it is so intuitive

* A group of people is:
    * 2 people
    * OR 2 people
    * OR 3 people
    * OR 4 people
    * OR ...
    * ...
    * ...

* Alternatively, we can use the idea of recursion to define a group of people a different way
* When we use recursion to define something, we use the definition of itself in it's definition
    * Define something in terms of itself

* Recursive definition of a **group of people** is:
    * 2 people
    * OR a **group of people** plus one more person

* Based on this definition, if I ask you if 2 people are a **group of people**, the answer is clearly yes (the first point)
* But if I ask you if 4 people is a **group of people**, we need to do some digging
    * In order to tell you if 4 people is a **group of people**, I need to know if 3 people is a **group of people**
        * If 3 is, then I know 4 is since 4 is then be a **group of people** plus one more person
    * To know if 3 people is a **group of people**, I must know if 2 people is a **group of people**
    * I know, by definition, that 2 people is, in fact, a **group of people**
    * Therefore, I know that 3 people is a **group of people**
    * Thus, 4 people must be a **group of people**

* In the above recursive example, you will notice a **base case** and a **recursive** case
    * The base case is something with a clear definition
    * The recursive case is one that defines itself in terms of itself


.. warning::

    Although there is no **hard** rule saying that you need a base case, and there are examples of situations where you
    would not include one, not including a base case is a recipe for disaster. Remember ``uhOh()`` from topic 18?

    For our purposes in this course, always include your base case.


Lists
-----

* Think of a list from Python, or a linear linked structure
* We can define this recursively in a rather natural way

* A list is:
    * **Base Case** --- an empty list
    * **Recursive Case** --- There is a head of the list, followed by a tail that's a list

* Consider the following list

    ``[a, b, c, d, e]``

* This can be broken down into the head ``a`` and the tail ``[b, c, d, e]``

    ``a + [b, c, d, e]``

* Further, we can break the tail list down again and again and again until we hit an empty list

    ``a + b + [c, d, e]``
    ``a + b + c + [d, e]``
    ``a + b + c + d + [e]``
    ``a + b + c + d + e + []``


Recursion
=========


Going Up and Down
-----------------


Factorial
---------


Recursive Programming
=====================


Factorial
---------


Observations
============


Computational Complexity
========================

* When analysing iterative code, one of the tricks was to think about how many operations will be needed relative to an input size ``n`` and how much the amount of work done scales as we change ``n``

* When looking at ``iterativeFactorial(n)``
    * We see there are a few constant time operations (do not depend on ``n``)
    * But we see the loop running constant time work that runs ``n`` times
    * Therefore, :math:`O(n)`

* When analyzing recursive functions, the idea is the same --- how many operations will be needed relative to an input size ``n`` and how much the amount of work done scales as we change ``n``

* When looking at ``recursiveFactorial(n)``
    * We see there are constant time operations
    * We also see the recursive call, which means the code inside this function can run repeatedly
    * The question then is, how many times will ``recursiveFactorial(n)`` get called?

    +---------------------------------------+-----------------------------+
    | *Times Function Runs*                 | *Function Call*             |
    +=======================================+=============================+
    | 1                                     | ``recursiveFactorial(n)``   |
    +---------------------------------------+-----------------------------+
    | 2                                     | ``recursiveFactorial(n-1)`` |
    +---------------------------------------+-----------------------------+
    | 3                                     | ``recursiveFactorial(n-2)`` |
    +---------------------------------------+-----------------------------+
    | ...                                   | ``recursiveFactorial(...)`` |
    +---------------------------------------+-----------------------------+
    | n - 1                                 | ``recursiveFactorial(2)``   |
    +---------------------------------------+-----------------------------+
    | n                                     | ``recursiveFactorial(1)``   |
    +---------------------------------------+-----------------------------+
    | n + 1                                 | ``recursiveFactorial(0)``   |
    +---------------------------------------+-----------------------------+

* Therefore, ``recursiveFactorial(n)`` is also linear --- :math:`O(n)`


Fibonacci
---------


Towers of Hanoi
===============


For next time
=============

* Read Chapter 8
    * 28 pages
