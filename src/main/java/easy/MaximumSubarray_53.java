package easy;

public class MaximumSubarray_53 {
    public static void main(String args[]){
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray_53 maximumSubarray_53 = new MaximumSubarray_53();
        System.out.println(maximumSubarray_53.maxSubArray(nums));
    }
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0)
                sum = nums[i];
            else
                sum += nums[i];
            if (sum > max)
                max = sum;
        }
        return max;
    }
}
