package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func main() {
	l6 := ListNode{2, nil}
	l5 := ListNode{5, &l6}
	l4 := ListNode{2, &l5}
	l3 := ListNode{3, &l4}
	l2 := ListNode{4, &l3}
	l1 := ListNode{1, &l2}
	list := partition(&l1, 0)
	for list != nil {
		fmt.Println(list.Val)
		list = list.Next
	}

}
func partition(head *ListNode, x int) *ListNode {
	var preCur, afterCur, headBefore, headAfter *ListNode
	if head == nil {
		return head
	}
	for ; head != nil; head = head.Next {
		if head.Val < x {
			if headBefore == nil {
				headBefore = head
				preCur = headBefore
			} else {
				preCur.Next = head
				preCur = preCur.Next
			}
		} else {
			if headAfter == nil {
				headAfter = head
				afterCur = headAfter
			} else {
				afterCur.Next = head
				afterCur = afterCur.Next
			}
		}
	}
	if afterCur != nil {
		afterCur.Next = nil
	}
	if headBefore != nil {
		preCur.Next = headAfter
		return headBefore
	}
	return headAfter

}
