package LeetCode.Easy;

/*
* Given a string s consisting of words and spaces, return the length of the last word in the string.
* A word is a maximal substring consisting of non-space characters only.

* Example 1:
    Input: s = "Hello World"
    Output: 5
    Explanation: The last word is "World" with length 5.

* Example 2:
    Input: s = "   fly me   to   the moon  "
    Output: 4
    Explanation: The last word is "moon" with length 4.
* */

public class LengthOfLastWord {
    public static void main(String[] args) {
        String str = "Hello World";

        int lengthOfLastWord = lengthOfLastWord(str);
        System.out.println(lengthOfLastWord);
    }

    public static int lengthOfLastWord(String str) {
        int count = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) != ' ') {
                count++;
            } else {
                // it's a white space instead
                // Did we already started to count a word ? => "   fly me   to   the moon  " for this scenario
                if (count > 0) {
                    return count;
                }
            }
        }
        return count;
    }
}
