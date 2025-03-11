package data_structures.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoublyLinkedListTest {
    private DoublyLinkedList<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new DoublyLinkedList<>();
    }

    @Test
    public void testPrepend() {
        list.prepend(10);
        list.prepend(20);
        assertEquals(2, list.size());
        assertEquals(20, list.search(20).data);
        assertEquals(10, list.search(10).data);
    }

    @Test
    public void testAppend() {
        list.append(10);
        list.append(20);
        assertEquals(2, list.size());
        assertEquals(10, list.search(10).data);
        assertEquals(20, list.search(20).data);
    }

    @Test
    public void testInsert() {
        list.append(10);
        list.append(30);
        DoublyNode<Integer> newNode = new DoublyNode<>(20);
        list.insert(newNode, list.search(10));
        assertEquals(3, list.size());
        assertEquals(20, list.search(20).data);
    }

    @Test
    public void testDelete() {
        list.append(10);
        list.append(20);
        list.append(30);
        list.delete(20);
        assertNull(list.search(20));
        assertEquals(2, list.size());
    }

    @Test
    public void testDeleteHead() {
        list.append(10);
        list.append(20);
        list.delete(10);
        assertNull(list.search(10));
        assertEquals(1, list.size());
    }

    @Test
    public void testDeleteTail() {
        list.append(10);
        list.append(20);
        list.delete(20);
        assertNull(list.search(20));
        assertEquals(1, list.size());
    }

    @Test
    public void testDeleteNonExistentElement() {
        list.append(10);
        list.append(20);
        list.delete(30);
        assertEquals(2, list.size());
    }

    @Test
    public void testSearch() {
        list.append(10);
        list.append(20);
        assertNotNull(list.search(10));
        assertNotNull(list.search(20));
        assertNull(list.search(30));
    }

    @Test
    public void testSize() {
        assertEquals(0, list.size());
        list.append(10);
        assertEquals(1, list.size());
        list.append(20);
        assertEquals(2, list.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.append(10);
        assertFalse(list.isEmpty());
        list.delete(10);
        assertTrue(list.isEmpty());
    }
}
