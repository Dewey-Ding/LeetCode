package easy

import "fmt"

func main(){
	var result[] int
	nums := []int{2,7,11,15}
	target := 9
	result = twoSum(nums,target)
	fmt.Println(result)
}
func twoSum(nums []int, target int) []int {
	temp:=make([]int,2)
	count:=0
	flage:=false
	for i:=0;i<len(nums);i=i+1{
		for j:=i+1;j<len(nums);j=j+1{
			if nums[i]+nums[j]==target{
				temp[count] = i
				temp[count+1] = j
				flage=true
				break
			}
		}
		if flage{
			break
		}
	}
	return temp
}