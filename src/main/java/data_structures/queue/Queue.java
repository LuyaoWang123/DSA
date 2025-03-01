package src.main.java.data_structures.queue;

/**
 * A simple implementation using a fixed-size array
 * Based on "Introduction to Algorithms," 4-th Edition, Chapter 10.1
 * @param tail - where the element reside when enqueue
 * @param head - where the element reside when dequeue 
 */
public class Queue<U> {
    private int tail;
    private int head;
    private int capacity;
    private int size;
    private U[] queue;

    @SuppressWarnings("unchecked")
    public Queue(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Queue capacity must be greater than 0");
        this.capacity = capacity;
        this.queue = (U[])(new Object[this.capacity]);
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public void enqueue(U x) {
        if (size == capacity) throw new Error("Queue overflow");
        queue[tail] = x;
        if (tail == capacity - 1) {
            tail = 0;
        } else {
            tail = tail + 1;
        }
        size = size + 1;
    }

    public U dequeue() {
        if (size == 0) throw new Error("Queue underflow");
        U x = queue[head];
        if (head == capacity - 1) {
            head = 0;
        } else {
            head = head + 1;
        }
        size = size - 1;
        return x;
    }
}
