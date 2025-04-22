package LeetCode.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* Given an array of integers nums, sort the array in increasing order based on the frequency of the values.
* If multiple values have the same frequency, sort them in decreasing order.

* Return the sorted array.

* Example 1:
    Input: nums = [1,1,2,2,2,3]
    Output: [3,1,1,2,2,2]
    Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.

* Example 2:
    Input: nums = [2,3,1,3,2]
    Output: [1,3,3,2,2]
    Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.

* Example 3:
    Input: nums = [-1,1,-6,4,5,-6,1,4,1]
    Output: [5,-1,4,4,-6,-6,1,1,1]

* */
public class SortArrayByIncreasingFrequency {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 3, 2};

        int[] res = frequencySort(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        Integer[] temp = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }

        Arrays.sort(temp, (a, b) -> {
            if (freqMap.get(a) == freqMap.get(b)) {
                return b - a;
            }
            return freqMap.get(a) - freqMap.get(b);
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }

        return nums;
    }
}
