package LeetCode.Easy;

import java.util.Arrays;

/*
* You are given an integer array nums. Transform nums by performing the following operations in the exact order specified:
    Replace each even number with 0.
    Replace each odd numbers with 1.
    Sort the modified array in non-decreasing order.

* Return the resulting array after performing these operations.

* Example 1:
    Input: nums = [4,3,2,1]
    Output: [0,0,1,1]
    Explanation:
    Replace the even numbers (4 and 2) with 0 and the odd numbers (3 and 1) with 1. Now, nums = [0, 1, 0, 1].
    After sorting nums in non-descending order, nums = [0, 0, 1, 1].
* */

public class TransformArrayByParity {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1};
        int[] res = transformArray(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] transformArray(int[] nums) {
        int oddLength = 0;

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                oddLength++;
            }
            nums[i] = 0;
        }

        // start with last index and start to put 1, oddLength times
        // as sorting would make 1 appear at last
        int rightPtr = nums.length - 1;
        while (oddLength > 0) {
            nums[rightPtr--] = 1;
            oddLength--;
        }

        return nums;
    }

    public static int[] transformArray_basic(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                nums[i] = 0;
            } else {
                nums[i] = 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        return nums;
    }
}
