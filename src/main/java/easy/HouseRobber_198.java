package easy;

/**
 * @author dewey
 * @date 2019-09-03 21:47
 */
public class HouseRobber_198 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        int pre2 = 0;
        int pre1 = 0;
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            //对于当前房间i，如果抢则拿到的价值是它前两个房间的最大值+当前房间的价值
            //如果不抢则等于他前一个房间的最大值
            //所以当前房间的最大价值为上述两种情况中的最大者
            curr = Math.max(pre2+nums[i],pre1);
            pre2 = pre1;
            pre1 = curr;
        }
        return curr;
    }
}
