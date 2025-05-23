package LeetCode.Easy;

/*
* You are given an integer array nums consisting of n elements, and an integer k.
* Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
* Any answer with a calculation error less than 10^-5 will be accepted.

* Example 1:
    Input: nums = [1,12,-5,-6,50,3], k = 4
    Output: 12.75000
    Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

* Example 2:
    Input: nums = [5], k = 1
    Output: 5.00000
* */
public class MaximumAverageSubArrayI {
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double res = findMaxAverage(nums, k);
        System.out.println(res);
    }

    public static double findMaxAverage(int[] nums, int k) {
        // Get sum for starting window
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        // Start sliding window
        int low = 0;
        int high = k;

        while (high < nums.length) {
            // ... remove prev element and add next element to keep window intact
            // Remove previous element
            sum -= nums[low];
            low++;

            // Add next element
            sum += nums[high];
            high++;

            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }
}
