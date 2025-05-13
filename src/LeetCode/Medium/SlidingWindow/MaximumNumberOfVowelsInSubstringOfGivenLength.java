package LeetCode.Medium.SlidingWindow;

/*
* Given a string s and an integer k,
* return the maximum number of vowel letters in any substring of s with length k.

* Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

* Example 1:
    Input: s = "abciiidef", k = 3
    Output: 3
    Explanation: The substring "iii" contains 3 vowel letters.

* Example 2:
    Input: s = "aeiou", k = 2
    Output: 2
    Explanation: Any substring of length 2 contains 2 vowels.

* Example 3:
    Input: s = "leetcode", k = 3
    Output: 2
    Explanation: "lee", "eet" and "ode" contain 2 vowels.
* */

public class MaximumNumberOfVowelsInSubstringOfGivenLength {
    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;

        int maxCount = maxVowels(s, k);
        System.out.println(maxCount);
    }

    public static int maxVowels(String s, int k) {
        int maxVowelCount = 0;
        int currVowelCount = 0;

        int low = 0;
        int high = 0;
        while (high < s.length()) {
            // start with each element and if vowel, increase count
            if (isVowel(s.charAt(high))) {
                currVowelCount++;
            }

            // check if the current window crossed the sliding window size - k
            while (high - low + 1 > k) {
                // remove count from front
                if (isVowel(s.charAt(low))) {
                    currVowelCount--;
                }
                low++; // keep window size intact
            }

            high++;

            maxVowelCount = Math.max(maxVowelCount, currVowelCount);
        }

        return maxVowelCount;
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'A' ||
                ch == 'e' || ch == 'E' ||
                ch == 'i' || ch == 'I' ||
                ch == 'o' || ch == 'O' ||
                ch == 'u' || ch == 'U';
    }
}
