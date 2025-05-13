package LeetCode.Easy;

/*
* Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence (i.e. subarray).
* The subsequence must be strictly increasing.

* A continuous increasing subsequence is defined by two indices l and r (l < r)
*  such that it is [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] and for each l <= i < r, nums[i] < nums[i + 1].

* Example 1:
    Input: nums = [1,3,5,4,7]
    Output: 3
    Explanation: The longest continuous increasing subsequence is [1,3,5] with length 3.
    Even though [1,3,5,7] is an increasing subsequence, it is not continuous as elements 5 and 7 are separated by element

* */

// Longest Increasing Subarray
public class LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7, 8, 9, 10};

        int maxCount = findLengthOfLCIS(nums);
        System.out.println(maxCount);
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1) return 1;

        int currCount = 1; // first element is always a start of sequence
        int maxCount = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) { // number is still increasing
                currCount++;
            } else { // reset current count to 0 as soon as non-increasing is found
                currCount = 1;
            }

            if (currCount > maxCount) {
                maxCount = currCount;
            }
        }

        return maxCount;
    }
}
