package easy

import (
	"fmt"
)

func main(){
	s:="MCMXCVI"
	fmt.Print(romanToInt(s))
}
func romanToInt(s string) int {
	count:=len(s)-1
	result:=0
	last:=0
	for count>=0 {
		switch s[count] {
		case 'M':
			result+=1000
			last=1000
		case 'D':
			if last>500{
				result-=500
			}else {
				result += 500
			}
			last=500
		case 'C':
			if last>100{
				result-=100
			}else {
				result += 100
			}
			last=100
		case 'L':
			if last>50{
				result-=50
			}else {
				result += 50
			}
			last=50
		case 'X':
			if last>10{
				result-=10
			}else {
				result += 10
			}
			last=10
		case 'V':
			if last>5{
				result-=5
			}else {
				result += 5
			}
			last=5
		case 'I':
			if last>1{
				result-=1
			}else {
				result += 1
			}
			last=1
		}
		count--
	}
	return result
}