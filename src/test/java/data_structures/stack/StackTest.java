package data_structures.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




public class StackTest {
    private Stack<Integer> stack;

    @BeforeEach
    public void setUp() {
        stack = new Stack<>(5);
    }

    @Test
    public void testEmptyStack() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testNonEmptyStack() {
        stack.push(1);
        assertFalse(stack.isEmpty());
    }
    
    @Test 
    public void testPushAndPeek() {
        stack.push(10);
        int actual = stack.peek();
        int expect = 10;
        assertEquals(expect, actual);
    }

    @Test
    public void testPushAndPop() {
        stack.push(1);
        stack.push(2);

        int firstActual = stack.peek();
        int firstExpected = 2;
        assertEquals(firstExpected, firstActual);
        stack.pop();

        int secondActual = stack.peek();
        int secondExpected = 1;
        assertEquals(secondExpected, secondActual);
        stack.pop();
    }

    @Test 
    public void testOverflow() {
        assertThrows(Error.class, () -> {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.push(5);
            stack.push(6);
        });
    }

    @Test
    public void testUnderflow() {
        assertThrows(Error.class, () -> {
            stack.push(1);
            stack.pop();
            stack.pop();
        });
    }
}
