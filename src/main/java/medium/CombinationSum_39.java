package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39 {
    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,5};
        int target = 8;
        List<List<Integer>> result = combinationSum(candidates,target);
        for (int i = 0; i < result.size(); i++) {
            List<Integer> list = result.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.println(list.get(j));
            }
        }
    }

    /*
    *
    * */



    /*
    * backtrack
    * backtrack函数中nums表示当前的combination，remain表示combination的和与target的数值差。
    * index表示当前遍历cans的位置，是为了保持nums中从大到小的序列从而确保唯一性而设置的，
    * numcount是nums中有效元素的界限位置。
    * */
    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();
        int[] length = new int[target];
        Arrays.sort(candidates);
        backtrack(result,length,candidates,target,0,0);
        return result;
    }
    public static void backtrack(List<List<Integer>> result,int[] nums,int[] cans,int remain,int index,int numcount){
        if(remain == 0){
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < numcount; i++) {
                list.add(nums[i]);
            }
            result.add(list);
            return;
        }else if(remain < 0){
            return;
        }else if(remain>0){
            for (int i = index; i < cans.length; i++) {
                nums[numcount] = cans[i];
                backtrack(result,nums,cans,remain-cans[i],index,numcount+1);
                index++;
            }
        }
    }

    /*
    * dynamic program
    * 1.求和为target的List分解为和为1-target的list。（分解为子任务）
    * 2.单步循环candidates得到和为所求sub-target的所有可能组成方式。
    *   2.1 sub-target的combination在求解过程中list按asc顺序，避免防止重复。
    * */
    public static List<List<Integer>> combinationSumD(int[] candidates, int target) {
        int k = target/candidates[0];
        List<List<List<Integer>>> targetList = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        targetList.add(list);
        Arrays.sort(candidates);
        for (int i = 1; i <=target ; i++) {
            List<List<Integer>> kSum = kSum(targetList,candidates,i);
            targetList.add(kSum);
        }
        return targetList.get(target);
    }
    public static List<List<Integer>> kSum( List<List<List<Integer>>> targetList,int[] candidates,int k){
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            if(candidates[i] > k){
                break;
            }else if(candidates[i] == k){
                list.add(Arrays.asList(candidates[i]));
            }else{
                for(List<Integer> list1:targetList.get(k-candidates[i])){
                    if(candidates[i]>=list1.get(list1.size()-1)) {
                        List<Integer> tmp = new ArrayList<>(list1);
                        tmp.add(candidates[i]);
                        list.add(tmp);
                    }
                }
            }
        }
        return list;
    }
}
