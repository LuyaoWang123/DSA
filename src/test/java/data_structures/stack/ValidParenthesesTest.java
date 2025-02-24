package src.test.java.data_structures.stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.main.java.data_structures.stack.ValidParentheses;

import static org.junit.jupiter.api.Assertions.*;

public class ValidParenthesesTest {

    private ValidParentheses validParentheses;

    @BeforeEach
    public void setUp() {
        validParentheses = new ValidParentheses();
    }

    @Test
    public void testEmptyString() {
        assertTrue(validParentheses.isValid(""));
    }

    @Test
    public void testValidParentheses() {
        assertTrue(validParentheses.isValid("()"));
        assertTrue(validParentheses.isValid("()[]{}"));
        assertTrue(validParentheses.isValid("{[]}"));
    }

    @Test
    public void testInvalidParentheses() {
        assertFalse(validParentheses.isValid("(]"));
        assertFalse(validParentheses.isValid("([)]"));
        assertFalse(validParentheses.isValid("{[}]"));
    }

    @Test
    public void testMismatchedParentheses() {
        assertFalse(validParentheses.isValid("("));
        assertFalse(validParentheses.isValid(")"));
        assertFalse(validParentheses.isValid("["));
        assertFalse(validParentheses.isValid("]"));
        assertFalse(validParentheses.isValid("{"));
        assertFalse(validParentheses.isValid("}"));
    }

    @Test
    public void testNestedValidParentheses() {
        assertTrue(validParentheses.isValid("({[]})"));
        assertTrue(validParentheses.isValid("{[()]}"));
    }

    @Test
    public void testNestedInvalidParentheses() {
        assertFalse(validParentheses.isValid("({[}])"));
        assertFalse(validParentheses.isValid("{[({)]}"));
    }

    @Test
    public void testMixedValidAndInvalidParentheses() {
        assertFalse(validParentheses.isValid("()[]{}{"));
        assertFalse(validParentheses.isValid("()[]{}}"));
    }

    @Test
    public void testLongValidString() {
        assertTrue(validParentheses.isValid("((((((((()))))))))"));
        assertTrue(validParentheses.isValid("{{{{{{{{[]}}}}}}}}"));
        assertTrue(validParentheses.isValid("[[[[[[[[]]]]]]]]"));
    }

    @Test
    public void testLongInvalidString() {
        assertFalse(validParentheses.isValid("((((((((())))))))))"));
        assertFalse(validParentheses.isValid("{{{{{{{{[]}}}}}}}}}"));
        assertFalse(validParentheses.isValid("[[[[[[[[]]]]]]]]]"));
    }
}