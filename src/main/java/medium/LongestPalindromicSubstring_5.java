package medium;

public class LongestPalindromicSubstring_5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbccccbc" ));
    }
    public static String longestPalindrome(String s) {
        if(s.length()==1){
            return s;
        }
        int maxpre=0,maxend=0;
        for(int i=0;i<s.length();i++){
            int pre=i,end=i;
            while(i+1<s.length()&&s.charAt(i)==s.charAt(i+1)){
                end = i+1;
                i++;
            }
            while(pre>0&&end<s.length()-1){
                if(s.charAt(pre-1)==s.charAt(end+1)){
                    pre--;
                    end++;
                    continue;
                }else{
                    break;
                }
            }
            if(end-pre>maxend-maxpre){
                maxend=end;
                maxpre=pre;
            }
        }
//        System.out.println(maxend);
//        System.out.println(maxpre);
        return s.substring(maxpre,maxend+1);
    }


}

/*
public static String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
        sb.append(s.charAt(i));
        }
        String s1 = sb.toString();
        int maxend=0,maxpre=0;
        for(int j=1-s.length();j<s.length();j++) {
        String subs = s.substring(j,s1.length());
        String subs1 = s1.substring(0,s1.length()-j);
        System.out.println(subs+"   "+subs1);
        int pre=-1,end=-1;
        for (int i = 0; i < subs.length(); i++) {
        if (subs.charAt(i) == subs1.charAt(i)) {
        if (pre == -1) {
        pre = i+j;
        }
        end = i+j;
        continue;
        }
        if (end - pre > maxend - maxpre) {
        maxend = end;
        maxpre = pre;
        pre=end=-1;
        }
        }
        if (end - pre > maxend - maxpre) {
        maxend = end;
        maxpre = pre;
        }
        }
          }
*/
