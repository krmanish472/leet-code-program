package LeetCode.Easy;

/*
* You are given an integer array nums. The unique elements of an array are the elements that appear exactly once in the array.
* Return the sum of all the unique elements of nums.

* Example 1:
    Input: nums = [1,2,3,2]
    Output: 4
    Explanation: The unique elements are [1,3], and the sum is 4.

* Example 2:
    Input: nums = [1,1,1,1,1]
    Output: 0
    Explanation: There are no unique elements, and the sum is 0.

* Example 3:
    Input: nums = [1,2,3,4,5]
    Output: 15
    Explanation: The unique elements are [1,2,3,4,5], and the sum is 15.
* */

public class SumOfUniqueElements {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2};

        int sum = sumOfUnique(nums);
        System.out.println(sum);
    }

    public static int sumOfUnique(int[] nums) {
        int[] freArr = new int[101]; // array starting from 0 to 100 => each index represents a number
        int sum = 0;
        // update frequency of each number
        for (int num : nums) {
            freArr[num]++;
        }

        for (int i = 0; i < freArr.length; i++) {
            if (freArr[i] == 1) { // if unique elements
                sum += i;
            }
        }
        return sum;
    }

    // can also solve using hashset
}
