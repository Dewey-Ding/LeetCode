package medium;

public class RotateList_61 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[5];
        for (int i = 0; i < 5; i++) {
            listNodes[i] = new ListNode(i);
        }
        listNodes[0].next = listNodes[1];
        listNodes[1].next = listNodes[2];
        listNodes[2].next = listNodes[3];
        listNodes[3].next = listNodes[4];
        listNodes[4].next = null;
        ListNode result = rotateRight(listNodes[0], 3);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        ListNode pre = head, cur = head;
        int count = 0;
        while (cur.next != null) {
            if (count < k) {
                cur = cur.next;
                count++;
            } else if (count == k) {
                cur = cur.next;
                pre = pre.next;
            } else {
                break;
            }
        }
        cur.next = head;
        head = pre.next;
        pre.next = null;
        return head;
    }
}
