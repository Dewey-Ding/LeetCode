package easy

import "fmt"

func main(){
	digits:=[]int{9,9}
	fmt.Print(plusOne(digits))
}
func plusOne(digits []int) []int {
	for i:=len(digits)-1;i>=0;i--{
		if digits[i]<9{
			digits[i] = digits[i]+1
			return digits
		}
		digits[i]=0
	}
	slice:=make([]int,len(digits)+1)
	slice[0] = 1
	return slice
}