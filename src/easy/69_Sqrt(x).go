package easy

import "fmt"

func main(){
	fmt.Print(mySqrt(17))
}

func mySqrt(x int) int {
	if x==0{
		return 0
	}
	if x==1{
		return 1
	}
	end,pre:=x,0
	for end-pre>1{
		mid := (pre+end)/2
		if mid*mid<x{
			pre = mid
		}else if mid*mid>x{
			end = mid
		}else{
			return mid
		}
	}
	return pre
}