package data_structures.linkedlist;

/**
 * Singly linked list is not implemented, but you can have a try! submit a pull request on github!:)
 */
public class SinglyLinkedList<U> implements LinkedList<U, SinglyNode<U>>{
    private SinglyNode<U> head;
    private SinglyNode<U> tail;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void prepend(U data) {
        SinglyNode<U> newNode = new SinglyNode<U>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size = size + 1;
    }

    @Override
    public void append(U data) {
        SinglyNode<U> newNode = new SinglyNode<U>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size = size + 1;
    }

    @Override
    public void insert(SinglyNode<U> newNode, SinglyNode<U> oldNode) {
        if (newNode == null) throw new IllegalArgumentException("new node can not be null");
        if (oldNode == null) {
            append(newNode.data);
        } else {
            newNode.next = oldNode.next;
            oldNode.next = newNode;
            size = size + 1;
        }
    }

    @Override
    public void delete(U data) {
        SinglyNode<U> pre = new SinglyNode<U>(null);
        pre.next = head;
        SinglyNode<U> node = head;
        while (node != null && node.data != data) {
            node = node.next;
            pre = pre.next;
        }
        if (node == null) return;
        if (node == head) {
            head = head.next;
        } else {
            pre.next = node.next;
            node.next = null;
        }
        size = size - 1;
    }

    @Override
    public SinglyNode<U> search(U data) {
        SinglyNode<U> node = head;
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
        return size == 0;
    }
    
}
