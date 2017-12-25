package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum_15 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0};
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i<nums.length-1;i++){
            int num1 = nums[i];
            if(i>0&&num1==nums[i-1]){
                continue;
            }
            int pre=i+1,end=nums.length-1;
            while(pre<end){
                if(num1+nums[pre]+nums[end]==0){
                    List<Integer> list = new ArrayList<>();
                    list.add(num1);
                    list.add(nums[pre]);
                    list.add(nums[end]);
                    while(pre<end&&nums[pre]==nums[pre+1]){
                        pre = pre+1;
                    }
                    while(end>pre&&nums[end]==nums[end-1]){
                        end = end-1;
                    }
                    result.add(list);
                    pre++;
                    end--;
                }else if(num1+nums[pre]+nums[end]>0){
                    end--;
                }else{
                    pre++;
                }
            }
        }
        return result;
    }
}
