package data_structures.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreOfParenthesesTest {

    private ScoreOfParentheses scoreOfParentheses;

    @BeforeEach
    public void setUp() {
        scoreOfParentheses = new ScoreOfParentheses();
    }

    @Test
    public void testEmptyStringScore() {
        assertEquals(0, scoreOfParentheses.scoreOfParentheses(""));
    }

    @Test
    public void testSinglePairScore() {
        assertEquals(1, scoreOfParentheses.scoreOfParentheses("()"));
    }

    @Test
    public void testAdjacentPairsScore() {
        assertEquals(2, scoreOfParentheses.scoreOfParentheses("()()"));
    }

    @Test
    public void testNestedPairScore() {
        assertEquals(2, scoreOfParentheses.scoreOfParentheses("(())"));
    }

    @Test
    public void testMixedAdjacentAndNestedScore() {
        assertEquals(3, scoreOfParentheses.scoreOfParentheses("()(())"));
    }

    @Test
    public void testComplexNestedParenthesesScore() {
        assertEquals(6, scoreOfParentheses.scoreOfParentheses("(()(()))"));
    }

    @Test
    public void testDeeplyNestedParenthesesScore() {
        assertEquals(4, scoreOfParentheses.scoreOfParentheses("((()))"));
    }
}
