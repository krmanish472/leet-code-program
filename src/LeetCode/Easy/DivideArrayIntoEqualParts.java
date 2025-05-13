package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

/*
* You are given an integer array nums consisting of 2 * n integers.
* You need to divide nums into n pairs such that:
    Each element belongs to exactly one pair.
    The elements present in a pair are equal.

* Return true if nums can be divided into n pairs, otherwise return false.

* Example 1:
    Input: nums = [3,2,3,2,2,2]
    Output: true
    Explanation:
    There are 6 elements in nums, so they should be divided into 6 / 2 = 3 pairs.
    If nums is divided into the pairs (2, 2), (3, 3), and (2, 2), it will satisfy all the conditions.

* Example 2:
    Input: nums = [1,2,3,4]
    Output: false
    Explanation:
    There is no way to divide nums into 4 / 2 = 2 pairs such that the pairs satisfy every condition.
* */
public class DivideArrayIntoEqualParts {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 2, 2, 2};
        if (divideArray_bitwise(nums)) {
            System.out.println("Can be divided");
        } else {
            System.out.println("can not be divided");
        }
    }

    public static boolean divideArray_hashMap(int[] nums) {
        // count freq of each element
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // for each frequency - check if there is any odd value
        for (Integer el : map.values()) {
            if (el % 2 != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean divideArray_bitwise(int[] nums) {
        // count freq of each element
        int[] freq = new int[501]; // 0 to 500
        for (int i : nums) {
            freq[i]++;
        }

        // for each frequency - check if there is any odd value
        for (int i : freq) {
            // num & 1 results in 1 if num is odd - odd has LSB of 1 => 1&1 => 1
            // num & 1 results in 0 if num is even - even has LSB of 0 => 0&1 => 0
            if ((i & 1) == 1) {
                return false;
            }
            /*if (i % 2 != 0) {
                return false;
            }*/
        }

        return true;
    }
}



