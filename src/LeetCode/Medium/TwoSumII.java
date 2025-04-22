package LeetCode.Medium;

/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers
such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2]
where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

    Input: numbers = [2,7,11,15], target = 9
    Output: [1,2]
    Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2]

    Input: numbers = [2,3,4], target = 6
    Output: [1,3]

*/

import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        // int[] arr = {2, 3, 4};
        // int target = 6;

        int[] res = twoSum(arr, target);
        System.out.println(Arrays.toString(res));
    }

    static int[] twoSum(int[] arr, int target) {
        int leftPtr = 0;
        int rightPtr = arr.length - 1;

        while (leftPtr < rightPtr) {
            int sum = arr[leftPtr] + arr[rightPtr];
            if (sum < target) { // if sum is smaller than target, move left pointer
                leftPtr++;
            } else if (sum > target) { // if sum is greater than target, move right pointer
                rightPtr--;
            } else { // if sum is equal return result
                return new int[]{leftPtr + 1, rightPtr + 1};
            }
        }
        return new int[]{};
    }
}
