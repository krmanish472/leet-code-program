package LeetCode.Medium;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:
    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]

Example 2:
    Input: nums = [0,1,1]
    Output: []
    Explanation: The only possible triplet does not sum up to 0.

Example 3:
    Input: nums = [0,0,0]
    Output: [[0,0,0]]
    Explanation: The only possible triplet sums up to 0.
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> triplets = threeSum(nums);
        System.out.println("Triplets that sum up to zero are: " + triplets); // Output:  [[-1, -1, 2], [-1, 0, 1]]
    }

    public static List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr); // [-4, -1, -1, 0, 1, 2]
        for (int i = 0; i < arr.length - 2; i++) {
            // check for duplicate -> on i -> if current == prev
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int leftPtr = i + 1;
            int rightPtr = arr.length - 1;

            while (leftPtr < rightPtr) {
                int sum = arr[i] + arr[leftPtr] + arr[rightPtr];
                if (sum < 0) { // if sum is smaller than target, move left pointer
                    leftPtr++;
                } else if (sum > 0) { // if sum is greater than target, move right pointer
                    rightPtr--;
                } else { // if sum is equal return result
                    result.add(Arrays.asList(arr[i], arr[leftPtr], arr[rightPtr]));

                    // check for duplicate -> on leftPtr traversal
                    while (leftPtr < rightPtr && arr[leftPtr] == arr[leftPtr + 1]) {
                        leftPtr++;
                    }
                    // check for duplicate -> on rightPtr traversal
                    while (leftPtr < rightPtr && arr[rightPtr] == arr[rightPtr - 1]) {
                        rightPtr--;
                    }

                    leftPtr++;
                    rightPtr--;
                }
            }
        }
        return result;
    }
}
