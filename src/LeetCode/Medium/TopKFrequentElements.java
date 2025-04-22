package LeetCode.Medium;

import java.util.*;

/*
* Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
* Example:
    Input: nums = [1,1,1,2,2,3], k = 2
    Output: [1,2]
* Example2:
    Input: nums = [1], k = 1
    Output: [1]
* */

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] input = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] res = topKFrequent(input, k);
        System.out.println(Arrays.toString(res));
    }

    static int[] topKFrequent(int[] arr, int k) {
        // best case
        if (k == arr.length) {
            return arr;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int el : arr) {
            map.put(el, map.getOrDefault(el, 0) + 1);
        }

        // The elements of the priority queue are ordered according to their natural ordering,
        // or by a Comparator provided at queue construction time
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (int key : map.keySet()) {
            heap.add(key);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }
        return ans;
    }
}
