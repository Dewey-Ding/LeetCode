package easy

import "fmt"

func main()  {
	fmt.Print(lengthOfLastWord("   "))
}
func lengthOfLastWord(s string) int {
	pre,count:=0,0
	for _,v := range s{
		if v==rune(' '){
			if count!=0{
				pre=count
				count=0
			}
			continue
		}else{
			count++
		}
	}
	if count==0{
		return pre
	}
	return count
}