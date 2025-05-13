package LeetCode.Medium.TwoPointer;

/*
* Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
* such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

* Notice that the solution set must not contain duplicate triplets.

* Example 1:
    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]
    Explanation:
    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
    The distinct triplets are [-1,0,1] and [-1,-1,2].
    Notice that the order of the output and the order of the triplets does not matter.

* Example 2:
    Input: nums = [0,1,1]
    Output: []
    Explanation: The only possible triplet does not sum up to 0.

* Example 3:
    Input: nums = [0,0,0]
    Output: [[0,0,0]]
    Explanation: The only possible triplet sums up to 0.
* */

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> triplets = threeSum(nums);
        System.out.println("Triplets that sum up to zero are: " + triplets); // Output:  [[-1, -1, 2], [-1, 0, 1]]
    }

    public static List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr); // [-4, -1, -1, 0, 1, 2]

        // start with each element as 1st of triplet
        // other 2 of triplets will be left and right
        for (int i = 0; i < arr.length - 2; i++) {

            // skip duplicates for 1/3 triplet
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(arr[i], arr[left], arr[right]));

                    // skip duplicates on left traversal - 2/3 triplets
                    while (left < right && arr[left] == arr[left + 1]) {
                        left++;
                    }

                    // skip duplicates on right traversal - 3/3 triplets
                    while (left < right && arr[right] == arr[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum_usingHashSet(int[] arr) {
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(arr); // [-4, -1, -1, 0, 1, 2]

        for (int i = 0; i < arr.length - 2; i++) {
            int leftPtr = i + 1;
            int rightPtr = arr.length - 1;

            while (leftPtr < rightPtr) {
                int sum = arr[i] + arr[leftPtr] + arr[rightPtr];

                if (sum < 0) {
                    leftPtr++;
                } else if (sum > 0) {
                    rightPtr--;
                } else {
                    result.add(Arrays.asList(arr[i], arr[leftPtr], arr[rightPtr]));
                    leftPtr++;
                    rightPtr--;
                }
            }
        }

        return new ArrayList<>(result);
    }
}
