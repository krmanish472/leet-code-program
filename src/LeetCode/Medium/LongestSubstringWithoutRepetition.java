package LeetCode.Medium;

/*
* Given a string s, find the length of the longest substring without duplicate characters.
* Example 1:
    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.
* */

import java.util.HashSet;

public class LongestSubstringWithoutRepetition {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int ans = 0;

        HashSet<Character> set = new HashSet<>();

        while (right < s.length()) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
