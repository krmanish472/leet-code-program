package LeetCode.Easy;

/*
* Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:
    Input: s = "leetcode"
    Output: 0
    Explanation:
    The character 'l' at index 0 is the first character that does not occur at any other index.

* Example 2:
    Input: s = "loveleetcode"
    Output: 2

* Example 3:
    Input: s = "aabb"
    Output: -1
* */

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterinString {
    public static void main(String[] args) {
        String s = "loveleetcode";

        int res = firstUniqChar(s);
        int res1 = firstUniqChar_withHashMap(s);
        int res2 = firstUniqChar_withCharArray(s);

        System.out.println(res);
        System.out.println(res1);
        System.out.println(res2);
    }

    // basic way
    public static int firstUniqChar(String str) {
        for (int i = 0; i < str.length(); i++) {
            boolean unique = true;
            // loop through all elements - no logic for visited
            for (int j = 0; j < str.length(); j++) {
                // i != j => exclude the char at same index
                if (i != j && str.charAt(i) == str.charAt(j)) {
                    unique = false;
                    break; // if a char is repeating even once, no need to check for another repetition
                }
            }
            if (unique) {
                return i;
            }
        }
        return -1;
    }

    // preferred way
    public static int firstUniqChar_withHashMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static int firstUniqChar_withCharArray(String str) {
        int[] freqArr = new int[26];

        for (int i = 0; i < str.length(); i++) {
            freqArr[str.charAt(i) - 'a']++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (freqArr[str.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
