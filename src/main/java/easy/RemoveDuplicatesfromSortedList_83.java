package easy;


public class RemoveDuplicatesfromSortedList_83 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next =listNode3;
        ListNode result = deleteDuplicates(listNode1);
        while (result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode result = head,tmp = head;
        while(head!=null){
            if(tmp.val != head.val){
                tmp.next=head;
                head = head.next;
                tmp = tmp.next;
                tmp.next = null;
                continue;
            }
            head = head.next;
            tmp.next = null;
        }
        return result;
    }
    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }
}
