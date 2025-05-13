package LeetCode.Medium.GreedyApproach;

/*
* You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
* Each element nums[i] represents the maximum length of a forward jump from index i. In other words,
* if you are at nums[i], you can jump to any nums[i + j] where:
    0 <= j <= nums[i] and
    i + j < n

* Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

* Example 1:
    Input: nums = [2,3,1,1,4]
    Output: 2
    Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1,
    then 3 steps to the last index.

* Example 2:
    Input: nums = [2,3,0,1,4]
    Output: 2
* */

// Greedy Approach - choose the farthest I can go from available options [window]

public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 2, 3, 1, 1, 2};

        int minJumpCount = jump(nums);
        System.out.println(minJumpCount);
    }

    public static int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int totalJumps = 0;

        int maxWindowIdx = 0;
        int lastJumpIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            maxWindowIdx = Math.max(maxWindowIdx, i + nums[i]); // 2, [5, 3]

            // check if we covered all the index in window
            if (i == lastJumpIdx) {
                totalJumps++;
                lastJumpIdx = maxWindowIdx;

                // check if we reached destination
                if (lastJumpIdx == nums.length - 1) {
                    return totalJumps;
                }
            }
        }

        return totalJumps;
    }
}
