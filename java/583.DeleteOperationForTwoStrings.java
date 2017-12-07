// Problem 583 Delete Operation for two Strings

// Method 1: dp array is used to store characters that are need to be deleted.
class Solution {
    public int minDistance(String word1, String word2) {
        int [][]dp = new int[word1.length() + 1][word2.length() + 1];
        // If word1 is null or word2 is null, fill the array.
        for (int i = 0; i <= word1.length(); i++)
            dp[i][0] = i;
        for (int j = 0; j <= word2.length(); j++)
            dp[0][j] = j;
        // Fill the number of deleting numbers.
        for(int i = 1; i <= word1.length(); i++) {
            for(int j = 1; j <= word2.length(); j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1] + 2, dp[i - 1][j] + 1), dp[i][j - 1] + 1);
                            
            }
        }
        return dp[word1.length()][word2.length()];
    }
}

// Method 2: dp array is used to store characters that are same.
class Solution {
    public int minDistance(String word1, String word2) {
        int [][]dp = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 1; i <= word1.length(); i++) {
            for(int j = 1; j <= word2.length(); j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);               
            }
        }
        return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
    }
}