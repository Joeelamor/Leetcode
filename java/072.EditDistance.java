// Problem 72 Edit Distance

class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.equals(word2))
            return 0;
        if (word1.length() == 0 || word2.length() == 0)
            return Math.abs(word1.length() - word2.length());
        int [][]dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i- 1][j]) + 1;
            }
        }
        return dp[word1.length()][word2.length()];
    }
}