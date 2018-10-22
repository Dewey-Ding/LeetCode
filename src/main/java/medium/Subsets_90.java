package main.java.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dewey
 * @date 2018/10/22 21:14
 */
public class Subsets_90 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        System.out.println(subsetsWithDup(nums).toString());
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            Helper(result,temp,i,nums);
        }
        return result;
    }

    /**
     * 递归查找子序列
     * @param result
     * @param temp
     * @param index
     * @param nums
     */
    public static void Helper(List<List<Integer>> result,List<Integer> temp,int index,int nums[]){
        if(!result.contains(temp)){
            result.add(new ArrayList<>(temp));
        }
        for (int i = index+1; i < nums.length; i++) {
            if(i>index+1&&nums[i]==nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            Helper(result,temp,i,nums);
            temp.remove(temp.size()-1);
        }
    }
}
