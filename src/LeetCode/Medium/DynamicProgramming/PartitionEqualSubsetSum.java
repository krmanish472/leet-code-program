package LeetCode.Medium.DynamicProgramming;

/*
* Given an integer array nums, return true if you can partition the array into two subsets
* such that the sum of the elements in both subsets is equal or false otherwise.
* Example 1:
    Input: nums = [1,5,11,5]
    Output: true
    Explanation: The array can be partitioned as [1, 5, 5] and [11].
* Example 2:
    Input: nums = [1,2,3,5]
    Output: false
    Explanation: The array cannot be partitioned into equal sum subsets.
* */

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        int[] nums2 = {1, 2, 3, 5};

        if (canPartition(nums)) {
            System.out.println("Can partition");
        } else {
            System.out.println("Can not partition");
        }
    }

    public static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // if sum is even, we can't make partition
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                if (dp[i - num]) {
                    dp[i] = true;
                }
            }
        }

        return dp[target];
    }
}
