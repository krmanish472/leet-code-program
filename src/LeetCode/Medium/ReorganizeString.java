package LeetCode.Medium;

/*
* Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
* Return any possible rearrangement of s or return "" if not possible.

* Example 1:
    Input: s = "aab"
    Output: "aba"

* Example 2:
    Input: s = "aaab"
    Output: ""
* */
public class ReorganizeString {
    public static void main(String[] args) {
        String s = "xxxrwpp";

        String res = reorganizeString(s);
        System.out.println(res);
    }

    public static String reorganizeString(String s) {
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }

        int maxCount = 0, letter = 0; // 3, 23

        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] > maxCount) {
                maxCount = charCount[i]; // p->2, r->1, w->1 x->3
                letter = i; // letter = 15, 23
            }
        }

        if (maxCount > (s.length() + 1) / 2) {
            return "";
        }

        // array to hold result string
        char[] res = new char[s.length()];
        int idx = 0;

        // fill all the even places with majority character
        while (charCount[letter] != 0) { // count is => 3 for x
            res[idx] = (char) (letter + 'a');
            idx = idx + 2;
            charCount[letter]--;
        }

        // fill the remaining characters at remaining positions
        for (int i = 0; i < charCount.length; i++) {
            while (charCount[i] > 0) { // count is => 2 for p, 1 for r, 1 for w
                if (idx >= res.length) {
                    idx = 1; // make index 1 to offset even position
                }
                res[idx] = (char) (i + 'a');
                idx = idx + 2;
                charCount[i]--;
            }
        }

        return String.valueOf(res);
    }
}
