package LeetCode.Medium;


/*
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 */

//  Kadane's Algorithm
public class MaximumSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int maxSum = maxSubArraySum(arr);
        System.out.println(maxSum);
    }

    public static int maxSubArraySum(int[] arr) {
        int currentSum = arr[0];
        int maxSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            // check if currentSum at i is greater or element at i is greater
            // if element at i is greater => we can ignore prev sum
            // subarray will start at i
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
