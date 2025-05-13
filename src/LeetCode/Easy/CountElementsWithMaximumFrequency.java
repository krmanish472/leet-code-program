package LeetCode.Easy;

/*
* You are given an array nums consisting of positive integers.
* Return the total frequencies of elements in nums such that those elements all have the maximum frequency.
* The frequency of an element is the number of occurrences of that element in the array.

* Example 1:
    Input: nums = [1,2,2,3,1,4]
    Output: 4
    Explanation: The elements 1 and 2 have a frequency of 2 which is the maximum frequency in the array.
    So the number of elements in the array with maximum frequency is 4.

* Example 2:
    Input: nums = [1,2,3,4,5]
    Output: 5
    Explanation: All elements of the array have a frequency of 1 which is the maximum.
    So the number of elements in the array with maximum frequency is 5.

* */

import java.util.HashMap;
import java.util.Map;

public class CountElementsWithMaximumFrequency {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        int res = maxFrequencyElements(nums);
        System.out.println(res);
    }

    public static int maxFrequencyElements_usingHashMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxFreq = Integer.MIN_VALUE;
        for (int value : map.values()) {
            maxFreq = Math.max(maxFreq, value);
        }

        int count = 0;
        for (int num : nums) {
            if (map.get(num) == maxFreq) {
                count++;
            }
        }

        return count;
    }

    public static int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        for (int num : nums) {
            freq[num]++;
        }

        int maxFreq = Integer.MIN_VALUE;
        for (int count : freq) {
            maxFreq = Math.max(maxFreq, count);
        }

        int count = 0;
        for (int num : nums) {
            if (freq[num] == maxFreq) {
                count++;
            }
        }

        return count;
    }
}
