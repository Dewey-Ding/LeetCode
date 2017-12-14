package easy

import (
	"fmt"
)

func main(){
	nums:=[]int{-2,1,-3,4,-1,2,1,-5,4}
	fmt.Print(maxSubArray(nums))
}
func maxSubArray(nums []int) int {
	max:=nums[0]
	for sum,i:=nums[0],1;i<len(nums);i++{
		if sum<0{
			sum=nums[i]
		}else {
			sum=sum+nums[i]
		}
		if sum>max{
			max = sum
		}
	}
	return max
}