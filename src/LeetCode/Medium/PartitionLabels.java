package LeetCode.Medium;

/*
* You are given a string s. We want to partition the string into as many parts as possible so that
* each letter appears in at most one part.
* For example, the string "ababcc" can be partitioned into ["abab", "cc"],
* but partitions such as ["aba", "bcc"] or ["ab", "ab", "cc"] are invalid.

* Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

* Return a list of integers representing the size of these parts.

* Example 1:
    Input: s = "ababcbacadefegdehijhklij"
    Output: [9,7,8]
    Explanation:
    The partition is "ababcbaca", "defegde", "hijhklij".
    This is a partition so that each letter appears in at most one part.
    A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

* Example 2:
    Input: s = "eccbbbbdec"
    Output: [10]
* */

import java.util.ArrayList;
import java.util.List;

// Greedy Approach
public class PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> list = partitionLabels(s);
        System.out.println(list);
    }

    public static List<Integer> partitionLabels(String str) {
        List<Integer> partitions = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            // get 1st and last index of first character
            int startIdx = i;
            int endIdx = str.lastIndexOf(str.charAt(startIdx));

            // check if next char is occurring anywhere in string and get that index
            for (int j = startIdx + 1; j <= endIdx - 1; j++) {
                int lastIndexOfNextChar = str.lastIndexOf(str.charAt(j));
                // if next char in substring is occurring later after endIdx, include substring till that index
                // i.e. update endIdx
                if (lastIndexOfNextChar > endIdx) {
                    // update endIndex of substring
                    endIdx = lastIndexOfNextChar;
                }
            }
            int lengthOfSubstring = endIdx - startIdx + 1;
            partitions.add(lengthOfSubstring);
            i = endIdx + 1; // start after endIdx for next substring
        }
        return partitions;
    }
}
