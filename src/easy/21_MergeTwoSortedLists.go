package easy

import (
	"fmt"
	"math"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

func main() {
	var l1,l2 *ListNode
	node1:=ListNode{1,nil}
	node2:=ListNode{2,nil}
	node3:=ListNode{3,nil}
	node4:=ListNode{5,nil}
	l1=&node1
	node1.Next=&node3
	l2=&node2
	node2.Next=&node4
	result:=mergeTwoLists(l1,l2)
	for ;result.Next!=nil;{
		fmt.Print(result.Val)
		result=result.Next
	}
	fmt.Print(result.Val)

}
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1==nil{
		return l2
	}
	if l2==nil{
		return l1
	}
	var result,pre *ListNode
	first:=ListNode{math.MinInt16,l1}
	result=&first
	pre = result
	for ;;{
		if l1.Val<=l2.Val {
			pre.Next=l1
			pre = pre.Next
			l1=l1.Next
			if l1==nil{
			break
			}
		}else{
			pre.Next=l2
			pre=pre.Next
			l2=l2.Next
			if l2==nil{
				break
				}
		}
	}
	if l1==nil{
		pre.Next=l2
	}else{
		pre.Next=l1
	}
	return result
}
