package LeetCode.Medium;

/*
* Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
* In other words, return true if one of s1's permutations is the substring of s2.
* Example 1:
    Input: s1 = "ab", s2 = "eidbaooo"
    Output: true
    Explanation: s2 contains one permutation of s1 ("ba").

* Example 2:
    Input: s1 = "ab", s2 = "eidboaoo"
    Output: false
* */

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";

        if (checkInclusion(s1, s2)) {
            System.out.println("Permutation present");
        } else {
            System.out.println("Permutation not present");
        }
    }

    public static boolean checkInclusion(String s1, String s2) {
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++; // add all elements of s1 => 2
            s2Map[s2.charAt(i) - 'a']++; // add 2 subsequent elements => ei
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1Map, s2Map)) { // check if arrays are equal
                return true;
            }
            s2Map[s2.charAt(s1.length() + i) - 'a']++; // add next element
            s2Map[s2.charAt(i) - 'a']--; // remove previous element(s)
        }
        return matches(s1Map, s2Map);
    }

    public static boolean matches(int[] s1Map, int[] s2Map) {
        for (int i = 0; i < 26; i++) {
            if (s1Map[i] != s2Map[i]) {
                return false;
            }
        }
        return true;
    }
}
