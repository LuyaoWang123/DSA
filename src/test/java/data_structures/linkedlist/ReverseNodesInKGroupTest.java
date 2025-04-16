package data_structures.linkedlist;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ReverseNodesInKGroupTest {

    @Test
    public void testReverseKGroupWithEmptyList() {
        ReverseNodesInKGroup rk = new ReverseNodesInKGroup();
        SinglyNode<Integer> head = null;
        SinglyNode<Integer> result = rk.reverseKGroup(head, 2);
        assertNull(result);
    }

    @Test
    public void testReverseKGroupWithSingleNode() {
        ReverseNodesInKGroup rk = new ReverseNodesInKGroup();
        SinglyNode<Integer> head = new SinglyNode<>(1);
        SinglyNode<Integer> result = rk.reverseKGroup(head, 2);
        assertNotNull(result);
        assertEquals(1, result.data);
        assertNull(result.next);
    }

    @Test
    public void testReverseKGroupWithKEqualToOne() {
        ReverseNodesInKGroup rk = new ReverseNodesInKGroup();
        SinglyNode<Integer> head = new SinglyNode<>(1);
        head.next = new SinglyNode<>(2);
        head.next.next = new SinglyNode<>(3);
        SinglyNode<Integer> result = rk.reverseKGroup(head, 1);
        assertEquals(1, result.data);
        assertEquals(2, result.next.data);
        assertEquals(3, result.next.next.data);
        assertNull(result.next.next.next);
    }

    @Test
    public void testReverseKGroupWithExactMultipleLength() {
        ReverseNodesInKGroup rk = new ReverseNodesInKGroup();
        SinglyNode<Integer> head = new SinglyNode<>(1);
        head.next = new SinglyNode<>(2);
        head.next.next = new SinglyNode<>(3);
        head.next.next.next = new SinglyNode<>(4);
        SinglyNode<Integer> result = rk.reverseKGroup(head, 2);
        assertEquals(2, result.data);
        assertEquals(1, result.next.data);
        assertEquals(4, result.next.next.data);
        assertEquals(3, result.next.next.next.data);
        assertNull(result.next.next.next.next);
    }

    @Test
    public void testReverseKGroupWithLengthNotMultipleOfK() {
        ReverseNodesInKGroup rk = new ReverseNodesInKGroup();
        SinglyNode<Integer> head = new SinglyNode<>(1);
        head.next = new SinglyNode<>(2);
        head.next.next = new SinglyNode<>(3);
        head.next.next.next = new SinglyNode<>(4);
        head.next.next.next.next = new SinglyNode<>(5);
        SinglyNode<Integer> result = rk.reverseKGroup(head, 3);
        assertEquals(3, result.data);
        assertEquals(2, result.next.data);
        assertEquals(1, result.next.next.data);
        assertEquals(4, result.next.next.next.data);
        assertEquals(5, result.next.next.next.next.data);
        assertNull(result.next.next.next.next.next);
    }

    @Test
    public void testReverseKGroupWithFullReverse() {
        ReverseNodesInKGroup rk = new ReverseNodesInKGroup();
        SinglyNode<Integer> head = new SinglyNode<>(1);
        head.next = new SinglyNode<>(2);
        head.next.next = new SinglyNode<>(3);
        head.next.next.next = new SinglyNode<>(4);
        SinglyNode<Integer> result = rk.reverseKGroup(head, 4);
        assertEquals(4, result.data);
        assertEquals(3, result.next.data);
        assertEquals(2, result.next.next.data);
        assertEquals(1, result.next.next.next.data);
        assertNull(result.next.next.next.next);
    }
}
