package data_structures.deque;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SlidingWindowMaximumTest {
    private SlidingWindowMaximum slidingWindowMaximum;

    @BeforeEach
    public void setUp() {
        slidingWindowMaximum = new SlidingWindowMaximum();
    }

    @Test
    public void testExampleCase() {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] expected = {3, 3, 5, 5, 6, 7};
        assertArrayEquals(expected, slidingWindowMaximum.maxSlidingWindow(nums, k));
    }

    @Test
    public void testSingleElementArray() {
        int[] nums = {4};
        int k = 1;
        int[] expected = {4};
        assertArrayEquals(expected, slidingWindowMaximum.maxSlidingWindow(nums, k));
    }

    @Test
    public void testAllNegativeNumbers() {
        int[] nums = {-1, -3, -5, -2, -8, -6};
        int k = 2;
        int[] expected = {-1, -3, -2, -2, -6};
        assertArrayEquals(expected, slidingWindowMaximum.maxSlidingWindow(nums, k));
    }

    @Test
    public void testIncreasingOrder() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        int[] expected = {3, 4, 5, 6, 7};
        assertArrayEquals(expected, slidingWindowMaximum.maxSlidingWindow(nums, k));
    }

    @Test
    public void testDecreasingOrder() {
        int[] nums = {9, 8, 7, 6, 5, 4, 3};
        int k = 3;
        int[] expected = {9, 8, 7, 6, 5};
        assertArrayEquals(expected, slidingWindowMaximum.maxSlidingWindow(nums, k));
    }

    @Test
    public void testSameNumbers() {
        int[] nums = {5, 5, 5, 5, 5};
        int k = 3;
        int[] expected = {5, 5, 5};
        assertArrayEquals(expected, slidingWindowMaximum.maxSlidingWindow(nums, k));
    }

    @Test
    public void testWindowSizeEqualsArraySize() {
        int[] nums = {1, 3, 5, 7, 9};
        int k = 5;
        int[] expected = {9};
        assertArrayEquals(expected, slidingWindowMaximum.maxSlidingWindow(nums, k));
    }

    @Test
    public void testWindowSizeOne() {
        int[] nums = {10, 20, 30, 40, 50};
        int k = 1;
        int[] expected = {10, 20, 30, 40, 50};
        assertArrayEquals(expected, slidingWindowMaximum.maxSlidingWindow(nums, k));
    }

    @Test
    public void testEdgeCaseKGreaterThanArraySize() {
        int[] nums = {1, 2, 3};
        int k = 5;
        assertThrows(NegativeArraySizeException.class, () -> slidingWindowMaximum.maxSlidingWindow(nums, k));
    }
}
