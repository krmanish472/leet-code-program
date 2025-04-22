package LeetCode.Medium;

/*
* Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
* The following rules define a valid string:
    Any left parenthesis '(' must have a corresponding right parenthesis ')'.
    Any right parenthesis ')' must have a corresponding left parenthesis '('.
    Left parenthesis '(' must go before the corresponding right parenthesis ')'.
    '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
* Example 1:
    Input: s = "()"
    Output: true

Example 2:
    Input: s = "(*)"
    Output: true

Example 3:
    Input: s = "(*))"
    Output: true
* */
public class ValidParenthesisString {
    public static void main(String[] args) {
        String s = "(*))";
        if (checkValidString(s)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }

    public static boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // treat '(' as open parenthesis
                minOpen++;
                maxOpen++;
            } // treat ')' as closed parenthesis
            else if (c == ')') {
                minOpen--;
                maxOpen--;
            } // * can be treated as '(' or ')' or ""
            else {
                minOpen--; // treat * as ')'
                maxOpen++; // treat * as '('
            }

            // if maxOpen is negative, means too many ')'
            if (maxOpen < 0) {
                return false;
            }
            // minOpen can not be negative
            minOpen = Math.max(minOpen, 0);
        }
        return minOpen == 0; // means '(' can be matched with ')'
    }
}
