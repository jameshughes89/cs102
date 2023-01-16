*****************
Aside --- Postfix
*****************

* Postfix expression evaluation is one of the classic stack examples


Postfix Expressions
===================

* Humans prefer *infix* notation for writing mathematical expressions

    * ``3 + 4 * 2 = 11``
    * ``(7 + 2) / 3 = 3``


* However, this infix notation is just a convention
* Other notations exist, such as *postfix* notation

    * Postfix notation has some advantages for computers


* The above infix expressions can be expressed with postfix notation as follows

    * ``3 4 2 * + = (3 (4 2 *) +) = 11``
    * ``7 2 + 3 / = ((7 2 +) 3 /) = 3``



Pseudocode for Evaluating Postfix Expressions
---------------------------------------------

.. code-block:: text
    :linenos:

    For each symbol in expression
        If symbol is an operand
            PUSH symbol onto stack

        If symbol is an operator
            POP twice from the stack
            Apply operator to the two popped operands
            PUSH result onto stack


Evaluate
--------

* With the pseudocode, evaluate ``7 4 -3 * 1 5 + / *``

.. figure:: stack_postfix.png
    :width: 500 px
    :align: center

    Example evaluation of the postfix expression ``7 4 -3 * 1 5 + / *`` using a stack. For brevity, only six of the ten
    states that the stack would have are shown; multiple sequential operand pushes are not shown.


* Notice that, once again, the idea of a stack can be used to solve a problem despite not knowing its implementation
