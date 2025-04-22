package LeetCode.Easy;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.
* */

import java.util.HashMap;
import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([])"));
    }

    public static boolean isValid(String s) {
        HashMap<Character, Character> mappedBrackets = new HashMap<>();
        mappedBrackets.put(')', '(');
        mappedBrackets.put('}', '{');
        mappedBrackets.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!mappedBrackets.containsKey(c)) {
                stack.push(c); // put open brackets in stack
            } else { // check for close brackets
                if (stack.isEmpty()) {
                    return false;
                }
                char topElement = stack.pop(); // open bracket
                if (topElement != mappedBrackets.get(c)) { // if open bracket equals open bracket
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
