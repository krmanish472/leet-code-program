package LeetCode.Easy;

/*
* You are given a 0-indexed array nums of length n containing distinct positive integers.
* Return the minimum number of right shifts required to sort nums and -1 if this is not possible.

* A right shift is defined as shifting the element at index i to index (i + 1) % n, for all indices.

* Example 1:
    Input: nums = [3,4,5,1,2]
    Output: 2
    Explanation:
    After the first right shift, nums = [2,3,4,5,1].
    After the second right shift, nums = [1,2,3,4,5].
    Now nums is sorted; therefore the answer is 2.

* Example 2:
    Input: nums = [1,3,5]
    Output: 0
    Explanation: nums is already sorted therefore, the answer is 0.
* */

import java.util.Arrays;
import java.util.List;

// Similar to CheckIfArrayIsSortedAndRotated
public class MinRightShiftToSortArray {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, 4, 5, 1, 2);

        int rotatedTimes = minimumRightShifts(nums);
        System.out.println(rotatedTimes);
    }

    public static int minimumRightShifts(List<Integer> nums) {
        int pivotIdx = 0, count = 0;

        for (int i = 1; i < nums.size(); i++) {
            // for rotated sorted array, there is at max 1 element
            // such that the curr element is smaller than the prev element
            if (nums.get(i) < nums.get(i - 1)) {
                pivotIdx = i;
                count++; // count those occurrences
            }

            // there can be only one pivotIdx count
            if (count > 1) {
                return -1;
            }
        }

        // if array is already sorted - pivotIdx will not change and remain 0
        if (pivotIdx == 0) {
            return 0;
        }

        /**if (nums[nums.length - 1] > nums[0]) { // [2,1,3,4]
         breakCount++;
         }*/

        if (nums.get(nums.size() - 1) > nums.get(0)) { // [2,1,3,4]
            return -1;
        }

        return nums.size() - pivotIdx;
    }

}
