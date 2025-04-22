package LeetCode.Medium;

/*
* Given an array of characters chars, compress it using the following algorithm:
* Begin with an empty string s. For each group of consecutive repeating characters in chars:
    If the group's length is 1, append the character to s.
    Otherwise, append the character followed by the group's length.
    The compressed string s should not be returned separately, but instead, be stored in the input character array chars.
* Note that group lengths that are 10 or longer will be split into multiple characters in chars.

* After you are done modifying the input array, return the new length of the array.

* Example 1:
    Input: chars = ["a","a","b","b","c","c","c"]
    Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
    Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
* */

public class StringCompression {
    public static void main(String[] args) {
        char[] arr = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};

        int compressesCharCount = compress(arr);
        System.out.println(compressesCharCount);
    }

    public static int compress(char[] arr) {
        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            int count = 0;

            while (i < arr.length && arr[i] == ch) {
                count++;
                i++;
            }

            if (count == 1) {
                arr[idx++] = ch;
            } else {
                arr[idx++] = ch;
                for (char c : String.valueOf(count).toCharArray()) {
                    arr[idx++] = c;
                }
            }
            i--;
        }
        return idx;
    }
}
