package LeetCode.Medium;

/*
* You are given a string s and an integer k. You can choose any character of the string and change it
* to any other uppercase English character. You can perform this operation at most k times.
* Return the length of the longest substring containing the same letter you can get after performing the above operations.
* Example 1:
    Input: s = "ABAB", k = 2
    Output: 4
    Explanation: Replace the two 'A's with two 'B's or vice versa.
* Example 2:
    Input: s = "HPHPH", k = 2
    Output: 5
    Explanation: Replace the two 'A's with two 'B's or vice versa.
* */

//  Sliding Window + 2 Ptr

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "HPHP";
        int k = 2;
        int res = characterReplacement(s, k);
        System.out.println(res);
    }

    public static int characterReplacement(String s, int k) {
        int[] occurrence = new int[26];
        int leftPtr = 0;
        int maxOccurrence = 0;
        int ans = 0;

        for (int rightPtr = 0; rightPtr < s.length(); rightPtr++) {
            maxOccurrence = Math.max(maxOccurrence, ++occurrence[s.charAt(rightPtr) - 'A']);
            if (rightPtr - leftPtr + 1 - maxOccurrence > k) {
                occurrence[s.charAt(leftPtr) - 'A']--; // remove character from front
                leftPtr++;
            }
            ans = Math.max(ans, rightPtr - leftPtr + 1);
        }
        return ans;
    }
}
