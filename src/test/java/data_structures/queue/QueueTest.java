package data_structures.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueueTest {
    private Queue<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new Queue<>(5);
    }

    @Test
    public void testEnqueueDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(Integer.valueOf(1), queue.dequeue());
        assertEquals(Integer.valueOf(2), queue.dequeue());
        assertEquals(Integer.valueOf(3), queue.dequeue());
    }

    @Test
    public void testUnderflow() {
        assertThrows(Error.class, () -> {
            queue.dequeue();
        });
    }

    @Test
    public void testOverflow() {
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        assertThrows(Error.class, () -> {
            queue.enqueue(5);
        });
    }

    @Test
    public void testWrapAround() {
        for (int i = 1; i <= 5; i++) {
            queue.enqueue(i);
        }
        assertEquals(Integer.valueOf(1), queue.dequeue());
        assertEquals(Integer.valueOf(2), queue.dequeue());
        queue.enqueue(6);
        queue.enqueue(7);
        assertEquals(Integer.valueOf(3), queue.dequeue());
        assertEquals(Integer.valueOf(4), queue.dequeue());
        assertEquals(Integer.valueOf(5), queue.dequeue());
        assertEquals(Integer.valueOf(6), queue.dequeue());
        assertEquals(Integer.valueOf(7), queue.dequeue());
    }
}
