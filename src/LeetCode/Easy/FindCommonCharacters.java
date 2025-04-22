package LeetCode.Easy;

/*
* Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates).
* You may return the answer in any order.

* Example 1:
    Input: words = ["bella","label","roller"]
    Output: ["e","l","l"]

* Example 2:
    Input: words = ["cool","lock","cook"]
    Output: ["c","o"]
* */

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {
    public static void main(String[] args) {
        String[] words = {"bella", "label", "roller"};

        List<String> result = commonChars(words);
        System.out.println(result);
    }

    public static List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();

        for (int c = 'a'; c <= 'z'; c++) {
            int minCount = Integer.MAX_VALUE;

            // loop through each word
            for (String currentWord : words) {
                int wordCount = 0;
                // in each word, count the occurrence of letter/char
                for (char currentChar : currentWord.toCharArray()) {
                    if (currentChar == c) {
                        wordCount++;
                    }
                }
                // get minimum occurrence count
                minCount = Math.min(minCount, wordCount);
            }

            for (int i = 0; i < minCount; i++) {
                result.add("" + (char) c);
            }
        }

        return result;
    }
}
