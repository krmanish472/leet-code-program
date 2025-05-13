package LeetCode.Easy;

/*
* Given an integer array nums, return the third distinct maximum number in this array.
* If the third maximum does not exist, return the maximum number.

* Example 1:
    Input: nums = [3,2,1]
    Output: 1

* Example 2:
    Input: nums = [1,2]
    Output: 2

* Example 3:
    Input: nums = [2,2,3,1]
    Output: 1

* */

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 1};
        int[] nums2 = {1, 2, 2};

        int thirdMax = thirdMax(nums);
        System.out.println(thirdMax);

        int thirdMax2 = thirdMax(nums2);
        System.out.println(thirdMax2);
    }

    public static int thirdMax(int[] nums) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;

        for (int num : nums) {
            // if duplicate is found, continue
            if (num == firstMax || num == secondMax || num == thirdMax) {
                continue;
            }

            if (num > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if (num > thirdMax) {
                thirdMax = num;
            }
        }

        return thirdMax == Integer.MIN_VALUE ? firstMax : thirdMax;
    }
}
