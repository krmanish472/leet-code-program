package LeetCode.Easy;

import java.util.Map;

/*
 * You are given a positive integer array nums.
 * The element sum is the sum of all the elements in nums.
 * The digit sum is the sum of all the digits (not necessarily distinct) that appear in nums.

 * Return the absolute difference between the element sum and digit sum of nums.

 * Note that the absolute difference between two integers x and y is defined as |x - y|.

 * Example 1:
    Input: nums = [1,15,6,3]
    Output: 9
    Explanation:
    The element sum of nums is 1 + 15 + 6 + 3 = 25.
    The digit sum of nums is 1 + 1 + 5 + 6 + 3 = 16.
    The absolute difference between the element sum and digit sum is |25 - 16| = 9.
 * */

public class DifferenceBetweenElementSumAndDigitSumOfArray {
    public static void main(String[] args) {
        int[] nums = {1, 15, 6, 3};

        int res = differenceOfSum(nums);
        System.out.println(res);
    }

    public static int differenceOfSum(int[] nums) {
        int elementSum = 0;
        int digitSum = 0;

        for (int num : nums) {
            elementSum += num;
            digitSum += getSumOfDigit(num);
        }

        return Math.abs(elementSum - digitSum);
    }

    private static int getSumOfDigit(int num) {
        int sum = 0;
        while (num != 0) {
            int lastDigit = num % 10;
            sum += lastDigit;
            num = num / 10;
        }
        return sum;
    }

}
