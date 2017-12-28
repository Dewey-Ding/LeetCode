package medium;

public class RemoveNthNodeFromEndofList_19 {
    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[6];
        listNodes[0] = new ListNode(1);
        listNodes[0].next = null;
        removeNthFromEnd(listNodes[0], 1);

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode result = pre;
        while (head.next != null) {
            if (n <= 1) {
                pre = pre.next;
            }
            head = head.next;
            n--;
        }
        pre.next = pre.next.next;
        return result.next;
    }
}
