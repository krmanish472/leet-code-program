package LeetCode.Easy;

import java.util.Arrays;

/*
* Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn)
* such that the sum of min(ai, bi) for all i is maximized.
* Return the maximized sum.

* Example 1:
    Input: nums = [1,4,3,2]
    Output: 4
    Explanation: All possible pairings (ignoring the ordering of elements) are:
    1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
    2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
    3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
    So the maximum possible sum is 4.
* */
public class ArrayPartition {
    public static void main(String[] args) {

    }

    // Note: Given 2n integers. We need to create n pairs.
    // Which means that the number of pairs is half of the given array.
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            sum += nums[i];
        }

        return sum;
    }
}
