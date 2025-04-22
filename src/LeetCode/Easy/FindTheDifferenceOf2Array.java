package LeetCode.Easy;

import java.util.*;

/*
* Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
    answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
    answer[1] is a list of all distinct integers in nums2 which are not present in nums1.

* Note that the integers in the lists may be returned in any order.

* Example 1:
    Input: nums1 = [1,2,3], nums2 = [2,4,6]
    Output: [[1,3],[4,6]]

* Example 2:
    Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
    Output: [[3],[]]
* */

public class FindTheDifferenceOf2Array {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3}, nums2 = {2, 4, 6};

        List<List<Integer>> res = findDifference(nums1, nums2);
        System.out.println(res);
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        return Arrays.asList(
                getDifferentValues(nums1, nums2),
                getDifferentValues(nums2, nums1)
        );
    }

    private static List<Integer> getDifferentValues(int[] num1, int[] num2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : num2) {
            set2.add(num);
        }

        for (int num : num1) {
            if (!set2.contains(num)) {
                set1.add(num);
            }
        }

        return new ArrayList<>(set1);
    }
}
