package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII_47 {
    //含相同元素，不能使用set
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,3,3};
        System.out.println(permuteUnique(nums));
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        int[] flag = new int[nums.length];
        Arrays.sort(nums);
        permuteUniqueHelper(result,subset,flag,nums,0);
        return result;
    }
    public static void permuteUniqueHelper(List<List<Integer>> result, List<Integer> subset,int[] flag,int[] nums,int count){
        if(count==nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }else{
            for (int i = 0; i < nums.length; i++) {
                if(flag[i]==1){
                    continue;
                }else if(i>0&&nums[i]==nums[i-1]&&flag[i-1]==0){
                    continue;
                }else{
                    subset.add(nums[i]);
                    flag[i] = 1;
                    permuteUniqueHelper(result,subset,flag,nums,count+1);
                    subset.remove(subset.size()-1);
                    flag[i] = 0;
                }
            }
        }
    }
}
