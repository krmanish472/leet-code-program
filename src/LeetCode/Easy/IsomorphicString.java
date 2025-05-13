package LeetCode.Easy;

/*
* Given two strings s and t, determine if they are isomorphic.
* Two strings s and t are isomorphic if the characters in s can be replaced to get t.
* All occurrences of a character must be replaced with another character while preserving the order of characters.
* No two characters may map to the same character, but a character may map to itself.

* Example 1:
    Input: s = "egg", t = "add"
    Output: true
    Explanation:
        The strings s and t can be made identical by:
        Mapping 'e' to 'a'.
        Mapping 'g' to 'd'.

* Example 2:
    Input: s = "foo", t = "bar"
    Output: false
    Explanation:
        The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.
* */

import java.util.HashMap;

public class IsomorphicString {
    public static void main(String[] args) {
        String s = "egf", t = "add";
        if (isIsomorphic(s, t)) {
            System.out.println("Isomorphic");
        } else {
            System.out.println("Not Isomorphic");
        }
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char original = s.charAt(i);
            char replacement = t.charAt(i);

            // check for: egf => add; for g<->d, next when we put f, we can't map it to d
            // as it's already mapped to key of g
            if (!map.containsKey(original)) {
                if (!map.containsValue(replacement)) {
                    map.put(original, replacement);
                } else {
                    return false;
                }
            } else {
                // check for: egg => adb; for g <-> d, next g should also be d
                if (map.get(original) != replacement) {
                    return false;
                }
            }
        }
        return true;
    }
}
