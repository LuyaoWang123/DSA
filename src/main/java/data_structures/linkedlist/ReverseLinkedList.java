package data_structures.linkedlist;

public class ReverseLinkedList {
    public SinglyNode<Integer> reverseList(SinglyNode<Integer> head) {
        SinglyNode<Integer> pre = null;
        SinglyNode<Integer> cur = head;
        while (cur != null) {
            SinglyNode<Integer> next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
