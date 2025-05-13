package LeetCode.Easy;

/*
* Given a sorted array of distinct integers and a target value, return the index if the target is found.
* If not, return the index where it would be if it were inserted in order.

* You must write an algorithm with O(log n) runtime complexity.

* Example 1:
    Input: nums = [1,3,5,6], target = 5
    Output: 2

* Example 2:
    Input: nums = [1,3,5,6], target = 2
    Output: 1

* Example 3:
    Input: nums = [1,3,5,6], target = 7
    Output: 4
* */

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;

        int[] nums1 = {1, 3, 5, 6};
        int target1 = 2;

        int res = searchInsert(nums, target);
        System.out.println(res);

        int res1 = searchInsert(nums1, target1);
        System.out.println(res1);
    }

    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            } else if (target != nums[i] && nums[i] > target) {
                return i;
            }
        }
        return nums.length;
    }
}
