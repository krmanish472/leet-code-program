package LeetCode.Easy;

/*
* You are given an integer array nums and an integer k.
* In one operation, you can choose any index i where 0 <= i < nums.length and change nums[i] to nums[i] + x
* where x is an integer from the range [-k, k]. You can apply this operation at most once for each index i.

* The score of nums is the difference between the maximum and minimum elements in nums.
* Return the minimum score of nums after applying the mentioned operation at most once for each index in it.

* Example 1:
    Input: nums = [0,10], k = 2
    Output: 6
    Explanation: Change nums to be [2, 8]. The score is max(nums) - min(nums) = 8 - 2 = 6.

* Example 3:
    Input: nums = [1,3,6], k = 3
    Output: 0
    Explanation: Change nums to be [4, 4, 4]. The score is max(nums) - min(nums) = 4 - 4 = 0.
* */

public class SmallestRangeI {
    public static void main(String[] args) {
        int[] nums = {1, 3, 6};
        int k = 2;

        int res = smallestRangeI(nums, k);
        System.out.println(res);
    }

    public static int smallestRangeI(int[] nums, int k) {
        int minVal = nums[0];
        int maxVal = nums[0];

        // loop through each element to get MAX and MIN value
        for (int num : nums) {
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }

        if (minVal + k > maxVal - k) {
            return 0;
        } else {
            return (maxVal - k) - (minVal + k); // 6 1 // 3 - 4
        }
    }
}
