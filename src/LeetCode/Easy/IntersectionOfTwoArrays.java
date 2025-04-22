package LeetCode.Easy;

/*
* Given two integer arrays nums1 and nums2, return an array of their intersection.
* Each element in the result must be unique and you may return the result in any order.

* Example 1:
    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2]

* Example 2:
    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    Output: [9,4]
    Explanation: [4,9] is also accepted.
* */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] res = intersection(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        /*for (int num : nums2) {
            if (set1.contains(num) && !result.contains(num)) {
                result.add(num);
            }
        }*/

        // ... OR ... //
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }

        // copy from set to array
        int[] res = new int[set2.size()];
        int idx = 0;
        for (int i : set2) {
            res[idx] = i;
            idx++;
        }

        // return array
        return res;
    }
}
