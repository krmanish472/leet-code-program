package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/*
* Given an array of strings words and a character separator, split each string in words by separator.
* Return an array of strings containing the new strings formed after the splits, excluding empty strings.

* Notes
    separator is used to determine where the split should occur, but it is not included as part of the resulting strings.
    A split may result in more than two strings.

* The resulting strings must maintain the same order as they were initially given.

* Example 1:
    Input: words = ["one.two.three","four.five","six"], separator = "."
    Output: ["one","two","three","four","five","six"]
    Explanation: In this example we split as follows:

    "one.two.three" splits into "one", "two", "three"
    "four.five" splits into "four", "five"
    "six" splits into "six"
    Hence, the resulting array is ["one","two","three","four","five","six"].

* Example 2:
    Input: words = ["$easy$","$problem$"], separator = "$"
    Output: ["easy","problem"]
    Explanation: In this example we split as follows:
    "$easy$" splits into "easy" (excluding empty strings)
    "$problem$" splits into "problem" (excluding empty strings)
    Hence, the resulting array is ["easy","problem"].

* */
public class SplitStringsBySeparator {
    public static void main(String[] args) {
        List<String> words = List.of("$easy$", "$problem$");
        List<String> words1 = List.of("one.two.three", "four.five", "six");

        List<String> res = splitWordsBySeparator(words, '$');
        System.out.println(res);

        List<String> res1 = splitWordsBySeparator(words1, '.');
        System.out.println(res1);
    }

    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();

        for (String word : words) { // $easy$
            int left = 0, right = 0;

            while (right < word.length()) {
                if (word.charAt(right) == separator) {
                    // only add if it's not an empty string
                    if (left < right) {
                        result.add(word.substring(left, right));
                    }
                    // point to the start of next word
                    left = right + 1;
                }
                right++;
            }
            // for last word
            if (left < word.length()) {
                result.add(word.substring(left));
            }
        }

        return result;
    }

    public static List<String> splitWordsBySeparator_alt(List<String> words, char separator) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            String[] splitWords = word.split(Pattern.quote(String.valueOf(separator)));
            // above is equivalent to
            // String[] splitWords = word.split("\\$");
            for (String splitWord : splitWords) {
                if (splitWord.length() > 0) {
                    result.add(splitWord);
                }
            }
        }

        return result;
    }
}
