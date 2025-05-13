package LeetCode.Medium.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]]
* such that:
    0 <= a, b, c, d < n
    a, b, c, and d are distinct.
    nums[a] + nums[b] + nums[c] + nums[d] == target

* You may return the answer in any order.

* Example 1:
    Input: nums = [1,0,-1,0,-2,2], target = 0
    Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

* Example 2:
    Input: nums = [2,2,2,2,2], target = 8
    Output: [[2,2,2,2]]
* */

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int[] nums2 = {2, 2, 2, 2, 2};
        int target = 0;
        int target2 = 8;

        List<List<Integer>> result = fourSum(nums, target);
        System.out.println(result);

        List<List<Integer>> result2 = fourSum(nums2, target2);
        System.out.println(result2);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums); // [-2, -1, 0, 0, 1, 2] // [2, 2, 2, 2, 2]

        for (int i = 0; i < nums.length - 3; i++) {
            // skip duplicate on 1/4
            if (i != 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                // skip duplicates on 2/4
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // skip duplicates on 3/4
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        // skip duplicates on 4/4
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
