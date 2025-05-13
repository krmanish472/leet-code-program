package LeetCode.Easy;

import java.util.*;

/*
* Given an array of positive integers nums,
* return an array answer that consists of the digits of each integer in nums
* after separating them in the same order they appear in nums.

* To separate the digits of an integer is to get all the digits it has in the same order.
* For example, for the integer 10921, the separation of its digits is [1,0,9,2,1].

* Example 1:
    Input: nums = [13,25,83,77]
    Output: [1,3,2,5,8,3,7,7]
    Explanation:
    - The separation of 13 is [1,3].
    - The separation of 25 is [2,5].
    - The separation of 83 is [8,3].
    - The separation of 77 is [7,7].
    answer = [1,3,2,5,8,3,7,7]. Note that answer contains the separations in the same order.

* Example 2:
    Input: nums = [7,1,3,9]
    Output: [7,1,3,9]
    Explanation: The separation of each integer in nums is itself.
    answer = [7,1,3,9].
* */

public class SeparateDigitsInArray {
    public static void main(String[] args) {
        int[] nums = {13, 25, 83, 77};

        int[] res = separateDigits(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] separateDigits(int[] nums) {
        int totalDigitCnt = 0; // 8

        for (int num : nums) {
            while (num != 0) {
                totalDigitCnt++;
                num /= 10;
            }
        }

        int[] ans = new int[totalDigitCnt]; // 8

        for (int i = nums.length - 1; i >= 0; i--) {
            while (nums[i] != 0) {
                // -- first as we need to start with 7 first and totalDigitCnt = 8
                ans[--totalDigitCnt] = nums[i] % 10;
                nums[i] /= 10;
            }
        }

        return ans;
    }

    public static int[] separateDigits_alt(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            List<Integer> currList = new ArrayList<>(); // for 13 => 3, 1
            while (num != 0) {
                currList.add(num % 10);
                num /= 10;
            }

            Collections.reverse(currList); // 1, 3
            list.addAll(currList);
        }

        int[] res = new int[list.size()];

        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
