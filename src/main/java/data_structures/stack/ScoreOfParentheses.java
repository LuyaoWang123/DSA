package data_structures.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ScoreOfParentheses {
    public int scoreOfParentheses(String s) {
        Deque<Integer> score = new ArrayDeque<>();
        score.push(0);
        for (char parenthesis: s.toCharArray()) {
            if (parenthesis == '(') score.push(0);
            else {
                int matchVal = score.pop();
                int curVal = score.pop();
                score.push(curVal + Math.max(2 * matchVal, 1));
            }
        }
        return score.peek();
    }
}
