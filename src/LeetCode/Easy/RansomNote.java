package LeetCode.Easy;

/*
* Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine
* and false otherwise.
* Each letter in magazine can only be used once in ransomNote.

* Example 1:
    Input: ransomNote = "a", magazine = "b"
    Output: false

* Example 2:
    Input: ransomNote = "aa", magazine = "ab"
    Output: false

* Example 3:
    Input: ransomNote = "aa", magazine = "aab"
    Output: true
* */

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        String ransomNote1 = "aa", magazine1 = "ab";

        if (canConstruct(ransomNote1, magazine1)){
            System.out.println("Can construct");
        } else{
            System.out.println("Can not construct");
        }
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] charCount = new int[26];

        // Count the frequency of each character in the magazine
        for (char c : magazine.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (charCount[c - 'a'] == 0) {
                return false; // Character not available in magazine
            }
            charCount[c - 'a']--;
        }

        return true;
    }
}
