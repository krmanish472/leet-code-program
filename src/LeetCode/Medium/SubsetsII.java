package LeetCode.Medium;

/*
* Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
* The solution set must not contain duplicate subsets. Return the solution in any order.
* Example 1:
    Input: nums = [1,2,2]
    Output: [[],[1],[1,2],[1,2,2],[2],[2,2]] // note here we could have had duplicate [1,2]

* Example 2:
    Input: nums = [0]
    Output: [[],[0]]
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = subsetsWithDup(nums);

        System.out.println(res);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int index) {
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            // skip duplicates - if curr equals prev
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]);
            backtrack(result, current, nums, i + 1);
            current.removeLast();
        }
    }
}
