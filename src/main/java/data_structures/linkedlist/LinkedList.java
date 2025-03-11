package data_structures.linkedlist;

public interface LinkedList<U, V extends Node<U>> {
    void prepend(U data);
    void append(U data);
    /**
     * insert new node after old node
     * @param newNode
     * @param oldNode
     */
    void insert(V newNode,V oldNode);
    void delete(U data);
    V search(U data);
    int size();
    boolean isEmpty();
}
