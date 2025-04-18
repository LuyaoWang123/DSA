package data_structures.linkedlist;

public abstract class Node<U> {
    protected U key;
    public Node (U key) {
        this.key = key;
    }
    public U getKey() {
        return key;
    }
}
