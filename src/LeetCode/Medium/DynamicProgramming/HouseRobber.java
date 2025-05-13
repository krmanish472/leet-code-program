package LeetCode.Medium.DynamicProgramming;

/*
* You are a professional robber planning to rob houses along a street.
* Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that
* adjacent houses have security systems connected and it will automatically contact the police
* if two adjacent houses were broken into on the same night.
*
* Given an integer array nums representing the amount of money of each house,
* return the maximum amount of money you can rob tonight without alerting the police.

* Example 1:
    Input: nums = [1,2,3,1]
    Output: 4
    Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
    Total amount you can rob = 1 + 3 = 4.

* Example 2:
    Input: nums = [2,7,9,3,1]
    Output: 12
    Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
    Total amount you can rob = 2 + 9 + 1 = 12.
* */
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};

        System.out.println(rob(nums));
        System.out.println(rob(new int[]{1, 2, 3, 1}));
    }

    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];

        // memoize maximum loot at first 2 index
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            // core logic
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    // alternate solution - similar to ClimbingStairs & MinCostClimbingStairs
    public static int rob_withoutDPArray(int[] nums) { // rob1, rob2, n, ...
        int rob1 = 0;
        int rob2 = 0;

        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = max;
        }
        return max;
    }
}
