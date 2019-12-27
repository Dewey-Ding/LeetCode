package hard;


public class InterleavingString_97 {
    public static void main(String[] args) {
        System.out.println((test.HELLO.getValue()).getClass());
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(s1.getClass());
        System.out.println(isInterleave(s1,s2,s3));
        System.out.println(isInterleave2(s1,s2,s3));
        System.out.println(isInterleave3(s1,s2,s3));
    }
    public static boolean isInterleave3(String s1, String s2, String s3) {

        if (s3.length() != s1.length() + s2.length()) return false;

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = dp[i-1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);

        }
        for (int j = 1; j <= s2.length(); j++) {
            dp[0][j] = dp[0][j-1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= s1.length(); i++ ) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i][j] = (dp[i-1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j-1]  && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }

        return dp[s1.length()][s2.length()];

    }
    public static boolean isInterleave2(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        char[] remain = new char[s2.length()];
        int index3 = 0,index2=0;
        for (int i = 0; i < s1.length(); i++) {
            while (index3<s3.length()&&s1.charAt(i)!=s3.charAt(index3)){
                remain[index2++] = s3.charAt(i);
                index3++;
            }
        }
        String remainStr = new String(remain);
        return remainStr.equals(s2);
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        return Helper(s1.toCharArray(),s2.toCharArray(),s3.toCharArray(),0,0,0);
    }
    public static boolean Helper(char[] s1, char[] s2, char[] s3,int index1,int index2,int index3){
        if(index3 == s3.length){
            return true;
        }
        if(index1<s1.length&&index2<s2.length&&s3[index3] == s1[index1] && s3[index3] == s2[index2]){
            return Helper(s1,s2,s3,index1+1,index2,index3+1)||Helper(s1,s2,s3,index1,index2+1,index3+1);
        }else if(index1<s1.length && s3[index3] == s1[index1]){
            return Helper(s1,s2,s3,index1+1,index2,index3+1);
        }else if(index2<s2.length && s3[index3] == s2[index2]){
            return Helper(s1,s2,s3,index1,index2+1,index3+1);
        }else{
            return false;
        }
    }
    public enum test{

        HELLO("Hello"),
        WORLD("World");

        private String value;
        private test(String value){
            this.value = value;
        }
        public String getValue(){
            return this.value;
        }
    }
}
