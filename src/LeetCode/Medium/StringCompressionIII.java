package LeetCode.Medium;

/*
* Given a string word, compress it using the following algorithm:
* Begin with an empty string comp. While word is not empty, use the following operation:
    Remove a maximum length prefix of word made of a single character c repeating at most 9 times.
    Append the length of the prefix followed by c to comp.
* Return the string comp.

* Example 1:
    Input: word = "abcde"
    Output: "1a1b1c1d1e"

* Example 2:
    Input: word = "aaaaaaaaaaaaaabb"
    Output: "9a5a2b"
* */

public class StringCompressionIII {
    public static void main(String[] args) {
        String word = "abcde";

        String result = compressedString(word);
        System.out.println(result);

        String result1 = compressedString("aaaaaaaaaaaaaabb");
        System.out.println(result1);
    }

    public static String compressedString(String word) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int count = 0;
            while (i < word.length() && word.charAt(i) == ch) {
                if (count == 9) {
                    break;
                }
                count++;
                i++;
            }
            result.append(count);
            result.append(ch);
            i--;
        }
        return result.toString();
    }
}
