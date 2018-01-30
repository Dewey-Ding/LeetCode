package medium;

public class JumpGame_55 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,0,0,1};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        System.out.println(canJump(nums));
    }
    //perfect
    public static boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
/*    public static boolean canJump(int[] nums){
        int start = 0;
        for (int i = 1; i < nums[start]; i++) {
            int interval = nums.length-1;
            while(start!=nums.length-1){
                if(nums[start]>=interval){
                    return true;
                }else{
                    if(start+i<nums.length){
                        start = start+i;
                    }
                }
            }
        }
        return false;
    }*/

    //stackoverflowerror
    public static boolean canJump1(int[] nums) {
        if(nums.length==1){
            return true;
        }
        return helper(nums,0,nums.length-1);
    }
    public static boolean helper(int[] nums,int start,int intervel){
        int count = nums[start];
        if(count>=intervel){
            return true;
        }
        for (int i = 1; i <= count&&i<nums.length; i++) {
            if(start+i<nums.length) {
                return helper(nums, start + i, intervel - i);
            }
        }
        return false;
    }

    public static boolean canJump2(int[] nums) {
        if( nums == null || nums.length == 0 ) {
            return false;
        }

        int available = nums[0];

        for(int i = 1; i < nums.length; i++ ){
            if( available < i ) {
                return false;
            }

            available = Math.max( available, nums[i] + i);
        }

        return available >= nums.length - 1;
    }
}
