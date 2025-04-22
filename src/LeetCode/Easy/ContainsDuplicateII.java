package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

/*
* Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array
* such that nums[i] == nums[j] and abs(i - j) <= k.

* Example 1:
    Input: nums = [1,2,3,1], k = 3
    Output: true
    Explanation: nums[0] == nums[3] and 3-0 <= 3 i.e. nums[i] == nums[j] and i-j<=k

* Example 2:
    Input: nums = [1,0,1,1], k = 1
    Output: true

* Example 3:
    Input: nums = [1,2,3,1,2,3], k = 2
    Output: false
* */

public class ContainsDuplicateII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;

        if (containsNearbyDuplicate(nums, k)) {
            System.out.println("Contains nearby duplicates");
        } else {
            System.out.println("Does not contain nearby duplicates");
        }
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) { // put elements in map with its index
                map.put(nums[i], i);
            } else {
                // if element exists, get the index as prevIndex
                int prevIdx = map.get(nums[i]);
                // if prevIdx-currentIdx <=k, return true else simply add it to hashmap
                if (Math.abs(prevIdx - i) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            }
        }
        return false;
    }
}
