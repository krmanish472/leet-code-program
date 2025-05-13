package LeetCode.Easy;

/*
* You are given an array of strings words and a string pref.

* Return the number of strings in words that contain pref as a prefix.

* A prefix of a string s is any leading contiguous substring of s.

* Example 1:
    Input: words = ["pay","attention","practice","attend"], pref = "at"
    Output: 2
    Explanation: The 2 strings that contain "at" as a prefix are: "attention" and "attend".

* Example 2:
    Input: words = ["leetcode","win","loops","success"], pref = "code"
    Output: 0
    Explanation: There are no strings that contain "code" as a prefix.
* */

public class CountingWordsWithGivenPrefix {
    public static void main(String[] args) {
        String[] words = {"pay", "attention", "practice", "attend"};
        String prefix = "at";

        int count = prefixCount(words, prefix);
        System.out.println(count);
    }

    public static int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                count++;
            }
        }

        return count;
    }

    public static int prefixCount_withoutInBuildMethod(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.substring(0, Math.min(pref.length(), word.length())).equals(pref)) {
                count++;
            }
        }

        return count;
    }
}
