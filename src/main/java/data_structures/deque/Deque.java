package data_structures.deque;

public class Deque<U> {
    private int tail;
    private int head;
    private int capacity;
    private int size;
    private U[] deque;

    @SuppressWarnings("unchecked")
    public Deque (int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Queue capacity must be greater than 0");
        this.capacity = capacity;
        this.deque = (U[])(new Object[this.capacity]);
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    private boolean isFull() {
        return size == capacity;
    }

    public void enqueueFromTail(U x) {
        if (isFull()) throw new Error("Deque overflow when enqueue from tail");
        deque[tail] = x;
        if (tail == capacity - 1) {
            tail = 0;
        }  else {
            tail = tail + 1;
        }
        size = size + 1;
    }

    public void enqueueFromHead(U x) {
        if (isFull()) throw new Error("Deque overflow when enqueue from head");
        if (head == 0) {
            head = capacity - 1;
        } else {
            head = head - 1;
        }
        deque[head] = x;
        size = size + 1;
    }

    public U dequeueFromTail() {
        if (isEmpty()) throw new Error("Deque underflow when dequeue from tail");
        if (tail == 0) {
            tail = capacity - 1;
        } else {
            tail = tail - 1;
        }
        U x = deque[tail];
        size = size - 1;
        return x;
    }

    public U dequeueFromHead() {
        if (isEmpty()) throw new Error("Deque underflow when dequeue from head");
        U x = deque[head];
        if (head == capacity - 1) {
            head = 0;
        } else {
            head = head + 1;
        }
        size = size - 1;
        return x;
    }
    
    public U peekHead() {
        if (isEmpty()) throw new Error("Deque underflow when get head");
        return deque[head];
    }

    public U peekTail() {
        if (isEmpty()) throw new Error("Deque underflow when get tail");
        return deque[tail - 1];
    }
}
