package LeetCode.Medium;

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

// Greedy Approach
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

        // start with 2nd last index
        for (int index = nums.length - 2; index >= 0; index--) {
            // current index + no of jumps i.e. nums[index] => does it land to final position
            if (index + nums[index] >= finalPos) {
                finalPos = index; // update final position
            }
        }
        // if final pos is traversed till 0th index => we can make jump
        return finalPos == 0;
    }
}
