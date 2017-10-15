// Problem 300 Longest Increasing Subsequence

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int []dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i])
                        dp[i] = dp[j] + 1;
                }
            }
        }
        int max = 0;
        for (int n : dp) {
            max = Math.max(max, n);
        }
        return max;
    }
}