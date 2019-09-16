package medium;

/**
 * @author dewey
 * @date 2019-09-03 22:10
 */
public class HouseRobberII_213 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1}));
    }
    public static int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int n = nums.length;
        int a = helper(nums,0,n-1);
        int b = helper(nums,1,n);
        /**
         * 相当于两个连着的房间，只能取一个max值
         */
        return Math.max(a,b);
    }
    public static int helper(int[] nums,int start,int end){
        int pre1 = 0;
        int pre2 = 0;
        int curr = 0;
        for (int i = start; i < end; i++) {
            curr = Math.max(pre2+nums[i],pre1);
            pre2 = pre1;
            pre1 = curr;
        }
        return curr;
    }
}
