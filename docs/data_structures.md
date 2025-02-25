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


For problem 20, it is just judging the if all open and closed parentheses get matched. Then based on
the fact that they are matched, we can also compute the properties of such matched(balanced) string input. 
For example, problem 856:

#### [Leetcode 856(Medium). Score of Parentheses](https://leetcode.com/problems/score-of-parentheses/description/)
##### Description:
Given a **balanced** parentheses string s, return the score of the string.

The score of a balanced parentheses string is based on the following rule:

+ "()" has score 1.
+ AB has score A + B, where A and B are balanced parentheses strings.
+ (A) has score 2 * A, where A is a balanced parentheses string.

##### Solution: 
Before calculating the score of the input, we initialize the stack via pushing 0(current value of the input)
Then for each character in the string, it is either '(' or ')':
+ If the character is '(', then it is a new nested layer, for example, a string with "(())" has layer depth 2,
while a string "((()()))" has a depth 3, as there are at most 3 unmatched ((( appear together, 
either (((, or ((()(. Each time for  a new layer, we push 0 to the stack indicates that 
this is a new layer;
+ If the character is ')', then it ends a nested layer. As we end the layer, 
we will need to double the score of the nested string by rule 3. When we finish nesting calculation,
we also need to add this string's score to the left adjacent nested string in the same depth, which is rule 2. 
For example, (ABC), where A,B,C are all balanced parentheses string, and A,B,C has the same depth. 
  + Thus when we find the score of A, we will add score A to score (, which is 0, get a score $score_{(A}$;
  + then when we find the score of B, we will add score B to $score_{(A}$, get $score_{(AB}$, 
  + then when we find the score of C, we will add score C to $score_{(AB}$, get $score_{(ABC}$
  + then we have ), that means we need to double the score of $ABC$, then push it to stack 

In short, by pop 2 values from stack and push 1 value in stack when we encounter ')', 
we actually finish the match this ')' to the most recent open parentheses, and by adding the result to
the second recent open parentheses, we make this second parentheses to be the most recent unmatched 
open parentheses **and** compute the nest string score. 

Here is an animation(too small? [original slides](/src/main/resources/856_score_of_parentheses.pptx))
<figure style="text-align: center;">
  <img src="../src/main/resources/856_score_of_parentheses.gif" alt="Description">
  <figcaption>
    <strong>Figure 2.</strong> Score of parentheses example animation<br>
  </figcaption>
</figure>

##### [Code]()

##### Complexity:
Time Complexity is $O(n)$ where n is the length of parentheses input;
Space Complexity is $O(n)$ 