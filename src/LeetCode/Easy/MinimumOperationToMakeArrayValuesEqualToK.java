package LeetCode.Easy;

/*
* You are given an integer array nums and an integer k.

* An integer h is called valid if all values in the array that are strictly greater than h are identical.
* For example, if nums = [10, 8, 10, 8], a valid integer is h = 9 because all nums[i] > 9 are equal to 10
* but 5 is not a valid integer.

* You are allowed to perform the following operation on nums:
    Select an integer h that is valid for the current values in nums.
    For each index i where nums[i] > h, set nums[i] to h.

* Return the minimum number of operations required to make every element in nums equal to k.
* If it is impossible to make all elements equal to k, return -1.

* Example 1:
    Input: nums = [5,2,5,4,5], k = 2
    Output: 2
    Explanation:
    The operations can be performed in order using valid integers 4 and then 2.

* Example 2:
    Input: nums = [2,1,2], k = 2
    Output: -1
    Explanation:
    It is impossible to make all the values equal to 2.

* Example 3:
    Input: nums = [9,7,5,3], k = 1
    Output: 4
    Explanation:
    The operations can be performed using valid integers in the order 7, 5, 3, and 1.

* */

import java.util.HashSet;
import java.util.Set;

public class MinimumOperationToMakeArrayValuesEqualToK {
    public static void main(String[] args) {
        int[] nums = {5, 2, 5, 4, 5};
        int k = 2;

        int count = minOperations(nums, k);
        System.out.println(count);
    }

    public static int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num < k) {
                return -1;
            } else if (num > k) {
                set.add(num);
            }
        }
        // the answer is the number of distinct integers in the array that are larger than k.
        return set.size();
    }


    // Check Later
    private static void someFn(int[] nums, int k) {
        // end recursion if all elements in array i.e. nums equals to k
        if (allElementsEqualToK(nums, k)) {
            return;
        }

        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE; // valid integer 4, 2

        for (int num : nums) {
            if (num > max) {
                max2 = max;
                max = num;
            } else if (num > max2 && num != max) {
                max2 = num;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max2) {
                nums[i] = max2;
            }
        }

        someFn(nums, k);
    }

    public static boolean allElementsEqualToK(int[] arr, int k) {
        for (int value : arr) {
            if (value != k) {
                return false;
            }
        }
        return true;
    }


}
