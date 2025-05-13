package LeetCode.Medium;

/*
* Given an integer array nums, find a subarray that has the largest product, and return the product.
* The test cases are generated so that the answer will fit in a 32-bit integer.
* Example 1:
    Input: nums = [2,3,-2,4]
    Output: 6
    Explanation: [2,3] has the largest product 6.

* Example 2:
    Input: nums = [-2,0,-1]
    Output: 0
    Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
* */

public class MaximumProductSubArray {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 5, 6, -1, 4};

        int maxProduct = maxProductSubArray(nums);
        System.out.println(maxProduct);
    }

    public static int maxProductSubArray(int[] nums) {
        int n = nums.length;

        int leftProduct = 1;
        int rightProduct = 1;

        int maxProduct = nums[0]; // best case -> if only 1 el, max is the same element

        for (int i = 0; i < nums.length; i++) {
            // if 0 is encountered, make 1 to discard left/right elements from product and start fresh
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

            leftProduct *= nums[i]; // start product from 0, 1, 2, ...
            rightProduct *= nums[n - 1 - i]; // start product from 6, 5, 4

            maxProduct = Math.max(maxProduct, Math.max(leftProduct, rightProduct));
        }

        return maxProduct;
    }
}
