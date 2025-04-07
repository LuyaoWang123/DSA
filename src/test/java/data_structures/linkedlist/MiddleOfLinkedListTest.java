package data_structures.linkedlist;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MiddleOfLinkedListTest {

    @Test
    public void testEmptyList() {
        MiddleOfLinkedList mol = new MiddleOfLinkedList();
        SinglyNode<Integer> head = null;
        SinglyNode<Integer> middle = mol.middleNode(head);
        assertNull(middle);
    }

    @Test
    public void testSingleElementList() {
        MiddleOfLinkedList mol = new MiddleOfLinkedList();
        SinglyNode<Integer> head = new SinglyNode<>(1);
        SinglyNode<Integer> middle = mol.middleNode(head);
        assertNotNull(middle);
        assertEquals(1, middle.data);
        assertNull(middle.next);
    }

    @Test
    public void testTwoElementList() {
        MiddleOfLinkedList mol = new MiddleOfLinkedList();
        SinglyNode<Integer> node1 = new SinglyNode<>(1);
        SinglyNode<Integer> node2 = new SinglyNode<>(2);
        node1.next = node2;
        SinglyNode<Integer> middle = mol.middleNode(node1);
        assertNotNull(middle);
        assertEquals(2, middle.data); 
    }

    @Test
    public void testOddNumberElements() {
        MiddleOfLinkedList mol = new MiddleOfLinkedList();
        SinglyNode<Integer> node1 = new SinglyNode<>(1);
        SinglyNode<Integer> node2 = new SinglyNode<>(2);
        SinglyNode<Integer> node3 = new SinglyNode<>(3);
        node1.next = node2;
        node2.next = node3;
        SinglyNode<Integer> middle = mol.middleNode(node1);
        assertNotNull(middle);
        assertEquals(2, middle.data); 
    }

    @Test
    public void testEvenNumberElements() {
        MiddleOfLinkedList mol = new MiddleOfLinkedList();
        SinglyNode<Integer> node1 = new SinglyNode<>(1);
        SinglyNode<Integer> node2 = new SinglyNode<>(2);
        SinglyNode<Integer> node3 = new SinglyNode<>(3);
        SinglyNode<Integer> node4 = new SinglyNode<>(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        SinglyNode<Integer> middle = mol.middleNode(node1);
        assertNotNull(middle);
        assertEquals(3, middle.data); 
    }
}
