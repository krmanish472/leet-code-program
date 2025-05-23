package LeetCode.Easy;

/*
* Given a 0-indexed integer array nums, return true if it can be made strictly increasing after
* removing exactly one element, or false otherwise.

* If the array is already strictly increasing, return true.

* The array nums is strictly increasing if nums[i - 1] < nums[i] for each index (1 <= i < nums.length).

* Example 1:
    Input: nums = [1,2,10,5,7]
    Output: true
    Explanation: By removing 10 at index 2 from nums, it becomes [1,2,5,7].
    [1,2,5,7] is strictly increasing, so return true.

* Example 2:
    Input: nums = [2,3,1,2]
    Output: false
    Explanation:
    [3,1,2] is the result of removing the element at index 0.
    [2,1,2] is the result of removing the element at index 1.
    [2,3,2] is the result of removing the element at index 2.
    [2,3,1] is the result of removing the element at index 3.
    No resulting array is strictly increasing, so return false.
* */
public class RemoveOneElementToMakeArrayStrictlyIncreasing {
    public static void main(String[] args) {
        int[] nums = {1, 2, 10, 5, 7};

        if (canBeIncreasing(nums)) {
            System.out.println("Can be increasing");
        } else {
            System.out.println("Can not be increasing");
        }
    }

    public static boolean canBeIncreasing(int[] nums) {
        int i = 1;

        // continue iteration if curr element is greater than prev element
        while (i < nums.length && nums[i] >= nums[i - 1]) {
            i++;
        }

        return checkIfSorted(nums, i - 1)
                || checkIfSorted(nums, i);
    }

    private static boolean checkIfSorted(int[] nums, int targetIdx) {
        int prev = 0;
        for (int i = 0; i < nums.length; ++i) {
            // skip the element to be deleted
            if (i == targetIdx) {
                continue;
            }
            // for sorted previous element should be less than current element
            if (prev >= nums[i]) {
                return false;
            }
            prev = nums[i];
        }

        return true;
    }
}
