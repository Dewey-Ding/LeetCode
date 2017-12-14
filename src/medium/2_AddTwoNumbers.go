package medium

import (
	"fmt"
)

type ListNode struct {
	Val  int
	Next *ListNode
}
func main(){
	var l1,l2 *ListNode
	x1:=ListNode{5,nil}
	//x2:=ListNode{4,nil}
	//x3:=ListNode{3,nil}
	y1:=ListNode{5,nil}
	//y2:=ListNode{6,nil}
	//y3:=ListNode{4,nil}
	l1 = &x1
	//x1.Next=&x2
	//x2.Next=&x3
	l2 = &y1
	//y1.Next=&y2
	//y2.Next=&y3
	l3:=addTwoNumbers(l1,l2)
	for l3.Next!=nil {
		fmt.Print(" ",l3.Val)
		l3=l3.Next
	}
	fmt.Println(l3.Val)
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	point:=&ListNode{0,nil}
	result:=point
	add:=0
	for l1!=nil||l2!=nil{
		x:=0
		y:=0
		if l1!=nil{
			x=l1.Val
			l1=l1.Next
		}else{
			x=0
		}
		if l2!=nil{
			y=l2.Val
			l2=l2.Next
		}else{
			y=0
		}
		if x+y+add >= 10 {
			point.Next = &ListNode{ x+y+add-10, nil}
			add = 1
		} else {
			point.Next = &ListNode{x+y+add , nil}
			add=0
		}
		point=point.Next
	}
	if add==1{
		point.Next=&ListNode{1,nil}
	}
	return result.Next
}
