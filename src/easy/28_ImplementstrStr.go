package easy

import (
	"fmt"
)

func main(){
	fmt.Print(strStr("a","a"))
}
func strStr(haystack string, needle string) int {
	if len(needle)==0{
		return 0
	}
	for i:=0;i<=len(haystack)-len(needle);i++{
		match:=true
		for j:=0;j<len(needle);j++{
			if haystack[i+j]!=needle[j] {
				match=false
				break
			}
		}
		if match{
			return i
		}
	}
	return -1
}


/*
func strStr(haystack string, needle string) int {
	if len(haystack)==0&&len(needle)==0{
		return 0
	}
	if len(haystack)==0{
		return -1
	}
	if len(needle)==0{
		return 0
	}
	for i,j,count:=0,0,len(haystack);i<count;i++{
		if haystack[i]!=needle[j]{
			continue
		}
		for lens:=len(needle);j<lens;j++{
			if i+j<count&&haystack[i+j]==needle[j]{
				if j==lens-1{
					return i
				}
				continue
			}
			j=0
			break
		}
	}
	return -1
}*/
