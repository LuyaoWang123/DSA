package data_structures.linkedlist;

public class DoublyLinkedList<U> implements LinkedList<U, DoublyNode<U>>{
    private DoublyNode<U> head;
    private DoublyNode<U> tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void prepend(U data) {
        DoublyNode<U> newNode = new DoublyNode<U>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.pre = newNode;
            head = newNode;
        }
        size = size + 1;
    }

    @Override
    public void append(U data) {
        DoublyNode<U> newNode = new DoublyNode<U>(data);
        if (tail == null) {
            tail = head = newNode;
        } else {
            newNode.pre = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size = size + 1;
    }

    @Override
    public void insert(DoublyNode<U> newNode, DoublyNode<U> oldNode) {
        newNode.next = oldNode.next;
        newNode.pre = oldNode;
        if (oldNode.next != null) oldNode.next.pre = newNode;
        oldNode.next = newNode;
        size = size + 1;
    }

    @Override
    public void delete(U data) {
        DoublyNode<U> toBeDeleted = search(data);
        if (toBeDeleted == null) return;
        if (toBeDeleted.pre != null) {
            toBeDeleted.pre.next = toBeDeleted.next;
        } else {
            head = toBeDeleted.next;
        }
        if (toBeDeleted.next != null) {
            toBeDeleted.next.pre = toBeDeleted.pre;
        } else {
            head = toBeDeleted.pre;
        }
        size = size - 1;
    }

    @Override
    public DoublyNode<U> search(U data) {
        DoublyNode<U> node = head;
        while (node != null && node.data != data) {
            node = node.next;
        }
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
    
}
