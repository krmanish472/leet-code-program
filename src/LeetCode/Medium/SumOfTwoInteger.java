package LeetCode.Medium;

/*
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 * */

public class SumOfTwoInteger {
    public static void main(String[] args) {
        System.out.println(getSum(3, 5));
    }

    public static int getSum(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            int carry = (a & b) << 1;
            a = temp;
            b = carry;
        }
        return a;
    }
}
