package LeetCode.Easy;

/*
* A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
* Each word consists of lowercase and uppercase English letters.

* A sentence can be shuffled by appending the 1-indexed word position to each word then rearranging the words in the sentence.

* Example 1:
    Input: s = "is2 sentence4 This1 a3"
    Output: "This is a sentence"
    Explanation: Sort the words in s to their original positions "This1 is2 a3 sentence4", then remove the numbers.

* Example 2:
    Input: s = "Myself2 Me1 I4 and3"
    Output: "Me Myself and I"
    Explanation: Sort the words in s to their original positions "Me1 Myself2 and3 I4", then remove the numbers.
* */
public class SortingTheSentence {
    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";

        String actualSentence = sortSentence(s);
        System.out.println(actualSentence);
    }

    public static String sortSentence(String str) {
        String[] words = str.split(" ");

        // string array to form final string
        String[] res = new String[words.length];

        for (String word : words) {
            int lastIdx = word.length() - 1;

            // get the actual index and actual word
            int actualIdx = word.charAt(lastIdx) - '1';
            String actualWord = word.substring(0, lastIdx);

            res[actualIdx] = actualWord;
        }

        // build actual string
        StringBuilder actualSentence = new StringBuilder();
        for (String s : res) {
            actualSentence.append(s);
            actualSentence.append(" ");
        }

        return actualSentence.toString().trim();
    }
}
