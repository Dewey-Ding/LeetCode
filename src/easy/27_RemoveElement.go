package easy

import "fmt"

func main(){
	arr:=[]int{2,3,2,3}
	fmt.Print(removeElement(arr,2))
}
func removeElement(nums []int, val int) int {
	count:=len(nums)
	move:=0
	for i:=0;i<count;i++{
		if nums[i]==val{
			move++
			continue
		}
		nums[i-move] = nums[i]
	}
	return count-move
}