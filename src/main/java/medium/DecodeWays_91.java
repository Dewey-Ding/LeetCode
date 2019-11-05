package medium;

/**
 * @author dewey
 * @date 2018/10/23 22:09
 */
public class DecodeWays_91 {
    public static void main(String[] args) {
        String test = "0";
        System.out.println(numDecodings(test));
    }
    public static int numDecodings(String s) {
        int[] result = new int[s.length()+1];
        result[0] = 1;
        result[1] = s.charAt(0)=='0'?0:1;
        for (int i = 2; i <= s.length(); i++) {
            int oneDigit = s.charAt(i-1)-'0';
            int twoDigit = Integer.valueOf(s.substring(i-2,i));
            if(oneDigit>0&&oneDigit<=9){
                result[i]+=result[i-1];
            }
            if(twoDigit>=10&&twoDigit<=26){
                result[i]+=result[i-2];
            }
        }
        return result[s.length()];
    }

}
