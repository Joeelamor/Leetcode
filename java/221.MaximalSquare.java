// Problem 221 Maximal Square

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, res = 0;
        // use dp[][] to record current corner largest side length of square.
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1')
                    // current corner length is sum of 1 and the minimal number of its left, up and left-up corner length.
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                res = Math.max(res, dp[i][j]);
            }
        }
        return res * res;
    }
}