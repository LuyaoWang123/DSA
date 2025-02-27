package src.main.java.data_structures.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int longest = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char parenthesis = s.charAt(i);
            if (parenthesis == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    longest = Math.max(longest, i - stack.peek());
                }
            }
        }
        return longest;
    }
}
