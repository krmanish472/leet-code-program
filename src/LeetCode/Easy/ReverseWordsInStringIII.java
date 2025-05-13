package LeetCode.Easy;

/*
* Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace
* and initial word order.

* Example 1:
    Input: s = "Let's take LeetCode contest"
    Output: "s'teL ekat edoCteeL tsetnoc"

* Example 2:
    Input: s = "Mr Ding"
    Output: "rM gniD"
* */

public class ReverseWordsInStringIII {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";

        String reverseIII = reverseWords_2Ptr(s);
        System.out.println(reverseIII);
    }

    public static String reverseWords_2Ptr(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = 0;

        while (right < arr.length) {
            // if we find space reverse the word
            if (arr[right] == ' ') {
                reverseCharsInWord(arr, left, right - 1);
                left = right + 1; // one step after " " i.e. new word starting index
            }
            right++; // until we find space i.e. new word ends
        }

        // reverse the last word
        reverseCharsInWord(arr, left, right - 1);

        return new String(arr);
    }

    static void reverseCharsInWord(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}


