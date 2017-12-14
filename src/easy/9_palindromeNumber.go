package easy

import "fmt"

func main(){
	fmt.Print(isPalindrome(10))

}
func isPalindrome(x int) bool {
	if x<0{
		return false
	}
	revert:=0
	y:=x
	for y>0{
		revert=revert*10+y%10
		y=y/10
	}
	return revert==x
}
