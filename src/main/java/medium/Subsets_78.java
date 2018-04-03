package medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = subsets(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            helper(lists, new ArrayList<>(), nums, 0, 0, i);
        }
        return lists;
    }

    public static void helper(List<List<Integer>> lists, List<Integer> list, int[] nums, int count, int index, int k) {
        if (count == k) {
            lists.add(new ArrayList<>(list));
        } else if (count < k) {
            for (int i = index; i < nums.length; i++, index++) {
                list.add(nums[i]);
                helper(lists, list, nums, count + 1, index + 1, k);
                list.remove(list.size() - 1);
            }
        }
    }
}
