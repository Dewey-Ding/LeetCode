package medium;

/**
 * @author dewey
 * @date 2019-09-16 22:31
 */
public class ArithmeticSlices_413 {
    public static void main(String[] args) {
        int A[] = new int[]{1,2,3,8,9,10};
        System.out.println(numberOfArithmeticSlices(A));
    }

    /**
     * dp[i]表示以i元素结尾的等差数列个数，如果A[i]-A[i-1]==A[i-1]-A[i-2]则dp[i]=dp[i-1]+1.
     * 最后是以各个元素结尾的等差数列的和为整个数列的子等差数列和
     * @param A
     * @return
     */
    public static int numberOfArithmeticSlices(int[] A) {
        if(A.length<=2){
            return 0;
        }
        int dp[] = new int[A.length];
        dp[0]=dp[1]=0;
        for (int i = 2; i < A.length; i++) {
            if(A[i]-A[i-1]==A[i-1]-A[i-2]){
                dp[i] = dp[i-1]+1;
            }
        }
        int total = 0;
        for (int i = 0; i < dp.length; i++) {
            total+=dp[i];
        }
        return total;
    }
}
