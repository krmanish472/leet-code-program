package LeetCode.Medium;

/*
* Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence
* of one or more dictionary words.
* Note that the same word in the dictionary may be reused multiple times in the segmentation.

* Example 1:
    Input: s = "leetcode", wordDict = ["leet","code"]
    Output: true
    Explanation: Return true because "leetcode" can be segmented as "leet code".

* Example 2:
    Input: s = "applepenapple", wordDict = ["apple","pen"]
    Output: true
    Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
    Note that you are allowed to reuse a dictionary word.

* Example 3:
    Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
    Output: false
* */

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");

        if (wordBreak(s, wordDict)) {
            System.out.println("Can break");
        } else {
            System.out.println("Can not break");
        }
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        // find maxLength of word in dict
        int maxLength = 0;
        for (String word : wordDict) {
            maxLength = Math.max(maxLength, word.length());
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // empty string is valid

        for (int i = 1; i <= s.length(); i++) {
            // check prefixes of length till maxLength
            for (int j = i - 1; j >= Math.max(0, i - maxLength); j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
