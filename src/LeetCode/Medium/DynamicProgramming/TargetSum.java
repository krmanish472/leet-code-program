package LeetCode.Medium.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/*
* You are given an integer array nums and an integer target.
* You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums
* and then concatenate all the integers.

* Return the number of different expressions that you can build, which evaluates to target.

* Example 1:
    Input: nums = [1,1,1,1,1], target = 3
    Output: 5
    Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
    -1 + 1 + 1 + 1 + 1 = 3
    +1 - 1 + 1 + 1 + 1 = 3
    +1 + 1 - 1 + 1 + 1 = 3
    +1 + 1 + 1 - 1 + 1 = 3
    +1 + 1 + 1 + 1 - 1 = 3

* Example 2:
    Input: nums = [1], target = 1
    Output: 1
* */

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;

        int noOfWays = findTargetSumWays(nums, target);
        System.out.println(noOfWays);
    }


    public static int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> dpMap = new HashMap<>(); // <Sum, Ways>
        dpMap.put(0, 1);

        for (int num : nums) {
            // temporary map to store new DP states for current iteration
            Map<Integer, Integer> nextDpMap = new HashMap<>();

            for (int sum : dpMap.keySet()) {
                int countWays = dpMap.get(sum);

                // add next number to sum
                nextDpMap.put(sum + num,
                        nextDpMap.getOrDefault(sum + num, 0) + countWays);

                // remove next number from sum
                nextDpMap.put(sum - num,
                        nextDpMap.getOrDefault(sum - num, 0) + countWays);
            }

            // update DP map
            dpMap = nextDpMap;
        }
        return dpMap.getOrDefault(target, 0);
    }
}
