package data_structures.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovingAverageTest {
    private MovingAverage movingAverage;

    @BeforeEach
    public void setUp() {
        movingAverage = new MovingAverage(3); 
    }

    @Test
    public void testSingleElement() {
        double actual = movingAverage.next(1);
        double expected = 1.0;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testMovingAverageWithMultipleElements() {
        assertEquals(1.0, movingAverage.next(1), 0.001); // [1]
        assertEquals(1.5, movingAverage.next(2), 0.001); // [1,2]
        assertEquals(2.0, movingAverage.next(3), 0.001); // [1,2,3]
        assertEquals(3.0, movingAverage.next(4), 0.001); // [2,3,4] 
        assertEquals(4.0, movingAverage.next(5), 0.001); // [3,4,5] 
    }

    @Test
    public void testMovingAverageWithCapacityOne() {
        MovingAverage smallWindow = new MovingAverage(1);
        assertEquals(1.0, smallWindow.next(1), 0.001);
        assertEquals(2.0, smallWindow.next(2), 0.001);
        assertEquals(3.0, smallWindow.next(3), 0.001);
    }
}
