package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum_18 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(nums, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j - 1 != i && nums[j] == nums[j - 1]) {
                    continue;
                }
                int pre = j + 1, end = nums.length - 1;
                while (pre != i && pre != j && end != i && end != j && pre < end) {
                    if (nums[i] + nums[j] + nums[pre] + nums[end] == target) {
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[pre], nums[end])));
                        while (pre < end && nums[pre] == nums[pre + 1]) {
                            pre++;
                        }
                        while (pre < end && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        pre++;
                        end--;
                    } else if (nums[i] + nums[j] + nums[pre] + nums[end] < target) {
                        pre++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return result;
    }
    /*
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<4) return res;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n-3;i++){
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target)break;
            if(nums[i]+nums[n-1]+nums[n-2]+nums[n-3]<target)continue;
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target) break;
                if(nums[i]+nums[j]+nums[n-2]+nums[n-1]<target) continue;
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int low = j+1, high = n-1;
                while(low<high){
                    int sum = nums[i]+nums[j]+nums[low]+nums[high];
                    if(sum==target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                        while(low<high && nums[low]==nums[low+1])low++;
                        while(low<high && nums[high]==nums[high-1])high--;
                        low++;
                        high--;
                    }
                    else if(sum<target) low++;
                    else high--;
                }
            }
        }
        return res;

    }*/
}
