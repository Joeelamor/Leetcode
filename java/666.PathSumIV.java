// Problem 666 Path Sum IV

// Use DP to store the current sum along the path
class Solution {
    public int pathSum(int[] nums) {
        int[][] dp = new int[5][8];
        for (int num : nums) {
            int i = num / 100; // i is 1 based index;
            int j = (num % 100) / 10 - 1; // j is 0 based index
            int k = num % 10;
            dp[i][j] = dp[i - 1][j / 2] + k; // store the current sum along the path
        }
        int sum = 0;
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 4 || dp[i][j] != 0 && dp[i + 1][j * 2] == 0 && dp[i + 1][j * 2 + 1] == 0) { // if it's leaf
                    sum += dp[i][j];
                }
            }
        }
        return sum;
    }
}