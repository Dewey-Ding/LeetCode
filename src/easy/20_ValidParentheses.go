package easy

import "fmt"

func main() {
	fmt.Print(isValid("]"))
}
func isValid(s string) bool {
	count := 0
	var a [5000000] int
	for i := 0; i < len(s); i++ {
		switch s[i] {
		case '(':
			a[count] = i
			count++
		case '{':
			a[count] = i
			count++
		case '[':
			a[count] = i
			count++
		case ')':
			count--
			if count<0||s[a[count]]!='('{
				return false
			}
		case '}':
			count--
			if count<0||s[a[count]]!='{'{
				return false
			}
		case ']':
			count--
			if count<0||s[a[count]]!='['{
				return false
			}

		}
	}
	if count!=0{
		return false
	}
	return true
}


//利用对称性更简单
/*
var CloseP map[byte]byte = map[byte]byte{')':'(' , ']':'[', '}':'{'}
var OpenP map[byte]byte = map[byte]byte{'(':')' , '[':']', '{':'}'}

func isValid(s string) bool {
	buf := make([]byte,0, len(s))
	for i:=0;i<len(s);i++{
		c := s[i]
		if _,ok := OpenP[c]; ok{
			buf =append(buf,c)
			continue
		}
		openOne:=CloseP[c]
		bufLen := len(buf)
		if len(buf)<=0 || buf[bufLen-1] != openOne{
			return false
		}
		buf = buf[:bufLen-1]
	}
	return len(buf)==0
}*/
