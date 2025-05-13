package LeetCode.Medium.TwoPointer;

/*
* Given an integer array nums of length n and an integer target, find three integers in nums
* such that the sum is closest to target.

* Return the sum of the three integers.

* You may assume that each input would have exactly one solution.

* Example 1:
    Input: nums = [-1,2,1,-4], target = 1
    Output: 2
    Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

* Example 2:
    Input: nums = [0,0,0], target = 1
    Output: 0
    Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
* */

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        int target = 4;

        int closestSum = threeSumClosest(arr, target);
        System.out.println(closestSum);
    }

    public static int threeSumClosest(int[] arr, int target) {
        Arrays.sort(arr); // [-4, -1, -1, 0, 1, 2]

        // if only 3 elements are there - result sum is sum of all 3 elements
        int resultSum = arr[0] + arr[1] + arr[2];

        int minDiff = Integer.MAX_VALUE;

        // fix first element and find other 2 elements
        for (int i = 0; i < arr.length - 2; i++) {
            // find other 2 using 2 sum approach
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == target) {
                    return target;
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }

                int currDiff = Math.abs(sum - target);

                if (currDiff < minDiff) {
                    minDiff = currDiff;
                    resultSum = sum;
                }
            }
        }
        return resultSum;
    }
}
