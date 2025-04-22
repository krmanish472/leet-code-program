package LeetCode.Easy;

/*
* Given a binary array nums, return the maximum number of consecutive 1's in the array.

* Example 1:
    Input: nums = [1,1,0,1,1,1]
    Output: 3
    Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
* Example 2:
    Input: nums = [1,0,1,1,0,1]
    Output: 2

* */

//  Kadane's Algorithm
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        int countOfMostConsecutiveOnes = findMaxConsecutiveOnes(nums);

        System.out.println(countOfMostConsecutiveOnes);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;

        for (int num : nums) {
            if (num == 1) {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0;
            }
        }

        return maxCount;
    }
}
