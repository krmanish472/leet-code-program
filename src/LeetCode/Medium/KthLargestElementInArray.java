package LeetCode.Medium;

/*
* Given an integer array nums and an integer k, return the kth largest element in the array.
* Note that it is the kth largest element in the sorted order, not the kth distinct element.
* Can you solve it without sorting?

* Example 1:
    Input: nums = [3,2,1,5,6,4], k = 2
    Output: 5

* Example 2:
    Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
    Output: 4
* */

import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int res = findKthLargest(nums, k);
        System.out.println(res);
    }

    public static int findKthLargest(int[] nums, int k) {
        // The elements of the priority queue are ordered according to their natural ordering,
        // or by a Comparator provided at queue construction time
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest element to maintain heap size as k
            }
        }

        return minHeap.peek(); // root of the minHeap is the kth largest element
    }
}
