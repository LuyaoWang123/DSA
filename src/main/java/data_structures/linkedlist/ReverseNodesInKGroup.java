package data_structures.linkedlist;

public class ReverseNodesInKGroup {
    public SinglyNode<Integer> reverseKGroup(SinglyNode<Integer> head, int k) {
        SinglyNode<Integer> sentinel = new SinglyNode<Integer>(-1);
        sentinel.next = head;
        SinglyNode<Integer> preTail = sentinel;
        SinglyNode<Integer> ptr = sentinel;
        int i = 0;
        ReverseLinkedList r = new ReverseLinkedList();
        while (ptr != null) {
            if (i != 0 && i % k == 0) {
                SinglyNode<Integer> curHead = preTail.next;
                SinglyNode<Integer> curTail = ptr;
                SinglyNode<Integer> nextHead = curTail.next;
                curTail.next = null;
                SinglyNode<Integer> reversedHead = r.reverseList(curHead);
                SinglyNode<Integer> reversedTail = curHead;
                preTail.next = reversedHead;
                reversedTail.next = nextHead;
                preTail = reversedTail;
                ptr = reversedTail;
            }
            ptr = ptr.next;
            i++;
        }
        return sentinel.next;
    }
}
