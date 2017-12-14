package easy

import (
	"fmt"
)

func main(){
	nums:=[]int{1,3,5,6}
	fmt.Print(searchInsert(nums,7))
}
func searchInsert(nums []int, target int) int {
	if target>nums[len(nums)-1]{
		return len(nums)
	}
	for i:=0;i<len(nums);i++{
		if target<=nums[i]{
			return i
		}
	}
	return 0
}