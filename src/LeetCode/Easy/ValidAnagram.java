package LeetCode.Easy;

/*
* Given two strings s and t, return true if t is an anagram of s, and false otherwise.
    Input: s = "anagram", t = "nagaram"
    Output: true

    Input: s = "rat", t = "car"
    Output: false
* */

public class ValidAnagram {
    public static void main(String[] args) {
        String str1 = "anagram", str2 = "nagaram";
        // String str1 = "rat", str2 = "car";

        if (isAnagram(str1, str2)) {
            System.out.println("Valid Anagram");
        } else {
            System.out.println("Not a Valid Anagram");
        }
    }

    static boolean isAnagram(String str1, String str2) {
        // basic case => str length should be equal to  be anagram
        if (str1.length() != str2.length()) {
            return false;
        }

        // array to count character frequency
        int[] charCount = new int[26]; // a-z represents 26

        for (int i = 0; i < str1.length(); i++) {
            charCount[str1.charAt(i) - 'a']++; // increase freq of char in str1
            charCount[str2.charAt(i) - 'a']--; // decrease freq of char in str2
        }

        // after equal ++ and -- ... count should be 0
        for (int count : charCount) {
            if (count != 0) { // for anagram count will always be 0
                return false;
            }
        }

        return true;
    }
}
