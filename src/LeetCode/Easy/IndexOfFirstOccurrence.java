package LeetCode.Easy;

/*
* Given two strings needle and haystack,
* return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

* Example 1:
    Input: haystack = "sadbutsad", needle = "sad"
    Output: 0
    Explanation: "sad" occurs at index 0 and 6.
    The first occurrence is at index 0, so we return 0.

* Example 2:
    Input: haystack = "leetcode", needle = "leeto"
    Output: -1
    Explanation: "leeto" did not occur in "leetcode", so we return -1.
* */

public class IndexOfFirstOccurrence {
    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "but";

        int firstOccurrence = strStr(haystack, needle);
        System.out.println(firstOccurrence);
    }

    public static int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i, needle.length() + i).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
