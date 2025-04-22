package LeetCode.Medium;

/*
* Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2,
* also represented as a string.
* Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

Example 1:
    Input: num1 = "2", num2 = "3"
    Output: "6"

Example 2:
    Input: num1 = "123", num2 = "456"
    Output: "56088"
* */

public class MultiplyString {
    public static void main(String[] args) {
        String num1 = "16", num2 = "13";
        System.out.println(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();

        // initialize an array to hold result of multiplication
        int[] result = new int[m + n];

        // reverse both num1 and num2 for easier calculation
        for (int i = m - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';

            for (int j = n - 1; j >= 0; j--) {
                int digit2 = num2.charAt(j) - '0';

                // multiply digits
                int mul = digit1 * digit2;

                // find position in the result array where to add the product.
                int mulIndex = i + j + 1; // mul result
                int carryIndex = i + j; // carry

                // add multiplication result to the current position and handle carry
                int sum = mul + result[mulIndex];

                result[mulIndex] = sum % 10; // get last digit and set the value
                result[carryIndex] += sum / 10; // get carry digit and set the value
            }
        }
        // convert result array into a string
        StringBuilder product = new StringBuilder();
        for (int num : result) {
            // skip leading zero
            if (product.length() != 0 || num != 0) {
                product.append(num);
            }
        }
        // return product string
        return product.toString();
    }
}
