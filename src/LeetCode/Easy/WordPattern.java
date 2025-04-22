package LeetCode.Easy;

/*
* Given a pattern and a string s, find if s follows the same pattern.
* Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
* Specifically:
    Each letter in pattern maps to exactly one unique word in s.
    Each unique word in s maps to exactly one letter in pattern.
    No two letters map to the same word, and no two words map to the same letter.

* Example 1:
    Input: pattern = "abba", s = "dog cat cat dog"
    Output: true
    Explanation:
    The bijection can be established as:
    'a' maps to "dog".
    'b' maps to "cat".

* Example 2:
    Input: pattern = "abba", s = "dog cat cat fish"
    Output: false
* */

import java.util.HashMap;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat dog";
        if (wordPattern(pattern, s)) {
            System.out.println("Follows pattern");
        } else {
            System.out.println("Does not follow pattern");
        }
    }

    public static boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");

        if (pattern.length() != arr.length) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            // if a -> dog, b -> cat => if key is present but value does not match
            if (map.containsKey(ch) && !map.get(ch).equals(arr[i])) {
                return false;
            }
            // if a -> dog, b -> dog => we need to stop this duplicate mapping
            // i.e. if map already has that value, key should be present
            if (map.containsValue(arr[i]) && !map.containsKey(ch)) {
                return false;
            } else {
                map.put(ch, arr[i]);
            }
        }
        return true;
    }
}
