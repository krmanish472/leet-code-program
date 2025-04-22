package LeetCode.Medium;

import java.util.HashSet;

/*
* Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

* Example 1:
    Input: nums = [100,4,200,1,3,2]
    Output: 4
    Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore, its length is 4.

* Example 1:
    Input: nums = [0,3,7,2,5,8,4,6,0,1]
    Output: 9
* */

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] num = {100, 4, 200, 1, 3, 2};
        // int[] num = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int N = longestConsecutive(num);
        System.out.println("Longest Consecutive Num - " + N);
    }

    static int longestConsecutive(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        // copy all elements to set
        for (int el : arr) {
            set.add(el);
        }

        int longestSeqCount = 1;
        for (int num : set) {
            // if set contains number less than current number -> it can't be the start of sequence
            if (set.contains(num - 1)) {
                continue;
            }
            int currentNum = num; // start of a sequence eg - 99
            int currentSeqCount = 1;
            // if subsequent number exists in set, increase sequence count
            while (set.contains(currentNum + 1)) {
                currentNum++; // 100, 101, 102 ...
                currentSeqCount++;
            }
            // if current sequence count is greater than longest sequence count - update longest sequence count
            longestSeqCount = Math.max(longestSeqCount, currentSeqCount);
        }
        return longestSeqCount;
    }
}
