package medium;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArrayII_80 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        Arrays.sort(nums);
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int before = nums[0];
        int length = 1;
        int count = 1;
        for (int i = 1, j = 1; i < nums.length && j < nums.length; i++) {
            if (nums[i] == before && count < 2) {
                length++;
                count++;
                if (j != i) {
                    nums[j] = nums[i];
                }
                j++;
            } else if (nums[i] != before) {
                length++;
                count = 1;
                before = nums[i];
                if (j != i) {
                    nums[j] = nums[i];
                }
                j++;
            }
        }
        return length;
    }
}
