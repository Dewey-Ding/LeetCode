package medium;

public class MaximumProductSubarray_152 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,-5,-2,-4,3};
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {
        if(nums.length==0){
            return 0;
        }

        int maxPositive=Integer.MIN_VALUE,maxNegative=Integer.MAX_VALUE,max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(max == Integer.MIN_VALUE){
                max = nums[i];
            }else {
                max = max * nums[i];
            }
            if( max > 0){
                maxPositive = Math.max(maxPositive,max);
            }else if(max < 0 ){
                if(maxNegative<0){
                    max = maxNegative * max;
                    maxPositive = Math.max(max,maxPositive);
                    maxNegative = Integer.MAX_VALUE;
                }else {
                    maxNegative = Math.min(maxNegative,max);
                    max = Integer.MIN_VALUE;
                }
            }else{
                maxPositive = Math.max(max,maxPositive);
                maxNegative = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
            }

        }

        max =  Math.max(max,maxPositive);
        if(maxNegative!=Integer.MAX_VALUE) {
            max = Math.max(max, maxNegative);
        }
        return Math.max(max,maxRight(nums));
    }
    public static int maxRight(int[] nums){
        if(nums.length==0){
            return 0;
        }

        int maxPositive=Integer.MIN_VALUE,maxNegative=Integer.MAX_VALUE,max = Integer.MIN_VALUE;
        for (int i = nums.length-1; i >= 0; i--) {
            if(max == Integer.MIN_VALUE){
                max = nums[i];
            }else {
                max = max * nums[i];
            }
            if( max > 0){
                maxPositive = Math.max(maxPositive,max);
            }else if(max < 0 ){
                if(maxNegative<0){
                    max = maxNegative * max;
                    maxPositive = Math.max(max,maxPositive);
                    maxNegative = Integer.MAX_VALUE;
                }else {
                    maxNegative = Math.min(maxNegative,max);
                    max = Integer.MIN_VALUE;
                }
            }else{
                maxPositive = Math.max(max,maxPositive);
                maxNegative = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
            }

        }

        max =  Math.max(max,maxPositive);
        if(maxNegative!=Integer.MAX_VALUE) {
            return Math.max(max, maxNegative);
        }
        return max;
    }
}
