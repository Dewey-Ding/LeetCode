package medium;

import java.util.List;

public class SwapNodesinPairs_24 {
    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[4];
        for(int i =0;i<4;i++){
            listNodes[i] = new ListNode(i);
        }
        listNodes[0].next = listNodes[1];
        listNodes[1].next = listNodes[2];
        listNodes[2].next = listNodes[3];
        listNodes[3].next = null;
        ListNode listNode = swapPairs(listNodes[0]);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode pre = result;
        while (head != null && head.next != null) {
            pre.next = head.next;
            head.next = pre.next.next;
            pre.next.next = head;
            head = head.next;
            pre = pre.next.next;
        }
        return result.next;
    }
}
