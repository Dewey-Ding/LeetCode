package medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {
    public static void main(String[] args) {
        List<List<Integer>> lists = combine(4, 2);
        System.out.println(lists);
    }

    public static List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        int[] result = new int[k];
        helper(lists, nums, result, 0, 0, k);
        return lists;
    }

    public static void helper(List<List<Integer>> lists, int[] nums, int[] result, int count, int index, int length) {
        if (count == length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                list.add(result[i]);
            }
            lists.add(list);
        } else if (count < length) {
            for (int i = index; i < nums.length; i++) {
                result[count++] = nums[index++];
                helper(lists, nums, result, count, index, length);
                count--;
            }
        }
    }
}
