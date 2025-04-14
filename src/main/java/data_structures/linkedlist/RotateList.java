package data_structures.linkedlist;

public class RotateList {
    public SinglyNode<Integer> rotateRight(SinglyNode<Integer> head, int k) {
        if (head == null || head.next == null) return head;
        SinglyNode<Integer> cur = head;
        for (int i = 0; i < k; i++) {
            if (cur.next == null) {
                cur = head;
            } else {
                cur = cur.next;
            }
        }
        SinglyNode<Integer> ptr = head;
        while (cur.next != null) {
            cur = cur.next;
            ptr = ptr.next;
        }
        cur.next = head;
        SinglyNode<Integer> newHead = ptr.next;
        ptr.next = null;
        return newHead;
    }
}
