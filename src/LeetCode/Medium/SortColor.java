package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Given an array nums with n objects colored red, white, or blue, sort them in-place so that
* objects of the same color are adjacent, with the colors in the order red, white, and blue.

* We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

* You must solve this problem without using the library's sort function.

* Example 1:
    Input: nums = [2,0,2,1,1,0]
    Output: [0,0,1,1,2,2]

* Example 2:
    Input: nums = [2,0,1]
    Output: [0,1,2]
* */

public class SortColor {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0, 1, 0, 1, 0};

        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int start = 0;
        int mid = 0;
        int end = nums.length - 1;

        while (mid <= end) {
            switch (nums[mid]) {
                case 0:
                    // swap with start index
                    swap(nums, mid, start);
                    start++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    // swap with end index
                    swap(nums, mid, end);
                    end--;
                    break;
            }
        }
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void sortColors_alt(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;

        for (int num : nums) {
            if (num == 0) {
                zero += 1;
            } else if (num == 1) {
                one += 1;
            } else {
                two += 1;
            }
        }

        int index = 0;
        while (zero > 0) {
            nums[index] = 0;
            zero--;
            index++;
        }
        while (one > 0) {
            nums[index] = 1;
            one--;
            index++;
        }
        while (two > 0) {
            nums[index] = 2;
            two--;
            index++;
        }
    }
}
