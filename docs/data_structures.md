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
#### Leetcode 20(Easy). Valid Parentheses
##### Description:
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

+ Open brackets must be closed by the same type of brackets.
+ Open brackets must be closed in the correct order.
+ Every close bracket has a corresponding open bracket of the same type

##### Solution:
 For each character in this string, it is **either** open parentheses or a closed parentheses. 
+ if it is a open parentheses, then this parentheses needs to be matched in the future, so we store it in the stack(we use stack here, as we want future closed parentheses to match the closet open parentheses on its left--the most recent open parentheses that is pushed in to stack)
+ if it is a closed parentheses, then we check the top of stack to see if there is a match open parentheses. If there is a match, then pop this matched open parentheses then we go to the next character; otherwise, this is not a valid string, as there is a closed parentheses that does not have matched open parentheses.

After iteration, we still need to check if the stack is empty, as if it is not empty, then there are some open parentheses not get matched, thus not valid either.

##### [Code](/src/main/java/data_structures/stack/ValidParentheses.java)

##### Complexity:
$n$ is the length of the string input

Time Complexity: $O(n)$, as we iterate through the whole string, each character in the string is accessed once

Space Complexity: $O(n)$, as we are using stack, whose size might go up to the whole string