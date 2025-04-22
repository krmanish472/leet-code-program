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
        String s = "egg", t = "add";
        if (isIsomorphic(s, t)) {
            System.out.println("Isomorphic");
        } else {
            System.out.println("Not Isomorphic");
        }
    }

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && !map.get(s.charAt(i)).equals(t.charAt(i))) {
                return false;
            }
            if (map.containsValue(t.charAt(i)) && !map.containsKey(s.charAt(i))) {
                return false;
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}
