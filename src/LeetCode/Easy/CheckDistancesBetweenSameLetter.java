package LeetCode.Easy;

/*
* You are given a 0-indexed string s consisting of only lowercase English letters,
* where each letter in s appears exactly twice. You are also given a 0-indexed integer array distance of length 26.

* Each letter in the alphabet is numbered from 0 to 25 (i.e. 'a' -> 0, 'b' -> 1, 'c' -> 2, ... , 'z' -> 25).

* In a well-spaced string, the number of letters between the two occurrences of the ith letter is distance[i].
* If the ith letter does not appear in s, then distance[i] can be ignored.

* Return true if s is a well-spaced string, otherwise return false.

* Example 1:
    Input: s = "abaccb", distance = [1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
    Output: true
    Explanation:
    - 'a' appears at indices 0 and 2 so it satisfies distance[0] = 1.
    - 'b' appears at indices 1 and 5 so it satisfies distance[1] = 3.
    - 'c' appears at indices 3 and 4 so it satisfies distance[2] = 0.
    Note that distance[3] = 5, but since 'd' does not appear in s, it can be ignored.
    Return true because s is a well-spaced string.

* Example 2:
    Input: s = "aa", distance = [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
    Output: false
    Explanation:
    - 'a' appears at indices 0 and 1 so there are zero letters between them.
    Because distance[0] = 1, s is not a well-spaced string.
* */

public class CheckDistancesBetweenSameLetter {
    public static void main(String[] args) {
        String s = "abaccb";
        int[] distance = {1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        checkDistances(s, distance);
    }

    public static boolean checkDistances(String s, int[] distance) {
        int[] initialIdxArr = new int[26];

        for (int i = 1; i <= s.length(); i++) {
            int currChar = s.charAt(i - 1) - 'a';
            if (initialIdxArr[currChar] != 0
                    && i - initialIdxArr[currChar] - 1 != distance[currChar]) {
                return false;
            }

            initialIdxArr[currChar] = i;
        }

        return true;
    }

    public static boolean checkDistances_alt(String s, int[] distance) {
        int[] initialIdxArr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int currChar = s.charAt(i) - 'a';
            if (initialIdxArr[currChar] == 0) {
                initialIdxArr[currChar] = i + 1;
            } else {
                if (i - initialIdxArr[currChar] != distance[s.charAt(i) - 'a']) {
                    return false;
                }
            }
        }

        return true;
    }
}
