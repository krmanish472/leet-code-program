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
        int[] nums = {2, 3, -2, 4};

        System.out.println(maxProductSubArray(nums));
        System.out.println(maxProductSubArray(new int[]{-2, 0, -1}));
    }

    public static int maxProductSubArray(int[] arr) {
        int maxProduct = arr[0];
        int minProduct = arr[0];
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < 0) { // if negative is encountered, swap min-max product
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(arr[i], maxProduct * arr[i]);
            minProduct = Math.min(arr[i], minProduct * arr[i]);

            result = Math.max(result, maxProduct);
        }
        return result;
    }
}
