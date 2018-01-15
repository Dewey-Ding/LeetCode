package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII_40 {
    public static void main(String[] args) {
        int[] candidates = new int[]{2,2,2};
        int target = 4;
        System.out.println(combinationSum2(candidates,target));
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int[] nums = new int[target];
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result,candidates,nums,0,0,target);
        return result;
    }
    public static void backtrack(List<List<Integer>> result,int[] candidates,int[] nums,int index,int count,int remain){
        if(remain == 0){
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                list.add(nums[i]);
            }
            result.add(list);
            return;
        }else if(remain<0){
            return;
        }else{
            for (int i = index; i < candidates.length; i++) {
                //注意去掉重复。每一次循环中i>index且该数和前一个相等时跳过该数
                if(i>index&&candidates[i]==candidates[i-1]){
                    continue;
                }
                nums[count] = candidates[i];
                backtrack(result,candidates,nums,i+1,count+1,  remain-candidates[i]);
            }
        }
    }
}
