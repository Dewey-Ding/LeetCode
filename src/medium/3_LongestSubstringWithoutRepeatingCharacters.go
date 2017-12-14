package medium

import "fmt"

func main() {
	fmt.Print(lengthOfLongestSubstring("abcabcbb"))
}
func lengthOfLongestSubstring(s string) int {
	pre, mPre, mEnd, max := 0, 0, 0, 0
	count := len(s)
	if count == 0 {
		return 0
	}
	for i := 0; i < count; i++ {
		for k := pre; k <= i; k++ {
			if s[i] == s[k] && i != k {
				pre = k + 1
				break
			}
		}
		if i-pre+1 > max {
			max = i - pre + 1
			mPre = pre
			mEnd = i
		}
	}
	max = mEnd - mPre + 1
	return max
}
