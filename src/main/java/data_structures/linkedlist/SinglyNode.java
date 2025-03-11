package data_structures.linkedlist;

public class SinglyNode<U> extends Node<U> {
    SinglyNode<U> next;
    
    public SinglyNode(U data) {
        super(data);
        this.next = null;
    }
}
