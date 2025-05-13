package LeetCode.Easy.TwoPointer;

import java.util.Arrays;

/*
* Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].

* Return the array in the form [x1,y1,x2,y2,...,xn,yn].

* Example 1:
    Input: nums = [2,5,1,3,4,7], n = 3
    Output: [2,3,5,4,1,7]
    Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].

* Example 2:
    Input: nums = [1,2,3,4,4,3,2,1], n = 4
    Output: [1,4,2,3,3,2,4,1]
* */

// Note: even if n is not provided we can get it by half of length of arr
public class ShuffleTheArray {
    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;

        int[] res = shuffle(nums, n);
        System.out.println(Arrays.toString(res));
    }

    public static int[] shuffle(int[] nums, int n) { // nums = {x1, x2, x3, y1, y2, y3}
        int[] ans = new int[nums.length]; // {x1, y1, x2, y2, x3, y3}
        int xPtr = 0;
        int yPtr = n;

        int idx = 0;
        // loop till xPtr covers all X and yPtr covers all Y
        while (xPtr < n || yPtr < nums.length) {
            ans[idx++] = nums[xPtr++];
            ans[idx++] = nums[yPtr++];
        }

        return ans;
    }
}
