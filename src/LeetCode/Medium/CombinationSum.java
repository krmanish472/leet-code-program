package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

/*
* Given an array of distinct integers candidates and a target integer target
* return a list of all unique combinations of candidates where the chosen numbers sum to target.
* You may return the combinations in any order.
* The same number may be chosen from candidates an unlimited number of times.
* Two combinations are unique if the frequency of at least one of the chosen numbers is different.
* Example 1:
    Input: candidates = [2,3,6,7], target = 7
    Output: [[2,2,3],[7]]
    Explanation:
    2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
    7 is a candidate, and 7 = 7.
    These are the only two combinations.
Example 2:
    Input: candidates = [2,3,5], target = 8
    Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:
    Input: candidates = [2], target = 1
    Output: []
* */

public class CombinationSum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(nums, target));
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> current,
                                  int[] nums, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
        } else if (target < 0) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(result, current, nums, target - nums[i], i);
            current.removeLast();
        }
    }
}
