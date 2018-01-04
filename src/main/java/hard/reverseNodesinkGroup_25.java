package hard;

import java.util.List;

public class reverseNodesinkGroup_25 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode[] head = new ListNode[5];
        for (int i = 0; i < head.length; i++) {
            head[i] = new ListNode(i+1);
            if(i!=0) {
                head[i - 1].next = head[i];
            }
        }
        ListNode test = null;
        ListNode result = reverseKGroup(test,2);
        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(k==0||k==1||head==null){
            return head;
        }
        ListNode pre = head,end = head;
        int count = k;
        while(head!=null&&count>0){
            end = head;
            head = head.next;
            count--;
        }
        end.next = null;
        //倒转k个元素
        if(count==0){
            ListNode cur = pre;
            ListNode next = pre.next;
            pre.next = null;
            while(next!=null){
                ListNode tmp = next.next;
                next.next = cur;
                cur = next;
                next = tmp;
            }
            pre.next=reverseKGroup(head,k);
            return end;
        }
        return pre;
    }
    /*
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int n =0;
        while(cur!=null && n!=k){
            cur = cur.next;
            n++;
        }
        if(n==k){
            cur = reverseKGroup(cur,k);
            while(n-- >0){
                ListNode nex = head.next;
                head.next = cur;
                cur = head;
                head = nex;
            }
            head = cur;
        }
        return head;
    }
    */
    /**/
}
