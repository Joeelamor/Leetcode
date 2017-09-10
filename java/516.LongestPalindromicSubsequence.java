// Problem 516 Longest Palindromic Subsequence

// Method 1: brute force: Time Limit Exceeded 
class Solution {
    public int longestPalindromeSubseq(String s) {
        return longestPalindromeSubseq(0, s.length() - 1, s);
    }
    public int longestPalindromeSubseq(int left, int right, String s) {
        if(left == right)
            return 1;
        if(left > right)
            return 0;
        return s.charAt(left) == s.charAt(right)? 2 + longestPalindromeSubseq(left + 1, right - 1, s):
            Math.max(longestPalindromeSubseq(left + 1, right, s), longestPalindromeSubseq(left, right - 1, s));
    }
}

// Method 2: brute force to DP
// I get an idea, in DP, array index means the point, don't know if it's right. Just go ahead.
class Solution {
    public int longestPalindromeSubseq(String s) {
        int [][]dp = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            for(int j = i - 1; j >= 0; j--) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i - 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[s.length() - 1][0];
    }
}

