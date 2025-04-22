package LeetCode.Easy;

/*
* Write a function to find the longest common prefix string amongst an array of strings.
* If there is no common prefix, return an empty string "".

* Example 1:
    Input: strs = ["flower","flow","flight"]
    Output: "fl"

* Example 2:
    Input: strs = ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.
* */

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};

        String commonPrefix = longestCommonPrefix(strs);
        System.out.println(commonPrefix);
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        Arrays.sort(strs);

        // get the first and last strings
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();

        // start comparing
        for (int i = 0; i < first.length; i++) {
            if (first[i] != last[i]) {
                break;
            }
            result.append(first[i]);
        }
        return result.toString();
    }
}
