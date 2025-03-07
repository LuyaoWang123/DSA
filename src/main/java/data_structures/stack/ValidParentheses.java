package data_structures.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * Practice from leetcode 20: https://leetcode.com/problems/valid-parentheses/
 * Difficulty: Easy
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> parentheses = Map.of(
            '(', ')',
            '[', ']',
            '{', '}'
        );
        for (char c : s.toCharArray()) {
            if (parentheses.containsKey(c)) {
                stack.push(parentheses.get(c));
            } else {
                if (!stack.isEmpty() && stack.peek() == c) stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}