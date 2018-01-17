package medium;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        premuteHelper1(result,subset,nums);
        return result;
    }
    public static void premuteHelper1(List<List<Integer>> result,List<Integer> subset,int[] nums){
        if(subset.size()==nums.length){
            //不能直接添加subset不然对subset的后续操作会影响到result
            result.add(new ArrayList<>(subset));
            return;
        }else{
            for (int i = 0; i < nums.length; i++) {
                if(subset.contains(nums[i])){
                    continue;
                }else{
                    subset.add(nums[i]);
                    premuteHelper1(result,subset,nums);
                    subset.remove((Integer) nums[i]);
                }
            }
            return;
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        int[] flag = new int[nums.length];
        premuteHelper(result,subset,flag,nums,0);
        return result;
    }
    public static void premuteHelper(List<List<Integer>> result, List<Integer> subset,int[] flag,int[] nums,int count){
        if(count==nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }else{
            for (int i = 0; i < nums.length; i++) {
                if(flag[i]==1){
                    continue;
                }else{
                    subset.add(nums[i]);
                    flag[i] = 1;
                    premuteHelper(result,subset,flag,nums,count+1);
                    subset.remove(subset.size()-1);
                    flag[i] = 0;
                }
            }
        }
    }
}
