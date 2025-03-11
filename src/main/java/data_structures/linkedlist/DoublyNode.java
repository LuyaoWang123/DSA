package data_structures.linkedlist;

public class DoublyNode<U> extends Node<U>{
    DoublyNode<U> pre;
    DoublyNode<U> next;
    public DoublyNode (U data) {
        super(data);
        this.pre = null;
        this.next = null;
    }
}
