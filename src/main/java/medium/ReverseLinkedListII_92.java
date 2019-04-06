package main.java.medium;


/**
 * @author dewey
 * @date 2018/11/12 13:49
 */
public class ReverseLinkedListII_92 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[6];
        for (int i = 0; i < listNodes.length; i++) {
            listNodes[i] = new ListNode(i+1);
        }
        for (int i = 0; i < listNodes.length; i++) {
            listNodes[i].next = i==listNodes.length-1?null:listNodes[i+1];
        }

        ListNode result = reverseBetween(listNodes[0],2,4);
        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode result = head;
        ListNode index = head;
        ListNode pre = null;
        ListNode sectionBegin = null;
        ListNode indexPre = null;
        int count = 1;
        while (count<m){
            count++;
            pre = pre==null?head:pre.next;
        }
        index = pre==null?head:pre.next;
        //reverse begin pre.next

        sectionBegin = index;
        for (int i = m; i <= n; i++) {
            ListNode temp = index.next;
            index.next = indexPre;
            indexPre = index;
            index = temp;
        }
        sectionBegin.next = index;
        if(pre==null){
           return indexPre;
        }
        pre.next = indexPre;

        return result;
    }
}
