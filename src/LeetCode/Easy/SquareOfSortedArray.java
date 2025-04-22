package LeetCode.Easy;

/*
* Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in
* non-decreasing order.

* Example 1:
    Input: nums = [-4,-1,0,3,10]
    Output: [0,1,9,16,100]
    Explanation: After squaring, the array becomes [16,1,0,9,100].
    After sorting, it becomes [0,1,9,16,100].

* Example 2:
    Input: nums = [-7,-3,2,3,11]
    Output: [4,9,9,49,121]
* */

import java.util.Arrays;

public class SquareOfSortedArray {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};

        int[] sqSortedNums = sortedSquares(nums);
        System.out.println(Arrays.toString(sqSortedNums));
    }

    public static int[] sortedSquares(int[] nums) {
        // square elements of nums array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        // [16, 1, 0, 9, 100]

        int[] result = new int[nums.length];

        // sort array - 2 pointer approach
        int low = 0;
        int high = nums.length - 1;

        for (int index = nums.length - 1; index >= 0; index--) {
            if (nums[low] > nums[high]) {
                result[index] = nums[low];
                low++;
            } else {
                result[index] = nums[high];
                high--;
            }
        }

        return result;
    }
}
