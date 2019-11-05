package medium;

/**
 * @author dewey
 * @date 2019-09-17 22:27
 */
public class IntegerBreak_343 {
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
    public static int integerBreak(int n) {
        int dp[] = new int[n+1];
        dp[1]=dp[2]=1;
        for (int i = 2; i < n+1; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i],Math.max(dp[i-j]*j,(i-j)*j));
            }
        }
        return dp[n];
    }
}

