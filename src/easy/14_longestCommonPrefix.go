package easy

import "fmt"

func main(){
	strs:=[]string{"a","ab","ab"}
	fmt.Print(longestCommonPrefix(strs))
}
func longestCommonPrefix(strs []string) string {
	if len(strs)==0 {
		return ""
	}
	if len(strs)==1 {
		return strs[0]
	}
	for j:=1;j<=len(strs[0]);j++ {
		for i:=1;i<len(strs);i++ {
			if j>len(strs[i]) {
				return strs[0][0:j-1]
			}
			if strs[0][0:j]!=strs[i][0:j] {
				if(j==1){
					return ""
				}else{
					return strs[0][0:j-1]
				}
			}
		}
		if j==len(strs[0]){
			return strs[0][0:j]
		}
	}
	return ""
}
