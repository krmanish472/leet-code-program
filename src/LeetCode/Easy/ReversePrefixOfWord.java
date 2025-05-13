package LeetCode.Easy;

/*
* Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0
* and ends at the index of the first occurrence of ch (inclusive). If the character ch does not exist in word, do nothing.

* For example, if word = "abcdefd" and ch = "d", then you should reverse the segment that starts at 0 and ends at 3 (inclusive).
* The resulting string will be "dcbaefd".

* Return the resulting string.

* Example 1:
    Input: word = "abcdefd", ch = "d"
    Output: "dcbaefd"
    Explanation: The first occurrence of "d" is at index 3.
    Reverse the part of word from 0 to 3 (inclusive), the resulting string is "dcbaefd".

* Example 2:
    Input: word = "abcd", ch = "z"
    Output: "abcd"
    Explanation: "z" does not exist in word.
    You should not do any reverse operation, the resulting string is "abcd".

* */

import java.util.Stack;

public class ReversePrefixOfWord {
    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';

        String rev = reversePrefix(word, ch);
        System.out.println(rev);
    }

    public static String reversePrefix(String word, char ch) {
        int firstOccurIdx = word.indexOf(ch);
        // if the char is not present in the given string
        if (firstOccurIdx == -1) {
            return word;
        }

        // add elements until 1st occurrence to stack
        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i <= firstOccurIdx; i++) {
            charStack.push(word.charAt(i));
        }

        StringBuilder res = new StringBuilder();

        // add chars from stack to res - gives reverse order
        while (!charStack.isEmpty()) {
            res.append(charStack.pop());
        }

        for (int i = firstOccurIdx + 1; i < word.length(); i++) {
            res.append(word.charAt(i));
        }

        return res.toString();
    }

    public static String reversePrefix_2Ptr(String word, char ch) {
        int firstOccurIdx = word.indexOf(ch);
        int left = 0;
        int right = firstOccurIdx;

        char[] arr = word.toCharArray();

        while (left <= right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        return new String(arr);
    }
}
