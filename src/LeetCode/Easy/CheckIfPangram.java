package LeetCode.Easy;

/*
* A pangram is a sentence where every letter of the English alphabet appears at least once.
* Given a string sentence containing only lowercase English letters,
* return true if sentence is a pangram, or false otherwise.

* Example 1:
    Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
    Output: true
    Explanation: sentence contains at least one of every letter of the English alphabet.

* Example 2:
    Input: sentence = "leetcode"
    Output: false
* */

import java.util.HashSet;
import java.util.Set;

public class CheckIfPangram {
    public static void main(String[] args) {
        String str = "thequickbrownfoxjumpsoverthelazydog";

        if (checkIfPangram_hashSet(str)) {
            System.out.println("Pangram");
        } else {
            System.out.println("Not Pangram");
        }
    }

    // basic way
    public static boolean checkIfPangram(String sentence) {
        for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            // check if sentence has that char
            // using index
            if (sentence.indexOf(alphabet) == -1) {
                return false;
            }
            // OR ... using contains
            /*if (!sentence.contains(String.valueOf(alphabet))) {
                return false;
            }*/
        }
        return true;
    }

    public static boolean checkIfPangram_hashSet(String sentence) {
        Set<Character> characterSet = new HashSet<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            characterSet.add(ch);
        }

        for (int i = 0; i < sentence.length(); i++) {
            characterSet.remove(sentence.charAt(i));
            // if there is no element left in hashset means all the alphabets are covered
            if (characterSet.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
