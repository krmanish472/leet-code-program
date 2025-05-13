package LeetCode.Easy;

/*
* Given an integer array nums of size n,

* return the number with the value closest to 0 in nums.

* If there are multiple answers, return the number with the largest value.

* Example 1:
    Input: nums = [-4,-2,1,4,8]
    Output: 1
    Explanation:
    The distance from -4 to 0 is |-4| = 4.
    The distance from -2 to 0 is |-2| = 2.
    The distance from 1 to 0 is |1| = 1.
    The distance from 4 to 0 is |4| = 4.
    The distance from 8 to 0 is |8| = 8.
    Thus, the closest number to 0 in the array is 1.

* Example 2:
    Input: nums = [2,-1,1]
    Output: 1
    Explanation: 1
* */

public class FindClosestNumberToZero {
    public static void main(String[] args) {
        int[] nums = {-4, -2, 1, 4, 8};
        int[] nums1 = {2, -1, 2};
        int[] nums2 = {2, -1, 2, 1};

        int closestNum = findClosestNumber(nums);
        System.out.println(closestNum);

        int closestNum1 = findClosestNumber(nums1);
        System.out.println(closestNum1);

        int closestNum2 = findClosestNumber(nums2);
        System.out.println(closestNum2);
    }

    public static int findClosestNumber(int[] nums) {
        int minDiff = Integer.MAX_VALUE;
        int closestNum = 0;

        for (int num : nums) {
            int currDiff = Math.abs(num);

            if (currDiff < minDiff) {
                minDiff = currDiff;
                closestNum = num;
            }
            // if same difference -1, 1 => return highest one
            else if (currDiff == minDiff) {
                closestNum = Math.max(closestNum, num);
            }
        }

        return closestNum;
    }
}
