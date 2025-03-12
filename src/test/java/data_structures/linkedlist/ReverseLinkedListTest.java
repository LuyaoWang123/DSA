package data_structures.linkedlist;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ReverseLinkedListTest {

    @Test
    public void testEmptyList() {
        ReverseLinkedList rll = new ReverseLinkedList();
        SinglyNode<Integer> head = null;
        SinglyNode<Integer> reversed = rll.reverseList(head);
        assertNull(reversed);
    }

    @Test
    public void testSingleElementList() {
        ReverseLinkedList rll = new ReverseLinkedList();
        SinglyNode<Integer> head = new SinglyNode<>(1);
        SinglyNode<Integer> reversed = rll.reverseList(head);
        assertNotNull(reversed);
        assertEquals(1, reversed.data);
        assertNull(reversed.next);
    }

    @Test
    public void testMultipleElementsList() {
        ReverseLinkedList rll = new ReverseLinkedList();
        SinglyNode<Integer> node1 = new SinglyNode<>(1);
        SinglyNode<Integer> node2 = new SinglyNode<>(2);
        SinglyNode<Integer> node3 = new SinglyNode<>(3);
        SinglyNode<Integer> node4 = new SinglyNode<>(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        SinglyNode<Integer> reversed = rll.reverseList(node1);
        assertNotNull(reversed);
        assertEquals(4, reversed.data);
        assertNotNull(reversed.next);
        assertEquals(3, reversed.next.data);
        assertNotNull(reversed.next.next);
        assertEquals(2, reversed.next.next.data);
        assertNotNull(reversed.next.next.next);
        assertEquals(1, reversed.next.next.next.data);
        assertNull(reversed.next.next.next.next);
    }
}
