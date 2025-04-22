package LeetCode.Easy;

/*
* Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
* A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
* of the characters without disturbing the relative positions of the remaining characters.
* (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
*
* Example 1:
    Input: s = "abc", t = "ahbgdc"
    Output: true
Example 2:
    Input: s = "axc", t = "ahbgdc"
    Output: false
* */

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        if (isSubsequence(s, t)){
            System.out.println("Is subsequence");
        } else {
            System.out.println(" Is not a subsequence");
        }
    }

    public static boolean isSubsequence(String str1, String str2) {
        int s1Ptr = 0;
        int s2Ptr = 0;

        while (s1Ptr < str1.length() && s2Ptr < str2.length()) {
            if (str1.charAt(s1Ptr) == str2.charAt(s2Ptr)) {
                // move both pointers to compare next char
                s1Ptr++;
                s2Ptr++;
            } else {
                // move t pointer to check if it is present later in the string
                s2Ptr++;
            }
        }
        // if subsequence, s1Ptr will have reached the end of str1 length
        return s1Ptr == str1.length();
    }
}
