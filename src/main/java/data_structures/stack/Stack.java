package src.main.java.data_structures.stack;

/**
 * A simple implementation based on Introduction to Algorithm, 4-th Edition, Chapter 10.1 
 */
public class Stack<U> {
    private int topPtr;
    private int capacity;
    private U[] stack;

    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Stack capacity must be greater than 0");
        this.topPtr = -1;
        this.capacity = capacity;
        this.stack = (U[]) new Object[this.capacity];
    }

    public boolean isEmpty() {
        return topPtr == -1;
    }

    public void push(U element) {
        if (this.topPtr == this.capacity - 1) {
            throw new Error("stack overflow");
        }
        ++topPtr;
        stack[topPtr] = element;
    }

    public U pop() {
        if (isEmpty()) {
            throw new Error("stack underflow");
        }
        --topPtr;
        return stack[topPtr + 1];
    }

    public U peek() {
        if (isEmpty()) {
            throw new Error("stack underflow");
        }
        return stack[topPtr];
    }
}