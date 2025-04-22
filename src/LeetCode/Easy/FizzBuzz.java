package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer n, return a string array answer (1-indexed) where:
answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
answer[i] == "Fizz" if i is divisible by 3.
answer[i] == "Buzz" if i is divisible by 5.
answer[i] == i (as a string) if none of the above conditions are true.
* */

public class FizzBuzz {
    public static void main(String[] args) {
        List<String> li = new FizzBuzz().fizzBuzz(15);
        System.out.println(li);
    }

    public List<String> fizzBuzz(int n) {
        List<String> li = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                li.add("FizzBuzz");
            } else if (i % 3 == 0) {
                li.add("Fizz");
            } else if (i % 5 == 0) {
                li.add("Buzz");
            } else {
                li.add(String.valueOf(i));
            }
        }
        return li;
    }
}
