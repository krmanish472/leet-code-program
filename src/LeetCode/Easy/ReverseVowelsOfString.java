package LeetCode.Easy;

/*
* Given a string s, reverse only all the vowels in the string and return it.
* The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

* Example 1:
    Input: s = "IceCreAm"
    Output: "AceCreIm"
    Explanation:
    The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

* Example 2:
Input: s = "leetcode"
Output: "leotcede"
* */

// 2 Pointers
public class ReverseVowelsOfString {
    public static void main(String[] args) {
        String s = "IceCreAm";
        String reversedWord = reverseVowels(s);
        System.out.println(reversedWord);
    }

    public static String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        int leftPtr = 0;
        int rightPtr = s.length() - 1;

        while (leftPtr < rightPtr) {
            if (!isVowel(charArray[leftPtr])) {
                leftPtr++;
            } else if (!isVowel(charArray[rightPtr])) {
                rightPtr--;
            } else {
                swap(charArray, leftPtr, rightPtr);
                leftPtr++;
                rightPtr--;
            }
        }
        return String.valueOf(charArray);
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'A' ||
                ch == 'e' || ch == 'E' ||
                ch == 'i' || ch == 'I' ||
                ch == 'o' || ch == 'O' ||
                ch == 'u' || ch == 'U';
    }

    private static void swap(char[] arr, int idx1, int idx2) {
        char temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
