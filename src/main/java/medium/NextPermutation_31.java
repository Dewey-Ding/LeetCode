package medium;

import java.util.Arrays;

public class NextPermutation_31 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2};
        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
    public static void nextPermutation(int[] nums) {
        int i = nums.length-1;
        while(i>0 && nums[i-1] >= nums[i]){
            i--;
        }
        if(i == 0){
            reverse(nums, i, nums.length-1);
            return;
        }


        int j = i;
        while(j<nums.length && nums[j] > nums[i-1]){
            j++;
        }

        j--;
        int temp = nums[i-1];
        nums[i-1] = nums[j];
        nums[j] = temp;

        reverse(nums, i, nums.length-1);
    }


    private static void reverse(int[] nums, int i, int j){
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

/*    public static void nextPermutation(int[] nums) {
        int exPre = -1,exEnd = 0;
        for (int i = nums.length-1; i > 0; i--) {
            for (int j = i; j >= 0 ; j--) {
                if(nums[i]>nums[j]){
                    if(j>exPre){
                        exPre = j;
                        exEnd = i;
                    }
                }
            }
        }
        if(exPre!=-1){
            int tmp = nums[exPre];
            nums[exPre] = nums[exEnd];
            nums[exEnd] = tmp;
        }
        Arrays.sort(nums,exPre+1,nums.length);
        return;
    }*/
}
