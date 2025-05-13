package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

/*
* You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums
* that meet the following conditions:
    The length of the subarray is k, and
    All the elements of the subarray are distinct.
    Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

* A subarray is a contiguous non-empty sequence of elements within an array.

* Example 1:
    Input: nums = [1,5,4,2,9,9,9], k = 3
    Output: 15
    Explanation: The subarrays of nums with length 3 are:
    - [1,5,4] which meets the requirements and has a sum of 10.
    - [5,4,2] which meets the requirements and has a sum of 11.
    - [4,2,9] which meets the requirements and has a sum of 15.
    - [2,9,9] which does not meet the requirements because the element 9 is repeated.
    - [9,9,9] which does not meet the requirements because the element 9 is repeated.
    We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions

* Example 2:
    Input: nums = [4,4,4], k = 3
    Output: 0
    Explanation: The subarrays of nums with length 3 are:
    - [4,4,4] which does not meet the requirements because the element 4 is repeated.
    We return 0 because no subarrays meet the conditions.
* */
public class MaximumSumOfDistinctSubarraysWithLengthK {
    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;

        long res = maximumSubarraySum(arr, k);
        System.out.println(res);
    }

    public static long maximumSubarraySum(int[] arr, int k) {
        long maxSum = 0;

        // map of element -> index to track duplicates
        Map<Integer, Integer> map = new HashMap<>();

        // start 2 pointers
        int low = 0;
        int high = 0;

        long currSum = 0;

        while (high < arr.length) {
            // get index of the current element in map
            int idx = map.getOrDefault(arr[high], -1);

            // reduce the window if window size is greater than k
            // or curr element is duplicate
            while (high - low > k - 1
                    || idx >= low) {
                currSum = currSum - arr[low];
                low++;
            }

            currSum += arr[high];
            map.put(arr[high], high); // add element and index in map
            high++;

            // if window size equals k, find maxSum
            if (high - low == k) {
                maxSum = Math.max(maxSum, currSum);
            }
        }

        return maxSum;
    }
}
