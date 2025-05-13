package LeetCode.Easy;

/*
* You are given an integer array nums.
* You replace each element in nums with the sum of its digits.

* Return the minimum element in nums after all replacements.

* Example 1:
    Input: nums = [10,12,13,14]
    Output: 1
    Explanation:
    nums becomes [1, 3, 4, 5] after all replacements, with minimum element 1.

* */
public class MinimumElementAfterReplacementWithDigitSum {
    public static void main(String[] args) {
        int[] nums = {10, 12, 13, 14};

        int minEl = minElement(nums);
        System.out.println(minEl);
    }

    public static int minElement(int[] nums) {
        int minEl = Integer.MAX_VALUE;

        for (int num : nums) {
            int digitSum = 0;
            while (num != 0) {
                digitSum += num % 10;
                num /= 10;
            }

            minEl = Math.min(minEl, digitSum);
        }

        return minEl;
    }
}
