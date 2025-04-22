package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Given a collection of candidate numbers (candidates) and a target number (target)
* find all unique combinations in candidates where the candidate numbers sum to target.
* Each number in candidates may only be used once in the combination.
* Note: The solution set must not contain duplicate combinations.

* Example 1:
    Input: candidates = [10,1,2,7,6,1,5], target = 8
    Output:
    [[1,1,6], [1,2,5], [1,7], [2,6]]

Example 2:
    Input: candidates = [2,5,2,1,2], target = 5
    Output:
    [[1,2,2], [5]]
* */

public class CombinationSumII {
    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(nums, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, ArrayList<Integer> current, int[] nums, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            // skip duplicates - if curr equals prev
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            if (target - nums[i] < 0) {
                break;
            }
            current.add(nums[i]);
            backtrack(result, current, nums, target - nums[i], i + 1);
            current.removeLast();
        }
    }
}
