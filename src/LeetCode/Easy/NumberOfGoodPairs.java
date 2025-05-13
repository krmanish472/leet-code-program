package LeetCode.Easy;

/*
* Given an array of integers nums, return the number of good pairs.
* A pair (i, j) is called good if nums[i] == nums[j] and i < j.

* Example 1:
    Input: nums = [1,2,3,1,1,3]
    Output: 4
    Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.

* Example 2:
    Input: nums = [1,1,1,1]
    Output: 6
    Explanation: Each pair in the array are good.

* Example 3:
    Input: nums = [1,2,3]
    Output: 0
* */

public class NumberOfGoodPairs {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1, 3};

        int res = numIdenticalPairs(nums);
        System.out.println(res);
    }

    public static int numIdenticalPairs(int[] nums) {
        int[] count = new int[101]; // number from 0 to 100
        for (int num : nums) {
            count[num]++;
        }

        int totalCount = 0;
        for (int i : count) {
            totalCount += (i * (i - 1)) / 2;
        }

        return totalCount;
    }
}
