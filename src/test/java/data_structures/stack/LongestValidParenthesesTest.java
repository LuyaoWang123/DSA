package src.test.java.data_structures.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.data_structures.stack.LongestValidParentheses;

import static org.junit.jupiter.api.Assertions.*;

public class LongestValidParenthesesTest {

    private LongestValidParentheses longestValidParentheses;

    @BeforeEach
    public void setUp() {
        longestValidParentheses = new LongestValidParentheses();
    }

    @Test
    public void testEmptyString() {
        assertEquals(0, longestValidParentheses.longestValidParentheses(""));
    }

    @Test
    public void testSinglePair() {
        assertEquals(2, longestValidParentheses.longestValidParentheses("()"));
    }

    @Test
    public void testAdjacentPairs() {
        assertEquals(4, longestValidParentheses.longestValidParentheses("()()"));
    }

    @Test
    public void testNestedPair() {
        assertEquals(4, longestValidParentheses.longestValidParentheses("(())"));
    }

    @Test
    public void testMixedValidAndInvalid() {
        assertEquals(2, longestValidParentheses.longestValidParentheses("(()"));
        assertEquals(2, longestValidParentheses.longestValidParentheses("())"));
    }

    @Test
    public void testComplexCase() {
        assertEquals(6, longestValidParentheses.longestValidParentheses("()(())"));
    }

    @Test
    public void testInvalidString() {
        assertEquals(0, longestValidParentheses.longestValidParentheses(")("));
    }
}
