package LeetCode.Easy;

/*
* Given a 0-indexed integer array nums,
* return the smallest index i of nums such that i mod 10 == nums[i],
* or -1 if such index does not exist.

* Example 1:
    Input: nums = [0,1,2]
    Output: 0
    Explanation:
    i=0: 0 mod 10 = 0 == nums[0].
    i=1: 1 mod 10 = 1 == nums[1].
    i=2: 2 mod 10 = 2 == nums[2].
    All indices have i mod 10 == nums[i], so we return the smallest index 0.

* Example 2:
    Input: nums = [4,3,2,1]
    Output: 2
    Explanation:
    i=0: 0 mod 10 = 0 != nums[0].
    i=1: 1 mod 10 = 1 != nums[1].
    i=2: 2 mod 10 = 2 == nums[2].
    i=3: 3 mod 10 = 3 != nums[3].
    2 is the only index which has i mod 10 == nums[i].
* */

public class SmallestIndexWithEqualValue {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3};
        int res = smallestEqual(nums);
        System.out.println(res);
    }

    public static int smallestEqual(int[] nums) {
        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i]) {
                smallest = Math.min(smallest, i);
            }
        }

        return smallest == Integer.MAX_VALUE ? -1 : smallest;
    }
}
