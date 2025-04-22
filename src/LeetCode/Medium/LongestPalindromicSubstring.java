package LeetCode.Medium;

/*
* Given a string s, return the longest palindromic substring in s.

* Example 1:
    Input: s = "babad"
    Output: "bab"
    Explanation: "aba" is also a valid answer.

* Example 2:
    Input: s = "cbbd"
    Output: "bb"
* */

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String str = "babad";

        String longestPalindromicSubstring = longestPalindrome(str);
        System.out.println(longestPalindromicSubstring);
    }

    public static String longestPalindrome(String str) {
        if (str.length() <= 1) {
            return str;
        }

        String longestPalindromeStr = "";

        for (int i = 1; i < str.length(); i++) {
            // consider odd length
            int low = i;
            int high = i;
            while (str.charAt(low) == str.charAt(high)) {
                low--;
                high++;
                // terminating condition - if we reach to end/start of the string
                if (low == -1 || high == str.length()) {
                    break;
                }
            }

            // indexes low and high can be used to extract substring
            String palindrome = str.substring(low + 1, high);
            if (palindrome.length() > longestPalindromeStr.length()) {
                longestPalindromeStr = palindrome;
            }

            // consider even length
            low = i - 1;
            high = i;
            while (str.charAt(low) == str.charAt(high)) {
                low--;
                high++;
                // terminating condition - if we reach to end/start of the string
                if (low == -1 || high == str.length()) {
                    break;
                }
            }
            // indexes low and high can be used to extract substring
            palindrome = str.substring(low + 1, high);
            if (palindrome.length() > longestPalindromeStr.length()) {
                longestPalindromeStr = palindrome;
            }
        }
        return longestPalindromeStr;
    }
}
