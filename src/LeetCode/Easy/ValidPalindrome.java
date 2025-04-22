package LeetCode.Easy;

/*
* Given a string s, return true if it is a palindrome, or false otherwise
    Input: s = "A man, a plan, a canal: Panama"
    Output: true
    Explanation: "amanaplanacanalpanama" is a palindrome.

    Input: s = "race a car"
    Output: false
    Explanation: "raceacar" is not a palindrome.
* */

public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        // String str = "race a car";

        if (isPalindrome(str)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
    }

    static boolean isPalindrome(String str) {
        int leftPtr = 0;
        int rightPtr = str.length() - 1;

        while (leftPtr < rightPtr) {
            // if any non-alphanumeric char found, move on
            while (leftPtr < rightPtr && !Character.isLetterOrDigit(str.charAt(leftPtr))) {
                leftPtr++;
            }
            // if any non-alphanumeric char found, move on
            while (leftPtr < rightPtr && !Character.isLetterOrDigit(str.charAt(rightPtr))) {
                rightPtr--;
            }

            if (Character.toLowerCase(str.charAt(leftPtr)) != Character.toLowerCase(str.charAt(rightPtr))) {
                return false;
            }

            leftPtr++;
            rightPtr--;
        }
        return true;
    }
}
