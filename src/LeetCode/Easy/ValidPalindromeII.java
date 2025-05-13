package LeetCode.Easy;

/*
* Given a string s, return true if the s can be palindrome after deleting at most one character from it.

* Example 1:
    Input: s = "aba"
    Output: true

* Example 2:
    Input: s = "abca"
    Output: true
    Explanation: You could delete the character 'c'.

* Example 3:
    Input: s = "abc"
    Output: false
* */

public class ValidPalindromeII {
    public static void main(String[] args) {
        String str = "rotatxor";

        if (validPalindrome(str)) {
            System.out.println("Valid Palindrome");
        } else {
            System.out.println("Not a valid palindrome");
        }

    }

    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                // try deleting 1 char from either direction
                // atx || tat
                return isPalindrome(s, left + 1, right)
                        || isPalindrome(s, left, right - 1);
            }
        }
        return true;
    }

    private static boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
