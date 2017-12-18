package medium;

public class StringtoInteger_atoi_8 {
    public static void main(String[] args) {
        StringtoInteger_atoi_8 stringtoInteger_atoi_8 = new StringtoInteger_atoi_8();
        System.out.println(stringtoInteger_atoi_8.myAtoi("      -11919730356x"));
    }
    public int myAtoi(String str) {
        int j=0,flag=1,result = 0;
        if(str==null||str.length()==0){
            return result;
        }
        while (str.charAt(j)==' '){
            j++;
        }
        if(str.charAt(j)=='-'||str.charAt(j)=='+'){
            flag=str.charAt(j)=='-'?-1:1;
            j++;
        }
        for(int i=j;i<str.length();i++){
            if(str.charAt(i)-'0'<0||str.charAt(i)-'9'>0){
                return flag*result;
            }
            if(flag==1&&(result>Integer.MIN_VALUE/10||(result==Integer.MIN_VALUE/10&&str.charAt(i)-'0'>7))){
                return 2147483647;
            }else if(flag==-1&&(result>Integer.MIN_VALUE||(result==Integer.MIN_VALUE/10&&flag==-1&&str.charAt(i)-'0'>8))){
                return -2147483648;
            }
            result=10*result+str.charAt(i)-'0';
        }
        return flag*result;
    }
}
