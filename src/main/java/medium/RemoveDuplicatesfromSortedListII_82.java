package medium;

public class RemoveDuplicatesfromSortedListII_82 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[7];
        listNodes[0] = new ListNode(0);
        for (int i = 0; i < 6; i++) {
            listNodes[i + 1] = new ListNode(i + 1);
            listNodes[i].next = listNodes[i + 1];
        }
        listNodes[0].val = 1;
        listNodes[1].val = 2;
        listNodes[2].val = 3;
        listNodes[3].val = 3;
        listNodes[4].val = 4;
        listNodes[5].val = 4;
        listNodes[6].val = 5;
        ListNode result = deleteDuplicates(listNodes[0]);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode result = null;
        ListNode pre = null;
        ListNode index = null;
        boolean duplicate = false;
        while (head != null) {
            if (pre == null) {
                pre = head;
                duplicate = false;
            } else if (pre.val == head.val) {
                duplicate = true;
            } else if (pre.val != head.val) {
                //only one
                if (duplicate == false) {
                    if (result == null) {
                        result = pre;
                        index = result;
                    } else {
                        index.next = pre;
                        index = index.next;
                    }
                    index.next = null;
                    pre = head;
                    duplicate = false;
                } else if (duplicate = true) {
                    pre = head;
                    duplicate = false;
                }
            }
            head = head.next;
        }
        if (duplicate == false && pre != null) {
            if (result == null) {
                result = pre;
                result.next = null;
            } else {
                index.next = pre;
            }
        }
        return result;
    }
}
