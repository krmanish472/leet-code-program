package LeetCode.Easy;

/*
* Given an array nums containing n distinct numbers in the range [0, n]
* Return the only number in the range that is missing from the array.

* Example 1:
    Input: nums = [3,0,1]
    Output: 2

* Example 2:
    Input: nums = [0,1]
    Output: 2
* */

public class MissingNumber {
    public static void main(String[] args) {
        int missingNum = missingNumber(new int[]{3, 0, 1});
        System.out.println(missingNum);
    }

    public static int missingNumber(int[] nums) {
        int xOr = 0;

        // 0 ^ 1 ^ 2 ^ 3
        for (int i = 0; i <= nums.length; i++) {
            xOr = xOr ^ i;
        }

        // 3 ^ 0 ^ 1
        for (int i = 0; i < nums.length; i++) {
            xOr = xOr ^ nums[i];
        }

        return xOr;
    }
}
