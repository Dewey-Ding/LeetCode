package hard;

import java.util.List;

public class MergekSortedLists_23 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[4];
        lists[0] = null;
        lists[2] = null;
        lists[1] = new ListNode(-1);
        lists[1].next = new ListNode(5);
        lists[3] = new ListNode(6);
        lists[3].next = new ListNode(10);
        ListNode listNode = mergeKLists(lists);
        while (listNode!=null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    public static ListNode mergeKLists(ListNode[] lists){
        if(lists.length==0||lists==null){
            return null;
        }
        return mergeSubList(lists,0,lists.length-1);
    }
    public static ListNode mergeSubList(ListNode[] lists,int left,int right){
        if(left==right){
            return lists[left];
        }
        if(left<right){
            int mid = (left+right)/2;
            ListNode listNodeL = mergeSubList(lists,left,mid);
            ListNode listNodeR = mergeSubList(lists,mid+1,right);
            return merge(listNodeL,listNodeR);
        }
        return null;
    }
    public static ListNode merge(ListNode listNodeL,ListNode listNodeR){
        if(listNodeL==null){
            return listNodeR;
        }
        if(listNodeR==null){
            return listNodeL;
        }
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while(listNodeL!=null&&listNodeR!=null){
            if(listNodeL.val<listNodeR.val){
                cur.next = listNodeL;
                listNodeL = listNodeL.next;
            }else{
                cur.next = listNodeR;
                listNodeR = listNodeR.next;
            }
            cur = cur.next;
        }
        if(listNodeL!=null){
            cur.next = listNodeL;
        }else if(listNodeR!=null){
            cur.next =  listNodeR;
        }
        return result.next;
    }
/*    //one case time out
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode listNode = new ListNode(0);
        ListNode pre = listNode;
        int index = -1;
        int max = 0;
        for(int i = 0;i<lists.length;i++){
            ListNode tmp = lists[i];
            while(tmp!=null){
                tmp = tmp.next;
                max++;
            }
        }
        while(max>0) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < min) {
                    min = lists[i].val;
                    index = i;
                }
            }
            pre.next = lists[index];
            lists[index] = lists[index].next;
            pre = pre.next;
            max--;
        }
        return listNode.next;
    }
    */
}
