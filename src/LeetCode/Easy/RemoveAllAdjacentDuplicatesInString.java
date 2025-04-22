package LeetCode.Easy;

/*
* You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent
* and equal letters and removing them.

* We repeatedly make duplicate removals on s until we no longer can.
* Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

* Example 1:
    Input: s = "abbaca"
    Output: "ca"
    Explanation:
    For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.
    The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".

* Example 2:
    Input: s = "azxxzy"
    Output: "ay"
* */

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        String s = "abbaca";

        String res = removeDuplicates(s);
        System.out.println(res);

        String res1 = removeDuplicates_withStack(s);
        System.out.println(res1);
    }

    public static String removeDuplicates(String s) {
        char[] stack = new char[s.length()];
        int idx = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (idx > 0 && currentChar == stack[idx - 1]) {
                idx--;
            } else {
                stack[idx] = currentChar;
                idx++;
            }
        }
        return new String(stack, 0, idx);
    }

    public static String removeDuplicates_withStack(String s) {
        Stack<Character> main = new Stack<>();

        for (char c : s.toCharArray()) {
            if (main.isEmpty() || c != main.peek()) {
                main.push(c);
            } else {
                main.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!main.isEmpty()) {
            sb.append(main.pop());
        }

        return sb.reverse().toString();
    }
}
