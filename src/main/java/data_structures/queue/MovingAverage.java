package src.main.java.data_structures.queue;

public class MovingAverage {
    private Queue<Integer> queue;
    private int capacity;
    private double sum;

    public MovingAverage(int size) {
        this.queue = new Queue<>(size);
        this.capacity = size;
        this.sum = 0.0;
    }
    
    public double next(int val) {
        if (queue.size() == capacity) {
            sum -= queue.dequeue();
        }
        sum += val;
        queue.enqueue(val);
        return sum / queue.size();
    }
}
