package LeetCode.Medium;

/*
* Given an integer array nums,
* return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
    Input: nums = [1,2,3,4]
    Output: [24,12,8,6]
* */

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};
        int[] res = productExceptSelf(input);

        System.out.println(Arrays.toString(res));
    }

    static int[] productExceptSelf(int[] arr) {
        int[] res = new int[arr.length];

        Arrays.fill(res, 1);

        int pre = 1, post = 1;

        // prefix -> for each element, multiply pre with prefix elements
        for (int i = 0; i < arr.length; i++) {
            res[i] = pre; // initially for 0th index it will be 1
            pre *= arr[i];
        }

        // postfix -> for each element from last, multiply post with postfix elements
        // - with whatever was calculated form prefix res
        for (int i = arr.length - 1; i >= 0; i--) {
            res[i] = res[i] * post;
            post *= arr[i];
        }

        return res;
    }
}
