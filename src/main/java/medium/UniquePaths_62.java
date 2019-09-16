package medium;

import java.util.Arrays;

public class UniquePaths_62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(51, 9));
        System.out.println(uniquePaths2(5, 3));
    }

    public static int uniquePaths(int m, int n) {
        if (m < n) {
            int tmp = m;
            m = n;
            n = tmp;
        }
        m--;
        n--;
        long result = 1;
        int[] flag = new int[n];
        int count = 0;
        for (int i = m + 1; i <= m + n; i++) {
            result = result * i;
            for (int j = 0; count != n && j < n; j++) {
                if (flag[j] == 0) {
                    if (result % (j + 1) == 0) {
                        result = result / (j + 1);
                        flag[j] = 1;
                        count++;
                    }
                }
            }
        }
        return (int) result;
    }

    public static int uniquePaths2(int m,int n){
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //到达上方的方法数与到达左方的方法数想加
                dp[j] = dp[j]+dp[j-1];
            }
        }
        return dp[n-1];
    }
}
