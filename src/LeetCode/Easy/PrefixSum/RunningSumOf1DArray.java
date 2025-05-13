package LeetCode.Easy.PrefixSum;

import java.util.Arrays;

/*
* Given an array nums. We define a running sum of an array as
* runningSum[i] = sum(nums[0]…nums[i]).

* Return the running sum of nums.

* Example 1:
    Input: nums = [1,2,3,4]
    Output: [1,3,6,10]
    Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

* Example 2:
    Input: nums = [1,1,1,1,1]
    Output: [1,2,3,4,5]
    Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
* */

public class RunningSumOf1DArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        int[] res = runningSum(nums);
        System.out.println(Arrays.toString(res));
    }

    // Note: {1, 2, 3, 4} => 1st will remain same => {1, 2, 3, 4}
    // For 2 => sum is 1 + 2 => {1, 3, 3, 4}
    // For 3 => sum is 1 + 2 + 3 => Now we already know that the sum of 1 + 2 is 3
    // so, 1 + 2 + 3 => 3 (prefix sum) + 3
    // Logic: sum at i is prefix sum + num[i]
    // where prefix sum is nums[i-1] i.e. already calculated sum till i-1
    public static int[] runningSum(int[] nums) {
        // prefix sum
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
