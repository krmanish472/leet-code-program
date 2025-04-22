package LeetCode.Medium;

/*
* Given an integer array nums of unique elements, return all possible subsets (the power set). 2^n
* The solution set must not contain duplicate subsets. Return the solution in any order.
* Example 1:
    Input: nums = [1,2,3]
    Output: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]

* Example 2:
    Input: nums = [0]
    Output: [[],[0]]
* */

/*
* start with [], then with 1st element (index=0), then 2nd element (index=1) => for loop
* number included [e.g. 1]
* => generate subsets with each having [1]
* => generate subsets with each having [2]
* => generate subsets with each having [3]
* go back and remove each element 1-by-1 (backtracking) by removing 3, then 2, then 1
* */

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = subsets(nums);

        System.out.println(res);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void generateSubsets(List<List<Integer>> result, List<Integer> current, int[] nums, int index) {
        // add subsets to the result
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            // include the number
            current.add(nums[i]);

            // backtrack the new subset
            generateSubsets(result, current, nums, i + 1);

            // do not include number
            current.removeLast();
        }
    }
}
