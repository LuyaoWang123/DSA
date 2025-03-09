package data_structures.deque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DequeTest {
    private Deque<Integer> deque;

    @BeforeEach
    public void setUp() {
        deque = new Deque<>(5);
    }

    @Test
    public void testEnqueueDequeueFromTail() {
        deque.enqueueFromTail(1);
        deque.enqueueFromTail(2);
        deque.enqueueFromTail(3);
        assertEquals(Integer.valueOf(1), deque.dequeueFromHead());
        assertEquals(Integer.valueOf(2), deque.dequeueFromHead());
        assertEquals(Integer.valueOf(3), deque.dequeueFromHead());
    }

    @Test
    public void testEnqueueDequeueFromHead() {
        deque.enqueueFromHead(1);
        deque.enqueueFromHead(2);
        deque.enqueueFromHead(3);
        assertEquals(Integer.valueOf(3), deque.dequeueFromHead());
        assertEquals(Integer.valueOf(2), deque.dequeueFromHead());
        assertEquals(Integer.valueOf(1), deque.dequeueFromHead());
    }

    @Test
    public void testMixedOperations() {
        deque.enqueueFromTail(1);
        deque.enqueueFromTail(2);
        deque.enqueueFromHead(0);
        deque.enqueueFromTail(3);
        deque.enqueueFromHead(-1);

        assertEquals(Integer.valueOf(-1), deque.dequeueFromHead());
        assertEquals(Integer.valueOf(0), deque.dequeueFromHead());
        assertEquals(Integer.valueOf(1), deque.dequeueFromHead());
        assertEquals(Integer.valueOf(2), deque.dequeueFromHead());
        assertEquals(Integer.valueOf(3), deque.dequeueFromHead());
    }

    @Test
    public void testUnderflow() {
        assertThrows(Error.class, () -> deque.dequeueFromHead());
        assertThrows(Error.class, () -> deque.dequeueFromTail());
    }

    @Test
    public void testOverflow() {
        for (int i = 0; i < 5; i++) {
            deque.enqueueFromTail(i);
        }
        assertThrows(Error.class, () -> deque.enqueueFromTail(5));
        assertThrows(Error.class, () -> deque.enqueueFromHead(6));
    }

    @Test
    public void testWrapAroundBehavior() {
        deque.enqueueFromTail(1);
        deque.enqueueFromTail(2);
        deque.enqueueFromTail(3);
        deque.enqueueFromTail(4);
        deque.enqueueFromTail(5);

        assertEquals(Integer.valueOf(1), deque.dequeueFromHead());
        assertEquals(Integer.valueOf(2), deque.dequeueFromHead());

        deque.enqueueFromTail(6);
        deque.enqueueFromTail(7);

        assertEquals(Integer.valueOf(3), deque.dequeueFromHead());
        assertEquals(Integer.valueOf(4), deque.dequeueFromHead());
        assertEquals(Integer.valueOf(5), deque.dequeueFromHead());
        assertEquals(Integer.valueOf(6), deque.dequeueFromHead());
        assertEquals(Integer.valueOf(7), deque.dequeueFromHead());

        assertTrue(deque.isEmpty());
    }

    @Test
    public void testEdgeCaseWhenDequeBecomesEmptyAndRefilled() {
        deque.enqueueFromTail(1);
        deque.enqueueFromTail(2);
        deque.enqueueFromTail(3);
        deque.enqueueFromTail(4);
        deque.enqueueFromTail(5);

        for (int i = 0; i < 5; i++) {
            deque.dequeueFromHead();
        }

        assertTrue(deque.isEmpty());

        deque.enqueueFromTail(6);
        deque.enqueueFromTail(7);
        deque.enqueueFromTail(8);
        deque.enqueueFromTail(9);
        deque.enqueueFromTail(10);

        assertEquals(Integer.valueOf(6), deque.dequeueFromHead());
        assertEquals(Integer.valueOf(7), deque.dequeueFromHead());
        assertEquals(Integer.valueOf(8), deque.dequeueFromHead());
        assertEquals(Integer.valueOf(9), deque.dequeueFromHead());
        assertEquals(Integer.valueOf(10), deque.dequeueFromHead());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(deque.isEmpty());
        deque.enqueueFromTail(1);
        assertFalse(deque.isEmpty());
        deque.dequeueFromHead();
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testPeekHead() {
        deque.enqueueFromTail(1);
        deque.enqueueFromTail(2);
        assertEquals(Integer.valueOf(1), deque.peekHead());

        deque.enqueueFromHead(0);
        assertEquals(Integer.valueOf(0), deque.peekHead());

        deque.dequeueFromHead();
        assertEquals(Integer.valueOf(1), deque.peekHead());
    }

    @Test
    public void testPeekTail() {
        deque.enqueueFromTail(1);
        deque.enqueueFromTail(2);
        assertEquals(Integer.valueOf(2), deque.peekTail());

        deque.enqueueFromHead(0);
        assertEquals(Integer.valueOf(2), deque.peekTail());

        deque.dequeueFromTail();
        assertEquals(Integer.valueOf(1), deque.peekTail());
    }
}
