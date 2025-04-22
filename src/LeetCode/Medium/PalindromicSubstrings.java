package LeetCode.Medium;

/*
* Given a string s, return the number of palindromic substrings in it.
* A string is a palindrome when it reads the same backward as forward.
* A substring is a contiguous sequence of characters within the string.

Example 1:
    Input: s = "abc"
    Output: 3
    Explanation: Three palindromic strings: "a", "b", "c".

* Example 2:
    Input: s = "aaa"
    Output: 6
    Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
* */
public class PalindromicSubstrings {
    public static void main(String[] args) {
        String str = "abbac";
        int res = countSubstrings(str); // [a, b, b, a, c, bb, abba]
        System.out.println(res);
    }

    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // count palindrome with odd length
            count += countPalindrome(s, i, i);
            // count palindrome with even length
            count += countPalindrome(s, i, i + 1);
        }
        return count;
    }

    private static int countPalindrome(String s, int left, int right) {
        int count = 0;
        while (left != -1 && right != s.length()
                && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
