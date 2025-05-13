package LeetCode.Easy;

/*
* Given a string s, reverse the string according to the following rules:
    All the characters that are not English letters remain in the same position.
    All the English letters (lowercase or uppercase) should be reversed.
    Return s after reversing it.

* Example 1:
    Input: s = "ab-cd"
    Output: "dc-ba"

* Example 2:
    Input: s = "a-bC-dEf-ghIj"
    Output: "j-Ih-gfE-dCba"

* Example 3:
    Input: s = "Test1ng-Leet=code-Q!"
    Output: "Qedo1ct-eeLg=ntse-T!"
* */

public class ReverseOnlyLetters {
    public static void main(String[] args) {
        String str = "a-bC-dEf-ghIj";

        String rev = reverseOnlyLetters(str);
        System.out.println(rev);
    }

    public static String reverseOnlyLetters(String s) {
        int start = 0;
        int end = s.length() - 1;

        char[] arr = s.toCharArray();

        while (start < end) {
            if (!Character.isLetter(arr[start])) {
                start++;
                continue; // or use while loop - check ValidPalindrome
            }
            if (!Character.isLetter(arr[end])) {
                end--;
                continue; // or use while loop - check ValidPalindrome
            }

            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return new String(arr);
    }
}
