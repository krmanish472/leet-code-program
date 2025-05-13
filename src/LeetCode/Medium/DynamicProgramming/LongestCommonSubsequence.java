package LeetCode.Medium.DynamicProgramming;

/*
* Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
* A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted
* without changing the relative order of the remaining characters.

* For example, "ace" is a subsequence of "abcde".
* A common subsequence of two strings is a subsequence that is common to both strings.

* Example 1:
    Input: text1 = "abcde", text2 = "ace"
    Output: 3
    Explanation: The longest common subsequence is "ace" and its length is 3.

* Example 2:
    Input: text1 = "abc", text2 = "abc"
    Output: 3
    Explanation: The longest common subsequence is "abc" and its length is 3.

* Example 3:
    Input: text1 = "abc", text2 = "def"
    Output: 0
    Explanation: There is no such common subsequence, so the result is 0.
* */

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        int longestCommonSubsequence = longestCommonSubsequence(text1, text2);
        System.out.println(longestCommonSubsequence);
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1]; // create 2D array to store DP of 2 strings

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) { // for add 1 to vertically opposite
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]); // for non-common char, max of prev 2
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
