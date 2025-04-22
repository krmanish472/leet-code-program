package LeetCode.Easy;
/*
* Given an array nums of size n, return the majority element.
* The majority element is the element that appears more than ⌊n / 2⌋ times.
* You may assume that the majority element always exists in the array.

* Example 1:
    Input: nums = [3,2,3]
    Output: 3

* Example 2:
    Input: nums = [2,2,1,1,1,2,2]
    Output: 2
* */

public class MajorityElements {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};

        int majorityElements = majorityElement(arr);
        System.out.println(majorityElements);
    }

    public static int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) { // each unique element will have count 0 at start
                candidate = num;
            }
            if (candidate == num) { // if candidate is same as num, increase count
                count++;
            } else { // if its a different candidate, decrease count
                count--;
            }
        }
        return candidate;
    }
}
