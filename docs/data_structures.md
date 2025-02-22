# Documentation for Data Structure

This file serves as the documentation for data structure.
Data structure is way to organize data based on specific rules.

## Stack

[Stack](/data_structures/stack/Stack.java) is a data structure that follows **First In, Last Out(FIFO)**. Namely, the element being pushed first will be the one that is last popped out. 
<figure style="text-align: center;">
  <img src="../src/main/resources/stack.gif" alt="Description">
  <figcaption>
    <strong>Figure 1.</strong> Stack Mechanism<br>
  </figcaption>
</figure>

In this mechanism demonstration, we set topPtr to be -1(which means the bottom of the stack) for stack initialization.
+ If we **push** one element into stack, (after check overflow)we first increment stack's top pointer, 
then assign the value to where the pointer points. 
+ If we **pop**
one element from stack, (after check underflow) we first decrement stack's top pointer, then return what 
the pointer + 1 points to.

### Time Complexity
| Operation | Time Complexity |
|-----------|-----------------|
| push      | O(1)          |
| pop       | O(1)          |
| peek/top  | O(1)          |
| isEmpty   | O(1)          |

### Practice