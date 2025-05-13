package LeetCode.Easy;

/*
* You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have.
* Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
* Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:
    Input: jewels = "aA", stones = "aAAbbbb"
    Output: 3

* Example 2:
    Input: jewels = "z", stones = "ZZ"
    Output: 0
* */

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public static void main(String[] args) {
        String jewels = "aA", stones = "aAAbbbb";

        int jewelsCount = numJewelsInStones(jewels, stones);
        System.out.println(jewelsCount);
    }

    public static int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }

        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i))) {
                count++;
            }
        }

        return count;
    }
}
