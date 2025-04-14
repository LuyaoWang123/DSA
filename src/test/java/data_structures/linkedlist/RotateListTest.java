package data_structures.linkedlist;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RotateListTest {

    @Test
    public void testRotateRightWithEmptyList() {
        RotateList rl = new RotateList();
        SinglyNode<Integer> head = null;
        SinglyNode<Integer> result = rl.rotateRight(head, 5);
        assertNull(result);
    }

    @Test
    public void testRotateRightWithSingleElement() {
        RotateList rl = new RotateList();
        SinglyNode<Integer> head = new SinglyNode<>(10);
        SinglyNode<Integer> result = rl.rotateRight(head, 2);
        assertNotNull(result);
        assertEquals(10, result.data);
        assertNull(result.next);
    }

    @Test
    public void testRotateRightWithRotationZero() {
        RotateList rl = new RotateList();
        SinglyNode<Integer> node1 = new SinglyNode<>(1);
        SinglyNode<Integer> node2 = new SinglyNode<>(2);
        SinglyNode<Integer> node3 = new SinglyNode<>(3);
        node1.next = node2;
        node2.next = node3;
        SinglyNode<Integer> result = rl.rotateRight(node1, 0);
        assertNotNull(result);
        assertEquals(1, result.data);
        assertEquals(2, result.next.data);
        assertEquals(3, result.next.next.data);
        assertNull(result.next.next.next);
    }

    @Test
    public void testRotateRightWithRotationEqualToListLength() {
        RotateList rl = new RotateList();
        SinglyNode<Integer> node1 = new SinglyNode<>(1);
        SinglyNode<Integer> node2 = new SinglyNode<>(2);
        SinglyNode<Integer> node3 = new SinglyNode<>(3);
        node1.next = node2;
        node2.next = node3;
        SinglyNode<Integer> result = rl.rotateRight(node1, 3);
        assertNotNull(result);
        assertEquals(1, result.data);
        assertEquals(2, result.next.data);
        assertEquals(3, result.next.next.data);
        assertNull(result.next.next.next);
    }

    @Test
    public void testRotateRightWithRotationGreaterThanListLength() {
        RotateList rl = new RotateList();
        SinglyNode<Integer> node1 = new SinglyNode<>(1);
        SinglyNode<Integer> node2 = new SinglyNode<>(2);
        SinglyNode<Integer> node3 = new SinglyNode<>(3);
        node1.next = node2;
        node2.next = node3;
        SinglyNode<Integer> result = rl.rotateRight(node1, 5);
        assertNotNull(result);
        assertEquals(2, result.data);
        assertEquals(3, result.next.data);
        assertEquals(1, result.next.next.data);
        assertNull(result.next.next.next);
    }

    @Test
    public void testRotateRightWithStandardScenario() {
        RotateList rl = new RotateList();
        SinglyNode<Integer> node1 = new SinglyNode<>(10);
        SinglyNode<Integer> node2 = new SinglyNode<>(20);
        SinglyNode<Integer> node3 = new SinglyNode<>(30);
        SinglyNode<Integer> node4 = new SinglyNode<>(40);
        SinglyNode<Integer> node5 = new SinglyNode<>(50);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        SinglyNode<Integer> result = rl.rotateRight(node1, 2);
        assertNotNull(result);
        assertEquals(40, result.data);
        assertEquals(50, result.next.data);
        assertEquals(10, result.next.next.data);
        assertEquals(20, result.next.next.next.data);
        assertEquals(30, result.next.next.next.next.data);
        assertNull(result.next.next.next.next.next);
    }
}
