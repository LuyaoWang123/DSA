package data_structures.deque;


public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // maintain a non-increasing list using deque
        int n = nums.length;
        int[] window = new int[n - k + 1];
        Deque<Integer> nonIncr = new Deque<>(n);

        // initialize our list
        for (int i = 0; i < k; i++) {
            while (!nonIncr.isEmpty() && nonIncr.peekTail() < nums[i]) {
                nonIncr.dequeueFromTail();
            }
            nonIncr.enqueueFromTail(nums[i]);
        }
        window[0] = nonIncr.peekHead();

        // iterate through to the rest
        for (int i = k; i < n; i++) {
            if (nonIncr.peekHead() == nums[i - k]) {
                nonIncr.dequeueFromHead();
            }
            while (!nonIncr.isEmpty() && nonIncr.peekTail() < nums[i]) {
                nonIncr.dequeueFromTail();
            }
            nonIncr.enqueueFromTail(nums[i]);
            window[i - k + 1] = nonIncr.peekHead();
        }
        return window;
    }
}
