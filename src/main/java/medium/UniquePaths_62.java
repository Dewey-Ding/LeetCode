package medium;

public class UniquePaths_62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(51, 9));
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
}
