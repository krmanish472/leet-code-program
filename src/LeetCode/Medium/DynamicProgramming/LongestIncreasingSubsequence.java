package LeetCode.Medium.DynamicProgramming;

/*
* Given an integer array nums, return the length of the longest strictly increasing subsequence.

* Example 1:
    Input: nums = [10,9,2,5,3,7,101,18]
    Output: 4
    Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

* Example 2:
    Input: nums = [0,1,0,3,2,3]
    Output: 4

* Example 3:
    Input: nums = [7,7,7,7,7,7,7]
    Output: 1

* */

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        int lengthOfLIS = lengthOfLIS(nums);
        System.out.println(lengthOfLIS);
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        // start main pointer
        for (int i = 1; i < nums.length; i++) {
            // start second pointer
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) { // update only if the value will be more than existing
                        dp[i] = dp[j] + 1; // dp at any point will be at least 1 greater than previous point
                    }
                }
            }
        }
        // find the max value
        int maxIndex = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }
        return dp[maxIndex] + 1; // array is initialized with 0 so add 1
    }
}
