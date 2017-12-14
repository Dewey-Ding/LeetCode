package easy

import "fmt"

func main(){
	result := reverse(1534236469)
	fmt.Print(result)
}
func reverse(x int) int {
	var result int = 0
	flag:=false
	//-2147483648||x>2147483647
	if x>2147483647||x<(-2147483648){
		return 0
	}
	if x<0{
		x = -x
		flag=true
	}
	for x>0{
		result=result*10+x%10
		x=x/10
	}
	if flag {
		if -result<(-2147483648) {
			return 0
		}
		return -result
	}else{
		if result>2147483647 {
			return 0
		}
		return result
	}
}
