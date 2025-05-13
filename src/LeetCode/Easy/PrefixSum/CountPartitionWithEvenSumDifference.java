package LeetCode.Easy.PrefixSum;

/*
* You are given an integer array nums of length n.


* A partition is defined as an index i where 0 <= i < n - 1, splitting the array into two non-empty subarrays such that:
    Left subarray contains indices [0, i].
    Right subarray contains indices [i + 1, n - 1].

* Return the number of partitions where the difference between the sum of the left and right subarrays is even.

* Example 1:
    Input: nums = [10,10,3,7,6]
    Output: 4
    Explanation:
    The 4 partitions are:
    [10], [10, 3, 7, 6] with a sum difference of 10 - 26 = -16, which is even.
    [10, 10], [3, 7, 6] with a sum difference of 20 - 16 = 4, which is even.
    [10, 10, 3], [7, 6] with a sum difference of 23 - 13 = 10, which is even.
    [10, 10, 3, 7], [6] with a sum difference of 30 - 6 = 24, which is even.
* */

public class CountPartitionWithEvenSumDifference {
    public static void main(String[] args) {
        int[] arr = {10, 10, 3, 7, 6};
        int res = countPartitions(arr);
        System.out.println(res);
    }

    public static int countPartitions(int[] nums) {
        int count = 0;

        // prefix sum - 10, 20, 23, 30, 36
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        for (int i = 0; i < nums.length - 1; i++) {
            // Note:
            // nums[i] at i represents prefix sum i.e. sum of elements until i [leftSum]
            // last element i.e sum of all elements - current element i.e sum of elements on left (prefix sum) gives right element sum

            int rightSum = nums[nums.length - 1] - nums[i];
            if (Math.abs(nums[i] - rightSum) % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    public static int countPartitions_basic(int[] nums) {
        // approach: find count of => left partition sum - right partition sum = even number
        int evenDiffCount = 0;

        // we need to traverse only till length-1 as the last element will not have any right part
        for (int i = 0; i < nums.length - 1; i++) {
            int leftPartSum = 0;
            int rightPartSum = 0;

            for (int left = 0; left <= i; left++) {
                leftPartSum += nums[left];
            }
            for (int right = i + 1; right < nums.length; right++) {
                rightPartSum += nums[right];
            }

            // use abs as the diff might be negative
            if (Math.abs(leftPartSum - rightPartSum) % 2 == 0) {
                evenDiffCount++;
            }
        }

        return evenDiffCount;
    }
}
