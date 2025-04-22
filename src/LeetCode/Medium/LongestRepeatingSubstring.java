package LeetCode.Medium;

// Longest Repeating Substring -- without repeating characters
// Return the length

import java.util.HashSet;
import java.util.Set;

// 2-pointer approach
public class LongestRepeatingSubstring {
    public static void main(String[] args) {
        String s = "pwwkewxpw";
        int res = lengthOfLongestSubstring(s);
        System.out.println(res);
    }

    static int lengthOfLongestSubstring(String str) {
        Set<Character> set = new HashSet<>();

        int maxLength = 0;
        int leftPtr = 0;

        for (int right = 0; right < str.length(); right++) {
            while (set.contains(str.charAt(right))) {
                set.remove(str.charAt(leftPtr));
                leftPtr++;
            }

            set.add(str.charAt(right));
            maxLength = Math.max(maxLength, right - leftPtr + 1);
        }
        return maxLength;
    }
}
