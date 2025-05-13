package LeetCode.Medium;

import java.util.PriorityQueue;

/*
* You are given an array of non-negative integers nums and an integer k.
* In one operation, you may choose any element from nums and increment it by 1.

* Return the maximum product of nums after at most k operations.
* Since the answer may be very large, return it modulo 109 + 7.

* Note that you should maximize the product before taking the modulo.

* Example 1:
    Input: nums = [0,4], k = 5
    Output: 20
    Explanation: Increment the first number 5 times.
    Now nums = [5, 4], with a product of 5 * 4 = 20.
    It can be shown that 20 is maximum product possible, so we return 20.
    Note that there may be other ways to increment nums to have the maximum product.

* Example 2:
    Input: nums = [6,3,3,2], k = 2
    Output: 216
    Explanation: Increment the second number 1 time and increment the fourth number 1 time.
    Now nums = [6, 4, 3, 3], with a product of 6 * 4 * 3 * 3 = 216.
    It can be shown that 216 is maximum product possible, so we return 216.
    Note that there may be other ways to increment nums to have the maximum product.
* */
public class MaximumProductAfterKIncrements {
    public static void main(String[] args) {
        int[] nums = {6, 3, 4, 2, 5};
        int k = 4;

        int maxProduct = maximumProduct(nums, k);
        System.out.println(maxProduct);
    }

    public static int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // defaults to natural order
        int mod = 1000000007;

        for (int num : nums) {
            pq.add(num);
        }

        for (int i = 0; i < k; i++) {
            // get the minimum element and increment by 1
            int minElement = pq.remove();
            minElement++;

            // add it back to priority queue
            pq.offer(minElement);
        }

        // find the product
        long result = 1;
        while (!pq.isEmpty()) {
            result *= pq.poll();
            result %= mod;
        }

        return (int) result;
    }
}
