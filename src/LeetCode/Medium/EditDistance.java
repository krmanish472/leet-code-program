package LeetCode.Medium;

/*
* Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
* You have the following three operations permitted on a word:
    Insert a character
    Delete a character
    Replace a character

* Example 1:
    Input: word1 = "horse", word2 = "ros"
    Output: 3
    Explanation:
    horse -> rorse (replace 'h' with 'r')
    rorse -> rose (remove 'r')
    rose -> ros (remove 'e')

* Example 2:
    Input: word1 = "intention", word2 = "execution"
    Output: 5
    Explanation:
    intention -> inention (remove 't')
    inention -> enention (replace 'i' with 'e')
    enention -> exention (replace 'n' with 'x')
    exention -> exection (replace 'n' with 'c')
    exection -> execution (insert 'u')
* */
public class EditDistance {
    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        int res = minDistance(word1, word2);
        System.out.println(res);
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // DP Array
        int[][] costDP = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            costDP[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            costDP[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // for same characters => Copy from top left (diagonal)
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    costDP[i][j] = costDP[i - 1][j - 1];
                } else {
                    // Get minimum of all 3 neighbors
                    int top = costDP[i - 1][j];
                    int left = costDP[i][j - 1];
                    int topLeft = costDP[i - 1][j - 1];
                    costDP[i][j] = Math.min(topLeft, Math.min(top, left)) + 1;
                }
            }
        }
        return costDP[m][n];
    }
}
