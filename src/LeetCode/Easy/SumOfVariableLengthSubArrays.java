package LeetCode.Easy;

/*
* You are given an integer array nums of size n. For each index i where 0 <= i < n, define a subarray nums[start ... i]
* where start = max(0, i - nums[i]).

* Return the total sum of all elements from the subarray defined for each index in the array.

* Example 1:
    Input: nums = [3,1,1,2]
    Output: 13
    Explanation:
    i	Subarray	Sum
    0	nums[0] = [3]	3
    1	nums[0 ... 1] = [3, 1]	4
    2	nums[1 ... 2] = [1, 1]	2
    3	nums[1 ... 3] = [1, 1, 2]	4
    Total Sum	 	13
    The total sum is 13. Hence, 13 is the output.

* */

public class SumOfVariableLengthSubArrays {
    public static void main(String[] args) {
        int[] nums = {3, 1, 1, 2};
        int sum = subarraySum(nums);
        System.out.println(sum);
    }

    public static int subarraySum(int[] nums) {
        int totalSubArraySum = 0;

        for (int i = 0; i < nums.length; i++) {
            // start as per given condition
            int start = Math.max(0, i - nums[i]);
            // start ... j => take sum of elements
            for (int j = start; j <= i; j++) {
                totalSubArraySum += nums[j];
            }
        }

        return totalSubArraySum;
    }
}
