package LeetCode.Easy;

import java.util.Arrays;
import java.util.HashMap;

/*
* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]

    Input: nums = [3,2,4], target = 6
    Output: [1,2]
* */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 2};
        int target = 9;

        // int[] nums = {2,7,11,15};
        // int target = 9;

        // int[] nums = {3,2,4};
        // int target = 6;

        int[] res = twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }

    // every element is a possible solution => keep adding them in hashmap
    static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            // get complement & check if its already present
            // if present, result will be that number's index and complement's index
            int compliment = target - arr[i];
            if (map.containsKey(compliment)) {
                return new int[]{map.get(compliment), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{};
    }
}
