package LeetCode.Easy;

import java.util.HashSet;
import java.util.Set;

/*
* Given an integer array nums, return true if any value appears at least twice in the array,
* and return false if every element is distinct.
* Ex:
    Input: nums = [1,2,3,1]
    Output: true
    Explanation: The element 1 occurs at the indices 0 and 3.
* Ex:
    Input: nums = [1,2,3,4]
    Output: false
    Explanation: All elements are distinct.
* */

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums2 = {1, 2, 3, 1};

        if (containsDuplicate(nums2)) {
            System.out.println("Contains Duplicate");
        } else {
            System.out.println("Unique");
        }
    }

    static boolean containsDuplicate(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int el : arr) {
            if (set.contains(el)) {
                return true;
            }
            set.add(el);
        }
        return false;
    }
}
