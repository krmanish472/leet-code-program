package LeetCode.Easy;

/*
* You are given a 0-indexed integer array nums.
* Rearrange the values of nums according to the following rules:
    Sort the values at odd indices of nums in non-increasing order.
    Sort the values at even indices of nums in non-decreasing order.

* Return the array formed after rearranging the values of nums.

* Example 1:
    Input: nums = [4,1,2,3]
    Output: [2,3,4,1]

* Example 2:
    Input: nums = [2,1]
    Output: [2,1]
* */

import java.util.Arrays;

public class SortEvenOddIndicesIndependently {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 3};

        int[] sortedArr = sortEvenOdd(nums);
        System.out.println(Arrays.toString(sortedArr));
    }

    public static int[] sortEvenOdd(int[] nums) {
        if (nums.length <= 2) {
            return nums;
        }

        int[] oddArr = new int[nums.length / 2];
        int[] evenArr = new int[nums.length - oddArr.length];

        // separate even odd array
        for (int i = 0, evenArrIdx = 0, oddArrIdx = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evenArr[evenArrIdx++] = nums[i];
            } else {
                oddArr[oddArrIdx++] = nums[i];
            }
        }

        // sort even and odd array
        sort(evenArr);
        sort(oddArr);

        // add the values back in original array
        for (int i = 0, evenArrIdx = 0, oddArrIdx = oddArr.length - 1; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = evenArr[evenArrIdx++];
            } else {
                // oddArr is sorted in ascending order - hence add from reverse order
                nums[i] = oddArr[oddArrIdx--];
            }
        }

        return nums;
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static int[] sortEvenOdd_alt(int[] nums) { // good memory bad time
        if (nums.length < 2) return nums;

        // Sort even indices in ascending order
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = i + 2; j < nums.length; j += 2) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        // Sort odd indices in descending order
        for (int i = 1; i < nums.length; i += 2) {
            for (int j = i + 2; j < nums.length; j += 2) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        return nums;
    }
}
