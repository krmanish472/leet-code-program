package LeetCode.Medium;

/*
* Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

* Example 1:
    Input: nums = [1,2,3,4,5,6,7], k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]
* */

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
    }

    // This would give timeout for leetcode submission
    public static void rotate(int[] arr, int k) {
        while (k != 0) {
            int temp = arr[arr.length - 1];
            for (int i = arr.length - 1; i >= 1; i--) { // 7,1,2,3,4,5,6
                arr[i] = arr[i - 1];
            }
            arr[0] = temp;
            k--;
        }
    }

    // better approach -
    // Step1: reverse array, [7,6,5,4,3,2,1]
    // Step2: reverse k elements [5,6,7]
    // Step3: reverse remaining elements [1,2,3,4]
    // [1,2,3,4,5,6,7] -> [5,6,7,1,2,3,4]
    public static void rotate_usingReverse(int[] nums, int k) {
        int n = nums.length;
        k %= n; // for array of length 3, and k = 4 => 3 rotate will make array as original, hence only 1 rotate is fine
        reverse(nums, 0, n - 1); // reverse entire array
        reverse(nums, 0, k - 1); // reverse k elements
        reverse(nums, k, n - 1); // reverse remaining elements
    }

    private static void reverse(int[] nums, int leftPtr, int rightPtr) {
        while (leftPtr < rightPtr) {
            int temp = nums[leftPtr];
            nums[leftPtr] = nums[rightPtr];
            nums[rightPtr] = temp;

            leftPtr++;
            rightPtr--;
        }
    }

}
