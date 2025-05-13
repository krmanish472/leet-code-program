package LeetCode.Easy;

/*
* Given a string s and a character c that occurs in s,
* return an array of integers answer where answer.length == s.length and
* answer[i] is the distance from index i to the closest occurrence of character c in s.

* The distance between two indices i and j is abs(i - j), where abs is the absolute value function.

* Example 1:
    Input: s = "loveleetcode", c = "e"
    Output: [3,2,1,0,1,0,0,1,2,2,1,0]

* Example 2:
    Input: s = "aaab", c = "b"
    Output: [3,2,1,0]
* */

import java.util.Arrays;
import java.util.Map;

public class ShortestDistanceToCharacter {
    public static void main(String[] args) {
        String s = "baaa";

        int[] res = shortestToChar(s, 'b');
        System.out.println(Arrays.toString(res));
    }

    public static int[] shortestToChar(String s, char c) {
        int[] ans = new int[s.length()];
        Arrays.fill(ans, Integer.MAX_VALUE);

        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (s.charAt(right) == c) {
                while (left <= right) {
                    ans[left] = Math.abs(right - left);
                    left++;
                }
            }
            right++;
        }

        // Second pass: right to left
        left = s.length() - 1;
        right = s.length() - 1;
        while (right >= 0) {
            if (s.charAt(right) == c) {
                while (left >= right) {
                    ans[left] = Math.min(ans[left], Math.abs(right - left));
                    left--;
                }
            }
            right--;
        }

        return ans;
    }

    public int[] shortestToChar_alt(String s, char c) {
        int[] ans = new int[s.length()];

        // First pass: left to right
        int prev = Integer.MIN_VALUE / 2;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            ans[i] = i - prev;
        }

        // Second pass: right to left
        prev = Integer.MAX_VALUE / 2;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            ans[i] = Math.min(ans[i], prev - i);
        }

        return ans;
    }
}
