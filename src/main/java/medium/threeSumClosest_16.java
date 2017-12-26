package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSumClosest_16 {
    public static void main(String[] args) {
        int[] nums  = new int[]{0,2,1,-3};
        System.out.println(threeSumClosest(nums,1));
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = nums[0]+nums[1]+nums[2]-target;
        int flag = 0;
        if(min<0){
            flag = 1;
            min = - min;
        }
        for(int i = 0;i<nums.length-1;i++){
            int num1 = nums[i];
            if(i>0&&num1==nums[i-1]){
                continue;
            }
            int pre=i+1,end=nums.length-1;
            while(pre<end){
                int sum = num1+nums[pre]+nums[end]-target;
                if(sum == 0){
                    return num1+nums[pre]+nums[end];
                }else if(sum<0){
                    if(-sum<min) {
                        flag = 1;
                        min = -sum;
                    }
                    pre++;
                }else if(sum>0){
                    if(sum<min) {
                        flag = 0;
                        min = sum;
                    }
                    end--;
                }
            }
        }
        if(flag==1){
            return -min+target;
        }
        return min+target;
    }
}
