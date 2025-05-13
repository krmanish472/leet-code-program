package LeetCode.Easy;

/*
* You are given a binary string s that contains at least one '1'.
* You have to rearrange the bits in such a way that the resulting binary number is the maximum odd binary number
* that can be created from this combination.

* Return a string representing the maximum odd binary number that can be created from the given combination.
* Note that the resulting string can have leading zeros.

* Example 1:
    Input: s = "010"
    Output: "001"
    Explanation: Because there is just one '1', it must be in the last position. So the answer is "001".

* Example 2:
    Input: s = "0101"
    Output: "1001"
    Explanation: One of the '1's must be in the last position. The maximum number that can be made with the remaining digits is "100".
    So the answer is "1001".
* */

public class MaximumOddBinaryNumber {
    public static void main(String[] args) {
        String s = "0101";

        String maxOddBinary = maximumOddBinaryNumber(s);
        System.out.println(maxOddBinary);
    }

    // last digit should be 1
    // all big numbers should be at start
    public static String maximumOddBinaryNumber(String s) {
        int countZero = 0;
        int countOne = 0;
        // count 0s and 1s
        for (char c : s.toCharArray()) {
            if (c == '0') {
                countZero++;
            } else {
                countOne++;
            }
        }

        // build answer
        StringBuilder ans = new StringBuilder();

        // add 1 at the end
        ans.append(1);

        // add all zeros now
        ans.append("0".repeat(countZero));

        // add all ones now
        ans.append("1".repeat(countOne - 1));

        // reverse the string now
        return ans.reverse().toString();
    }
}
