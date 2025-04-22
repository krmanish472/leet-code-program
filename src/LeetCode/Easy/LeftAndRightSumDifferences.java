package LeetCode.Easy;

/*
* You are given a 0-indexed integer array nums of size n.
* Define two arrays leftSum and rightSum where:
    leftSum[i] is the sum of elements to the left of the index i in the array nums. If there is no such element, leftSum[i] = 0.
    rightSum[i] is the sum of elements to the right of the index i in the array nums. If there is no such element, rightSum[i] = 0.

* Return an integer array answer of size n where answer[i] = |leftSum[i] - rightSum[i]|.

* Example 1:
    Input: nums = [10,4,8,3]
    Output: [15,1,11,22]
    Explanation: The array leftSum is [0,10,14,22] and the array rightSum is [15,11,3,0].
    The array answer is [|0 - 15|,|10 - 11|,|14 - 3|,|22 - 0|] = [15,1,11,22].

* Example 2:
    Input: nums = [1]
    Output: [0]
    Explanation: The array leftSum is [0] and the array rightSum is [0].
    The array answer is [|0 - 0|] = [0].
* */

import java.util.Arrays;

// Check FindPivotIndex as reference
public class LeftAndRightSumDifferences {
    public static void main(String[] args) {
        int[] nums = {10, 4, 8, 3};
        int[] res = leftRightDifference(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] leftRightDifference(int[] nums) {
        int rightSum = 0;
        int leftSum = 0;

        // Calculate the total right sum
        for (int num : nums) {
            rightSum += num;
        }

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Get the value at index i - as this gets modified later
            // but we need it for left sum
            int val = nums[i];

            // Update the right sum
            rightSum = rightSum - val;

            // Find the difference
            nums[i] = Math.abs(leftSum - rightSum);

            // Update the left sum
            leftSum = leftSum + val;
        }

        return nums;
    }
}
