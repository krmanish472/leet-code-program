package LeetCode.Medium;


/*
* Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and using only constant extra space.
    Input: nums = [3,1,3,4,2]
    Output: 3
* */

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 2};
        int duplicate = findDuplicate(nums);

        System.out.println(duplicate);
    }

    static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static int findDuplicatesHashSet(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            if (numSet.contains(num))
                return num;
            numSet.add(num);
        }

        return -1;
    }
}
