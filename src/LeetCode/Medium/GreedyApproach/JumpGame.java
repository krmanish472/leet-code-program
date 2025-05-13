package LeetCode.Medium.GreedyApproach;

/*
* You are given an integer array nums. You are initially positioned at the array's first index,
* and each element in the array represents your maximum jump length at that position.

* Return true if you can reach the last index, or false otherwise.

* Example 1:
    Input: nums = [2,3,1,1,4]
    Output: true
    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

* Example 2:
    Input: nums = [3,2,1,0,4]
    Output: false
    Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible
    to reach the last index.
* */

// Greedy Approach - check if we can reach 2nd last step from prev steps and so on..

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};

        if (canJump(nums)) {
            System.out.println("Can jump");
        } else {
            System.out.println("Can not jump");
        }
    }

    public static boolean canJump(int[] nums) {
        int finalPos = nums.length - 1;

        // start with 2nd last index and move back till 0th index
        // if we reach 2nd last step, we will always reach last step - with 1 step
        for (int currPos = nums.length - 2; currPos >= 0; currPos--) {
            // check if current currPos + no of jumps lands to final position
            int noOfJumpsAtCurrPos = nums[currPos];
            if (currPos + noOfJumpsAtCurrPos >= finalPos) {
                finalPos = currPos; // update final position
            }
        }

        // if final pos is traversed till 0th index => we can make jump
        return finalPos == 0;
    }
}
