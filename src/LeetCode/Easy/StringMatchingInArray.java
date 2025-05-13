package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

/*
* Given an array of string words, return all strings in words that are a substring of another word.
* You can return the answer in any order.

* Example 1:
    Input: words = ["mass","as","hero","superhero"]
    Output: ["as","hero"]
    Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
    ["hero","as"] is also a valid answer.

* Example 2:
    Input: words = ["leetcode","et","code"]
    Output: ["et","code"]
    Explanation: "et", "code" are substring of "leetcode".
* */

public class StringMatchingInArray {
    public static void main(String[] args) {
        String[] words = {"mass", "as", "hero", "superhero"};

        List<String> result = stringMatching(words);
        System.out.println(result);
    }

    public static List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        // Bruteforce: for each word, check if the other words (i!=j) is a substring of current word
        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < words.length; ++j) {
                // using words[j] contains... instead of words[i] contains to avoid duplicates
                if (i != j && words[j].contains(words[i])) {
                    ans.add(words[i]);
                    break;
                }
            }
        }

        return ans;
    }
}
