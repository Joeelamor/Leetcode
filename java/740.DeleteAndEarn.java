// Problem 740 Delete And Earn

class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        int[][] dp = new int[10001][2];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 1; i < 10001; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + count[i] * i;
        }
        return Math.max(dp[10000][0], dp[10000][1]);
    }
}

