package medium;

import java.util.ArrayList;

/**
 * @author dewey
 * @date 2019-10-20 17:10
 */
public class LongestIncreasingSubsequence_300 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,6,7,9,4,10,5,6};
        int count = lengthOfLIS(nums);
        System.out.println();
        System.out.println(count);
    }

    /**
     * O(n*n)
     * @param nums
     * @return
     */
    public static int lengthOfLIS2(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int alwaysMax = 0;
        int result[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            //自己作为一个递增数列
            int max = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]) {
                    max = Math.max(result[j]+1,max);
                }
            }
            result[i] = max;
            alwaysMax = Math.max(alwaysMax,max);
        }
        return alwaysMax;
    }

    /**
     * O(nlogn)
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        ArrayList<Integer> help = new ArrayList<>();
        for (int num:nums){
            if (help.size()==0 || help.get(help.size()-1)<num) help.add(num);
            else{
                int insert = bi_se(help,num);
                help.set(insert,num);
            }
        }
        return help.size();
    }

    private static int bi_se(ArrayList<Integer> help,int target){
        int l=0,r=help.size()-1;
        while (l<=r){
            int mid=(l+r)/2;
            int getter = help.get(mid);
            if (getter==target) return mid;
            else if(getter>target) r=mid-1;
            else l=mid+1;
        }
        return l;
    }
}
