package data_structures.linkedlist;

public class MiddleOfLinkedList {
    public SinglyNode<Integer> middleNode(SinglyNode<Integer> head) {
        if (head == null) return head;
        SinglyNode<Integer> fast = head;
        SinglyNode<Integer> slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
