package LeetCode.Easy;

/*
* You are given an integer array nums and an integer k.
* You can perform the following operation any number of times:
    Select an index i and replace nums[i] with nums[i] - 1.

* Return the minimum number of operations required to make the sum of the array divisible by k.

* Example 1:
    Input: nums = [3,9,7], k = 5
    Output: 4
    Explanation:
    Perform 4 operations on nums[1] = 9. Now, nums = [3, 5, 7].
    The sum is 15, which is divisible by 5.

* Example 2:
    Input: nums = [4,1,3], k = 4
    Output: 0
    Explanation:
    The sum is 8, which is already divisible by 4. Hence, no operations are needed.

 * */

import java.util.Arrays;

public class MinimumOperationsToMakeArraySumDivisibleByK {
    public static void main(String[] args) {
        int[] nums = {3, 9, 7};
        int k = 5;

        int minOp = minOperations(nums, k);
        System.out.println(minOp);
    }

    public static int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int el : nums) {
            sum += el;
        }

        return sum % k;
    }
}
