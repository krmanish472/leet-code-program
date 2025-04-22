package LeetCode.Easy;

/*
* Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
* You must implement a solution with a linear runtime complexity and use only constant extra space.
Example 1:
    Input: nums = [2,2,1]
    Output: 1

Example 2:
    Input: nums = [4,1,2,1,2]
    Output: 4
* */

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        int singleNum = singleNumber(nums);

        System.out.println(singleNum);
    }

    public static int singleNumber(int[] numbers) {
        int result = 0;
        for (int number: numbers) {
            result ^= number; // Logical XOR operator
        }
        return result;
    }
}
