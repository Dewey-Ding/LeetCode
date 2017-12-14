package easy

import "fmt"

func main(){
	nums:=[]int{1,1,2,2,3,5,5}
	fmt.Print(removeDuplicates(nums))
}
func removeDuplicates(nums []int) int {
	count:=len(nums)
	if count == 0{
		return 0
	}
	result :=1
	for i,x:=1,nums[0];i<count;i++{
		if x != nums[i]{
			nums[result]=nums[i]
			result++
			x=nums[i]
		}
	}
	return result
}